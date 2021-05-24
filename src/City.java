import java.util.ArrayList;
//Questa classe rappresenta una città
public class City {
	
	private int x;
	private int y;
	private int h;
	private String name;
	private String links;
	private int linkCounter;
	private ArrayList<Integer> linksArray= new ArrayList<Integer>();
	public City(int x, int y, int h, String name, String links,int linkCounter) {
		
		this.x=x;
		this.y=y;
		this.h=h;
		this.name=name;
		this.links=links;
		this.linkCounter=linkCounter;
		setLinkArray();
	}
	
	public int getX() {
		return x;
	}




	public int getY() {
		return y;
	}




	public int getH() {
		return h;
	}




	public String getName() {
		return name;
	}




	public ArrayList<Integer> getLinksArray() {
		return linksArray;
	}




	private void setLinkArray() {
		String[] parts = links.split("-");
		
		for (int i=0; i<linkCounter; i++) {
			linksArray.add(Integer.parseInt(parts[i]));
		}
	}



	public String toString() {
		String s = "";
		s += x + " " + y + " " + h +" " + name + " " + linksArray;
		return s;
	}

}
