package ru.niatomi.service.Impl;

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
import ru.niatomi.service.ESPService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author niatomi
 */
@Service
@AllArgsConstructor
public class ESPServiceImpl implements ESPService {

    private final PasswordRepository passwordRepository;
    private final ActionsHistoryRepository actionsHistoryRepository;
    private final OpenerRepository openerRepository;
    private final KeylockConfigRepository keylockConfigRepository;
    private final KeylockMapper keylockMapper;

    @Override
    public List<PasswordWithOpenerIdDto> getPasswords() {
        List<PasswordWithOpenerIdDto> passwordList = new ArrayList<>();
        passwordRepository.findAll().forEach(p -> passwordList
                .add(new PasswordWithOpenerIdDto(p.getOpener().getId(), p.getType().toLowerCase(), p.getValue())));
        return passwordList;
    }

    @Override
    public void addAction(ActionsHistoryDto actionsHistory) {
        ActionsHistoryEntity actionsHistoryEntity = new ActionsHistoryEntity(
                actionsHistoryRepository.count() + 1,
                openerRepository.findById(actionsHistory.getOpenerId()).get(),
                actionsHistory.getDescription(),
                LocalDateTime.now());

        if (actionsHistory.getDescription().equals("unClosed") || actionsHistory.getDescription().equals("Closed")) {
            ActionsHistoryEntity lastRecord = actionsHistoryRepository.findById(actionsHistoryRepository.count()).get();
            actionsHistoryEntity.setOpener(lastRecord.getOpener());
        }

        actionsHistoryRepository.save(actionsHistoryEntity);
    }

    @Override
    public KeylockConfigDto getConfig() {
        return keylockMapper.map(keylockConfigRepository.findById(1).get());
    }

    @Override
    public void lockConfig() {
        KeylockConfig keylockConfig = keylockConfigRepository.findById(1).get();
        keylockConfig.setLock(true);
        keylockConfigRepository.save(keylockConfig);
    }

}
