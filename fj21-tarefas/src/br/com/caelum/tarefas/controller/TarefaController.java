package br.com.caelum.tarefas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Controller
public class TarefaController {
	
	private JdbcTarefaDao dao;

	@Autowired
	public TarefaController(JdbcTarefaDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("tarefa")
	public String Tarefa(Tarefa tarefa) {
		return "tarefas/adiciona";
	}	
	
	@RequestMapping("adicionaTarefa")
	public String adicionaTarefa(@Valid Tarefa tarefa, Model model, BindingResult result) {
		
		if (result.hasFieldErrors("descricao")) {
			model.addAttribute("hasErros", "OK");
			return "tarefas/adiciona";
		}
		
		System.out.println("Verificação de charset:" + tarefa.getDescricao());
		
		dao.adiciona(tarefa);
		return "redirect:listaTarefa";
	}
	
	@RequestMapping("listaTarefa")
	public String listarTarefa(Model model) {
		
		

		List<Tarefa> tarefas = dao.lista();
		
		model.addAttribute("tarefas", tarefas);
		
		return "tarefas/lista";
	}
	
	@RequestMapping("removeTarefa")
	public String removeTarefa(Tarefa tarefa) {
		
		

		dao.remove(tarefa);
		return "redirect:listaTarefa";
	}
	
	@ResponseBody
	@RequestMapping("finalizaTarefa")
	public void finalizaTarefa(Long id) {
		
		
	
		dao.finaliza(id);
		//return "redirect:listaTarefa";
	}
	
	
	//Exemplo retornando model
	@ResponseBody
	@RequestMapping("finalizaTarefaModel")
	public void finalizaTarefaModel(Long id, Model model) {
		
		

		dao.finaliza(id);
		model.addAttribute("tarefa", dao.buscaPorId(id));
		//return "tarefa/datafinalizada";
	}
}
