package ru.niatomi.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.niatomi.model.domain.OpenerEntity;
import ru.niatomi.exceptions.OpenerAlreadyExistsException;
import ru.niatomi.repository.OpenerRepository;
import ru.niatomi.repository.PasswordRepository;

/**
 * @author niatomi
 */
@Service
@AllArgsConstructor
public class ClientServiceImpl {

    public final OpenerRepository openerRepository;
    public final PasswordRepository passwordRepository;

    public OpenerEntity create(OpenerEntity openerEntity) throws OpenerAlreadyExistsException {
        return openerRepository.save(openerEntity);
    }
}


//    public UserEntity registration(UserEntity user) throws UserAlreadyExistsException {
//        if (userRepo.findByUsername(user.getUsername()) != null) {
//            throw new UserAlreadyExistsException(user);
//        }
//        return userRepo.save(user);
//    }
