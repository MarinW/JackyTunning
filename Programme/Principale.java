
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Principale {

	public static boolean partieTerminee=false;

	static Avatar Jacky = new Avatar("Antoine"); 
	static Fantome Test = new Fantome("test");
	
	static Labyrinthe lab = new Labyrinthe(2);
	static LabyrintheGraph fenetre = new LabyrintheGraph(lab);
	
	static BufferedImage  heros = null;
	static BufferedImage  monstre = null;
	static BufferedImage  obstacle = null;

	public static void main (String[] args) throws IOException {

		fenetre.setVisible(true); 

		initilisation();

		fenetre.dessinerLab(lab);


		while(!partieTerminee) {	
			deplacementMonstre();
		}
		System.out.println("Bien joué !");
	}

	private static void initilisation() throws IOException {

		lab.initJoueur(Jacky.getX(), Jacky.getY());
		Test.setX(10);
		Test.setY(12);
		lab.initFantome(Test.getX(), Test.getY());

		try {
			File input1 = new File("Resources/herosBlanc.png");
			heros = ImageIO.read(input1);
			File input2 = new File("Resources/monstre.png");
			monstre = ImageIO.read(input2);
			File input3 = new File("Resources/obstacle.png");
			obstacle = ImageIO.read(input3);
			
			Thread.sleep(2000); //temps de chargement
		}
		catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void deplacerJoueur(String s) {
		
		Jacky.deplacement(s,lab.getLab(),fenetre);
		fenetre.getGraphics().drawImage(heros, Jacky.getX()*40, (Jacky.getY()*40)+22, 40, 40, null);
		
		if(Jacky.getX()==3 && Jacky.getY()==3) partieTerminee=true;
		
	}

	public static void deplacementMonstre() {
		
		try {
			Thread.sleep(1000); 
		}
		catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
		Test.deplacement(Test.deplacementInt(lab.getLab(), Jacky), lab.getLab(), fenetre);
		fenetre.getGraphics().drawImage(monstre, Test.getX()*40, (Test.getY()*40)+22, 40, 40, null);
		
	}
}
