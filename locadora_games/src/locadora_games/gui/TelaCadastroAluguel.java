package locadora_games.gui;

import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import locadora_games.modelo.Aluguel;
import locadora_games.modelo.Cliente;
import locadora_games.modelo.IGame;
import locadora_games.persistencia.PersistenciaEmBanco;

import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroAluguel extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel lblSelecionarCliente;
	private JComboBox<Cliente> comboBoxSelecionarCliente;
	private JLabel lblTituloAluguel;
	private JLabel lblSelecionarGame;
	private JComboBox<IGame> comboBoxSelecionarGame;
	private JLabel lblDataLocacao;
	private JFormattedTextField txfDataLocacao;
	private JLabel lblDataDevolucao;
	private JFormattedTextField txfDataDevolucao;
	private JLabel lblValor;
	private JTextField txfValor;
	private JPanel panel;
	private JButton btnSalvarAluguel;
	private JButton btnCancelarAluguel;
	
	private int codigo;
	private Cliente cliente;
	private IGame game;
	private String dataAluguel;
	private String dataDevolução;
	private float valorAPagar;
	
	public TelaCadastroAluguel() {
		
		setTitle("Cadastrar Aluguel");
		setSize(800, 600);
		setModal(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		
		lblSelecionarCliente = new JLabel("Selecionar Cliente:");
		lblSelecionarCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSelecionarCliente.setBounds(38, 86, 140, 13);
		getContentPane().add(lblSelecionarCliente);
		
		comboBoxSelecionarCliente = new JComboBox();
		comboBoxSelecionarCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxSelecionarCliente.setBounds(192, 78, 505, 32);
		getContentPane().add(comboBoxSelecionarCliente);
		
		DefaultComboBoxModel defaultComboBoxCliente = new DefaultComboBoxModel(PersistenciaEmBanco.pegarInstancia().todosClientes().toArray());
		comboBoxSelecionarCliente.setModel(defaultComboBoxCliente);
		
		lblTituloAluguel = new JLabel("Cadastrar aluguel");
		lblTituloAluguel.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblTituloAluguel.setBounds(277, 10, 204, 21);
		getContentPane().add(lblTituloAluguel);
		
		lblSelecionarGame = new JLabel("Selecionar Game:");
		lblSelecionarGame.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSelecionarGame.setBounds(38, 147, 140, 13);
		getContentPane().add(lblSelecionarGame);
		
		comboBoxSelecionarGame = new JComboBox();
		comboBoxSelecionarGame.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxSelecionarGame.setBounds(192, 137, 505, 32);
		getContentPane().add(comboBoxSelecionarGame);
		
		DefaultComboBoxModel defaultComboBoxGame = new DefaultComboBoxModel(PersistenciaEmBanco.pegarInstancia().todosGames().toArray());
		comboBoxSelecionarGame.setModel(defaultComboBoxGame);
		
		lblDataLocacao = new JLabel("Data da loca\u00E7\u00E3o:");
		lblDataLocacao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDataLocacao.setBounds(38, 215, 140, 13);
		getContentPane().add(lblDataLocacao);
		
		txfDataLocacao = new JFormattedTextField();
		txfDataLocacao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txfDataLocacao.setBounds(195, 211, 140, 19);
		getContentPane().add(txfDataLocacao);
		txfDataLocacao.setColumns(10);
		
		lblDataDevolucao = new JLabel("Data de devolu\u00E7\u00E3o:");
		lblDataDevolucao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDataDevolucao.setBounds(376, 215, 140, 13);
		getContentPane().add(lblDataDevolucao);
		
		MaskFormatter mfDataLocacao;
		try {
			mfDataLocacao = new MaskFormatter("##/##/####");
			mfDataLocacao.install(txfDataLocacao);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		txfDataDevolucao = new JFormattedTextField();
		txfDataDevolucao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txfDataDevolucao.setBounds(540, 211, 156, 19);
		getContentPane().add(txfDataDevolucao);
		txfDataDevolucao.setColumns(10);
		
		MaskFormatter mfDataDevolucao;
		try {
			mfDataDevolucao = new MaskFormatter("##/##/####");
			mfDataDevolucao.install(txfDataDevolucao);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		lblValor = new JLabel("Valor \u00E0 pagar:");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValor.setBounds(38, 265, 121, 26);
		getContentPane().add(lblValor);
		
		txfValor = new JTextField();
		txfValor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txfValor.setBounds(191, 268, 128, 19);
		getContentPane().add(txfValor);
		txfValor.setColumns(10);
		
		panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 399, 766, 154);
		getContentPane().add(panel);
		
		btnSalvarAluguel = new JButton("Salvar");
		btnSalvarAluguel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				codigo = 0;
				cliente = (Cliente) comboBoxSelecionarCliente.getSelectedItem();
				game = (IGame) comboBoxSelecionarGame.getSelectedItem();
				dataAluguel = txfDataLocacao.getText();
				dataDevolução = txfDataDevolucao.getText();
				valorAPagar = Float.parseFloat(txfValor.getText());
				
				Aluguel aluguel = new Aluguel(codigo, cliente, game, dataAluguel, dataDevolução, valorAPagar);
				System.out.println(aluguel);
				PersistenciaEmBanco.pegarInstancia().CadastrarAluguel(aluguel);
				JOptionPane.showMessageDialog(null,"Aluguel cadastrado com sucesso!!");
				
				
				txfDataLocacao.setText("");
				txfDataDevolucao.setText("");
				txfValor.setText("");
				
			}
		});
		panel.add(btnSalvarAluguel);
		
		btnCancelarAluguel = new JButton("Cancelar");
		btnCancelarAluguel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?");
				if(resposta == 0) {
					dispose();
				}
			}
		});
		panel.add(btnCancelarAluguel);
		setVisible(true);
	}

}
