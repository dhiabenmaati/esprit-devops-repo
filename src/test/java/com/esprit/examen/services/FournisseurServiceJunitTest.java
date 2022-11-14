/* package com.esprit.examen.services;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.entities.SecteurActivite;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FournisseurServiceJunitTest {
	@Autowired
	IFournisseurService fs;
	@Autowired
	ISecteurActiviteService sc;


	@Test
    public void TestAddFournisseur() {
    	Fournisseur fournisseur = new Fournisseur();
        fournisseur.setCategorieFournisseur(null);
        fournisseur.setCode("123");
        fournisseur.setFactures(null);
        fournisseur.setLibelle("lib");
        fournisseur.setSecteurActivites(null);
        fournisseur.setCategorieFournisseur(null);
        fournisseur.setDetailFournisseur(null);
        Fournisseur f = fs.addFournisseur(fournisseur);
        assertNull(f.getFactures());
		assertSame("123", f.getCode());      
		fs.deleteFournisseur(f.getIdFournisseur());

	}
	
	@Test
    public void retriveall() {
    	Fournisseur fournisseur = new Fournisseur();
        fournisseur.setCategorieFournisseur(null);
        fournisseur.setCode("123");
        fournisseur.setFactures(null);
        fournisseur.setLibelle("lib");
        fournisseur.setSecteurActivites(null);
        fournisseur.setCategorieFournisseur(null);
        fournisseur.setDetailFournisseur(null);
        Fournisseur fournisseur1 = new Fournisseur();
        fournisseur1.setCategorieFournisseur(null);
        fournisseur1.setCode("123");
        fournisseur1.setFactures(null);
        fournisseur1.setLibelle("lib");
        fournisseur1.setSecteurActivites(null);
        fournisseur1.setCategorieFournisseur(null);
        fournisseur1.setDetailFournisseur(null);
        Fournisseur f= fs.addFournisseur(fournisseur);
        Fournisseur f2 = fs.addFournisseur(fournisseur1);
        assertEquals(2, fs.retrieveAllFournisseurs().size());
		fs.deleteFournisseur(f.getIdFournisseur());
		fs.deleteFournisseur(f2.getIdFournisseur());


        

	}
	
  
    
}

*/
