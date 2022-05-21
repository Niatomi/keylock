package ru.niatomi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author niatomi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActionsHistoryDto {

    private Long openerId;
    private String description;

}
