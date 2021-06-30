package model;

public class Schedule {
	private String schedule_name;
	private String schedule_date;
	private int schedule_sq;
	public String getSchedule_name() {
		return schedule_name;
	}
	public void setSchedule_name(String schedule_name) {
		this.schedule_name = schedule_name;
	}
	public String getSchedule_date() {
		return schedule_date;
	}
	public void setSchedule_date(String schedule_date) {
		this.schedule_date = schedule_date;
	}
	public int getSchedule_sq() {
		return schedule_sq;
	}
	public void setSchedule_sq(int schedule_sq) {
		this.schedule_sq = schedule_sq;
	}
	@Override
	public String toString() {
		return "Schedule [schedule_name=" + schedule_name + ", schedule_date=" + schedule_date + ", schedule_sq="
				+ schedule_sq + "]";
	}
	
}
