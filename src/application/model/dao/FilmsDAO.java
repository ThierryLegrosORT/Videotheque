package application.model.dao;

import java.sql.*;
import java.util.ArrayList;

import application.model.beans.Films;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FilmsDAO extends DAO<Films> {
		
	
	@Override
	public Films find(long id) {
		
		Films film = new Films();
		
		try {
			
			Statement state = connect.createStatement();
			
			ResultSet rs = (ResultSet)state.executeQuery("select * from Films where idFilms ="+id+";");
			
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
			System.out.println("Recherche par titre échouée: "+e.getLocalizedMessage());
		}
		return null;
	}
	
	public ArrayList<Films> findbyname(String titre){
		ArrayList<Films> listfilm = new ArrayList<Films>();
		
		try {
			Statement state = connect.createStatement();
			ResultSet result = state.executeQuery("select * from Films where titre like '%"+titre+"%';");
			while (result.next()) {
				
				Films film = new Films();
				int idFilm_bd = result.getInt("idFilms");
				String titre_bd = result.getString("titre");
				String genre_bd = result.getString("genre");
				
				film.setId(idFilm_bd);
				film.setTitre(titre_bd);
				film.setGenre(genre_bd);
				
				listfilm.add(film);
			}
			return listfilm;
		}
		catch(Exception e) {
			System.out.println("Erreur FilmDAO: "+e.getLocalizedMessage());
		}
		return null;
	}
		
	@Override
	public Films create(Films obj) {
		// TODO Auto-generated method stub
		String titre = obj.getTitre();
		String genre = obj.getGenre();
		int annee = obj.getAnnee();
		
		try {
			Statement state = connect.createStatement();
			state.execute("insert into Films (titre, genre, annee) values ('"+titre+"', '"+genre+"', "+annee+");");
			
		}
		catch(Exception e) {
			System.out.println("Insert failed: "+e.getLocalizedMessage());
		}
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
		int idfilm = obj.getId();
		try {
			Statement state = connect.createStatement();
			state.execute("delete from Films where idFilms = "+idfilm+";");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public ObservableList<Films> listeBDD(){
		try {
			ObservableList<Films> film = FXCollections.observableArrayList();
			Statement state = connect.createStatement();
			ResultSet rs = state.executeQuery("select * from Films order by titre;");
			
			while(rs.next()) {
				Films ligne = new Films(rs.getInt("idFilms"),
						rs.getString("titre"),
						rs.getString("genre"),
						rs.getInt("annee"));
				film.add(ligne);
			}
			return film;
		}
		catch(Exception e) {
			System.out.println("ligne error: "+e.getLocalizedMessage());
		}
		return null;
	}

}
