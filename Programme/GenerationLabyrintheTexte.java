
package Class;

import java.io.*;

public class GenerationLabyrintheTexte {

	public static void Generation(int dificulte, int hauteur, int largeur){

		String adressedufichier = System.getProperty("user.dir") + "/" + "Programme" + "/" + "Ressources" + "/" + "LabyrintheTexte"; 

		try{ //on met try si jamais il y a une exception 

			PrintWriter writer = new PrintWriter(adressedufichier);

			writer.println("22222222222222222222");

			for (int i = 1; i < hauteur - 1; i++){

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
