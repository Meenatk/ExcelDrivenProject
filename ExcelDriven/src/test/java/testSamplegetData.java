import java.io.IOException;
import java.util.ArrayList;

public class testSamplegetData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		copyDataDriven d= new copyDataDriven();
		ArrayList<String> data =d.getData("Addprofile");
		
		System.out.println(data.get(0));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
		

	}

}
