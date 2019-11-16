package br.com.surittec.clienteapi.repository;

import br.com.surittec.clienteapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
