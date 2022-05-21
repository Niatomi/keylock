package ru.niatomi.repository;

import org.springframework.data.repository.CrudRepository;
import ru.niatomi.model.domain.ActionsHistoryEntity;

/**
 * @author niatomi
 */
public interface ActionsHistoryRepository extends CrudRepository<ActionsHistoryEntity, Long> {
}
