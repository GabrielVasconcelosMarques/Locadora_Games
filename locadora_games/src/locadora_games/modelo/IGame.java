package locadora_games.modelo;

public interface IGame {
	
	public int getCodigo();
	public void setCodigo(int codigo);

	public String getMarca();
	public void setMarca(String marca);

	public String getNome();
	public void setNome(String nome);

	public String getGenero();
	public void setGenero(String genero);

	public String getConsole();
	public void setConsole(String console);

	public String getNumeroJogadores();
	public void setNumeroJogadores(String numeroJogadores);

	public String getClassificacao();
	public void setClassificacao(String classificacao);

	public String getIdioma();
	public void setIdioma(String idioma);

	public String getAnoLancamento();
	public void setAnoLancamento(String anoLancamento);

	public String getStatus();
	public void setStatus(String status);

	public float getValorAluguel();
	public void setValorAluguel(float valorAluguel);
}
