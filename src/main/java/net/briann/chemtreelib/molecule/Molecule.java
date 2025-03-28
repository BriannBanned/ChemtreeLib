package main.java.net.briann.chemtreelib.molecule;

import main.java.net.briann.chemtreelib.element.Element;

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
