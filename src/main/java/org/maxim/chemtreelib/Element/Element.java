package org.maxim.chemtreelib.Element;


public class Element {

    public Element(String name,int atomicNumber,double molarMass,int valenceElectrons){
        this.name = name;
        this.molarMass = molarMass;
        this.atomicNumber = atomicNumber;
        this.valenceElectrons = valenceElectrons;
    }

    private String name;
    private double molarMass;
    private int atomicNumber;
    private int valenceElectrons;

    public double GetMass(){
        return molarMass;
    }
}