package it.polito.tdp.anagrammi.model;

import java.util.Set;

import it.polito.tdp.anagrammi.DAO.ParolaDAO;

public class Model {

	ParolaDAO parolaDAO;

	public Model() {
		this.parolaDAO = new ParolaDAO();
	}

	public boolean isCorretto(String s){
		return this.parolaDAO.isCorretto(s);
	}
	
}
