package myapps.analisibioscav.datamodel;

import java.util.HashMap;
import java.util.Iterator;

public class InputContainer {
    private final HashMap<Rifiuto, InputRifiuto> map = new HashMap<>();

    public InputContainer(ResultContainer resultContainer){
        for (var typeRifiuto : Rifiuto.values()){
            map.put(typeRifiuto, new InputRifiuto());
        }
        setResultContainer(resultContainer);
    }

    public HashMap<Rifiuto, InputRifiuto> getMap(){
        return map;
    }

    public void setResultContainer(ResultContainer resultContainer){
        var resultMap = resultContainer.getMap();
        map.get(Rifiuto.IMBALLAGGI_COREPLA).setResults(resultContainer, resultMap.get(CategoriaRifiuto.MONOMATERIALE));
        map.get(Rifiuto.INDUSTRIALI).setResults(resultContainer,        resultMap.get(CategoriaRifiuto.TRACCIANTI));
        map.get(Rifiuto.ALLUMINIO_ACCIAIO).setResults(resultContainer,  resultMap.get(CategoriaRifiuto.MDIFF_ALLUMINIO_ACCIAIO));
        map.get(Rifiuto.UMIDO).setResults(resultContainer,              resultMap.get(CategoriaRifiuto.FE_TOTALE));
        map.get(Rifiuto.VETRO).setResults(resultContainer,              resultMap.get(CategoriaRifiuto.FE_TOTALE));
        map.get(Rifiuto.CARTA_TETRA_PAK).setResults(resultContainer,    resultMap.get(CategoriaRifiuto.FE_TOTALE));
        map.get(Rifiuto.MEDICINALI).setResults(resultContainer,         resultMap.get(CategoriaRifiuto.FE_TOTALE));
        map.get(Rifiuto.FRAZIONI_FINI_2X2).setResults(resultContainer,  resultMap.get(CategoriaRifiuto.FE_TOTALE));
        map.get(Rifiuto.RAEE).setResults(resultContainer,               resultMap.get(CategoriaRifiuto.FE_TOTALE));
        map.get(Rifiuto.LEGNO).setResults(resultContainer,              resultMap.get(CategoriaRifiuto.FE_TOTALE));
        map.get(Rifiuto.TESSUTI).setResults(resultContainer,            resultMap.get(CategoriaRifiuto.FE_TOTALE));
        map.get(Rifiuto.ALTRE_FE).setResults(resultContainer,           resultMap.get(CategoriaRifiuto.FE_TOTALE));
    }

    public void reset(){
        for (var i : map.values()){
            i.reset();
        }
    }

    public void refresh(){
        for (var i : map.values()){
            i.updatePesoNetto();
        }
    }
}
