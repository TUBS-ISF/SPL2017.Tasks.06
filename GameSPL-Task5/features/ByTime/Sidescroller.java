import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;

public class Sidescroller {
	public void textfeatures(){
		
		original();

		Graphics g = renderer.gr;
		
		if (!started) {
			g.drawString("Click to start", 30, HEIGHT / 2 - 50);
			g.setFont(new Font("Arial", 1, 50));
			g.drawString("Time Mode Unfinished", 100, HEIGHT / 2 +10);
		}
		
	}
}
