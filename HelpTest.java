import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

public class HelpTest {
	private Image help, logo, back, background, back_hover;
	private static final int[] BACK_COOR={480,520,168,80};
	private String message[]= new String[4]; 
	
	public HelpTest() throws SlickException {
		logo= new Image("icon/logoMemory-removebg-preview.png");
		help= new Image("icon/help.png");
		message[0]="L'objectif est de";
		message[1]= "retrouver tous les couples";
		message[2]="de cartes avec le minimum";
		message[3]="de tentatives";
		back= new Image("icon/back.png");
		background= new Image("icon/background3.gif");
		back_hover= new Image("icon/backh.png");
	}
	
	public void dessinerHelp(Graphics g, GameContainer gc) {
		g.setColor(new Color(128,255,255,80));
		g.drawImage(background,-30, 0);
		g.drawImage(logo, 100, -40);
		g.drawImage(help, 200, 100);
		
		//Afficher le outton back 
		Input inp= gc.getInput();
		int x=inp.getMouseX();
		int y=inp.getMouseY();
		if(x<=BACK_COOR[0]+BACK_COOR[2] && x>=BACK_COOR[0] && y>=BACK_COOR[1] && y<=BACK_COOR[1]+BACK_COOR[3])
			g.drawImage(back_hover, BACK_COOR[0], BACK_COOR[1]);
		else
			g.drawImage(back, BACK_COOR[0], BACK_COOR[1]);
		afficherAide(g);
	}
	
	public void afficherAide(Graphics g) {
		//Ecrire le help
			java.awt.Font font = new Font("Verdana", Font.BOLD, 38);
			TrueTypeFont ttf = new TrueTypeFont(font, true);
			ttf.drawString(150.0f, 200.0f, message[0], Color.blue);
			ttf.drawString(55.0f, 300.0f, message[1], Color.blue);
			ttf.drawString(50.0f, 400.0f, message[2], Color.blue);
			ttf.drawString(200.0f, 500.0f, message[3], Color.blue);
	}
	
	//Si on clique sur le boutton back, on revient au menu
		public void clicCase(int x, int y) {
			if(x<=BACK_COOR[0]+BACK_COOR[2] && x>=BACK_COOR[0] && y>=BACK_COOR[1] && y<=BACK_COOR[1]+BACK_COOR[3]) {
				Menu.selection=0;	
			}
		}
	
}
