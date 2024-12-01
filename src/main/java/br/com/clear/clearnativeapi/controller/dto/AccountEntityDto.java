package br.com.clear.clearnativeapi.controller.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link br.com.clear.clearnativeapi.data.entity.AccountEntity}
 */
@Value
public class AccountEntityDto implements Serializable {
    Long id;
    Integer accountNumber;
    String accountName;
    String type;
}
