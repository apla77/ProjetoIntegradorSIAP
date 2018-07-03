package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import play.db.jpa.Model;
@Entity
public class Conta extends Model{
	
	public Integer numeroConta;
	@Transient
	public float recarga;
	public float saldo;
	@Transient
	public String pagamento;
	
	
	public void gerarNumeroConta(){
		GeradorDeNumeroDeConta gerador = (GeradorDeNumeroDeConta) GeradorDeNumeroDeConta.findAll().get(0);
		numeroConta = gerador.numeroCoontroleConta;		
	}  
	@OneToMany(mappedBy = "conta")
	public List<Recarga> recargas;
	
}
