package ru.niatomi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import ru.niatomi.model.domain.OpenerEntity;

import java.util.List;
import java.util.Optional;

/**
 * @author niatomi
 */
public interface OpenerRepository extends CrudRepository<OpenerEntity, Long> {

    Page<OpenerEntity> findByPasswordsIsNotNull(Pageable page);

    Page<OpenerEntity> findAll(Pageable page);

}
