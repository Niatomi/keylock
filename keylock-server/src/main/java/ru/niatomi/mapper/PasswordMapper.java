package ru.niatomi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import ru.niatomi.mapper.customMappers.CustomOpenerMapper;
import ru.niatomi.model.domain.PasswordEntity;
import ru.niatomi.model.dto.PasswordDto;

import java.util.List;

/**
 * @author niatomi
 */
@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface PasswordMapper {

    @Mappings({
        @Mapping(target = "type", expression = "java(passwordEntity.getType().toString())"),
        @Mapping(target = "value", expression = "java(passwordEntity.getValue().toString())")
    })
    PasswordDto toDto(PasswordEntity passwordEntity);
}
