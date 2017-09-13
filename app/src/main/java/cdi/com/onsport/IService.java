package cdi.com.onsport;

import java.util.Date;
import java.util.List;

public interface   IService {

	public Utilisateur authenticate(String email, String password);
	
	public Utilisateur register(Utilisateur utilisateur);
	
	public List<Activites> getListActivity(String codepostal, Date debut, Date fin);
	
	public List<Activites> getListActivity(String codepostal, Date debut, Date fin, Integer num);
	
}
