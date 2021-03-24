package locadora_games.gui;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;

import locadora_games.modelo.Cliente;
import locadora_games.persistencia.PersistenciaEmBanco;

public class TelaConsultaCliente extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel lblTituloConsultaCliente;
	private JScrollPane scrollPane;
	private JLabel lblBuscaNome;
	private JTable table;
	private final int QUANTIDADE_MAX_CONTAS = 20;
	private String[] colunasTabela = {"CPF", "Nome", "Telefone"};
	private Object [][] elementos = new Object[QUANTIDADE_MAX_CONTAS][3];
	private JLabel lblBuscarTodos;
	private JTextField txfNome;
	private JButton btnBuscarPorNome;
	
	
	public TelaConsultaCliente() {
		
		setTitle("Consultar cliente");
		setSize(800, 600);
		setModal(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		lblTituloConsultaCliente = new JLabel("Consultar Clientes");
		lblTituloConsultaCliente.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblTituloConsultaCliente.setBounds(309, 34, 201, 13);
		getContentPane().add(lblTituloConsultaCliente);
		
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
				inserirTabela(PersistenciaEmBanco.pegarInstancia().getAllClientes());
			}
		});
		btnConsultarTodos.setBounds(591, 87, 85, 21);
		getContentPane().add(btnConsultarTodos); */
		
		txfNome = new JTextField();
		txfNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txfNome.setBounds(153, 88, 177, 19);
		getContentPane().add(txfNome);
		txfNome.setColumns(10); 
		
		btnBuscarPorNome = new JButton("Buscar");
		btnBuscarPorNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserirTabela(PersistenciaEmBanco.pegarInstancia().todosClientesPorNome(txfNome.getText().toUpperCase()));
				if(PersistenciaEmBanco.pegarInstancia().todosClientesPorNome(txfNome.getText().toUpperCase()).isEmpty()) {
					JOptionPane.showMessageDialog(null,"Nenhum cliente encontrado!!");
				}
			}
		});
		btnBuscarPorNome.setBounds(343, 87, 85, 21);
		getContentPane().add(btnBuscarPorNome);
		setVisible(true);
	}
	
	private class TabelaAtualizarEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public void inserirTabela(List<Cliente> list) {

        
        for(int i = 0; i<QUANTIDADE_MAX_CONTAS; i++)
        {
            elementos[i][0] = "";
            elementos[i][1] = "";
            elementos[i][2] = "";
        }


        int i = 0;

        for(Cliente cliente : list)
        {
            elementos[i][0] = cliente.getCpf();
            elementos[i][1] = cliente.getNome();
            elementos[i][2] = cliente.getTelefone();
         

            i++;
        }

        table.updateUI();
    }
}


