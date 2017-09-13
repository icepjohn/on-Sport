package cdi.com.onsport;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrateur on 11/09/2017.
 */

public class ClientWS implements IService {
    private final String wsUrl="http://192.168.23.117:8888/ws/dao";
    private final String soapUurl="http://localhost:9998/service/";
    @Override
    public Utilisateur authenticate(String email, String password) {
        return null;
    }

    @Override
    public Utilisateur register(Utilisateur utilisateur) {
        return null;
    }

    @Override
    public List<Activites> getListActivity(String codepostal, Date debut, Date fin) {
        return null;
    }

    @Override
    public List<Activites> getListActivity(String codepostal, Date debut, Date fin, Integer num) {
        return null;
    }
}
