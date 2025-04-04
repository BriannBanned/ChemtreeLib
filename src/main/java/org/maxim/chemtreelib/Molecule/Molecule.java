package org.maxim.chemtreelib.Molecule;

import org.maxim.chemtreelib.Element.Element;

public class Molecule {
    public Molecule(Element ... Elements){
        this.Elements = Elements;
    }

    private final Element[] Elements;

    public double GetMolecularMass(){
        double total = 0;
        for (Element s : Elements) {
            total += s.GetMass();
        }
        return total;
    }
}