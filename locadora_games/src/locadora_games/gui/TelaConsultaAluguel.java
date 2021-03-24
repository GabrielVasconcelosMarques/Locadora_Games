package locadora_games.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import locadora_games.modelo.Aluguel;
import locadora_games.modelo.Cliente;
import locadora_games.persistencia.PersistenciaEmBanco;

public class TelaConsultaAluguel extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel lblTituloConsultaAluguel;
	private JScrollPane scrollPane;
	private JTable table;
	private final int QUANTIDADE_MAX_CONTAS = 20;
	private String[] colunasTabela = {"Código do aluguel", "CPF Cliente", "Código do game", "Data da locação", "Data da devolução", "Valor"};
	private Object [][] elementos = new Object[QUANTIDADE_MAX_CONTAS][6];
	private JLabel lblBuscarTodos;
	
	public TelaConsultaAluguel() {
		
		setTitle("Consultar cliente");
		setSize(800, 600);
		setModal(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		lblTituloConsultaAluguel = new JLabel("Consultar Alugueis");
		lblTituloConsultaAluguel.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblTituloConsultaAluguel.setBounds(309, 26, 201, 31);
		getContentPane().add(lblTituloConsultaAluguel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 163, 739, 307);
		getContentPane().add(scrollPane);
		
		table = new JTable(elementos, colunasTabela);
		scrollPane.setViewportView(table);
		
		lblBuscarTodos = new JLabel("Buscar Todos:");
		lblBuscarTodos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBuscarTodos.setBounds(21, 89, 147, 13);
		getContentPane().add(lblBuscarTodos);
		
		JButton btnConsultarTodos = new JButton("Buscar");
		btnConsultarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserirTabela(PersistenciaEmBanco.pegarInstancia().getAllAlugueis());
			}
		});
		btnConsultarTodos.setBounds(141, 87, 85, 21);
		getContentPane().add(btnConsultarTodos);
		setVisible(true);
	}
	
	private class TabelaAtualizarEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	public void inserirTabela(List<Aluguel> list) {

        
        for(int i = 0; i<QUANTIDADE_MAX_CONTAS; i++)
        {
            elementos[i][0] = "";
            elementos[i][1] = "";
            elementos[i][2] = "";
            elementos[i][3] = "";
            elementos[i][4] = "";
            elementos[i][5] = "";
        }


        int i = 0;

        for(Aluguel aluguel : list)
        {
            elementos[i][0] = aluguel.getCodigo();
            elementos[i][1] = aluguel.getCliente().getCpf();
            elementos[i][2] = aluguel.getGame().getCodigo();
            elementos[i][3] = aluguel.getDataAluguel();
            elementos[i][4] = aluguel.getDataDevolução();
            elementos[i][5] = aluguel.getValorAPagar();
         

            i++;
        }

        table.updateUI();
    }

}
