package br.edu.ifpb.pweb.calendar.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class DiasCalendario extends Calendar {
	@OneToMany(mappedBy="diasCalendario", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Calendar> calendarios;
	@Temporal(TemporalType.DATE)
	private Date diaData;

	public DiasCalendario(){
		this.calendarios = new ArrayList<Calendar>();
	}
	
	public void addCalendar(Calendar calendar){
		this.calendarios.add(calendar);
	}
	
	public List<Calendar> getCalendarios() {
		return calendarios;
	}

	public void setCalendarios(List<Calendar> calendarios) {
		this.calendarios = calendarios;
	}

	public Date getDiaData() {
		return diaData;
	}

	public void setDiaData(Date diaData) {
		this.diaData = diaData;
	}
	
}
