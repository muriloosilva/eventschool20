package DB;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.GregorianCalendar;

import models.Evento;

public class TesteDB {

	public static void main(String[] args) {
		ConnectionMannager.getConnetion();
		Evento evento = new Evento();
		evento.setDataFim(new Date(new GregorianCalendar(2014, 04, 25).getTimeInMillis()));
		evento.setDataInicio(new Date(new GregorianCalendar(2014, 04, 23).getTimeInMillis()));
		evento.setDataFimInscricoes(new Timestamp(new GregorianCalendar(2014, 04, 25, 23, 59, 59).getTimeInMillis()));
		evento.setDataInicioInscricoes(new Timestamp(new GregorianCalendar(2014, 04, 23, 0, 0, 0).getTimeInMillis()));
		evento.setDescricao("alksjd lasjd alsçdj sçalkdj salkdj saldj açslkaslkdj asklj dçsakl djçsakl djçakls djçksalj dkçsaljdlksaj d");
		evento.setEmail("muriloosilva@gmail.com");
		evento.setLocal("IFG Formosa");
		evento.setNome("SECITEC 2014");
		evento.setTelefone("123456");
		
		if(EventoDAO.adicionarEvento(evento)){
			System.out.println("Evento inserido");
		}
		else{
			System.out.println("Evento não inserido");
		}
	}

}
