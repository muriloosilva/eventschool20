package util;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class DataHourFormat {
	private static SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");  
	public static String formatarData(Date data){
		return formatador.format(data).toString(); 
	}
}
