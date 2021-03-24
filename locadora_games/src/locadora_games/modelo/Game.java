package locadora_games.modelo;

import java.io.Serializable;

public class Game implements IGame, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int codigo;
	String marca;
	String nome;
	String genero;
	String console;
	String numeroJogadores;
	String classificacao;
	String idioma;
	String anoLancamento;
	String status;
	float valorAluguel;
	
	
	public Game(int codigo, String marca, String nome,String genero, String console, String numeroJogadores,
			String classificacao, String idioma, String anoLancamento, float valorAluguel) {
		super();
		this.codigo = codigo;
		this.marca = marca;
		this.nome = nome;
		this.genero = genero;
		this.console = console;
		this.numeroJogadores = numeroJogadores;
		this.classificacao = classificacao;
		this.idioma = idioma;
		this.anoLancamento = anoLancamento;
		this.status = "Disponível";
		this.valorAluguel = valorAluguel;
	}
	
	

	
	public Game(int codigo, String nome, String genero, String console, float valorAluguel) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.genero = genero;
		this.console = console;
		this.valorAluguel = valorAluguel;
	}






	public Game(int codigo) {
		super();
		this.codigo = codigo;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}



	



	@Override
	public String toString() {
		return "" + nome + " - " + console + "";
	}




	public Game(int codigo, String nome, String console) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.console = console;
	}




	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public String getMarca() {
		return marca;
	}



	public void setMarca(String marca) {
		this.marca = marca;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getGenero() {
		return genero;
	}



	public void setGenero(String genero) {
		this.genero = genero;
	}



	public String getConsole() {
		return console;
	}



	public void setConsole(String console) {
		this.console = console;
	}



	public String getNumeroJogadores() {
		return numeroJogadores;
	}



	public void setNumeroJogadores(String numeroJogadores) {
		this.numeroJogadores = numeroJogadores;
	}



	public String getClassificacao() {
		return classificacao;
	}



	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}



	public String getIdioma() {
		return idioma;
	}



	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}



	public String getAnoLancamento() {
		return anoLancamento;
	}



	public void setAnoLancamento(String anoLancamento) {
		this.anoLancamento = anoLancamento;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public float getValorAluguel() {
		return valorAluguel;
	}



	public void setValorAluguel(float valorAluguel) {
		this.valorAluguel = valorAluguel;
	}
	
	
	

}
