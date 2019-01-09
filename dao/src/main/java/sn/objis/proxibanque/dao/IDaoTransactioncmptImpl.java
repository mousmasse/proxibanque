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
import sn.objis.proxibanque.metier.CompteEpargne;
import sn.objis.proxibanque.metier.Personnel;
import sn.objis.proxibanque.metier.Transactioncmpt;
import sn.objis.proxibanque.utils.MysqlConnexion;

/**
 * Classe IDaoTransactioncmptImpl
 * 
 * @author Moustapha M. NDIAYE
 * @version 0.0.1-SNAPSHOT
 * @since 02/01/2019
 */
public class IDaoTransactioncmptImpl implements IDaoTransactioncmpt{
	
	/**
	 * Obtention d'une instance de Logger
	 */
	static final Logger log = LogManager.getLogger(IDaoAgenceImpl.class.getName());

	/**
	 * Obtention de l'unique instance de connexion avec la base
	 */
	Connection connexion = MysqlConnexion.getInstanceConnexion();


	@Override
	public void ajouter(Transactioncmpt e) {

		// Etape1 : Cr�ation de la requ�te
		String sql = "INSERT INTO transactioncmpt VALUES(NULL,?,?,?,?,?,?,?);";
		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
			// Etape2 : transmission des valeurs aux param�tres de la requ�te

			preparedStatement.setDate(1, Date.valueOf(e.getDateTransaction()));
			preparedStatement.setDouble(2, e.getMontantTransaction());
			preparedStatement.setString(3, e.getTypeOperation());
			preparedStatement.setLong(4, e.getNumeroComptDebiteur());
			preparedStatement.setLong(5, e.getNumeroCompteCrediteur());
			preparedStatement.setLong(6, e.getNumeroCompteCourant());
			preparedStatement.setLong(7, e.getNumeroCompteEpargne());

			// Etape3 : ex�cution de la requ�te

			preparedStatement.executeUpdate();
			
		} catch (SQLException s) {
			log.info("Echec de la cr�ation d'une transaction.");
			log.error(s.getMessage());
		} finally {
			log.info("Requ�te de cr�ation d'une transaction ex�cut� avec succ�s.");
		}

	
		
	}

	@Override
	public Transactioncmpt lire(Transactioncmpt e) {
		
		Transactioncmpt transaction = new Transactioncmpt();

		// Etape1 : Cr�ation de la requ�te

		String sql = "SELECT * FROM transactioncmpt where numeroTransaction = ?;";

		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {

			// Etape2 : transmission de la valeur aux param�tres de la requ�te
			preparedStatement.setLong(1, e.getNumeroTransaction());

			// Etape3 : ex�cution de la requ�te

			try (ResultSet resultSet = preparedStatement.executeQuery()) {

				// Etape3 : Traitement du r�sultat
				
				while (resultSet.next()) {

					transaction.setNumeroTransaction(resultSet.getLong("numeroTransaction"));
					Date date = resultSet.getDate("dateTransaction");
					transaction.setDateTransaction(date.toLocalDate());
					transaction.setMontantTransaction(resultSet.getDouble("montantTransaction"));
					transaction.setTypeOperation(resultSet.getString("typeOperation"));
					transaction.setNumeroComptDebiteur(resultSet.getLong("numeroComptDebiteur"));
					transaction.setNumeroCompteCrediteur(resultSet.getLong("numeroCompteCrediteur"));
					transaction.setNumeroCompteCourant(resultSet.getLong("numeroCompteCourant"));
					transaction.setNumeroCompteEpargne(resultSet.getLong("numeroCompteEpargne"));

				}

			} catch (Exception s) {
				log.info("Echec de la lecture d'une transaction.");
				log.error(s.getMessage());
			} finally {
				log.info("Requ�te de lecture d'une transaction ex�cut� avec succ�s.");
			}

		} catch (SQLException s) {
			log.info("Echec de l'execution de la requ�te de lecture d'une transaction.");
			log.error(s.getMessage());
		} finally {
			log.info("Execution de la requ�te de lecture d'une transaction ex�cut� avec succ�s.");
		}

		return transaction;

	}

	@Override
	public List<Transactioncmpt> lire() {
		
		List<Transactioncmpt> listeDesTransactions = new ArrayList<>();
		
		// Etape1 : Cr�ation de la requ�te

		String sql = "SELECT * FROM transactioncmpt ;";

		try (Statement statement = connexion.createStatement()) {

			// Etape2 : ex�cution de la requ�te

			try (ResultSet resultSet = statement.executeQuery(sql)) {

				// Etape3 : Traitement du r�sultat
				
				while (resultSet.next()) {
					
					Transactioncmpt transaction = new Transactioncmpt();
					
					transaction.setNumeroTransaction(resultSet.getLong("numeroTransaction"));
					Date date = resultSet.getDate("dateTransaction");
					transaction.setDateTransaction(date.toLocalDate());
					transaction.setMontantTransaction(resultSet.getDouble("montantTransaction"));
					transaction.setTypeOperation(resultSet.getString("typeOperation"));
					transaction.setNumeroComptDebiteur(resultSet.getLong("numeroComptDebiteur"));
					transaction.setNumeroCompteCrediteur(resultSet.getLong("numeroCompteCrediteur"));
					transaction.setNumeroCompteCourant(resultSet.getLong("numeroCompteCourant"));
					transaction.setNumeroCompteEpargne(resultSet.getLong("numeroCompteEpargne"));
					
					listeDesTransactions.add(transaction);

				}

			} catch (Exception s) {
				log.info("Echec de la lecture des transactions.");
				log.error(s.getMessage());
			} finally {
				log.info("Requ�te de lecture des transactions ex�cut� avec succ�s.");
			}

		} catch (SQLException s) {
			log.info("Echec de l'execution de la requ�te de lecture des transactions.");
			log.error(s.getMessage());
		} finally {
			log.info("Execution de la requ�te de lecture des transactions ex�cut� avec succ�s.");
		}

		return listeDesTransactions;

	}
	
	@Override
	public List<Transactioncmpt> lire(CompteEpargne compteEpargne) {

		
		List<Transactioncmpt> listeDesTransactions = new ArrayList<>();
		
		// Etape1 : Cr�ation de la requ�te

		String sql = "SELECT * FROM transactioncmpt  WHERE numeroCompteEpargne=? ;";

		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
			
			// Etape2 : transmission des valeurs aux param�tres de la requ�te
			
						preparedStatement.setLong(1, compteEpargne.getNumeroCompteEpargne());

			// Etape3 : ex�cution de la requ�te

			try (ResultSet resultSet = preparedStatement.executeQuery()) {

				// Etape3 : Traitement du r�sultat
				
				while (resultSet.next()) {
					
					Transactioncmpt transaction = new Transactioncmpt();
					
					transaction.setNumeroTransaction(resultSet.getLong("numeroTransaction"));
					Date date = resultSet.getDate("dateTransaction");
					transaction.setDateTransaction(date.toLocalDate());
					transaction.setMontantTransaction(resultSet.getDouble("montantTransaction"));
					transaction.setTypeOperation(resultSet.getString("typeOperation"));
					transaction.setNumeroComptDebiteur(resultSet.getLong("numeroComptDebiteur"));
					transaction.setNumeroCompteCrediteur(resultSet.getLong("numeroCompteCrediteur"));
					transaction.setNumeroCompteCourant(resultSet.getLong("numeroCompteCourant"));
					transaction.setNumeroCompteEpargne(resultSet.getLong("numeroCompteEpargne"));
					
					listeDesTransactions.add(transaction);

				}

			} catch (Exception s) {
				log.info("Echec de la lecture des transactions.");
				log.error(s.getMessage());
			} finally {
				log.info("Requ�te de lecture des transactions ex�cut� avec succ�s.");
			}

		} catch (SQLException s) {
			log.info("Echec de l'execution de la requ�te de lecture des transactions.");
			log.error(s.getMessage());
		} finally {
			log.info("Execution de la requ�te de lecture des transactions ex�cut� avec succ�s.");
		}

		return listeDesTransactions;

	
	}

	@Override
	public List<Transactioncmpt> lire(CompteCourant compteCourant) {


		
		List<Transactioncmpt> listeDesTransactions = new ArrayList<>();
		
		// Etape1 : Cr�ation de la requ�te

		String sql = "SELECT * FROM transactioncmpt  WHERE numeroCompteCourant=? ;";

		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
			
			// Etape2 : transmission des valeurs aux param�tres de la requ�te
			
						preparedStatement.setLong(1, compteCourant.getNumeroCompteCourant());

			// Etape3 : ex�cution de la requ�te

			try (ResultSet resultSet = preparedStatement.executeQuery()) {

				// Etape3 : Traitement du r�sultat
				
				while (resultSet.next()) {
					
					Transactioncmpt transaction = new Transactioncmpt();
					
					transaction.setNumeroTransaction(resultSet.getLong("numeroTransaction"));
					Date date = resultSet.getDate("dateTransaction");
					transaction.setDateTransaction(date.toLocalDate());
					transaction.setMontantTransaction(resultSet.getDouble("montantTransaction"));
					transaction.setTypeOperation(resultSet.getString("typeOperation"));
					transaction.setNumeroComptDebiteur(resultSet.getLong("numeroComptDebiteur"));
					transaction.setNumeroCompteCrediteur(resultSet.getLong("numeroCompteCrediteur"));
					transaction.setNumeroCompteCourant(resultSet.getLong("numeroCompteCourant"));
					transaction.setNumeroCompteEpargne(resultSet.getLong("numeroCompteEpargne"));
					
					listeDesTransactions.add(transaction);

				}

			} catch (Exception s) {
				log.info("Echec de la lecture des transactions.");
				log.error(s.getMessage());
			} finally {
				log.info("Requ�te de lecture des transactions ex�cut� avec succ�s.");
			}

		} catch (SQLException s) {
			log.info("Echec de l'execution de la requ�te de lecture des transactions.");
			log.error(s.getMessage());
		} finally {
			log.info("Execution de la requ�te de lecture des transactions ex�cut� avec succ�s.");
		}

		return listeDesTransactions;

	
	
	}
	
	@Override
	public List<Transactioncmpt> listetransactioncmptep(Personnel personnel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transactioncmpt> listetransactioncmptcr(Personnel personnel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transactioncmpt> listetransactioncmptep(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transactioncmpt> listetransactioncmptcr(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifier(Transactioncmpt e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimer(Transactioncmpt e) {


		// IMPORTANT A COMPLETER AVEC AGENT ET CLIENT!!!

		// Etape1 : Cr�ation de la requ�te
		
		String sql = "TRUNCATE TABLE transactioncmpt;";

		try (Statement statement = connexion.createStatement()) {

			

			// Etape2 : ex�cution de la requ�te
			
			statement.executeQuery(sql);

		} catch (Exception s) {
			log.info("Echec de l'effacement des informations de la table transaction.");
			log.error(s.getMessage());
		} finally {
			log.info("Requ�te de suppression des informations de la table transaction ex�cut� avec succ�s.");
		}

	
	}

	@Override
	public Transactioncmpt dernierenregistrement() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
