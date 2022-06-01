package ru.niatomi.service;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import ru.niatomi.model.domain.OpenerEntity;
import ru.niatomi.model.dto.OpenerDtoWithoutId;
import ru.niatomi.model.dto.PasswordDtoValueAndType;
import ru.niatomi.model.enumarations.PasswordType;

import java.util.List;

/**
 * @author niatomi
 */
public interface ClientService {

    String signUpOpener(OpenerDtoWithoutId opener);

    String updateOpener(OpenerEntity opener);

    List<OpenerEntity> getAllOpeners();

    OpenerEntity getOpener(Long id);

    Page<OpenerEntity> getOpenersWithPasswordInPages(Integer page, Integer size);

    Page<OpenerEntity> getAllOpenersInPages(Integer page, Integer size);

    String deleteOpener(Long openerId);

    String deleteOpenerPasswords(Long openerId);

    String openKeylock();

    String blockKeylock();

    String addPassword(Long id, PasswordType passwordType, String passwordValue);

}
