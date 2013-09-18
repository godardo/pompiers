package robots;

import cases.Case;
import others.Direction;
import others.DonneesSimulation;
import others.Position;





/**
 *The Robot class is an abstract class that has defined every services that is 
 * logic and useful that a robot could have, as public methods.
 * 
 * @author 
 * @version 
 *
 */
public abstract class Robot {

    private int reservoirCapacite;
    private int reservoirCourant;
    private int dureeRemplissageComplet;
    private int dureeVidageComplet;
    private int qteInterventionUnitaire;
    private int dureeInterventionUnitaire;
    
    private Position positionCourante;
    private DonneesSimulation donneesSimu;
    

    /**
     *
     * @return
     */
    public int getDureeRemplissage() {
        return dureeRemplissageComplet;
    }

    /**
     *
     * @param dir
     * @return
     */
    public abstract int deplacer(Direction dir);

    /**
     *
     * @param c
     * @return
     */
    public abstract double getVitesse(Case c);

    /**
     *
     * @param depart
     * @param dir
     * @return
     */
    public abstract double getVitesse(Case depart, Direction dir);

    /**
     *
     * @param dir
     * @return
     */
    public abstract double getVitesse(Direction dir);

    /**
     *
     * @param c
     * @return
     */
    public abstract boolean estAccesible(Case c);

    /**
     *
     * @param depart
     * @param dir
     * @return
     */
    public abstract boolean estAccesible(Case depart, Direction dir);

    /**
     *
     * @param dir
     * @return
     */
    public abstract boolean estAccesible(Direction dir);

    /**
     *
     * @param c
     * @return
     */
    public abstract boolean peutRemplir(Case c);

    /**
     *
     * @return
     */
    public abstract int remplir();

    /**
     *
     * @param c
     * @return
     */
    public abstract boolean peutIntervenirSur(Case c);

    /**
     *
     * @param c
     */
    public abstract void intervenirSur(Case c);
}
