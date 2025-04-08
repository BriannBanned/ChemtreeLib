package org.maxim.chemtreelib.Lewis;

import org.maxim.chemtreelib.Element.Element;
import org.maxim.chemtreelib.Molecule.Molecule;

import java.util.List;

public class ConstructedMolecule {
    public Molecule molecule;
    public int lonePairsCenter;
    public List<Bond> Bonds;

    public ConstructedMolecule(List<Bond> Bonds, Molecule molecule){
        this.Bonds = Bonds;
        this.molecule = molecule;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Print molecule name (optional: formula builder later)
        sb.append("Constructed Molecule:\n");

        // Print elements
        sb.append("Elements: ");
        for (Element e : molecule.GetElements()) {
            sb.append(e.getName()).append(" ");
        }
        sb.append("\n");

        // Molecular mass
        sb.append("Molecular Mass: ").append(String.format("%.3f", molecule.GetMolecularMass())).append(" g/mol\n");

        // Bonds
        sb.append("Bonds:\n");
        for (Bond b : Bonds) {
            sb.append("  ").append(b).append("\n");
        }

        return sb.toString();
    }

    public double GetElectronegativity(){
        double totalElectronegativity = 0;
        int totalBondCount = 0;
        for (Bond b : Bonds) {
            // For ionic bonds, we just take the average of the two electronegativities
            if (b.order == 0) {  // Ionic bond
                totalElectronegativity += (b.atom1.GetElectronegativity() + b.atom2.GetElectronegativity()) / 2;
                totalBondCount++; // Count the bond
            } else {  // Covalent bond
                totalElectronegativity += (b.atom1.GetElectronegativity() + b.atom2.GetElectronegativity()) / 2 * b.order;
                totalBondCount += b.order; // Multiply by the bond order to account for multiple bonds
            }
        }

        // Return the average electronegativity of the molecule
        return totalElectronegativity / totalBondCount;
    }

}
