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
			g.drawString("Reach 3 Points", 200, HEIGHT / 2 +10);
		}
		
		if (score>=3){
			g.drawString("You Won!", WIDTH / 2 - 250, HEIGHT/2-50);
		}
		if (gameOver && score<3) {
			g.drawString("Game Over!", WIDTH/2 - 325 , HEIGHT / 2 - 50);
		}
	}
}
