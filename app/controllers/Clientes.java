package controllers;

import java.util.List;

import models.Cliente;
import models.Conta;
import models.GeradorDeNumeroDeConta;
import play.data.validation.Valid;
import play.mvc.Controller;

public class Clientes extends Controller{
	
	public static void cadastro(Cliente cliente) {
		render(cliente);
	}
	
	public static void dadosCliente(Cliente cliente) {
		long id = new Long(session.get("idClienteLogado"));
		cliente = Cliente.findById(id);
		render(cliente);
	}
	
	public static void salvar(@Valid Cliente cliente) {
		
    System.out.println(validation.hasErrors());
		
		if(validation.hasErrors()) {
			validation.keep();
			params.flash();
			cadastro(cliente);
		}
		
		Conta conta = new Conta();
		conta.gerarNumeroConta();
		conta.save();
		 
		cliente.cliConta = conta;
		cliente.save();
		
		GeradorDeNumeroDeConta gerador = (GeradorDeNumeroDeConta) GeradorDeNumeroDeConta.findAll().get(0);
		gerador.numeroCoontroleConta += 1;
		gerador.save();
		
		flash.success("Cliente adicionado com sucesso!");
		renderTemplate("Logins/login.html", cliente);
	} 
	public static void atualizar(@Valid Cliente cliente) {
		
		 System.out.println(validation.hasErrors());
			
			if(validation.hasErrors()) {
				validation.keep();
				params.flash();
				dadosCliente(cliente);
			}
			
		cliente.save();
		flash.success("Dados atualizados com sucesso!");
		renderTemplate("Application/index.html", cliente);
	} 
	
	public static void editar(Long id) {
		Cliente cliente = Cliente.findById(id);
		renderTemplate("Clientes/dadosCliente.html", cliente);
	}
	
	public static void detalhes(Cliente cliente) {
		render(cliente); 
	}
	
	public static void listar() {
		List<Cliente> clientes = Cliente.findAll();
		render(clientes); 
	}
	
	public static void remover(Long id) {
		Cliente cliente = Cliente.findById(id);
		cliente.delete();
		flash.success("Cliente removido com sucesso!");
		listar();
	}
	
	public static void buscar(String busca) {
		System.out.println(busca);
		List<Cliente> clientes = Cliente.find("nome like ? or email like ?", "%" + busca + "%", "%" + busca + "%").fetch();
		renderTemplate("Clientes/listar.html", clientes);
	}

}
