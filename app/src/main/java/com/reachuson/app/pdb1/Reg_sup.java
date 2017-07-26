package com.reachuson.app.pdb1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Reg_sup extends AppCompatActivity {
    private EditText Inst,Owner,pin;
    private Button save;
    private String userID;

    //Firebase Stuff
    private FirebaseAuth mauth;
    private FirebaseDatabase mdb;
    private DatabaseReference myref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_sup);
        Inst = (EditText)findViewById(R.id.editText7);
        Owner = (EditText)findViewById(R.id.editText8);
        pin = (EditText)findViewById(R.id.editText9);

        mauth = FirebaseAuth.getInstance();
        mdb = FirebaseDatabase.getInstance();
        myref = mdb.getReference();
        FirebaseUser user = mauth.getCurrentUser();
        userID = user.getUid();

    }

    public void save(View view){
        String mInst = Inst.getText().toString();
        String mOwner = Owner.getText().toString();
        String mPin = pin.getText().toString();

        user muser = new user();
        muser.setName(mOwner);
        muser.setInstname(mInst);
        muser.setpin(mPin);

        mdb.getReference(userID).child("Info").setValue(muser);
        //myref.child(userID).setValue(muser);

        Inst.setText("");
        Owner.setText("");
        pin.setText("");

        Intent i = new Intent(Reg_sup.this,Supplier.class);
        startActivity(i);
    }
}
