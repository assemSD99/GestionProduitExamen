package Service;

import ma.saadaoui.assem.Produit;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProduitServiceTest {

    private ProduitService service;

    @Before
    public void setUp() throws Exception {
        service = new ProduitService();
    }
    @Test
    public void testCreateProduit() throws Exception {
        Produit produit = new Produit(1L, "Produit1", 10.0, 5);
        service.createProduit(produit);
        // autres assertions ici
    }

    @Test(expected = Exception.class)
    public void testCreateProduitAvecDonneesInvalides() throws Exception {
        Produit produit = new Produit(2L, "Produit2", -1.0, 3);
        service.createProduit(produit);
    }


}