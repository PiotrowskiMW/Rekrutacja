
public class MainClass {
	public static void main(String[] args)
	{
		HandleFile handleFile;
		if(args.length > 0)
			handleFile = new HandleFile(args[0]);
		else
			handleFile = new HandleFile("Plik z danymi.txt");
		handleFile.parseData();
		System.out.printf("Poszukiwana liczba to: %.2f", handleFile.sumValues());
	}
}
