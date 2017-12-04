package model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Adres", catalog = "SP2Team08")
public class Adres implements java.io.Serializable {

	private Integer idAdres;
	private String straat;
	private int huisnum;
	private int postcode;
	private String stad;
	private String land;
	private Set<Leerkracht> leerkrachts = new HashSet<Leerkracht>(0);
	private Set<Training> trainings = new HashSet<Training>(0);

	public Adres() {
	}

	public Adres(String straat, int huisnum, int postcode, String stad, String land) {
		this.straat = straat;
		this.huisnum = huisnum;
		this.postcode = postcode;
		this.stad = stad;
		this.land = land;
	}

	public Adres(String straat, int huisnum, int postcode, String stad, String land, Set<Leerkracht> leerkrachts,
			Set<Training> trainings) {
		this.straat = straat;
		this.huisnum = huisnum;
		this.postcode = postcode;
		this.stad = stad;
		this.land = land;
		this.leerkrachts = leerkrachts;
		this.trainings = trainings;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idAdres", unique = true, nullable = false)
	public Integer getIdAdres() {
		return this.idAdres;
	}

	public void setIdAdres(Integer idAdres) {
		this.idAdres = idAdres;
	}

	@Column(name = "straat", nullable = false, length = 20)
	public String getStraat() {
		return this.straat;
	}

	public void setStraat(String straat) {
		this.straat = straat;
	}

	@Column(name = "huisnum", nullable = false)
	public int getHuisnum() {
		return this.huisnum;
	}

	public void setHuisnum(int huisnum) {
		this.huisnum = huisnum;
	}

	@Column(name = "postcode", nullable = false)
	public int getPostcode() {
		return this.postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	@Column(name = "stad", nullable = false, length = 20)
	public String getStad() {
		return this.stad;
	}

	public void setStad(String stad) {
		this.stad = stad;
	}

	@Column(name = "land", nullable = false, length = 20)
	public String getLand() {
		return this.land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "adres")
	public Set<Leerkracht> getLeerkrachts() {
		return this.leerkrachts;
	}

	public void setLeerkrachts(Set<Leerkracht> leerkrachts) {
		this.leerkrachts = leerkrachts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "adres")
	public Set<Training> getTrainings() {
		return this.trainings;
	}

	public void setTrainings(Set<Training> trainings) {
		this.trainings = trainings;
	}

}
