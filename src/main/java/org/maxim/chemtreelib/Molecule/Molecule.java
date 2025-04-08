package org.maxim.chemtreelib.Molecule;

import org.maxim.chemtreelib.Element.Element;

public class Molecule {


    public Molecule(double meltPoint,double boilPoint,double standardPressure,double energyVaporization,Element ... Elements){
        this.Elements = Elements;
        this.energyVaporization = energyVaporization;
        this.standardPressure = standardPressure;
        this.meltPoint = meltPoint;
        this.boilPoint = boilPoint;
    }

    private final double standardPressure;
    private final double meltPoint;
    private final double boilPoint;

    public double GetMeltPoint(){
        return meltPoint;
    }
    public double GetBoilPoint(){
        return boilPoint;
    }

    public double GetStandardPressure(){
        return standardPressure;
    }

    private final Element[] Elements;
    private final double energyVaporization;

    public double GetEnergyVaporization(){
        return energyVaporization;
    }


    public double GetMolecularMass(){
        double total = 0;
        for (Element s : Elements) {
            total += s.GetMass();
        }
        return total;
    }

    public Element[] GetElements(){
        return Elements;
    }
}