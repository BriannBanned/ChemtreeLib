package main.java.net.briann.chemtreelib.element;

public class Element {

    public Element(String name,double molarMass){
        this.name = name;
        this.molarMass = molarMass;
    }

    private String name;
    private double molarMass;

    public double GetMass(){
        return molarMass;
    }
}
