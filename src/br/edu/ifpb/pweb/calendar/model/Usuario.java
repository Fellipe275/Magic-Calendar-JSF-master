package br.edu.ifpb.pweb.calendar.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Usuario extends Pessoa {
	
	private boolean status;
	
	@OneToMany(mappedBy="usuario", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<CalendarComment> listComment;
	
	public Usuario(String nome, String senha){
		super(nome, senha);
		this.listComment = new ArrayList<CalendarComment>();
		this.status = false;
	}
	
	public Usuario(){}
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void addComment(CalendarComment comment){
		comment.setUsuario(this);
		this.listComment.add(comment);
	}
	
	public void delComment(CalendarComment comment){
		this.listComment.remove(comment);
	}
	
	public List<CalendarComment> getAllListComment(){
		return this.listComment;
	}
	
	public CalendarComment getComment(int id, int type){
		for(CalendarComment comment : listComment){
			if(comment.getId() == id /*&& comment.getType() == type*/ ){
				return comment;
			}
		}
		return null;
	}
	
	public CalendarComment getComment(int id){
		for(CalendarComment comment : listComment){
			if(comment.getId() == id){
				return comment;
			}
		}
		return null;
	}
	
	public void setComment(CalendarComment c){
		int index = 0;
		for(CalendarComment comment : listComment){
			if(comment.getId() == c.getId()){
				this.listComment.set(index, c);
			}
			index++;
		}
	}
}
