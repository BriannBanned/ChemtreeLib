package org.maxim.chemtreelib.Chemical;

import org.maxim.chemtreelib.Molecule.Molecule;

import java.util.function.Supplier;

public class Chemical {

    public Chemical(String name, double energyVaporization, Supplier<Molecule> molecule){
        this.chemicalName = name;
        this.energyVaporization = energyVaporization;
        this.molecule = molecule;
    }


    public Supplier<Molecule> molecule;
    public String chemicalName;
    public double energyVaporization;

}