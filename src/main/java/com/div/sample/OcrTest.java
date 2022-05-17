package com.div.sample;

import java.io.File;

import org.apache.log4j.Logger;

import com.innovatrics.mrz.MrzParseException;
import com.innovatrics.mrz.MrzParser;
import com.innovatrics.mrz.MrzRecord;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;



public class OcrTest {
	static final Logger logger = Logger.getLogger(Stream.class);
	public static void main(String[] args) {
		Tesseract tesseract = new Tesseract(); 
        try { 
  
            tesseract.setDatapath("D:/OCR-Images/"); 
  
            String text = tesseract.doOCR(new File("D:/OCR-Images/img6.jpg")); 
            logger.info("REST {}"+text); 
            final MrzRecord record =   MrzParser.parse(text);
            logger.info("DATA = "+record); 
        } 
        catch (TesseractException e) { 
        	logger.error(e); 
        } 
        catch (MrzParseException e) { 
        	logger.error(e); 
        } 

	}

   
}