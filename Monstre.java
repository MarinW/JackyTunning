
public class Monstre {
	private int x;
	private int y;
	private int PDV=5;
	
	public Monstre(int x,int y) {
		this.x=x;
		this.y=y;
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
	
}
