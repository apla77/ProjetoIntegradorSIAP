package controllers;

import java.util.List;

import org.h2.engine.User;

import models.Usuario;
import play.mvc.Before;
import play.mvc.Controller;

public class Admin extends Controller{
 @Before(unless="login")
 static void checkAuthentification() {
	 if(session.get("User")== null)Logins.login();
 }
 public static void index() {
	 List<Usuario> users = Usuario.findAll();
	 render(users);
 }
}
