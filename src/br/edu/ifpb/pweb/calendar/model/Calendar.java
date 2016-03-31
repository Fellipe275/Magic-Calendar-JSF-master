package br.edu.ifpb.pweb.calendar.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public abstract class Calendar {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private DiasCalendario diasCalendario;
	private String text;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	private String color;
	
	public Calendar(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DiasCalendario getDiasCalendario() {
		return diasCalendario;
	}

	public void setDiasCalendario(DiasCalendario diasCalendario) {
		this.diasCalendario = diasCalendario;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
