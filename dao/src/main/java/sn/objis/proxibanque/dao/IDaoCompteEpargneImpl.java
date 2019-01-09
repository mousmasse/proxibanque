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

import sn.objis.proxibanque.metier.Client;
import sn.objis.proxibanque.metier.CompteEpargne;
import sn.objis.proxibanque.metier.Personnel;
import sn.objis.proxibanque.utils.MysqlConnexion;

/**
 * Classe IDaoCompteEpargneImpl
 * 
 * @author Moustapha M. NDIAYE
 * @version 0.0.1-SNAPSHOT
 * @since 02/01/2019
 */
public class IDaoCompteEpargneImpl implements IDaoCompteEpargne{

	/**
	 * Obtention d'une instance de Logger
	 */
	static final Logger log = LogManager.getLogger(IDaoAgenceImpl.class.getName());

	/**
	 * Obtention de l'unique instance de connexion avec la base
	 */
	Connection connexion = MysqlConnexion.getInstanceConnexion();

	@Override
	public void ajouter(CompteEpargne e) {

		// Etape1 : Création de la requête

		String sql = "INSERT INTO compteepargne VALUES(NULL,?,?,?,?);";

		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {

			// Etape2 : transmission des valeurs aux paramètres de la requête

			preparedStatement.setDouble(1, e.getSoldeEpargne());
			preparedStatement.setDate(2, Date.valueOf(e.getDateOuvertureEpargne()));
			preparedStatement.setDouble(3, e.getTaux());
			preparedStatement.setLong(4, e.getClientCompteEpargne().getIdClient());

			// Etape3 : exécution de la requête

			preparedStatement.executeUpdate();

		} catch (SQLException s) {
			log.info("Echec de la création du compte epargne.");
			log.error(s.getMessage());
		} finally {
			log.info("Requête de création du compte epargne exécuté avec succés.");
		}



	}

	@Override
	public CompteEpargne lire(CompteEpargne e) {

		CompteEpargne compteepargne = new CompteEpargne();

		// Etape1 : Création de la requête

		String sql = "SELECT * FROM compteepargne where numeroCompteEpargne = ?;";

		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {

			// Etape2 : transmission de la valeur aux paramètres de la requête
			preparedStatement.setLong(1, e.getNumeroCompteEpargne());

			// Etape3 : exécution de la requête

			try (ResultSet resultSet = preparedStatement.executeQuery()) {

				// Etape3 : Traitement du résultat

				while (resultSet.next()) {

					compteepargne.setNumeroCompteEpargne(resultSet.getLong("numeroCompteCourant"));
					compteepargne.setSoldeEpargne(resultSet.getDouble("soldeCourant"));
					Date date = resultSet.getDate("dateOuvertureEpargne");
					compteepargne.setDateOuvertureEpargne((date.toLocalDate()));
					compteepargne.setTaux(resultSet.getDouble("taux"));
					Client client = new Client();
					client.setIdClient(resultSet.getLong("idClient"));
					compteepargne.setClientCompteEpargne(client);

				}

			} catch (Exception s) {
				log.info("Echec de la lecture des informations du compte epargne.");
				log.error(s.getMessage());
			} finally {
				log.info("Requête de lecture des informations du compte epargne exécuté avec succés.");
			}

		} catch (SQLException s) {
			log.info("Echec de l'execution de la requête de lecture des informations du compte epargne.");
			log.error(s.getMessage());
		} finally {
			log.info("Execution de la requête de lecture des informations du compte epargne exécuté avec succés.");
		}

		return compteepargne;


	}

	@Override
	public List<CompteEpargne> lire() {


		List<CompteEpargne> listeCompteEpargne = new ArrayList<>();

		//Etape1 : Création de la requête
		String sql = "SELECT * FROM   compteepargne ;";

		try (Statement statement = connexion.createStatement()){
			//Etape2: Exécution de la requête

			try (ResultSet resultSet = statement.executeQuery(sql)){

				//Etape3 : Traitement du résultat
				while (resultSet.next()) {

					CompteEpargne compteEpargne = new CompteEpargne();

					compteEpargne.setNumeroCompteEpargne(resultSet.getLong("numeroCompteCourant"));
					compteEpargne.setSoldeEpargne(resultSet.getDouble("soldeCourant"));
					Date date = resultSet.getDate("dateOuvertureEpargne");
					compteEpargne.setDateOuvertureEpargne((date.toLocalDate()));
					compteEpargne.setTaux(resultSet.getDouble("taux"));
					Client client = new Client();
					client.setIdClient(resultSet.getLong("idClient"));
					compteEpargne.setClientCompteEpargne(client);

					listeCompteEpargne.add(compteEpargne);
				}

			} catch (Exception s) {
				log.info("Echec de la lecture de la table compteepargne.");
				log.error(s.getMessage());
			} finally {
				log.info("Requête de lecture de la table compteepargne exécuté avec succés.");
			}		

		}  catch (SQLException s) {
			log.info("Echec de la préparation de la liste des compteepargne.");
			log.error(s.getMessage());
		} finally {
			log.info("Préparation de la liste des compteepargne exécuté avec succés.");
		}


		return listeCompteEpargne;

	}

