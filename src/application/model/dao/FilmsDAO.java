package application.model.dao;

import java.sql.*;
import java.util.ArrayList;

import application.model.beans.Films;

public class FilmsDAO extends DAO<Films> {
		
	// On recherche par le titre en renvoyant une liste
	@Override
	public ArrayList<Films> findByName(String titre){
		
		
		try {
			ArrayList<Films> listFilms = new ArrayList<Films>();
			
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from films where titre like '%"+titre+"%'");
			
			while(rs.next()) {
				Films film = new Films(rs.getInt("idFilms"), rs.getString("titre"), rs.getString("genre"));
				
				int idFilm_bd = rs.getInt("idFilms");
				String titre_bd = rs.getString("titre");
				String genre_bd = rs.getString("genre");
				
				film.setId(idFilm_bd);
				film.setTitre(titre_bd);
				film.setGenre(genre_bd);
				
				listFilms.add(film);
			}
			
			return listFilms;
		}
	

		catch(Exception e) {
			System.out.println("Erreur: "+e.getLocalizedMessage());
		}
		return null;
	}
	
	@Override
	public Films find(String titre) {
		Films film = new Films();
		
		try {
			Statement state = connect.createStatement();
			ResultSet rs = state.executeQuery("select * from Films where titre like %;");
			while(rs.next()) {
				
				int idFilm_bd = rs.getInt("idFilms");
				String titre_bd = rs.getString("titre");
				String genre_bd = rs.getString("genre");
				
				film.setId(idFilm_bd);
				film.setTitre(titre_bd);
				film.setGenre(genre_bd);
				
			}
			
			return film;
		}
		catch(Exception e) {
			System.out.println("Recherche par titre échouée: "+e);
		}
		return null;
	}
		
	@Override
	public Films create(Films obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Films update(Films obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Films obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Films find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
