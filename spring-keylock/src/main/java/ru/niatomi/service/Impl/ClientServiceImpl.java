package ru.niatomi.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.niatomi.exceptions.excep.OpenerNotFoundException;
import ru.niatomi.model.domain.OpenerEntity;
import ru.niatomi.exceptions.OpenerAlreadyExistsException;
import ru.niatomi.repository.OpenerRepository;
import ru.niatomi.repository.PasswordRepository;
import ru.niatomi.service.ClientService;

/**
 * @author niatomi
 */
@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    public final OpenerRepository openerRepository;
    public final PasswordRepository passwordRepository;

    public OpenerEntity create(OpenerEntity openerEntity) {
        if (openerRepository.findById(openerEntity.getId()).isPresent()) {
            throw new OpenerAlreadyExistsException();
        }
        return openerRepository.save(openerEntity);

    }

    @Override
    public String delete(Long id) {
        if (!openerRepository.findById(id).isPresent()) {
            throw new OpenerNotFoundException();
        }
        openerRepository.deleteById(id);
        return "User with id=" + id + "deleted";
    }
}