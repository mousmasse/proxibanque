/**
 * 
 */
package sn.objis.proxibanque.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



/**
 * Classe MysqlConnexion 
 * @author Moustapha M. NDIAYE
 * @version 0.0.1-SNAPSHOT
 * @since 02/01/2019 
 */
public class MysqlConnexion{
	
	static final Logger log = LogManager.getLogger(MysqlConnexion.class.getName());
	ClassLoader classloader = Thread.currentThread().getContextClassLoader();
	InputStream doc = classloader.getResourceAsStream("connection.properties");
	
	/*try {
		String result = IOUtils.toString(doc, StandardCharsets.UTF_8);
	}catch (IOException ex) {
	       log.error(ex.getMessage());
	    } finally {
	       
	    }*/
	
/*	String fileName = "connection.properties";
	//read file into stream, try-with-resources
			try(Stream<String> stream = Files.lines(Paths.get(fileName))) {
				stream.forEach(System.out::println);

			} catch (IOException e) {
				e.printStackTrace();
			}*/
			
	
	private static  String url="jdbc:mysql://localhost/gestionscolaire?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String userBd = "root";
	private static String pwdBd = "";
	private static Connection connexion = null;

	/**
	 * Constructeur privé pour entraver la création d'instance de la classe
	 */
	private MysqlConnexion() {
		super();
	}

	public static Connection getInstanceConnexion() {

		if (connexion==null) {

			try {
				connexion = DriverManager.getConnection(url, userBd, pwdBd);
				log.info("Connexion établie avec la base.");
				System.out.println();
			} catch (SQLException e) {
				log.info("Echéque de la tentative de connexion avec la base");
				log.error(e.getMessage());
			}

		}

		return connexion;

	}


}
