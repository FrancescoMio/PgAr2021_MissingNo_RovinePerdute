import java.util.ArrayList;

import javax.xml.stream.XMLStreamException;
//Questa classe crea matrici diverse in base ai veicoli
public class GenMatrix {
	
	public double distanceTwoPoints(int i, int j, int k, int l) {
		return Math.sqrt(Math.pow((i-k), 2)+Math.pow((j-l), 2));
	}
	 
	public double[][] genTonatiuh() throws XMLStreamException {
		
		ArrayList<City> cities = new InputOutput().getData();
		double[][] matrix = new double[cities.size()][cities.size()];
		
		/*for (int i=0; i<cities.size(); i++) {
			for (int j=0; j<cities.size();j++) {
				matrix[i][j]=0;
			}
		}*/
		
		for (int i=0; i<cities.size();i++) {
			for (int j=0; j<cities.get(i).getLinksArray().size();j++) {
				int temp=cities.get(i).getLinksArray().get(j);
				double distance= distanceTwoPoints(cities.get(i).getX(),cities.get(i).getY(),cities.get(temp).getX(),cities.get(temp).getY());
				matrix[i][temp]=distance;
			}
			
		}
		return matrix;
		
	}
	
	
	public double[][] genMetztli() throws XMLStreamException{
		ArrayList<City> cities = new InputOutput().getData();
		double[][] matrix = new double[cities.size()][cities.size()];
		
		/*for (int i=0; i<cities.size(); i++) {
			for (int j=0; j<cities.size();j++) {
				matrix[i][j]=0;
			}
		}*/
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
