package cdi.com.onsport;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignIn extends AppCompatActivity {

    ViewGroup TransitionContainer;
    Date date=null;
    Boolean ERROR = false;
    Utilisateur session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);



        Slide slideOut = new Slide(Gravity.LEFT);
        getWindow().setExitTransition(slideOut);
        Slide slideIn = new Slide(Gravity.RIGHT);
        getWindow().setEnterTransition(slideIn);

        EditText pseudo = (EditText) findViewById(R.id.pseudo);
        final EditText email = (EditText) findViewById(R.id.email);
        final EditText dateNaissance = (EditText) findViewById(R.id.dateNaissance);
        EditText password = (EditText) findViewById(R.id.password);
        EditText password2 = (EditText) findViewById(R.id.password2);
        EditText codePostal = (EditText) findViewById(R.id.CodePostal);
        EditText ville = (EditText) findViewById(R.id.Ville);

        final String string_pseudo = pseudo.getText().toString();
        final String string_email = email.getText().toString();
        final String string_date = dateNaissance.getText().toString();
        final String string_password = password.getText().toString();
        final String string_password2 = password2.getText().toString();
        final String string_codePostal = codePostal.getText().toString();
        final String string_ville = ville.getText().toString();






        /****************** OnClick EditText date de naissance ***************************/
        //calendrier

        dateNaissance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

// calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                DatePickerDialog datePickerDialog = new DatePickerDialog(SignIn.this,
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
        /********************** fin onclick date de naissance *************************************/




        Button signUp = (Button) findViewById(R.id.SignUp);
        signUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (string_email.isEmpty()||string_date.isEmpty()||string_password.isEmpty()||string_password2.isEmpty()||string_codePostal.isEmpty()||string_ville.isEmpty()){
                    Toast.makeText(SignIn.this, "Vous devez renseigner tous les champs",
                            Toast.LENGTH_SHORT).show();
                }
                else {

                    IService inscription = new MyExterneServices(true);

                    Utilisateur util = new Utilisateur();

                    /************** on insere le pseudo *************/
                    util.setPseudo(string_pseudo);
                    /************** on verifie le mail *************/
                    Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
                    Matcher m = p.matcher(string_email);
                    if (!m.matches()) {
                        Toast.makeText(SignIn.this, "Vous n'avez pas entré un mail valide",
                                Toast.LENGTH_SHORT).show();
                        ERROR = true;
                    } else {

                        util.setMail(string_email);
                    }


                    /************** on formate la date de naissance de String a Date *************/
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        date = sdf.parse(string_date);
                  // date = new Date(sdf.parse(string_date).getTime());
                    } catch (ParseException e) {
                        e.printStackTrace();
                        ERROR=true;
                    }
                    // on insere la date de naissance
                    util.setDatedenaissance(date);

                    /************** on on verifie les passwords *************/
                    if (string_password.equals(string_password2)) {
                        util.setMotdepasse(string_password);
                    } else {
                        Toast.makeText(SignIn.this, "Les mots de passe ne corespondent pas",
                                Toast.LENGTH_SHORT).show();
                        ERROR=true;
                    }
                    /************** on verifie le cp *************/
                    if (string_codePostal.length() > 5) {
                        Toast.makeText(SignIn.this, "Vous n'avez pas entré un code postal valide",
                                Toast.LENGTH_SHORT).show();
                        ERROR=true;
                    } else {
                        util.setCp(string_codePostal);
                    }
                    /************** on insere la ville *************/
                    util.setVille(string_ville);

                    if (ERROR==false)
                    session = inscription.register(util);
                    if (session==null)
                        Toast.makeText(SignIn.this, "Erreur de communication avec la base de donnée",
                                Toast.LENGTH_SHORT).show();
                }
            }
        });





    }
}
