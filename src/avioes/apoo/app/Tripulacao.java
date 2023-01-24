package avioes.apoo.app;

public class Tripulacao extends Pessoa {
	
	private String nLincenca;
	private String dataDeValidade;
	private String anotacoes;
	private String categoria;
	private String nVoo;
	
	public Tripulacao(String id, String nVoo, String nome, String nacionalidade, String morada, String telefone, String dataDeNascimento,
			String nLincenca, String dataDeValidade, String anotacoes, String categoria) {
		super(id, nome, nacionalidade, morada, telefone, dataDeNascimento);
		this.nLincenca = nLincenca;
		this.dataDeValidade = dataDeValidade;
		this.anotacoes = anotacoes;
		this.categoria = categoria;
		this.nVoo = nVoo;
	}

	public Tripulacao() {
		
	}
	
	public String getnVoo() {
		return this.nVoo;
	}

	public void setnVoo(String nVoo) {
		this.nVoo = nVoo;
	}

	public String getnLincenca() {
		return nLincenca;
	}

	public void setnLincenca(String nLincenca) {
		this.nLincenca = nLincenca;
	}

	public String getDataDeValidade() {
		return dataDeValidade;
	}

	public void setDataDeValidade(String dataDeValidade) {
		this.dataDeValidade = dataDeValidade;
	}

	public String getAnotacoes() {
		return anotacoes;
	}

	public void setAnotacoes(String anotacoes) {
		this.anotacoes = anotacoes;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Tripulantes [\nId: " + getId() + "\nNome: " + getNome() + "\nNacionalidade: " + getNacionalidade() + 
				"\nMorada: " + getMorada() + "\ntelefone: " + getTelefone() + "\nData de nascimento: " + 
				getDataDeNascimento() + "[\nN�mero da lincenca: " + nLincenca + "\nData de validade: " + dataDeValidade + "\nAnota��es: " + anotacoes
				+ "\nCategoria: " + categoria + "]" + "\n" + 
				"------------------------------------------------------";
				
	}
	
	

}
