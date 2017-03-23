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
/*    */ 
/*    */ public class Banque
/*    */   extends Societe
/*    */ {
/*    */   private int code_banque;
/*    */   private ArrayList<Compte_Bancaire> liste_comptes;
/*    */   
/*    */   public Banque(String nom, Pays pays, int code, int id)
/*    */   {
/* 24 */     super(nom, pays, id);
/* 25 */     this.code_banque = code;
/* 26 */     this.liste_comptes = new ArrayList();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int getCode_banque()
/*    */   {
/* 33 */     return this.code_banque;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setCode_banque(int code_banque)
/*    */   {
/* 41 */     this.code_banque = code_banque;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public ArrayList<Compte_Bancaire> getListe_comptes()
/*    */   {
/* 48 */     return this.liste_comptes;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setListe_comptes(ArrayList<Compte_Bancaire> cb_array)
/*    */   {
/* 56 */     this.liste_comptes = cb_array;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void addCompte(Compte_Bancaire b)
/*    */   {
/* 64 */     this.liste_comptes.add(b);
/*    */   }
/*    */ }


/* Location:              D:\Users\ZeMachine\Scolaire\ET3S5\Java\projet.jar!\et3\fraude\moteur_jeu\Banque.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */