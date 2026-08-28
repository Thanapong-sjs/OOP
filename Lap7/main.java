package Lap7;

public class main {
	public static void main(String[] args)
	{
		Ball ballA = new BallA("Zentia");
		TestBall(ballA,1.0);
		Ball ballB = new BallB("Zapphire");
		TestBall(ballB,1.1);
		Ball ballC = new BallC("Zenith");
		TestBall(ballC,1.2);
	}
		public static void TestBall(Ball ball,double volume)
		{
			ball.inflate(volume);
			((RollAble) ball).roll();
		}
}
