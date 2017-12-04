package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Login", catalog = "SP2Team08")
public class Login implements java.io.Serializable {

	private Integer idLogin;
	private Personeel personeel;
	private String username;
	private String password;

	public Login() {
	}

	public Login(Personeel personeel, String username, String password) {
		this.personeel = personeel;
		this.username = username;
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idLogin", unique = true, nullable = false)
	public Integer getIdLogin() {
		return this.idLogin;
	}

	public void setIdLogin(Integer idLogin) {
		this.idLogin = idLogin;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPersoneel", nullable = false)
	public Personeel getPersoneel() {
		return this.personeel;
	}

	public void setPersoneel(Personeel personeel) {
		this.personeel = personeel;
	}

	@Column(name = "username", nullable = false, length = 10)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
