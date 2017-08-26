package in.rishirajpurohit.android.sharedprefrences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final SharedPreferences sharedPreferences = getSharedPreferences("myAppPrefs",MODE_APPEND);

        final EditText et_username = (EditText) findViewById(R.id.username);
        final EditText et_password = (EditText) findViewById(R.id.password);
        Button btn_login = (Button) findViewById(R.id.login_btn);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();

                if(!username.isEmpty() && !password.isEmpty()){
                    String real_password = sharedPreferences.getString(username,"");
                    if(password.trim().equals(real_password)){
                        Toast.makeText(LoginActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(LoginActivity.this, "Please Fill All Fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
