package com.doriath.application.configuration;

import com.doriath.application.App;
import com.doriath.application.datamodel.*;
import com.doriath.guicomponents.util.stringconverter.WeightStringConverter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SavedDataLoader {

    private AnalisiDAO analisiDAO;
    public static final Path dataFile = Paths.get(App.configPath + "\\data.txt");

    public SavedDataLoader(AnalisiDAO analisiDAO) throws IOException {
        this.analisiDAO = analisiDAO;
        if (!Files.exists(dataFile)){
            initDataFile();
        }
    }

    private void initDataFile() throws IOException {
        List<String> lines = new ArrayList<>();
        for (var rifiuto : Rifiuto.values()){
            lines.add("0.0,0.0");
        }
        for (var itme : AnagrafeItem.values()){
            lines.add("");
        }
        Files.write(dataFile, lines);
    }

    public void load() throws IOException {
        var linesIterator = Files.readAllLines(dataFile).iterator();
        for (var rifiuto : Rifiuto.values()){
            String[] values = linesIterator.next().split(",");
            analisiDAO.getInputContainer()
                    .getMap()
                    .get(rifiuto)
                    .loadValues(Double.parseDouble(values[0]), Double.parseDouble(values[1]));
        }
        for (var item : AnagrafeItem.values()){
            String value = linesIterator.next();
            analisiDAO.getAnagrafeAnalisi()
                    .get(item)
                    .setValue(value);
        }
    }

    public void save() throws IOException {
        List<String> lines = new ArrayList<>();
        for (var rifiuto : Rifiuto.values()){
            InputRifiuto inputRifiuto = analisiDAO.getInputContainer()
                    .getMap()
                    .get(rifiuto);
            String lordo = WeightStringConverter.instance.toString(inputRifiuto.getPesoLordo());
            String tara = WeightStringConverter.instance.toString(inputRifiuto.getPesoTara());
            lines.add(lordo + "," + tara);
        }
        for (var item : AnagrafeItem.values()){
            lines.add(analisiDAO.getAnagrafeAnalisi().get(item).getValue());
        }
        Files.write(dataFile, lines);
    }

}
