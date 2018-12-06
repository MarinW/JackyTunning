package Class;

import java.io.*;

public class LectureLabyrintheTexte {

	public static int[][] Lecture(int hauteur, int largeur){

		int[][] lab = new int [hauteur][largeur]; 

		try{

			String adressedufichier = System.getProperty("user.dir") + "/" + "Programme" + "/" + "Ressources" + "/" + "LabyrintheTexte";

			InputStream flux = new FileInputStream(adressedufichier); 
			InputStreamReader lecture=new InputStreamReader(flux);
			BufferedReader buff=new BufferedReader(lecture);
			String ligne;

			int i = 0;

			while ((ligne=buff.readLine())!=null){

				int taille = ligne.length();

				for (int j = 0; j < taille; j++){

					lab[i][j] = ligne.charAt(j) - '0';

				}

				i ++;

			}

			buff.close(); 

		}		

		catch (Exception e){

			System.out.println(e.toString());

		}

		return lab;

	}	

}
