package feuchtwanger.microprocessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class UseMicroprocessor {

	public static void main(String[] args) {
		Microprocessor processor;
		Memory memory;
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(new File("mach.in")));
			String memoryString = reader.readLine();
			while(memoryString != null){
				System.out.println();
				memory = new Memory(memoryString);
				processor = new Microprocessor(memory);
				for(String s :memory.getMemory()){
					System.out.print(s);
				}
				memoryString = reader.readLine();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
