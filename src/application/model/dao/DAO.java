package application.model.dao;

import java.sql.Connection;

import application.model.beans.Films;
import application.model.dao.MySQLConnect;
import javafx.collections.ObservableList;

public abstract class DAO<T> {
	
    public Connection connect = MySQLConnect.getInstance();
    /** * Permet de récupérer un objet via son ID * @param id * @return */
    public abstract T find(long id);
    
    /** * Permet de créer une entrée dans la base de données * par rapport à un objet*/
    public abstract T create(T obj);
   
    /** * Permet de mettre à jour les données d'une entrée dans la base  */
    public abstract T update(T obj);
   
    /** * Permet la suppression d'une entrée de la base * @param obj */
    public abstract void delete(T obj);
    
    // Permet d'afficher la listeBDD dans le tableau
	public abstract ObservableList<Films> listeBDD();

}