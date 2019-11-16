package br.com.surittec.clienteapi.rest;

import br.com.surittec.clienteapi.model.Cliente;
import br.com.surittec.clienteapi.model.Email;
import br.com.surittec.clienteapi.model.Endereco;
import br.com.surittec.clienteapi.model.Telefone;
import br.com.surittec.clienteapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("${origem-permitida}")
public class ClienteRest {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping(value = "/clientes")
    public List<Cliente> listar(){
        return clienteRepository.findAll();
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

        return clienteRepository.save(cliente);
    }

}
