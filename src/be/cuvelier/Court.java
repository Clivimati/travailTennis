package be.cuvelier;

import java.util.Date;

public class Court {
	
	private int id;
	private int nbrspect;
	private int couvert;
	private String typeSurface;
	private Date dispo;
	
	public Date GetD() {
		return dispo;
	}
	
	public String getType() {
		return typeSurface;
	}
	public void setType(String typeSurface) {
		this.typeSurface = typeSurface;
	}
	public int getNbrspct() {
		return nbrspect;
	}
	public void setNbrspct(int nbrspect) {
		this.nbrspect = nbrspect;
	}
	
	public int getIdc() {
		return id;
	}
	public void setIdc(int id) {
		this.id = id;
	}
	public int getCouvert() {
		return couvert;
	}
	public void setCouvert(int couvert) {
		this.couvert = couvert;
	}

}
