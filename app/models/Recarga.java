package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Recarga extends Model{
	
	public float recarga;
	public String pagamento;
	public Date data;
	
	@ManyToOne
	@JoinColumn(name = "conta_id")
	public Conta conta;
}
