/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

//archivos
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
//librerias ajenas a itext
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import sun.tools.jar.Main;
/**
 * @web http://jc-mouse.blogspot.com/
 * @author Mouse
 */
public class ArchPdf {

    private File ruta_destino;

    public ArchPdf(){
        ruta_destino=null;
    }

    /*metodo que hace uso de la clase itext para manipular archivos PDF*/
   public void crear_PDF(/*Recibo recibo1, Recibo recibo2*/Historia_Clinica objh){
        //abre ventana de dialogo "guardar"
        //Colocar_Destino();
        //si destino es diferente de null
        
            try {
                // se crea instancia del documento
                Document mipdf = new Document();
                // se establece una instancia a un documento pdf
                PdfWriter pw = PdfWriter.getInstance(mipdf, new FileOutputStream("src/PDF/"+objh.getPaciente().getId()+ ".pdf"));
                mipdf.open();// se abre el documento
                mipdf.addTitle("Recibo Entrada Parqueadero"); // se añade el titulo
                /*mipdf.addAuthor(a); // se añade el autor del documento
                mipdf.addSubject(s); //se añade el asunto del documento
                mipdf.addKeywords(k); //Se agregan palabras claves*/
                mipdf.add(new Paragraph("HISTORIA CLINICA \n\n"));
                mipdf.add(new Paragraph(objh.toString()+"\n"));
                mipdf.add(new Paragraph("------------------------------------------------------------------------------------------------"
                        + "-------------------------------\n"));
                mipdf.add(new Paragraph("\n"+"Total a pagar: "+objh.getServicio().tarifaServicio(objh.getPaciente())+"\n"));
                mipdf.add(codBar(mipdf, pw, objh.getFecha().toString() +" - "+objh.getPaciente().getId()));
                //mipdf.add(new Paragraph("Parrafo 2 "+m+"\n"));
                // se añade el contendio del PDF
                mipdf.close(); //se cierra el PDF&
                JOptionPane.showMessageDialog(null,"Documento PDF creado");
            } catch (DocumentException ex) {
                Logger.getLogger(Main.class.getName()).log(null,"Error, ", ex.toString());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(null,"Error, ",ex.toString());
            }
        
    }
    /* abre la ventana de dialogo GUARDAR*/
    public void Colocar_Destino(){
       FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo PDF","pdf","PDF");
       JFileChooser fileChooser = new JFileChooser();
       fileChooser.setFileFilter(filter);
       int result = fileChooser.showSaveDialog(null);
       if ( result == JFileChooser.APPROVE_OPTION ){
           this.ruta_destino = fileChooser.getSelectedFile().getAbsoluteFile();
        }
    }

    public File getRuta_destino() {
        return ruta_destino;
    }

    public void setRuta_destino(File ruta_destino) {
        this.ruta_destino = ruta_destino;
    }
    public Image codBar(Document doc, PdfWriter pw, String infoCod)
    {
        PdfContentByte cimg = pw.getDirectContent();
        Barcode128 code128 =new Barcode128();
        code128.setCode(infoCod);
        code128.setCodeType(Barcode128.CODE128);
        code128.setTextAlignment(Element.ALIGN_CENTER);
        Image img=code128.createImageWithBarcode(cimg, BaseColor.BLACK, BaseColor.BLACK);
        img.setAlignment(Element.ALIGN_CENTER);
        return img;
    }
    
}