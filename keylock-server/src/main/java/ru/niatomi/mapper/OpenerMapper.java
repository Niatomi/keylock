package ru.niatomi.mapper;

import org.mapstruct.*;
import ru.niatomi.mapper.customMappers.CustomHistoryMapper;
import ru.niatomi.mapper.customMappers.CustomOpenerMapper;
import ru.niatomi.model.domain.OpenerEntity;
import ru.niatomi.model.dto.OpenerDto;

/**
 * @author niatomi
 */
@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = CustomOpenerMapper.class
)
public interface OpenerMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "secondName", target = "secondName"),
            @Mapping(source = "thirdName", target = "thirdName"),
            @Mapping(source = "signUpDate", target = "signUpDate"),
            @Mapping(source = "deleteDate", target = "deleteDate"),
    })
    OpenerDto map(OpenerEntity openerEntity, @MappingTarget OpenerDto openerDto);

}
