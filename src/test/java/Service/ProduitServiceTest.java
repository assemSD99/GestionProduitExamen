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

    @Test
    public void testReadProduitExistant() throws Exception {
        Produit produit = new Produit(1L, "Produit1", 10.0, 5);
        service.createProduit(produit);

        Produit produitLu = service.readProduit(1L);
        assertNotNull(produitLu);
        assertEquals("Produit1", produitLu.getNom());
    }

    @Test(expected = Exception.class)
    public void testReadProduitNonExistant() throws Exception {
        service.readProduit(999L); // ID qui n'existe pas
    }

    @Test
    public void testUpdateProduitExistant() throws Exception {
        Produit produitMisAJour = new Produit(1L, "Produit1", 20.0, 10);
        service.updateProduit(produitMisAJour);

        Produit produitApresMiseAJour = service.readProduit(1L);
        assertEquals(20.0, produitApresMiseAJour.getPrix(), 0.0);
        assertEquals(10, produitApresMiseAJour.getQuantite());
    }

    @Test(expected = Exception.class)
    public void testUpdateProduitNonExistant() throws Exception {
        Produit produit = new Produit(2L, "Produit2", 20.0, 10);
        service.updateProduit(produit);
    }

    @Test(expected = Exception.class)
    public void testUpdateProduitAvecDonneesInvalides() throws Exception {
        Produit produitInvalide = new Produit(1L, "Produit1", -20.0, -10);
        service.updateProduit(produitInvalide);
    }


}