package br.com.surittec.clienteapi.model;

import lombok.Getter;

public enum TipoTelefone {
    RES ("Residencial"),
    COM ("Comercial"),
    CEL ("Celular");

    @Getter
    private String descricao;

    TipoTelefone(String descricao) {
        this.descricao = descricao;
    }

}
