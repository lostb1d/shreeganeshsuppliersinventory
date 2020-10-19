package np.com.dineshbishwakarma.shreeganeshsuppliersinventory;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddCustomer extends AppCompatActivity {
    private static final String TAG = "AddCustomer";

    DatabaseHelper mDatabaseHelper;
    private Button btnAdd;
    private EditText customer_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        customer_name = (EditText) findViewById(R.id.CustomerName);
        btnAdd = (Button) findViewById(R.id.createCustomer);
        mDatabaseHelper = new DatabaseHelper(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = customer_name.getText().toString();
                if(customer_name.length() != 0){
                    AddData(newEntry);
                    customer_name.setText("");
                }else{
                    Toast.makeText(AddCustomer.this, "You must put something in the customer name", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public void AddData(String newEntry){
        boolean insertData = mDatabaseHelper.addData((newEntry));

        if (insertData){
            Toast.makeText(this, "Data successfully inserted", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Something went wrong..", Toast.LENGTH_SHORT).show();
        }
    }
}