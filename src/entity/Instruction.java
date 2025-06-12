package entity;

public class Instruction {
    private int stepNumber;
    private String description;
    
    
	public Instruction(int stepNumber, String description) {
		super();
		this.stepNumber = stepNumber;
		this.description = description;
	}
	
	//getters&setters
	public int getStepNumber() {
		return stepNumber;
	}
	public void setStepNumber(int stepNumber) {
		this.stepNumber = stepNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    
   

    @Override
    public String toString() {
        return "Step " + stepNumber + ": " + description;
    }

}
