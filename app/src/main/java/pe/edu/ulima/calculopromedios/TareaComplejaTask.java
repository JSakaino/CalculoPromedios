package pe.edu.ulima.calculopromedios;

import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

/**
 * Created by sodm on 23/09/2016.
 */
public class TareaComplejaTask extends AsyncTask<List<String[]>,Integer,String> {

    @Override
    protected String doInBackground(List<String[]>... lists) {
        double total = 0.0;
        for (List<String[]> strings : lists){


            Log.i("MainActivity", "Longitud:" + lists.length);

            for (String[] strings : lists){
                total += sigmoid(Double.parseDouble(res[3]));
                //total += Double.parseDouble(res[3]);
            }

            double promedio = total / lists.length;

            tviResultado.setText(String.valueOf(promedio));

        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }
    private double sigmoid(double value){
        return 1.0 / (1.0 + Math.exp(-1 * value));
    }

}
