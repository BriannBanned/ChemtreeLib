package org.maxim.chemtreelib.Chemical;

import java.util.Arrays;
import java.util.List;

public class Mixture {

    public Mixture(MixtureMolecule ... Molecules){
        this.Molecules = Arrays.stream(Molecules).toList();
    }

    public List<MixtureMolecule> Molecules;

    public double GetMixtureAmount(){
        double total = 0;
        for(MixtureMolecule chem : this.Molecules){
            total += chem.amount;
        }
        return total;
    }

}
