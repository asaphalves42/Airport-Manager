package avioes.apoo.app;

public class Aeronave {
	private int nRegistro;
	private String marcaEmodelo;
	private int NlugaresTuristica;
	private int NlugaresExecutiva;
	
	public Aeronave(int nRegistro, String marcaEmodelo, int nlugaresTuristica, int nlugaresExecutiva) {
		super();
		this.nRegistro = nRegistro;
		this.marcaEmodelo = marcaEmodelo;
		NlugaresTuristica = nlugaresTuristica;
		NlugaresExecutiva = nlugaresExecutiva;
	}

	public int getnRegistro() {
		return nRegistro;
	}

	public void setnRegistro(int nRegistro) {
		this.nRegistro = nRegistro;
	}

	public String getMarcaEmodelo() {
		return marcaEmodelo;
	}

	public void setMarcaEmodelo(String marcaEmodelo) {
		this.marcaEmodelo = marcaEmodelo;
	}

	public int getNlugaresTuristica() {
		return NlugaresTuristica;
	}

	public void setNlugaresTuristica(int nlugaresTuristica) {
		NlugaresTuristica = nlugaresTuristica;
	}

	public int getNlugaresExecutiva() {
		return NlugaresExecutiva;
	}

	public void setNlugaresExecutiva(int nlugaresExecutiva) {
		NlugaresExecutiva = nlugaresExecutiva;
	}
	
	
}
