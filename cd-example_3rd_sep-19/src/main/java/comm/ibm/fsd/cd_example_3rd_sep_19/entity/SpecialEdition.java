package comm.ibm.fsd.cd_example_3rd_sep_19.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity

@DiscriminatorValue("Special_edition_CD")
public class SpecialEdition extends CD{

	@Column(name="newfeatures")
	private String newFreatures;

	public SpecialEdition() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SpecialEdition(String artist, String title, Date purchaseDate, double cost, String newFeatures) {
		super(artist, title, purchaseDate, cost);
		this.newFreatures=newFeatures;
		
	}

	public String getNewFreatures() {
		return newFreatures;
	}

	public void setNewFreatures(String newFreatures) {
		this.newFreatures = newFreatures;
	}	
	
}
