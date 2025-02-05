package com.doriath.application.pdf;

import com.doriath.application.datamodel.*;
import com.doriath.guicomponents.util.stringconverter.PercentageStringConverter;
import com.doriath.guicomponents.util.stringconverter.PositiveIntegerStringConverter;
import com.lowagie.text.*;
import com.lowagie.text.alignment.HorizontalAlignment;
import com.lowagie.text.alignment.VerticalAlignment;
import com.lowagie.text.pdf.PdfWriter;
import com.doriath.guicomponents.util.stringconverter.WeightStringConverter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import static java.io.File.separator;

public class PdfGenerator {

    static final int ANAGRAFE_COLSPAN = 4;
    final WeightStringConverter weightStringConverter = WeightStringConverter.instance;
    final PercentageStringConverter percentageStringConverter = PercentageStringConverter.instance;
    final PositiveIntegerStringConverter positiveIntegerStringConverter = PositiveIntegerStringConverter.instance;

    private ResultContainer resultContainer;
    private InputContainer inputContainer;
    private AnagrafeAnalisi anagrafe;
    private Font font = FontFactory.getFont(FontFactory.HELVETICA, 10);
    private Font headerFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD);

    public PdfGenerator(AnalisiDAO analisiDAO) {
        this.inputContainer = analisiDAO.getInputContainer();
        this.resultContainer = analisiDAO.getResultContainer();
        this.anagrafe = analisiDAO.getAnagrafeAnalisi();
    }

    void setTableHeader(Table table, String title, int colspan){
        Cell cell = new Cell(title);
        cell.setHorizontalAlignment(HorizontalAlignment.CENTER);
        cell.setVerticalAlignment(VerticalAlignment.CENTER);
        cell.setHeader(true);
        cell.setColspan(colspan);
        table.addCell(cell);
        table.endHeaders();
    }

    Cell getNewCell(String s){
        Phrase phrase = new Phrase(s, font);
        Cell cell = new Cell(phrase);
        cell.setVerticalAlignment(VerticalAlignment.CENTER);
        return cell;
    }

    Cell getNewWeightCell(Double val){
        String s = weightStringConverter.toString(val);
        return getNewCell(s);
    }

    Cell getNewPercentageCell(Double val){
        String s = percentageStringConverter.toString(val);
        return getNewCell(s);
    }

    Cell getNewPositiveIntegerCell(Integer val){
        String s = positiveIntegerStringConverter.toString(val);
        return getNewCell(s);
    }


    private Cell getNewHeaderCell(String s){
        Phrase phrase = new Phrase(s, headerFont);
        Cell cell = new Cell(phrase);
        cell.setVerticalAlignment(VerticalAlignment.CENTER);
        cell.setHorizontalAlignment(HorizontalAlignment.CENTER);
        return cell;
    }

    private void prepareAnagrafeTable(Table table){
        for (var item : AnagrafeItem.values()){
            String text = item.getText();
            table.addCell(getNewCell(text));
            table.addCell(getNewCell(anagrafe.get(item).getValue()));
        }
    }

    private void prepareAnalisiDataTable(Table table){
        table.addCell(getNewHeaderCell("Tipo Rifiuto"));
        table.addCell(getNewHeaderCell("Peso Lordo (kg)"));
        table.addCell(getNewHeaderCell("Peso Tara (kg)"));
        table.addCell(getNewHeaderCell("Peso Netto (kg)"));

        var map = inputContainer.getMap();

        for (var rifiuto : Rifiuto.values()){
            InputRifiuto input = map.get(rifiuto);
            table.addCell(getNewCell(rifiuto.getText()));
            table.addCell(getNewWeightCell(input.getPesoLordo()));
            table.addCell(getNewWeightCell(input.getPesoTara()));
            table.addCell(getNewWeightCell(input.getPesoNetto()));
        }
    }

    private void prepareCategories(Table table) {
        table.addCell(getNewHeaderCell("Categoria"));
        table.addCell(getNewHeaderCell("kg"));
        table.addCell(getNewHeaderCell("%"));

        var map = resultContainer.getMap();

        for (var category : CategoriaRifiuto.values()){
            var result = map.get(category);
            table.addCell(getNewCell(category.getText()));
            table.addCell(getNewWeightCell(result.getPesoTotale()));
            table.addCell(getNewPercentageCell(result.getPesoPercentuale()));
        }
    }

    public void generatePdf(File selectedDirectory, String filename)
            throws NoDirectorySelectedExeption, FilenameException {

        if (selectedDirectory == null){
            throw new NoDirectorySelectedExeption("Errore: nessuna cartella selezionata");
        }

        Document document = new Document(PageSize.A4);

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(
                    selectedDirectory.getAbsolutePath() + separator + filename));
            document.open();

            Table table = new Table(ANAGRAFE_COLSPAN);
            table.setBorderWidth(1);
            table.setPadding(2);

            setTableHeader(table, "ANAGRAFE", ANAGRAFE_COLSPAN);
            prepareAnagrafeTable(table);
            document.add(table);

            table = new Table(4);
            table.setBorderWidth(1);
            table.setPadding(2);

            setTableHeader(table, "DATI ANALIZZATI", 4);
            prepareAnalisiDataTable(table);
            document.add(table);

            table = new Table(3);
            table.setBorderWidth(1);
            table.setPadding(2);

            setTableHeader(table, "RISULTATI ANALISI", 3);
            prepareCategories(table);
            document.add(table);

            table = new Table(2);
            table.setBorderWidth(1);
            table.setPadding(2);
            table.addCell(getNewCell("Peso Campione (Kg)"));
            table.addCell(getNewCell(weightStringConverter.toString(resultContainer.getPesoCampione().getPesoCampione().getValue())));
            table.addCell(getNewCell("Range Qualità"));
            table.addCell(getNewCell(positiveIntegerStringConverter.toString(resultContainer.getQualityRange().getValue())));
            document.add(table);

            Paragraph note = new Paragraph("Nota: ", font);
            note.add(resultContainer.getNote());
            document.add(note);
        } catch (DocumentException | IOException de){
            throw new FilenameException("Errore: nome del file invalido");
        }
        document.close();
    }

}
