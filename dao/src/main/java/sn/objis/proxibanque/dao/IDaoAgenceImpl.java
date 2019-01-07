/**
 * 
 */
package sn.objis.proxibanque.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import sn.objis.proxibanque.metier.Agence;
import sn.objis.proxibanque.utils.MysqlConnexion;

/**
 * Classe IDaoAgenceImpl
 * 
 * @author Moustapha M. NDIAYE
 * @version 0.0.1-SNAPSHOT
 * @since 02/01/2019
 */
public class IDaoAgenceImpl implements IDaoAgence {

	/**
	 * Obtention d'une instance de Logger
	 */
	static final Logger log = LogManager.getLogger(IDaoAgenceImpl.class.getName());

	/**
	 * Obtention de l'unique instance de connexion avec la base
	 */
	Connection connexion = MysqlConnexion.getInstanceConnexion();

	/*
	 * (non-Javadoc)
	 * 
	 * @see sn.objis.proxibanque.dao.IDaoGenerique#ajouter(java.lang.Object)
	 */
	public void ajouter(Agence e) {
		// Etape1 : Cr�ation de la requ�te
		String sql = "INSERT INTO agence VALUES(NULL,?,?);";
		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
			// Etape2 : transmission des valeurs aux param�tres de la requ�te

			preparedStatement.setString(1, e.getLibAgence());
			preparedStatement.setDate(2, Date.valueOf(e.getDateCreation()));

			// Etape3 : ex�cution de la requ�te

			preparedStatement.executeUpdate();
			
		} catch (SQLException s) {
			log.info("Echec de la cr�ation d'une agence.");
			log.error(s.getMessage());
		} finally {
			log.info("Requ�te de cr�ation d'une agence ex�cut� avec succ�s.");
		}

	}

	/* (non-Javadoc)
	 * @see sn.objis.proxibanque.dao.IDaoGenerique#lire(java.lang.Object)
	 */
	public Agence lire(Agence e) {
		Agence agence = new Agence();
		// Etape1 : Cr�ation de la requ�te

		String sql = "SELECT * FROM agence where numeroAgence = ?;";

		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {

			// Etape2 : transmission de la valeur aux param�tres de la requ�te
			preparedStatement.setLong(1, e.getNumeroAgence());

			// Etape3 : ex�cution de la requ�te

			try (ResultSet resultSet = preparedStatement.executeQuery()) {

				// Etape3 : Traitement du r�sultat
				
				while (resultSet.next()) {

					agence.setNumeroAgence(resultSet.getLong("numeroAgence"));
					agence.setLibAgence(resultSet.getString("libAgence"));
					Date date = resultSet.getDate("dateCreation");
					agence.setDateCreation(date.toLocalDate());

				}

			} catch (Exception s) {
				log.info("Echec de la lecture d'une agence.");
				log.error(s.getMessage());
			} finally {
				log.info("Requ�te de lecture d'une agence ex�cut� avec succ�s.");
			}

		} catch (SQLException s) {
			log.info("Echec de l'execution de la requ�te de lecture d'une agence.");
			log.error(s.getMessage());
		} finally {
			log.info("Execution de la requ�te de lecture d'une agence ex�cut� avec succ�s.");
		}

		return agence;

	}

	public List<Agence> lire() {
		List<Agence> listeAgence = new ArrayList<>();
		
		//Etape1 : Cr�ation de la requ�te
		String sql = "SELECT * FROM agence ;";

			try (Statement statement = connexion.createStatement()){
				//Etape2: Ex�cution de la requ�te

				try (ResultSet resultSet = statement.executeQuery(sql)){
					
					//Etape3 : Traitement du r�sultat
					while (resultSet.next()) {
						
						Agence agence = new Agence();
						
						agence.setNumeroAgence(resultSet.getLong("numeroAgence"));
						agence.setLibAgence(resultSet.getString("libAgence"));
						Date date = resultSet.getDate("dateCreation");
						agence.setDateCreation(date.toLocalDate());	
						
						listeAgence.add(agence);
					}
					
				} catch (Exception s) {
					log.info("Echec de la lecture de la table agence.");
					log.error(s.getMessage());
				} finally {
					log.info("Requ�te de lecture de la table agence ex�cut� avec succ�s.");
				}		
				
			}  catch (SQLException s) {
				log.info("Echec de la pr�paration de la liste des agences.");
				log.error(s.getMessage());
			} finally {
				log.info("Pr�paration de la liste des agences ex�cut� avec succ�s.");
			}

		
	return listeAgence;
	}

	public void modifier(Agence e) {

		// Etape1 : Cr�ation de la requ�te
		
		String sql = "UPDATE agence SET libAgence  = ?, dateCreation =? WHERE numeroAgence=?";

		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {

			// Etape2 : transmission des valeurs aux param�tres de la requ�te
			
			preparedStatement.setString(1, e.getLibAgence());
			preparedStatement.setDate(2, Date.valueOf(e.getDateCreation()));
			preparedStatement.setLong(3, e.getNumeroAgence());

			// Etape3 : ex�cution de la requ�te
			
			preparedStatement.executeUpdate();

		} catch (Exception s) {
			log.info("Echec de la modification des informations de l'agence.");
			log.error(s.getMessage());
		} finally {
			log.info("Requ�te de modification d'une agence ex�cut� avec succ�s.");
		}
	}

	/* (non-Javadoc)
	 * @see sn.objis.proxibanque.dao.IDaoGenerique#supprimer(java.lang.Object)
	 */
	public void supprimer(Agence e) {

		// IMPORTANT A COMPLETER AVEC AGENT ET CLIENT!!!

		// Etape1 : Cr�ation de la requ�te
		
		String sql = "DELETE FROM agence where numeroAgence=?";

		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {

			// Etape2 : transmission de la valeur aux param�tres de la requ�te
			
			preparedStatement.setLong(1, e.getNumeroAgence());

			// Etape3 : ex�cution de la requ�te
			
			preparedStatement.executeUpdate();

		} catch (Exception s) {
			log.info("Echec de la suppression des informations de l'agence.");
			log.error(s.getMessage());
		} finally {
			log.info("Requ�te de suppression d'une agence ex�cut� avec succ�s.");
		}

	}

	public Agence dernierenregistrement() {
		// TODO Auto-generated method stub
		return null;
	}

}
