
public class Avatar{
	private int x;
	private int y;
	private String j;
	private int PDV=10;
	
	public Avatar(int x,int y,String j) {
		this.x=x;
		this.y=y;
		this.j=j;
	}
	
	public Avatar(String j) {
		x=1;
		y=1;
		this.j=j;
	}
	
	public Avatar() {
		x=1;
		y=1;
		j="Jacky";
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
	public String getJ() {
		return j;
	}

	public void setJ(String j) {
		this.j = j;
	}
	public int getPDV() {
		return PDV;
	}

	public void setPDV(int pDV) {
		PDV = pDV;
	}
	
	public void afficher() {
		System.out.println(j+"("+x+","+y+")");
	}

	public void deplacement(String S,int [][] Lab) {
		S.toUpperCase();
		
		if(S.equals("B")) {
			if(Lab[x+1][y]==1) {
				System.out.println("Il y a un mur impossible de passer !");	
			}
			else {
				x+=1;
			}
		}
		else if(S.equals("H")) {
			if(Lab[x-1][y]==1) {
				System.out.println("Il y a un mur impossible de passer !");	
			}
			else {
				x-=1;}
		}
		else if(S.equals("G")) {
			if(Lab[x][y-1]==1) {
				System.out.println("Il y a un mur impossible de passer !");	
			}
			else {
				y-=1;}
		}
		else if(S.equals("D")) {
			if(Lab[x][y+1]==1) {
				System.out.println("Il y a un mur impossible de passer !");	
			}
			else {
				y+=1;}
		}
		else {
			System.out.println("Vous restez perplexe...");
		}
	}

	public void Degat() {
		PDV-=1;
	}
	
}
