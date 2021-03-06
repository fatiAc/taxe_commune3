/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Device;
import bean.Historique;
import bean.User;
import controler.util.DateUtil;
import controler.util.SearchUtil;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ayoub
 */
@Stateless
public class HistoriqueFacade extends AbstractFacade<Historique> {

    @PersistenceContext(unitName = "projet_java_taxPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Historique>findAll(){
        return em.createQuery("SELECT h FROM Historique h ORDER BY h.dateAction DESC").getResultList();
    }
    public void updateDevice(Device device) {
        String rqt = "UPDATE Historique h set h.device = " + null + " WHERE h.device.id =" + device.getId();
        System.out.println(rqt);
        em.createQuery(rqt).executeUpdate();
    }

    public List<Historique> rechercher(Date dateMin, Date dateMax, int type, User user) {
        String requette = "SELECT h FROM Historique h where  1=1 ";
        requette += SearchUtil.addConstraintMinMaxDate("h", "dateAction", dateMin, dateMax);
        if (type != 0) {
            requette += SearchUtil.addConstraint("h", "type", "=", type);
        }
        if (user != null) {
            requette += SearchUtil.addConstraint("h", "user.login", "=", user.getLogin());
        }
        requette+=" ORDER BY h.dateAction DESC";
        System.out.println(requette);
        return em.createQuery(requette).getResultList();

    }

    public HistoriqueFacade() {
        super(Historique.class);
    }

    public void clone(Historique historiqueSource, Historique historiqueDestaination) {
        historiqueDestaination.setId(historiqueSource.getId());

    }

    public Historique clone(Historique historique) {
        Historique cloned = new Historique();
        clone(historique, cloned);
        return cloned;
    }

}
