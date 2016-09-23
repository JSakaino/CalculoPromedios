package pe.edu.ulima.calculopromedios;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView tviResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tviResultado = (TextView) findViewById(R.id.tviResultado);
        Button butPromediar = (Button) findViewById(R.id.butPromediar);
        butPromediar.setOnClickListener(new View.OnClickListener() {
            long tiempoInicial = new Date().getTime();
            @Override
            public void onClick(View v) {
                List<String[]> resultado = CSVManager.getInstance().obtenerData(
                        MainActivity.this, "sueldos.csv");

                double total = 0.0;

                Log.i("MainActivity", "Longitud:" + resultado.size());

                for (String[] res : resultado){
                    total += sigmoid(Double.parseDouble(res[3]));
                    //total += Double.parseDouble(res[3]);
                }

                double promedio = total / resultado.size();

                tviResultado.setText(String.valueOf(promedio));
                long tiempoFinal = new Date().getTime();
                Log.i("MainActivity", "tiempo: " + ((tiempoFinal- tiempoInicial)/1000));
            }
        });
    }

    private double sigmoid(double value){
        return 1.0 / (1.0 + Math.exp(-1 * value));
    }
}
