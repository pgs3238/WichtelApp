package Eventverwaltung.Teilnehmer.usecase.impl;

import Eventverwaltung.Event.dao.EventDAO;
import Eventverwaltung.Event.dao.SubgruppeDAO;
import Eventverwaltung.Event.entity.internal.Subgruppe;
import Eventverwaltung.Teilnehmer.dao.UserDAO;
import Eventverwaltung.Teilnehmer.entity.internal.User;
import Eventverwaltung.Teilnehmer.usecase.ITeilnehmerZuSubgruppe;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/teilnZuSubgruppen")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeilnehmerZuSubgruppe implements ITeilnehmerZuSubgruppe {

    @Inject
    UserDAO userDAO;
    @Inject
    SubgruppeDAO subgruppeDAO;
    @Inject
    EventDAO eventDAO;
    @Context
    SecurityContext securityContext;

    @RolesAllowed({"admin", "owner"})
    @POST
    @Path("/add")
    @Override
    public Response TeilnehmerZuSubgruppeHinz(@QueryParam("email") String email, @QueryParam("subgruppeId") int subgruppeId) {
        User user = userDAO.findUserByEmail(email);
        Subgruppe subgruppe = subgruppeDAO.find(subgruppeId);
        if (user != null && subgruppeDAO.addUserToSubgruppe(user, subgruppe)) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @RolesAllowed({"admin", "owner"})
    @POST
    @Path("/remove")
    @Override
    public boolean TeilnehmerAusSubgruppe(@QueryParam("email") String email, @QueryParam("subgruppeId") int subgruppeId) {
        User user = userDAO.findUserByEmail(email);
        Subgruppe subgruppe = subgruppeDAO.find(subgruppeId);
        if (user == null) {
            return Boolean.FALSE;
        } else {
            subgruppeDAO.removeUserFromSubgruppe(user, subgruppe);
            return Boolean.TRUE;
        }
    }




}
