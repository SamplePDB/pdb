package com.reachuson.app.pdb1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private FirebaseDatabase mdb;
    private DatabaseReference myref;
    private FirebaseUser mUser;
    private FirebaseAuth mauth;
    private String uID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mdb = FirebaseDatabase.getInstance();
        mauth = FirebaseAuth.getInstance();
        FirebaseUser user = mauth.getCurrentUser();
        uID = user.getUid();




    }
    public void supp(View view){

        mdb.getReference(uID).child("type").setValue(1);
        Intent inte = new Intent(MainActivity.this,Reg_sup.class);
        startActivity(inte);
    }
    public void Retailer(View view){
        myref.child("type").setValue("2");
        Intent inte = new Intent(MainActivity.this,Retailer.class);
        startActivity(inte);
    }

}
