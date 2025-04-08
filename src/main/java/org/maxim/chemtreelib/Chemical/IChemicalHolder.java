package org.maxim.chemtreelib.Chemical;

public interface IChemicalHolder {

    Mixture GetMixture();

    void SetMixture(Mixture mixture);

    double ChemicalCapacity();

    default boolean TrySetMixture(Mixture mixture){
        if(GetMixture().GetMixtureAmount() >= ChemicalCapacity()){
            return false;
        }
        if(IsLocked()){
            return false;
        }
        SetMixture(mixture);
        return true;
    }

    default boolean IsLocked(){
        return false;
    }


}
