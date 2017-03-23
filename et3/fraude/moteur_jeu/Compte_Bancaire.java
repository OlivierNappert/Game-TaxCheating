/*    */ package et3.fraude.moteur_jeu;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Compte_Bancaire
/*    */ {
/*    */   private Banque banque;
/*    */   
/*    */ 
/*    */   private int identifiant_unique;
/*    */   
/*    */ 
/*    */   private int solde;
/*    */   
/*    */ 
/*    */   private Proprietaire proprietaire_compte;
/*    */   
/*    */ 
/*    */ 
/*    */   public Compte_Bancaire(Banque bank, int id, int solde_compte)
/*    */   {
/* 23 */     this.banque = bank;
/* 24 */     this.identifiant_unique = id;
/* 25 */     this.solde = solde_compte;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 29 */     return "Banque : " + this.banque.getNom() + " Compte n°" + this.identifiant_unique + " solde : " + this.solde + "$";
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int getIdentifiant_unique()
/*    */   {
/* 36 */     return this.identifiant_unique;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setIdentifiant_unique(int identifiant_unique)
/*    */   {
/* 44 */     this.identifiant_unique = identifiant_unique;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int getSolde()
/*    */   {
/* 51 */     return this.solde;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setSolde(int solde)
/*    */   {
/* 59 */     this.solde = solde;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void addToSolde(int montant)
/*    */   {
/* 67 */     this.solde += montant;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public Banque getBanque()
/*    */   {
/* 74 */     return this.banque;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setBanque(Banque banque)
/*    */   {
/* 82 */     this.banque = banque;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public Proprietaire getProprietaire()
/*    */   {
/* 89 */     return this.proprietaire_compte;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setProprietaire_compte(Proprietaire proprietaire)
/*    */   {
/* 97 */     this.proprietaire_compte = proprietaire;
/*    */   }
/*    */ }


/* Location:              D:\Users\ZeMachine\Scolaire\ET3S5\Java\projet.jar!\et3\fraude\moteur_jeu\Compte_Bancaire.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */