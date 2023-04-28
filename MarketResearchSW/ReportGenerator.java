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
import java.sql.*;

class ReportGenerator {

  private String header;
  private String data;
  private String footer;

  public String getHeader() {
    return header;
  }

  public void setHeader(String header) {
    // System.out.println("Setting report header");
    this.header = header;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    // System.out.println("Setting report data");
    this.data = data;
  }

  public String getFooter() {
    return footer;
  }

  public void setFooter(String footer) {
    // System.out.println("Setting report footer");
    this.footer = footer;
  }
}

enum ReportType {
  PDF,
  HTML
}

class ReportWriter {

  public void writeHtmlReport(ReportGenerator report) {
    System.out.println("HTML Report written");
    // System.out.println(report.getHeader());
    // System.out.println(report.getData());
    // System.out.println(report.getFooter());

    // put it all in a HTML file and download
    String tmploc;
    File file;
    try {
      tmploc = System.getenv("ReportOutputLocation") + "\\";
      // System.out.println(System.getenv("ReportOutputLocation"));
      file = new File(tmploc + "output.html");
    } catch (Exception e) {
      System.out.println("Path NOT FOUND...Storing in CWD");
      file = new File("output.html");
    }
    try {
      // Create a new PrintWriter object
      PrintWriter writer = new PrintWriter(new FileWriter(file));

      // Write data to the HTML file
      writer.println("<html>");
      writer.println("<head><title>Report</title></head>");
      writer.println("<body>");
      writer.println("<h3>" + report.getHeader() + "</h3>");
      writer.println("<h1>" + report.getData() + "</h1>");
      writer.println("<h3>" + report.getFooter() + "</h3>");
      writer.println("</body>");
      writer.println("</html>");

      // Close the PrintWriter
      writer.close();

      System.out.println("HTML file created successfully.");
    } catch (IOException e) {
      System.out.println("ERROR");

    }

  }

  public void writePdfReport(ReportGenerator report) {
    // System.out.println("Pdf Report written");
    // System.out.println(report.getHeader());
    // System.out.println(report.getData());
    // System.out.println(report.getFooter());
    String tmploc;
    String file;
    tmploc = System.getenv("ReportOutputLocation") + "\\";
    // System.out.println(System.getenv("ReportOutputLocation"));
    file = tmploc + "output.pdf";

    try 
    {
      // Create a PDF document object
      Document document = new Document();
      // Create a PDF writer to write data to the PDF document
      // String tmploc = System.getenv("ReportOutputLocation") + "\\";
      // System.out.println(System.getenv("ReportOutputLocation"));
      //String file = tmploc + "output.pdf";
      PdfWriter.getInstance(document, new FileOutputStream(file));
      // Open the PDF document
      document.open();
      // Write data to the PDF document
      document.add(new Paragraph(report.getHeader()));
      document.add(new Paragraph(report.getData()));
      document.add(new Paragraph(report.getFooter()));
      // Close the PDF document
      document.close();

    } catch (Exception e) {
        try {
          // System.out.println("sgrh");
        Document document = new Document();
        // Create a PDF writer to write data to the PDF document
        // String tmploc = System.getenv("ReportOutputLocation") + "\\";
        // System.out.println(System.getenv("ReportOutputLocation"));
        //String file = tmploc + "output.pdf";
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
        catch(Exception p)
        {
          System.out.println("Error");
        }
    }
  }
}

class ReportGeneratorFacade {
  public static void generateReport(ReportType type, Product p) // throws Exception
  {
    if (type == null) {
      System.out.println("File type not specified");
      return;
      // throw new Exception();
    }
    if (p == null) {
      System.out.println("Product not found");
      return;
    }

    // Create report
    ReportGenerator report = new ReportGenerator();

    report.setHeader(p.name + " Report");
    report.setFooter("Generated at time " + (new Date().toString()));

    // Get data from dataSource and set to String object

    String data = generateReportData(p.pID);
    report.setData(data);

    // Write report
    ReportWriter writer = new ReportWriter();
    switch (type) {
      case HTML:
        writer.writeHtmlReport(report);
        break;

      case PDF:
        writer.writePdfReport(report);
        break;
    }
    System.out.println("Report has been generated");
  }

  static String generateReportData(String productID) {
    ResultSet resultSet = null;
    // retrieve all related products from db
    Connection connection = null;

    String data = "\n";

    try {
      // below two lines are used for connectivity.
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/marketresearchsw",
          "root", "");

      Statement statement;
      statement = connection.createStatement();

      String command = "select * from review where pid = \"" + productID + "\";";

      resultSet = statement.executeQuery(command);

      while (resultSet.next()) {
        String review = resultSet.getString("review");
        int rating = resultSet.getInt("rating");

        data = data + rating + "\t " + review + "\n";

      }

      statement.close();
      connection.close();

    } catch (Exception e) {
      System.out.println("There was an issue while generating data for report");
    }

    // System.out.println(data);
    return data;
  }
}