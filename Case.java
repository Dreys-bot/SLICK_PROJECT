
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
public class Case {
	private final int L=160;
	private int x1,y1,l,w;
	public Case() {
		// Un carreau (case) est défini par ses 4 côtés
		x1=y1=0; l=L;
	}
	public Case(int X1, int Y1) {
		this();
		if(X1>=0&&Y1>=0) {
			x1=X1; y1=Y1;
			l=L;
		}
	}
	
	public Case(int X1, int Y1, int L1, int W1) {
		this();
		if(X1>=0&&Y1>=0) {
			x1=X1; y1=Y1;
			l=L1; w=W1;
		}
	}
	
	public void dessinerCase(Graphics g) {
		g.setColor(new Color(128,255,255,80)); 
		g.fillRect(x1, y1, l, l);
	}
	
	public void dessinerCaseMenu(Graphics g) {
		g.setColor(new Color(128,255,255,80)); 
		g.fillRect(x1, y1, w, l);
	}
	
	public int getX1() {
		return x1;
	}
	public int getY1() {
		return y1;
	}
	public int getL() {
		return l;
	}
	
	public int getW() {
		return w;
	}
	
	public void dessinerEmplacement(Graphics g) {
		g.setColor(Color.darkGray);
		for(int i=4; i<=10; i++)
			g.drawRoundRect(x1+i, y1+i, l-2*i, l-2*i, 5);
	}
	
	public void dessinerEmplacementMenu(Graphics g) {
		g.setColor(Color.darkGray);
		for(int i=2; i<=7; i++)
			g.drawRoundRect(x1+i, y1+i, w-2*i, l-2*i, 5);
	}
	
}