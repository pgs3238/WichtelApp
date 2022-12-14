package Eventverwaltung.Teilnehmer.dao;

import Eventverwaltung.Event.entity.EventTO;
import Eventverwaltung.Event.entity.internal.User_Event;
import Eventverwaltung.Teilnehmer.entity.internal.User;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Transactional
@RequestScoped
public class UserDAO extends GenericDAO<User> {

    public UserDAO() {
        super(User.class);
    }

    public User findUserByEmail(String email) {
        Map<String, Object> parameters = new HashMap<>();
        System.out.println("Email: "+email);
        parameters.put("email", email);

        return super.findOneResult(User.FIND_BY_EMAIL, parameters);
    }


    public void delete(User aUser) {
        super.delete(aUser.getId(),User.class);
    }

    public Collection<User> findTeilnehmerByEvent(EventTO eventTO){
        Map<String, Object> eventParameter = new HashMap<>();
        eventParameter.put("event",eventTO.toEvent());

        return super.findListResult(User.GET_TEILNEHMER_VON_EVENT,eventParameter);
    }
}
