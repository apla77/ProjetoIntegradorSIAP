package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Usuario extends Model {
	
	public Cliente cliente;
	
	
}
