package locadora_games.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Color;

public class TelaPrincipal extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JMenuBar menuBar;
	private JMenu mnCliente;
	private JMenuItem mntmCadastrarCliente;
	private JMenu mnAluguel;
	private JMenuItem mntmCadastrarAluguel;
	private JMenu mnGames;
	private JMenuItem mntmConsultarCliente;
	private JMenuItem mntmCadastrarGame;
	private JMenuItem mntmConsultarGame;
	private JMenuItem mntmConsultarAluguel;
	private JLabel lblImagem;
	
	public TelaPrincipal() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("Tela Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(800, 600);
		getContentPane().setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(10, 0, 741, 22);
		getContentPane().add(menuBar);
		
		mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);
		
		mntmCadastrarCliente = new JMenuItem("Cadastrar Cliente");
		mnCliente.add(mntmCadastrarCliente);
		
		mntmConsultarCliente = new JMenuItem("Consultar Cliente");
		mnCliente.add(mntmConsultarCliente);
		mntmConsultarCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new TelaConsultaCliente();
			}
		});
		
		mnGames = new JMenu("Games");
		menuBar.add(mnGames);
		
		mntmCadastrarGame = new JMenuItem("Cadastrar Game");
		mnGames.add(mntmCadastrarGame);
		mntmCadastrarGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new TelaCadastroGame();
			}
		});
		
		mntmConsultarGame = new JMenuItem("Consultar Game");
		mnGames.add(mntmConsultarGame);
		mntmConsultarGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new TelaConsultaGame();
			}
		});
		
		
		mnAluguel = new JMenu("Aluguel");
		menuBar.add(mnAluguel);
		
		mntmCadastrarAluguel = new JMenuItem("Cadastrar Aluguel");
		mnAluguel.add(mntmCadastrarAluguel);
		mntmCadastrarAluguel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new TelaCadastroAluguel();
			}
		});
		
		mntmConsultarAluguel = new JMenuItem("Consultar Aluguel");
		mnAluguel.add(mntmConsultarAluguel);
		mntmConsultarAluguel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new TelaConsultaAluguel();
			}
		});
		
		mntmCadastrarCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new TelaCadastroCliente();
			}
		});
		
		
		ImageIcon imagem = new ImageIcon(getClass().getResource("logotipo.jpg"));
		
		lblImagem = new JLabel(imagem);
		lblImagem.setBounds(159, 116, 429, 339);
		getContentPane().add(lblImagem);
		
		
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
