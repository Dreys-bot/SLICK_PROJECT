import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

public class ExitTest {
	private Image[] yes = new Image[2];
	private Image[] no = new Image[2];
	private boolean close;
	
	public ExitTest() throws SlickException {
		yes[0]= new Image("images\\yes0.png");
		yes[1]= new Image("images\\yes1.png");
		no[0]= new Image("images\\no1.png");
		no[1]= new Image("images\\no0.png");
		close=false;
	}
	
	public void dessinerExit(Graphics g, GameContainer gc) {
		//Dessinons le container de la consigne
			g.setColor(new Color(255, 255, 255, 200));
			g.fillRect(0, 0, 660, 750);
			g.setColor(new Color(241,166,38));
			g.fillRoundRect(80, 250, 500, 300, 50);
		
		//Ecrire la consigne
			java.awt.Font font = new Font("Verdana", Font.BOLD, 40);
			TrueTypeFont ttf = new TrueTypeFont(font, true);
			ttf.drawString(102.0f, 320.0f, "Continue and exit ?", Color.darkGray);
		
		//on affiche les deux faces des boutons, soit le hover, soit la face non cachée
			Input inp= gc.getInput();
			int x=inp.getMouseX();
			int y=inp.getMouseY();
			if(x<=95+118 && x>=95 && y>=460 && y<=460+60)
				g.drawImage(yes[1], 90, 452);
			else
				g.drawImage(yes[0], 95, 460);
			
			if(x<=575 && x>=575-118 && y>=460 && y<=460+60)
				g.drawImage(no[1], 575-124, 452);
			else
				g.drawImage(no[0], 575-118, 460);
	}
	
	public void clicExit(int x, int y) {//si le joueur clic sur l'emplacement de la reponse yes, on renvoie la valeur de close
		if(x<=95+118 && x>=95 && y>=460 && y<=460+60) {
			close=true;
		}
		else if(x<=575 && x>=575-118 && y>=460 && y<=460+60) {//sinon, on revient au menu
			Menu.selection=0;	
		}
	}
	
	public boolean close() {
		return close;
	}
}
