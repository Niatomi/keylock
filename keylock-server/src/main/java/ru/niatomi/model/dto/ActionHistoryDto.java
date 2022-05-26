package ru.niatomi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author niatomi
 */
@AllArgsConstructor
@Data
public class ActionHistoryDto {
    private Long openerId;
    private String actionType;
}
