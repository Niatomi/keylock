package ru.niatomi.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.niatomi.dto.KeylockConfigDto;
import ru.niatomi.entity.ActionsHistoryEntity;
import ru.niatomi.entity.KeylockConfig;
import ru.niatomi.entity.OpenerEntity;
import ru.niatomi.entity.PasswordEntity;
import ru.niatomi.mapper.KeylockMapper;
import ru.niatomi.model.ActionsHistory;
import ru.niatomi.model.Password;
import ru.niatomi.model.PasswordWithOpenerId;
import ru.niatomi.repository.ActionsHistoryRepository;
import ru.niatomi.repository.KeylockConfigRepository;
import ru.niatomi.repository.OpenerRepository;
import ru.niatomi.repository.PasswordRepository;
import sun.util.resources.LocaleData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.Optional;

/**
 * @author niatomi
 */
@Service
@AllArgsConstructor
public class ESPService {

    private final PasswordRepository passwordRepository;
    private final ActionsHistoryRepository actionsHistoryRepository;
    private final OpenerRepository openerRepository;
    private final KeylockConfigRepository keylockConfigRepository;
    private final KeylockMapper keylockMapper;

    public List<PasswordWithOpenerId> getPasswords() {
        List<PasswordWithOpenerId> passwordList = new ArrayList<PasswordWithOpenerId>();
        passwordRepository.findAll().forEach(p -> passwordList.add(new PasswordWithOpenerId(p.getOpener().getId(), p.getType().toLowerCase(), p.getValue())));
        return passwordList;
    }

    public void addAction(ActionsHistory actionsHistory) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        actionsHistoryRepository.save(
                new ActionsHistoryEntity(
                        actionsHistoryRepository.count() + 1,
                        openerRepository.findById(actionsHistory.getOpenerId()).get(),

                        actionsHistory.getDescription(),

                        LocalDateTime.now()));
    }

    public KeylockConfigDto getConfig() {
        return keylockMapper.map(keylockConfigRepository.findById(1).get());
    }

    public void lockConfig() {
        KeylockConfig keylockConfig = keylockConfigRepository.findById(1).get();
        keylockConfig.setLock(true);
        keylockConfigRepository.save(keylockConfig);
    }

}
