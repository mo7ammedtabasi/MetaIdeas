package com.mo7ammedtabasi.metaideas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class RestaurantActivity extends AppCompatActivity {

    CheckBox chkPizza,chkBurger,chkChicken,chkSalad,chkPepsi,chkTea,chkCoffee,chkAnise;
    Button btnGetInvoice;
    TextView tvInvoice;
    int invoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        chkPizza=findViewById(R.id.chk_pizza);
        chkBurger=findViewById(R.id.chk_burger);
        chkChicken=findViewById(R.id.chk_chicken);
        chkSalad=findViewById(R.id.chk_salad);
        chkPepsi=findViewById(R.id.chk_pepsi);
        chkTea=findViewById(R.id.chk_tea);
        chkCoffee=findViewById(R.id.chk_coffee);
        chkAnise=findViewById(R.id.chk_anise);

        btnGetInvoice=findViewById(R.id.btn_getInvoice);
        tvInvoice=findViewById(R.id.tv_invoice);

        btnGetInvoice.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                invoice=0;
                StringBuilder totalOrder=new StringBuilder();
                if (chkPizza.isChecked()){
                    invoice+=30;
                    totalOrder.append(chkPizza.getText().toString()).append(",");
                }
                if (chkBurger.isChecked()){
                    invoice+=35;
                    totalOrder.append(chkBurger.getText().toString()).append(",");
                }
                if (chkChicken.isChecked()){
                    invoice+=25;
                    totalOrder.append(chkChicken.getText().toString()).append(",");
                }
                if (chkSalad.isChecked()){
                    invoice+=5;
                    totalOrder.append(chkSalad.getText().toString()).append(",");
                }
                if (chkPepsi.isChecked()){
                    invoice+=6;
                    totalOrder.append(chkPepsi.getText().toString()).append(",");
                }
                if (chkTea.isChecked()){
                    invoice+=3;
                    totalOrder.append(chkTea.getText().toString()).append(",");
                }
                if (chkCoffee.isChecked()){
                    invoice+=12;
                    totalOrder.append(chkCoffee.getText().toString()).append(",");
                }
                if (chkAnise.isChecked()){
                    invoice+=2;
                    totalOrder.append(chkAnise.getText().toString()).append(",");
                }

                tvInvoice.setText("The total order is : "+totalOrder+"\nand your invoice is : "+invoice);
            }
        });
    }
}