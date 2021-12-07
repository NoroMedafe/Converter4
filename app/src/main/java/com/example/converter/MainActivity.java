package com.example.converter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    CheckBox[] chk;
    EditText[] num;
    EditText[] price;
    EditText result;
    EditText costAp;
    EditText costBl;
    EditText costStr;
    EditText costPo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chk = new CheckBox[4];
        num = new EditText[4];
        price  = new EditText[4];
        price[0] = findViewById(R.id.CostApple);
        price[1] = findViewById(R.id.CostBlue);
        price[2] = findViewById(R.id.CostStraw);
        price[3] = findViewById(R.id.CostPotat);

        num[0]= findViewById(R.id.QuantApple);
        num[1]= findViewById(R.id.QuanBlue);
        num[2]= findViewById(R.id.QuanStraw);
        num[3]= findViewById(R.id.QuanPotat);
        chk[0] = findViewById(R.id.Capple);
        chk[1] = findViewById(R.id.Cblue);
        chk[2] = findViewById(R.id.Cstraw);
        chk[3] = findViewById(R.id.Cpotat);

    }

    public float tryParseFloat(String value)
    {
        try {
            return Float.parseFloat(value);
        } catch (NumberFormatException e){
            return 0;
        }
    }
    public Integer tryParseInt(String value)
    {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e){
            return 0;
        }
    }
    public void message()
    {
        AlertDialog.Builder bld = new AlertDialog.Builder(this);
        AlertDialog dlg = bld.create();
        dlg.setTitle("Аккуратно!");
        dlg.setMessage("Вы забыли что-то выбрать или ввести или ввели некорректно!");
        dlg.show();
    }
    public void button_click(View v)
    {
        boolean bruh = false;
        int k = 0;
        int q;
        float a;
        float sum = 0.0f;
        for (int i = 0; i < chk.length; i++)
        {
            if (chk[i].isChecked()==true)
            {
                k+=1;
            }
        }
        if (k == 0)
        {
            message();
        }
        else {
            for (int i = 0; i < chk.length; i++) {
                if (chk[i].isChecked()) {

                    a = tryParseFloat(price[i].getText().toString());
                    if (a == 0) {
                        message();
                        bruh = true;
                        break;
                    }
                        q = tryParseInt(num[i].getText().toString());
                    if (q == 0)
                    {
                        bruh = true;
                        break;
                    }
                        float val = a * q;
                        sum += val;
                }
            }
            if (bruh ==true)
            {message();}
            else {
                String rel = String.valueOf(sum);
                AlertDialog.Builder bld = new AlertDialog.Builder(this);
                AlertDialog dlg = bld.create();
                dlg.setTitle("Цена покупок");
                dlg.setMessage("С вас:" + rel);
                dlg.setIcon(R.drawable.bc86396e81a27996023b2eb3f874fbb3);
                dlg.show();
            }
        }
    }

}