package com.qr_storeage.QR_StoragePt2.Models.Barcodes.Barcode128;

import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Barcode128_pdf {

    public static String PdfFolderPath = "C:\\Users\\kille\\Documents\\careerdevs\\2021_12\\QR_StoragePt2\\QRCodes\\PDF\\";

    public static void createBarCode128(String fileName) {
        try {
            Code128Bean bean = new Code128Bean();
            final int dpi = 160;

            bean.setModuleWidth((UnitConv.in2mm(2.8f / dpi)));

            bean.doQuietZone(false);

            File outputFile = new File(PdfFolderPath + fileName + ".PDF");

            FileOutputStream out = new FileOutputStream(outputFile);

            BitmapCanvasProvider canvas = new BitmapCanvasProvider(
                    out, "image/x-png", dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0
            );

            bean.generateBarcode(canvas, fileName);

            canvas.finish();

            System.out.println("Barcode for " + fileName + " successfully created.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        createBarCode128("Path test");
//    }
}
