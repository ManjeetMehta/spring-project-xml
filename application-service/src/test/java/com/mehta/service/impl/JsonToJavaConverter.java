package com.mehta.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;




public class JsonToJavaConverter {

    
	private static final Logger logger = LoggerFactory.getLogger(JsonToJavaConverter.class);
	
	
	 
    public static void main(String args[]) throws JsonParseException
                                                , JsonMappingException, IOException{
    		BasicConfigurator.configure();
            JsonToJavaConverter converter = new JsonToJavaConverter();
            
            String json = "{\n" +
            "    \"name\": \"ABC\",\n" +
            "    \"surname\": \"XYZ\",\n" +
            "    \"phone\": 98327346}";
          
            //converting JSON String to Java object
            converter.fromJson(json);
            
          
    }
  
  
    public Object fromJson(String json) throws JsonParseException
                                               , JsonMappingException, IOException{
            User obj = new ObjectMapper().readValue(json, User.class);
            logger.info("Java Object created from JSON String ");
            logger.info("JSON String : " + json);
            logger.info("Java Object : " + obj);
            Document document = new Document();
            try
      	   {
      	       PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("/home/satyaprakash/pdf work/JsonTOJava.pdf"));
      	       document.open();

      	       PdfPTable table = new PdfPTable(3); // 3 columns.
      	       table.setWidthPercentage(100); //Width 100%
      	       table.setSpacingBefore(10f); //Space before table
      	       table.setSpacingAfter(10f); //Space after table

      	       //Set Column widths
      	       float[] columnWidths = {1f,1f,1f};
      	       
      	       table.setWidths(columnWidths);
      	       
      	       
      			       PdfPCell cell1 = new PdfPCell(new Paragraph(obj.getName()));
      			       cell1.setBorderColor(BaseColor.BLUE);
      			       cell1.setPaddingLeft(10);
      			       cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
      			       cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
      	
      			       PdfPCell cell2 = new PdfPCell(new Paragraph(obj.getSurname()));
      			       cell2.setBorderColor(BaseColor.BLUE);
      			       cell2.setPaddingLeft(10);
      			       cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
      			       cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
      			       
      			       System.out.println(obj.getPhone());
      			      PdfPCell cell3 = new PdfPCell(new Paragraph(obj.getPhone().toString()));
      			      
      			      			
      			      
     			       cell3.setBorderColor(BaseColor.BLUE);
     			       cell3.setPaddingLeft(10);
     			       cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
     			       cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
      	
      			       table.addCell(cell1);
      			       table.addCell(cell2);
      			       table.addCell(cell3);
      	
      			      
      	   
      	       document.add(table);
      	       document.close();
      	       writer.close();
      	   } 
          catch (DocumentException e){
             e.printStackTrace();
          } 
            return obj;
            
    
    }
    
    public static class User{
            private String name;
            private String surname;
            private Long phone;
          
            public String getName() {return name;}
            public void setName(String name) {this.name = name;}

            public String getSurname() {return surname;}
            public void setSurname(String surname) {this.surname = surname;}

            public Long getPhone() {return phone;}
            public void setPhone(Long phone) {this.phone = phone;}

            @Override
            public String toString() {
                    return "User [name=" + name + ", surname=" + surname + ", phone="
                                    + phone + "]";
            }
          
     
}
}	 