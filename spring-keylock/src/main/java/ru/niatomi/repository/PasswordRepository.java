package ru.niatomi.repository;

import org.springframework.data.repository.CrudRepository;
import ru.niatomi.model.domain.PasswordEntity;

import java.util.Optional;

/**
 * @author niatomi
 */
public interface PasswordRepository extends CrudRepository<PasswordEntity, Long> {

    Optional<PasswordEntity> findByValueEquals(String value);

    void deleteByOpenerIdEquals(Long id);

}
