package aodai.badran.aodaiproject;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnsaveacc;
    private Button btndeletesaved;
    private EditText eTusername;
    private EditText eTemail;
    private EditText eTpassword;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btnsaveacc=(Button) findViewById(R.id.btnsaveacc);
        btndeletesaved=(Button)findViewById(R.id.btndeletesaved);
        eTusername=(EditText)findViewById(R.id.eTusername);
        eTemail=(EditText)findViewById(R.id.eTemail);
        eTpassword=(EditText)findViewById(R.id.eTpassword);
        btnsaveacc.setOnClickListener(this);
        btndeletesaved.setOnClickListener(this);
        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();
    }


    private void dataHandler() {
        String email = eTemail.getText().toString();
        String username = eTusername.getText().toString();
        String passw = eTpassword.getText().toString();
        boolean isOk = true;//to check if all feilds are filled correctly

        createAccount(email,passw);
    }



    private void createAccount(String email, String passw ) {
        auth.createUserWithEmailAndPassword(email,passw).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(SignUpActivity.this, "Authentication Successful.", Toast.LENGTH_SHORT).show();
                    //updateUserProfile(task.getResult().getUser());
                    finish();
                }
                else
                {
                    Toast.makeText(SignUpActivity.this, "Authentication failed."+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        dataHandler();

    }
}
