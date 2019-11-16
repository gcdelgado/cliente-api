package br.com.surittec.clienteapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String email;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

}
