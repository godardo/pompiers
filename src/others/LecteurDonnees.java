package others;

// Ensimag 2013-14 - 2A APOO  

import java.io.*;
import java.util.*;


/**
 * Lecteur de cartes au format spectifie dans le sujet.
 * Les donnees sur les cases, robots puis incendies sont lues dans le fichier,
 * puis simplement affichees. 
 * A noter: pas de verification semantique sur les valeurs numeriques lues.
 *
 * A vous de modifier ou d'ajouter des methodes, inspirees de celles presentes
 * (ou non), qui creeent les objets au moment adequat pour construite une
 * instance de la classe DonneesSimulation a partir d'un fichier.  
 * 
 */
public class LecteurDonnees {


	/**
	 * Lit et affiche le contenu d'un fichier de donnees (cases, 
	 * robots et incendies).
	 * Methode de classe, utilisation: LecteurDonnees.lire(fichierDonnees)
	 * @param fichierDonnees nom du fichier a lire
	 */
	public static void lire(String fichierDonnees) 
			throws FileNotFoundException, ExceptionFormatDonnees {
		System.out.println("\n == Lecture du fichier" + fichierDonnees);
		LecteurDonnees lecteur = new LecteurDonnees(fichierDonnees);
		lecteur.lireCarte();
		lecteur.lireIncendies();		
		lecteur.lireRobots();
		scanner.close();
		System.out.println("\n == Lecture terminee");
	}

	// Vous pouvez par exemple ajouter une methode qui cree et
	// retourne un objet contenant toutes les donnees lues: 
	//   public static DonneesSimulation creeDonnees(String fichierDonnees); 
	
	
	// Tout le reste de la classe est prive!
	
	private static Scanner scanner;

	/**
	 * Constructeur prive; impossible d'instancier la classe depuis l'exterieur
	 * @param fichierDonnees nom du fichier a lire
	 */
	private LecteurDonnees(String fichierDonnees) 
			throws FileNotFoundException {
		scanner = new Scanner(new File(fichierDonnees));
		scanner.useLocale(Locale.US);				
	}
	
	/**
	 * Lit et affiche les donnees de la carte.
	 * @throws ExceptionFormatDonnees
	 */
	private void lireCarte() throws ExceptionFormatDonnees {
		ignorerCommentaires();
		try {
			int nbLignes = scanner.nextInt();
			int nbColonnes = scanner.nextInt();
			int tailleCases = scanner.nextInt();	// en m
			System.out.println("Carte " + nbLignes + "x" + nbColonnes
					+ "; taille des cases = " + tailleCases);
			
			for (int lig = 0; lig < nbLignes; lig++) {
				for (int col = 0; col < nbColonnes; col++) {
					lireCase(lig, col);
				}
			}
			
		} catch (NoSuchElementException e) {
			throw new ExceptionFormatDonnees("Format invalide. "
					+ "Attendu: nbLignes nbColonnes tailleCases");
		}
		// une ExceptionFormat levee depuis lireCase est remontee telle quelle
	}
	

	
	
	/**
	 * Lit et affiche les donnees d'une case.
	 */
	private void lireCase(int lig, int col) throws ExceptionFormatDonnees {
		ignorerCommentaires();		
		System.out.print("Case (" + lig + "," + col + "): ");
		
		try {
			String nature = scanner.next();
			int altitude = scanner.nextInt();
			System.out.print("nature = " + nature + ";\t altitude = " + altitude);
			
			// lecture d'arguments supplementaires eventuels
			// pas de verification semantique sur les valeurs lues: dans les bornes, etc.)			
			switch (nature) {
			case "FORET":    // densite de vegetation?
				lireFlottant("; \tdensite = ");
				break;
			case "COURS_D_EAU":    // profondeur?
				lireFlottant("; \tprofondeur = ");
				break;
			default:
				// rien a lire pour les cases d'une autre nature
				verifieLigneTerminee();
			}
			
		} catch (NoSuchElementException e) {
			throw new ExceptionFormatDonnees("format de case invalide. "
					+ "Attendu: nature altitude [valeur_specifique]");
		}

		System.out.println();
	}



