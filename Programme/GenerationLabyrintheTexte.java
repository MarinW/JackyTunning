package Class;

import java.io.*;
import java.util.List;
import java.util.Arrays;
import java.lang.Object;


public class GenerationLabyrintheTexte {

	private int hauteur;
	private int largeur;
	int[][] lab;

	public GenerationLabyrintheTexte(int dificulte){

		this.hauteur = 20;
		this.largeur = 20 ;

		String adressedufichier = System.getProperty("user.dir") + "/" + "Programme" + "/" + "Ressources" + "/" + "LabyrintheTexte"; //on met try si jamais il y a une exception 



		try{

			PrintWriter writer = new PrintWriter(adressedufichier);

			writer.println("22222222222222222222");

			for (int i = 1; i < largeur - 1; i++){

				writer.print("2");

				String ligne = new String();

				for (int j = 1; j < largeur - 1; j++){

					double test = Math.random();

					if (test < (0.5/(0.5/dificulte))/20){

						ligne = ligne + "1";

					}

					else{

						ligne = ligne + "0";

					}

				}

				writer.println(ligne + "2");

			}

			writer.print("22222222222222222222");

			writer.close();


		}

		catch(IOException ioe){ System.out.print("Erreur : "); ioe.printStackTrace();

		}

	}	

}