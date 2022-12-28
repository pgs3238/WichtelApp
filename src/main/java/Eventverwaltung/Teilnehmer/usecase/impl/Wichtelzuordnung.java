package Eventverwaltung.Teilnehmer.usecase.impl;

import Eventverwaltung.Event.dao.User_EventDAO;
import Eventverwaltung.Event.entity.EventTO;
import Eventverwaltung.Event.entity.internal.User_Event;
import Eventverwaltung.Teilnehmer.entity.UserTO;
import Eventverwaltung.Teilnehmer.usecase.IWichtelzuordnung;

import javax.inject.Inject;
import java.util.*;

public class Wichtelzuordnung implements IWichtelzuordnung{

    @Inject
    User_EventDAO user_eventDAO;

    @Override
    public Map<UserTO,UserTO> WichtelZulosen(EventTO event){
        Collection<User_Event> teilnehmerByEvent = user_eventDAO.findUserEventByEvent(event);
        Collection<User_Event> wichtelListe = user_eventDAO.findUserEventByEvent(event);
        Map<UserTO, UserTO> zuordnung = new HashMap<>();

        if (istSchonDurchgelost(teilnehmerByEvent)){
            return null;
        }
        //prüft ob sich mehr als eine Person in dem Event befinden
        if(teilnehmerByEvent.size()>1) {

            for (User_Event ue : teilnehmerByEvent) {
                Optional<User_Event> neuWichtel = teilnehmerByEvent.stream().skip(new Random()
                        .nextInt(teilnehmerByEvent.size())).findFirst();
                if (neuWichtel.get().equals(ue) || neuWichtel.get().getSubgruppe().equals(ue.getSubgruppe())) {

                }
            }
        }
            return null;
    }

    // sortiert die User nach der Größe der Subgruppe
    // das ist benötigt damit man in der Zuordnung nicht in eine Endlosschleife läuft
    public Collection<User_Event> UserEventSortieren(Collection<User_Event> collection){
        return null;
    }

    //prüft ob jeder Teilnehmer schon ein Wichtel hat (evtl. benachrichtigen oder keine neue Zuordnung)
    public boolean istSchonDurchgelost(Collection<User_Event> liste){
        for (User_Event ue : liste){
            if (ue.getWichtel()!= null){
                continue;
            }else return false;
        }
        return true;
    }

    //prüft ob keine der Subgruppen mehr als 50% der Teilnehmer hat
    public boolean kleineSubgruppen(Collection<User_Event> liste){
     return true;
    }
}