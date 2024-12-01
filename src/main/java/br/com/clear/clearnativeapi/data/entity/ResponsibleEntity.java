package br.com.clear.clearnativeapi.data.entity;

import br.com.clear.clearnativeapi.controller.dto.ResponsibleDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "responsible")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponsibleEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String phone;
    @OneToOne
    private CompanyEntity company;
    private String role;
    @OneToOne
    private UserEntity userEntity;
}
