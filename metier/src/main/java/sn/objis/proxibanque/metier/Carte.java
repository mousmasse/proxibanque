/**
 * 
 */
package sn.objis.proxibanque.metier;

/**
 * Classe Carte 
 * @author Moustapha M. NDIAYE
 * @version 0.0.1-SNAPSHOT
 * @since 02/01/2019 
 */
public class Carte {
	
	private long numeroCarte;
	private String typeCarte;
	private double plafondDesRetraits;
	private double plafondDunRetrait;
	private boolean opositionCarte;
	private CompteCourant compteCourant;

	/**
	 * Constructeur sans paramètre
	 */
	public Carte() {
		super();
	}

	/**
	 * Constructeur avec paramètres
	 * @param numeroCarte
	 * @param typeCarte
	 * @param plafondDesRetraits
	 * @param plafondDunRetrait
	 * @param opositionCarte
	 * @param compteCourant
	 */
	public Carte(long numeroCarte, String typeCarte, double plafondDesRetraits, double plafondDunRetrait,
			boolean opositionCarte, CompteCourant compteCourant) {
		super();
		this.numeroCarte = numeroCarte;
		this.typeCarte = typeCarte;
		this.plafondDesRetraits = plafondDesRetraits;
		this.plafondDunRetrait = plafondDunRetrait;
		this.opositionCarte = opositionCarte;
		this.compteCourant = compteCourant;
	}

	/**
	 * @return the numeroCarte
	 */
	public long getNumeroCarte() {
		return numeroCarte;
	}

	/**
	 * @param numeroCarte the numeroCarte to set
	 */
	public void setNumeroCarte(long numeroCarte) {
		this.numeroCarte = numeroCarte;
	}

	/**
	 * @return the typeCarte
	 */
	public String getTypeCarte() {
		return typeCarte;
	}

	/**
	 * @param typeCarte the typeCarte to set
	 */
	public void setTypeCarte(String typeCarte) {
		this.typeCarte = typeCarte;
	}

	/**
	 * @return the plafondDesRetraits
	 */
	public double getPlafondDesRetraits() {
		return plafondDesRetraits;
	}

	/**
	 * @param plafondDesRetraits the plafondDesRetraits to set
	 */
	public void setPlafondDesRetraits(double plafondDesRetraits) {
		this.plafondDesRetraits = plafondDesRetraits;
	}

	/**
	 * @return the plafondDunRetrait
	 */
	public double getPlafondDunRetrait() {
		return plafondDunRetrait;
	}

	/**
	 * @param plafondDunRetrait the plafondDunRetrait to set
	 */
	public void setPlafondDunRetrait(double plafondDunRetrait) {
		this.plafondDunRetrait = plafondDunRetrait;
	}

	/**
	 * @return the opositionCarte
	 */
	public boolean isOpositionCarte() {
		return opositionCarte;
	}

	/**
	 * @param opositionCarte the opositionCarte to set
	 */
	public void setOpositionCarte(boolean opositionCarte) {
		this.opositionCarte = opositionCarte;
	}

	/**
	 * @return the compteCourant
	 */
	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	/**
	 * @param compteCourant the compteCourant to set
	 */
	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Carte :\nnumeroCarte=" + numeroCarte + ", \ntypeCarte=" + typeCarte + ", \nplafondDesRetraits="
				+ plafondDesRetraits + ", \nplafondDunRetrait=" + plafondDunRetrait + ", \nopositionCarte="
				+ opositionCarte + ", \ncompteCourant=" + compteCourant.toString() + ".";
	}
	
	
	

}
