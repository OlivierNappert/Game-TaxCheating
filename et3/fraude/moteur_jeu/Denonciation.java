/*     */ package et3.fraude.moteur_jeu;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Denonciation
/*     */ {
/*     */   private Enqueteur enqueteur;
/*     */   private int id_enqueteur;
/*     */   private int id_transaction;
/*     */   private String chaine_1;
/*     */   private String chaine_2;
/*     */   private int jour;
/*     */   
/*     */   public Denonciation(Enqueteur enqu)
/*     */   {
/*  23 */     this.enqueteur = enqu;
/*  24 */     this.id_enqueteur = enqu.getId_enqueteur();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getJour()
/*     */   {
/*  31 */     return this.jour;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setJour(int jour)
/*     */   {
/*  39 */     this.jour = jour;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getId_enqueteur()
/*     */   {
/*  46 */     return this.id_enqueteur;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getId_transaction()
/*     */   {
/*  53 */     return this.id_transaction;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId_transaction(int id_transaction)
/*     */   {
/*  61 */     this.id_transaction = id_transaction;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getChaine_1()
/*     */   {
/*  68 */     return this.chaine_1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setChaine_1(String chaine_societe)
/*     */   {
/*  76 */     this.chaine_1 = chaine_societe;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getChaine_2()
/*     */   {
/*  83 */     return this.chaine_2;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setChaine_2(String chaine_societe)
/*     */   {
/*  91 */     this.chaine_2 = chaine_societe;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     String[] temp_1 = this.chaine_1.split(",");
/*  96 */     String[] temp_2 = this.chaine_2.split(",");
/*  97 */     String piste_1 = "";
/*  98 */     String piste_2 = "";
/*     */     
/* 100 */     for (int i = 0; i < temp_1.length; i++) {
/* 101 */       if (i < temp_1.length - 1) {
/* 102 */         for (int j = 0; j < Monde.getListe_allCompagnies().size(); j++) {
/* 103 */           if (((Societe)Monde.getListe_allCompagnies().get(j)).getId_societe() == Integer.parseInt(temp_1[i])) {
/* 104 */             piste_1 = piste_1 + ((Societe)Monde.getListe_allCompagnies().get(j)).getNom() + " -> ";
/* 105 */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       } else {
/* 110 */         piste_1 = piste_1 + temp_1[i].toUpperCase();
/*     */       }
/*     */     }
/*     */     
/* 114 */     for (int i = 0; i < temp_2.length; i++) {
/* 115 */       if (i < temp_2.length - 1) {
/* 116 */         for (int j = 0; j < Monde.getListe_allCompagnies().size(); j++) {
/* 117 */           if (((Societe)Monde.getListe_allCompagnies().get(j)).getId_societe() == Integer.parseInt(temp_2[i])) {
/* 118 */             piste_2 = piste_2 + ((Societe)Monde.getListe_allCompagnies().get(j)).getNom() + " -> ";
/* 119 */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       } else {
/* 124 */         piste_2 = piste_2 + temp_2[i].toUpperCase();
/*     */       }
/*     */     }
/*     */     
/* 128 */     String s1 = this.enqueteur.getNom() + " " + this.enqueteur.getPrenom() + "\t  " + this.id_transaction + "         " + piste_1;
/* 129 */     String s2 = this.enqueteur.getNom() + " " + this.enqueteur.getPrenom() + "\t  " + this.id_transaction + "         " + piste_2;
/*     */     
/* 131 */     return s1 + "\n" + s2 + "\n";
/*     */   }
/*     */ }


/* Location:              D:\Users\ZeMachine\Scolaire\ET3S5\Java\projet.jar!\et3\fraude\moteur_jeu\Denonciation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */