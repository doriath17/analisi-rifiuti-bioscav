package myapps.pdf;

import com.lowagie.text.*;
import com.lowagie.text.alignment.HorizontalAlignment;
import com.lowagie.text.alignment.VerticalAlignment;
import com.lowagie.text.pdf.PdfWriter;
import myapps.datamodel.Analisi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import static java.io.File.*;

public class PdfGenerator {

    static final int ANAGRAFE_COLSPAN = 4;

    static void setTableHeader(Table table, String title){
        Cell cell = new Cell(title);
        cell.setHorizontalAlignment(HorizontalAlignment.CENTER);
        cell.setVerticalAlignment(VerticalAlignment.CENTER);
        cell.setHeader(true);
        cell.setColspan(ANAGRAFE_COLSPAN);
        table.addCell(cell);
        table.endHeaders();
    }

    static Cell getNewCell(String s, Font f){
        Phrase phrase = new Phrase(s, f);
        Cell cell = new Cell(phrase);
        cell.setVerticalAlignment(VerticalAlignment.CENTER);
        return cell;
    }

    static void prepareAnagrafeTable(Table table, HashMap<String, String> anagrafe, Font font){
        for (Iterator<String> keyI = anagrafe.keySet().iterator(), valueI = anagrafe.values().iterator(); keyI.hasNext();){
            table.addCell(getNewCell(keyI.next(), font));
            table.addCell(getNewCell(valueI.next(), font));
        }
    }

    public static void generatePdf(File selectedDirectory, String filename, Analisi analisi, HashMap<String, String> anagrafe){

        Document document = new Document(PageSize.A4);

        try {
            PdfWriter write = PdfWriter.getInstance(document, new FileOutputStream(
                    selectedDirectory.getAbsolutePath() + separator + filename));
            document.open();

            Font font = FontFactory.getFont(FontFactory.HELVETICA, 12);

            Table table = new Table(ANAGRAFE_COLSPAN);
            table.setBorderWidth(1);
            table.setPadding(2);

            setTableHeader(table, "ANAGRAFE");

            prepareAnagrafeTable(table, anagrafe, font);

            document.add(table);
        } catch (DocumentException | IOException de){
            System.err.println(de.getMessage());
        }
        document.close();
    }

}
