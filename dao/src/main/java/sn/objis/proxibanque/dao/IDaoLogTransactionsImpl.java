/**
 * 
 */
package sn.objis.proxibanque.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import sn.objis.proxibanque.metier.LogTransactions;
import sn.objis.proxibanque.utils.MysqlConnexion;

/**
 * @author Moustapha M. NDIAYE
 *
 */
public class IDaoLogTransactionsImpl implements IDaoLogTransactions{
	
	/**
	 * Obtention d'une instance de Logger
	 */
	static final Logger log = LogManager.getLogger(IDaoAgenceImpl.class.getName());

	/**
	 * Obtention de l'unique instance de connexion avec la base
	 */
	Connection connexion = MysqlConnexion.getInstanceConnexion();
	
	@Override
	public void transferer() {

		/* Etape1 : Cr�ation de la requ�te avec la fonctionnalit�  "TRANSACTION"
		 * TRANSACTION permet de regrouper des requ�tes dans des blocs, et de faire en sorte que 
		 * tout le bloc soit ex�cut� en une seule fois, cela afin de pr�server l'int�grit� des donn�es de la base.
		 * */
		
		String sql = "START TRANSACTION;"
				+ "INSERT logtransactions SELECT * FROM transactioncmpt;"
				+ "COMMIT;";

		try (Statement statement = connexion.createStatement()) {


			// Etape3 : ex�cution de la requ�te
			
			statement.execute(sql);

		} catch (Exception s) {
			log.info("Echec du transf�rer des informations de la table transactioncmpt.");
			log.error(s.getMessage());
		} finally {
			log.info("Requ�te de transf�re des informations de la table transactioncmpt ex�cut� avec succ�s.");
		}

	
		
	}

	@Override
	public void ajouter(LogTransactions e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LogTransactions lire(LogTransactions e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LogTransactions> lire() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifier(LogTransactions e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimer(LogTransactions e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LogTransactions dernierenregistrement() {
		// TODO Auto-generated method stub
		return null;
	}



}
