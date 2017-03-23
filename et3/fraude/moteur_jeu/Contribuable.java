/*    */ package et3.fraude.moteur_jeu;
/*    */ 
/*    */ import java.util.Date;
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
/*    */ public class Contribuable
/*    */   extends Proprietaire
/*    */ {
/*    */   protected String prenom;
/*    */   protected Date date_naissance;
/*    */   
/*    */   public Contribuable(String nom, String pren, Date date_naiss, Pays pays)
/*    */   {
/* 24 */     super(nom, pays);
/* 25 */     this.prenom = pren;
/* 26 */     this.date_naissance = date_naiss;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 30 */     return this.nom + " " + this.prenom + " (" + this.pays_residence + ")";
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public String getPrenom()
/*    */   {
/* 37 */     return this.prenom;
/*    */   }
/*    */ }


/* Location:              D:\Users\ZeMachine\Scolaire\ET3S5\Java\projet.jar!\et3\fraude\moteur_jeu\Contribuable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */