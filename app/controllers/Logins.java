package controllers;

import javax.servlet.http.HttpSession;

import models.Cliente;
import models.Usuario;
import play.mvc.Controller;

public class Logins extends Controller{
	
	public static void login() {
		render();
	}
		
	public static void autenticar(String login, String senha) {
		boolean tipoLogin = false;
		Cliente usuario;
		for(int i = 0; i < login.length() ; i++) {
			if(login.charAt(i) == '@') {
				tipoLogin = true;
			}
		}
		
	    if(login.equals("admin") && senha.equals("admin")){
	    	Operadores.operador(); 
	    }
		
		if(tipoLogin) {
			usuario = Cliente.find("email = ? and senha = ?", login, senha).first();
		}
		else {
			usuario = Cliente.find("telefone = ? and senha = ?", login, senha).first();
		}
		if(usuario == null){
			flash.error("Por favor, entre com usuário e senha corretos.");
			login();
		}else{
			session.put("idClienteLogado", usuario.id);
			Application.index(); 
		}
	}
	
	public static void logout() {
		session.clear();
		System.out.println("logout");
		login();
	}


}
