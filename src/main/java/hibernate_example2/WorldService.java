package hibernate_example2;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class WorldService {
    private EntityManagerFactory managerFactory;
    private EntityManager manager;

    public WorldService() {
        openConnection();
    }

    public City getCityById(int id) {
        return manager.find(City.class, id);
    }

    private void openConnection() {
        managerFactory =
                Persistence.createEntityManagerFactory("mysqlPU");
        manager = managerFactory.createEntityManager();
    }

    private void closeAll() {
        manager.close();
        managerFactory.close();
    }

    public void stop() {
        closeAll();
    }

    public City update(City city) {
        manager.getTransaction().begin();
        manager.persist(city);
        manager.flush(); // wymuszenie zapisu
        manager.refresh(city); // odświeżenie
        manager.getTransaction().commit();
        return city;
    }

    public City save(City city) {
        manager.getTransaction().begin();
        manager.persist(city);
        manager.getTransaction().commit();
        return city;
    }

    public List<City> findCitiesByName(String name) {
        TypedQuery<City> query = manager.createNamedQuery("citiesByName", City.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }

    public List<City> findCitiesByDistrict(String dis) {

        return manager.createNamedQuery("findCityInDistrictNative", City.class)
                .setParameter(1, dis)
                .getResultList();
    }
}