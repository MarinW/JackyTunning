
public class Monstre extends Entite{
	private int x;
	private int y;
	private int PDV=5;

	public Monstre(int x,int y, String j) {
		super(x, y, j);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getPDV() {
		return PDV;
	}

	public void setPDV(int pDV) {
		PDV = pDV;
	}

	public void deplacement(String S,int [][] Lab) {
		S.toUpperCase();
		if(S.equals("B")) {
			if(Lab[x+1][y]==1) {
			}
			else {
				x+=1;
			}
		}
		else if(S.equals("H")) {
			if(Lab[x-1][y]==1) {
			}
			else {
				x-=1;}
		}
		else if(S.equals("G")) {
			if(Lab[x][y-1]==1) {
			}
			else {
				y-=1;}
		}
		else if(S.equals("D")) {
			if(Lab[x][y+1]==1) {
			}
			else {
				y+=1;}
		}
		else {

		}
	}


	public boolean[] detectionMur(int [][] Lab) {
		boolean[] dirpos = {true, true, true, true};
		if(Lab[x+1][y]==1) {
		}
		else {
			dirpos[0] = false; //Bas
		}
		if(Lab[x-1][y]==1) {
		}
		else {
			dirpos[1] = false; //Haut
		}
		if(Lab[x][y-1]==1) {
		}
		else {
			dirpos[2] = false; //Gauche
		}

		if(Lab[x][y+1]==1) {
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
