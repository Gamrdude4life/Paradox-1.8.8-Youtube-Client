package me.gamrboy4life.paradox.utils;

public class Timer2 {
	
	public static short convert(float perSecond) {
		return (short)(1000 / perSecond);
	}
	
	public static long getCurrentTime() {
		return System.nanoTime() / 1000000;
	}
	
	private long previousTime;
	
	public Timer2() {
		previousTime = -1;
	}
	
	public long get() {
		return previousTime;
	}
	
	public boolean check(float milliseconds) {
		return Timer2.getCurrentTime() - previousTime >= milliseconds;
	}
	
	public void reset() {
		previousTime = Timer2.getCurrentTime();
	}
	

}
