package avioes.apoo.app;

public class Passageiros extends Pessoa {
	
	private String email;
	private String tipoBilhete;
	private String lugarReservado;
	
	public Passageiros(int id, String nome, String nacionalidade, String morada, int telefone, String dataDeNascimento,
			String email, String tipoBilhete, String lugarReservado) {
		
		super(id, nome, nacionalidade, morada, telefone, dataDeNascimento);
		this.email = email;
		this.tipoBilhete = tipoBilhete;
		this.lugarReservado = lugarReservado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipoBilhete() {
		return tipoBilhete;
	}

	public void setTipoBilhete(String tipoBilhete) {
		this.tipoBilhete = tipoBilhete;
	}

	public String getLugarReservado() {
		return lugarReservado;
	}

	public void setLugarReservado(String lugarReservado) {
		this.lugarReservado = lugarReservado;
	}
	
	

}
