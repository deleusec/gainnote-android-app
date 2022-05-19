package com.example.gainnote.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.gainnote.R;
import com.example.gainnote.dao.AppDatabase;
import com.example.gainnote.databinding.ActivityCurrentDataBinding;
import com.example.gainnote.model.User;
import com.example.gainnote.utils.ActivityUtils;
import com.google.android.material.textfield.TextInputLayout;

import java.lang.reflect.Array;

public class CurrentDataActivity extends AppCompatActivity {

    ActivityCurrentDataBinding binding;
    private TextInputLayout InputSexe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_current_data);

        InputSexe = binding.inputSexe;
        String[] itemsSexe = new String[]{
                "Homme",
                "Femme"
        };
        String[] itemsBodyType = new String[]{
                "Mince",
                "Normal",
                "Sportif",
                "Surpoid"
        };
        ArrayAdapter<String> adapterSexe = new ArrayAdapter<>(CurrentDataActivity.this, R.layout.dropdown_item,itemsSexe);
        ArrayAdapter<String> adapterBodyType = new ArrayAdapter<>(CurrentDataActivity.this, R.layout.dropdown_item,itemsBodyType);
        binding.menuSexe.setAdapter(adapterSexe);
        binding.menuBodyType.setAdapter(adapterBodyType);
        /*
        this.setSpinner(R.id.user_body_type, R.array.body_type_array);
        this.setSpinner(R.id.user_sexe, R.array.sexe_array);
        */

        binding.dataValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userFirstname = binding.userFirstname.getText().toString();
                String userName = binding.userName.getText().toString();
                String userSexe = binding.menuSexe.getText().toString();
                String userBodyType = binding.menuBodyType.getText().toString();

                int userWeight = 0;
                int userHeight = 0;

                if (!binding.userWeight.getText().toString().isEmpty()) {
                    userWeight = Integer.parseInt(binding.userWeight.getText().toString());
                }

                if (!binding.userHeight.getText().toString().isEmpty()) {
                    userHeight = Integer.parseInt(binding.userHeight.getText().toString());
                }


                if(!userFirstname.isEmpty() && !userName.isEmpty() && !userBodyType.isEmpty() && userWeight != 0 && userHeight != 0){
                    User user = new User(userFirstname, userName, userSexe, userWeight, userHeight, userBodyType);
                    AppDatabase.getDatabase(CurrentDataActivity.this).appDao().insert(user);

                    ActivityUtils.launchActivity(CurrentDataActivity.this, MainActivity.class);
                } else {
                    Toast.makeText(CurrentDataActivity.this, "Champs manquant !", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void setSpinner(Object id, Object array ){
        Spinner spinner = (Spinner) findViewById((Integer) id);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                (Integer) array, R.layout.color_spinner_layout);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}