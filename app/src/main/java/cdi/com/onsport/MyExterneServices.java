package cdi.com.onsport;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrateur on 11/09/2017.
 */

public class MyExterneServices implements IService {
    protected boolean prod;
    protected ClientWS cws;

    public MyExterneServices(boolean prod) {
        this.prod = prod;
    }

    @Override
    public Utilisateur authenticate(String email, String password) {
        Date currentDate= Calendar.getInstance().getTime();
        if (!prod) {
            // creation d'un fake pour test
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setId(1);
            utilisateur.setPseudo("toto");
            utilisateur.setMail("toto@mail.com");
            utilisateur.setMotdepasse("1234");
            utilisateur.setDatedenaissance(currentDate);
            utilisateur.setVille("Lille");
            utilisateur.setCp("59000");
            // retourne le fake si login correct null sinon
            if (email.equals(utilisateur.getMail()) && password.equals(utilisateur.getMotdepasse())) {
                return utilisateur;
            } else {

                return null;
            }
        } else {
            ClientWS cws = new ClientWS();
            return cws.authenticate(email, password);
        }

    }

    @Override
    public Utilisateur register(Utilisateur utilisateur) {
        if (!prod) {
            return utilisateur;
        } else {
            ClientWS cws = new ClientWS();
            return cws.register(utilisateur);
        }
    }

    @Override
    public List<Activites> getListActivity(String codepostal, Date debut, Date fin) {
        List<Activites> la = new ArrayList<>();
            if (!prod) {
                for (int i = 0; i < 10; i++) {
                    Activites activite = new Activites("Lille" + i, Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), 10 + i, "fouteux de brun", "un message bidon");
                    la.add(activite);
                }
                return la;
            } else {
                ClientWS cws = new ClientWS();
                return cws.getListActivity(codepostal, debut, fin);
            }

    }

    @Override
    public List<Activites> getListActivity(String codepostal, Date debut, Date fin, Integer num) {
        List<Activites> la= new ArrayList<>();
        if(!prod){
            for (int i=0;i<10;i++){
                Activites activite=new Activites("Lille"+i,Calendar.getInstance().getTime(),Calendar.getInstance().getTime(),10+i,"fouteux de brun","un message bidon");
                la.add(activite);
            }
            return la;
        }else {
            ClientWS cws = new ClientWS();
            return cws.getListActivity(codepostal, debut, fin,num);
        }
    }
}
