package org.maxim.chemtreelib.ChemistryMath;

import org.maxim.chemtreelib.Molecule.Molecule;

public class ChemistryMath {

    public static double calculateVaporPressure(Molecule molecule, double TemperatureKelvin) { //uh chaoulkics equations or whatever
        final double R = 8.314; //J/K/Mol

        double ratio = Math.exp((molecule.GetEnergyVaporization() / R) * ((1 / TemperatureConvert(20,"c","k")) - (1 / TemperatureKelvin)));
        double P2 = molecule.GetStandardPressure() * ratio; //Todo remove standard pressure this is cluttering molecule creation, somehow do it
        return P2;
    }

    public static double TemperatureConvert(double temp,String from, String to){
        if(from.equalsIgnoreCase("c") && to.equalsIgnoreCase("k")){
            return temp + 273.15;
        }
        System.out.println("Failed to convert " + temp + " to " + to + " from " + from);
        return temp;
    }
    public static double CTK(double temp){
        return temp + 273.15;
    }
}
