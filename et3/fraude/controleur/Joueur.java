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
/*    */ public class Joueur
/*    */ {
/*    */   protected int id_joueur;
/*    */   protected Enqueteur enqueteur;
/*    */   protected int points_action;
/*    */   
/*    */   public Joueur()
/*    */   {
/* 21 */     this.points_action = 2;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 25 */     return "Joueur numéro " + this.id_joueur + ", enquêteur : " + this.enqueteur.toString();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Joueur(int id, int pa)
/*    */   {
/* 34 */     this.id_joueur = id;
/* 35 */     this.points_action = pa;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int getId_joueur()
/*    */   {
/* 42 */     return this.id_joueur;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setId_joueur(int id_joueur)
/*    */   {
/* 50 */     this.id_joueur = id_joueur;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public Enqueteur getEnqueteur()
/*    */   {
/* 57 */     return this.enqueteur;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setEnqueteur(Enqueteur enqueteur)
/*    */   {
/* 65 */     this.enqueteur = enqueteur;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int getPoints_action()
/*    */   {
/* 72 */     return this.points_action;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setPoints_action(int points_action)
/*    */   {
/* 80 */     this.points_action = points_action;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void minusPoint_action()
/*    */   {
/* 87 */     this.points_action -= 1;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void addPoint_action()
/*    */   {
/* 94 */     this.points_action += 1;
/*    */   }
/*    */ }


/* Location:              D:\Users\ZeMachine\Scolaire\ET3S5\Java\projet.jar!\et3\fraude\controleur\Joueur.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */