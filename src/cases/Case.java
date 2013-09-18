package cases;

import others.Position;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author godardo
 */
public abstract class Case {

    private String natureTerrain;
    private double altitude;
    private Position position;

    /**
     * Nature of ground
     *
     * @return natureTerrain
     */
    public String getNatureTerrain() {
        return natureTerrain;
    }

    /**
     * Return the position of the case
     *
     * @return position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Return accesibilitePiste
     *
     * @return
     */
    public abstract double getAccesibilitePiste();

    /**
     * Return accesibiliteTerrain
     *
     * @return
     */
    public abstract double getAccesibiliteTerrain();

    /**
     * Water or not
     *
     * @return
     */
    public abstract boolean estPointEau();

    /**
     * Return the deep of water
     *
     * @return
     */
    public abstract double getProfondeurEau();

    /**
     * On fire or not
     *
     * @return
     */
    public abstract boolean estEnFeu();

    /**
     * Return the intensity of the fire
     *
     * @return
     */
    public abstract boolean getIntensiteIncendie();

    /**
     * Return the sensibility to water
     *
     * @return
     */
    public abstract double getSensibiliteEau();

    /**
     * Receive water
     *
     * @param nbLitres number of liter of water brang
     */
    public abstract void recevoirEau(int nbLitres);

    /**
     * Return the string with the informations
     *
     * @return the informations of the case
     */
    public abstract String toStringCase();

    /**
     * Return the informations about fire
     *
     * @return the informations about the fire
     */
    public abstract String toStringIncendies();

    /**
     *
     * @return
     */
    @Override
    public abstract String toString();
}
