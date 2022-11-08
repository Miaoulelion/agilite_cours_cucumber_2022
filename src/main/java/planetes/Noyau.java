package planetes;


/**
 * Décrivez votre classe Noyau ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Noyau
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private Planete planete;
    /**
     * Constructeur d'objets de classe Noyau
     */
    public Noyau(Planete planete)
    {
    	this.setPlanete(planete);
        planete.setNoyau(this);
    }
    
    private void setPlanete(Planete planete){
        if(planete==null){
            throw new IllegalArgumentException("Il n'y a pas de planète, planète == null");
        }
        this.planete=planete;
        planete.setNoyau(this);
    }

    /**
     * Le noyau n'est pas visible. Son diamètre est approximé en fonction du diamètre de la planète
     * et de sa tempréature.
     * @return le diamètre approximé du noyau.
     */
    public int getDiametreApproximatif()
    {
        // Insérez votre code ici
        return (int)this.planete.getDiametreEtTemperatureMoyenne()[0]*(this.planete.getDiametreEtTemperatureMoyenne()[1]/5000);
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((planete == null) ? 0 : planete.hashCode());
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
		Noyau other = (Noyau) obj;
		if (planete == null) {
			if (other.planete != null)
				return false;
		} else if (!planete.equals(other.planete))
			return false;
		return true;
	}
}
