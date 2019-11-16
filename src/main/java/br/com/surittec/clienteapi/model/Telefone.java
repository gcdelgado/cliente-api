package br.com.surittec.clienteapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoTelefone tipo;

    @NotEmpty
    private String numero;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

}
