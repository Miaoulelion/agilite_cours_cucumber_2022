package planetes;

import java.util.LinkedList;

/**
 * La classe planète décrit une planète et ses comportements
 * (Promis pas d'astéroïde)
 * @author Nicolas B. Anis H.
 * @version (un numéro de version ou une date)
 */
public class Planete {
    // Variables d'instance représentant les principales caractéristiques 
    // d'une planète
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
     * Par défaut les planètes sont très petites et il y fait
     * plutôt chaud...
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
     * Donne à l'utilisateur le diamètre de l'instance de planète
     * @return     le diametre de la planète
     */
    public int getDiametre()
    {
        return this.diametre;
    }
    
    /**
     * Donne à l'utilisateur la température moyenne de l'instance
     * de planète
     * @return  la température moyenne de la planète
     */
    public int getTemperatureMoyenne(){
        return this.temperatureMoyenne;
    }
    
    /**
     * Parfois la température peut monter...
     * Méthode permettant de modifier la température de la planète
     */
    public void setTemperatureMoyenne(int temperature){
        this.temperatureMoyenne=temperature;
    }
    
    /**
     * Certaines planètes font un régime...
     * Méthode permettant de modifier le diamètre de la planète
     */
    public void setDiametre(int diam){
        this.diametre=diam;
    }
    
    /**
     * Getter du noyau de la planète
     */
    public Noyau getNoyau(){
        return this.noyau;
    }
    
    /**
     * 
     * @return Un tableau de deux éléments, le premier étant le diamètre de la planète et le second la température moyenne.
     */
    
    public int[] getDiametreEtTemperatureMoyenne(){
        return new int[]{this.diametre,this.temperatureMoyenne};
    }

    /**
     * Ajoute un satellite autour d'une planète.
     * @param une Planete
     */
    
    public void ajouterSatellites(Satellite satelite) {
    	if(satelite == null) {
    		throw new IllegalArgumentException("Ajout de planète == null non valide");
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
