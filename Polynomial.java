import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Polynomial {
	/**
	 * Locates TextFile and Adds Coefficient to the LinkList.
	 */
	static String Filename = "Polynomial.txt";
	static LinkList List1 ;
	static LinkList List2;
	static BufferedReader file;
	
	public static void LocateFile () {
		// Read the first line from the textFile.
		// Information will be separated by commas
		try {
			file = new BufferedReader ( new 
					InputStreamReader (new FileInputStream (Filename)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// How Do I do this....
		try {
			String data = "";
			String blank = "";
			while (data != null){
				data = file.readLine ();
				String info1 = data;
				if (data.equals(blank)){
					data = file.readLine();
				}else{
					data= file.readLine ();
					String info2 = data;
					addToLinkList (info1,info2);
					data = file.readLine ();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void addToLinkList (String data1,String data2){
		List1 = new LinkList ();
		List2 = new LinkList ();
		
		String [] data = data1.split(",");
		for (String x: data)
			List1.addItem(Integer.parseInt(x)); 
		
		String [] otherdata = data2.split(",");
		for (String x: otherdata)
			List2.addItem(Integer.parseInt(x));
		
		printList();
	}
	public static void printList (){
		LinkList finalList = List1.addPoly(List2);
		System.out.println("The Sum of two Polynomials is: ");
		finalList.PrintAll();

		finalList = List1.multiPoly(List2);
		System.out.println("The multiple of two Polynomials is: ");
		finalList.PrintAll();
	}
	public static void main (String [] args){
			LocateFile();
	}
}
