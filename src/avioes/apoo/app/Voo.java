package avioes.apoo.app;

public class Voo {
	
	private String nVoo;
	private String aviao;
	private String aeroOrigem;
	private String aeroDestino;
	private String dataDePartida;
	private String dataDeChegada;
	private String horaDePartida;
	private String horaDeChegada;
	
	public Voo(String nVoo, String aviao, String aeroOrigem, String aeroDestino, String dataDePartida,String dataDeChegada,  
			String horaDePartida, String horaDeChegada) {
		super();
		this.nVoo = nVoo;
		this.aviao = aviao;
		this.aeroOrigem = aeroOrigem;
		this.aeroDestino = aeroDestino;
		this.dataDePartida = dataDePartida;
		this.dataDeChegada = dataDeChegada;
		this.horaDePartida = horaDePartida;
		this.horaDeChegada = horaDeChegada;
		
		
	}

	public Voo() {
		
	}

	public String getnVoo() {
		return nVoo;
	}

	public void setnVoo(String nVoo) {
		this.nVoo = nVoo;
	}

	public String getAviao() {
		return aviao;
	}

	public void setAviao(String aviao) {
		this.aviao = aviao;
	}

	public String getAeroOrigem() {
		return aeroOrigem;
	}

	public void setAeroOrigem(String aeroOrigem) {
		this.aeroOrigem = aeroOrigem;
	}

	public String getAeroDestino() {
		return aeroDestino;
	}

	public void setAeroDestino(String aeroDestino) {
		this.aeroDestino = aeroDestino;
	}

	public String getDataDePartida() {
		return dataDePartida;
	}

	public void setDataDePartida(String dataDePartida) {
		this.dataDePartida = dataDePartida;
	}

	public String getDataDeChegada() {
		return dataDeChegada;
	}

	public void setDataDeChegada(String dataDeChegada) {
		this.dataDeChegada = dataDeChegada;
	}

	public String getHoraDePartida() {
		return horaDePartida;
	}

	public void setHoraDePartida(String horaDePartida) {
		this.horaDePartida = horaDePartida;
	}

	public String getHoraDeChegada() {
		return horaDeChegada;
	}

	public void setHoraDeChegada(String horaDeChegada) {
		this.horaDeChegada = horaDeChegada;
	}

	@Override
	public String toString() {
		return "Voos[\nVoo: " + nVoo + " \nNúmero do avião: " + aviao + " \nAeroporto de origem: " + aeroOrigem + " \nAeroporto de destino: "
				+ aeroDestino + " \nData de partida: " + dataDePartida + " \nData de chegada: " + dataDeChegada
				+ " \nHora de partida: " + horaDePartida + " \nHora de chegada: " + horaDeChegada + "]\n" + 
				"--------------------------------------------------------------------";
	}

	
	
}
