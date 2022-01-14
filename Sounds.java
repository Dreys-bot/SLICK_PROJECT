import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class Sounds {
	public static Sound choice;
	public static Sound hover;
	public static Sound play;
	
	public Sounds() throws SlickException {
		choice= new Sound("Sounds/choice.wav");
		hover = new Sound("Sounds/hover.wav");
		play = new Sound("Sounds/click.wav");
	}
	
	
	
	
	
}
