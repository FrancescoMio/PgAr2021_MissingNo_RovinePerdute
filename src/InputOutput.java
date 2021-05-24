import java.io.FileInputStream;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

//Questa classe si preoccupa di tutte quelle operazioni legate alla lettura e scrittura di file xml
public class InputOutput {

	
	private int x;
	private int y;
	private int h;
	private String nome;
	private String links ="";
	private int linkCounter=0;
	private ArrayList<City> cities = new ArrayList<City>();

	
	public XMLStreamReader creaLettore(String filename) {
		XMLInputFactory xmlif = null;
		XMLStreamReader xmlr = null;
		try {
		 xmlif = XMLInputFactory.newInstance();
		 xmlr = xmlif.createXMLStreamReader(filename, new FileInputStream(filename));
		} catch (Exception e) {
		 System.out.println("Errore nell'inizializzazione del reader:");
		 System.out.println(e.getMessage());
		 return null;
		}
		return xmlr;
	}
	
	//Questo metodo legge un xml e crea un arraylist di città
	public ArrayList<City> getData() throws XMLStreamException {
		
		XMLStreamReader xmlr = creaLettore("test_file/PgAr_Map_5.xml");
		while (xmlr.hasNext()) {
			switch(xmlr.getEventType()) {
			case XMLStreamConstants.START_ELEMENT:
				//System.out.println("Tag " + xmlr.getLocalName());
				if (xmlr.getLocalName()=="city") {
					for (int i = 0; i < xmlr.getAttributeCount(); i++)
						switch(xmlr.getAttributeLocalName(i)) {
						case "name":
							//System.out.println("questo è il nome " + xmlr.getAttributeValue(i));
							nome=xmlr.getAttributeValue(i);
							break;
						case "x":
							//System.out.println(xmlr.getAttributeValue(i));
							x =  Integer. parseInt(xmlr.getAttributeValue(i));	
							break;
						case "y":	
							//System.out.println(xmlr.getAttributeValue(i));
							y =  Integer. parseInt(xmlr.getAttributeValue(i));
							
							break;
						case "h":
							//System.out.println(xmlr.getAttributeValue(i));
							h = Integer. parseInt(xmlr.getAttributeValue(i));
							break;
						}
				}
				
				if (xmlr.getLocalName()=="link") {
					//System.out.println("questo è il link " + xmlr.getAttributeValue(0));
					links+=xmlr.getAttributeValue(0) + "-";
					linkCounter++;
					
				}
				
				break;
				
			case XMLStreamConstants.END_ELEMENT:
				if (xmlr.getLocalName()=="city") {
					City city= new City (x, y, h , nome, links, linkCounter);
					this.cities.add(city);
					links="";
					linkCounter=0;
					
				}
				
				break;
			}
			
			xmlr.next();
		}
		
		return cities;
			
		}
	}
	
	
	
	
	


