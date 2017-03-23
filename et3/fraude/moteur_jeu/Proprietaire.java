/*    */ package et3.fraude.moteur_jeu;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Proprietaire
/*    */ {
/*    */   protected String nom;
/*    */   protected Compte_Bancaire compte_bancaire;
/*    */   protected Pays pays_residence;
/*    */   protected ArrayList<Societe> liste_societes;
/*    */   
/*    */   protected Proprietaire(String name, Pays pays)
/*    */   {
/* 24 */     this.nom = name;
/* 25 */     this.pays_residence = pays;
/* 26 */     this.liste_societes = new ArrayList();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public String getNom()
/*    */   {
/* 33 */     return this.nom;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public Compte_Bancaire getCompte_bancaire()
/*    */   {
/* 40 */     return this.compte_bancaire;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setCompte_bancaire(Compte_Bancaire compte)
/*    */   {
/* 48 */     this.compte_bancaire = compte;
/* 49 */     this.compte_bancaire.setProprietaire_compte(this);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public Pays getPays_residence()
/*    */   {
/* 56 */     return this.pays_residence;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setPays_residence(Pays pays_residence)
/*    */   {
/* 64 */     this.pays_residence = pays_residence;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public ArrayList<Societe> getListe_societes()
/*    */   {
/* 71 */     return this.liste_societes;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setSociete(Societe s)
/*    */   {
/* 79 */     this.liste_societes.add(s);
/*    */   }
/*    */ }


/* Location:              D:\Users\ZeMachine\Scolaire\ET3S5\Java\projet.jar!\et3\fraude\moteur_jeu\Proprietaire.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */