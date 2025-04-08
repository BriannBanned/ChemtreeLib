package org.maxim.chemtreelib.Element;


import net.minecraft.network.chat.Component;

public class Element {

    public Element(String name,int atomicNumber,double molarMass,int valenceElectrons,double electroNegativity){
        this.name = name;
        this.molarMass = molarMass;
        this.atomicNumber = atomicNumber;
        this.valenceElectrons = valenceElectrons;
        this.electroNegativity  = electroNegativity;
    }

    private String name;
    private double molarMass;
    private int atomicNumber;
    private int valenceElectrons;
    private double electroNegativity;

    public double GetMass(){
        return molarMass;
    }
    public double GetElectronegativity(){
        return this.electroNegativity;
    }
    public int getValenceElectrons(){
        return this.valenceElectrons;
    }

    public String getName(){
        return name;
    }

    public String getTranslatedName(){
        return Component.translatable("element.chemtreelib."+name).getString();
    }

    public int getAtomicNumber(){
        return this.atomicNumber;
    }
}