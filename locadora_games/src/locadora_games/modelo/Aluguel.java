package locadora_games.modelo;

import java.io.Serializable;

public class Aluguel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int codigo;
	Cliente cliente;
	IGame game;
	String dataAluguel;
	String dataDevolu��o;
	float valorAPagar;
	
	
	public Aluguel(int codigo, Cliente cliente, IGame game, String dataAluguel, String dataDevolu��o, float valorAPagar) {
		super();
		this.codigo = codigo;
		this.cliente = cliente;
		this.game = game;
		this.dataAluguel = dataAluguel;
		this.dataDevolu��o = dataDevolu��o;
		this.valorAPagar = valorAPagar;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	@Override
	public String toString() {
		return "Aluguel [cliente=" + cliente + ", game=" + game + ", dataAluguel=" + dataAluguel + ", dataDevolu��o="
				+ dataDevolu��o + ", valorAPagar=" + valorAPagar + "]";
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public IGame getGame() {
		return game;
	}


	public void setGame(IGame game) {
		this.game = game;
	}


	public String getDataAluguel() {
		return dataAluguel;
	}


	public void setDataAluguel(String dataAluguel) {
		this.dataAluguel = dataAluguel;
	}


	public String getDataDevolu��o() {
		return dataDevolu��o;
	}


	public void setDataDevolu��o(String dataDevolu��o) {
		this.dataDevolu��o = dataDevolu��o;
	}


	public float getValorAPagar() {
		return valorAPagar;
	}


	public void setValorAPagar(float valorAPagar) {
		this.valorAPagar = valorAPagar;
	}


	
	

}
