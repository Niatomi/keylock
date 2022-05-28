#include <ArduinoJson.h>
#include <ESP8266WiFi.h>              
#include <WiFiClient.h>
#include <TimeLib.h>
#include <Key.h>
#include <Keypad.h>

#define HTTP 5
#define HARDWARE_INDICATION 4

#define LED_BUILTIN 2
volatile unsigned long globalTimeBufferMillis = 0;

// WiFi, HTTP
// const char* ssid = "Ttk 139";
// const char* password = "631790355";

const char* ssid = "Niatomi";
const char* password = "1234567890";

WiFiClient client;
IPAddress local(192, 168, 137, 1);
uint16_t port = 8080;

DynamicJsonDocument doc(2048);
unsigned long openerId; 

String enteringPassword = "";

void setup() {

    WiFi.begin(ssid, password);

    pinMode(HTTP, OUTPUT);
    pinMode(HARDWARE_INDICATION, OUTPUT);
    digitalWrite(HTTP, LOW);
    digitalWrite(HARDWARE_INDICATION, LOW);
  
    while (WiFi.status() != WL_CONNECTED)
        delay(500);

    Serial.begin(9600);
    Serial.setTimeout(5);
}

void getPasswords() {
    if (client.connect(local, port)) {
        digitalWrite(HTTP, HIGH);
        // Send HTTP request
        client.println("GET /esp HTTP/1.0\r\n");
        client.println("Host: " + local.toString() + ":8080");

        // Skip HTTP headers
        char endOfHeaders[] = "\r\n\r\n";
        if (!client.find(endOfHeaders)) {                      
            // Serial.println("Invalid response");
            return;
        }

        deserializeJson(doc, client);
        client.stop();
        digitalWrite(HTTP, LOW);
    }
}

boolean checkPassword(String enteringPassword, String enteringType) {
    getPasswords();

    for (JsonObject item : doc.as<JsonArray>()) {
        openerId = item["openerId"]; 
        String type = item["type"]; 
        String value = item["value"]; 

        if (type == enteringType) {
            if (value ==  enteringPassword) {
                return true;
            }
        }
    }

    openerId = 1;
    return false;
}

void loop() {
    hardwareListener();
}


void hardwareListener() {
    if (Serial.available()) {

        String expression = Serial.readStringUntil('-');
        String method = expression.substring(0, expression.indexOf(':'));
        expression = expression.substring(expression.indexOf(':') + 1, expression.length());

        if (method == "check") {

            String type = expression.substring(0, expression.indexOf(':'));
            expression = expression.substring(expression.indexOf(':') + 1, expression.length());
            

            enteringPassword = expression.substring(0, expression.length());
            if (type == "keypad") {
                if (checkPassword(enteringPassword, type)) {
                    digitalWrite(HARDWARE_INDICATION, HIGH);
                    
                    Serial.flush();
                    Serial.write("open*");
                    Serial.flush();

                    sendAction("Open");
                    digitalWrite(HARDWARE_INDICATION, LOW);
                } else {
                    digitalWrite(HARDWARE_INDICATION, HIGH);
                    Serial.flush();
                    Serial.write("wrong*");
                    Serial.flush();
                    sendAction("WrongKeyAccess");
                    digitalWrite(HARDWARE_INDICATION, LOW);
                }
            }

        }

        if (method == "hall") {
                openerId = 1;
                expression = expression.substring(0, expression.indexOf('@'));
                sendAction(expression);
        }

        if (method == "getConfig") {
            getServerConfig();
        }

        if (method.indexOf("lock") != -1) {
            sendLockConfigAction();
        }

        if (method.indexOf("config") != -1) {
            sendSettingsConfigAction();
        }

        if (method == "getConfig") {
            getServerConfig();
        }

        Serial.flush();
    }
}

void sendSettingsConfigAction() {
    digitalWrite(HTTP, HIGH);

    if (client.connect(local, port)) {
        client.println("POST /esp/setConfig HTTP/1.1");
        client.println("Host: " + local.toString() + ":8080");
        client.println();
        improvedDelay(200);
        client.stop();

    }

    digitalWrite(HTTP, LOW);

}

void sendLockConfigAction() {
    digitalWrite(HTTP, HIGH);

    if (client.connect(local, port)) {
        client.println("POST /esp/setLock HTTP/1.1");
        client.println("Host: " + local.toString() + ":8080");
        client.println();
        improvedDelay(200);
        client.stop();

    }

    digitalWrite(HTTP, LOW);
} 

boolean re_read_password;
char sendingConfig[12]; 
void getServerConfig() {
    String arduinoConfiguration = "config:";

    DynamicJsonDocument config(128);    
    if (client.connect(local, port)) {
        digitalWrite(HTTP, HIGH);
        // Send HTTP request
        client.println("GET /esp/getConfig HTTP/1.0\r\n");
        client.println("Host: " + local.toString() + ":8080");

        // Skip HTTP headers
        char endOfHeaders[] = "\r\n\r\n";
        if (!client.find(endOfHeaders)) {                      
            // Serial.println("Invalid response");
            return;
        }

        deserializeJson(config, client);
        client.stop();
        digitalWrite(HTTP, LOW);
    }

    boolean sound = config["sound"].as<boolean>();
    boolean showPassword = config["showPassword"].as<boolean>();
    re_read_password = config["re_read_password"].as<boolean>();
    boolean lock = config["lock"].as<boolean>();

    arduinoConfiguration.concat(sound);
    arduinoConfiguration.concat(showPassword);
    arduinoConfiguration.concat(lock);
    arduinoConfiguration.concat("-");

    for (int i = 0; i < arduinoConfiguration.length(); i++) {
        sendingConfig[i] = arduinoConfiguration.charAt(i);
    }
    digitalWrite(HARDWARE_INDICATION, HIGH);
    Serial.write(sendingConfig);
    Serial.flush();
    digitalWrite(HARDWARE_INDICATION, LOW);
} 

void sendAction(String action) {

    if (client.connect(local, port)) {
        digitalWrite(HTTP, HIGH);
        StaticJsonDocument<250> docOut;

        docOut["openerId"] = openerId;
        docOut["description"] = action;

        // Write response headers
        client.println("POST /esp HTTP/1.1");
        client.println("Host: " + local.toString() + ":8080");
        client.println("Content-Type: application/json");
        client.println("Connection: close");
        client.print("Content-Length: ");
        client.println(measureJsonPretty(docOut));
        client.println();

        serializeJsonPretty(docOut, client);

        client.stop();
        digitalWrite(HTTP, LOW);
        
    }

}



void sendHttpAction() {
    StaticJsonDocument<48> docOut;

}

void improvedDelay(unsigned int waitTime) {
    globalTimeBufferMillis = millis();
    boolean cooldownState = true;

    while (cooldownState) {
        if (millis() - globalTimeBufferMillis > waitTime) 
            cooldownState = false;
    }
}