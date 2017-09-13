package cdi.com.onsport.Activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import cdi.com.onsport.Activites;
import cdi.com.onsport.Home;
import cdi.com.onsport.MyContext.ActivityAdapter;
import cdi.com.onsport.R;

public class ListeActivity extends AppCompatActivity {

    private ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);

        mListView = (ListView) findViewById(R.id.liste);

        List<Activites> activityList = genererListActivity();

        ActivityAdapter adapter = new ActivityAdapter(ListeActivity.this, activityList);
        mListView.setAdapter(adapter);

        final ImageView connexion = (ImageView) findViewById(R.id.homeLink);
        connexion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListeActivity.this, Home.class);
                startActivity(intent);
            }
        });




    }

    private List<Activites> genererListActivity() {
        List<Activites> infos = new ArrayList<Activites>();
        try {
            infos.add(new Activites("Lille", new SimpleDateFormat("yyyy-MM-DD").parse("1545-09-27"), 12, "Football", R.drawable.cover_foot));
            infos.add(new Activites("Lille", new SimpleDateFormat("yyyy-MM-DD").parse("1545-09-27"), 12, "Football", R.drawable.cover_foot));
            infos.add(new Activites("Arras", new SimpleDateFormat("yyyy-MM-DD").parse("1545-09-27"), 12, "Football", R.drawable.cover_foot));
            infos.add(new Activites("Lille", new SimpleDateFormat("yyyy-MM-DD").parse("1545-09-27"), 12, "Football", R.drawable.cover_foot));
            infos.add(new Activites("Lille", new SimpleDateFormat("yyyy-MM-DD").parse("1545-09-27"), 12, "Football", R.drawable.cover_foot));
        }catch (Exception e){

        }


        return infos;
    }
}
    //String lieu, Date date_debut, int nbr_participants, String activite, String messages

