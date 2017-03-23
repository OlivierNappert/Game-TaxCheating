/*    */ package et3.fraude.moteur_jeu;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Transaction_Bancaire
/*    */ {
/*    */   private int id;
/*    */   
/*    */ 
/*    */ 
/*    */   private Compte_Bancaire compte_source;
/*    */   
/*    */ 
/*    */ 
/*    */   private Compte_Bancaire compte_destination;
/*    */   
/*    */ 
/*    */ 
/*    */   private int montant;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public Compte_Bancaire getCompte_source()
/*    */   {
/* 27 */     return this.compte_source;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setCompte_source(Compte_Bancaire compte_source)
/*    */   {
/* 35 */     this.compte_source = compte_source;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public Compte_Bancaire getCompte_destination()
/*    */   {
/* 42 */     return this.compte_destination;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setCompte_destination(Compte_Bancaire compte_destination)
/*    */   {
/* 50 */     this.compte_destination = compte_destination;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int getMontant()
/*    */   {
/* 57 */     return this.montant;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setMontant(int montant)
/*    */   {
/* 65 */     this.montant = montant;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int getId()
/*    */   {
/* 72 */     return this.id;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setId(int id)
/*    */   {
/* 80 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     String s = String.format("\n  %d\t  %d\t%d$\t\t%d\n  %d\t  %d\t%d$\t\t%d", new Object[] {
/* 85 */       Integer.valueOf(this.compte_source.getIdentifiant_unique()), Integer.valueOf(this.compte_source.getBanque().getCode_banque()), Integer.valueOf(this.montant), Integer.valueOf(this.id), 
/* 86 */       Integer.valueOf(this.compte_destination.getIdentifiant_unique()), Integer.valueOf(this.compte_destination.getBanque().getCode_banque()), Integer.valueOf(this.montant), Integer.valueOf(this.id) });
/*    */     
/* 88 */     return s;
/*    */   }
/*    */ }


/* Location:              D:\Users\ZeMachine\Scolaire\ET3S5\Java\projet.jar!\et3\fraude\moteur_jeu\Transaction_Bancaire.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */