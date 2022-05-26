package ru.niatomi.service;

import ru.niatomi.model.domain.PasswordEntity;
import ru.niatomi.model.dto.PasswordDto;

/**
 * @author niatomi
 */
public interface PasswordService {

    PasswordDto createPassword(PasswordEntity passwordEntity, Long openerId);

}
