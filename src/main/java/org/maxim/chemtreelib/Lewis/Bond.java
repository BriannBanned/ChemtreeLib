package org.maxim.chemtreelib.Lewis;

import org.maxim.chemtreelib.Element.Element;

public class Bond {
    public Element atom1;
    public Element atom2;
    public int order; // 0 = no bond, 1 = single, 2 = double, 3 = triple

    public Bond(Element a1, Element a2, int order) {
        this.atom1 = a1;
        this.atom2 = a2;
        this.order = order;
    }

    public boolean isPolar(){
        double diff = Math.abs(atom1.GetElectronegativity() - atom2.GetElectronegativity());
        return diff >= 0.4;
    }

    public boolean isIonic(){
        double diff = Math.abs(atom1.GetElectronegativity() - atom2.GetElectronegativity());
        return diff >= 1.7;
    }

    @Override
    public String toString() {
        String bondType = "-".repeat(order);
        String polarStr = isIonic() ? " (ionic)" : isPolar() ? " (polar)" : "";
        return atom1.getTranslatedName() + bondType + atom2.getTranslatedName() + polarStr;
    }
}