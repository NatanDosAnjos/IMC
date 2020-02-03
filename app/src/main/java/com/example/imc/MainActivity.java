package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.imc.R.id.editTextNome;
import static com.example.imc.R.id.textInputAltura;
import static com.example.imc.R.id.textInputPeso;
import static com.example.imc.R.id.textoImc;

public class MainActivity extends AppCompatActivity {
    private EditText campoPeso;
    private EditText campoAltura;
    private EditText campoNome;
    private TextView textoResultado;
    private TextView imc;
    private Vibrator vibrator;
    private EditText tempo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoPeso          = findViewById(textInputPeso);
        campoAltura        = findViewById(textInputAltura);
        campoNome          = findViewById(editTextNome);
        textoResultado     = findViewById(R.id.textViewResultado);
        imc                = findViewById(textoImc);
        vibrator           = (Vibrator) getSystemService(VIBRATOR_SERVICE);
    }

    //Gera número aleatório e os atribui
    public void numeroAleatorio(View view){
        //Fecha o teclado caso ele esteja aberto ao executar a função
        hideSoftKeyboard();

        EditText textoPeso      = findViewById(textInputPeso);
        EditText textoAltura    = findViewById(textInputAltura);

        imc.setText("");
        textoResultado.setText("");

        //Gerando números aleatórios para os campos Peso e Altura
        int randomNum               = (int) (Math.random()*100);
        textoPeso.setText(String.format("%d", randomNum));

        double randomNumDouble       = Math.random()*2;
        textoAltura.setText(String.format("%.2f", randomNumDouble));
    }

    //Fechar Teclado virtual
    public void hideSoftKeyboard() {
        if(getCurrentFocus()!=null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    /*
    public void vibrar() {
        int tempo2;

        tempo2 = (tempo.getText().toString());

        //Vibra por 200 milisegundos
        vibrator.vibrate(VibrationEffect.createOneShot(tempo2, VibrationEffect.DEFAULT_AMPLITUDE));
    }


    public void pararDeVibrar(View view) {
        vibrator.cancel();
    }
    */

    public void calcular(View view) throws InterruptedException {
        //Fechando teclado virtual
        hideSoftKeyboard();
        imc.setText("");

        double peso     = 0;
        double altura   = 0;

        //Pegando valores dos campos e armazenando em variáveis String

        String textoAltura = campoAltura.getText()
                                        .toString();
        String textoPeso = campoPeso.getText()
                                    .toString();

        //Transformando Strings em ponto flutuante double
        if(textoPeso.length() != 0  && textoAltura.length() != 0) {
            if (!textoAltura.equals(".") && !textoPeso.equals(".")) {
                peso = Double.parseDouble(textoPeso);
                altura = Double.parseDouble(textoAltura);
            }
        }




        Imc pessoa = new Imc();
        pessoa.setPeso(peso);
        pessoa.setAltura(altura);
        textoResultado.setText(pessoa.diagnostico());

        if(pessoa.getImc() != 0) {
            imc.setText(String.format("%.2f", (float) pessoa.getImc()));
        } else {
            //Thread.sleep(800);
            //textoResultado.setText("");
        }
    }
}
