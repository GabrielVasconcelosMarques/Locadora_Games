package locadora_games.modelo;

import javax.swing.SwingUtilities;

import locadora_games.gui.TelaCadastroCliente;
import locadora_games.gui.TelaPrincipal;
import locadora_games.persistencia.FabricaConexao;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new TelaPrincipal();
				
				
			}
		});

	}

}
