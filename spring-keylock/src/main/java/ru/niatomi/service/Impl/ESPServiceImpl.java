package ru.niatomi.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.niatomi.model.domain.ActionsHistoryEntity;
import ru.niatomi.model.dto.ActionsHistory;
import ru.niatomi.model.dto.PasswordWithOpenerId;
import ru.niatomi.repository.ActionsHistoryRepository;
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
public class ESPServiceImpl {

    public final PasswordRepository passwordRepository;
    public final ActionsHistoryRepository actionsHistoryRepository;
    public final OpenerRepository openerRepository;

    public List<PasswordWithOpenerId> getPasswords() {
        List<PasswordWithOpenerId> passwordList = new ArrayList<PasswordWithOpenerId>();
        passwordRepository.findAll().forEach(p -> passwordList.add(new PasswordWithOpenerId(p.getOpener().getId(), p.getType(), p.getValue())));
        return passwordList;
    }

    public void addAction(ActionsHistory actionsHistory) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        actionsHistoryRepository.save(
                new ActionsHistoryEntity(
                        actionsHistoryRepository.count() + 1,
                        openerRepository.findById(actionsHistory.getOpenerId()).get(),
                        actionsHistory.getDescription(),
                        LocalDateTime.now().format(format)));
    }
}
