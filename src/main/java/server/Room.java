package server;

public class Room {
	private int number;
	private String status;
	private boolean lightOn;
	//getters and setters
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isLightOn() {
		return lightOn;
	}
	public void setLightOn(boolean lightOn) {
		this.lightOn = lightOn;
	}	
}
