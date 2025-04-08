package org.maxim.chemtreelib.Molecule;

import org.maxim.chemtreelib.ChemistryMath.ChemistryMath;
import org.maxim.chemtreelib.Element.Elements;

public class Molecules {
    public static final Molecule WATER_MOLECULE = new Molecule(ChemistryMath.CTK(0),ChemistryMath.CTK(100),2338.794f,40.79,Elements.HYDROGEN,Elements.HYDROGEN,Elements.OXYGEN);
    public static final Molecule SODIUM_CHLORIDE_MOLECULE = new Molecule(ChemistryMath.CTK(801),ChemistryMath.CTK(1465),130000,171,Elements.SODIUM,Elements.CHLORINE);
}