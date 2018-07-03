package job;

import models.Cliente;
import models.GeradorDeNumeroDeConta;
import models.Usuario;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job{

	@Override
	public void doJob() throws Exception {
	//	if(Usuario.count() == 0){
	//		Usuario usuario = new Usuario();
	//		usuario.login = "admin";
	//		usuario.senha = "admin";
	//		usuario.save();
	//	}
		 
		if(Cliente.count() == 0){
			Cliente usuario = new Cliente();
			usuario.nome = "admin";
			usuario.email = "admin";
			usuario.senha = "admin";
			usuario.save();
		}
		
		if(GeradorDeNumeroDeConta.count() == 0){
			GeradorDeNumeroDeConta gerador = new GeradorDeNumeroDeConta();
			gerador.numeroCoontroleConta = 1000;
			gerador.save();
			
		}
	}
	
}
