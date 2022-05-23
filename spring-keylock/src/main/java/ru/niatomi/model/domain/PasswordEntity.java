package ru.niatomi.model.domain;

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
@Table(name = "password_table")
public class PasswordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    // TODO: transfer this check in Liquibase
    @Column(unique = true)
    private String value;

    @ManyToOne
    @JoinColumn(name = "opener_id")
    private OpenerEntity opener;

}
