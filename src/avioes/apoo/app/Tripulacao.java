package avioes.apoo.app;

public class Tripulacao extends Pessoa {
	
	private int nLincenca;
	private String dataDeValidade;
	private String anotacoes;
	private String categoria;
	
	public Tripulacao(int id, String nome, String nacionalidade, String morada, int telefone, String dataDeNascimento,
			int nLincenca, String dataDeValidade, String anotacoes, String categoria) {
		super(id, nome, nacionalidade, morada, telefone, dataDeNascimento);
		this.nLincenca = nLincenca;
		this.dataDeValidade = dataDeValidade;
		this.anotacoes = anotacoes;
		this.categoria = categoria;
	}

	public int getnLincenca() {
		return nLincenca;
	}

	public void setnLincenca(int nLincenca) {
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
	
	

}
