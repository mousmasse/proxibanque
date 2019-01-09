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
import sn.objis.proxibanque.metier.Personnel;
import sn.objis.proxibanque.utils.MysqlConnexion;

/**
 * Classe IDaoPersonnelImpl
 * 
 * @author Moustapha M. NDIAYE
 * @version 0.0.1-SNAPSHOT
 * @since 02/01/2019
 */
public class IDaoPersonnelImpl implements IDaoPersonnel{
	
	/**
	 * Obtention d'une instance de Logger
	 */
	static final Logger log = LogManager.getLogger(IDaoAgenceImpl.class.getName());

	/**
	 * Obtention de l'unique instance de connexion avec la base
	 */
	Connection connexion = MysqlConnexion.getInstanceConnexion();

	@Override
	public void ajouter(Personnel e) {
		
		// Etape1 : Création de la requête
		
		String sql = "INSERT INTO personnel VALUES(NULL,?,?,?,?,?,?,?);";
		
		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
			// Etape2 : transmission des valeurs aux paramètres de la requête

			preparedStatement.setString(1, e.getNomPersonnel());
			preparedStatement.setString(2, e.getPrenomPersonnel());
			preparedStatement.setString(3, e.getTypePersonnel());
			preparedStatement.setString(4, e.getAdressePersonnel());
			preparedStatement.setInt(5, e.getTelPersonnel());
			preparedStatement.setDate(6, Date.valueOf(e.getDateEmbauche()));
			preparedStatement.setLong(7, e.getAgence().getNumeroAgence());
			
			// Etape3 : exécution de la requête

			preparedStatement.executeUpdate();
			
		} catch (SQLException s) {
			log.info("Echec de la création d'un enregistrement de personnel.");
			log.error(s.getMessage());
		} finally {
			log.info("Requête de création d'un enregistrement de personnel exécuté avec succés.");
		}

	}

	@Override
	public Personnel lire(Personnel e) {

		Personnel personnel = new Personnel();
		// Etape1 : Création de la requête

		String sql = "SELECT * FROM personnel where idPersonnel = ?;";

		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {

			// Etape2 : transmission de la valeur aux paramètres de la requête
			preparedStatement.setLong(1, e.getIdPersonnel());

			// Etape3 : exécution de la requête

			try (ResultSet resultSet = preparedStatement.executeQuery()) {

				// Etape3 : Traitement du résultat
				
				while (resultSet.next()) {

					personnel.setIdPersonnel(resultSet.getLong("idPersonnel"));
					personnel.setNomPersonnel(resultSet.getString("nomPersonnel"));
					personnel.setPrenomPersonnel(resultSet.getString("prenomPersonnel"));
					personnel.setTypePersonnel(resultSet.getString("typePersonnel"));
					personnel.setAdressePersonnel(resultSet.getString("adressePersonnel"));
					personnel.setTelPersonnel(resultSet.getInt("telPersonnel"));
					Date date = resultSet.getDate("dateEmbauche");
					personnel.setDateEmbauche(date.toLocalDate());
					Agence agence = new Agence();
					agence.setNumeroAgence(resultSet.getLong("numeroAgence"));
					personnel.setAgence(agence);

				}

			} catch (Exception s) {
				log.info("Echec de la lecture d'un enregistrement de personnel.");
				log.error(s.getMessage());
			} finally {
				log.info("Requête de lecture d'un enregistrement de personnel exécuté avec succés.");
			}

		} catch (SQLException s) {
			log.info("Echec de l'execution de la requête de lecture d'un enregistrement de personnel.");
			log.error(s.getMessage());
		} finally {
			log.info("Execution de la requête de lecture d'un enregistrement de personnel exécuté avec succés.");
		}

		return personnel;

	
	}

	@Override
	public List<Personnel> lire() {
		List<Personnel> listePersonnels = new ArrayList<>();
		
		//Etape1 : Création de la requête
		String sql = "SELECT * FROM personnel ;";

			try (Statement statement = connexion.createStatement()){
				//Etape2: Exécution de la requête

				try (ResultSet resultSet = statement.executeQuery(sql)){
					
					//Etape3 : Traitement du résultat
					while (resultSet.next()) {
						
						Personnel personnel = new Personnel();
						
						personnel.setIdPersonnel(resultSet.getLong("idPersonnel"));
						personnel.setNomPersonnel(resultSet.getString("nomPersonnel"));
						personnel.setPrenomPersonnel(resultSet.getString("prenomPersonnel"));
						personnel.setTypePersonnel(resultSet.getString("typePersonnel"));
						personnel.setAdressePersonnel(resultSet.getString("adressePersonnel"));
						personnel.setTelPersonnel(resultSet.getInt("telPersonnel"));
						Date date = resultSet.getDate("dateEmbauche");
						personnel.setDateEmbauche(date.toLocalDate());
						Agence agence = new Agence();
						agence.setNumeroAgence(resultSet.getLong("numeroAgence"));
						personnel.setAgence(agence);
						
						listePersonnels.add(personnel);
					}
					
				} catch (Exception s) {
					log.info("Echec de la lecture de la table personnel.");
					log.error(s.getMessage());
				} finally {
					log.info("Requête de lecture de la table personnel exécuté avec succés.");
				}		
				
			}  catch (SQLException s) {
				log.info("Echec de la préparation de la liste des personnels.");
				log.error(s.getMessage());
			} finally {
				log.info("Préparation de la liste des personnels exécuté avec succés.");
			}

		
	return listePersonnels;
	}

	@Override
	public void modifier(Personnel e) {


		// Etape1 : Création de la requête
		
		String sql = "UPDATE personnel SET nomPersonnel  = ?, prenomPersonnel =? , typePersonnel =? , adressePersonnel =? , telPersonnel =? , dateEmbauche =? , numeroAgence =? WHERE idPersonnel=?";

		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {

			// Etape2 : transmission des valeurs aux paramètres de la requête
			
			preparedStatement.setString(1, e.getNomPersonnel());
			preparedStatement.setString(2, e.getPrenomPersonnel());
			preparedStatement.setString(3, e.getTypePersonnel());
			preparedStatement.setString(4, e.getAdressePersonnel());
			preparedStatement.setInt(5, e.getTelPersonnel());
			preparedStatement.setDate(6, Date.valueOf(e.getDateEmbauche()));
			preparedStatement.setLong(7, e.getAgence().getNumeroAgence());
			preparedStatement.setLong(8, e.getIdPersonnel());

			// Etape3 : exécution de la requête
			
			preparedStatement.executeUpdate();

		} catch (Exception s) {
			log.info("Echec de la modification des informations d'un enregistrement de personnel.");
			log.error(s.getMessage());
		} finally {
			log.info("Requête de modification d'un enregistrement de personnel exécuté avec succés.");
		}
	
		
	}

	@Override
	public void supprimer(Personnel e) {


		// IMPORTANT A COMPLETER AVEC AGENT ET CLIENT!!!

		// Etape1 : Création de la requête
		
		String sql = "DELETE FROM personnel where idPersonnel=?";

		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {

			// Etape2 : transmission de la valeur aux paramètres de la requête
			
			preparedStatement.setLong(1, e.getIdPersonnel());

			// Etape3 : exécution de la requête
			
			preparedStatement.executeUpdate();

		} catch (Exception s) {
			log.info("Echec de la suppression des informations d'un enregistrement de personnel.");
			log.error(s.getMessage());
		} finally {
			log.info("Requête de suppression d'un enregistrement de personnel exécuté avec succés.");
		}

	
		
	}

	@Override
	public Personnel dernierenregistrement() {
		// TODO Auto-generated method stub
		return null;
	}

}
