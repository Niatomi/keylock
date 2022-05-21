package ru.niatomi.repository;

import org.springframework.data.repository.CrudRepository;
import ru.niatomi.model.domain.OpenerEntity;

/**
 * @author niatomi
 */
public interface OpenerRepository extends CrudRepository<OpenerEntity, Long> {
}
