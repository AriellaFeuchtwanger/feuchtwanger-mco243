package feuchtwanger.microprocessor;

import java.io.File;

public class UseMicroprocessor {

	public static void main(String[] args) {
		Microprocessor processor = new Microprocessor(new File("mach.in"));
		String[] memory = processor.getMemory();

		for (String s : memory) {
			System.out.print(s);
		}

		processor = new Microprocessor(
				"040563B14004220FF31FF041320FE31FE00C2042314200032041314170080000F03000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001");
		memory = processor.getMemory();

		System.out.println();
		for (String s : memory) {
			System.out.print(s);
		}
	}

}
