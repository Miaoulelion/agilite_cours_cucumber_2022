package planetes;

public class Satellite {
	private Planete planete;
	private String nom;
	
	public Satellite(Planete planete, String nom) {
		this.setPlanete(planete);
		this.nom = nom;
	}

	public void setPlanete(Planete planete) {
		if(planete == null) {
			throw new IllegalArgumentException("Une satelite ne peut avoir une planete == null");
		}
		this.planete = planete;
		//Il se peut que ce satellite appartienne déjà à une planète, il ne faudrait pas qu'il 
		//appartienne deux fois à cette planète.
		if(!planete.getSatellite().contains(this)) {
			planete.ajouterSatellites(this);
		}
	}
	
	public Planete getPlanete() {
		return this.planete;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
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
		Satellite other = (Satellite) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (planete == null) {
			if (other.planete != null)
				return false;
		} else if (!planete.equals(other.planete))
			return false;
		return true;
	}
	
	
}
