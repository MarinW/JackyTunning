
public class Fantome extends Entite{

	private int x;
	private int y;
	private int PDV=5;

	public Fantome(int x,int y, String j) {
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



	public void deplacement(String S,int [][] Lab) { //S = deplacementInt(Lab, Jacky)
		S.toUpperCase();
		if(S.equals("B")) {
				x+=1;}
		else if(S.equals("H")) {
				x-=1;}
		else if(S.equals("G")) {
				y-=1;}
		
		else if(S.equals("D")) {
				y+=1;}
		
		else {

		}
	}



	public String deplacementInt(int[][] Lab, Avatar A) {
		double dist = Math.sqrt((Math.pow(A.getX()-this.getX(),2)-(Math.pow(A.getY()-this.getY(),2))));
		String S;
		if (dist<=0.20*Lab.length) {
			double[] distPrevue = calculDist(Lab, A);
			double min = distPrevue[0];
			int indmin = 0;
			for (int i = 1; i<4 ; i++) {
				if (distPrevue[i]<min) {
					min = distPrevue[i];
					indmin = i;
				}
			}
			if (indmin == 0) S = "B";
			else if (indmin == 1) S = "H";
			else if (indmin == 2) S = "G";
			else S = "D";
			return S;
		}
		else {
			double aleat = Math.random();
			if (aleat < 0.25) S = "B";
			else if (0.25 <= aleat && aleat < 0.5) S = "H";
			else if (0.5 <= aleat && aleat < 0.75) S = "G";
			else S = "D";
			return S;
		}
		
	}


	public double[] calculDist(int[][] Lab, Avatar A) {
		double[] distPrevue = {0, 0, 0, 0};
		distPrevue[0] = Math.sqrt((Math.pow(A.getX()-this.getX()+1,2)-(Math.pow(A.getY()-this.getY(),2)))); //Bas
		distPrevue[1] = Math.sqrt((Math.pow(A.getX()-this.getX()-1,2)-(Math.pow(A.getY()-this.getY(),2)))); //Haut
		distPrevue[2] = Math.sqrt((Math.pow(A.getX()-this.getX(),2)-(Math.pow(A.getY()-this.getY()-1,2)))); //Gauche
		distPrevue[3] = Math.sqrt((Math.pow(A.getX()-this.getX(),2)-(Math.pow(A.getY()-this.getY()+1,2)))); //Droite
		return distPrevue;
	}
}