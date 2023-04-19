package MarketResearchSW;

import java.util.Date;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class ReportGenerator 
{
 
    private String header;
    private String data;
    private String footer;
     
    public String getHeader() 
    {
      return header;
    }
    public void setHeader(String header) 
    {
      System.out.println("Setting report header");
      this.header = header;
    }
    public String getData() 
    {
      return data;
    }
    public void setData(String data) 
    {
      System.out.println("Setting report data");
      this.data = data;
    }
    public String getFooter() 
    {
      return footer;
    }
    public void setFooter(String footer) 
    {
      System.out.println("Setting report footer");
      this.footer = footer;
    }
}

enum ReportType 
{
    PDF, 
    HTML
}
  
class ReportWriter 
{
     
    public void writeHtmlReport(ReportGenerator report, String location) 
    {
      System.out.println("HTML Report written");
      //System.out.println(report.getHeader());
      //System.out.println(report.getData());
      //System.out.println(report.getFooter());

      //put it all in a HTML file and download
      File file = new File("output.html");
        
        try 
        {
            // Create a new PrintWriter object
            PrintWriter writer = new PrintWriter(new FileWriter(file));
            
            // Write data to the HTML file
            writer.println("<html>");
            writer.println("<head><title>Report</title></head>");
            writer.println("<body>");
            writer.println("<h3>"+ report.getHeader() + "</h3>");
            writer.println("<h5>"+ report.getData() + "</h5>");
            writer.println("<h3>"+ report.getFooter() + "</h3>");
            writer.println("</body>");
            writer.println("</html>");
            
            // Close the PrintWriter
            writer.close();
            
            System.out.println("HTML file created successfully.");
        } 
        catch (IOException e) 
        {
          System.out.println("Error");
        }

    }
     
    public void writePdfReport(ReportGenerator report, String location) 
    {
      System.out.println("Pdf Report written");
      //System.out.println(report.getHeader());
      //System.out.println(report.getData());
      //System.out.println(report.getFooter());
      try 
        {
            // Create a PDF document object
            Document document = new Document();
            // Create a PDF writer to write data to the PDF document
            PdfWriter.getInstance(document, new FileOutputStream("output.pdf"));
            // Open the PDF document
            document.open();
            // Write data to the PDF document
            document.add(new Paragraph(report.getHeader()));
            document.add(new Paragraph(report.getData()));
            document.add(new Paragraph(report.getFooter()));
            // Close the PDF document
            document.close();

        } 
        catch (Exception e) 
        {
            System.out.println("Error");
        }
    }
}
  
   
class ReportGeneratorFacade 
{
    public static void generateReport(ReportType type, String location, Product p) //throws Exception 
    {
      if(type == null) 
      {
        System.out.println("File type not specified");
        //throw new Exception();
      }

      //Create report
      ReportGenerator report = new ReportGenerator();
 
      report.setHeader(p.name + " Report");
      report.setFooter("Generated for " + p.company + " at time " + (new Date().toString()));
       
      //Get data from dataSource and set to String object
       
      String data = generateReportData(p.pID);
      report.setData(data);
       
      //Write report
      ReportWriter writer = new ReportWriter();
      switch(type) 
      {
        case HTML:
          writer.writeHtmlReport(report, location);
          break;
           
        case PDF:
          writer.writePdfReport(report, location);
          break;
      }
    }

    static String generateReportData(String productID)
    {
        //connect to database and extract out the reviews for given id
        //last 5 reviews
        //# of 5, 4, 3...star reviews
        //best reviews
        //worst reviews. 
        //Append each line with \n for breaks
        return "Data";
    }
  }