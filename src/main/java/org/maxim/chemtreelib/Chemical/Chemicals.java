package org.maxim.chemtreelib.Chemical;

import org.maxim.chemtreelib.Molecule.Molecules;

public class Chemicals {
    public static final Chemical WATER = new Chemical("water",2560,()-> Molecules.WATER_MOLECULE);
    public static final Chemical SODIUM_CHLORIDE = new Chemical("sodium_chloride",130000,()->Molecules.SODIUM_CHLORIDE_MOLECULE);
}