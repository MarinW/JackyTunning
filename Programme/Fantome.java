
package Class;

public class Fantome extends Entite{

	public Fantome(int x,int y,String j) {
		super(x, y, j);
		setPDV(5);
	}

	public Fantome(String j) {
		super(j);
		setPDV(5);
	}

	public void afficher() {
		System.out.println(this.getJ()+"("+this.getX()+","+this.getY()+")");
	}

	public void deplacement(String S,int [][] Lab, LabyrintheGraph fenetre) {
		if (this.getDeplacementpossible() > 0) this.setDeplacementpossible(this.getDeplacementpossible() - 1);
		else {
			fenetre.repaint((this.getX())*40, this.getY()*40+22, 40, 40); // enlever fantome

			int Xold = this.getX(); //ancienne coordonnées
			int Yold = this.getY();

			switch(S) {

			case "D":

				switch(Lab[this.getX()+1][this.getY()]) {
				case 2 : // contour
					break;
				case 100:
					break;
				default: // Sinon
					this.setX(this.getX()+1);
					break;
				}

				break;

			case "G":

				switch(Lab[this.getX()-1][this.getY()]) {
				case 2 : // contour
					break;
				case 100:
					break;
				default: // Sinon
					this.setX(this.getX()-1);
					break;
				}

				break;

			case "H":

				switch(Lab[this.getX()][this.getY()-1]) {
				case 2 : // contour
					break;
				case 100:
					break;
				default: // Sinon
					this.setY(this.getY()-1);
					break;
				}

				break;

			case "B":

				switch(Lab[this.getX()][this.getY()+1]) {
				case 2 : // contour
					break;
				case 100:
					break;
				default: // Sinon
					this.setY(this.getY()+1);
					break;
				}

				break;

			default:
				break;
			}


			fenetre.getGraphics().drawImage(Principale.monstre, this.getX()*40, (this.getY()*40)+22, 40, 40, null);

			if (Lab[Xold][Yold]==1) {
				try {
					Thread.sleep(0, 1);
					fenetre.getGraphics().drawImage(Principale.obstacle, Xold*40, (Yold*40)+22, 40, 40, null);
				}
				catch(Exception e) {
					System.out.println(e);
				}

			}	
		}
	}

	public void Degat() {
		this.setPDV(this.getPDV()-1);
	}



	public String deplacementInt(int[][] Lab, Avatar A) {
		double dist = Math.sqrt((Math.pow(A.getX()-this.getX(),2)-(Math.pow(A.getY()-this.getY(),2))));
		String S;
		if (dist<=10*Lab.length) {
			double[] distPrevue = calculDist(Lab, A);
			double min = distPrevue[0];
			int indmin = 0;
			for (int i = 1; i<4 ; i++) {
				if (distPrevue[i]<min) {
					min = distPrevue[i];
					indmin = i;
				}
			}
			if (indmin == 0) S = "G";
			else if (indmin == 1) S = "D";
			else if (indmin == 2) S = "B";
			else S = "H";
			return S;
		}
		else {
			double aleat = Math.random();
			if (aleat < 0.25) S = "G";
			else if (0.25 <= aleat && aleat < 0.5) S = "D";
			else if (0.5 <= aleat && aleat < 0.75) S = "B";
			else S = "H";
			return S;
		}

	}


	public double[] calculDist(int[][] Lab, Avatar A) {
		double[] distPrevue = {0, 0, 0, 0};
		distPrevue[0] = Math.sqrt((Math.pow(A.getX()-this.getX()+1,2)-(Math.pow(A.getY()-this.getY(),2)))); //Droit
		distPrevue[1] = Math.sqrt((Math.pow(A.getX()-this.getX()-1,2)-(Math.pow(A.getY()-this.getY(),2)))); //Gauche
		distPrevue[2] = Math.sqrt((Math.pow(A.getX()-this.getX(),2)-(Math.pow(A.getY()-this.getY()-1,2)))); //Haut
		distPrevue[3] = Math.sqrt((Math.pow(A.getX()-this.getX(),2)-(Math.pow(A.getY()-this.getY()+1,2)))); //Bas
		return distPrevue;
	}

}
