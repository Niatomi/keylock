package ru.niatomi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.niatomi.model.domain.ActionsHistoryEntity;

/**
 * @author niatomi
 */
public interface ActionsHistoryRepository extends PagingAndSortingRepository<ActionsHistoryEntity, Long> {
    Page<ActionsHistoryEntity> findAll(Pageable page);
}
