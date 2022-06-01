package ru.niatomi.model.domain;

import lombok.*;

import javax.persistence.*;

/**
 * @author niatomi
 */
@Setter
@Getter
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
