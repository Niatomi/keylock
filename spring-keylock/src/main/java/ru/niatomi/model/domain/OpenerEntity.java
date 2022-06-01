package ru.niatomi.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author niatomi
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "opener_table")
@Entity
public class OpenerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "opener", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("opener")
    @ToString.Exclude
    List<PasswordEntity> passwords;

    private String firstName;
    private String secondName;
    private String thirdName;

}
