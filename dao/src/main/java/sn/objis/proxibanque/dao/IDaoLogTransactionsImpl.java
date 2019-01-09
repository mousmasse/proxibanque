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

		/* Etape1 : Création de la requête avec la fonctionnalité  "TRANSACTION"
		 * TRANSACTION permet de regrouper des requêtes dans des blocs, et de faire en sorte que 
		 * tout le bloc soit exécuté en une seule fois, cela afin de préserver l'intégrité des données de la base.
		 * */
		
		String sql = "START TRANSACTION;"
				+ "INSERT logtransactions SELECT * FROM transactioncmpt;"
				+ "COMMIT;";

		try (Statement statement = connexion.createStatement()) {


			// Etape3 : exécution de la requête
			
			statement.execute(sql);

		} catch (Exception s) {
			log.info("Echec du transférer des informations de la table transactioncmpt.");
			log.error(s.getMessage());
		} finally {
			log.info("Requête de transfére des informations de la table transactioncmpt exécuté avec succés.");
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
