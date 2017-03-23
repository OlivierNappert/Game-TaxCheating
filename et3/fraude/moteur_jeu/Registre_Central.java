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
/*    */ public class Registre_Central
/*    */ {
/*    */   private ArrayList<Denonciation> liste_denonciations;
/*    */   private ArrayList<Transaction_Bancaire> liste_transactions_suspectes;
/*    */   
/*    */   public Registre_Central()
/*    */   {
/* 20 */     this.liste_denonciations = new ArrayList();
/* 21 */     this.liste_transactions_suspectes = new ArrayList();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public ArrayList<Denonciation> getListeDenonc()
/*    */   {
/* 28 */     return this.liste_denonciations;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setDenonciation(Denonciation d)
/*    */   {
/* 36 */     this.liste_denonciations.add(d);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public ArrayList<Transaction_Bancaire> getListeTransactionSuspectes()
/*    */   {
/* 43 */     return this.liste_transactions_suspectes;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setAllTransactions(ArrayList<Transaction_Bancaire> tb_array)
/*    */   {
/* 51 */     this.liste_transactions_suspectes = tb_array;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void removeTransaction(Transaction_Bancaire tb)
/*    */   {
/* 59 */     int i = this.liste_transactions_suspectes.indexOf(tb);
/* 60 */     this.liste_transactions_suspectes.remove(i);
/*    */   }
/*    */ }


/* Location:              D:\Users\ZeMachine\Scolaire\ET3S5\Java\projet.jar!\et3\fraude\moteur_jeu\Registre_Central.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */