package ru.niatomi.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.niatomi.model.domain.ActionsHistoryEntity;
import ru.niatomi.model.dto.ActionsHistoryDto;
import ru.niatomi.model.dto.PasswordWithOpenerIdDto;
import ru.niatomi.repository.ActionsHistoryRepository;
import ru.niatomi.repository.OpenerRepository;
import ru.niatomi.repository.PasswordRepository;
import ru.niatomi.service.ESPService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author niatomi
 */
@Service
@AllArgsConstructor
public class ESPServiceImpl implements ESPService {

    public final PasswordRepository passwordRepository;
    public final ActionsHistoryRepository actionsHistoryRepository;
    public final OpenerRepository openerRepository;

    public List<PasswordWithOpenerIdDto> getPasswords() {
        List<PasswordWithOpenerIdDto> passwordList = new ArrayList<PasswordWithOpenerIdDto>();
        passwordRepository.findAll().forEach(p -> passwordList.add(new PasswordWithOpenerIdDto(p.getOpener().getId(), p.getType(), p.getValue())));
        return passwordList;
    }

    public void addAction(ActionsHistoryDto actionsHistoryDto) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        actionsHistoryRepository.save(
                new ActionsHistoryEntity(
                        actionsHistoryRepository.count() + 1,
                        openerRepository.findById(actionsHistoryDto.getOpenerId()).get(),
                        actionsHistoryDto.getDescription(),
                        LocalDateTime.now().format(format)));
    }
}
