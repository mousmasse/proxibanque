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

import sn.objis.proxibanque.metier.Carte;
import sn.objis.proxibanque.metier.CompteCourant;
import sn.objis.proxibanque.utils.MysqlConnexion;

/**
 * Classe IDaoCarteImpl
 * 
 * @author Moustapha M. NDIAYE
 * @version 0.0.1-SNAPSHOT
 * @since 02/01/2019
 */
public class IDaoCarteImpl implements IDaoCarte {
	
	/**
	 * Obtention d'une instance de Logger
	 */
	static final Logger log = LogManager.getLogger(IDaoCarteImpl.class.getName());

	/**
	 * Obtention de l'unique instance de connexion avec la base
	 */
	Connection connexion = MysqlConnexion.getInstanceConnexion();

	@Override
	public void ajouter(Carte e) {
		// Etape1 : Création de la requête
		String sql = "INSERT INTO carte VALUES(NULL,?,?,?,?,?)";
		try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
			// Etape2 : transmission des valeurs aux paramètres de la requête

			preparedStatement.setString(1, e.getTypeCarte());
			preparedStatement.setDouble(2, e.getPlafondDesRetraits());
			preparedStatement.setDouble(3, e.getPlafondDunRetrait());
			preparedStatement.setBoolean(4, e.isOpositionCarte());
			preparedStatement.setLong(5, e.getCompteCourant().getNumeroCompteCourant());
			

			// Etape3 : exécution de la requête

			preparedStatement.executeUpdate();

		} catch (SQLException s) {
			log.info("Echec de l'ajout d'une carte.");
			log.error(s.getMessage());
		} finally {
			log.info("Requête d'ajout d'une carte exécuté avec succés.");
		}

	}

	@Override
	public Carte lire(Carte e) {
		Carte carte = new Carte();
		// Etape1 : Création de la requête

				String sql = "SELECT * FROM carte where numeroCarte = ?";

				try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {

					// Etape2 : transmission de la valeur aux paramètres de la requête
					preparedStatement.setLong(1, e.getNumeroCarte());

					// Etape3 : exécution de la requête

					try (ResultSet resultSet = preparedStatement.executeQuery()) {

						// Etape3 : Traitement du résultat
						
						while (resultSet.next()) {
							
							CompteCourant cmptCourant = new CompteCourant();
							
							carte.setNumeroCarte(resultSet.getLong("numeroCarte"));
							carte.setTypeCarte(resultSet.getString("typeCarte"));
							carte.setPlafondDesRetraits(resultSet.getDouble("plafondDesRetraits"));
							carte.setPlafondDunRetrait(resultSet.getDouble("plafondDunRetrait"));
							carte.setOpositionCarte(resultSet.getBoolean("opositionCarte"));
							cmptCourant.setNumeroCompteCourant(resultSet.getLong("numeroCompteCourant"));
							carte.setCompteCourant(cmptCourant);
						}

					} catch (Exception s) {
						log.info("Echec de la lecture d'une carte.");
						log.error(s.getMessage());
					} finally {
						log.info("Requête de lecture d'une carte exécuté avec succés.");
					}

				} catch (SQLException s) {
					log.info("Echec de l'execution de la requête de lecture d'une carte.");
					log.error(s.getMessage());
				} finally {
					log.info("Execution de la requête de lecture d'une carte exécuté avec succés.");
				}

				return carte;
	}

	@Override
	public List<Carte> lire() {
		List<Carte> listeCarte = new ArrayList<>();
		
		//Etape1 : Création de la requête
				String sql = "SELECT * FROM carte ;";

					try (Statement statement = connexion.createStatement()){
						//Etape2: Exécution de la requête

						try (ResultSet resultSet = statement.executeQuery(sql)){
							
							//Etape3 : Traitement du résultat
							while (resultSet.next()) {
								
								Carte carte = new Carte();
								
								CompteCourant cmptCourant = new CompteCourant();
								
								carte.setNumeroCarte(resultSet.getLong("numeroCarte"));
								carte.setTypeCarte(resultSet.getString("typeCarte"));
								carte.setPlafondDesRetraits(resultSet.getDouble("plafondDesRetraits"));
								carte.setPlafondDunRetrait(resultSet.getDouble("plafondDunRetrait"));
								carte.setOpositionCarte(resultSet.getBoolean("opositionCarte"));
								cmptCourant.setNumeroCompteCourant(resultSet.getLong("numeroCompteCourant"));
								carte.setCompteCourant(cmptCourant);
								
								listeCarte.add(carte);
							}
							
						} catch (Exception s) {
							log.info("Echec de la lecture de la table carte.");
							log.error(s.getMessage());
						} finally {
							log.info("Requête de lecture de la table carte exécuté avec succés.");
						}		
						
					}  catch (SQLException s) {
						log.info("Echec de la préparation de la liste des agences.");
						log.error(s.getMessage());
					} finally {
						log.info("Préparation de la liste des agences exécuté avec succés.");
					}

				
			return listeCarte;
	}

	@Override
	public void modifier(Carte e) {
		// Etape1 : Création de la requête
		
				String sql = "UPDATE carte SET typeCarte  = ?, plafondDesRetraits =?, plafondDunRetrait =?, opositionCarte =?, numeroCompteCourant =?  WHERE numeroCarte=?";

				try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {

					// Etape2 : transmission des valeurs aux paramètres de la requête
					
					preparedStatement.setString(1, e.getTypeCarte());
					preparedStatement.setDouble(2, e.getPlafondDesRetraits());
					preparedStatement.setDouble(3, e.getPlafondDunRetrait());
					preparedStatement.setBoolean(4, e.isOpositionCarte());
					preparedStatement.setLong(5, e.getCompteCourant().getNumeroCompteCourant());
					preparedStatement.setLong(6, e.getNumeroCarte());

					// Etape3 : exécution de la requête
					
					preparedStatement.executeUpdate();

				} catch (Exception s) {
					log.info("Echec de la modification des informations de la carte.");
					log.error(s.getMessage());
				} finally {
					log.info("Requête de modification de la carte exécuté avec succés.");
				}
		
	}

	@Override
	public void supprimer(Carte e) {
		
		// IMPORTANT A COMPLETER AVEC AGENT ET CLIENT!!!

				// Etape1 : Création de la requête
				
				String sql = "DELETE FROM carte where numeroCarte=?";

				try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {

					// Etape2 : transmission de la valeur aux paramètres de la requête
					
					preparedStatement.setLong(1, e.getNumeroCarte());

					// Etape3 : exécution de la requête
					
					preparedStatement.executeUpdate();

				} catch (Exception s) {
					log.info("Echec de la suppression des informations de la carte.");
					log.error(s.getMessage());
				} finally {
					log.info("Requête de suppression de la carte exécuté avec succés.");
				}

		
	}

	@Override
	public Carte dernierenregistrement() {
		// TODO Auto-generated method stub
		return null;
	}


}
