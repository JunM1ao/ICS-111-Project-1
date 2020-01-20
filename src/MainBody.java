import java.awt.Color;
import java.awt.event.KeyEvent;

public class MainBody {
	public static void main(String[] args) {
		// framework and labels
		int game = 1;// game switch, 0=off, 1=on
		EZ.initialize(1024, 768); // game resolution
		EZImage background = EZ.addImage("court.png", 512, 384); // set background image
		EZImage player = EZ.addImage("main.png", 512, 400); // set game sprite
		int lives = 3; // start live counter
		double score = 0; // start score counter

		// import sound
		EZSound ball1s = EZ.addSound("1.wav");
		EZSound ball2s = EZ.addSound("2.wav");
		EZSound ball3s = EZ.addSound("3.wav");
		EZSound ball4s = EZ.addSound("4.wav");
		EZSound ooob = EZ.addSound("0.wav");
		EZSound ouch = EZ.addSound("7.wav");

		// font setup
		int fontsize1 = 70;
		Color tc1 = new Color(62, 249, 196);
		EZText text = EZ.addText(512, 50, "Run!", tc1, fontsize1);
		text.setFont("text.ttf");

		int fontsize2 = 50;
		Color tc2 = new Color(30, 237, 252);
		EZText text2 = EZ.addText(512, 710, "", tc2, fontsize2);
		text2.setFont("text.ttf");

		// player position
		int PposX = 512; // player x position label
		int PposY = 400; // player y position label

		// set ball sprite and position
		EZImage ball1 = EZ.addImage("ball1.png", 125, 125);
		float Ball1X = 125;
		float Ball1Y = 125; // Set ball1 sprite and position
		EZImage ball2 = EZ.addImage("Basketball.png", 900, 125);
		float Ball2X = 900;
		float Ball2Y = 125; // set ball2 sprite and position
		EZImage ball3 = EZ.addImage("Dragon Ball.png", 125, 640);
		float Ball3X = 125;
		float Ball3Y = 640; // set ball3 sprite and position
		EZImage ball4 = EZ.addImage("soccer ball.png", 900, 640);
		float Ball4X = 900;
		float Ball4Y = 640; // set ball4 sprite and position

		// ball direction "place holders"
		float dBall1X = 0;
		float dBall1Y = 0;
		float dBall2X = 0;
		float dBall2Y = 0;
		float dBall3X = 0;
		float dBall3Y = 0;
		float dBall4X = 0;
		float dBall4Y = 0;

		// ball distance "place holders"
		float h1 = 0;
		float h2 = 0;
		float h3 = 0;
		float h4 = 0;

		// calculation "place holders"
		float width1 = 0;
		float height1 = 0;
		float width2 = 0;
		float height2 = 0;
		float width3 = 0;
		float height3 = 0;
		float width4 = 0;
		float height4 = 0;

		// hit detection place holders
		int Hball1x, Hball1y;
		int Hball2x, Hball2y;
		int Hball3x, Hball3y;
		int Hball4x, Hball4y;
		int pb = 150;
		// start ball movement 1
		if (game == 1) {
			// first calculations
			// start sound
			ooob.loop();
			// ball1
			Math.abs(width1 = PposX - Ball1X);
			Math.abs(height1 = PposY - Ball1Y);
			h1 = (int) Math.sqrt((width1 * width1) + (height1 * height1));
			Ball1X = Ball1X + dBall1X;
			Ball1Y = Ball1Y + dBall1Y;
			dBall1X = width1 / h1 * 10;
			dBall1Y = height1 / h1 * 10;
			// ball2
			Math.abs(width2 = PposX - Ball2X);
			Math.abs(height2 = PposY - Ball2Y);
			h2 = (int) Math.sqrt((width2 * width2) + (height2 * height2));
			Ball2X = Ball2X + dBall2X;
			Ball2Y = Ball2Y + dBall2Y;
			dBall2X = width2 / h2 * 7;
			dBall2Y = height2 / h2 * 7;
			// ball3
			Math.abs(width3 = PposX - Ball3X);
			Math.abs(height3 = PposY - Ball3Y);
			h3 = (int) Math.sqrt((width3 * width3) + (height3 * height3));
			Ball3X = Ball3X + dBall3X;
			Ball3Y = Ball3Y + dBall3Y;
			dBall3X = width3 / h3 * 5;
			dBall3Y = height3 / h3 * 5;
			// ball4
			Math.abs(width4 = PposX - Ball4X);
			Math.abs(height4 = PposY - Ball4Y);
			h4 = (int) Math.sqrt((width4 * width4) + (height4 * height4));
			Ball4X = Ball4X + dBall4X;
			Ball4Y = Ball4Y + dBall4Y;
			dBall4X = width4 / h4 * 7;
			dBall4Y = height4 / h4 * 7;
		}

		while (game == 1) {
			// all ball movement and re-bounce
			// ball1
			Math.abs(width1 = PposX - Ball1X);
			Math.abs(height1 = PposY - Ball1Y);
			h1 = (int) Math.sqrt((width1 * width1) + (height1 * height1));
			Ball1X = Ball1X + dBall1X;
			Ball1Y = Ball1Y + dBall1Y;
			ball1.translateTo(Ball1X, Ball1Y);
			if (Ball1X < 0) {
				dBall1X = width1 / h1 * 10;
				dBall1Y = height1 / h1 * 10;
				ball1s.play();

			}
			if (Ball1X > 1024) {
				dBall1X = width1 / h1 * 10;
				dBall1Y = height1 / h1 * 10;
				ball1s.play();
			}
			if (Ball1Y < 0) {
				dBall1X = width1 / h1 * 10;
				dBall1Y = height1 / h1 * 10;
				ball1s.play();
			}
			if (Ball1Y > 768) {
				dBall1X = width1 / h1 * 10;
				dBall1Y = height1 / h1 * 10;
				ball1s.play();
			}
			// ball2
			Math.abs(width2 = PposX - Ball2X);
			Math.abs(height2 = PposY - Ball2Y);
			h1 = (int) Math.sqrt((width2 * width2) + (height2 * height2));
			Ball2X = Ball2X + dBall2X;
			Ball2Y = Ball2Y + dBall2Y;
			ball2.translateTo(Ball2X, Ball2Y);
			if (Ball2X < 0) {
				dBall2X = width2 / h2 * 7;
				dBall2Y = height2 / h2 * 7;
				ball2s.play();
			}
			if (Ball2X > 1024) {
				dBall2X = width2 / h2 * 7;
				dBall2Y = height2 / h2 * 7;
				ball2s.play();
			}
			if (Ball2Y < 0) {
				dBall2X = width2 / h2 * 7;
				dBall2Y = height2 / h2 * 7;
				ball2s.play();
			}
			if (Ball2Y > 768) {
				dBall2X = width2 / h2 * 7;
				dBall2Y = height2 / h2 * 7;
				ball2s.play();
			}
			// ball3
			Math.abs(width3 = PposX - Ball3X);
			Math.abs(height3 = PposY - Ball3Y);
			h1 = (int) Math.sqrt((width3 * width3) + (height3 * height3));
			Ball3X = Ball3X + dBall3X;
			Ball3Y = Ball3Y + dBall3Y;
			ball3.translateTo(Ball3X, Ball3Y);
			if (Ball3X < 0) {
				dBall3X = width3 / h3 * 5;
				dBall3Y = height3 / h3 * 5;
				ball3s.play();
			}
			if (Ball3X > 1024) {
				dBall3X = width3 / h3 * 5;
				dBall3Y = height3 / h3 * 5;
				ball3s.play();
			}
			if (Ball3Y < 0) {
				dBall3X = width3 / h3 * 5;
				dBall3Y = height3 / h3 * 5;
				ball3s.play();
			}
			if (Ball3Y > 768) {
				dBall3X = width3 / h3 * 5;
				dBall3Y = height3 / h3 * 5;
				ball3s.play();
			}
			// ball4
			Math.abs(width4 = PposX - Ball4X);
			Math.abs(height4 = PposY - Ball4Y);
			h1 = (int) Math.sqrt((width4 * width4) + (height4 * height4));
			Ball4X = Ball4X + dBall4X;
			Ball4Y = Ball4Y + dBall4Y;
			ball4.translateTo(Ball4X, Ball4Y);
			if (Ball4X < 0) {
				dBall4X = width4 / h4 * 7;
				dBall4Y = height4 / h4 * 7;
				ball4s.play();
			}
			if (Ball4X > 1024) {
				dBall4X = width4 / h4 * 7;
				dBall4Y = height4 / h4 * 7;
				ball4s.play();
			}
			if (Ball4Y < 0) {
				dBall4X = width4 / h4 * 7;
				dBall4Y = height4 / h4 * 7;
				ball4s.play();
			}
			if (Ball4Y > 768) {
				dBall4X = width4 / h4 * 7;
				dBall4Y = height4 / h4 * 7;
				ball4s.play();
			}
			// player movement
			player.translateTo(PposX, PposY);
			if (EZInteraction.isKeyDown("d") && !EZInteraction.isKeyDown(KeyEvent.VK_SHIFT)) {// slow movement right
				PposX += 5;
			}
			if (EZInteraction.isKeyDown("a") && !EZInteraction.isKeyDown(KeyEvent.VK_SHIFT)) {// slow movement left
				PposX -= 5;
			}
			if (EZInteraction.isKeyDown("w") && !EZInteraction.isKeyDown(KeyEvent.VK_SHIFT)) {// slow movement up
				PposY -= 5;
			}
			if (EZInteraction.isKeyDown("s") && !EZInteraction.isKeyDown(KeyEvent.VK_SHIFT)) {// slow movement down
				PposY += 5;
			}
			if (EZInteraction.isKeyDown("d") && EZInteraction.isKeyDown(KeyEvent.VK_SHIFT)) {// fast movement right
				PposX += 9;
			}
			if (EZInteraction.isKeyDown("a") && EZInteraction.isKeyDown(KeyEvent.VK_SHIFT)) {// fast movement left
				PposX -= 9;
			}
			if (EZInteraction.isKeyDown("w") && EZInteraction.isKeyDown(KeyEvent.VK_SHIFT)) {// fast movement up
				PposY -= 9;
			}
			if (EZInteraction.isKeyDown("s") && EZInteraction.isKeyDown(KeyEvent.VK_SHIFT)) {// fast movement down
				PposY += 9;
			}
			// player boundary
			if (PposX < 0) {
				PposX += 9;
			}
			if (PposX > 1024) {
				PposX -= 9;
			}
			if (PposY < 0) {
				PposY += 9;
			}
			if (PposY > 768) {
				PposY -= 9;
			}
			EZ.refreshScreen();
			score++; // add score
			// hit detection
			// ball 1 hitbox
			Hball1x = ball1.getXCenter() - pb / 3;
			Hball1y = ball1.getYCenter() - pb / 3;
			Hball1x = ball1.getXCenter() + pb / 3;
			Hball1y = ball1.getYCenter() - pb / 3;
			Hball1x = ball1.getXCenter() + pb / 3;
			Hball1y = ball1.getYCenter() + pb / 3;
			Hball1x = ball1.getXCenter() - pb / 3;
			Hball1y = ball1.getYCenter() + pb / 3;
			if (player.isPointInElement(Hball1x, Hball1y) && score % 6 == 0) {
				lives--;
				ouch.play();
			}
			// ball2 hitbox
			Hball2x = ball2.getXCenter() - pb / 3;
			Hball2y = ball2.getYCenter() - pb / 3;
			Hball2x = ball2.getXCenter() + pb / 3;
			Hball2y = ball2.getYCenter() - pb / 3;
			Hball2x = ball2.getXCenter() + pb / 3;
			Hball2y = ball2.getYCenter() + pb / 3;
			Hball2x = ball2.getXCenter() - pb / 3;
			Hball2y = ball2.getYCenter() + pb / 3;
			if (player.isPointInElement(Hball2x, Hball2y) && score % 7 == 0) {
				lives--;
				ouch.play();
			}
			// ball3 hitbox
			Hball3x = ball3.getXCenter() - pb / 3;
			Hball3y = ball3.getYCenter() - pb / 3;
			Hball3x = ball3.getXCenter() + pb / 3;
			Hball3y = ball3.getYCenter() - pb / 3;
			Hball3x = ball3.getXCenter() + pb / 3;
			Hball3y = ball3.getYCenter() + pb / 3;
			Hball3x = ball3.getXCenter() - pb / 3;
			Hball3y = ball3.getYCenter() + pb / 3;
			if (player.isPointInElement(Hball3x, Hball3y) && score % 9 == 0) {
				lives--;
				ouch.play();
			}
			// ball4 hitbox
			Hball4x = ball4.getXCenter() - pb / 3;
			Hball4y = ball4.getYCenter() - pb / 3;
			Hball4x = ball4.getXCenter() + pb / 3;
			Hball4y = ball4.getYCenter() - pb / 3;
			Hball4x = ball4.getXCenter() + pb / 3;
			Hball4y = ball4.getYCenter() + pb / 3;
			Hball4x = ball4.getXCenter() - pb / 3;
			Hball4y = ball4.getYCenter() + pb / 3;
			if (player.isPointInElement(Hball4x, Hball4y) && score % 7 == 0) {
				lives--;
				ouch.play();
			} // loop exit and lives detector
			if (lives <= 0) { // stops game when live reach 0 [or below 0 as it could from time to time...]
				game--;
			}
			// push text to front
			text.pullToFront();
			text2.pullToFront();
			// show lives
			text.setMsg("Lives Left: " + lives);
			// show score
			text2.setMsg("Score: " + score);

		}
		// game over screen
		ooob.stop();// stop scoring
		EZSound RIP = EZ.addSound("gg.wav");// add game over sound
		RIP.loop();// loop game over music
		text.hide(); // remove text 1
		text2.hide(); // remove text 2
		// game over text
		int fontsize3 = 150;
		Color go = new Color(242, 55, 55);
		EZText gameover = EZ.addText(512, 304, "GAME OVER", go, fontsize3);
		text.setFont("text.ttf");
		gameover.pullToFront();
		// final score
		Color fin = new Color(245, 247, 106);
		EZText finalscore = EZ.addText(512, 384, "Final Score: " + score, fin, 40);
		finalscore.pullToFront();
		System.out.println(score); //in case can't see
	}

}