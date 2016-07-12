import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class HandleFile {
	private List<String> readedData;	//Tablica przechowująca dane przeczytane z pliku
	private List<Double> readedValues;	//Tablica z przeczytanymi wartościami
	public HandleFile(String filePath)
	{
		try (Scanner input = new Scanner(new File(filePath))) {
			readedData = new ArrayList<String>();
            while(input.hasNextLine())
            {
               readedData.add(input.nextLine());
            }
		}
		catch (Exception e) {
            e.printStackTrace();
        }
	}
	public void parseData()
	{
		readedValues = new ArrayList<Double>();
		String delims = "@";
		for(String x : readedData)
		{
			String[] tokens = x.split(delims);
			for(String y : tokens)
			{
				if(y.startsWith("amount"))
				{
					y = extractDigits(y);
					readedValues.add(Double.parseDouble(y));
					//System.out.println(y);
				}
			}
		}
		
	}
	public double sumValues()	//Funkcja sumująca wszystkie wartości
	{
		double sum = 0;
		for(Double y : readedValues)
			sum += y;
		return sum;
	}
	private String extractDigits(String src)	//Funkcja wyłuskująca warrtość liczbową z pola amount
	{
	    StringBuilder builder = new StringBuilder();
	    for (int i = 0; i < src.length(); i++) {
	        char c = src.charAt(i);
	        if (Character.isDigit(c) || c == ',') {
	        	if(c == ',')
	        		builder.append('.');
	        	else
	        		builder.append(c);
	        }
	    }
	    return builder.toString();
	}
}
