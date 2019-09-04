package comm.ibm.fsd.cd_example_3rd_sep_19.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity

@DiscriminatorValue("International CD")

public class InternationalCD extends CD{

	@Column(name="languages")
	private String languages;
	@Column(name="region")
	private String region;
	
	
	public InternationalCD() {
		super();
	}


	public InternationalCD(String artist, String title, Date purchaseDate, double cost, String languages, String region) {
		super(artist, title, purchaseDate, cost);
		this.languages=languages;
		this.region= region;
		
	}


	public String getLanguages() {
		return languages;
	}


	public void setLanguages(String languages) {
		this.languages = languages;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}
	
	
}
