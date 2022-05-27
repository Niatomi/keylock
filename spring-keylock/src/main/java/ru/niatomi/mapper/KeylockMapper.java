package ru.niatomi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import ru.niatomi.dto.KeylockConfigDto;
import ru.niatomi.entity.KeylockConfig;

/**
 * @author niatomi
 */

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)

public interface KeylockMapper {

    @Mappings({
            @Mapping(source = "re_read_password", target = "re_read_password"),
            @Mapping(source = "lock", target = "lock"),
            @Mapping(source = "sound", target = "sound"),
            @Mapping(source = "showPassword", target = "showPassword")
    })
    KeylockConfigDto map(KeylockConfig keylockConfig);
}
