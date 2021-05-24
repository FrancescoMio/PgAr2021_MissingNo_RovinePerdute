import java.util.ArrayList;

import javax.xml.stream.XMLStreamException;
//Questa classe crea matrici diverse in base ai veicoli
public class GenMatrix {
	
	ArrayList<City> cities;
	
	public GenMatrix (ArrayList<City> cities) {
		this.cities=cities;
	}
	
	public double distanceTwoPoints(int i, int j, int k, int l) {
		return Math.sqrt(Math.pow((i-k), 2)+Math.pow((j-l), 2));
	}
	 
	public double[][] genTonatiuh() throws XMLStreamException {
		
		double[][] matrix = new double[cities.size()][cities.size()];
		for (int i=0; i<cities.size();i++) {
			for (int j=0; j<cities.get(i).getLinksArray().size();j++) {
				int temp=cities.get(i).getLinksArray().get(j);
				//Arrotondato alla seconda cifra decimale, non dovrebbe causare problemi
				double distance= Math.round((distanceTwoPoints(cities.get(i).getX(),cities.get(i).getY(),cities.get(temp).getX(),cities.get(temp).getY()))*100.0)/100.0;
				matrix[i][temp]=distance;
			}
			
		}
		return matrix;
		
	}
	
	public double[][] genMetztli() throws XMLStreamException{
		double[][] matrix = new double[cities.size()][cities.size()];
		for (int i=0; i<cities.size();i++) {
			for (int j=0; j<cities.get(i).getLinksArray().size();j++) {
			int temp=cities.get(i).getLinksArray().get(j);
			double distance= Math.abs(cities.get(i).getH()-cities.get(temp).getH());
			matrix[i][temp]=distance;
			}
			
		}
		return matrix;
		
	}
	
	
	
	
	
	
	

}
