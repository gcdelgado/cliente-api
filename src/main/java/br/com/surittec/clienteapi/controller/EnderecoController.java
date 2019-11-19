package br.com.surittec.clienteapi.controller;

import br.com.surittec.clienteapi.model.Endereco;
import br.com.surittec.clienteapi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("${origem-permitida}")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping(value = "enderecos/{cep}")
    public Endereco consultarEnderecoPorCep(@PathVariable String cep) {
        return enderecoRepository.buscarPorCep(cep);
    }

}
