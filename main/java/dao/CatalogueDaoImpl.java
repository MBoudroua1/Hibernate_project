package dao;

import javax.persistence.*;
import java.util.List;

public class CatalogueDaoImpl implements ICatalogueDao {
    private EntityManager entityManager;

    public CatalogueDaoImpl() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("UP_CAT");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void addProduit(Produit p) {
        // créer une transaction
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try{
            entityManager.persist(p);
            transaction.commit();
        }
        catch (Exception e ){
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<Produit> listProduits() {

        Query query = entityManager.createQuery("select p from Produit p");
        return query.getResultList();
    }

    @Override
    public List<Produit> produitsParMC(String mc) {
        Query query =entityManager.createQuery("select p from Produit p where p.designation like :x");
        query.setParameter("x","%"+mc+"%");

        return query.getResultList();
    }

    @Override
    public Produit getProduit(Long idProduit) {
        Produit p = entityManager.find(Produit.class,idProduit);
        return p;
    }

    @Override
    public void updateProduit(Produit p) {
        entityManager.merge(p);

    }

    @Override
    public void deleteProduit(Long idProduit) {
        Produit p = entityManager.find(Produit.class,idProduit );
        entityManager.remove(p);
        System.out.println("Produit supprimé");
    }
}
