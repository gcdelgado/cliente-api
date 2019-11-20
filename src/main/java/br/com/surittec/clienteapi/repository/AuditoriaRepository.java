package br.com.surittec.clienteapi.repository;

import br.com.surittec.clienteapi.model.Auditoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditoriaRepository extends JpaRepository<Auditoria, Long> {
}
