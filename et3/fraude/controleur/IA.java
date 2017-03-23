/*    */ package et3.fraude.controleur;
/*    */ 
/*    */ import et3.fraude.moteur_jeu.Enqueteur;
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
/*    */ public class IA
/*    */   extends Joueur
/*    */ {
/*    */   public IA() {}
/*    */   
/*    */   public IA(int id, int pa)
/*    */   {
/* 23 */     super(id, pa);
/*    */   }
/*    */   
/*    */   public String toString() {
/* 27 */     return "Joueur " + this.id_joueur + " (IA), enquêteur : " + this.enqueteur.toString();
/*    */   }
/*    */ }


/* Location:              D:\Users\ZeMachine\Scolaire\ET3S5\Java\projet.jar!\et3\fraude\controleur\IA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */