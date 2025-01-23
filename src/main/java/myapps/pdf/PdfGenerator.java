package myapps.pdf;

import com.lowagie.text.*;
import com.lowagie.text.alignment.HorizontalAlignment;
import com.lowagie.text.alignment.VerticalAlignment;
import com.lowagie.text.pdf.PdfWriter;
import myapps.datamodel.Analisi;

import java.io.FileOutputStream;
import java.io.IOException;

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

    public static void generatePdf(String filename, Analisi analisi){
        Document document = new Document(PageSize.A4);

        try {
            PdfWriter write = PdfWriter.getInstance(document, new FileOutputStream("files/app-template.pdf"));
            document.open();

            Font font = FontFactory.getFont(FontFactory.HELVETICA, 12);

            Table table = new Table(ANAGRAFE_COLSPAN);
            table.setBorderWidth(1);
            table.setPadding(2);

            setTableHeader(table, "ANAGRAFE");

            table.addCell(getNewCell("Comune", font));
            table.addCell(getNewCell("Mondragone", font));
            table.addCell(getNewCell("", font));
            table.addCell(getNewCell("Data Formulario", font));
            table.addCell(getNewCell("Numero CER", font));

            document.add(table);

            table = new Table(4);
            setTableHeader(table, "DATI ANALIZZATI");

            table.addCell(getNewCell("Comune", font));
            table.addCell(getNewCell("Mondragone", font));
            table.addCell(getNewCell("Formulario", font));
            table.addCell(getNewCell("Data Formulario", font));
            table.addCell(getNewCell("Numero CER", font));

            document.open();
        } catch (DocumentException | IOException de){
            System.err.println(de.getMessage());
        }
        document.close();
    }

}
