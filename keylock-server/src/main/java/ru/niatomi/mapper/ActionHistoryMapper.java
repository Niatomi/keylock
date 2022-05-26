package ru.niatomi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import ru.niatomi.mapper.customMappers.CustomHistoryMapper;
import ru.niatomi.model.domain.ActionsHistoryEntity;
import ru.niatomi.model.dto.ActionHistoryDto;
import ru.niatomi.model.dto.ActionHistoryWithTimeDto;

import java.time.LocalDate;

/**
 * @author niatomi
 */
@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = CustomHistoryMapper.class
)
public interface ActionHistoryMapper {

    LocalDate DATE = LocalDate.now();

    @Mappings(
        @Mapping(target = "actionDate", expression = "java(DATE)")
//        @Mapping(source = ".", target = "actionType", qualifiedByName = "stringToEnum")
    )
    ActionsHistoryEntity mapInRealTime(ActionHistoryDto actionHistoryDto);

    ActionsHistoryEntity mapOffline(ActionHistoryWithTimeDto actionHistoryWithTimeDto);


}

