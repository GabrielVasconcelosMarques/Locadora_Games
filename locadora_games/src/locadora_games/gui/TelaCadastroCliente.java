package locadora_games.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.text.MaskFormatter;

import locadora_games.enumerates.Sexo;
import locadora_games.exception.ClienteJaCadastradoException;
import locadora_games.modelo.Cliente;
import locadora_games.persistencia.PersistenciaEmBanco;

import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;

public class TelaCadastroCliente extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	private JButton btnSalvar;
	private JButton btnCancelar;
	private JLabel lblNome;
	private JTextPane txfNome;
	private JLabel lblTitulo;
	private JLabel lblCPF;
	private JFormattedTextField txfCPF;
	private JLabel lblDataNascimento;
	private JFormattedTextField txfDataNascimento;
	private JLabel lblIdentificacao;
	private JLabel lblSexo;
	private JComboBox comboBoxSexo;
	private JLabel lblEndereco;
	private JLabel lblRua;
	private JTextField txfRua;
	private JLabel lblNumeroCasa;
	private JTextField txfNumRua;
	private JLabel lblBairro;
	private JTextField txfBairro;
	private JLabel lblCidade;
	private JTextField txfCidade;
	private JLabel lblContato;
	private JLabel lblTelefone;
	private JFormattedTextField txfTelefone;
	
	private String nome;
	private String cpf;
	private String dataNascimento;
	private String sexo;
	private String rua;
	private int numRua;
	private String bairro;
	private String cidade;
	private String telefone;
	private Cliente cliente;
	
	
	
	public TelaCadastroCliente() {
		setTitle("Cadastro cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(800, 600);
		setModal(true);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(29, 497, 723, 56);
		getContentPane().add(panel);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				nome = txfNome.getText().toUpperCase();
				cpf = txfCPF.getText();
				dataNascimento = txfDataNascimento.getText();
				sexo = comboBoxSexo.getSelectedItem().toString();
				rua = txfRua.getText().toUpperCase();
				numRua = Integer.parseInt(txfNumRua.getText());
				bairro = txfBairro.getText().toUpperCase();
				cidade = txfCidade.getText().toUpperCase();
				telefone = txfTelefone.getText();
				
				cliente = new Cliente(cpf, nome, dataNascimento, telefone, sexo, rua, numRua, bairro, cidade);
				System.out.println(cliente);
				try {
					PersistenciaEmBanco.pegarInstancia().CadastrarCliente(cliente);
					JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso!!");
				} catch (ClienteJaCadastradoException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null,"Erro !! CPF já se encontra cadastrado no sistema");
				}
				
				
				
				txfNome.setText("");
				txfCPF.setText("");
				txfDataNascimento.setText("");
				txfRua.setText("");
				txfNumRua.setText("");
				txfBairro.setText("");
				txfCidade.setText("");
				txfTelefone.setText("");
				
			}
		});
		panel.add(btnSalvar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?");
				if(resposta == 0) {
					dispose();
				}
			}
		});
		panel.add(btnCancelar);
		
		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNome.setBounds(49, 126, 68, 14);
		getContentPane().add(lblNome);
		
		txfNome = new JTextPane();
		txfNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txfNome.setBounds(147, 114, 506, 26);
		getContentPane().add(txfNome);
		
		lblTitulo = new JLabel("Cadastro de Clientes");
		lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblTitulo.setBounds(269, 22, 202, 13);
		getContentPane().add(lblTitulo);
		
		lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCPF.setBounds(49, 170, 45, 13);
		getContentPane().add(lblCPF);
		
		txfCPF = new JFormattedTextField();
		txfCPF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txfCPF.setBounds(147, 169, 180, 19);
		getContentPane().add(txfCPF);
		txfCPF.setColumns(10);
		
		MaskFormatter mfCpf;
		try {
			mfCpf = new MaskFormatter("###.###.###-##");
			mfCpf.install(txfCPF);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		lblDataNascimento = new JLabel("Data de nascimento:");
		lblDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDataNascimento.setBounds(359, 170, 155, 13);
		getContentPane().add(lblDataNascimento);
		
		txfDataNascimento = new JFormattedTextField();
		txfDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txfDataNascimento.setBounds(524, 169, 129, 19);
		getContentPane().add(txfDataNascimento);
		txfDataNascimento.setColumns(10);
		
		MaskFormatter mfDataNascimento;
		try {
			mfDataNascimento = new MaskFormatter("##/##/####");
			mfDataNascimento.install(txfDataNascimento);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		lblIdentificacao = new JLabel("Identifica\u00E7\u00E3o");
		lblIdentificacao.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblIdentificacao.setBounds(49, 76, 129, 19);
		getContentPane().add(lblIdentificacao);
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSexo.setBounds(49, 214, 45, 13);
		getContentPane().add(lblSexo);
		
		lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblEndereco.setBounds(49, 270, 100, 13);
		getContentPane().add(lblEndereco);
		
		lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRua.setBounds(49, 310, 45, 13);
		getContentPane().add(lblRua);
		
		txfRua = new JTextField();
		txfRua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txfRua.setBounds(147, 309, 410, 19);
		getContentPane().add(txfRua);
		txfRua.setColumns(10);
		
		lblNumeroCasa = new JLabel("N\u00B0:");
		lblNumeroCasa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumeroCasa.setBounds(569, 312, 45, 13);
		getContentPane().add(lblNumeroCasa);
		
		txfNumRua = new JTextField();
		txfNumRua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txfNumRua.setBounds(604, 309, 49, 19);
		getContentPane().add(txfNumRua);
		txfNumRua.setColumns(10);
		
		lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBairro.setBounds(49, 350, 68, 13);
		getContentPane().add(lblBairro);
		
		txfBairro = new JTextField();
		txfBairro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txfBairro.setBounds(147, 349, 168, 19);
		getContentPane().add(txfBairro);
		txfBairro.setColumns(10);
		
		lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCidade.setBounds(401, 352, 70, 13);
		getContentPane().add(lblCidade);
		
		txfCidade = new JTextField();
		txfCidade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txfCidade.setBounds(478, 349, 175, 19);
		getContentPane().add(txfCidade);
		txfCidade.setColumns(10);
		
		lblContato = new JLabel("Contato");
		lblContato.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblContato.setBounds(49, 398, 100, 13);
		getContentPane().add(lblContato);
		
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefone.setBounds(49, 443, 87, 13);
		getContentPane().add(lblTelefone);
		
		txfTelefone = new JFormattedTextField();
		txfTelefone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txfTelefone.setBounds(147, 442, 162, 19);
		getContentPane().add(txfTelefone);
		txfTelefone.setColumns(10);
		
		MaskFormatter mfTelefone;
		try {
			mfTelefone = new MaskFormatter("(##)#.####-####");
			mfTelefone.install(txfTelefone);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		comboBoxSexo = new JComboBox();
		comboBoxSexo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxSexo.setModel(new DefaultComboBoxModel<>(Sexo.values()));
		comboBoxSexo.setBounds(149, 212, 45, 21);
		getContentPane().add(comboBoxSexo);
		setVisible(true);
		
	}
}
