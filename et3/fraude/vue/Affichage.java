/*     */ package et3.fraude.vue;
/*     */ 
/*     */ import et3.fraude.controleur.Jeu;
/*     */ import et3.fraude.controleur.Joueur;
/*     */ import et3.fraude.moteur_jeu.Compte_Bancaire;
/*     */ import et3.fraude.moteur_jeu.Denonciation;
/*     */ import et3.fraude.moteur_jeu.Enqueteur;
/*     */ import et3.fraude.moteur_jeu.Monde;
/*     */ import et3.fraude.moteur_jeu.Registre_Central;
/*     */ import et3.fraude.moteur_jeu.Requete;
/*     */ import et3.fraude.moteur_jeu.Transaction_Bancaire;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Affichage
/*     */ {
/*     */   Monde world;
/*     */   Jeu game;
/*     */   
/*     */   public Affichage(Monde monde, Jeu jeu)
/*     */   {
/*  25 */     this.world = monde;
/*  26 */     this.game = jeu;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void afficherRegles()
/*     */   {
/*  33 */     System.out.println("\t\tREGLES DU JEU\t");
/*  34 */     System.out.println("--------------------------------------------------");
/*  35 */     System.out.println("Vous êtes un enquêteur fiscal et avez à disposition une liste de " + this.world.getNombreTransactions() + 
/*  36 */       " Transactions Bancaires suspectes.\n" + 
/*  37 */       "Cette liste est accessible a tout moment et est publiée par le Registre Central.");
/*  38 */     System.out.println("Le but du jeu est de remonter cette liste afin de trouver les personnes Contribuables qui sont propriétaires indirectement des comptes suspects, et de les dénoncer.");
/*  39 */     System.out.println("Chaque joueur peut effectuer " + Jeu.getNombreActions() + " actions par tour. Obtenir des informations enlève un point d'action, et Emettre une dénonciation en enlève 2.");
/*  40 */     System.out.println("Cependant, les autres actions comme la consultation du Registre Central n'enlèvent pas de points d'action.\n");
/*  41 */     System.out.println("Tous les enqueteurs commencent avec 10 000$, le gagnant est celui qui gagne le plus grand montant de récompenses.\n");
/*  42 */     System.out.println("Terminologie employée : ");
/*  43 */     System.out.println("Les noms des Entreprises (Sociétés et Banques) sont en MAJUSCULE et suivis d'un Pays de résidence et de leur ID.\nExemple : TOTAL (France) Id Société : 4");
/*  44 */     System.out.println("Un Contribuable est représenté par son nom en MAJUSCULE et son Prénom en Minuscule, ainsi que son Pays.\nExemple : BROOKS Charlotte (Royaume-Uni)");
/*  45 */     System.out.println("");
/*  46 */     System.out.println("Astuce : Concentrez vous sur une transaction à la fois, et utilisez bien vos points d'actions.");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void afficherRegistre()
/*     */   {
/*  53 */     System.out.println("");
/*     */     
/*  55 */     System.out.println("\t     REGISTRE CENTRAL\t");
/*  56 */     System.out.println("--------------------------------------------------");
/*  57 */     System.out.println("\t   TRANSACTIONS SUSPECTES\t");
/*  58 */     System.out.println("--------------------------------------------------");
/*  59 */     System.out.println("Compte n°  Code Banque  Montant  ID Transaction");
/*  60 */     for (int i = 0; i < this.world.getRegistre().getListeTransactionSuspectes().size(); i++) {
/*  61 */       System.out.println(((Transaction_Bancaire)this.world.getRegistre().getListeTransactionSuspectes().get(i)).toString());
/*     */     }
/*  63 */     System.out.println("");
/*  64 */     System.out.println("--------------------------------------------------");
/*  65 */     System.out.println("\t   DENONCIATIONS DE LA VEILLE\t");
/*  66 */     System.out.println("--------------------------------------------------");
/*  67 */     System.out.println("Enqueteur     ID Transaction       Piste\n");
/*  68 */     for (int i = 0; i < this.world.getRegistre().getListeDenonc().size(); i++) {
/*  69 */       System.out.println(((Denonciation)this.world.getRegistre().getListeDenonc().get(i)).toString());
/*     */     }
/*  71 */     System.out.println("");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void choixNbJoueurs()
/*     */   {
/*  78 */     System.out.println("\n\n\t    DEBUT DE LA PARTIE\t");
/*  79 */     System.out.println("--------------------------------------------------");
/*  80 */     System.out.println("Combien de joueurs doit il y avoir dans la partie ?");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void choixJoueursHumains()
/*     */   {
/*  87 */     System.out.println("Combien de joueurs sont contrôlés pas des humains ?");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void afficherEnqueteurs()
/*     */   {
/*  94 */     System.out.println("\nVoici les enqueteurs à votre disposition :");
/*  95 */     for (int i = 0; i < this.world.getListe_enqueteurs().size(); i++) {
/*  96 */       System.out.println(((Enqueteur)this.world.getListe_enqueteurs().get(i)).toString());
/*     */     }
/*  98 */     System.out.println("");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void recapJoueurs()
/*     */   {
/* 105 */     System.out.println("\nVoici le récapitulatif des joueurs :\n");
/* 106 */     for (int i = 0; i < this.game.getJoueurs().size(); i++) {
/* 107 */       System.out.println(((Joueur)this.game.getJoueurs().get(i)).toString());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEnqueteurJoueur(int num_joueur)
/*     */   {
/* 116 */     System.out.println("Joueur " + num_joueur + ", choisissez un enquêteur en indiquant son matricule :");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void afficherPointsAction(int index)
/*     */   {
/* 124 */     System.out.println("Vous pouvez encore effectuer " + ((Joueur)this.game.getJoueurs().get(index)).getPoints_action() + " actions ce tour.\n");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void afficherDebutTour(int index)
/*     */   {
/* 132 */     System.out.println("\n\t    TOUR DU JOUEUR " + ((Joueur)this.game.getJoueurs().get(index)).getId_joueur() + "\t");
/* 133 */     System.out.println("------------------------------------------------");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void afficherJour()
/*     */   {
/* 140 */     System.out.println("\n---------------- JOUR " + this.game.getJour() + " -----------------");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void afficherActions()
/*     */   {
/* 147 */     System.out.println("Choisissez une action :");
/* 148 */     System.out.println("1. Obtenir des informations.");
/* 149 */     System.out.println("2. Emettre une dénonciation.");
/* 150 */     System.out.println("3. Consulter le Registre Central.");
/* 151 */     System.out.println("4. Consulter la liste des joueurs.");
/* 152 */     System.out.println("5. Consulter les réponses reçues.");
/* 153 */     System.out.println("6. Passer votre tour.");
/* 154 */     System.out.println("7. Mettre fin à la partie.");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void afficherListeSollicitation()
/*     */   {
/* 161 */     System.out.println("\nChoisissez une des sollicitations disponibles :");
/* 162 */     System.out.println("1. Obtenir le propriétaire d'un compte bancaire.");
/* 163 */     System.out.println("2. Obtenir le propriétaire d'une société.");
/* 164 */     System.out.println("3. Obtenir les sociétés détenues par une société.");
/* 165 */     System.out.println("4. Revenir au menu précédent.");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void indiquerCodeBanque()
/*     */   {
/* 172 */     System.out.println("Indiquez le code de la banque :");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void indiquerNumeroCompte()
/*     */   {
/* 179 */     System.out.println("Indiquez le numéro de compte :");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void indiquerMatricule()
/*     */   {
/* 186 */     System.out.println("Indiquez le matricule de l'enquêteur :");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void indiquerIdSociete()
/*     */   {
/* 193 */     System.out.println("Indiquez l'id de la société :");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void confirmerSollicitation()
/*     */   {
/* 200 */     System.out.println("\nVotre demande à bien été prise en compte.");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void indiquerDelai(Requete req, boolean denonciation)
/*     */   {
/* 209 */     String s = "";
/* 210 */     if (denonciation) {
/* 211 */       s = s + "dénonciation";
/*     */     }
/*     */     else {
/* 214 */       s = s + "requête";
/*     */     }
/*     */     
/* 217 */     System.out.println("Vous recevrez la réponse à votre " + s + " le Jour " + (this.game.getJour() + req.getTemps_attente()) + ".\n");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void afficherResultat(String s)
/*     */   {
/* 225 */     System.out.println("\nNOUVEAU MESSAGE !\n" + s);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void afficherAnciens(ArrayList<Requete> req)
/*     */   {
/* 233 */     System.out.println("\nRésultat des requêtes précédentes :");
/* 234 */     for (int i = 0; i < req.size(); i++) {
/* 235 */       if (((Requete)req.get(i)).getTemps_attente() <= 0)
/* 236 */         System.out.println(((Requete)req.get(i)).getResultat());
/*     */     }
/* 238 */     System.out.println("");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void renseignerChaine(int num)
/*     */   {
/* 246 */     System.out.println("Entrez ci dessous la chaîne " + num + " :");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void renseignerNumTrans()
/*     */   {
/* 253 */     System.out.println("Entrez ci dessous le numéro de transaction :");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void afficherDenoncer()
/*     */   {
/* 260 */     System.out.println("\nVous souhaitez dénoncer un contribuable.");
/* 261 */     System.out.println("Pour cela vous devez rentrer les informations suivantes :");
/* 262 */     System.out.println("- L'ID de la Transaction à partir de laquelle vous avez trouvé le contribuable ( voir Registre Central ).");
/* 263 */     System.out.println("- Les chaînes des sociétés, en partant du premier propriétaire ( Compte initial ) jusqu'au contribuable.");
/* 264 */     System.out.println("Une chaîne sera formée par les ID des sociétés, séparés par une virgule( sans espaces ), ainsi que du Nom du Contribuable suspect en Majuscule.");
/* 265 */     System.out.println("Exemple de chaîne :\n1,2,3,CAPONE");
/* 266 */     System.out.println("Vous trouverez ci dessus des informations pouvant vous aider pour former les chaînes.\n");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void classement()
/*     */   {
/* 273 */     System.out.println("");
/* 274 */     System.out.println("--------------------------------------------------");
/* 275 */     System.out.println("\t   CLASSEMENT FINAL\t");
/* 276 */     System.out.println("--------------------------------------------------");
/* 277 */     System.out.println("Enqueteur     Nombre de dénonciations       Solde\n");
/*     */     
/* 279 */     for (int i = 0; i < this.game.getJoueurs().size(); i++) {
/* 280 */       System.out.println(((Joueur)this.game.getJoueurs().get(i)).getEnqueteur().getNom() + " " + ((Joueur)this.game.getJoueurs().get(i)).getEnqueteur().getPrenom() + 
/* 281 */         "\t\t" + ((Joueur)this.game.getJoueurs().get(i)).getEnqueteur().getNombre_denonciations() + 
/* 282 */         "\t\t    " + ((Joueur)this.game.getJoueurs().get(i)).getEnqueteur().getCompte_bancaire().getSolde() + "$");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void finPartie()
/*     */   {
/* 290 */     System.out.println("\nLa partie est terminée, merci d'avoir joué !");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void choiceError(int maxVal)
/*     */   {
/* 298 */     System.out.println("Ce choix n'est pas valide, merci de rentrer un nombre entre 1 et " + maxVal + ".");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void matriculeError()
/*     */   {
/* 305 */     System.out.println("Cet enqueteur est déjà affecté à un autre joueur, merci d'en choisir un autre.");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void formatError()
/*     */   {
/* 312 */     System.out.println("Cette entrée n'est pas valide, rentrez un nombre svp.");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void codeError()
/*     */   {
/* 319 */     System.out.println("Ce code banque est incorrect, recommencez svp.");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void accountError()
/*     */   {
/* 326 */     System.out.println("Ce numéro de compte est incorrect, recommencez svp.");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void transacError()
/*     */   {
/* 333 */     System.out.println("Ce numéro de transaction est incorrect, recommencez svp.");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void idError()
/*     */   {
/* 340 */     System.out.println("Cet identifiant de société est incorrect, recommencez svp.");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void idErrorChaine()
/*     */   {
/* 347 */     System.out.println("L'un des ID saisit n'existe pas ou est entré en double (impossible), recommencez svp.");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void chaineError()
/*     */   {
/* 354 */     System.out.println("Votre chaîne est incomplète, recommencez svp.");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void errorNombreJoueurs(boolean humain)
/*     */   {
/* 363 */     if (humain) {
/* 364 */       System.out.println("Le nombre de joueurs humains doit être compris entre 1 et " + this.world.getNombre_joueurs() + ", recommencez svp.");
/*     */     }
/*     */     else
/*     */     {
/* 368 */       System.out.println("Le nombre de joueurs doit être compris entre 1 et " + this.world.getNombreJoueursMax() + ", recommencez svp.");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void matriculeNumberError()
/*     */   {
/* 376 */     System.out.println("Ce matricule n'est pas dans la liste, recommencez svp.");
/*     */   }
/*     */ }


/* Location:              D:\Users\ZeMachine\Scolaire\ET3S5\Java\projet.jar!\et3\fraude\vue\Affichage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */