package ru.niatomi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author niatomi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "configuration_table")
public class KeylockConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private boolean sound;
    private boolean showPassword;
    private boolean lock;
}
