package com.mehta.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.util.Date;

import org.apache.commons.lang.StringEscapeUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfGen {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

		try {
			// Inserting Image in PDF
			Image image = Image.getInstance("/home/satyaprakash/pdf work/testpdf.jpg");
			image.scaleAbsolute(50f, 60f);// image width,height

			// Inserting Table in PDF
			PdfPTable table = new PdfPTable(3);
			PdfPCell cell = new PdfPCell(new Paragraph("www.google.com"));
			cell.setColspan(3);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setPadding(10.0f);
			cell.setBackgroundColor(new BaseColor(140, 221, 8));

			table.addCell(cell);

			table.addCell("Name");
			table.addCell("Address");
			table.addCell("Country");
			table.addCell("Java4s");
			table.addCell("NC");
			table.addCell("United States");
			table.setSpacingBefore(30.0f); // Space Before table starts, like
											// margin-top in CSS
			table.setSpacingAfter(30.0f); // Space After table starts, like
											// margin-Bottom in CSS

			// Inserting List in PDF
			List list = new List(true, 30);
			list.add(new ListItem("SATYA PRAKASH"));
			list.add(new ListItem("CHANDAN KUMAR"));
			list.add(new ListItem("RAVI KUMAR"));
			list.add(new ListItem("Chandrakant Renake"));

			// Text formating in PDF
			Chunk chunk = new Chunk("www.google.com");
			// chunk.setUnderline(+1f, -2f);// 1st co-ordinate is for line
			// width,2nd is space between
			chunk.setHorizontalScaling(2f);
			chunk.setBackground(new BaseColor(192, 192, 192));

			FileOutputStream file = new FileOutputStream(new File("/home/satyaprakash/pdf work/output.pdf"));
			Document document = new Document();
			PdfWriter writer = PdfWriter.getInstance(document, file);

			// Now Insert Every Thing Into PDF Document
			document.open();// PDF document opened........
			document.add(image);
			document.add(Chunk.NEWLINE);
			document.add(new Paragraph("Test doc"));
			document.add(new Paragraph("Document Generated On - " + new Date().toString()));
			document.add(table);
			document.add(Chunk.NEWLINE);
			document.add(chunk);
			document.add(Chunk.NEWLINE);
			document.add(list);
			document.add(Chunk.NEWLINE);

			document.newPage(); // Opened new page ------JSON Printing
			document.add(new Paragraph("Content on this page from Json"));
			HTMLWorker htmlWorker = new HTMLWorker(document);
			htmlWorker.parse(new StringReader("<b>" + JavaToJson.convertJavaToJson() + "</b>"));

			document.newPage();// Opened new page ------HTML Printing
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(new FileReader("/home/satyaprakash/pdf work/google.html"));
			try {

				String line = br.readLine();
				while (line != null) {
					sb.append(line);
					sb.append(System.lineSeparator());
					line = br.readLine();
				}
			} finally {
				br.close();
			}
			StringEscapeUtils escapeUtils = new StringEscapeUtils();
			String str = escapeUtils.escapeHtml(sb.toString());
			System.out.println(str);

			document.add(new Paragraph("Content on this page from Html Page"));
			htmlWorker.parse(new StringReader(str));
			document.close();
			file.close();
			System.out.println("Pdf created successfully..");
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

}

class JavaToJson {
	static public String convertJavaToJson() {
		Student student = new Student();
		student.setId(1);
		student.setFirstName("Ankush");
		student.setLastName("thakur");
		student.setGender("male");
		Gson gson = new Gson();
		return gson.toJson(student);
	}

}

class Student implements Serializable {

	private int id;
	private String firstName;
	private String lastName;
	private String gender;
	private String city;

	Student() {
	}

	public Student(int id, String firstName, String lastName, String gender, String city) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
