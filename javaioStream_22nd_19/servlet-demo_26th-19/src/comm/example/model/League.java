package comm.example.model;

import java.io.Serializable;

public class League implements Serializable{

	private static final long serialVersionUID = 1L;
    private String title;
    private String season;
    private int leagueYear;
    
    
    
	public League() {
		super();
	}

	public League(String title, String season, int leagueYear) {
		super();
		this.title = title;
		this.season = season;
		this.leagueYear = leagueYear;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public int getLeagueYear() {
		return leagueYear;
	}
	public void setLeagueYear(int leagueYear) {
		this.leagueYear = leagueYear;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
	
}
