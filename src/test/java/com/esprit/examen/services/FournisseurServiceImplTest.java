package tn.esprit.rh.achat.services;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import tn.esprit.rh.achat.entities.CategorieFournisseur;
import tn.esprit.rh.achat.entities.DetailFournisseur;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.DetailFournisseurRepository;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes = {FournisseurServiceImpl.class})
@RunWith(SpringRunner.class)
@SpringBootTest
public class FournisseurServiceImplTest {
    @MockBean
    private DetailFournisseurRepository detailFournisseurRepository;

    @MockBean
    private FournisseurRepository fournisseurRepository;

    @Autowired
    private FournisseurServiceImpl fournisseurServiceImpl;

    @MockBean
    private ProduitRepository produitRepository;

    @MockBean
    private SecteurActiviteRepository secteurActiviteRepository;
   
   @Autowired
   private IFournisseurService fs;





    @Test
    public void RetriveallFournisseru() throws ParseException {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setIdFournisseur(1L);
        fournisseur.setCategorieFournisseur(null);
        fournisseur.setCode("123");
        fournisseur.setFactures(null);
        fournisseur.setIdFournisseur(1L);
        fournisseur.setLibelle("lib");
        fournisseur.setSecteurActivites(null);
        fournisseur.setCategorieFournisseur(null);
        
        Fournisseur fournisseur2 = new Fournisseur();
        fournisseur2.setIdFournisseur(2L);
        fournisseur2.setCategorieFournisseur(null);
        fournisseur2.setCode("123456");
        fournisseur2.setFactures(null);
        fournisseur2.setIdFournisseur(1L);
        fournisseur2.setLibelle("lib");
        fournisseur2.setSecteurActivites(null);
        fournisseur.setCategorieFournisseur(null);


        
        ArrayList<Fournisseur> data = new ArrayList<>();
        data.add(fournisseur);
        data.add(fournisseur2);
        when(fournisseurRepository.findAll()).thenReturn(data);
        List<Fournisseur> resultatService = fournisseurServiceImpl.retrieveAllFournisseurs();
        assertEquals(2, resultatService.size());
        assertSame(data, resultatService);
        verify(fournisseurRepository).findAll();
    }

    @Test
    public void deleteFournisseur() {
    	Fournisseur fournisseur = new Fournisseur();
        fournisseur.setIdFournisseur(1L);
        fournisseur.setCategorieFournisseur(null);
        fournisseur.setCode("123");
        fournisseur.setFactures(null);
        fournisseur.setIdFournisseur(1L);
        fournisseur.setLibelle("lib");
        fournisseur.setSecteurActivites(null);
        fournisseur.setCategorieFournisseur(null);
        fournisseurServiceImpl.deleteFournisseur(1L);
        verify(fournisseurRepository, times(1)).deleteById(eq(fournisseur.getIdFournisseur()));
      
        
    }
    
   
    
}

