package org.hihan.girinoscope.ui;

import org.hihan.girinoscope.comm.Girino;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataFile {
    public static void write(File file, Girino.PrescalerInfo prescalerInfo, byte[] data) throws IOException {
        FileWriter writer = new FileWriter(file);
        writer.write(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()) + "\n");
        writer.write(prescalerInfo.description + "\n");
        for(int i=0; i<data.length; i++){
            writer.write(Integer.toString(data[i] & 0xFF));
            writer.write('\n');
        }
        writer.flush();
    }
}
