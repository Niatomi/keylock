package ru.niatomi.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.niatomi.exceptions.exc.OpenerNotFoundException;
import ru.niatomi.model.domain.OpenerEntity;
import ru.niatomi.model.dto.OpenerDto;
import ru.niatomi.model.dto.PasswordDto;
import ru.niatomi.repository.OpenerRepository;
import ru.niatomi.repository.PasswordRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @author niatomi
 */
@Service
@AllArgsConstructor
public class MainUserService {

    private final OpenerRepository repository;
    private final PasswordRepository passwordRepository;

    public String signUp(OpenerEntity opener) {
        repository.save(opener);
        return "Opener saved";
    }

    public String update(OpenerEntity opener) {
        if (!repository.findById(opener.getId()).isPresent())
            throw new OpenerNotFoundException();
        return "Opener updated";
    }

    public List<OpenerEntity> getAllOpeners() {
        List<OpenerEntity> listOfOpeners = new LinkedList<OpenerEntity>();
        repository.findAll().forEach(e -> listOfOpeners.add(e));
        return listOfOpeners;
    }

    public Page<OpenerEntity> getByOpenersByPages(Pageable page) {
        return repository.findAll(page);
    }

    public OpenerDto getOpener(Long id) {
        Optional<OpenerEntity> opener = repository.findById(id);
        if (!opener.isPresent())
            throw new OpenerNotFoundException();

        OpenerEntity opener1 = opener.get();



        List<PasswordDto> passwordDtos = new LinkedList<>();
        passwordRepository.findByOpenerId(opener1.getId()).forEach(passwordEntity -> passwordDtos.add(new PasswordDto(passwordEntity.getType().toString(), passwordEntity.getValue())));


//        passwordDtos.add()

//        opener_with_correct_passwords.setPasswords();
        return null;
    }

    // TODO: реализовать логику
    public Page<OpenerEntity> getOpenersWithAccess(Integer page, Integer size) {
        return null;
    }

    public String deleteOpener(Long id) {
        if (!repository.findById(id).isPresent())
            throw new OpenerNotFoundException();
        return "Opener deleted";
    }

}
