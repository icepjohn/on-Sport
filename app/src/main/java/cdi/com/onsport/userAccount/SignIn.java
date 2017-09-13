package cdi.com.onsport.userAccount;

import android.app.ActivityOptions;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import cdi.com.onsport.MyContext.UserHandler;
import cdi.com.onsport.R;

public class SignIn extends AppCompatActivity {

    ViewGroup TransitionContainer;
    EditText email, password, password2, codePostal, ville,  dateNaissance;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Slide slideOut = new Slide(Gravity.LEFT);
        getWindow().setExitTransition(slideOut);
        Slide slideIn = new Slide(Gravity.RIGHT);
        getWindow().setEnterTransition(slideIn);

        email = (EditText) findViewById(R.id.email);
        dateNaissance = (EditText) findViewById(R.id.dateNaissance);
        password = (EditText) findViewById(R.id.password);
        password2 = (EditText) findViewById(R.id.password2);
        codePostal = (EditText) findViewById(R.id.CodePostal);
        ville = (EditText) findViewById(R.id.Ville);

        final String Email = email.getText().toString();
        final String Date = dateNaissance.getText().toString();
        final String Password = password.getText().toString();
        final String Password2 = password2.getText().toString();
        final String CodePostal = codePostal.getText().toString();
        final String Ville = ville.getText().toString();

        //calendrier
        // initiate the date picker and a button
        // perform click event on edit text
        dateNaissance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(SignIn.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                dateNaissance.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        Button signUp = (Button) findViewById(R.id.SignUp);
        signUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


            }
        });







    }
}
