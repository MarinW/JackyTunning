
abstract class Entite {

	private int x;
	private int y;
	private String j;
	private int PDV;
			
	public Entite(int x, int y, String j) {
		this.x = x;
		this.y = y;
		this.j = j;
	}
	
	
	public Entite(String j) {
		x=1;
		y=1;
		this.j=j;
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
	
	
	abstract void deplacement(String S,int [][] Lab, LabyrintheGraph fenetre);
	
}
