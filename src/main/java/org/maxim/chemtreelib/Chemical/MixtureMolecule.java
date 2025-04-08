package org.maxim.chemtreelib.Chemical;

import org.maxim.chemtreelib.Molecule.Molecule;

public class MixtureMolecule {
    public double amount;
    public Molecule molecule;
    public double temperature;
    public MixtureMolecule(Molecule chemical, double amount){
        this.molecule = chemical;
        this.amount = amount;
    }
}
