package hcmute.edu.vn.connectfirebase.TranQuocTuan20110595;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText txtname, txtage, txtphone, txtheight;
    Button btnsave;
    DatabaseReference reff;
    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtname = findViewById(R.id.txtname);
        txtage = findViewById(R.id.txtage);
        txtphone = findViewById(R.id.txtphone);
        txtheight = findViewById(R.id.txtheight);
        btnsave = findViewById(R.id.btnsave);
        member = new Member();

        reff = FirebaseDatabase.getInstance().getReference().child("Member");

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int agea = Integer.parseInt(txtage.getText().toString().toString().trim());
                Float hit = Float.parseFloat(txtheight.getText().toString().trim());
                Long phn = Long.parseLong(txtphone.getText().toString().trim());
                member.setName(txtname.getText().toString().trim());
                member.setAge(agea);
                member.setHeight(hit);
                member.setPhone(phn);
                reff.push().setValue(member);
                Toast.makeText(MainActivity.this, "data inserted sucessfully", Toast.LENGTH_LONG).show();
            }
        });
    }
}