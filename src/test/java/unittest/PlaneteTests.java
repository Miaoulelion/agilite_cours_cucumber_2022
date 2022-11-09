package unittest;

import static org.junit.Assert.*;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import planetes.Noyau;
import planetes.Planete;
import planetes.Satellite;

public class PlaneteTests {

    private Planete planeteTerre;
    @SuppressWarnings("unused")
	private Noyau noyauDeLaTerre;
    private Satellite lune;

    // D�finissez ici les variables d'instance n�cessaires � vos engagements;
    // Vous pouvez �galement les saisir automatiquement du pr�sentoir
    // � l'aide du menu contextuel "Pr�sentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du pr�sentoir (les objets sans constructeur, comme int, float, etc.).
    

    /**
     * Met en place les engagements.
     *
     * M�thode appel�e avant chaque appel de m�thode de test.
     */
    @Before
    public void setUp() {
        this.planeteTerre = new Planete();
        this.noyauDeLaTerre = new Noyau(planeteTerre);
        this.lune = new Satellite(planeteTerre, "lune");
    }
    
    @Test
    public void diametreEtTemperatureTest(){
        assertEquals(100,this.planeteTerre.getDiametre());
        assertEquals(100,this.planeteTerre.getTemperatureMoyenne());
        this.planeteTerre.setDiametre(50);
        this.planeteTerre.setTemperatureMoyenne(25);
        assertEquals(50,this.planeteTerre.getDiametre());
        assertEquals(25,this.planeteTerre.getTemperatureMoyenne());
    }
    
    @Test
    public void diametreApproximatifNoyauTest(){
    	int diamApproximatif = 0;
    	//Dans le cas d'une plan�te "standard" : 
        if(this.planeteTerre.getDiametre() == 50 && this.planeteTerre.getTemperatureMoyenne() == 25){
        	
        	diamApproximatif = (int)50*(25/5000);
        
        	assertEquals(diamApproximatif, this.planeteTerre.getNoyau().getDiametreApproximatif());
        } else { //Dans le cas d'une plan�te "personnalis�e" :
        	
        	int diametrePlanete = this.planeteTerre.getDiametreEtTemperatureMoyenne()[0];
        	int temperaturePlanete = this.planeteTerre.getDiametreEtTemperatureMoyenne()[1];
        	diamApproximatif = temperaturePlanete * (diametrePlanete / 5000);
        	
            assertEquals(diamApproximatif, this.planeteTerre.getNoyau().getDiametreApproximatif());
        }
    }
    
    
    @Test
    public void satellitesDesPlanetesTest() {
    	//On retourne les satellites de la terre
    	LinkedList<Satellite> listeDesSatellites = this.planeteTerre.getSatellite();
    	listeDesSatellites.remove();
    	assertTrue(listeDesSatellites.size() == 0);
    	
    	//On v�rifie que la suppression d'un satellite de la LinkedList ne supprime pas
    	//r�ellement le satellite, des satellites de la terre. Il ne faut pas donner de si
    	//grands pouvoirs entre toutes les mains !
    	LinkedList<Satellite> listeDesSatellitesNonModifiees = this.planeteTerre.getSatellite();
    	assertTrue(listeDesSatellitesNonModifiees.size() == 1);
    	Satellite uniqueSatelliteDeLaTerre = listeDesSatellitesNonModifiees.get(0);
    	assertEquals(this.lune, uniqueSatelliteDeLaTerre);
    	//On en profite pour voir si notre satellite a le bon nom...
    	assertEquals(uniqueSatelliteDeLaTerre.getNom(), "lune");
    	
    	//Pour supprimer un satellite, il faut passer par la m�thode supprimerSatellite()
    	//On v�rifie que tout est bien encapsul� comme on l'a souhait�.
    	this.planeteTerre.supprimerSatellite(uniqueSatelliteDeLaTerre);
    	assertTrue(this.planeteTerre.getSatellite().size() == 0);
    }
    

    /**
     * Supprime les engagements
     *
     * M�thode appel�e apr�s chaque appel de m�thode de test.
     */
    @After
    public void tearDown()
    {
        //Lib�rez ici les ressources engag�es par setUp()
    }

}
