/**
 * 
 */
package sn.objis.proxibanque.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import sn.objis.proxibanque.metier.CompteCourant;
import sn.objis.proxibanque.utils.MysqlConnexion;

/**
 * @author Moustapha M. NDIAYE
 *
 */
public class IDaoCompteCourantImpl implements IDaoCompteCourant{
	
	/**
	 * Obtention d'une instance de Logger
	 */
	static final Logger log = LogManager.getLogger(IDaoAgenceImpl.class.getName());

	/**
	 * Obtention de l'unique instance de connexion avec la base
	 */
	Connection connexion = MysqlConnexion.getInstanceConnexion();

	@Override
	public void ajouter(CompteCourant e) {

		// Etape1 : Cr�ation de la requ�te
		String sql = "INSERT INTO agence VALUES(NULL,?,?,?,?);";
		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
			// Etape2 : transmission des valeurs aux param�tres de la requ�te

			preparedStatement.setDouble(1, e.getSoldeCourant());
			preparedStatement.setDate(2, Date.valueOf(e.getDateOuvertureCourant()));
			preparedStatement.setDouble(3, e.getDecouvert());
			preparedStatement.setLong(5, e.getClientCompteCourant().getIdClient());

			// Etape3 : ex�cution de la requ�te

			preparedStatement.executeUpdate();
			
		} catch (SQLException s) {
			log.info("Echec de la cr�ation du compte courant.");
			log.error(s.getMessage());
		} finally {
			log.info("Requ�te de cr�ation du compte courant ex�cut� avec succ�s.");
		}

	
		
	}

	@Override
	public CompteCourant lire(CompteCourant e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompteCourant> lire() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifier(CompteCourant e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimer(CompteCourant e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CompteCourant dernierenregistrement() {
		// TODO Auto-generated method stub
		return null;
	}

}
