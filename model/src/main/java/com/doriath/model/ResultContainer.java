package com.doriath.model;

import java.util.HashMap;

public class ResultContainer {
    private final PesoCampione pesoCampione = new PesoCampione();
    private final QualityRange qualityRange;
    private String note = "";

    private final HashMap<CategoriaRifiuto, CategoriaRifiutoBase> map = new HashMap<>();

    public ResultContainer() {
        map.put(CategoriaRifiuto.MDIFF_TOTALE,             new CategoriaRifiutoBase(pesoCampione));
        map.put(CategoriaRifiuto.MDIFF_COREPLA,            new CategoriaRifiutoBase(pesoCampione, map.get(CategoriaRifiuto.MDIFF_TOTALE)));
        map.put(CategoriaRifiuto.MDIFF_ALLUMINIO_ACCIAIO,  new CategoriaRifiutoBase(pesoCampione, map.get(CategoriaRifiuto.MDIFF_TOTALE)));
        map.put(CategoriaRifiuto.FE_TOTALE,                new CategoriaRifiutoBase(pesoCampione));
        map.put(CategoriaRifiuto.MONOMATERIALE,            new CategoriaRifiutoBase(pesoCampione, map.get(CategoriaRifiuto.MDIFF_COREPLA)));
        map.put(CategoriaRifiuto.TRACCIANTI,               new CategoriaRifiutoBase(pesoCampione, map.get(CategoriaRifiuto.MDIFF_COREPLA)));

        qualityRange = new QualityRange(map.get(CategoriaRifiuto.MDIFF_TOTALE));
    }

    // peso campione

    public PesoCampione getPesoCampione() {
        return pesoCampione;
    }

    public QualityRange getQualityRange() {
        return qualityRange;
    }
    
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public HashMap<CategoriaRifiuto, CategoriaRifiutoBase> getMap(){
        return map;
    }

    public void updatePercentualiCategorie(){
        for (CategoriaRifiutoBase categoria : map.values()){
            categoria.updatePesoPercentuale();
        }
        qualityRange.update();
    }

    public void reset(){
        pesoCampione.getPesoCampione().setValue(0.0);
        qualityRange.reset();
        for (var i : map.values()){
            i.reset();
        }
    }
}
