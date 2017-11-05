package aodai.badran.aodaiproject;

import android.content.Intent;
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

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnlogin;
    private Button btnregister;
    private EditText eTusername;
    private EditText eTpassword;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        btnlogin=(Button)findViewById(R.id.btnlogin);
        btnregister=(Button) findViewById(R.id.btnregister);
        eTusername=(EditText) findViewById(R.id.eTusername);
        eTpassword=(EditText) findViewById(R.id.eTpassword);
        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();
        btnlogin.setOnClickListener(this);
        btnlogin.setOnClickListener(this);
    }


    private void signIn(String email, String passw) {
        auth.signInWithEmailAndPassword(email, passw).addOnCompleteListener(LogInActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LogInActivity.this, "signIn Successful.", Toast.LENGTH_SHORT).show();
                    //Intent intent = new Intent(LogInActivity.this, MainListActivity.class);
                    //startActivity(intent);
                    //finish();
                } else {
                    Toast.makeText(LogInActivity.this, "signIn failed." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();

                }

            }
        });
    }


    private void dataHandler() {
        String email = eTusername.getText().toString();
        String passw = eTpassword.getText().toString();
        boolean isOk = true;//to check if all feilds are filled correctly

        signIn(email, passw);
    }


    @Override
    public void onClick(View view) {
        if (btnregister==view){
            Intent i = new Intent(this,SignUpActivity.class);
            startActivity(i);
        }

        if (btnlogin==view){
            dataHandler();

        }

    }
}
