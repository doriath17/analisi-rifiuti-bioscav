package myapps.analisibioscav.pdf;

import com.lowagie.text.*;
import com.lowagie.text.alignment.HorizontalAlignment;
import com.lowagie.text.alignment.VerticalAlignment;
import com.lowagie.text.pdf.PdfWriter;
import myapps.analisibioscav.datamodel.*;
import myapps.analisibioscav.gui.PositiveDoubleStringConverter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import static java.io.File.separator;

public class PdfGenerator {

    static final int ANAGRAFE_COLSPAN = 4;
    static final PositiveDoubleStringConverter converter = new PositiveDoubleStringConverter();

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

    private Cell getNewHeaderCell(String s){
        Phrase phrase = new Phrase(s, headerFont);
        Cell cell = new Cell(phrase);
        cell.setVerticalAlignment(VerticalAlignment.CENTER);
        cell.setHorizontalAlignment(HorizontalAlignment.CENTER);
        return cell;
    }

    private void prepareAnagrafeTable(Table table){
        var map = anagrafe.getMap();
        for (Iterator<String> i = AnagrafeAnalisi.names.iterator(); i.hasNext();){
            String name = i.next();
            table.addCell(getNewCell(name));
            table.addCell(getNewCell(map.get(name)));
        }
    }

    private void prepareAnalisiDataTable(Table table){
        table.addCell(getNewHeaderCell("Tipo Rifiuto"));
        table.addCell(getNewHeaderCell("Peso Lordo (kg)"));
        table.addCell(getNewHeaderCell("Peso Tara (kg)"));
        table.addCell(getNewHeaderCell("Peso Netto (kg)"));

        var map = inputContainer.getMap();
        for (Iterator<String> i = InputContainer.names.iterator(); i.hasNext(); ){
            String name = i.next();
            Rifiuto rifiuto = map.get(name);
            table.addCell(getNewCell(name));
            table.addCell(getNewCell(converter.toString(rifiuto.getPesoLordo().getValue())));
            table.addCell(getNewCell(converter.toString(rifiuto.getPesoTara().getValue())));
            table.addCell(getNewCell(converter.toString(rifiuto.getPesoNetto().getValue())));
        }
    }

    private void prepareCategories(Table table) {
        table.addCell(getNewHeaderCell("Categoria"));
        table.addCell(getNewHeaderCell("kg"));
        table.addCell(getNewHeaderCell("%"));

        var map = resultContainer.getMap();

        for (Iterator<String> i = ResultContainer.names.iterator(); i.hasNext();){
            String name = i.next();
            CategoriaRifiutoBase categoria = map.get(name);

            table.addCell(getNewCell(name));
            table.addCell(getNewCell(converter.toString(categoria.getPesoTotale().getValue())));
            table.addCell(getNewCell(converter.toString(categoria.getPesoPercentuale().getValue())));
        }
    }

    public void generatePdf(File selectedDirectory, String filename){

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
        } catch (DocumentException | IOException de){
            System.err.println(de.getMessage());
        }
        document.close();
    }

}
