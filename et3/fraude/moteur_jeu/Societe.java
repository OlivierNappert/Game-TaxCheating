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
/*    */ public class Societe
/*    */   extends Proprietaire
/*    */ {
/*    */   protected Proprietaire proprietaire;
/*    */   protected int id_societe;
/*    */   
/*    */   public Societe(String nom, Pays pays, int id)
/*    */   {
/* 21 */     super(nom, pays);
/* 22 */     this.id_societe = id;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 26 */     return this.nom + " (" + this.pays_residence + ") ID Societe : " + this.id_societe;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public Proprietaire getProprietaire()
/*    */   {
/* 33 */     return this.proprietaire;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setProprietaire(Proprietaire proprietaire)
/*    */   {
/* 41 */     this.proprietaire = proprietaire;
/* 42 */     proprietaire.liste_societes.add(this);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int getId_societe()
/*    */   {
/* 49 */     return this.id_societe;
/*    */   }
/*    */ }


/* Location:              D:\Users\ZeMachine\Scolaire\ET3S5\Java\projet.jar!\et3\fraude\moteur_jeu\Societe.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */