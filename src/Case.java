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
     * @return natureTerrain
     */
    public String getNatureTerrain(){
        return natureTerrain;
    }
    
    /**
     * Return the position of the case
     * @return position
     */
    public Position getPosition() {
        return position;
    }
    
    public abstract double getAccesibilitePiste();
    
    public abstract double getAccesibiliteTerrain();
    
    public abstract boolean estPointEau();
    
    public abstract double getProfondeurEau();
    
    public abstract boolean estEnFeu();
    
    public abstract boolean getIntensiteIncendie();
    
    public abstract double getSensibiliteEau();
    
    public abstract void recevoirEau(int nbLitres);
    
    public abstract String toStringCase();
    
    public abstract String toStringIncendies();
    
    @Override
    public abstract String toString();
    
    
}
