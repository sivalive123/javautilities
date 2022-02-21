package Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.apache.pdfbox.multipdf.PDFMergerUtility;

public class DownloadPDF {

    public static void downloadPDF(String pdfname, String pdfurl) throws IOException {
        URL url = new URL(pdfurl);
        InputStream in = url.openStream();
        FileOutputStream fos = new FileOutputStream(new File("/Users/siva-7333/Desktop/" + pdfname + ".pdf"));
        int length = -1;
        byte[] buffer = new byte[1024];// buffer for portion of data from connection
        while ((length = in.read(buffer)) > -1) {
            fos.write(buffer, 0, length);
        }
        fos.close();
        in.close();
    }

    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<String>();

        downloadPDF("pdfname", "pdfurl");

    }
}
