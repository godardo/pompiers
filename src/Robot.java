


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
     *returns the necessary duration for filling the tank
     * @return
     */
    public int getDureeRemplissage() {
        return dureeRemplissageComplet;
    }

    /**
     *moves the robot from it's current position to a new one if it's possible
     * @param dir new direction
     * @return
     */
    public abstract int deplacer(Direction dir);

    /**
     *Returns the speed of the robot on the "case"
     * @param c "case"
     * @return speed
     */
    public abstract double getVitesse(Case c);

    /**
     *returns the speed  of  the robot, assuming that it is  on the "case" 
     * depart and also, he wants to access the adjacent case inside the direction given.
     * 
     * The returned value depends on this values (depart and arrival)
     * @param depart "case from where it comes
     * @param dir new direction
     * @return
     */
    public abstract double getVitesse(Case depart, Direction dir);

    /**
     *returns the speed  of  the robot, assuming that he wants to access the 
     * adjacent case inside the direction given from where it is right now.
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
