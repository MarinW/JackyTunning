
package Class;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


public class Principale {
	
	public static boolean partieTerminee=false;
	public static boolean partiePerdue=false;
	public static boolean startClick=false;
	public static boolean restart=false;

	static Avatar Joueur; 
	static Fantome[] Fantome;
	static ArrayList<Entite> ArrayE = new ArrayList<Entite>();
	
	static int randX;
	static int randY;

	static interfaceStart fenetreStart = new interfaceStart();

	static Labyrinthe lab;
	static LabyrintheGraph fenetreLab;

	static BufferedImage  heros = null;
	static BufferedImage  monstre = null;
	static BufferedImage  obstacle = null;
	static BufferedImage  imaFin = null;

	public static void main (String[] args) throws IOException {

		fenetreStart.setVisible(true); 

		start();

		while(true) {

			while(!startClick) {
				System.out.print("");
			}
	
			interfaceStart fenetreChargement = new interfaceStart();
			fenetreChargement.setVisible(true); 

			progress(3); //Chargement
			
			fenetreLab.setVisible(true);
			fenetreLab.dessinerLab(lab);

			fenetreChargement.dispose();

			while(!partieTerminee) {	
				deplacementMonstre();
			}


			end();

			attenteReponse();
			restart=false;
		}

	}

	public static void initilisation(String nameJoueur,int difficulte) throws IOException {

		String adressedufichier = System.getProperty("user.dir") + "/" + "Programme" + "/" + "Ressources" + "/";
		
		/**Initialisation du labyrinthe et des entites**/
		
		lab = new Labyrinthe(difficulte);
		Joueur = new Avatar(nameJoueur);
		Fantome = initFantome(difficulte);
		
		lab.initJoueur(Joueur.getX(), Joueur.getY());
		lab.initFantome(Fantome);
		
		randCoord();
				
		while(lab.getInt(randX, randY)!=0 && randX>10 && randY>10) {
			randCoord();
		}
		
		lab.initData(randX, randY);

		/**Fin de la fenetre start et debut d'affichage du labyrinthe**/
		
		fenetreStart.setVisible(false);
		
		fenetreLab = new LabyrintheGraph(lab);
		JLabel background=new JLabel(new ImageIcon(adressedufichier + "ciaBackground.png"));
		fenetreLab.add(background);

		try {
			File input1 = new File(adressedufichier + "herosBlanc.png");
			heros = ImageIO.read(input1);
			File input2 = new File(adressedufichier + "monstre.png");
			monstre = ImageIO.read(input2);
			File input3 = new File(adressedufichier + "obstacle.png");
			obstacle = ImageIO.read(input3);
			File input4 = new File(adressedufichier + "iconLoad.png");
			imaFin = ImageIO.read(input4);

		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void deplacerJoueur(String s) {

		Joueur.deplacement(s,lab.getLab(),fenetreLab);
		fenetreLab.getGraphics().drawImage(heros, Joueur.getX()*40, (Joueur.getY()*40)+22, 40, 40, null);

		if(lab.getLab()[Joueur.getX()][Joueur.getY()]==100) partieTerminee=true;
		for (int i=1 ; i<ArrayE.size(); i++) { //Pour savoir si un monstre est sur la case du héros
			if(Jacky.getX()==ArrayE.get(i).getX() && Jacky.getY()==ArrayE.get(i).getY()) {//ne fonctionne pas bien...
				partiePerdue=true;
				partieTerminee=true;
			}
		}

	}

	public static void deplacementMonstre() {

		try {
			Thread.sleep(500); 
			for (int e=1 ; e<ArrayE.size(); e++) {
				if (ArrayE.get(e).getPDV()>0) {
				ArrayE.get(e).deplacement(ArrayE.get(e).deplacementInt(lab.getLab(), Jacky), lab.getLab(), fenetre);
				}
				else {
					ArrayE.get(e).setX(0);
					ArrayE.get(e).setY(0);
				}
				
			}
		}
		catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}	
	}

	public static void start() {
		
		progress(20);

		fenetreStart.build2();

		try {

			Thread.sleep(100); 

		}
		catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}


		fenetreStart.repaint();

		try {
			Thread.sleep(100);
		}
		catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
		fenetreStart.miseEnPlaceInterfaceStart();


	}

	public static void end() {

		Graphics g = fenetreLab.getGraphics();

		g.fillRoundRect(100, 261, 600, 300, 70, 70);

		g.setColor(Color.white);
		g.setFont(new Font("TimesRoman ",Font.BOLD+Font.ITALIC,30));
		g.drawString("YOU HACK IT", 290, 500);

		
		g.drawImage(imaFin, 321, 300, 158, 158, null);

		JButton btnReStart = new JButton("Restart");
		btnReStart.setBounds(297, 540, 100, 30);
		btnReStart.setBackground(Color.BLACK);
		btnReStart.addActionListener(new ReStartAction());


		JButton btnClose = new JButton("Close");
		btnClose.setBounds(402, 540, 100, 30);
		btnClose.setBackground(Color.BLACK);
		btnClose.addActionListener(new CloseAction());

		fenetreLab.add(btnReStart,0);
		fenetreLab.add(btnClose,1);

		fenetreLab.repaint(297, 562, 100, 30);
		fenetreLab.repaint(402, 562, 100, 30);

	}
	
	public static void attenteReponse() {
		while(!restart) {
			System.out.print("");
		}
	}
	
	public static void reset() {
		fenetreLab.setVisible(false);
		fenetreStart.setVisible(true);
		
		partieTerminee=false;
		startClick=false;
		
	}
	
	public static void randCoord() {
		randX = (int) Math.floor(Math.random()*18);
		randY = (int) Math.floor(Math.random()*18);
	}
	
	public static Fantome[] initFantome(int nbFant) {
		Fantome[] Fant = new Fantome[nbFant];

		for(int nbFantome=0;nbFantome<Fant.length;nbFantome++) {
			Fant[nbFantome] = new Fantome("F"+nbFantome);
				
			randCoord();
			
			while(lab.getInt(randX, randY)!=0) {
				randCoord();
			}
			
			Fant[nbFantome].setX(randX);
			Fant[nbFantome].setY(randY);
		}
		
		return(Fant);
		
	}
	
	public static void progress(int temps) {
		
		try {
			for(int i=0;i<101;i++) {
				interfaceStart.progressBar.setValue(i);
				Thread.sleep(temps);
			}
		}
		catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
	}

	static class ReStartAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				reset();
				restart=true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}  
	}

	static class CloseAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				fenetreLab.dispose();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}  
	}

}




