package cdi.com.onsport.userAccount;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import cdi.com.onsport.Activity.Activity;
import cdi.com.onsport.Home;
import cdi.com.onsport.MainActivity;
import cdi.com.onsport.MyContext.UserHandler;
import cdi.com.onsport.MyExterneServices;
import cdi.com.onsport.R;
import cdi.com.onsport.Utilisateur;

public class MonCompte extends AppCompatActivity {
    TextView Email;
    String email;
  /*  TextView ddn;
    Date dateNaissance;*/
    TextView textViewPPseudo;
    String pseudo ;
    TextView textViewVVille;
    String ville;
    TextView textViewCCP;
    String ccp;
    TextView textViewCComm;
    String comm;
    Button modifier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_compte);

        Slide slideOut = new Slide(Gravity.LEFT);
        getWindow().setExitTransition(slideOut);
        Slide slideIn = new Slide(Gravity.RIGHT);
        getWindow().setEnterTransition(slideIn);

        //commentaire
        textViewCComm = (TextView) findViewById(R.id.textViewCComm);
        comm = UserHandler.getInstance().getUser().getCommentaire();
        textViewCComm.setText(comm);
        // code postal
        textViewCCP = (TextView)findViewById(R.id.textViewCCP);
        ccp = UserHandler.getInstance().getUser().getCp();
        textViewCCP.setText(ccp);
        //pseudo
        textViewPPseudo = (TextView)findViewById(R.id.textViewPPseudo);
        pseudo =  UserHandler.getInstance().getUser().getPseudo();
        textViewPPseudo.setText(pseudo);
        //ville
        textViewVVille = (TextView) findViewById(R.id.textViewVVille);
        ville = UserHandler.getInstance().getUser().getVille();
        textViewVVille.setText(ville);
        // email
        Email = (TextView)findViewById(R.id.Mail);
        email =  UserHandler.getInstance().getUser().getMail();
        Email.setText(email);

      /*  ddn = (EditText)findViewById(R.id.dateNaissance);
        dateNaissance = UserHandler.getInstance().getUser().getDatedenaissance();
        ddn.setText(dateNaissance.format("dd/MM/yyyy ", dateNaissance).toString());*/

        modifier = (Button) findViewById(R.id.modifier);
        modifier.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MonCompte.this, UserModifier.class);
                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(MonCompte.this).toBundle();
                startActivity(intent, bundle);
            }

        });

        final ImageView connexion = (ImageView) findViewById(R.id.homeLink);
        connexion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MonCompte.this, Home.class);
                startActivity(intent);
            }
        });
    }
}
