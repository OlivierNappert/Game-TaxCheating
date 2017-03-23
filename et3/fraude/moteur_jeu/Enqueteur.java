/*     */ package et3.fraude.moteur_jeu;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Enqueteur
/*     */   extends Contribuable
/*     */ {
/*     */   private int nombre_denonciations;
/*     */   private int id_enqueteur;
/*     */   private ArrayList<Requete> liste_requetes;
/*     */   
/*     */   public Enqueteur(String nom, String pren, Date date_naiss, Pays pays, int id)
/*     */   {
/*  27 */     super(nom, pren, date_naiss, pays);
/*  28 */     this.id_enqueteur = id;
/*  29 */     this.liste_requetes = new ArrayList();
/*  30 */     pays.setEnqueteur(this);
/*     */   }
/*     */   
/*     */   public String toString() {
/*  34 */     return this.nom + " " + this.prenom + " (" + this.pays_residence + ") Matricule : " + this.id_enqueteur;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getNombre_denonciations()
/*     */   {
/*  41 */     return this.nombre_denonciations;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNombre_denonciations(int nombre_denonciations)
/*     */   {
/*  49 */     this.nombre_denonciations = nombre_denonciations;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void addDenonciation()
/*     */   {
/*  56 */     this.nombre_denonciations += 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getId_enqueteur()
/*     */   {
/*  63 */     return this.id_enqueteur;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId_enqueteur(int id_enqueteur)
/*     */   {
/*  71 */     this.id_enqueteur = id_enqueteur;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ArrayList<Requete> getListe_requetes()
/*     */   {
/*  78 */     return this.liste_requetes;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String solliciterBanque(int id_trans, int code_banque, int num_compte)
/*     */   {
/*  90 */     Proprietaire p = null;
/*  91 */     String s = "Transaction n°" + id_trans + " : Le proprietaire du compte n°" + num_compte + " (Code banque: " + code_banque + ") est : ";
/*  92 */     for (int i = 0; i < Monde.getListe_banques().size(); i++) {
/*  93 */       if (((Compte_Bancaire)((Banque)Monde.getListe_banques().get(code_banque - 1)).getListe_comptes().get(i)).getIdentifiant_unique() == num_compte) {
/*  94 */         p = ((Compte_Bancaire)((Banque)Monde.getListe_banques().get(code_banque - 1)).getListe_comptes().get(i)).getProprietaire();
/*  95 */         break;
/*     */       }
/*     */     }
/*     */     
/*  99 */     return s + p.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getProprietaireSociete(int id_societe)
/*     */   {
/* 109 */     String v = "";
/* 110 */     String s = "";
/*     */     
/* 112 */     for (int i = 0; i < Monde.getListe_allCompagnies().size(); i++)
/*     */     {
/* 114 */       if (((Societe)Monde.getListe_allCompagnies().get(i)).getId_societe() == id_societe) {
/* 115 */         s = ((Societe)Monde.getListe_allCompagnies().get(i)).getProprietaire().toString();
/* 116 */         v = ((Societe)Monde.getListe_allCompagnies().get(i)).getNom();
/* 117 */         break;
/*     */       }
/*     */     }
/*     */     
/* 121 */     String u = "Proprietaire de " + v + " : " + s;
/*     */     
/* 123 */     return u;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getListeFilliales(int id_societe)
/*     */   {
/* 133 */     ArrayList<Societe> array = null;
/* 134 */     String v = "";
/*     */     
/* 136 */     for (int i = 0; i < Monde.getListe_allCompagnies().size(); i++)
/*     */     {
/* 138 */       if (((Societe)Monde.getListe_allCompagnies().get(i)).getId_societe() == id_societe) {
/* 139 */         array = ((Societe)Monde.getListe_allCompagnies().get(i)).getListe_societes();
/* 140 */         v = ((Societe)Monde.getListe_allCompagnies().get(i)).getNom();
/* 141 */         break;
/*     */       }
/*     */     }
/*     */     
/* 145 */     String s = "Liste des societes possédées par " + v + " :\n";
/*     */     
/* 147 */     for (int i = 0; i < array.size(); i++) {
/* 148 */       s = s + ((Societe)array.get(i)).toString() + "\n";
/*     */     }
/* 150 */     return s;
/*     */   }
/*     */ }


/* Location:              D:\Users\ZeMachine\Scolaire\ET3S5\Java\projet.jar!\et3\fraude\moteur_jeu\Enqueteur.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */