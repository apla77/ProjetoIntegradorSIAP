package controllers;

import java.util.List;

import models.Sugestao;
import play.data.validation.Valid;
import play.mvc.Controller;

public class Sugestoes extends Controller{

	public static void formSugestao(Sugestao sugestao) {
		render(sugestao);
	}
	
	public static void salvar(@Valid Sugestao sugestao) {
		
		 System.out.println(validation.hasErrors());
			
			if(validation.hasErrors()) {
				validation.keep();
				params.flash();
				formSugestao(sugestao);
			}
			
		sugestao.save();
		flash.success("Mensagem enviada!");
		listSugestao();
	}
	
	
	public static void detalhes(Sugestao sugestao) {
		render(sugestao);
	}
	
	public static void listSugestao() {
		List<Sugestao> sugestoes = Sugestao.findAll();
		render(sugestoes);
	}
	
	public static void listagemOperador() {
		List<Sugestao> sugestoes = Sugestao.findAll();
		render(sugestoes);
	}
	
	public static void remover(Long id) {
		Sugestao sugestao = Sugestao.findById(id);
		flash.success("Mensagem Removida!");
		sugestao.delete();
		listSugestao();
	}
	
}
