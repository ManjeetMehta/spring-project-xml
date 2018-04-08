package com.mehta.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.FilenameUtils;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFCreationServiceImpl {

	public static void main(String[] args) throws FileNotFoundException {

		String imageSource = "/home/satyaprakash/source/";
		String pdfSource = "/home/satyaprakash/destination/";
		String pdfDestination = "/home/satyaprakash/";

		File folder = new File(imageSource);
		File[] listOfFiles = folder.listFiles();
		
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				PDFCreationServiceImpl.imageToPdf(folder.getAbsolutePath() + "/" + listOfFiles[i].getName(), pdfSource
						+ i + ".pdf");
				System.out.println("File " + listOfFiles[i].getName());
			}
		}

		File destFolder = new File(pdfSource);
		File[] listOfDestFiles = destFolder.listFiles();

		List<InputStream> inputStreamPdfList = new ArrayList<InputStream>();
		for (int i = 0; i < listOfDestFiles.length; i++) {
			if (listOfDestFiles[i].isFile()) {
				inputStreamPdfList.add(new FileInputStream(pdfSource
						+ FilenameUtils.removeExtension(listOfDestFiles[i].getName()) + ".pdf"));
			}
		}

		OutputStream output = new FileOutputStream(pdfDestination + "merge.pdf");
		PDFCreationServiceImpl.concatPDFs(inputStreamPdfList, output, true);
	}

	public static void imageToPdf(String input, String output) {
		Document document = new Document();
		try {
			FileOutputStream fos = new FileOutputStream(output);
			PdfWriter writer = PdfWriter.getInstance(document, fos);
			writer.open();
			document.open();

			Image img = Image.getInstance(input);
			Rectangle pageSize = new Rectangle(img.getWidth(), img.getHeight());
			document.setPageSize(pageSize);
			document.setMargins(10, 10, 10, 10);
			document.newPage();
			document.add(img);
			document.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void concatPDFs(List<InputStream> streamOfPDFFiles, OutputStream outputStream, boolean paginate) {

		Document document = new Document();
		try {
			List<InputStream> pdfs = streamOfPDFFiles;
			List<PdfReader> readers = new ArrayList<PdfReader>();
			int totalPages = 0;
			Iterator<InputStream> iteratorPDFs = pdfs.iterator();

			// Create Readers for the pdfs.
			while (iteratorPDFs.hasNext()) {
				InputStream pdf = iteratorPDFs.next();
				PdfReader pdfReader = new PdfReader(pdf);
				readers.add(pdfReader);
				totalPages += pdfReader.getNumberOfPages();
			}

			// Create a writer for the outputstream
			PdfWriter writer = PdfWriter.getInstance(document, outputStream);

			document.open();
			BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			PdfContentByte cb = writer.getDirectContentUnder(); // Holds the PDF

			// data

			PdfImportedPage page;
			int currentPageNumber = 0;
			int pageOfCurrentReaderPDF = 0;
			Iterator<PdfReader> iteratorPDFReader = readers.iterator();

			// Loop through the PDF files and add to the output.
			while (iteratorPDFReader.hasNext()) {
				PdfReader pdfReader = iteratorPDFReader.next();

				// Create a new page in the target for each source page.
				while (pageOfCurrentReaderPDF < pdfReader.getNumberOfPages()) {

					pageOfCurrentReaderPDF++;
					currentPageNumber++;

					page = writer.getImportedPage(pdfReader, pageOfCurrentReaderPDF);
					Rectangle pageSize = page.getBoundingBox();
					document.setPageSize(pageSize);
					document.setMargins(10, 10, 10, 10);
					document.newPage();
					cb.addTemplate(page, 0, 0);

					// Code for pagination.
					if (paginate) {
						cb.beginText();
						cb.setFontAndSize(bf, 9);
						cb.showTextAligned(PdfContentByte.ALIGN_CENTER, "" + currentPageNumber + " of " + totalPages,
								100, 10, 0);
						cb.endText();
					}
				}
				pageOfCurrentReaderPDF = 0;
			}
			outputStream.flush();
			document.close();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (document.isOpen())
				document.close();
			try {
				if (outputStream != null)
					outputStream.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	}
}
