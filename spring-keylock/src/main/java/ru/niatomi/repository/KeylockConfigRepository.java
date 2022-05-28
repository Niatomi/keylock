package ru.niatomi.repository;

import org.springframework.data.repository.CrudRepository;
import ru.niatomi.entity.KeylockConfig;

/**
 * @author niatomi
 */
public interface KeylockConfigRepository extends CrudRepository<KeylockConfig, Integer> {
}
