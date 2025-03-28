package main.java.net.briann.chemtreelib.chemical;

import main.java.net.briann.chemtreelib.molecule.Molecules;

public class Chemicals {
    

    public static final Chemical WATER = new Chemical("water",2560,()->Molecules.WATER_MOLECULE);
    public static final Chemical SODIUM_CHLORIDE = new Chemical("sodium_chloride",130000,()->Molecules.SODIUM_CHLORIDE_MOLECULE);


}
