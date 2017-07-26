package com.reachuson.app.pdb1;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.thrivecom.ringcaptcha.RingcaptchaApplication;
import com.thrivecom.ringcaptcha.RingcaptchaApplicationHandler;
import com.thrivecom.ringcaptcha.RingcaptchaService;
import com.thrivecom.ringcaptcha.RingcaptchaVerification;
import com.thrivecom.ringcaptcha.lib.models.RingcaptchaResponse;

public class Login extends AppCompatActivity {
    private FirebaseAuth mauth;
    private EditText username,password;
    private ProgressBar Spinner;
    private FirebaseDatabase mdb;
    private FirebaseUser mUser;
    private DatabaseReference myref,myref2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mauth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Spinner = (ProgressBar)findViewById(R.id.progressBar2);
        Spinner.setVisibility(View.GONE);



        mdb = FirebaseDatabase.getInstance();
        myref = mdb.getReference();
        mUser = mauth.getCurrentUser();



    }
    public void login(View view){

        username = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);
        final String email = username.getText().toString();
        String pass = password.getText().toString().trim();
        Spinner.setVisibility(View.VISIBLE);
        mauth.signInWithEmailAndPassword(email,pass)
                .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(!task.isSuccessful()){
                            Toast.makeText(Login.this, "Login Failure", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            String ID = mUser.getUid();
                            myref2 = mdb.getReference(ID).child("type");
                            myref2.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    String type = dataSnapshot.getValue().toString();
                                   // Toast.makeText(Login.this, ""+type, Toast.LENGTH_SHORT).show();
                                    if(type.contains("1")){
                                        Intent inter = new Intent(Login.this,Supplier.class);
                                        inter.putExtra("pass",email);
                                        inter.putExtra("nothing","nothi");
                                        startActivity(inter);
                                    }
                                    else{
                                        Toast.makeText(Login.this, "Hang in there!"+type, Toast.LENGTH_SHORT).show();
                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });


                        }


                            Spinner.setVisibility(View.GONE);
                        }

                    });
    }
    public void verify(View view){

    }
    public void create(View view){
        Intent inte = new Intent(Login.this,Register.class);
        startActivity(inte);
    }


}
