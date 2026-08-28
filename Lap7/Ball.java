package Lap7;

public abstract class Ball {
	private String treadMark;
	
	public abstract void inflate(double volume);

	public Ball(String treadMark) {
		this.treadMark = treadMark;
		System.out.println(treadMark + " is a treadmark of " + this.getClass().getSimpleName() + ".");
	}
	
	public String getTreadMark() {
		return treadMark;
	}

	public void setTreadMark(String treadMark) {
		this.treadMark = treadMark;
	}

}
