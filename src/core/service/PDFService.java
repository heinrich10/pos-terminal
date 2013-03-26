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

    PDDocument doc;
    private int fontSize;
    private int topMargin;
    private PDFont font = PDType1Font.HELVETICA_BOLD;
    private float Y;
    private float fontHeight;

    public PDFService(int fontSize, int topMargin) {
        this.fontSize = fontSize;
        this.topMargin = topMargin;
        try {
            doc = new PDDocument();
        } catch (IOException ex) {
            Logger.getLogger(PDFService.class.getName()).log(Level.SEVERE, null, ex);
        }
        fontHeight = font.getFontDescriptor().getFontBoundingBox().getHeight() / 1000 * fontSize;

    }

    public void printPDF(String saveLocation) {


        try {
            doc.save(saveLocation);
            doc.close();
        } catch (IOException ex) {
            Logger.getLogger(PDFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (COSVisitorException ex) {
            Logger.getLogger(PDFService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setTitle(String title, PDPage page) {
        float X;
        try {
            float titleWidth = font.getStringWidth(title) / 1000 * fontSize;
            X = (page.getMediaBox().getWidth() - titleWidth) / 2;
            Y = (page.getMediaBox().getHeight() - topMargin - fontHeight);

            PDPageContentStream contentStream = new PDPageContentStream(doc, page);

            contentStream.beginText();
            contentStream.setFont(font, fontSize);
            contentStream.moveTextPositionByAmount(X, Y);
            contentStream.drawString(title);
            contentStream.endText();
            contentStream.close();

        } catch (IOException ex) {
            Logger.getLogger(PDFService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addPage(PDPage page) {
        doc.addPage(page);
    }

    public PDPage newPage() {
        PDPage page = new PDPage();
        return page;
    }

    public void addSpace(PDPage page) {
        try {
            PDPageContentStream contentStream = new PDPageContentStream(doc, page, true, true);
            contentStream.beginText();
  
            float X = 100;
            Y -= fontHeight;
            contentStream.moveTextPositionByAmount(X, Y);
            contentStream.drawString(" ");
            contentStream.endText();
            contentStream.close();

        } catch (IOException ex) {
            Logger.getLogger(PDFService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addLine(String message, PDPage page) {
        try {
            PDPageContentStream contentStream = new PDPageContentStream(doc, page, true, true);
            contentStream.beginText();
            contentStream.setFont(font, fontSize);
            float X = 100;
            Y -= fontHeight;
            contentStream.moveTextPositionByAmount(X, Y);
            contentStream.drawString(message);
            contentStream.endText();
            contentStream.close();

        } catch (IOException ex) {
            Logger.getLogger(PDFService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void drawTableColumn(String[] column, PDPage page){
        float nextx = 100;
        float width = 0;
        for(int i = 0; i < column.length; i++){
            try {
                if(i < column.length){
                    width = font.getStringWidth(column[i]) / 1000 * fontSize;
                }
                
                PDPageContentStream contentStream = new PDPageContentStream(doc, page, true, true);
                contentStream.beginText();
                contentStream.moveTextPositionByAmount(nextx, Y);
                contentStream.drawLine(nextx, Y, nextx, Y-fontSize);
                contentStream.endText();
                contentStream.close();
                nextx += width;
                
            } catch (IOException ex) {
                Logger.getLogger(PDFService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    public static void main(String[] args) {
        PDFService pdf = new PDFService(12, 30);
        PDPage page = pdf.newPage();
        pdf.addPage(page);
        pdf.setTitle("Magnum Opus", page);
        pdf.addSpace(page);
        pdf.addLine("Sales report for 3/26/2013", page);
        pdf.addSpace(page);
        String[] test = {"100000000000000000000000000", "100", "100"};
        pdf.drawTableColumn(test, page);
        pdf.printPDF("D://test.pdf");



    }
}
