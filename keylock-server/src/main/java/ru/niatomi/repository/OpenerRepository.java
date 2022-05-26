package ru.niatomi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.niatomi.model.domain.OpenerEntity;

import java.util.Optional;

/**
 * @author niatomi
 */
@Repository
public interface OpenerRepository extends PagingAndSortingRepository<OpenerEntity, Long> {
    Optional<OpenerEntity> findById(Long id);
    Page<OpenerEntity> findAll(Pageable page);
}
