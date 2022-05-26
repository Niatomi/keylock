package ru.niatomi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.niatomi.model.domain.PasswordEntity;
import ru.niatomi.model.dto.PasswordDto;

import java.util.List;

/**
 * @author niatomi
 */
public interface PasswordRepository extends CrudRepository<PasswordEntity, Long> {
    List<PasswordEntity> findByOpenerId(Long id);
}
