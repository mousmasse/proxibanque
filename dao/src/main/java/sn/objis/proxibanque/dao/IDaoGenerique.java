/**
 * 
 */
package sn.objis.proxibanque.dao;

import java.util.List;

/**
 * Interface IDaoGenerique 
 * @author Moustapha M. NDIAYE
 * @version 0.0.1-SNAPSHOT
 * @since 02/01/2019 
 */
public interface IDaoGenerique<E> {

	/**
	 * @param e : M�thode g�n�rique pour l'ajout d'informations 
	 */
	public void ajouter(E e);
	
	/**
	 * @param e : M�thode g�n�rique pour la consultation d'informations 
	 */
	public E lire(E e);
	
	/**
	 * @param e : M�thode g�n�rique pour la consultation d'informations 
	 */
	public List<E> lire();
	
	/**
	 * @param e : M�thode g�n�rique pour la modification d'informations 
	 */
	public void modifier(E e);
	
	/**
	 * @param e : M�thode g�n�rique pour la suppression d'informations 
	 */
	public void supprimer(E e);
	
	/**
	 * @param e : M�thode g�n�rique pour r�cup�rer le dernier enregistrement  
	 * @return 
	 */
	public  E  dernierenregistrement ();
	
}
