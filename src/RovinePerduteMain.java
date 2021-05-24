import java.util.ArrayList;

import javax.xml.stream.XMLStreamException;

public class RovinePerduteMain {

	public static void main(String[] args) throws XMLStreamException {
		

		ArrayList<City> cities =new InputOutput().getData();
		double[][] matrix = new GenMatrix(cities).genTonatiuh();
		//double[][] matrix = new GenMatrix(cities).genMetztli()();
		
			for(int i = 0; i < cities.size(); i++) {
				for(int j = 0; j < cities.size(); j++) {
					System.out.print(matrix[i][j] + " ");
				}
				System.out.println("");
			}
		}
	
		
	}


