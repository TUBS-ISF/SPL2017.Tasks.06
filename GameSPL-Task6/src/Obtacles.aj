import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


aspect Obtacles {
	after(KeyEvent e, Sidescroller s):set(ArrayList<Rectangle> columns) && args(e) && this(s){
		s.addColumn(true);
		s.addColumn(true);
	}	
}