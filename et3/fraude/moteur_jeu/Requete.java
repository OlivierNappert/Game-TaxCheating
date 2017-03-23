/*    */ package et3.fraude.moteur_jeu;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Requete
/*    */ {
/*    */   private int temps_attente;
/*    */   
/*    */ 
/*    */ 
/*    */   private String resultat;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public Requete(int attente)
/*    */   {
/* 19 */     this.temps_attente = attente;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int getTemps_attente()
/*    */   {
/* 26 */     return this.temps_attente;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void minusTempsAttente()
/*    */   {
/* 33 */     this.temps_attente -= 1;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String getResultat()
/*    */   {
/* 44 */     return this.resultat;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setResultat(String resultat)
/*    */   {
/* 52 */     this.resultat = resultat;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 56 */     return this.resultat + "\n";
/*    */   }
/*    */ }


/* Location:              D:\Users\ZeMachine\Scolaire\ET3S5\Java\projet.jar!\et3\fraude\moteur_jeu\Requete.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */