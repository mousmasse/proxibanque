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
		// Etape1 : Création de la requête
		String sql = "INSERT INTO agence VALUES(NULL,?,?);";
		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
			// Etape2 : transmission des valeurs aux paramètres de la requête

			preparedStatement.setString(1, e.getLibAgence());
			preparedStatement.setDate(2, Date.valueOf(e.getDateCreation()));

			// Etape3 : exécution de la requête

			preparedStatement.executeUpdate();
			
		} catch (SQLException s) {
			log.info("Echec de la création d'une agence.");
			log.error(s.getMessage());
		} finally {
			log.info("Requête de création d'une agence exécuté avec succés.");
		}

	}

	/* (non-Javadoc)
	 * @see sn.objis.proxibanque.dao.IDaoGenerique#lire(java.lang.Object)
	 */
	public Agence lire(Agence e) {
		Agence agence = new Agence();
		// Etape1 : Création de la requête

		String sql = "SELECT * FROM agence where numeroAgence = ?;";

		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {

			// Etape2 : transmission de la valeur aux paramètres de la requête
			preparedStatement.setLong(1, e.getNumeroAgence());

			// Etape3 : exécution de la requête

			try (ResultSet resultSet = preparedStatement.executeQuery()) {

				// Etape3 : Traitement du résultat
				
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
				log.info("Requête de lecture d'une agence exécuté avec succés.");
			}

		} catch (SQLException s) {
			log.info("Echec de l'execution de la requête de lecture d'une agence.");
			log.error(s.getMessage());
		} finally {
			log.info("Execution de la requête de lecture d'une agence exécuté avec succés.");
		}

		return agence;

	}

	public List<Agence> lire() {
		List<Agence> listeAgence = new ArrayList<>();
		
		//Etape1 : Création de la requête
		String sql = "SELECT * FROM agence ;";

			try (Statement statement = connexion.createStatement()){
				//Etape2: Exécution de la requête

				try (ResultSet resultSet = statement.executeQuery(sql)){
					
					//Etape3 : Traitement du résultat
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
					log.info("Requête de lecture de la table agence exécuté avec succés.");
				}		
				
			}  catch (SQLException s) {
				log.info("Echec de la préparation de la liste des agences.");
				log.error(s.getMessage());
			} finally {
				log.info("Préparation de la liste des agences exécuté avec succés.");
			}

		
	return listeAgence;
	}

	public void modifier(Agence e) {

		// Etape1 : Création de la requête
		
		String sql = "UPDATE agence SET libAgence  = ?, dateCreation =? WHERE numeroAgence=?";

		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {

			// Etape2 : transmission des valeurs aux paramètres de la requête
			
			preparedStatement.setString(1, e.getLibAgence());
			preparedStatement.setDate(2, Date.valueOf(e.getDateCreation()));
			preparedStatement.setLong(3, e.getNumeroAgence());

			// Etape3 : exécution de la requête
			
			preparedStatement.executeUpdate();

		} catch (Exception s) {
			log.info("Echec de la modification des informations de l'agence.");
			log.error(s.getMessage());
		} finally {
			log.info("Requête de modification d'une agence exécuté avec succés.");
		}
	}

	/* (non-Javadoc)
	 * @see sn.objis.proxibanque.dao.IDaoGenerique#supprimer(java.lang.Object)
	 */
	public void supprimer(Agence e) {

		// IMPORTANT A COMPLETER AVEC AGENT ET CLIENT!!!

		// Etape1 : Création de la requête
		
		String sql = "DELETE FROM agence where numeroAgence=?";

		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {

			// Etape2 : transmission de la valeur aux paramètres de la requête
			
			preparedStatement.setLong(1, e.getNumeroAgence());

			// Etape3 : exécution de la requête
			
			preparedStatement.executeUpdate();

		} catch (Exception s) {
			log.info("Echec de la suppression des informations de l'agence.");
			log.error(s.getMessage());
		} finally {
			log.info("Requête de suppression d'une agence exécuté avec succés.");
		}

	}

	public Agence dernierenregistrement() {
		// TODO Auto-generated method stub
		return null;
	}

}
