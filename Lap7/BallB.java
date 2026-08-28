package Lap7;

public class BallB extends BallA{
	
	public BallB(String treadMark) {
		super(treadMark);
		
	}
	
	public void inflate(double volume)
	{
		System.out.println(getTreadMark() + "'s ball is inflated " + volume + " cu.ft.");
	}
	public void roll()
	{
		System.out.println(getTreadMark() + " rolls smoothly.");
	}
}
