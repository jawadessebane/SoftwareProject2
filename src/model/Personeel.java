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
@Table(name = "Personeel", catalog = "SP2Team08")
public class Personeel implements java.io.Serializable {

	private Integer idPersoneel;
	private String voornaam;
	private String familienaam;
	private int idAdres;
	private String afdeling;
	private String functie;
	private boolean fire;
	private Set<Login> logins = new HashSet<Login>(0);
	private Set<TrainingDetail> trainingDetails = new HashSet<TrainingDetail>(0);

	public Personeel() {
	}

	public Personeel(String voornaam, String familienaam, int idAdres, String afdeling, String functie, boolean fire) {
		this.voornaam = voornaam;
		this.familienaam = familienaam;
		this.idAdres = idAdres;
		this.afdeling = afdeling;
		this.functie = functie;
		this.fire = fire;
	}

	public Personeel(String voornaam, String familienaam, int idAdres, String afdeling, String functie, boolean fire,
			Set<Login> logins, Set<TrainingDetail> trainingDetails) {
		this.voornaam = voornaam;
		this.familienaam = familienaam;
		this.idAdres = idAdres;
		this.afdeling = afdeling;
		this.functie = functie;
		this.fire = fire;
		this.logins = logins;
		this.trainingDetails = trainingDetails;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idPersoneel", unique = true, nullable = false)
	public Integer getIdPersoneel() {
		return this.idPersoneel;
	}

	public void setIdPersoneel(Integer idPersoneel) {
		this.idPersoneel = idPersoneel;
	}

	@Column(name = "voornaam", nullable = false, length = 30)
	public String getVoornaam() {
		return this.voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	@Column(name = "familienaam", nullable = false, length = 30)
	public String getFamilienaam() {
		return this.familienaam;
	}

	public void setFamilienaam(String familienaam) {
		this.familienaam = familienaam;
	}

	@Column(name = "idAdres", nullable = false)
	public int getIdAdres() {
		return this.idAdres;
	}

	public void setIdAdres(int idAdres) {
		this.idAdres = idAdres;
	}

	@Column(name = "afdeling", nullable = false, length = 30)
	public String getAfdeling() {
		return this.afdeling;
	}

	public void setAfdeling(String afdeling) {
		this.afdeling = afdeling;
	}

	@Column(name = "functie", nullable = false, length = 30)
	public String getFunctie() {
		return this.functie;
	}

	public void setFunctie(String functie) {
		this.functie = functie;
	}

	@Column(name = "fire", nullable = false)
	public boolean isFire() {
		return this.fire;
	}

	public void setFire(boolean fire) {
		this.fire = fire;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personeel")
	public Set<Login> getLogins() {
		return this.logins;
	}

	public void setLogins(Set<Login> logins) {
		this.logins = logins;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personeel")
	public Set<TrainingDetail> getTrainingDetails() {
		return this.trainingDetails;
	}

	public void setTrainingDetails(Set<TrainingDetail> trainingDetails) {
		this.trainingDetails = trainingDetails;
	}

}
