package br.edu.ifpb.pweb.calendar.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.edu.ifpb.pweb.calendar.model.DiasCalendario;

@ManagedBean(name="magicCalendar")
public class MagicCalendar {
	private List<DiasCalendario> calendarios;
	private Date dataAtual;

	public MagicCalendar(){
		this.calendarios = new ArrayList<DiasCalendario>();
		this.dataAtual = new Date();
	}
	
	public List<DiasCalendario> getCalendarios() {
		return calendarios;
	}

	public void setCalendarios(List<DiasCalendario> calendarios) {
		this.calendarios = calendarios;
	}
	
	public void gerarCalendario(){
		
		try {
			for(int i = 1; i<= quantidadeDiaMes(); i++){
				this.calendarios.add(new DiasCalendario());
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	public int quantidadeDiaMes() throws ParseException{
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d = sdf.parse("17/03/2016");
		c.setTime(d);
		
		//System.out.println(c.getActualMaximum(Calendar.DAY_OF_MONTH));
		//System.out.println(c.get(Calendar.DAY_OF_MONTH)+" "+diaSemana(c.get(Calendar.DAY_OF_WEEK))+" / "+(c.get(Calendar.MONTH)+1)+" "+mesAno(c.get(Calendar.MONTH))+" / "+c.get(Calendar.YEAR));	
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	public void popularCalendario() throws ParseException{
		
				
	}
	
	public static String diaSemana(int dia){
		String[] diaSemana = new String[]{"","Domingo","Segunda","Terça","Quarta","Quinta","Sexta","Sábado"}; 
		return diaSemana[dia];
	}
	
	public static String mesAno(int mes){
		String[] mesAno = new String[]{"Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto"
									   ,"Setembro","Outubro","Novembro","Dezembro"}; 
		return mesAno[mes];
	}

	public Date getDataAtual() {
		return dataAtual;
	}

	public void setDataAtual(Date dataAtual) {
		this.dataAtual = dataAtual;
	}
}
