package in.rishirajpurohit.android.sharedprefrences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences sharedPreferences = getSharedPreferences("myAppPrefs",MODE_APPEND);

        final EditText et_username = (EditText) findViewById(R.id.username);
        final EditText et_password = (EditText) findViewById(R.id.password);
        final EditText et_email = (EditText) findViewById(R.id.email);
        Button btn_register = (Button) findViewById(R.id.register_btn);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                String email = et_email.getText().toString();

                if(!username.isEmpty() && !password.isEmpty() && !email.isEmpty()){
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(username,password);
                    editor.commit();
                    Toast.makeText(MainActivity.this, "Register Successfull", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(MainActivity.this, "Please Fill All Fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
