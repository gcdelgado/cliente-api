package br.com.surittec.clienteapi.controller;

import br.com.surittec.clienteapi.model.*;
import br.com.surittec.clienteapi.repository.AuditoriaRepository;
import br.com.surittec.clienteapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("${origem-permitida}")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @GetMapping(value = "/clientes")
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @GetMapping(value = "/clientes/{id}")
    public Cliente porId(@PathVariable("id") Long id) {
        Optional<Cliente> optCliente = clienteRepository.findById(id);
        return optCliente.orElse(null);
    }

    @PostMapping(value = "/clientes")
    public Cliente adicionar(@RequestBody @Valid Cliente cliente){
        if (cliente.getEndereco() != null){
            cliente.getEndereco().setCliente(cliente);
        }
        if (cliente.getEmails() != null) {
            for (Email email : cliente.getEmails()) {
                email.setCliente(cliente);
            }
        }
        if (cliente.getTelefones() != null) {
            for (Telefone telefone : cliente.getTelefones()) {
                telefone.setCliente(cliente);
            }
        }

        TipoOperacao tipoOperacao= cliente.getId() == null ? TipoOperacao.INCLUSAO : TipoOperacao.ALTERACAO;

        auditoriaRepository.save(new Auditoria(tipoOperacao, cliente.getId(), cliente.getNome(), "admin"));

        clienteRepository.save(cliente);

        return cliente;
    }

    @DeleteMapping(value = "/clientes/{id}")
    public void excluir(@PathVariable("id") Long id){
        Cliente cliente = porId(id);

        clienteRepository.deleteById(id);

        Auditoria auditoria = new Auditoria(TipoOperacao.EXCLUSAO, id, cliente.getNome(), "admin");

        auditoriaRepository.save(auditoria);

    }

}
