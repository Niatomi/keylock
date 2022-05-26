package ru.niatomi.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import ru.niatomi.model.validation.DateLessThan;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

/**
 * @author niatomi
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "opener_table")
@DateLessThan.List({
        @DateLessThan(
                time1 = "signUpDate",
                time2 = "deleteDate",
                message = "Дата удаления не может быть меньше даты регистрации"
        )
})
public class OpenerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "opener")
    List<PasswordEntity> passwords;

    @Pattern(regexp = "[а-яёА-ЯЁ-]+", message = "Должны быть только русские символы")
    private String firstName;

    @Pattern(regexp = "[а-яёА-ЯЁ-]+", message = "Должны быть только русские символы")
    private String secondName;

    @Pattern(regexp = "([а-яёА-ЯЁ-]+)?", message = "Должны быть только русские символы, либо отчества вовсе может не быть")
    private String thirdName;

    @CreatedDate
    private LocalDate signUpDate;

    private LocalDate deleteDate;


}
