package pe.edu.ulima.calculopromedios;

import android.content.Context;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;


public class CSVManager {
    private static CSVManager singleton;

    public static CSVManager getInstance(){
        if (singleton == null){
            singleton = new CSVManager();
        }
        return singleton;
    }

    private CSVManager(){}

    public List<String[]> obtenerData(Context context, String nombreArchivo){
        String next[] = null;
        List<String[]> list = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new InputStreamReader(context.getAssets().open(nombreArchivo)));
            for(;;) {
                next = reader.readNext();
                if(next != null) {
                    list.add(next);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
