import java.awt.Color;
import java.awt.event.KeyEvent;

public aspect Customizable {

	before(KeyEvent e, Sidescroller s):execution(void Sidescroller.keyReleased(*)) && args(e) && this(s){
		if ((e.getKeyCode() >= 48 && e.getKeyCode() <= 57) || (e.getKeyCode() >= 96 && e.getKeyCode() <= 105)) {
			//only 0-9
			switch (e.getKeyCode()) {
			case 48: case 96:
				s.bgc = Color.CYAN;
				break;
			case 49: case 97:
				s.bgc = Color.BLACK;
				break;
			case 50: case 98:
				s.bgc = Color.blue;
				break;
			default:
				break;
			}
		}
	}
}