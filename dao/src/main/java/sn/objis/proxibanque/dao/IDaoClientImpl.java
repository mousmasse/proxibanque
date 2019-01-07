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

		// Etape1 : Création de la requête
		String sql = "INSERT INTO client VALUES(NULL,?,?,?,?,?,?,?,?,?,?);";
		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
			// Etape2 : transmission des valeurs aux paramètres de la requête

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

			// Etape3 : exécution de la requête

			preparedStatement.executeUpdate();
			
		} catch (SQLException s) {
			log.info("Echec de la création d'un client.");
			log.error(s.getMessage());
		} finally {
			log.info("Requête de création d'un client exécuté avec succés.");
		}	
	}

	@Override
	public Client lire(Client e) {

		Client client = new Client();
		// Etape1 : Création de la requête

		String sql = "SELECT * FROM client where idClient = ?;";

		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {

			// Etape2 : transmission de la valeur aux paramètres de la requête
			preparedStatement.setLong(1, e.getIdClient());

			// Etape3 : exécution de la requête

			try (ResultSet resultSet = preparedStatement.executeQuery()) {

				// Etape3 : Traitement du résultat
				
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
				log.info("Requête de lecture d'un client exécuté avec succés.");
			}

		} catch (SQLException s) {
			log.info("Echec de l'execution de la requête de lecture d'un client.");
			log.error(s.getMessage());
		} finally {
			log.info("Requête de lecture d'un client exécuté avec succés.");
		}

		return client;

	
	}

	@Override
	public List<Client> lire() {
		List<Client> listeClients = new ArrayList<>();
		//Etape1 : Création de la requête
		String sql = "SELECT * FROM client ;";

			try (Statement statement = connexion.createStatement()){
				//Etape2: Exécution de la requête

				try (ResultSet resultSet = statement.executeQuery(sql)){
					
					//Etape3 : Traitement du résultat
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
					log.info("Requête de lecture de la table client exécuté avec succés.");
				}		
				
			}  catch (SQLException s) {
				log.info("Echec de la préparation de la liste des clients.");
				log.error(s.getMessage());
			} finally {
				log.info("Préparation de la liste des clients exécuté avec succés.");
			}

		
		return listeClients;
	}
	
	@Override
	public List<Client> lire(Personnel personnel) {

		List<Client> listeClients = new ArrayList<>();
		//Etape1 : Création de la requête
		String sql = "SELECT * FROM client where idPersonnel = ?;";

			try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)){
				//Etape2: Exécution de la requête
				
				preparedStatement.setLong(1, personnel.getIdPersonnel());

				try (ResultSet resultSet = preparedStatement.executeQuery(sql)){
					
					//Etape3 : Traitement du résultat
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
					log.info("Requête de lecture de la table client exécuté avec succés.");
				}		
				
			}  catch (SQLException s) {
				log.info("Echec de la préparation de la liste des clients.");
				log.error(s.getMessage());
			} finally {
				log.info("Préparation de la liste des clients exécuté avec succés.");
			}

		
		return listeClients;
	
	}

	@Override
	public void modifier(Client e) {
		// Etape1 : Création de la requête
		
				String sql = "UPDATE client SET nomClient = ?, prenomClient = ?, emailClient = ?, adresseClient = ?, ville = ?, codePostalClient  = ?, telephone = ?, profession = ?, numeroAgence = ?, idPersonnel = ? WHERE idClient=?";

				try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {

					// Etape2 : transmission des valeurs aux paramètres de la requête
					
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

					// Etape3 : exécution de la requête
					
					preparedStatement.executeUpdate();

				} catch (Exception s) {
					log.info("Echec de la modification des informations du client.");
					log.error(s.getMessage());
				} finally {
					log.info("Requête de modification du client exécuté avec succés.");
				}
		
	}

	@Override
	public void supprimer(Client e) {

		// Etape1 : Création de la requête
		
		String sql = "DELETE FROM client where idClient=?";

		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {

			// Etape2 : transmission de la valeur aux paramètres de la requête
			
			preparedStatement.setLong(1, e.getIdClient());

			// Etape3 : exécution de la requête
			
			preparedStatement.executeUpdate();

		} catch (Exception s) {
			log.info("Echec de la suppression des informations du client.");
			log.error(s.getMessage());
		} finally {
			log.info("Requête de suppression du client exécuté avec succés.");
		}

	
		
	}

	@Override
	public Client dernierenregistrement() {

		Client client = new Client();
		// Etape1 : Création de la requête

		String sql = "SELECT * FROM client where idClient = (SELECT MAX(idClient)  from client);";

		try (Statement statement = connexion.createStatement()) {

			// Etape3 : exécution de la requête

			try (ResultSet resultSet = statement.executeQuery(sql)) {

				// Etape3 : Traitement du résultat
				
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
				log.info("Requête de lecture du dernier client exécuté avec succés.");
			}

		} catch (SQLException s) {
			log.info("Echec de l'execution de la requête de lecture du dernier client.");
			log.error(s.getMessage());
		} finally {
			log.info("Requête de lecture du dernier client exécuté avec succés.");
		}

		return client;

	
	
	}

	

}
