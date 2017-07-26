package com.reachuson.app.pdb1;

import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;
import java.util.UUID;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Supplier extends AppCompatActivity {
    private String count;
    private EditText Brand,prod1,qty1,mrp1,price1,mon1,year1;
    private FloatingActionButton fab;
    private RelativeLayout rl1,rl2,rl3,rl11;
    private Button save;
    private String userID;

    private FirebaseAuth mauth;
    private FirebaseDatabase mdb;
    private DatabaseReference mref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier);

        mauth = FirebaseAuth.getInstance();
        mdb = FirebaseDatabase.getInstance();
        FirebaseUser user = mauth.getCurrentUser();
        userID = user.getUid();


        rl1 = (RelativeLayout)findViewById(R.id.rl1);
        rl2 = (RelativeLayout)findViewById(R.id.rl2);
        rl3 = (RelativeLayout)findViewById(R.id.rl3);
        rl11 = (RelativeLayout)findViewById(R.id.rl11);
        qty1 = (EditText)findViewById(R.id.editText10);
        mrp1 = (EditText)findViewById(R.id.editText11);
        price1 = (EditText)findViewById(R.id.editText12);
        Brand = (EditText)findViewById(R.id.editText5);
        prod1 = (EditText)findViewById(R.id.editText3);
        save = (Button) findViewById(R.id.button3);
        mon1 = (EditText)findViewById(R.id.editText13);
        year1 = (EditText)findViewById(R.id.editText6);


        rl11.setVisibility(View.GONE);

        fab = (FloatingActionButton)findViewById(R.id.floatingActionButton2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fab.setVisibility(View.GONE);
                rl11.setVisibility(View.VISIBLE);

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String brand = Brand.getText().toString();
                String prod = prod1.getText().toString();
                String  qty = qty1.getText().toString();
                String  mrp = mrp1.getText().toString();
                String  price = price1.getText().toString();
                String mon = mon1.getText().toString();
                String year = year1.getText().toString();


                medicine medi = new medicine();
                medi.setqty(qty);
                medi.setName(prod);
                medi.setBrand(brand);
                medi.setMrp(mrp);
                medi.setprice(price);
                medi.setmon(mon);
                medi.setyear(year);


                String key = UUID.randomUUID().toString();
                mdb.getReference(userID).child("medicine"+key).setValue(medi);
                Toast.makeText(Supplier.this, ""+medi, Toast.LENGTH_SHORT).show();



            }
        });
    }
}
