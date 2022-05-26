package ru.niatomi.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.niatomi.model.domain.enumerations.ActionType;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author niatomi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "actions_history_table")
public class ActionsHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "opener_id")
    private OpenerEntity opener;

    @Enumerated(EnumType.STRING)
    private ActionType actionType;

    private LocalDate actionDate;

}
