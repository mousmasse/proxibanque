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
import sn.objis.proxibanque.metier.CompteCourant;
import sn.objis.proxibanque.metier.Personnel;
import sn.objis.proxibanque.utils.MysqlConnexion;

/**
 * Classe IDaoCompteCourantImpl
 * 
 * @author Moustapha M. NDIAYE
 * @version 0.0.1-SNAPSHOT
 * @since 02/01/2019
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
		
		String sql = "INSERT INTO comptecourant VALUES(NULL,?,?,?,?);";
		
		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
			
			// Etape2 : transmission des valeurs aux param�tres de la requ�te

			preparedStatement.setDouble(1, e.getSoldeCourant());
			preparedStatement.setDate(2, Date.valueOf(e.getDateOuvertureCourant()));
			preparedStatement.setDouble(3, e.getDecouvert());
			preparedStatement.setLong(4, e.getClientCompteCourant().getIdClient());

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
		
		CompteCourant comptecourant = new CompteCourant();
		
		// Etape1 : Cr�ation de la requ�te

		String sql = "SELECT * FROM comptecourant where numeroCompteCourant = ?;";

		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {

			// Etape2 : transmission de la valeur aux param�tres de la requ�te
			preparedStatement.setLong(1, e.getNumeroCompteCourant());

			// Etape3 : ex�cution de la requ�te

			try (ResultSet resultSet = preparedStatement.executeQuery()) {

				// Etape3 : Traitement du r�sultat
				
				while (resultSet.next()) {

					comptecourant.setNumeroCompteCourant(resultSet.getLong("numeroCompteCourant"));
					comptecourant.setSoldeCourant(resultSet.getDouble("soldeCourant"));
					Date date = resultSet.getDate("dateOuvertureCourant");
					comptecourant.setDateOuvertureCourant((date.toLocalDate()));
					Client client = new Client();
					client.setIdClient(resultSet.getLong("idClient"));
					comptecourant.setClientCompteCourant(client);

				}

			} catch (Exception s) {
				log.info("Echec de la lecture des informations du compte courant.");
				log.error(s.getMessage());
			} finally {
				log.info("Requ�te de lecture des informations du compte courant ex�cut� avec succ�s.");
			}

		} catch (SQLException s) {
			log.info("Echec de l'execution de la requ�te de lecture des informations du compte courant.");
			log.error(s.getMessage());
		} finally {
			log.info("Execution de la requ�te de lecture des informations du compte courant ex�cut� avec succ�s.");
		}

		return comptecourant;

	
	}

	@Override
	public List<CompteCourant> lire() {

		List<CompteCourant> listeCompteCourant = new ArrayList<>();
		
		//Etape1 : Cr�ation de la requ�te
		String sql = "SELECT * FROM   comptecourant ;";

			try (Statement statement = connexion.createStatement()){
				//Etape2: Ex�cution de la requ�te

				try (ResultSet resultSet = statement.executeQuery(sql)){
					
					//Etape3 : Traitement du r�sultat
					while (resultSet.next()) {
						
						CompteCourant cmptCourant = new CompteCourant();
						
						cmptCourant.setNumeroCompteCourant(resultSet.getLong("numeroCompteCourant"));
						cmptCourant.setSoldeCourant(resultSet.getDouble("soldeCourant"));
						Date date = resultSet.getDate("dateOuvertureCourant");
						cmptCourant.setDateOuvertureCourant((date.toLocalDate()));
						Client client = new Client();
						client.setIdClient(resultSet.getLong("idClient"));
						cmptCourant.setClientCompteCourant(client);
						
						listeCompteCourant.add(cmptCourant);
					}
					
				} catch (Exception s) {
					log.info("Echec de la lecture de la table comptecourant.");
					log.error(s.getMessage());
				} finally {
					log.info("Requ�te de lecture de la table comptecourant ex�cut� avec succ�s.");
				}		
				
			}  catch (SQLException s) {
				log.info("Echec de la pr�paration de la liste des comptecourant.");
				log.error(s.getMessage());
			} finally {
				log.info("Pr�paration de la liste des comptecourant ex�cut� avec succ�s.");
			}

		
	return listeCompteCourant;
	
	}

	@Override
	public List<CompteCourant> lire(Personnel personnel) {

		List<CompteCourant> listeCompteCourant = new ArrayList<>();
		
		//Etape1 : Cr�ation de la requ�te
		String sql = "SELECT * FROM   comptecourant WHERE comptecourant.idClient = client.idClient AND client.idPersonnel=?;";

			try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)){
				//Etape2: Ex�cution de la requ�te
				
				preparedStatement.setLong(1, personnel.getIdPersonnel());

				try (ResultSet resultSet = preparedStatement.executeQuery(sql)){
					
					//Etape3 : Traitement du r�sultat
					while (resultSet.next()) {
						
						CompteCourant cmptCourant = new CompteCourant();
						
						cmptCourant.setNumeroCompteCourant(resultSet.getLong("numeroCompteCourant"));
						cmptCourant.setSoldeCourant(resultSet.getDouble("soldeCourant"));
						Date date = resultSet.getDate("dateOuvertureCourant");
						cmptCourant.setDateOuvertureCourant((date.toLocalDate()));
						Client client = new Client();
						client.setIdClient(resultSet.getLong("idClient"));
						cmptCourant.setClientCompteCourant(client);
						
						listeCompteCourant.add(cmptCourant);
					}
					
				} catch (Exception s) {
					log.info("Echec de la lecture de la table comptecourant.");
					log.error(s.getMessage());
				} finally {
					log.info("Requ�te de lecture de la table comptecourant ex�cut� avec succ�s.");
				}		
				
			}  catch (SQLException s) {
				log.info("Echec de la pr�paration de la liste des comptecourant.");
				log.error(s.getMessage());
			} finally {
				log.info("Pr�paration de la liste des comptecourant ex�cut� avec succ�s.");
			}

		
		return listeCompteCourant;
	
	}
	
	@Override
	public void modifier(CompteCourant e) {
		// Etape1 : Cr�ation de la requ�te
		
				String sql = "UPDATE comptecourant SET soldeCourant = ?, dateOuvertureCourant = ?, decouvert = ?, idClient = ? WHERE numeroCompteCourant = ?";

				try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {

					// Etape2 : transmission des valeurs aux param�tres de la requ�te
					
					preparedStatement.setDouble(1, e.getSoldeCourant());
					preparedStatement.setDate(2, Date.valueOf(e.getDateOuvertureCourant()));
					preparedStatement.setDouble(3, e.getDecouvert());
					preparedStatement.setLong(4, e.getClientCompteCourant().getIdClient());
					preparedStatement.setLong(5, e.getNumeroCompteCourant());

					// Etape3 : ex�cution de la requ�te
					
					preparedStatement.executeUpdate();

				} catch (Exception s) {
					log.info("Echec de la modification des informations du compte courant.");
					log.error(s.getMessage());
				} finally {
					log.info("Requ�te de modification du compte courant ex�cut� avec succ�s.");
				}
		
	}

	@Override
	public void supprimer(CompteCourant e) {
		
		// IMPORTANT A COMPLETER AVEC CARTE

				// Etape1 : Cr�ation de la requ�te
				
				String sql = "DELETE FROM comptecourant where numeroCompteCourant=?";

				try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {

					// Etape2 : transmission de la valeur aux param�tres de la requ�te
					
					preparedStatement.setLong(1, e.getNumeroCompteCourant());

					// Etape3 : ex�cution de la requ�te
					
					preparedStatement.executeUpdate();

				} catch (Exception s) {
					log.info("Echec de la suppression des informations du compte courant.");
					log.error(s.getMessage());
				} finally {
					log.info("Requ�te de suppression des informations du compte courant ex�cut� avec succ�s.");
				}
		
	}

	@Override
	public CompteCourant dernierenregistrement() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
