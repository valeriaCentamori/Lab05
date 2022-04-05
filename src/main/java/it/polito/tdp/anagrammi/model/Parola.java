package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

public class Parola {
	
	Set<String> anagrammi= new HashSet<String>();
	
	public Set<String> anagramma(String s) {
		anagramma_ricorsiva("",0,s);
		return anagrammi;
	}
	
	private void anagramma_ricorsiva(String parziale, int livello, String rimanenti) {
		if(rimanenti.length()==0) {
			anagrammi.add(parziale);
		}else {
			for(int pos=0; pos<rimanenti.length(); pos++) {
				anagramma_ricorsiva(parziale+rimanenti.charAt(pos),livello+1,rimanenti.substring(0, pos)+rimanenti.substring(pos+1));
				anagrammi.add(parziale+rimanenti.charAt(pos)+rimanenti.substring(0, pos)+rimanenti.substring(pos+1));
			}
		}
	}
}
