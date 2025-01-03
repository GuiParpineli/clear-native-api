package br.com.clear.clearnativeapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
    private long id;
    private String street;
    private String number;
    private String city;
    private String state;
    private int zipCode;
}
