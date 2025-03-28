package main.java.net.briann.chemtreelib.registry;

import main.java.net.briann.chemtreelib.chemical.Chemical;
import main.java.net.briann.chemtreelib.molecule.Molecules;

public class Chemicals {
    

    public static final Chemical water = new Chemical("water",2560,()->Molecules.WATER_MOLECULE);


}
