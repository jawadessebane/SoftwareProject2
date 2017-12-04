package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Training", catalog = "SP2Team08")
public class Training implements Serializable {

	private Integer idTraining;
	private Adres adres;
	private Leerkracht leerkracht;
	private String trainingNaam;
	private LocalDate datum;
	private String status;
	private Boolean archief;
	private Set<TrainingDetail> trainingDetails = new HashSet<TrainingDetail>(0);

	public Training() {
	}

	

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idTraining", unique = true, nullable = false)
	public Integer getIdTraining() {
		return this.idTraining;
	}

	public void setIdTraining(Integer idTraining) {
		this.idTraining = idTraining;
	}


	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idAdres", nullable = false)
	public Adres getAdres() {
		return this.adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idLeerkracht", nullable = false)
	public Leerkracht getLeerkracht() {
		return this.leerkracht;
	}

	public void setLeerkracht(Leerkracht leerkracht) {
		this.leerkracht = leerkracht;
	}

	@Column(name = "trainingNaam", nullable = false, length = 30)
	public String getTrainingNaam() {
		return this.trainingNaam;
	}

	public void setTrainingNaam(String trainingNaam) {
		this.trainingNaam = trainingNaam;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "training")
	public Set<TrainingDetail> getTrainingDetails() {
		return this.trainingDetails;
	}

	public void setTrainingDetails(Set<TrainingDetail> trainingDetails) {
		this.trainingDetails = trainingDetails;
	}



	public LocalDate getDatum() {
		return datum;
	}



	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public Boolean getArchief() {
		return archief;
	}



	public void setArchief(Boolean archief) {
		this.archief = archief;
	}

}
