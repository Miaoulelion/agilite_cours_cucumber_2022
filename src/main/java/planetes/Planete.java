package planetes;

import java.util.LinkedList;

/**
 * La classe plan�te d�crit une plan�te et ses comportements
 * (Promis pas d'ast�ro�de)
 * @author Nicolas B. Anis H.
 * @version (un num�ro de version ou une date)
 */
public class Planete {
    // Variables d'instance repr�sentant les principales caract�ristiques 
    // d'une plan�te
    private int diametre;
    private int temperatureMoyenne;
    private Noyau noyau;
    private LinkedList<Satellite> satellites;

    /**
     * Constructeur d'objets de classe Planete
     */
    public Planete(int diametre, int temp)
    {
        // initialisation des variables d'instance
        this.diametre = diametre;
        this.temperatureMoyenne = temp;
        this.satellites = new LinkedList<>();
    }
    
    /**
     * Par d�faut les plan�tes sont tr�s petites et il y fait
     * plut�t chaud...
     */
    public Planete(){
        this.diametre=100;
        this.temperatureMoyenne=100;
        this.satellites = new LinkedList<>();
        
    }
    
    public Planete(int diametre, int temp, Noyau noyau){
        if(noyau==null){
            throw new IllegalArgumentException("Il n'y a pas de noyau, noyau == null");
        }
        this.diametre=diametre;
        this.temperatureMoyenne=temp;
        this.noyau=noyau;
        this.satellites = new LinkedList<>();
    }
    
    public void setNoyau(Noyau noyau){
        if(noyau==null){
            throw new IllegalArgumentException("Il n'y a pas de noyau, noyau == null");
        }
        this.noyau=noyau;
    }

    /**
     * Donne � l'utilisateur le diam�tre de l'instance de plan�te
     * @return     le diametre de la plan�te
     */
    public int getDiametre()
    {
        return this.diametre;
    }
    
    /**
     * Donne � l'utilisateur la temp�rature moyenne de l'instance
     * de plan�te
     * @return  la temp�rature moyenne de la plan�te
     */
    public int getTemperatureMoyenne(){
        return this.temperatureMoyenne;
    }
    
    /**
     * Parfois la temp�rature peut monter...
     * M�thode permettant de modifier la temp�rature de la plan�te
     */
    public void setTemperatureMoyenne(int temperature){
        this.temperatureMoyenne=temperature;
    }
    
    /**
     * Certaines plan�tes font un r�gime...
     * M�thode permettant de modifier le diam�tre de la plan�te
     */
    public void setDiametre(int diam){
        this.diametre=diam;
    }
    
    /**
     * Getter du noyau de la plan�te
     */
    public Noyau getNoyau(){
        return this.noyau;
    }
    
    /**
     * 
     * @return Un tableau de deux �l�ments, le premier �tant le diam�tre de la plan�te et le second la temp�rature moyenne.
     */
    
    public int[] getDiametreEtTemperatureMoyenne(){
        return new int[]{this.diametre,this.temperatureMoyenne};
    }

    /**
     * Ajoute un satellite autour d'une plan�te.
     * @param une Planete
     */
    
    public void ajouterSatellites(Satellite satelite) {
    	if(satelite == null) {
    		throw new IllegalArgumentException("Ajout de plan�te == null non valide");
    	}
    	this.satellites.add(satelite);
    }
    
	public LinkedList<Satellite> getSatellite() {
		return new LinkedList<Satellite>(this.satellites);
	}
	
	public void supprimerSatellite(Satellite satellite) {
		this.satellites.remove(satellite);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + diametre;
		result = prime * result + ((noyau == null) ? 0 : noyau.hashCode());
		result = prime * result + ((satellites == null) ? 0 : satellites.hashCode());
		result = prime * result + temperatureMoyenne;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planete other = (Planete) obj;
		if (diametre != other.diametre)
			return false;
		if (noyau == null) {
			if (other.noyau != null)
				return false;
		} else if (!noyau.equals(other.noyau))
			return false;
		if (satellites == null) {
			if (other.satellites != null)
				return false;
		} else if (!satellites.equals(other.satellites))
			return false;
		if (temperatureMoyenne != other.temperatureMoyenne)
			return false;
		return true;
	}


}