	/** 
	 * Lit et affiche les donnees des robots.
	 */
	private void lireRobots() throws ExceptionFormatDonnees {
		ignorerCommentaires();
		try {
			int nbRobots = scanner.nextInt();
			System.out.println("Nb de robots = " + nbRobots);
			for (int i = 0; i < nbRobots; i++) {
				lireRobot(i);
			}
			
		} catch (NoSuchElementException e) {
			throw new ExceptionFormatDonnees("Format invalide. "
					+ "Attendu: nbRobots");
		}		
	}

	
	/**
	 * Lit et affiche les donnees du i-eme robot.
	 * @param i
	 */
	private void lireRobot(int i) throws ExceptionFormatDonnees {
		ignorerCommentaires();
		System.out.print("Robot " + i + ": ");
		
		try {
			int lig = scanner.nextInt();
			int col = scanner.nextInt();
			System.out.print("position = (" + lig + "," + col + ");");
			String type = scanner.next();
			
			// pas de type enumere, switch sur la chaine
			switch (type) {
			case "DRONE":
				System.out.print("\t type = " + type);
				lireFlottant("; \t vitesse = ");
				break;
			case "CHENILLES":
			case "ROUES":
			case "PATTES":
				System.out.print("\t type = " + type);
				verifieLigneTerminee();
				break;
			default:
				throw new ExceptionFormatDonnees("robot de type inconnu");
			}
			System.out.println();
			
		} catch (NoSuchElementException e) {
			throw new ExceptionFormatDonnees("format de robot invalide. "
					+ "Attendu: ligne colonne type [valeur_specifique]");		
		}
	}



	/** 
	 * Lit et affiche les donnees des incendies.
	 */
	private void lireIncendies() throws ExceptionFormatDonnees {
		ignorerCommentaires();
		try {
			int nbIncendies = scanner.nextInt();
			System.out.println("Nb d'incendies = " + nbIncendies);
			for (int i = 0; i < nbIncendies; i++) {
				lireIncendie(i);
			}
			
		} catch (NoSuchElementException e) {
			throw new ExceptionFormatDonnees("Format invalide. "
					+ "Attendu: nbIncendies");
		}		
	}

	
	/**
	 * Lit et affiche les donnees du i-eme incendie.
	 * @param i
	 */
	private void lireIncendie(int i) throws ExceptionFormatDonnees {
		ignorerCommentaires();		
		System.out.print("Incendie " + i + ": ");
		
		try {
			int lig = scanner.nextInt();
			int col = scanner.nextInt();
			float intensite = scanner.nextFloat();
			System.out.println("position = (" + lig + "," + col
					+ ");\t intensite = " + intensite);
			verifieLigneTerminee();
			
		} catch (NoSuchElementException e) {
			throw new ExceptionFormatDonnees("format d'incendie invalide. "
					+ "Attendu: ligne colonne intensite");		
		}
	}


	/** Ignore toute (fin de) ligne commencant par '#' */
	private void ignorerCommentaires() {
		while(scanner.hasNext("#.*")) {
				scanner.nextLine();
		}
	}

	/**
	 * Essaie de lire un flottant (sans signe), sur la meme ligne,
	 * et affiche sa valeur le cas echeant. 
	 * @param message Message affiche AVANT la valeur eventuellement lue
	 */
	private void lireFlottant(String message) {
		System.out.print(message);
		String s = scanner.findInLine("(\\d+(\\.\\d+)?)");
		if (s != null) {
			System.out.print(Float.parseFloat(s));
		} else {
			System.out.print("valeur par defaut");
		}		
	}

	
	/**
	 * Verifie qu'il n'y a plus rien a lire sur cette ligne (int ou float).
	 * @throws ExceptionFormatDonnees 
	 */
	private void verifieLigneTerminee() throws ExceptionFormatDonnees {
		if (scanner.findInLine("(\\d+)") != null) {
			throw new ExceptionFormatDonnees("format invalide, donnees en trop.");
		}		
	}
}

