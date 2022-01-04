import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main { 

	public static void main(String[] args)throws SlickException {
		Memories jeu = new Memories(null);
		AppGameContainer app = new AppGameContainer(jeu, 650, 600, false);
		app.start();

	}

}
