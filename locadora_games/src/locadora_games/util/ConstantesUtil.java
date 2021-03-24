package locadora_games.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConstantesUtil {
	
	public final static String LOCADORA_GAMES_DATABASE_PATH;
	public final static String LOCADORA_GAMES_DATABASE_PORT;
	public final static String LOCADORA_GAMES_DATABASE_IP;
	public final static String LOCADORA_GAMES_DATABASE_NAME;
	
	private static Properties prop;
	private static FileInputStream fis;
	
	static {
		
		try {
			prop = new Properties();
			fis = new FileInputStream("propriedades");
			prop.load(fis);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		LOCADORA_GAMES_DATABASE_PATH = prop.getProperty("locadora_games_database_path");
		LOCADORA_GAMES_DATABASE_PORT = prop.getProperty("locadora_games_database_port");
		LOCADORA_GAMES_DATABASE_IP = prop.getProperty("locadora_games_database_ip");
		LOCADORA_GAMES_DATABASE_NAME = prop.getProperty("locadora_games_database_name");
	}
	
	
}
