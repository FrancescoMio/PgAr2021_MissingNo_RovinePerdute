import java.util.ArrayList;

import javax.xml.stream.XMLStreamException;

public class RovinePerduteMain {

	public static void main(String[] args) throws XMLStreamException {
		System.out.println("test");
		System.out.println(new InputOutput().getData().size());
		double[][] matrix = new GenMatrix().genMetztli();
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < 5; j++) {
					System.out.print(matrix[i][j] + " ");
				}
				System.out.println("");
			}
		}
	
		
		/*ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(2);
		test.add(24);
		City city = new City(3,4,5,"banana",test );
		city.getString();*/

	}


