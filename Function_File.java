import java.awt.FileDialog;
import java.awt.print.PrinterJob;
import java.awt.print.PageFormat;
import java.io.*;
public class Function_File
{
  GUI gui;
  String fileName,fileAddress;
  public Function_File(GUI gui)
  {
    this.gui=gui;
  }
  public void newFile()
  {
    gui.textArea.setText("");
    gui.window.setTitle("New Text Document");
    fileName=null;
    fileAddress=null;
  }
  public void open()
  {
    FileDialog fd=new FileDialog(gui.window,"Open",FileDialog.LOAD);
    fd.setVisible(true);
    
    if(fd.getFile()!=null)
    { 
      fileName=fd.getFile();
      fileAddress=fd.getDirectory();
      gui.window.setTitle(fileName);
    }
    try
    {
      BufferedReader br=new BufferedReader(new FileReader(fileAddress + fileName));
      gui.textArea.setText("");
      String line=null;
      while((line=br.readLine())!=null)
          gui.textArea.append(line + "\n");
      br.close();   
    }
    catch(Exception e)
    {
      System.out.println("FILE NOT OPENED");
    }
  }
  public void save()
  {
    if(fileName==null)
    {
      saveAs();
    }
    else
    {
      try
      { 
         FileWriter fw=new FileWriter(fileAddress + fileName);
         fw.write(gui.textArea.getText());
         gui.window.setTitle(fileName);
         fw.close();
      }
      catch(Exception e)
      { 
       System.out.println("SOMETHING WRONG");
      }
    }
  }
  public void saveAs()
  {
    FileDialog fd=new FileDialog(gui.window,"SaveAs",FileDialog.SAVE);
    fd.setVisible(true);
    if(fd.getFile()!=null)
    {
      fileName=fd.getFile();
      fileAddress=fd.getDirectory();
      gui.window.setTitle(fileName);
    }
    try
    {
      FileWriter fw=new FileWriter(fileAddress + fileName);
      fw.write(gui.textArea.getText());
      fw.close();
    }
    catch(Exception e)
    { 
      System.out.println("SOMETHING WRONG");
    }
  }
  public void pageSetup()
  {
    PrinterJob pj = PrinterJob.getPrinterJob();
    PageFormat pf = pj.pageDialog(pj.defaultPage());
  }
  public void print()
  {
    PrinterJob pj = PrinterJob.getPrinterJob();
    if (pj.printDialog())
    {
      try {pj.print();}
       catch (Exception e) 
       {
            System.out.println("NO PRINTER AVAILABLE");
       }
    }  
  }
  public void exit()
  {
    System.exit(0);
  }
}