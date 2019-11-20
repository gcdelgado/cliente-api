package br.com.surittec.clienteapi.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Auditoria implements Serializable {

    public Auditoria(TipoOperacao tipoOperacao, Long idCliente, String nomeCliente, String usuario) {
        this.tipoOperacao = tipoOperacao;
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.usuario = usuario;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoOperacao tipoOperacao;

    private Long idCliente;

    private String nomeCliente;

    private String usuario;

    private Date dataHora = new Date();

}
