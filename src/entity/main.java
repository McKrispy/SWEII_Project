package entity;

public class main {
    public static void main(String[] args) {
        Recipe r = new Recipe("Spaghetti Bolognese",2);
        Ingredient i1 = new Ingredient("Spaghetti");
        Ingredient i2 = new Ingredient("Ground Beef");

        r.addIngredient(new InstructionEntry(i1, 200, "grams"));
        r.addIngredient(new InstructionEntry(i2, 300, "grams"));

        r.addInstruction(new Instruction(1, "Boil the spaghetti."));
        r.addInstruction(new Instruction(2, "Cook the beef."));

        System.out.println(r);

        // Scale to 4 servings
        r.scaleIngredients(4);
        System.out.println("After scaling:\n" + r);
    }
    
    

}
