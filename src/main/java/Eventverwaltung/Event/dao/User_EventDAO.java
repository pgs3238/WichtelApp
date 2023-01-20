package Eventverwaltung.Event.dao;

import Eventverwaltung.Event.entity.EventTO;
import Eventverwaltung.Event.entity.internal.User_Event;
import Eventverwaltung.Teilnehmer.dao.GenericDAO;
import Eventverwaltung.Teilnehmer.entity.UserTO;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User_EventDAO extends GenericDAO<User_Event> {

    public User_EventDAO(){
        super(User_Event.class);
    }

    public void delete(User_Event user_event){
        super.delete(user_event.getUser_event_id(), User_Event.class);
    }

    public User_Event findOneResult(UserTO user, EventTO event){
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("user", user.toUser());
        parameters.put("event", event.toEvent());

        return super.findOneResult(User_Event.GET_USEREVENT,parameters);
    }

    public Collection<User_Event> findUserEventByEvent(EventTO eventTO){
        Map<String, Object> eventParameter = new HashMap<>();
        eventParameter.put("event",eventTO.toEvent());

        return super.findListResult(User_Event.GET_TEILNEHMERINFO,eventParameter);
    }

    public List<User_Event> getSubgruppeNachGroesse(EventTO eventTO){
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("event",eventTO.toEvent());

        return super.findListResult(User_Event.GET_GROESSESUBGRUPPE, parameters);
    }
    @Override
    public void save(User_Event userEvent){
        super.save(userEvent);
    }
}
