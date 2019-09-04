package comm.ibm.fsd.cd_example_3rd_sep_19.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.InheritanceType;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.DiscriminatorType;

@Entity
@Table(name ="cd" )
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "cd_type")
@DiscriminatorValue("CD")


public class CD {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="artist")
	private String artist;
	@Column(name="title")
	private String title;
	@Column(name="purchasedate")
	private Date purchaseDate;
	@Column(name="cost")
    double cost;
	
    public CD() {
		super();
	}

	public CD(String artist, String title, Date purchaseDate, double cost) {
		super();
		this.artist = artist;
		this.title = title;
		this.purchaseDate = purchaseDate;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
}
