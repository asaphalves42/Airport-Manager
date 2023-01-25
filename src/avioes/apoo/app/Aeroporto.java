package avioes.apoo.app;

public class Aeroporto {
	
	private String sigla;
	private String país;
	private String aeroportoMaisProximo;
	
		public Aeroporto (String sigla, String país, String aeroportoMaisProximo) {
			
			super();
			this.sigla = sigla;
			this.país = país;
			this.aeroportoMaisProximo = aeroportoMaisProximo;
			
		}

		public String getSigla() {
			return sigla;
		}

		public void setSigla(String sigla) {
			this.sigla = sigla;
		}

		public String getPaís() {
			return país;
		}

		public void setPaís(String país) {
			this.país = país;
		}

		public String getAeroportoMaisProximo() {
			return aeroportoMaisProximo;
		}

		public void setAeroportoMaisProximo(String aeroportoMaisProximo) {
			this.aeroportoMaisProximo = aeroportoMaisProximo;
		}
		

}
