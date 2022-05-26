package ru.niatomi.mapper.customMappers;

import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import ru.niatomi.model.domain.enumerations.ActionType;

/**
 * @author niatomi
 */
@Named("CustomHistoryMapper")
@Component
public class CustomHistoryMapper {

    @Named("stringToEnum")
    public ActionType stringToEnum(String actionType) {
        return Enum.valueOf(ActionType.class, actionType.toUpperCase());
    }

}
