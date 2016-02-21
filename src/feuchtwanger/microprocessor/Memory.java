package feuchtwanger.microprocessor;

public class Memory {
	public String[] memory;
	
	public Memory(String memoryString){
		this.memory = memoryString.split("");
	}

	public String[] getMemory() {
		return memory;
	}

	public void setMemory(String[] memory) {
		this.memory = memory;
	}
}
