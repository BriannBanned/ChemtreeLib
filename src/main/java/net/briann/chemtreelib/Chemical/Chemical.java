package main.java.net.briann.chemtreelib.chemical;

import java.util.function.Supplier;
import main.java.net.briann.chemtreelib.molecule.Molecule;

public class Chemical {
    
    public Chemical(String name,double energyVaporization,Supplier<Molecule> molecule){
        this.chemicalName = name;
        this.energyVaporization = energyVaporization;
        this.molecule = molecule;
    }


    public Supplier<Molecule> molecule;
    public String chemicalName;
    public double energyVaporization;

}
