package com.progeto.equaodosegundoeterceirogral; // Pacote correto

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etA, etB, etC, etD;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etA = findViewById(R.id.etA);
        etB = findViewById(R.id.etB);
        etC = findViewById(R.id.etC);
        etD = findViewById(R.id.etD);
        btnCalcular = findViewById(R.id.btnCalcular);
    }

    public void solveSecondDegreeEquation(View view) {
        // Tornar o campo "a" visível
        etA.setVisibility(View.VISIBLE);
        // Tornar o campo "b" visível
        etB.setVisibility(View.VISIBLE);
        // Tornar o campo "c" visível
        etC.setVisibility(View.VISIBLE);
        // Tornar o campo "d" invisível
        etD.setVisibility(View.GONE);
        // Tornar o botão de calcular visível
        btnCalcular.setVisibility(View.VISIBLE);
    }

    public void solveThirdDegreeEquation(View view) {
        // Tornar o campo "a" visível
        etA.setVisibility(View.VISIBLE);
        // Tornar o campo "b" visível
        etB.setVisibility(View.VISIBLE);
        // Tornar o campo "c" visível
        etC.setVisibility(View.VISIBLE);
        // Tornar o campo "d" visível
        etD.setVisibility(View.VISIBLE);
        // Tornar o botão de calcular visível
        btnCalcular.setVisibility(View.VISIBLE);
    }

    public void calcular(View view) {
        if (areInputsValid()) {
            if (etD.getVisibility() == View.GONE) {
                // Equação de segundo grau
                double a = Double.parseDouble(etA.getText().toString());
                double b = Double.parseDouble(etB.getText().toString());
                double c = Double.parseDouble(etC.getText().toString());

                double delta = b * b - 4 * a * c;

                if (delta > 0) {
                    double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                    double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                    Toast.makeText(this, "As raízes da equação de segundo grau são: " + x1 + " e " + x2, Toast.LENGTH_LONG).show();
                } else if (delta == 0) {
                    double x = -b / (2 * a);
                    Toast.makeText(this, "A raiz dupla da equação de segundo grau é: " + x, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "A equação de segundo grau não possui raízes reais.", Toast.LENGTH_LONG).show();
                }
            } else {
                // Equação de terceiro grau
                double a = Double.parseDouble(etA.getText().toString());
                double b = Double.parseDouble(etB.getText().toString());
                double c = Double.parseDouble(etC.getText().toString());
                double d = Double.parseDouble(etD.getText().toString());

                double[] coeficientes = {a, b, c, d};
                double[] raizes = new double[3];

                try {
                    for (int i = 0; i < 3; i++) {
                        raizes[i] = Math.pow(coeficientes[i], 1.0 / 3.0);
                    }
                    Toast.makeText(this, "As raízes da equação de terceiro grau são: " + raizes[0] + ", " + raizes[1] + " e " + raizes[2], Toast.LENGTH_LONG).show();
                } catch (ArithmeticException e) {
                    Toast.makeText(this, "A equação de terceiro grau não possui raízes reais.", Toast.LENGTH_LONG).show();
                }
            }
        } else {
            Toast.makeText(this, "Preencha todos os campos para resolver a equação.", Toast.LENGTH_LONG).show();
        }
    }

    private boolean areInputsValid() {
        if (etD.getVisibility() == View.GONE) {
            // Para a equação de segundo grau
            return !TextUtils.isEmpty(etA.getText().toString())
                    && !TextUtils.isEmpty(etB.getText().toString())
                    && !TextUtils.isEmpty(etC.getText().toString());
        } else {
            // Para a equação de terceiro grau
            return !TextUtils.isEmpty(etA.getText().toString())
                    && !TextUtils.isEmpty(etB.getText().toString())
                    && !TextUtils.isEmpty(etC.getText().toString())
                    && !TextUtils.isEmpty(etD.getText().toString());
        }
    }

}
