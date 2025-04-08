package org.maxim.chemtreelib.Lewis;

import org.maxim.chemtreelib.Element.Element;
import org.maxim.chemtreelib.Element.Elements;
import org.maxim.chemtreelib.Molecule.Molecule;

import java.util.ArrayList;
import java.util.List;

public class LewisHelper {

    public static ConstructedMolecule buildMoleculeStructure(Molecule molecule){

        Element[] curElements = molecule.GetElements(); //Get molecules elements

        Element centerElement = null;
        double minEN = Double.MAX_VALUE;
        int totalValence = 0; //Determine total number of valence and least negativity
        for(Element element : curElements){ //Two birds one fat stone
            totalValence += element.getValenceElectrons();

            if(element != Elements.HYDROGEN){ //skip hydrogen
                if(element.GetElectronegativity() < minEN){
                    minEN = element.GetElectronegativity();
                    centerElement = element;
                }
            }
        }

        if(centerElement == null) centerElement = curElements[0]; //Fallback if like hydrogen is only element

        List<Bond> bonds = new ArrayList<>(); //Add bonds for every element
        for (Element e : curElements) {
            if (e == centerElement) continue;

            // Check electronegativity difference to determine if ionic bond exists
            double EN_diff = Math.abs(centerElement.GetElectronegativity() - e.GetElectronegativity());

            if (EN_diff >= 1.7) { // Ionic bond (electronegativity difference is high enough) //Todo implement charges on each element like a MoleculeElement
                // In ionic bonds, we don't actually "share" electrons, we just assign charges
                // Sodium (Na) will lose an electron, Chlorine (Cl) will gain an electron
                System.out.println("Ionic bond between " + centerElement.getName() + " and " + e.getName());
                // Create an ionic pair
                bonds.add(new Bond(centerElement, e, 0)); // No bond order for ionic bond
            } else {
                // Covalent bond (electronegativity difference is small)
                int bondsNeeded = e.getValenceElectrons() / 2;
                for (int i = 0; i < bondsNeeded; i++) {
                    bonds.add(new Bond(centerElement, e, 1));
                    totalValence -= 2;  // Each bond consumes 2 electrons
                }
            }
        }

        if (bonds.stream().anyMatch(b -> b.order == 0)) {
            System.out.println("This molecule has ionic bonds, skipping electron adjustments.");
        } else {
            // Step 3: Check lone pairs and add bonds if needed
            for (Element e : curElements) {
                int needed = (e == Elements.HYDROGEN) ? 2 : 8; // Hydrogen needs 2, others need 8 electrons
                int bonded = (int) bonds.stream()
                        .filter(b -> b.atom1 == e || b.atom2 == e)
                        .mapToInt(b -> b.order * 2) // Account for number of electrons used in bonds
                        .sum();

                int lonePairs = (needed - bonded);
                totalValence -= lonePairs;  // Adjust total valence for lone pairs
            }

            // Step 4: Upgrade bonds if there are leftover valence electrons
            while (totalValence < 0) {
                for (Bond b : bonds) {
                    if (b.order < 3) {
                        b.order++; // Upgrade single bond to double/triple
                        totalValence += 2;
                        break;
                    }
                }
            }
        }

        System.out.println("Created molecule with bonds:");
        for (Bond b : bonds) {
            System.out.println("  " + b);
        }
        return new ConstructedMolecule(bonds,molecule);
    }

}
