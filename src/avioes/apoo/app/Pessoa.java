package avioes.apoo.app;

public class Pessoa {
	
	private int id;
	private String nome;
	private String nacionalidade;
	private String morada;
	private int telefone;
	private String dataDeNascimento;
	
	
	public Pessoa(int id, String nome, String nacionalidade, String morada, int telefone, String dataDeNascimento) {
			
		super();
		this.id = id;
		this.nome = nome;
		this.nacionalidade = nacionalidade;
		this.morada = morada;
		this.telefone = telefone;
		this.dataDeNascimento = dataDeNascimento;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getMorada() {
		return morada;
	}

	public void setMorada(String morada) {
		this.morada = morada;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	
}
	