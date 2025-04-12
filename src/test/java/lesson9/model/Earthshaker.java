package lesson9.model;

public class Earthshaker {
    private String name;
    private String typeOfAttack;
    private String attribute;
    private StartingAttributes startingAttributes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOfAttack() {
        return typeOfAttack;
    }

    public void setTypeOfAttack(String typeOfAttack) {
        this.typeOfAttack = typeOfAttack;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public StartingAttributes getStartingAttributes() {
        return startingAttributes;
    }

    public void setStartingAttributes(StartingAttributes startingAttributes) {
        this.startingAttributes = startingAttributes;
    }
}
