package locadora_games.gui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;

import locadora_games.enumerates.Genero;
import locadora_games.enumerates.Status;
import locadora_games.exception.GameJaCadastradoException;
import locadora_games.modelo.Game;
import locadora_games.persistencia.PersistenciaEmBanco;

import javax.swing.border.BevelBorder;
import javax.swing.JButton;

public class TelaCadastroGame extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel lblTituloGames;
	private JLabel lblConsole;
	private JComboBox comboBoxConsole;
	private JLabel lblNomeGame;
	private JTextField txfNome;
	private JLabel lblMarca;
	private JTextField txfMarca;
	private JLabel lblNumJogadores;
	private JComboBox comboBoxNumJogadores;
	private JLabel lblIdioma;
	private JTextField txfIdioma;
	private JLabel lblClassificacao;
	private JComboBox comboBoxClassificacao;
	private JLabel lblAnoLancamento;
	private JTextField txfAnoLancamento;
	private JLabel lblStatus;
	private JComboBox comboBoxStatus;
	private JPanel panel;
	private JButton btnSalvarGame;
	private JButton btnCancelarGame;
	private JLabel lblValorAluguel;
	private JTextField txfValorAluguel;
	private JLabel lblGenero;
	private JComboBox comboBoxGenero;
	
	private String nome;
	private int codigo;
	private String console;
	private String marca;
	private String numJogadores;
	private String idioma;
	private String classificacao;
	private String anoLancamento;
	private String status;
	private float valoraluguel;
	private String genero;
	private Game game;
	
	public TelaCadastroGame() {
		setTitle("Cadastro game");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(800, 600);
		setModal(true);
		getContentPane().setLayout(null);
		
		lblTituloGames = new JLabel("Cadastro de games");
		lblTituloGames.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblTituloGames.setBounds(267, 24, 264, 23);
		getContentPane().add(lblTituloGames);
		
		lblConsole = new JLabel("Console:");
		lblConsole.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConsole.setBounds(60, 101, 78, 13);
		getContentPane().add(lblConsole);
		
		comboBoxConsole = new JComboBox();
		comboBoxConsole.setModel(new DefaultComboBoxModel(new String[] {"PlayStation 3", "PlayStation 4", "PlayStation 5", "Xbox one", "Xbox series X/S"}));
		comboBoxConsole.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxConsole.setBounds(157, 97, 163, 21);
		getContentPane().add(comboBoxConsole);
		
		lblNomeGame = new JLabel("Nome:");
		lblNomeGame.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNomeGame.setBounds(60, 153, 73, 13);
		getContentPane().add(lblNomeGame);
		
		txfNome = new JTextField();
		txfNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txfNome.setBounds(157, 152, 475, 19);
		getContentPane().add(txfNome);
		txfNome.setColumns(10);
		
		lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMarca.setBounds(60, 204, 73, 13);
		getContentPane().add(lblMarca);
		
		txfMarca = new JTextField();
		txfMarca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txfMarca.setBounds(157, 203, 221, 19);
		getContentPane().add(txfMarca);
		txfMarca.setColumns(10);
		
		lblNumJogadores = new JLabel("N\u00B0 jogadores:");
		lblNumJogadores.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumJogadores.setBounds(428, 199, 103, 23);
		getContentPane().add(lblNumJogadores);
		
		comboBoxNumJogadores = new JComboBox();
		comboBoxNumJogadores.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3 +"}));
		comboBoxNumJogadores.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxNumJogadores.setBounds(559, 202, 73, 21);
		getContentPane().add(comboBoxNumJogadores);
		
		lblIdioma = new JLabel("Idioma:");
		lblIdioma.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIdioma.setBounds(60, 260, 96, 13);
		getContentPane().add(lblIdioma);
		
		txfIdioma = new JTextField();
		txfIdioma.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txfIdioma.setBounds(157, 259, 221, 19);
		getContentPane().add(txfIdioma);
		txfIdioma.setColumns(10);
		
		lblClassificacao = new JLabel("Classifica\u00E7\u00E3o:");
		lblClassificacao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblClassificacao.setBounds(420, 260, 111, 13);
		getContentPane().add(lblClassificacao);
		
		comboBoxClassificacao = new JComboBox();
		comboBoxClassificacao.setModel(new DefaultComboBoxModel(new String[] {"Livre", "10", "12", "14", "16", "18"}));
		comboBoxClassificacao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxClassificacao.setBounds(542, 256, 90, 21);
		getContentPane().add(comboBoxClassificacao);
		
		lblAnoLancamento = new JLabel("Ano de lan\u00E7amento:");
		lblAnoLancamento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAnoLancamento.setBounds(60, 314, 169, 23);
		getContentPane().add(lblAnoLancamento);
		
		txfAnoLancamento = new JTextField();
		txfAnoLancamento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txfAnoLancamento.setBounds(218, 318, 120, 19);
		getContentPane().add(txfAnoLancamento);
		txfAnoLancamento.setColumns(10);
		
		lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStatus.setBounds(414, 321, 56, 13);
		getContentPane().add(lblStatus);
		
		comboBoxStatus = new JComboBox();
		comboBoxStatus.setModel(new DefaultComboBoxModel(Status.values()));
		comboBoxStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxStatus.setBounds(499, 317, 133, 21);
		getContentPane().add(comboBoxStatus);
		
		panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(31, 446, 725, 107);
		getContentPane().add(panel);
		
		btnSalvarGame = new JButton("Salvar");
		btnSalvarGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				codigo = 0;
				nome = txfNome.getText().toUpperCase();
				console = comboBoxConsole.getSelectedItem().toString();
				marca = txfMarca.getText().toUpperCase();
				numJogadores = comboBoxNumJogadores.getSelectedItem().toString();
				idioma = txfIdioma.getText().toUpperCase();
				classificacao = comboBoxClassificacao.getSelectedItem().toString();
				anoLancamento = txfAnoLancamento.getText();
				status = comboBoxStatus.getSelectedItem().toString();
				valoraluguel = Float.parseFloat(txfValorAluguel.getText());
				genero = comboBoxGenero.getSelectedItem().toString();
				
				game = new Game(codigo, marca, nome, genero, console, numJogadores, classificacao, idioma, anoLancamento, valoraluguel);
				System.out.println(game);
				try {
					PersistenciaEmBanco.pegarInstancia().CadastrarGame(game);
					JOptionPane.showMessageDialog(null,"Game cadastrado com sucesso!!");
				} catch (GameJaCadastradoException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null,"Erro !! Código do game já se encontra cadastrado no sistema");
				}
				
				
				txfNome.setText("");
				txfMarca.setText("");
				txfIdioma.setText("");
				txfAnoLancamento.setText("");
				txfValorAluguel.setText("");
				
			}
			
		});
		panel.add(btnSalvarGame);
		
		btnCancelarGame = new JButton("Cancelar");
		btnCancelarGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?");
				if(resposta == 0) {
					dispose();
				}
			}
		});
		panel.add(btnCancelarGame);
		
		lblValorAluguel = new JLabel("Valor aluguel:");
		lblValorAluguel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValorAluguel.setBounds(60, 369, 133, 23);
		getContentPane().add(lblValorAluguel);
		
		txfValorAluguel = new JTextField();
		txfValorAluguel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txfValorAluguel.setBounds(218, 373, 120, 19);
		getContentPane().add(txfValorAluguel);
		txfValorAluguel.setColumns(10);
		
		lblGenero = new JLabel("G\u00EAnero:");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGenero.setBounds(414, 376, 73, 13);
		getContentPane().add(lblGenero);
		
		comboBoxGenero = new JComboBox();
		comboBoxGenero.setModel(new DefaultComboBoxModel<>(Genero.values()));
		comboBoxGenero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxGenero.setBounds(499, 372, 133, 21);
		getContentPane().add(comboBoxGenero);
		setVisible(true);
	}
}
