package be.cuvelier;

import java.io.Serializable;

public class Joueur extends Personne implements Serializable {
	private static final long serialVersionUID=1;
	
	private int sex;
	private int classement;
	public static final int HOMME = 1;
	public static final int FEMME = 2;
	
	public Joueur() {}
	
	public Joueur(int i,int sex, int cla, String n , String p) 
	{
		super(i,n,p);
		this.sex=sex;
		classement =cla;
		
	}
	
	public int getClassement() {
		return classement;
	}
	public void setClassement(int classement) {
		this.classement = classement;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	
	public String toString() {
		return this.nom+" "
				+this.prenom;
	}
	
}
