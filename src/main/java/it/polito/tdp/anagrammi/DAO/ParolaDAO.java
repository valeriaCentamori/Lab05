package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParolaDAO {
	
	public boolean isCorretto(String s){
		
		final String sql="SELECT * FROM parola WHERE nome=?";
		boolean ok=false;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, s);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				ok= true;
			}

			st.close();
			rs.close();
			conn.close();

			return ok;


		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}

}
