package ru.niatomi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import ru.niatomi.model.domain.OpenerEntity;
import ru.niatomi.model.dto.OpenerDto;
import ru.niatomi.model.dto.OpenerDtoWithoutId;

/**
 * @author niatomi
 */
@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface OpenerMapper {

    @Mappings({
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "secondName", target = "secondName"),
            @Mapping(source = "thirdName", target = "thirdName")
    })
    OpenerEntity map(OpenerDtoWithoutId opener);
}
