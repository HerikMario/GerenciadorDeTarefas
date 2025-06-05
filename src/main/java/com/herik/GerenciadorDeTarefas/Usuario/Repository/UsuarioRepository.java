package com.herik.GerenciadorDeTarefas.Usuario.Repository;

import com.herik.GerenciadorDeTarefas.Usuario.Model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
}
