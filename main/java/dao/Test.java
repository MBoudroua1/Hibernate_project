package dao;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        CatalogueDaoImpl dao = new CatalogueDaoImpl();
        System.out.println(/***** test *****/ );
        dao.addProduit(new Produit("P1",8000,4));
        dao.addProduit(new Produit("P2",1200,1));
        dao.addProduit(new Produit("P3",7500,3));
        System.out.println(/***** new elements *****/ );
        List<Produit> products = dao.listProduits();
        System.out.println(/***** result *****/ );
        for (Produit  p: products){
            System.out.println(p.getDesignation());
        }

    }
}
