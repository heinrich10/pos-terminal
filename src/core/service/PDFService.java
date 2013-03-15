/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core.service;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author Heinrich
 */
public class PDFService {
    
    public void printPDF(){
        PDDocument doc = null;
        try {
            
            String message = "";
            String file = "";
            doc = new PDDocument();

            PDPage page = new PDPage();
            doc.addPage( page );
            PDFont font = PDType1Font.HELVETICA_BOLD;

            PDPageContentStream contentStream = new PDPageContentStream(doc, page);
            contentStream.beginText();
            contentStream.setFont( font, 12 );
            contentStream.appendRawCommands(12 + " TL\n");
            contentStream.moveTextPositionByAmount( 100, 700 );
            contentStream.drawString( message );
            contentStream.appendRawCommands("T*\n");
            contentStream.drawString( message + "test" );
            contentStream.appendRawCommands("T*\n");
            contentStream.appendRawCommands("T*\n");
            contentStream.appendRawCommands("T*\n");
            contentStream.drawString("this is the end");
            contentStream.endText();
            contentStream.close();
            doc.save( file );

            if( doc != null )
            {
                doc.close();
            }
        } catch (COSVisitorException | IOException ex) {
            Logger.getLogger(PDFService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
        
}
