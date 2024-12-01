package br.com.clear.clearnativeapi.domain.model;

import lombok.Data;

@Data
public class Address {
    private Long id;
    private String street;
    private String number;
    private String city;
    private String state;
    private String zipCode;
}
