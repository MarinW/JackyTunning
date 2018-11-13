import static org.junit.Assert.*;
import org.junit.Test;

public class Labyrinthe_Test {

	private Labyrinthe l1 = new Labyrinthe(1);

	@Test
	public void testgetHauteur() {

		assertTrue("Labyrinthe pas de la bonne hauteur", l1.getHauteur() == 20);

	}

	@Test
	public void testgetLargeur() {

		assertTrue("Labyrinthe pas de la bonne largeur", l1.getLargeur() == 20);

	}

	@Test
	public void testgetInt() {

		int different = 0;

		for (int i = 0; i < 20; i++){

			for (int j = 0; j < 20; j++){


				if (l1.getInt(i, j) != (l1.getLab())[i][j]){

					different = 1;

				}

			}

		}

		assertTrue("Int différent de celui attendu", different == 0);

	}

	@Test
	public void testinitJoueur() {

		int different = 0;

		for (int i = 0; i < 20; i++){

			for (int j = 0; j < 20; j++){

				l1.initJoueur(i, j);

				if (l1.getInt(i, j) != 20){

					different = 1;

				}

			}

		}

		assertTrue("Position initiale joeur erronée", different == 0);

	}

	@Test
	public void testinitFantome() {

		int different = 0;

		for (int i = 0; i < 20; i++){

			for (int j = 0; j < 20; j++){

				l1.initFantome(i, j);

				if (l1.getInt(i, j) != 30){

					different = 1;

				}

			}

		}

		assertTrue("Position initiale fantôme erronée", different == 0);

	}

}
