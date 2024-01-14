package Service;
import ma.saadaoui.assem.Produit;

import java.util.HashMap;
import java.util.Map;

public class ProduitService {
    private Map<Long, Produit> produits = new HashMap<>();

    public void createProduit(Produit produit) throws Exception {
        // Vérification de l'unicité et de la validité des données
        if (produits.containsKey(produit.getId()) || produits.containsValue(produit)) {
            throw new Exception("Produit déjà existant");
        }
        if (produit.getPrix() <= 0 || produit.getQuantite() < 0) {
            throw new Exception("Données invalides");
        }
        produits.put(produit.getId(), produit);
    }

    public Produit readProduit(Long id) throws Exception {
        if (!produits.containsKey(id)) {
            throw new Exception("Produit non trouvé");
        }
        return produits.get(id);
    }

    public void deleteProduit(Long id) throws Exception {
        if (!produits.containsKey(id)) {
            throw new Exception("Produit non trouvé pour l'ID: " + id);
        }
        produits.remove(id);
    }


}
