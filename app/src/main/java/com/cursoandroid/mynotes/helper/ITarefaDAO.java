package com.cursoandroid.mynotes.helper;

import com.cursoandroid.mynotes.model.Tarefa;

import java.util.List;

public interface ITarefaDAO {

    //Salvar - Deletar - Listar - Atualizar Tarefas
   public boolean salvar(Tarefa tarefa);
   public boolean atualizar(Tarefa tarefa);
   public boolean deletar(Tarefa tarefa);
   public List<Tarefa> listar();

}
