package Eventverwaltung.Teilnehmer.usecase.impl;

import Eventverwaltung.Event.entity.EventTO;
import Eventverwaltung.Teilnehmer.dao.UserDAO;
import Eventverwaltung.Teilnehmer.usecase.ITeilnehmerFuerEvent;
import Eventverwaltung.Teilnehmer.entity.internal.User;

import javax.inject.Inject;
import java.util.Collection;

public class TeilnehmerFuerEvent implements ITeilnehmerFuerEvent {

    @Inject
    UserDAO userDAO;

    @Override
    public Collection<User> teilnehmerFuerEvent(EventTO event){
        Collection<User> users = userDAO.findTeilnehmerByEvent(event);
        return users;
    }
}
