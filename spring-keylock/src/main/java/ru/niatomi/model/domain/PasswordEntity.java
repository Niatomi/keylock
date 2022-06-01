package ru.niatomi.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

/**
 * @author niatomi
 */
@Getter
@Setter
@ToString
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "opener_id")
    @JsonIgnoreProperties("password")
    private OpenerEntity opener;

}
