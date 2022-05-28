package ru.niatomi.repository;

import org.springframework.data.repository.CrudRepository;
import ru.niatomi.model.domain.PasswordEntity;

/**
 * @author niatomi
 */
public interface PasswordRepository extends CrudRepository<PasswordEntity, Long> {
    PasswordEntity findByValueContaining(String password);
}
