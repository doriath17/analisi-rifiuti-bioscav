//package myapps.pdf;
//
//import com.lowagie.text.*;
//import com.lowagie.text.alignment.HorizontalAlignment;
//import com.lowagie.text.alignment.VerticalAlignment;
//import com.lowagie.text.pdf.PdfWriter;
//import myapps.datamodel.Analisi;
//import myapps.datamodel.CategoriaRifiutoBase;
//import myapps.datamodel.Rifiuto;
//import myapps.gui.PositiveDoubleStringConverter;
//import myapps.gui.PrimaryWindowController;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Iterator;
//
//import static java.io.File.*;
//
//public class PdfGenerator {
//
//    static final int ANAGRAFE_COLSPAN = 4;
//    static final PositiveDoubleStringConverter converter = new PositiveDoubleStringConverter();
//
//    static void setTableHeader(Table table, String title, int colspan){
//        Cell cell = new Cell(title);
//        cell.setHorizontalAlignment(HorizontalAlignment.CENTER);
//        cell.setVerticalAlignment(VerticalAlignment.CENTER);
//        cell.setHeader(true);
//        cell.setColspan(colspan);
//        table.addCell(cell);
//        table.endHeaders();
//    }
//
//    static Cell getNewCell(String s, Font f){
//        Phrase phrase = new Phrase(s, f);
//        Cell cell = new Cell(phrase);
//        cell.setVerticalAlignment(VerticalAlignment.CENTER);
//        return cell;
//    }
//
//    static void prepareAnagrafeTable(Table table, HashMap<String, String> anagrafe, Font font){
//        for (Iterator<String> keyI = PrimaryWindowController.anagrafeStrings.iterator(), valueI = anagrafe.values().iterator(); keyI.hasNext();){
//            table.addCell(getNewCell(keyI.next(), font));
//            table.addCell(getNewCell(valueI.next(), font));
//        }
//    }
//
//    static void prepareAnalisiDataTable(Table table, Analisi currentAnalisi, Font font){
//        table.addCell(getNewCell("Tipo Rifiuto", font));
//        table.addCell(getNewCell("Peso Lordo (kg)", font));
//        table.addCell(getNewCell("Peso Tara (kg)", font));
//        table.addCell(getNewCell("Peso Netto (kg)", font));
//
//        for (Iterator<Rifiuto> i = currentAnalisi.getRifiutiArray().iterator(); i.hasNext();){
//            Rifiuto rifiuto = i.next();
//            table.addCell(getNewCell(rifiuto.getName(), font));
//            table.addCell(getNewCell(converter.toString(rifiuto.getPesoLordo().getValue()), font));
//            table.addCell(getNewCell(converter.toString(rifiuto.getPesoTara().getValue()), font));
//            table.addCell(getNewCell(converter.toString(rifiuto.getPesoNetto().getValue()), font));
//        }
//    }
//
//    static void prepareCategories(Table table, Analisi currentAnalisi, Font font) {
//        table.addCell(getNewCell("Categoria", font));
//        table.addCell(getNewCell("kg", font));
//        table.addCell(getNewCell("%", font));
//
//        for (Iterator<CategoriaRifiutoBase> i = currentAnalisi.getCategorieArray().iterator(); i.hasNext(); ) {
//            CategoriaRifiutoBase categoria = i.next();
//            table.addCell(getNewCell(categoria.getName(), font));
//            table.addCell(getNewCell(converter.toString(categoria.getPesoTotale().getValue()), font));
//            table.addCell(getNewCell(converter.toString(categoria.getPesoPercentuale().getValue()), font));
//        }
//
//        table.addCell(getNewCell("Materiale Differenziato", font));
//        table.addCell(getNewCell(converter.toString(currentAnalisi.getMaterialeDiff().getPesoTotale().getValue()), font));
//        table.addCell(getNewCell(converter.toString(currentAnalisi.getMaterialeDiff().getPesoPercentuale().getValue()), font));
//        table.addCell(getNewCell("Frazione Estranea Totale", font));
//        table.addCell(getNewCell(converter.toString(currentAnalisi.getFrazioneEstraneaTot().getPesoTotale().getValue()), font));
//        table.addCell(getNewCell(converter.toString(currentAnalisi.getFrazioneEstraneaTot().getPesoPercentuale().getValue()), font));
//    }
//
//
//    public static void generatePdf(File selectedDirectory, String filename, Analisi currentAnalisi, HashMap<String, String> anagrafe){
//
//        Document document = new Document(PageSize.A4);
//
//        try {
//            PdfWriter write = PdfWriter.getInstance(document, new FileOutputStream(
//                    selectedDirectory.getAbsolutePath() + separator + filename));
//            document.open();
//
//            Font font = FontFactory.getFont(FontFactory.HELVETICA, 10);
//
//            Table table = new Table(ANAGRAFE_COLSPAN);
//            table.setBorderWidth(1);
//            table.setPadding(2);
//
//            setTableHeader(table, "ANAGRAFE", 4);
//            prepareAnagrafeTable(table, anagrafe, font);
//            document.add(table);
//
//            table = new Table(4);
//            table.setBorderWidth(1);
//            table.setPadding(2);
//
//            setTableHeader(table, "DATI ANALIZZATI", 4);
//            prepareAnalisiDataTable(table, currentAnalisi, font);
//            document.add(table);
//
//            table = new Table(3);
//            table.setBorderWidth(1);
//            table.setPadding(2);
//
//            setTableHeader(table, "RISULTATI ANALISI", 3);
//            prepareCategories(table, currentAnalisi, font);
//            document.add(table);
//        } catch (DocumentException | IOException de){
//            System.err.println(de.getMessage());
//        }
//        document.close();
//    }
//
//}
