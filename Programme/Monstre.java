
public class Monstre extends Entite{
	public Monstre(int x,int y,String j) {
		super(x, y, j);
	}

	public Monstre(String j) {
		super(j);
	}

	public void afficher() {
		System.out.println(this.getJ()+"("+this.getX()+","+this.getY()+")");
	}

	public void deplacement(String S,int [][] Lab, LabyrintheGraph fenetre) {
		if(S.equals("D")) {
			if(Lab[this.getX()+1][this.getY()]==1 || Lab[this.getX()+1][this.getY()]==2) {
				//System.out.println("Il y a un mur impossible de passer !");	
			}
			else {
				this.setX(this.getX()+1);
				Lab[this.getX()-1][this.getY()]=0; // case vide
				Lab[this.getX()][this.getY()]=20;	//case heros
				fenetre.repaint((this.getX()-1)*40, this.getY()*40+22, 40, 40);
			}
		}
		else if(S.equals("G")) {
			if(Lab[this.getX()-1][this.getY()]==1 || Lab[this.getX()-1][this.getY()]==2) {
				//System.out.println("Il y a un mur impossible de passer !");	
			}
			else {
				this.setX(this.getX()-1);
				Lab[this.getX()+1][this.getY()]=0; // case vide
				Lab[this.getX()][this.getY()]=20;	//case heros
				fenetre.repaint((this.getX()+1)*40, this.getY()*40+22, 40, 40);
			}
		}
		else if(S.equals("H")) {
			if(Lab[this.getX()][this.getY()-1]==1 || Lab[this.getX()][this.getY()-1]==2) {
				//System.out.println("Il y a un mur impossible de passer !");	
			}
			else {
				this.setY(this.getY()-1);
				Lab[this.getX()][this.getY()+1]=0; // case vide
				Lab[this.getX()][this.getY()]=20;	//case heros
				fenetre.repaint((this.getX())*40, (this.getY()+1)*40+22, 40, 40);
			}
		}
		else if(S.equals("B")) {
			if(Lab[this.getX()][this.getY()+1]==1 || Lab[this.getX()][this.getY()+1]==2) {
				//System.out.println("Il y a un mur impossible de passer !");	
			}
			else {
				this.setY(this.getY()+1);
				Lab[this.getX()][this.getY()-1]=0; // case vide
				Lab[this.getX()][this.getY()]=20;	//case heros
				fenetre.repaint((this.getX())*40, (this.getY()-1)*40+22, 40, 40);
			}
		}
		else {
			//System.out.println("Vous restez perplexe...");
		}
	}

	public void Degat() {
		this.setPDV(this.getPDV()-1);
	}


	public boolean[] detectionMur(int [][] Lab) {
		boolean[] dirpos = {true, true, true, true};
		if(Lab[this.getX()+1][this.getY()]==1) {
		}
		else {
			dirpos[0] = false; //Bas
		}
		if(Lab[this.getX()-1][this.getY()]==1) {
		}
		else {
			dirpos[1] = false; //Haut
		}
		if(Lab[this.getX()][this.getY()-1]==1) {
		}
		else {
			dirpos[2] = false; //Gauche
		}

		if(Lab[this.getX()][this.getY()+1]==1) {
		}
		else {
			dirpos[3] = false; //Droite
		}
		return dirpos;
	}

	public void deplacementInt(int[][] Lab, Avatar A) {
		double dist = Math.sqrt((Math.pow(A.getX()-this.getX(),2)-(Math.pow(A.getY()-this.getY(),2))));
		boolean[] dirpos = detectionMur(Lab);
		if (dist<=0.20*Lab.length) {
			for (int i = 0; i<dirpos.length ; i++) {
				if (dirpos[i]==false) {

				}
			}
		}
	}

}
