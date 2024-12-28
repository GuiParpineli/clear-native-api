package br.com.clear.clearnativeapi.web.controller.dto;

import br.com.clear.clearnativeapi.infrastructure.entity.AccountEntity;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link AccountEntity}
 */
@Value
public class AccountDto implements Serializable {
    Long id;
    Integer accountNumber;
    String accountName;
    String type;
}
