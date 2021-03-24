package locadora_games.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import locadora_games.exception.ClienteJaCadastradoException;
import locadora_games.exception.GameJaCadastradoException;
import locadora_games.modelo.Aluguel;
import locadora_games.modelo.Cliente;
import locadora_games.modelo.Game;
import locadora_games.modelo.IGame;

public class PersistenciaEmBanco {
	
	private static PersistenciaEmBanco instance;

    private PersistenciaEmBanco() {
        // TODO Auto-generated constructor stub
    }

    public static PersistenciaEmBanco pegarInstancia()
    {
        if(instance != null)
            return instance;
        else
        {
            return instance = new PersistenciaEmBanco();
        }
    }
    
    
    // CRUD Cliente
    
    public void CadastrarCliente(Cliente obj) throws ClienteJaCadastradoException{
        String sql = "insert into cliente (cpf, nome, data_de_nascimento, sexo, rua, numero, bairro, cidade, telefone)"
                + " values (?,?,?,?,?,?,?,?,?);";

        try 
        {
            PreparedStatement pstmt = FabricaConexao.getConnection().prepareStatement(sql);
            pstmt.setString(1, obj.getCpf());
            pstmt.setString(2, obj.getNome());
            pstmt.setString(3, obj.getDataNascimento());
            pstmt.setString(4, obj.getSexo());
            pstmt.setString(5, obj.getRua());
            pstmt.setInt(6, obj.getNumero());
            pstmt.setString(7, obj.getBairro());
            pstmt.setString(8, obj.getCidade());
            pstmt.setString(9, obj.getTelefone());

            pstmt.execute();
            pstmt.close();

            System.out.println("inserido com sucesso");

        } catch (SQLException e) {
        	//e.printStackTrace();
            // TODO Auto-generated catch block
            throw new ClienteJaCadastradoException("Cliente já Cadastrado!");
            //JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public List<Cliente> getAllClientes() {

        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        String sql = "select * from cliente";

        try
        {
            PreparedStatement pstmt = FabricaConexao.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String telefone = rs.getString("telefone");

                Cliente cliente = new Cliente(nome, cpf, telefone);
                clientes.add(cliente);

            }

            pstmt.execute();
            pstmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            //JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return clientes;
    }
    
    
    // busca separada por nome 
    
    public ArrayList<Cliente> todosClientesPorNome(String nomeDoCliente) {

        ArrayList<Cliente> listaTodosClientes = new ArrayList<Cliente>();
        
    

        String sql = "select * from cliente where nome like '%"+nomeDoCliente+"%'";
        
        try
        {
            PreparedStatement pstmt = FabricaConexao.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
            	String cpf = rs.getString("cpf");
                String nome = rs.getString("nome");
                String dataNascimento = rs.getString("data_de_nascimento");
                String sexo = rs.getString("sexo");
                String rua = rs.getString("rua");
                int numero = rs.getInt("numero");
                String bairro = rs.getString("bairro");
                String cidade = rs.getString("cidade");
                String telefone = rs.getString("telefone");

                Cliente cliente = new Cliente(cpf, nome, dataNascimento, telefone, sexo, rua, numero, bairro, cidade);
                listaTodosClientes.add(cliente);

            }

            pstmt.execute();
            pstmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            //JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return listaTodosClientes;

        
    }
    
    // CRUD Games
    
    public void CadastrarGame(IGame obj) throws GameJaCadastradoException{
        String sql = "insert into game (marca, nome, genero, console, numjogador, classificacao, idioma, anolancamento, status, valoraluguel)"
                + " values (?,?,?,?,?,?,?,?,?,?);";

        try 
        {
            PreparedStatement pstmt = FabricaConexao.getConnection().prepareStatement(sql);
            pstmt.setString(1, obj.getMarca());
            pstmt.setString(2, obj.getNome());
            pstmt.setString(3, obj.getGenero());
            pstmt.setString(4, obj.getConsole());
            pstmt.setString(5, obj.getNumeroJogadores());
            pstmt.setString(6, obj.getClassificacao());
            pstmt.setString(7, obj.getIdioma());
            pstmt.setString(8, obj.getAnoLancamento());
            pstmt.setString(9, obj.getStatus());
            pstmt.setFloat(10, obj.getValorAluguel());

            pstmt.execute();
            pstmt.close();

            System.out.println("inserido com sucesso");

        } catch (SQLException e) {
        	//e.printStackTrace();
            // TODO Auto-generated catch block
        	throw new GameJaCadastradoException("Game já Cadastrado!");
            //JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
    public ArrayList<IGame> getAllGames() {

        ArrayList<IGame> games = new ArrayList<IGame>();

        String sql = "select * from game";

        try
        {
            PreparedStatement pstmt = FabricaConexao.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
            	int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                String genero = rs.getString("genero");
                String console = rs.getString("console");
                float valorAluguel = rs.getFloat("valoraluguel");

                IGame game = new Game(codigo, nome, genero, console, valorAluguel);
                games.add(game);

            }

            pstmt.execute();
            pstmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            //JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return games;
    }
    
    
    // CRUD Aluguel
    
    public ArrayList<Cliente> todosClientes() {

        ArrayList<Cliente> listaTodosClientes = new ArrayList<Cliente>();

        String sql = "select * from cliente";

        try
        {
            PreparedStatement pstmt = FabricaConexao.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
            	
            	String cpf = rs.getString("cpf");
            	String nome = rs.getString("nome");
            	String telefone = rs.getString("telefone");
            	
            	Cliente cliente = new Cliente(cpf, nome, telefone);
            	
            	listaTodosClientes.add(cliente);

            }

            pstmt.execute();
            pstmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            //JOptionPane.showMessageDialog(null, e.getMessage());
        }
    
        return listaTodosClientes;
    }
    
    
    
    public ArrayList<IGame> todosGames() {

        ArrayList<IGame> listaTodosGames = new ArrayList<IGame>();

        String sql = "select * from game";

        try
        {
            PreparedStatement pstmt = FabricaConexao.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
            	
            	int codigo = rs.getInt("codigo");
            	String nome = rs.getString("nome");
            	String console = rs.getString("console");
            	
            	IGame game = new Game(codigo, nome, console);
            	
            	listaTodosGames.add(game);

            }

            pstmt.execute();
            pstmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            //JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return listaTodosGames;
    }
    
    // busca separada por nome 
    
    public ArrayList<IGame> todosGamesPorNome(String nomeDoGame) {

        ArrayList<IGame> listaTodosGames = new ArrayList<IGame>();
        
    

        String sql = "select * from game where nome like '%"+nomeDoGame+"%'";
        
        try
        {
            PreparedStatement pstmt = FabricaConexao.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
            	int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                String genero = rs.getString("genero");
                String console = rs.getString("console");
                float valorAluguel = rs.getFloat("valoraluguel");

                IGame game = new Game(codigo, nome, genero, console, valorAluguel);
                listaTodosGames.add(game);

            }

            pstmt.execute();
            pstmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            //JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return listaTodosGames;

        
    }
    
    
    public void CadastrarAluguel(Aluguel obj) {
        String sql = "insert into cliente_aluga_game (cpf_cliente, codigo_game, data_aluguel, data_devolucao, valor_a_pagar)"
                + " values (?,?,?,?,?);";

        try 
        {
            PreparedStatement pstmt = FabricaConexao.getConnection().prepareStatement(sql);
            pstmt.setString(1, obj.getCliente().getCpf());
            pstmt.setInt(2, obj.getGame().getCodigo());
            pstmt.setString(3, obj.getDataAluguel());
            pstmt.setString(4, obj.getDataDevolução());
            pstmt.setFloat(5, obj.getValorAPagar());
  
            pstmt.execute();
            pstmt.close();

            System.out.println("inserido com sucesso");

        } catch (SQLException e) {
        	e.printStackTrace();
            // TODO Auto-generated catch block
           // throw new ClienteJaCadastradoException("Cliente já Cadastrado!");
            //JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
    public ArrayList<Aluguel> getAllAlugueis() {

        ArrayList<Aluguel> alugueis = new ArrayList<Aluguel>();

        String sql = "select * from cliente_aluga_game";

        try
        {
            PreparedStatement pstmt = FabricaConexao.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
            	int codigo = rs.getInt("codigo");
            	
                String cpf = rs.getString("cpf_cliente");
                Cliente cliente = new Cliente(cpf);
                int codGame = rs.getInt("codigo_game");
                IGame game = new Game(codGame);
                String data_aluguel = rs.getString("data_aluguel");
                String data_devolucao = rs.getString("data_devolucao");
                float valor_a_pagar = rs.getFloat("valor_a_pagar");

                Aluguel aluguel = new Aluguel(codigo, cliente, game, data_aluguel, data_devolucao, valor_a_pagar);
                alugueis.add(aluguel);

            }

            pstmt.execute();
            pstmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            //JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return alugueis;
    }
}
