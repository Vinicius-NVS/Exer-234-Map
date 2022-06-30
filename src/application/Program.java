 package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter file full path: "); // D:\para ser lido\in.txt
		
		String path = sc.nextLine();
		Map<String, Integer> vts = new HashMap<>();
		
	try(BufferedReader br = new BufferedReader(new FileReader(path))){
		
		String line = br.readLine();
			while(line != null) {		
				String[] fields = line.split(",");
				String name = fields[0];
				int cont = Integer.parseInt(fields[1]);
				
				line = br.readLine();
			
				if(vts.containsKey(name)) {
					int votesSoFar = vts.get(name);
					vts.put(name, cont + votesSoFar);
				}
				else {
					vts.put(name, cont);
				}
				
			} 	line = br.readLine();
				for(String key :vts.keySet()) {
					System.out.println(key + ": " + vts.get(key));
				}
			
				}	catch(IOException e) {
				System.out.println("Error " + e.getMessage());
			}
	
				sc.close();
	
	}

}