	@Override
	public List<CompteEpargne> lire(Personnel personnel) {

		List<CompteEpargne> listeCompteEpargne = new ArrayList<>();

		//Etape1 : Création de la requête
		String sql = "SELECT * FROM  compteepargne, client WHERE compteepargne.idClient = client.idClient AND client.idPersonnel=?;";

		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)){
			//Etape2: Exécution de la requête

			preparedStatement.setLong(1, personnel.getIdPersonnel());

			try (ResultSet resultSet = preparedStatement.executeQuery(sql)){

				//Etape3 : Traitement du résultat
				while (resultSet.next()) {

					CompteEpargne compteEpargne = new CompteEpargne();

					compteEpargne.setNumeroCompteEpargne(resultSet.getLong("numeroCompteCourant"));
					compteEpargne.setSoldeEpargne(resultSet.getDouble("soldeCourant"));
					Date date = resultSet.getDate("dateOuvertureEpargne");
					compteEpargne.setDateOuvertureEpargne((date.toLocalDate()));
					compteEpargne.setTaux(resultSet.getDouble("taux"));
					Client client = new Client();
					client.setIdClient(resultSet.getLong("idClient"));
					compteEpargne.setClientCompteEpargne(client);

					listeCompteEpargne.add(compteEpargne);
				}

			} catch (Exception s) {
				log.info("Echec de la lecture de la table compteepargne.");
				log.error(s.getMessage());
			} finally {
				log.info("Requête de lecture de la table compteepargne exécuté avec succés.");
			}		

		}  catch (SQLException s) {
			log.info("Echec de la préparation de la liste des compteepargne.");
			log.error(s.getMessage());
		} finally {
			log.info("Préparation de la liste des compteepargne exécuté avec succés.");
		}


		return listeCompteEpargne;


	}

	@Override
	public void modifier(CompteEpargne e) {

		// Etape1 : Création de la requête

		String sql = "UPDATE comptecourant SET soldeEpargne = ?, dateOuvertureEpargne = ?, taux = ?, idClient = ? WHERE numeroCompteEpargne = ?";

		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {

			// Etape2 : transmission des valeurs aux paramètres de la requête

			preparedStatement.setDouble(1, e.getSoldeEpargne());
			preparedStatement.setDate(2, Date.valueOf(e.getDateOuvertureEpargne()));
			preparedStatement.setDouble(3, e.getTaux());
			preparedStatement.setLong(4, e.getClientCompteEpargne().getIdClient());
			preparedStatement.setLong(5, e.getNumeroCompteEpargne());

			// Etape3 : exécution de la requête

			preparedStatement.executeUpdate();

		} catch (Exception s) {
			log.info("Echec de la modification des informations du compte epargne.");
			log.error(s.getMessage());
		} finally {
			log.info("Requête de modification du compte epargne exécuté avec succés.");
		}


	}

	@Override
	public void supprimer(CompteEpargne e) {

		// IMPORTANT A COMPLETER AVEC CARTE

		// Etape1 : Création de la requête

		String sql = "DELETE FROM compteepargne where numeroCompteEpargne=?";

		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {

			// Etape2 : transmission de la valeur aux paramètres de la requête

			preparedStatement.setLong(1, e.getNumeroCompteEpargne());

			// Etape3 : exécution de la requête

			preparedStatement.executeUpdate();

		} catch (Exception s) {
			log.info("Echec de la suppression des informations du compte epargne.");
			log.error(s.getMessage());
		} finally {
			log.info("Requête de suppression des informations du compte epargne exécuté avec succés.");
		}

	}

	@Override
	public CompteEpargne dernierenregistrement() {
		// TODO Auto-generated method stub
		return null;
	}



}
