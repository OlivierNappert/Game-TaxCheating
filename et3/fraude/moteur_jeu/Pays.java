/*    */ package et3.fraude.moteur_jeu;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Pays
/*    */ {
/*    */   private int id_pays;
/*    */   
/*    */ 
/*    */ 
/*    */   private String nom;
/*    */   
/*    */ 
/*    */   private Enqueteur enqueteur;
/*    */   
/*    */ 
/*    */ 
/*    */   public Pays(String nomPays, int id)
/*    */   {
/* 21 */     this.nom = nomPays;
/* 22 */     this.id_pays = id;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 26 */     return this.nom;
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
/*    */   public Enqueteur getEnqueteur()
/*    */   {
/* 40 */     return this.enqueteur;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setEnqueteur(Enqueteur e)
/*    */   {
/* 48 */     this.enqueteur = e;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int getId_pays()
/*    */   {
/* 55 */     return this.id_pays;
/*    */   }
/*    */ }


/* Location:              D:\Users\ZeMachine\Scolaire\ET3S5\Java\projet.jar!\et3\fraude\moteur_jeu\Pays.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */