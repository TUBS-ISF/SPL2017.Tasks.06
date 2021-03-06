package GameSPL;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

import interfaces.IEnable;
import interfaces.IText;
import loader.PluginLoader;

public class Sidescroller implements ActionListener, MouseListener, KeyListener {

	public static Sidescroller sidescroller;

	public final int WIDTH = 800, HEIGHT = 800;

	public Renderer renderer;

	public int ticks, yMotion, score;

	public boolean gameOver, started;
	public Rectangle player;
	public ArrayList<Rectangle> columns;

	public Random rand;

	List<IEnable> EnablePlugins = PluginLoader.load(IEnable.class);

	public Sidescroller() {

		JFrame jframe = new JFrame();
		Timer timer = new Timer(20, this);

		renderer = new Renderer();
		rand = new Random();

		jframe.add(renderer);
		jframe.setTitle("GameSPL-Task3");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(WIDTH, HEIGHT);
		jframe.addMouseListener(this);
		jframe.addKeyListener(this);
		// jframe.setResizable(false);
		jframe.setVisible(true);

		player = new Rectangle(WIDTH / 2, HEIGHT / 2 - 10, 20, 20);
		columns = new ArrayList<Rectangle>();

		for (IEnable feature : EnablePlugins) {
			if (feature.getName() == "Obstacles") {
				addColumn(true);
				addColumn(true);
			}
		}
		timer.start();
	}

	public void addColumn(boolean start) {
		// int space = 300;
		int width = 100;
		int height = 50 + rand.nextInt(300);

		if (start) {
			columns.add(new Rectangle(WIDTH + width + columns.size() * 600, HEIGHT - height - 120, width, height));
			// columns.add(new Rectangle(WIDTH + width + (columns.size() - 1) *
			// 300, 0, width, HEIGHT - height - space));
		} else {
			columns.add(new Rectangle(columns.get(columns.size() - 1).x + 600, HEIGHT - height - 120, width, height));
			// columns.add(new Rectangle(columns.get(columns.size() - 1).x, 0,
			// width, HEIGHT - height - space));

		}
	}

	public void paintColumn(Graphics g, Rectangle column) {
		g.setColor(Color.green.darker());
		g.fillRect(column.x, column.y, column.width, column.height);
	}

	public void jump() {
		if (gameOver) {
			player = new Rectangle(WIDTH / 2, HEIGHT / 2 - 10, 20, 20);
			columns.clear();
			yMotion = 0;
			score = 0;

			addColumn(true);
			addColumn(true);

			gameOver = false;
		}

		if (!started) {
			started = true;
		} else if (!gameOver) {
			if (yMotion > 0) {
				yMotion = 0;
			}
			yMotion -= 10;
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int speed = 10;

		ticks++;
		if (started) {
			for (int i = 0; i < columns.size(); i++) {
				Rectangle column = columns.get(i);

				column.x -= speed;
			}

			if (ticks % 2 == 0 && yMotion < 15) {
				yMotion += 2;
			}

			for (int i = 0; i < columns.size(); i++) {
				Rectangle column = columns.get(i);
				if (column.x + column.width < 0) {
					columns.remove(column);
					// if (column.y == 0 ) {
					addColumn(false);
					// }
				}
			}

			player.y += yMotion;

			for (Rectangle column : columns) {

				for (IEnable feature : EnablePlugins) {
					if (feature.getName() == "Score") {
						if (/* column.y == 0 && */ player.x + player.width / 2 > column.x + column.width / 2 - 10
								&& player.x + player.width / 2 < column.x + column.width / 2 + 10) {
							score++;
						}
					}
					if (feature.getName() == "Collision") {
						if (column.intersects(player)) {
							gameOver = true;

							player.x = column.x - player.width;
						}
					}
				}
			}

			if (player.y > HEIGHT - 120 || player.y < 0) {
				gameOver = true;
			}
			if (player.y + yMotion >= HEIGHT - 120) {
				player.y = HEIGHT - 120 - player.height;
			}
		}

		renderer.repaint();
	}

	public void repaint(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		g.setColor(Color.orange);
		g.fillRect(0, HEIGHT - 150, WIDTH, 150);

		g.setColor(Color.green);
		g.fillRect(0, HEIGHT - 150, WIDTH, 20);

		g.setColor(Color.red);
		g.fillRect(player.x, player.y, player.width, player.height);

		for (Rectangle column : columns) {
			paintColumn(g, column);
		}

		// TEXT ELEMENTS
		g.setColor(Color.white);
		g.setFont(new Font("Arial", 1, 100));

		List<IText> textPlugins = PluginLoader.load(IText.class);

		// STARTTEXT
		if (!started) {

			for (IText text : textPlugins) {
				g.drawString(text.getStarttext(), 30, HEIGHT / 2 - 50);
			}

		}
		for (IEnable feature : EnablePlugins) {
			if (feature.getName() == "Score") {
				if (!gameOver && started) {
					g.drawString(String.valueOf(score), WIDTH / 2 - 25, 100);
				}
			}
			if (feature.getName() == "ByScore") {
				if (!started) {
					g.setFont(new Font("Arial", 1, 50));
					g.drawString("Reach 3 Points", 200, HEIGHT / 2 + 10);
				}
				if (score >= 3)
					g.drawString("You Won!", WIDTH / 2 - 250, HEIGHT / 2 - 50);
				if (gameOver && score < 3)
					g.drawString("Game Over!", WIDTH / 2 - 325, HEIGHT / 2 - 50);
			} else {
				if (gameOver) {
					g.drawString("Game Over!", WIDTH / 2 - 325, HEIGHT / 2 - 50);
				}
			}
		}

	}

	public static void main(String[] args) {
		sidescroller = new Sidescroller();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		jump();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			jump();
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

}
