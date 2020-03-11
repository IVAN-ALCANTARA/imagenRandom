package mx.edu.tesoem.isc.niaa.imagenrandom;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    ImageView imagen;
    TextView letrero;
    Button btn;

    int i,itemporal=0;
    String l,ltemporal=null;

    MediaPlayer mp;
    Vibrator vibrator;
    int sr = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //asociando atributos, id, layout
        imagen = (ImageView) findViewById(R.id.imageView);
        letrero = (TextView) findViewById(R.id.texto);
        btn = (Button) findViewById(R.id.button);

        mostrarRand();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarRand();
            }
        });
    }

    //mostrar valores de aleatorio
    public void mostrarRand() {
        //randoms();
        sr = ThreadLocalRandom.current().nextInt(0,6);

        i = randArray[sr].getImagen();
        l = randArray[sr].getAleatorio();

        if((i!=itemporal)&&(l!=ltemporal)) {

            imagen.setImageResource(i);
            letrero.setText(l);
            //Reproducir sonidos
            stopPlying();
            mp = MediaPlayer.create(this,randArray[sr].getSonido());
            mp.start();
            //generar patron de vibracion
            vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            Random rand = new Random();
            int n = rand.nextInt(1000);
            long[] pattern = {n, n, n, n};
            vibrator.vibrate(pattern, -1);
            
            itemporal=i;
            ltemporal=l;

        }else{
            mostrarRand();
        }

    }

    aleatorio i1 = new aleatorio(R.drawable.uno,    "imagen 1", R.raw.sound1);
    aleatorio i2 = new aleatorio(R.drawable.dos,    "imagen 2", R.raw.sound2);
    aleatorio i3 = new aleatorio(R.drawable.tres,   "imagen 3", R.raw.sound3);
    aleatorio i4 = new aleatorio(R.drawable.cuatro, "imagen 4", R.raw.sound4);
    aleatorio i5 = new aleatorio(R.drawable.cinco,  "imagen 5", R.raw.sound5);
    aleatorio i6 = new aleatorio(R.drawable.seis,   "imagen 6", R.raw.sound6);
    aleatorio i7 = new aleatorio(R.drawable.siete,  "imagen 7", R.raw.sound7);


    //llenando array
    aleatorio[] randArray = new aleatorio[]{ i1, i2, i3, i4, i5, i6, i7 };

    //metodo para permutar aleatoriamente una lista, utilizando como fuente el vector randArray
    public void randoms(){
        //  Collections.shuffle(Arrays.asList(randArray));
    }


    // METODO PARA DETENER E INICIAR UNA REPRODUCCION
    private void stopPlying(){
        if(mp != null){
            mp.stop();
            mp.release();
            mp = null;
        }
    }
}
