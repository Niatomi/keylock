package ru.niatomi.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.niatomi.exceptions.excep.InvalidFirstUserException;
import ru.niatomi.exceptions.excep.OpenerNotFoundException;
import ru.niatomi.exceptions.excep.PasswordIsNotUniqueException;
import ru.niatomi.mapper.OpenerMapper;
import ru.niatomi.mapper.PasswordMapper;
import ru.niatomi.model.domain.KeylockConfig;
import ru.niatomi.model.domain.OpenerEntity;
import ru.niatomi.model.domain.PasswordEntity;
import ru.niatomi.model.dto.OpenerDtoWithoutId;
import ru.niatomi.model.enumarations.PasswordType;
import ru.niatomi.repository.KeylockConfigRepository;
import ru.niatomi.repository.OpenerRepository;
import ru.niatomi.repository.PasswordRepository;
import ru.niatomi.service.ClientService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @author niatomi
 */
@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final OpenerRepository openerRepository;
    private final KeylockConfigRepository keylockConfigRepository;
    private final PasswordRepository passwordRepository;

    private final OpenerMapper openerMapper;
    private final PasswordMapper passwordMapper;

    @Override
    public String signUpOpener(OpenerDtoWithoutId opener) {
        OpenerEntity map = openerMapper.map(opener);
        map.setId(openerRepository.count() + 1);
        openerRepository.save(map);
        return "Opener saved";
    }

    @Override
    public String updateOpener(OpenerEntity opener) {
        if (opener.getId() == 1L) {
            throw new InvalidFirstUserException();
        }

        openerRepository.save(opener);
        return "Opener updated";
    }

    @Override
    public List<OpenerEntity> getAllOpeners() {
        List<OpenerEntity> all = new LinkedList<>();
        openerRepository.findAll().forEach(all::add);
        return all;
    }

    @Override
    public OpenerEntity getOpener(Long id) {
        Optional<OpenerEntity> byId = openerRepository.findById(id);

        if (!byId.isPresent()) {
            throw new OpenerNotFoundException();
        }

        return byId.get();
    }

    @Override
    public Page<OpenerEntity> getOpenersWithPasswordInPages(Integer page, Integer size) {
        Sort sort = Sort.by(Sort.Order.asc("id"));
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<OpenerEntity> openersPage = openerRepository.findByPasswordsIsNotNull(pageRequest);
        return openersPage;
    }

    @Override
    public Page<OpenerEntity> getAllOpenersInPages(Integer page, Integer size) {
        Sort sort = Sort.by(Sort.Order.asc("id"));
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<OpenerEntity> openersPage = openerRepository.findAll(pageRequest);
        return openersPage;
    }

    @Override
    public String deleteOpener(Long openerId) {
        if (openerId == 1L) {
            throw new InvalidFirstUserException();
        }

        if (!openerRepository.findById(openerId).isPresent()) {
            throw new OpenerNotFoundException();
        }
        openerRepository.deleteById(openerId);
        return "Opener with id=" + openerId + " deleted...";
    }

    @Override
    @Transactional
    public String deleteOpenerPasswords(Long openerId) {
        if (openerId == 1L) {
            throw new InvalidFirstUserException();
        }

        if (!openerRepository.findById(openerId).isPresent()) {
            throw new OpenerNotFoundException();
        }
        OpenerEntity opener = openerRepository.findById(openerId).get();
        opener.setPasswords(new ArrayList<>());
        openerRepository.save(opener);
        passwordRepository.deleteByOpenerIdEquals(openerId);
        return "Opener with id=" + openerId + " now doesn't have any passwords";
    }

    @Override
    public String openKeylock() {
        KeylockConfig keylockConfig = keylockConfigRepository.findById(1).get();
        keylockConfig.setLock(false);
        keylockConfigRepository.save(keylockConfig);
        return "Keylock unlocked";
    }

    @Override
    public String blockKeylock() {
        KeylockConfig keylockConfig = keylockConfigRepository.findById(1).get();
        keylockConfig.setLock(true);
        keylockConfigRepository.save(keylockConfig);
        return "Keylock blocked";
    }

    @Override
    public String addPassword(Long id,
                              PasswordType passwordType,
                              String passwordValue) {
        if (id == 1L) {
            throw new InvalidFirstUserException();
        }

        if (!openerRepository.findById(id).isPresent()) {
            throw new OpenerNotFoundException();
        }
        Optional<PasswordEntity> byValueContaining = passwordRepository.findByValueEquals(passwordValue);
        if (byValueContaining.isPresent()) {
            throw new PasswordIsNotUniqueException();
        }

        OpenerEntity opener = openerRepository.findById(id).get();
        PasswordEntity map = new PasswordEntity();

        map.setValue(passwordValue);
        map.setType(passwordType.toString().toUpperCase());
        map.setOpener(opener);

        List<PasswordEntity> passwordEntityList = new ArrayList<>();
        if (opener.getPasswords().isEmpty()) {
            passwordEntityList.add(map);
        } else {
            passwordEntityList.addAll(opener.getPasswords());
            passwordEntityList.add(map);
        }
        opener.setPasswords(passwordEntityList);
        openerRepository.save(opener);

        return "Add password for opener with id=" + id;
    }
}
