package com.qr_storeage.QR_StoragePt2.Models.Barcodes.Barcode39;

import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Barcode39 {

    private static String ImgFolderPath = "C:\\Users\\kille\\Documents\\careerdevs\\2021_12\\QR_StoragePt2\\QRCodes\\39\\";


    public static void createBarcode39img(String fileName){
        try {
            Code39Bean bean39 = new Code39Bean();
            final int dpi = 160;

            bean39.setModuleWidth(UnitConv.in2mm(2.8f/dpi));

            bean39.doQuietZone(false);

            File outputFile = new File(ImgFolderPath + fileName + ".JPG");

            FileOutputStream out = new FileOutputStream(outputFile);

            BitmapCanvasProvider canvas = new BitmapCanvasProvider(
                    out, "image/x-png", dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0
            );

            bean39.generateBarcode(canvas, fileName);

            canvas.finish();

            System.out.println("Barcode for " + fileName + " successfully created.");


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createBarcode39img("Test 1");
    }

}
