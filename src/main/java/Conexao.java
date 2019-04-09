/**
 * Classe de estabelecimento de conexão com servidor
 * 
 * @author vbiavatti
 */
public class Conexao {

	private String ip;
	private int porta;
	
	/**
	 * Construir Conexão
	 * @param ip
	 * @param porta
	 */
	public Conexao(String ip, int porta) {
		super();
		this.ip = ip;
		this.porta = porta;
	}
	
	public String getIp() {
		return ip;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public int getPorta() {
		return porta;
	}
	
	public void setPorta(int porta) {
		this.porta = porta;
	}
}
