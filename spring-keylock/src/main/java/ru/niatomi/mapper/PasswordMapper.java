package ru.niatomi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import ru.niatomi.model.domain.PasswordEntity;
import ru.niatomi.model.dto.PasswordDtoValueAndType;

/**
 * @author niatomi
 */
@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface PasswordMapper {

    @Mappings({
            @Mapping(source = "value", target = "value"),
            @Mapping(source = "type", target = "type")
    })
    PasswordEntity map(PasswordDtoValueAndType dto);
}
