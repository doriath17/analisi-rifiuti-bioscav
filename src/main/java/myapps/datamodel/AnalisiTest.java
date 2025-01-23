package myapps.datamodel;

import java.util.HashMap;
import java.util.Iterator;

public class AnalisiTest extends Analisi{

    public void randomInput(){
        for (Iterator<Rifiuto> i = rifiutiArray.iterator(); i.hasNext();){
            Rifiuto rif = i.next();
            rif.randomSetup();
        }
    }

    public AnalisiTest(){
        randomInput();
    }

}
