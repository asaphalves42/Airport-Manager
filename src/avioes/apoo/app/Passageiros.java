package avioes.apoo.app;

public class Passageiros extends Pessoa {
	
	private String email;
	private String tipoBilhete;
	private String lugarReservado;
	private String nVoo;
	
	public Passageiros(String id, String nVoo, String nome, String nacionalidade, String morada, String telefone, String dataDeNascimento,
			String email, String tipoBilhete, String lugarReservado) {
		
		this.email = email;
		this.tipoBilhete = tipoBilhete;
		this.lugarReservado = lugarReservado;
		this.nVoo = nVoo;
	}

	public Passageiros() {
		
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
	

	public String getnVoo() {
		return nVoo;
	}

	public void setnVoo(String nVoo) {
		this.nVoo = nVoo;
	}

	@Override
	public String toString() {
		return "Passageiros [\nId: " + getId() + "\nNome: " + getNome() + "\nNacionalidade: " + getNacionalidade() + 
				"\nMorada: " + getMorada() + "\ntelefone: " + getTelefone() + "\nData de nascimento: " + getDataDeNascimento() + "\ne-mail: " + email + 
				"\ntipoBilhete: " + tipoBilhete + "\nLugar reservado: " + lugarReservado
				+ "]" + "\n" + 
				"---------------------------------------";
		
		
	}
	
	
	

}
