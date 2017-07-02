import java.awt.Color;
import java.awt.Font;

import java.awt.Graphics;

public aspect ByScore {

//	before(Graphics g, Sidescroller s):execution(void Sidescroller.repaint(Graphics)) && args(g) && this(s){
//		g = s.renderer.gr;
//		g.setColor(Color.white);
//		g.setFont(new Font("Arial", 1, 100));
//		System.out.println(s.score);
//		if (s.started) {
//			g.drawString(String.valueOf(s.score), s.WIDTH / 2 - 25, 100);
//		}
//	}
	before(Sidescroller s) : get(Graphics *.*) && this(s){
		s.renderer.gr.setColor(Color.white);
		s.renderer.gr.setFont(new Font("Arial", 1, 100));
		
		if (!s.started) {
			s.renderer.gr.drawString("Click to start", 30, s.HEIGHT / 2 - 50);
			s.renderer.gr.setFont(new Font("Arial", 1, 50));
			s.renderer.gr.drawString("Reach 3 Points", 200, s.HEIGHT / 2 +10);
		}
		
		if (s.score>=3){
			s.renderer.gr.drawString("You Won!", s.WIDTH / 2 - 250, s.HEIGHT/2-50);
		}
		if (s.gameOver && s.score<3) {
			s.renderer.gr.drawString("Game Over!", s.WIDTH/2 - 325 , s.HEIGHT / 2 - 50);
		}
	}
}