import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;

public class Sidescroller {
	public void textfeatures(){
		
		original();

		Graphics g = renderer.gr;
		g.setColor(Color.white);
		g.setFont(new Font("Arial", 1, 100));
		
		if (!started) {
			g.drawString("Click to start", 30, HEIGHT / 2 - 50);
		}
		
		if (gameOver) {
			g.drawString("Game Over!", WIDTH/2 - 325 , HEIGHT / 2 - 50);
		}
	}
}
