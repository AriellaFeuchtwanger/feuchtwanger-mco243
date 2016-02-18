package feuchtwanger.microprocessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Microprocessor {
	private String[] memory;
	private String a;
	private String b;
	private int counter;

	public Microprocessor(File file) {
		memory = new String[256];
		a = "0";
		b = "0"; // in case b wasn't initialized yet

		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String memoryString = reader.readLine();
			memory = memoryString.split("");
			process();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Microprocessor(String memory) {
		this.memory = memory.split("");
		a = "0";
		b = "0";
		process();
	}

	private void process() {
		counter = 0;

		while (memory[counter] != "8") {
			switch (memory[counter]) {
			case "0":
				load();
				break;
			case "1":
				store();
				break;
			case "2":
				swap();
				break;
			case "3":
				add();
				break;
			case "4":
				increase();
				break;
			case "5":
				decrease();
				break;
			case "6":
				bz();
				break;
			case "7":
				br();
				break;
			case "8":
				return;
			}
		}
	}

	public String[] getMemory() {
		return memory;
	}

	private void load() {
		counter++;
		int addressOneDec = Integer.parseInt(memory[counter], 16);

		counter++;
		int addressTwoDec = Integer.parseInt(memory[counter], 16);

		addressOneDec *= 16; // HEXADECIMAL
		int address = addressOneDec + addressTwoDec;
		a = memory[address];
		counter++;
	}

	private void store() {
		counter++;
		int addressOneDec = Integer.parseInt(memory[counter], 16);
		addressOneDec *= 16; // HEXADECIMAL

		counter++;
		int addressTwoDec = Integer.parseInt(memory[counter], 16);

		int address = addressOneDec + addressTwoDec;
		memory[address] = a;
		counter++;
	}

	private void swap() {
		String temp = a;
		a = b;
		b = temp;
		counter++;
	}

	private void add() {
		int numOne = Integer.parseInt(a, 16);
		int numTwo = Integer.parseInt(b, 16);

		int sum = numOne + numTwo;
		String hex = Integer.toHexString(sum).toUpperCase();
		String[] number = hex.split("");
		if (number.length == 2) {
			a = number[1];
			b = number[0];
		} else {
			a = number[0];
			b = "0";
		}
		counter++;
	}

	private void increase() {
		if (a.equals("F")) {
			a = "0";
		} else {
			int number = Integer.parseInt(a, 16);
			number++;
			a = Integer.toHexString(number).toUpperCase();
		}
		counter++;
	}

	private void decrease() {
		if (a.equals("0")) {
			a = "F";
		} else {
			int number = Integer.parseInt(a, 16);
			number--;
			a = Integer.toHexString(number).toUpperCase();
		}
		counter++;
	}

	private void bz() {
		if (a.equals("0")) {
			counter++;
			int addressOneDec = Integer.parseInt(memory[counter], 16);
			addressOneDec *= 16; // HEXADECIMAL

			counter++;
			int addressTwoDec = Integer.parseInt(memory[counter], 16);

			counter = addressOneDec + addressTwoDec;
		} else {
			counter += 3;
		}
	}

	private void br() {
		counter++;
		int addressOneDec = Integer.parseInt(memory[counter], 16);
		addressOneDec *= 16; // HEXADECIMAL

		counter++;
		int addressTwoDec = Integer.parseInt(memory[counter], 16);

		counter = addressOneDec + addressTwoDec;
	}
}
