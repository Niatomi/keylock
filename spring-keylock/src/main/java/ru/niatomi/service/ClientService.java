package ru.niatomi.service;

import org.springframework.stereotype.Service;
import ru.niatomi.model.domain.OpenerEntity;

/**
 * @author niatomi
 */
@Service
public interface ClientService {
    OpenerEntity create(OpenerEntity openerEntity);
    String delete(Long id);
}
