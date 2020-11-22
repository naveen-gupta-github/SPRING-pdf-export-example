package com.app.naveen.PDFexport.utilities;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import com.app.naveen.PDFexport.models.Actor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GeneratePDF {

	private static final Logger logger = LoggerFactory.getLogger(GeneratePDF.class);
	
	public static ByteArrayInputStream getPDF(List<Actor> actors) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(90);
            table.setWidths(new int[]{1, 2, 2});

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            BaseColor backgroundColor  =  BaseColor.LIGHT_GRAY;
            
            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("Id", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setPadding(10);
            hcell.setBackgroundColor(backgroundColor);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("First Name", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setPadding(10);
            hcell.setBackgroundColor(backgroundColor);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Last Name", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setPadding(10);
            hcell.setBackgroundColor(backgroundColor);
            table.addCell(hcell);

            for (Actor actor : actors) {

                PdfPCell cell;

                cell = new PdfPCell(new Phrase(actor.getId().toString()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(actor.getFirstName()));
                cell.setPadding(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(actor.getLastName()));
                cell.setPadding(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }

            PdfWriter.getInstance(document, out);
            document.open();
            document.add(table);
            document.close();

        } catch (DocumentException ex) {

            logger.error("Error occurred: {0}", ex);
        }

        return new ByteArrayInputStream(out.toByteArray());

	}
	
}
