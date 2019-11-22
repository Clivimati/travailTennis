package be.cuvelier;


import java.util.List;
import java.util.ListIterator;

public class Tournoi  {
	
	private List<Ordonnancement> iter;
	private ListIterator <Ordonnancement>man ;
	private Boolean tournoilance = false;
	
	public Tournoi( Ordonnancement or) {
		man=iter.listIterator();
		
		if(or.GetType()=="SF") {
			man.add(or);
		}else if(or.GetType()=="SM") 
		{
			man.add(or);
		}else if(or.GetType()=="DM")
		{
			man.add(or);
		}else if(or.GetType()=="DF")
		{
			man.add(or);
		}else if(or.GetType()=="DMI") {
			man.add(or);
		}
		
	}
	
	public void add(Ordonnancement ord) {
		man.add(ord);
	}

}
