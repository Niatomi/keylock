package ru.niatomi.service;



import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.niatomi.dto.KeylockConfigDto;
import ru.niatomi.mapper.KeylockMapper;
import ru.niatomi.model.domain.ActionsHistoryEntity;
import ru.niatomi.model.domain.KeylockConfig;
import ru.niatomi.model.dto.ActionsHistoryDto;
import ru.niatomi.model.dto.PasswordWithOpenerIdDto;
import ru.niatomi.repository.ActionsHistoryRepository;
import ru.niatomi.repository.KeylockConfigRepository;
import ru.niatomi.repository.OpenerRepository;
import ru.niatomi.repository.PasswordRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author niatomi
 */
@Service
@AllArgsConstructor
public class ESPService {

    private final PasswordRepository passwordRepository;
    private final ActionsHistoryRepository actionsHistoryRepository;
    private final OpenerRepository openerRepository;
    private final KeylockConfigRepository keylockConfigRepository;
    private final KeylockMapper keylockMapper;

    public List<PasswordWithOpenerIdDto> getPasswords() {
        List<PasswordWithOpenerIdDto> passwordList = new ArrayList<>();
        passwordRepository.findAll().forEach(p -> passwordList
                .add(new PasswordWithOpenerIdDto(p.getOpener().getId(), p.getType().toLowerCase(), p.getValue())));
        return passwordList;
    }

    public void addAction(ActionsHistoryDto actionsHistory) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        actionsHistoryRepository.save(
                new ActionsHistoryEntity(
                        actionsHistoryRepository.count() + 1,
                        openerRepository.findById(actionsHistory.getOpenerId()).get(),
                        actionsHistory.getDescription(),
                        LocalDateTime.now()));
    }

    public KeylockConfigDto getConfig() {
        return keylockMapper.map(keylockConfigRepository.findById(1).get());
    }

    public void lockConfig() {
        KeylockConfig keylockConfig = keylockConfigRepository.findById(1).get();
        keylockConfig.setLock(true);
        keylockConfigRepository.save(keylockConfig);
    }

}
