package com.example.appamst_lab2_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class PerfilUsuario extends AppCompatActivity {
    TextView txt_id, txt_name, txt_email, txt_telefono,txt_bio;
    ImageView imv_photo;
    DatabaseReference db_reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);
        Intent intent = getIntent();
        HashMap<String, String> info_user = (HashMap<String, String>) intent.getSerializableExtra("info_user");
        System.out.println("Informacion"+ info_user);
        txt_id = findViewById(R.id.txt_userId);
        txt_name = findViewById(R.id.txt_nombre);
        txt_email = findViewById(R.id.txt_correo);
        imv_photo = findViewById(R.id.imv_foto);
        txt_telefono=findViewById(R.id.txt_phone);
        txt_bio=findViewById(R.id.txt_prov);


        txt_id.setText(info_user.get("user_id"));
        txt_name.setText(info_user.get("user_name"));
        txt_email.setText(info_user.get("user_email"));
        txt_telefono.setText(info_user.get("user_phone"));
        txt_bio.setText(info_user.get("user_prov"));
        String photo = info_user.get("user_photo");
        Picasso.get().load(photo).into(imv_photo);
    }
    public void cerrarSesion(View view) {
        FirebaseAuth.getInstance().signOut();
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("msg", "cerrarSesion");
        startActivity(intent);
    }

    public void irRegistros(View view){
        Intent intent = new Intent(this, registros.class);
        startActivity(intent);
    }
}