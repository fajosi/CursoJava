package br.com.caelum.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Controller
public class TarefaController {
	
	@RequestMapping("adicionaTarefa")
	public String adicionaTarefa(Tarefa tarefa) {
		
		JdbcTarefaDao dao = new JdbcTarefaDao();	
		dao.adiciona(tarefa);
		return "tarefas/mensagens";
	}

}
