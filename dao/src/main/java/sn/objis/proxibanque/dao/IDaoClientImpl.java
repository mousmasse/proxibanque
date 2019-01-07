/**
 * 
 */
package sn.objis.proxibanque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import sn.objis.proxibanque.metier.Agence;
import sn.objis.proxibanque.metier.Client;
import sn.objis.proxibanque.metier.Personnel;
import sn.objis.proxibanque.utils.MysqlConnexion;

/**
 * Classe IDaoClientImpl
 * 
 * @author Moustapha M. NDIAYE
 * @version 0.0.1-SNAPSHOT
 * @since 02/01/2019
 */
public class IDaoClientImpl implements IDaoClient{
	
	/**
	 * Obtention d'une instance de Logger
	 */
	static final Logger log = LogManager.getLogger(IDaoAgenceImpl.class.getName());

	/**
	 * Obtention de l'unique instance de connexion avec la base
	 */
	Connection connexion = MysqlConnexion.getInstanceConnexion();

	@Override
	public void ajouter(Client e) {

		// Etape1 : Cr�ation de la requ�te
		String sql = "INSERT INTO client VALUES(NULL,?,?,?,?,?,?,?,?,?,?);";
		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
			// Etape2 : transmission des valeurs aux param�tres de la requ�te

			preparedStatement.setString(1, e.getNomClient());
			preparedStatement.setString(2, e.getPrenomClient());
			preparedStatement.setString(3, e.getEmailClient());
			preparedStatement.setString(4, e.getAdresseClient());
			preparedStatement.setString(5, e.getVille());
			preparedStatement.setInt(6, e.getCodePostalClient());
			preparedStatement.setInt(7, e.getTelephone());
			preparedStatement.setString(8, e.getProfession());
			preparedStatement.setLong(9, e.getAgence().getNumeroAgence());
			preparedStatement.setLong(10, e.getConseiller().getIdPersonnel());

			// Etape3 : ex�cution de la requ�te

			preparedStatement.executeUpdate();
			
		} catch (SQLException s) {
			log.info("Echec de la cr�ation d'un client.");
			log.error(s.getMessage());
		} finally {
			log.info("Requ�te de cr�ation d'un client ex�cut� avec succ�s.");
		}	
	}

	@Override
	public Client lire(Client e) {

		Client client = new Client();
		// Etape1 : Cr�ation de la requ�te

		String sql = "SELECT * FROM client where idClient = ?;";

		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {

			// Etape2 : transmission de la valeur aux param�tres de la requ�te
			preparedStatement.setLong(1, e.getIdClient());

			// Etape3 : ex�cution de la requ�te

			try (ResultSet resultSet = preparedStatement.executeQuery()) {

				// Etape3 : Traitement du r�sultat
				
				while (resultSet.next()) {

					client.setIdClient(resultSet.getLong("idClient"));
					client.setNomClient(resultSet.getString("nomClient"));
					client.setPrenomClient(resultSet.getString("prenomClient"));
					client.setEmailClient(resultSet.getString("emailClient"));
					client.setAdresseClient(resultSet.getString("adresseClient"));
					client.setVille(resultSet.getString("ville "));
					client.setCodePostalClient(resultSet.getInt("codePostalClient "));
					client.setTelephone(resultSet.getInt("telephone "));
					client.setProfession(resultSet.getString("profession"));
					Agence agence = new Agence();
					agence.setNumeroAgence(resultSet.getLong("numeroAgence"));
					client.setAgence(agence);
					Personnel perso = new Personnel();
					perso.setIdPersonnel(resultSet.getLong("idPersonnel"));
					client.setConseiller(perso);
				}

			} catch (Exception s) {
				log.info("Echec de la lecture d'un client.");
				log.error(s.getMessage());
			} finally {
				log.info("Requ�te de lecture d'un client ex�cut� avec succ�s.");
			}

		} catch (SQLException s) {
			log.info("Echec de l'execution de la requ�te de lecture d'un client.");
			log.error(s.getMessage());
		} finally {
			log.info("Requ�te de lecture d'un client ex�cut� avec succ�s.");
		}

		return client;

	
	}

	@Override
	public List<Client> lire() {
		List<Client> listeClients = new ArrayList<>();
		//Etape1 : Cr�ation de la requ�te
		String sql = "SELECT * FROM client ;";

			try (Statement statement = connexion.createStatement()){
				//Etape2: Ex�cution de la requ�te

				try (ResultSet resultSet = statement.executeQuery(sql)){
					
					//Etape3 : Traitement du r�sultat
					while (resultSet.next()) {
						
						Client client = new Client();
						
						client.setIdClient(resultSet.getLong("idClient"));
						client.setNomClient(resultSet.getString("nomClient"));
						client.setPrenomClient(resultSet.getString("prenomClient"));
						client.setEmailClient(resultSet.getString("emailClient"));
						client.setAdresseClient(resultSet.getString("adresseClient"));
						client.setVille(resultSet.getString("ville "));
						client.setCodePostalClient(resultSet.getInt("codePostalClient "));
						client.setTelephone(resultSet.getInt("telephone "));
						client.setProfession(resultSet.getString("profession"));
						Agence agence = new Agence();
						agence.setNumeroAgence(resultSet.getLong("numeroAgence"));
						client.setAgence(agence);
						Personnel perso = new Personnel();
						perso.setIdPersonnel(resultSet.getLong("idPersonnel"));
						client.setConseiller(perso);
						
						listeClients.add(client);
					}
					
				} catch (Exception s) {
					log.info("Echec de la lecture de la table client.");
					log.error(s.getMessage());
				} finally {
					log.info("Requ�te de lecture de la table client ex�cut� avec succ�s.");
				}		
				
			}  catch (SQLException s) {
				log.info("Echec de la pr�paration de la liste des clients.");
				log.error(s.getMessage());
			} finally {
				log.info("Pr�paration de la liste des clients ex�cut� avec succ�s.");
			}

		
		return listeClients;
	}
	
	@Override
	public List<Client> lire(Personnel personnel) {

		List<Client> listeClients = new ArrayList<>();
		//Etape1 : Cr�ation de la requ�te
		String sql = "SELECT * FROM client where idPersonnel = ?;";

			try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)){
				//Etape2: Ex�cution de la requ�te
				
				preparedStatement.setLong(1, personnel.getIdPersonnel());

				try (ResultSet resultSet = preparedStatement.executeQuery(sql)){
					
					//Etape3 : Traitement du r�sultat
					while (resultSet.next()) {
						
						Client client = new Client();
						
						client.setIdClient(resultSet.getLong("idClient"));
						client.setNomClient(resultSet.getString("nomClient"));
						client.setPrenomClient(resultSet.getString("prenomClient"));
						client.setEmailClient(resultSet.getString("emailClient"));
						client.setAdresseClient(resultSet.getString("adresseClient"));
						client.setVille(resultSet.getString("ville "));
						client.setCodePostalClient(resultSet.getInt("codePostalClient "));
						client.setTelephone(resultSet.getInt("telephone "));
						client.setProfession(resultSet.getString("profession"));
						Agence agence = new Agence();
						agence.setNumeroAgence(resultSet.getLong("numeroAgence"));
						client.setAgence(agence);
						Personnel perso = new Personnel();
						perso.setIdPersonnel(resultSet.getLong("idPersonnel"));
						client.setConseiller(perso);
						
						listeClients.add(client);
					}
					
				} catch (Exception s) {
					log.info("Echec de la lecture de la table client.");
					log.error(s.getMessage());
				} finally {
					log.info("Requ�te de lecture de la table client ex�cut� avec succ�s.");
				}		
				
			}  catch (SQLException s) {
				log.info("Echec de la pr�paration de la liste des clients.");
				log.error(s.getMessage());
			} finally {
				log.info("Pr�paration de la liste des clients ex�cut� avec succ�s.");
			}

		
		return listeClients;
	
	}

	@Override
	public void modifier(Client e) {
		// Etape1 : Cr�ation de la requ�te
		
				String sql = "UPDATE client SET nomClient = ?, prenomClient = ?, emailClient = ?, adresseClient = ?, ville = ?, codePostalClient  = ?, telephone = ?, profession = ?, numeroAgence = ?, idPersonnel = ? WHERE idClient=?";

				try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {

					// Etape2 : transmission des valeurs aux param�tres de la requ�te
					
					preparedStatement.setString(1, e.getNomClient());
					preparedStatement.setString(2, e.getPrenomClient());
					preparedStatement.setString(3, e.getEmailClient());
					preparedStatement.setString(4, e.getAdresseClient());
					preparedStatement.setString(5, e.getVille());
					preparedStatement.setInt(6, e.getCodePostalClient());
					preparedStatement.setInt(7, e.getTelephone());
					preparedStatement.setString(8, e.getProfession());
					preparedStatement.setLong(9, e.getAgence().getNumeroAgence());
					preparedStatement.setLong(10, e.getConseiller().getIdPersonnel());
					preparedStatement.setLong(11, e.getIdClient());

					// Etape3 : ex�cution de la requ�te
					
					preparedStatement.executeUpdate();

				} catch (Exception s) {
					log.info("Echec de la modification des informations du client.");
					log.error(s.getMessage());
				} finally {
					log.info("Requ�te de modification du client ex�cut� avec succ�s.");
				}
		
	}

	@Override
	public void supprimer(Client e) {

		// Etape1 : Cr�ation de la requ�te
		
		String sql = "DELETE FROM client where idClient=?";

		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {

			// Etape2 : transmission de la valeur aux param�tres de la requ�te
			
			preparedStatement.setLong(1, e.getIdClient());

			// Etape3 : ex�cution de la requ�te
			
			preparedStatement.executeUpdate();

		} catch (Exception s) {
			log.info("Echec de la suppression des informations du client.");
			log.error(s.getMessage());
		} finally {
			log.info("Requ�te de suppression du client ex�cut� avec succ�s.");
		}

	
		
	}

	@Override
	public Client dernierenregistrement() {

		Client client = new Client();
		// Etape1 : Cr�ation de la requ�te

		String sql = "SELECT * FROM client where idClient = (SELECT MAX(idClient)  from client);";

		try (Statement statement = connexion.createStatement()) {

			// Etape3 : ex�cution de la requ�te

			try (ResultSet resultSet = statement.executeQuery(sql)) {

				// Etape3 : Traitement du r�sultat
				
				while (resultSet.next()) {

					client.setIdClient(resultSet.getLong("idClient"));
					client.setNomClient(resultSet.getString("nomClient"));
					client.setPrenomClient(resultSet.getString("prenomClient"));
					client.setEmailClient(resultSet.getString("emailClient"));
					client.setAdresseClient(resultSet.getString("adresseClient"));
					client.setVille(resultSet.getString("ville "));
					client.setCodePostalClient(resultSet.getInt("codePostalClient "));
					client.setTelephone(resultSet.getInt("telephone "));
					client.setProfession(resultSet.getString("profession"));
					Agence agence = new Agence();
					agence.setNumeroAgence(resultSet.getLong("numeroAgence"));
					client.setAgence(agence);
					Personnel perso = new Personnel();
					perso.setIdPersonnel(resultSet.getLong("idPersonnel"));
					client.setConseiller(perso);
				}

			} catch (Exception s) {
				log.info("Echec de la lecture du dernier client.");
				log.error(s.getMessage());
			} finally {
				log.info("Requ�te de lecture du dernier client ex�cut� avec succ�s.");
			}

		} catch (SQLException s) {
			log.info("Echec de l'execution de la requ�te de lecture du dernier client.");
			log.error(s.getMessage());
		} finally {
			log.info("Requ�te de lecture du dernier client ex�cut� avec succ�s.");
		}

		return client;

	
	
	}

	

}
