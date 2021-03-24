package locadora_games.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import locadora_games.modelo.Cliente;
import locadora_games.modelo.IGame;
import locadora_games.persistencia.PersistenciaEmBanco;

public class TelaConsultaGame extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel lblTituloConsultaGame;
	private JScrollPane scrollPane;
	private JLabel lblBuscaNome;
	private JTable table;
	private final int QUANTIDADE_MAX_CONTAS = 20;
	private String[] colunasTabela = {"Código", "Nome", "Console", "Gênero", "Valor do Aluguel"};
	private Object [][] elementos = new Object[QUANTIDADE_MAX_CONTAS][5];
	private JLabel lblBuscarTodos;
	private JTextField txfNome;
	
	public TelaConsultaGame() {
		
		setTitle("Consultar games");
		setSize(800, 600);
		setModal(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		lblTituloConsultaGame = new JLabel("Consultar Games");
		lblTituloConsultaGame.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblTituloConsultaGame.setBounds(309, 34, 201, 13);
		getContentPane().add(lblTituloConsultaGame);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 163, 739, 307);
		getContentPane().add(scrollPane);
		
		table = new JTable(elementos, colunasTabela);
		scrollPane.setViewportView(table);
		
		lblBuscaNome = new JLabel("Busca por nome:");
		lblBuscaNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBuscaNome.setBounds(21, 89, 142, 13);
		getContentPane().add(lblBuscaNome);
		
		/*lblBuscarTodos = new JLabel("Buscar Todos:");
		lblBuscarTodos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBuscarTodos.setBounds(478, 89, 147, 13);
		getContentPane().add(lblBuscarTodos);
		
		JButton btnConsultarTodos = new JButton("Buscar");
		btnConsultarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserirTabela(PersistenciaEmBanco.pegarInstancia().getAllGames());
			}
		});
		btnConsultarTodos.setBounds(591, 87, 85, 21);
		getContentPane().add(btnConsultarTodos); */
		
		txfNome = new JTextField();
		txfNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txfNome.setBounds(153, 88, 172, 19);
		getContentPane().add(txfNome);
		txfNome.setColumns(10);
		
		JButton btnBuscaPorNome = new JButton("Buscar");
		btnBuscaPorNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserirTabela(PersistenciaEmBanco.pegarInstancia().todosGamesPorNome(txfNome.getText().toUpperCase()));
				if(PersistenciaEmBanco.pegarInstancia().todosGamesPorNome(txfNome.getText().toUpperCase()).isEmpty()) {
					JOptionPane.showMessageDialog(null,"Nenhum game encontrado!!");
				}
			}
		});
		btnBuscaPorNome.setBounds(336, 87, 85, 21);
		getContentPane().add(btnBuscaPorNome);
		setVisible(true);
	}
	
	private class TabelaAtualizarEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	public void inserirTabela(List<IGame> list) {

        
        for(int i = 0; i<QUANTIDADE_MAX_CONTAS; i++)
        {
            elementos[i][0] = "";
            elementos[i][1] = "";
            elementos[i][2] = "";
            elementos[i][3] = "";
            elementos[i][4] = "";
        }


        int i = 0;

        for(IGame game : list)
        {
            elementos[i][0] = game.getCodigo();
            elementos[i][1] = game.getNome();
            elementos[i][2] = game.getConsole();
            elementos[i][3] = game.getGenero();
            elementos[i][4] = game.getValorAluguel();
         

            i++;
        }

        table.updateUI();
    }
}
