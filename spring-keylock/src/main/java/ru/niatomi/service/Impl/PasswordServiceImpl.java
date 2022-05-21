package ru.niatomi.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.niatomi.model.domain.OpenerEntity;
import ru.niatomi.model.domain.PasswordEntity;
import ru.niatomi.model.dto.PasswordDto;
import ru.niatomi.repository.OpenerRepository;
import ru.niatomi.repository.PasswordRepository;

/**
 * @author niatomi
 */
@Service
@AllArgsConstructor
public class PasswordServiceImpl {

    private final PasswordRepository passwordRepository;
    private final OpenerRepository openerRepository;

    public PasswordDto createPassword(PasswordEntity passwordEntity,
                                      Long openerId) {
        OpenerEntity opener = openerRepository.findById(openerId).get();
        passwordEntity.setOpener(opener);
        passwordRepository.save(passwordEntity);
        return new PasswordDto(passwordEntity.getId(), passwordEntity.getType(), passwordEntity.getValue());
    }
}

