/*     */ package et3.fraude.controleur;
/*     */ 
/*     */ import et3.fraude.moteur_jeu.Contribuable;
/*     */ import et3.fraude.moteur_jeu.Denonciation;
/*     */ import et3.fraude.moteur_jeu.Enqueteur;
/*     */ import et3.fraude.moteur_jeu.Monde;
/*     */ import et3.fraude.moteur_jeu.Pays;
/*     */ import et3.fraude.moteur_jeu.Registre_Central;
/*     */ import et3.fraude.moteur_jeu.Requete;
/*     */ import et3.fraude.moteur_jeu.Societe;
/*     */ import et3.fraude.moteur_jeu.Transaction_Bancaire;
/*     */ import et3.fraude.vue.Affichage;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Scanner;
/*     */ 
/*     */ public class Jeu
/*     */ {
/*     */   private Monde world;
/*     */   private Affichage vue;
/*     */   private ArrayList<Joueur> joueurs;
/*     */   private Scanner sc;
/*     */   private static final int nombre_actions = 2;
/*  23 */   private int jour = 1;
/*     */   
/*     */ 
/*     */ 
/*     */   public Jeu()
/*     */   {
/*  29 */     this.world = new Monde();
/*  30 */     this.vue = new Affichage(this.world, this);
/*  31 */     this.joueurs = new ArrayList();
/*  32 */     this.sc = new Scanner(System.in);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ArrayList<Joueur> getJoueurs()
/*     */   {
/*  39 */     return this.joueurs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static int getNombreActions()
/*     */   {
/*  46 */     return 2;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getJour()
/*     */   {
/*  53 */     return this.jour;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void init()
/*     */   {
/*  64 */     this.vue.afficherRegles();
/*     */     
/*  66 */     this.vue.choixNbJoueurs();
/*  67 */     setNombreJoueurs();
/*     */     
/*  69 */     this.vue.choixJoueursHumains();
/*  70 */     setNombreHumains();
/*     */     
/*  72 */     this.world.init();
/*     */     
/*  74 */     this.vue.afficherEnqueteurs();
/*  75 */     setEnqueteurs();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setNombreJoueurs()
/*     */   {
/*  82 */     int nb_joueurs = 0;
/*     */     do {
/*  84 */       if (nb_joueurs > this.world.getNombreJoueursMax()) {
/*  85 */         this.vue.errorNombreJoueurs(false);
/*     */       }
/*     */       try {
/*  88 */         nb_joueurs = Integer.parseInt(this.sc.nextLine());
/*     */       }
/*     */       catch (NumberFormatException e) {
/*  91 */         this.vue.formatError();
/*  92 */         nb_joueurs = Integer.parseInt(this.sc.nextLine());
/*     */       }
/*  83 */     } while (
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
/*  95 */       nb_joueurs > this.world.getNombreJoueursMax());
/*     */     
/*  97 */     this.world.setNombre_joueurs(nb_joueurs);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setNombreHumains()
/*     */   {
/* 104 */     int nb_humains = 1;
/*     */     do {
/* 106 */       if ((nb_humains > this.world.getNombre_joueurs()) || (nb_humains < 1)) {
/* 107 */         this.vue.errorNombreJoueurs(true);
/*     */       }
/*     */       try {
/* 110 */         nb_humains = Integer.parseInt(this.sc.nextLine());
/*     */       }
/*     */       catch (NumberFormatException e) {
/* 113 */         this.vue.formatError();
/* 114 */         nb_humains = Integer.parseInt(this.sc.nextLine());
/*     */       }
/* 116 */     } while ((nb_humains > this.world.getNombre_joueurs()) || (nb_humains < 1));
/*     */     
/* 118 */     this.world.setNombre_joueurs_humain(nb_humains);
/* 119 */     createPlayers();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void createPlayers()
/*     */   {
/* 126 */     for (int i = 0; i < this.world.getNombre_joueurs(); i++) {
/* 127 */       if (i < this.world.getNombre_joueurs_humain()) {
/* 128 */         Joueur joueur = new Joueur(i + 1, 2);
/* 129 */         this.joueurs.add(joueur);
/*     */       }
/*     */       else {
/* 132 */         IA joueur = new IA(i + 1, 2);
/* 133 */         this.joueurs.add(joueur);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEnqueteurs()
/*     */   {
/* 143 */     ArrayList<Integer> id_array = new ArrayList();
/* 144 */     int matricule = 0;
/*     */     
/* 146 */     for (int i = 0; i < this.world.getNombre_joueurs(); i++) {
/*     */       do {
/* 148 */         if (i < this.world.getNombre_joueurs_humain()) {
/* 149 */           this.vue.setEnqueteurJoueur(i + 1);
/*     */           do {
/*     */             try {
/* 152 */               matricule = Integer.parseInt(this.sc.nextLine());
/*     */             }
/*     */             catch (NumberFormatException e) {
/* 155 */               this.vue.formatError();
/* 156 */               matricule = Integer.parseInt(this.sc.nextLine());
/*     */             }
/* 158 */             if (matricule > this.world.getNombre_joueurs()) {
/* 159 */               this.vue.matriculeNumberError();
/*     */             }
/* 150 */           } while (
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
/* 162 */             matricule > this.world.getNombre_joueurs());
/*     */           
/* 164 */           if (Monde.idUsed(id_array, matricule)) {
/* 165 */             this.vue.matriculeError();
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 170 */           matricule = this.world.randBetween(1, this.world.getNombre_joueurs());
/*     */         }
/*     */         
/* 173 */       } while (Monde.idUsed(id_array, matricule));
/*     */       
/* 175 */       ((Joueur)this.joueurs.get(i)).setEnqueteur((Enqueteur)this.world.getListe_enqueteurs().get(matricule - 1));
/* 176 */       id_array.add(Integer.valueOf(matricule));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void solliciter(Joueur joueur)
/*     */   {
/* 185 */     this.vue.afficherListeSollicitation();
/* 186 */     int choix = 0;
/* 187 */     boolean error = true;
/*     */     
/* 189 */     while (error) {
/*     */       try {
/*     */         do {
/* 192 */           choix = Integer.parseInt(this.sc.nextLine());
/* 193 */           if ((choix < 1) || (choix > 4)) {
/* 194 */             this.vue.choiceError(4);
/*     */           }
/* 196 */         } while ((choix < 1) || (choix > 4));
/* 197 */         error = false;
/*     */       }
/*     */       catch (NumberFormatException e) {
/* 200 */         this.vue.formatError();
/*     */       }
/*     */     }
/*     */     
/* 204 */     error = true;
/*     */     
/* 206 */     switch (choix) {
/*     */     case 1: 
/* 208 */       int code_banque = -1;int num_compte = -1;
/*     */       
/* 210 */       this.vue.indiquerCodeBanque();
/* 211 */       while (error) {
/*     */         try {
/*     */           do {
/* 214 */             code_banque = Integer.parseInt(this.sc.nextLine());
/* 215 */             if (!this.world.correctCode(code_banque)) {
/* 216 */               this.vue.codeError();
/*     */             }
/*     */             
/* 219 */           } while (!this.world.correctCode(code_banque));
/*     */           
/* 221 */           error = false;
/*     */         }
/*     */         catch (NumberFormatException e) {
/* 224 */           this.vue.formatError();
/*     */         }
/*     */       }
/*     */       
/* 228 */       error = true;
/*     */       
/* 230 */       this.vue.indiquerNumeroCompte();
/* 231 */       while (error) {
/*     */         try {
/*     */           do {
/* 234 */             num_compte = Integer.parseInt(this.sc.nextLine());
/* 235 */             if (!this.world.correctAccountNumber(code_banque, num_compte)) {
/* 236 */               this.vue.accountError();
/*     */             }
/*     */             
/* 239 */           } while (!this.world.correctAccountNumber(code_banque, num_compte));
/*     */           
/* 241 */           error = false;
/*     */         }
/*     */         catch (NumberFormatException e) {
/* 244 */           this.vue.formatError();
/*     */         }
/*     */       }
/* 247 */       int id_trans = 0;
/*     */       
/* 249 */       for (int i = 0; i < this.world.getRegistre().getListeTransactionSuspectes().size(); i++) {
/* 250 */         if ((((Transaction_Bancaire)this.world.getRegistre().getListeTransactionSuspectes().get(i)).getCompte_destination().getIdentifiant_unique() == num_compte) || 
/* 251 */           (((Transaction_Bancaire)this.world.getRegistre().getListeTransactionSuspectes().get(i)).getCompte_source().getIdentifiant_unique() == num_compte)) {
/* 252 */           id_trans = ((Transaction_Bancaire)this.world.getRegistre().getListeTransactionSuspectes().get(i)).getId();
/*     */         }
/*     */       }
/*     */       
/* 256 */       int attente = this.world.randBetween(1, 3);
/* 257 */       Requete req = new Requete(attente);
/* 258 */       req.setResultat(joueur.getEnqueteur().solliciterBanque(id_trans, code_banque, num_compte));
/* 259 */       joueur.getEnqueteur().getListe_requetes().add(req);
/* 260 */       this.vue.confirmerSollicitation();
/* 261 */       this.vue.indiquerDelai(req, false);
/* 262 */       break;
/*     */     
/*     */     case 2: 
/* 265 */       this.vue.indiquerIdSociete();
/* 266 */       int id_societe = -1;
/* 267 */       while (error) {
/*     */         try {
/*     */           do {
/* 270 */             id_societe = Integer.parseInt(this.sc.nextLine());
/* 271 */             if (!this.world.correctSocietyID(id_societe)) {
/* 272 */               this.vue.idError();
/*     */             }
/*     */             
/* 275 */           } while (!this.world.correctSocietyID(id_societe));
/*     */           
/* 277 */           error = false;
/*     */         }
/*     */         catch (NumberFormatException e) {
/* 280 */           this.vue.formatError();
/*     */         }
/*     */       }
/*     */       
/* 284 */       int id_pays_sollicite = -1;
/* 285 */       for (int i = 0; i < Monde.getListe_allCompagnies().size(); i++) {
/* 286 */         if (((Societe)Monde.getListe_allCompagnies().get(i)).getId_societe() == id_societe) {
/* 287 */           id_pays_sollicite = ((Societe)Monde.getListe_allCompagnies().get(i)).getPays_residence().getId_pays();
/* 288 */           break;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 294 */       int id_pays_enqueteur = joueur.getEnqueteur().getPays_residence().getId_pays();
/* 295 */       int attente_1 = -1;
/*     */       
/* 297 */       for (int i = 0; i < this.joueurs.size(); i++) {
/* 298 */         if (((Joueur)this.joueurs.get(i)).getEnqueteur().getPays_residence().getId_pays() == id_pays_sollicite) {
/* 299 */           if (id_pays_sollicite >= id_pays_enqueteur) {
/* 300 */             attente_1 = this.world.getFacteurs_coop()[(id_pays_sollicite - 1)][(id_pays_enqueteur - 1)];
/*     */           }
/*     */           else {
/* 303 */             attente_1 = this.world.getFacteurs_coop()[(id_pays_enqueteur - 1)][(id_pays_sollicite - 1)];
/*     */           }
/* 305 */           if ((attente_1 > 2) && (((Joueur)this.joueurs.get(i)).getEnqueteur().getNombre_denonciations() > 10)) {
/* 306 */             attente_1--;
/*     */           }
/*     */           
/* 309 */           Requete req_1 = new Requete(attente_1);
/* 310 */           req_1.setResultat(joueur.getEnqueteur().getProprietaireSociete(id_societe));
/* 311 */           joueur.getEnqueteur().getListe_requetes().add(req_1);
/* 312 */           this.vue.confirmerSollicitation();
/* 313 */           this.vue.indiquerDelai(req_1, false);
/* 314 */           break;
/*     */         }
/*     */       }
/* 317 */       break;
/*     */     
/*     */     case 3: 
/* 320 */       this.vue.indiquerIdSociete();
/* 321 */       int id_societe_2 = -1;
/* 322 */       while (error) {
/*     */         try {
/*     */           do {
/* 325 */             id_societe_2 = Integer.parseInt(this.sc.nextLine());
/* 326 */             if (!this.world.correctSocietyID(id_societe_2)) {
/* 327 */               this.vue.idError();
/*     */             }
/*     */             
/* 330 */           } while (!this.world.correctSocietyID(id_societe_2));
/*     */           
/* 332 */           error = false;
/*     */         }
/*     */         catch (NumberFormatException e) {
/* 335 */           this.vue.formatError();
/*     */         }
/*     */       }
/*     */       
/* 339 */       int id_pays_sollicite_2 = -1;
/* 340 */       for (int i = 0; i < Monde.getListe_allCompagnies().size(); i++) {
/* 341 */         if (((Societe)Monde.getListe_allCompagnies().get(i)).getId_societe() == id_societe_2) {
/* 342 */           id_pays_sollicite_2 = ((Societe)Monde.getListe_allCompagnies().get(i)).getPays_residence().getId_pays();
/* 343 */           break;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 349 */       int id_pays_enqueteur_2 = joueur.getEnqueteur().getPays_residence().getId_pays();
/* 350 */       int attente_2 = -1;
/*     */       
/* 352 */       for (int i = 0; i < this.joueurs.size(); i++) {
/* 353 */         if (((Joueur)this.joueurs.get(i)).getEnqueteur().getPays_residence().getId_pays() == id_pays_sollicite_2) {
/* 354 */           if (id_pays_sollicite_2 >= id_pays_enqueteur_2) {
/* 355 */             attente_2 = this.world.getFacteurs_coop()[(id_pays_sollicite_2 - 1)][(id_pays_enqueteur_2 - 1)];
/*     */           }
/*     */           else {
/* 358 */             attente_2 = this.world.getFacteurs_coop()[(id_pays_enqueteur_2 - 1)][(id_pays_sollicite_2 - 1)];
/*     */           }
/* 360 */           if ((attente_2 > 2) && (((Joueur)this.joueurs.get(i)).getEnqueteur().getNombre_denonciations() > 10)) {
/* 361 */             attente_2--;
/*     */           }
/*     */           
/* 364 */           Requete req_2 = new Requete(attente_2);
/* 365 */           req_2.setResultat(joueur.getEnqueteur().getListeFilliales(id_societe_2));
/* 366 */           joueur.getEnqueteur().getListe_requetes().add(req_2);
/* 367 */           this.vue.confirmerSollicitation();
/* 368 */           this.vue.indiquerDelai(req_2, false);
/* 369 */           break;
/*     */         }
/*     */       }
/* 372 */       break;
/*     */     
/*     */     case 4: 
/* 375 */       joueur.addPoint_action();
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void denoncer(Joueur joueur)
/*     */   {
/* 385 */     this.vue.afficherAnciens(joueur.getEnqueteur().getListe_requetes());
/* 386 */     this.vue.afficherDenoncer();
/* 387 */     String chaine_1 = "";
/* 388 */     String chaine_2 = "";
/* 389 */     int id_trans = 0;
/* 390 */     boolean error = true;
/*     */     
/* 392 */     this.vue.renseignerNumTrans();
/* 393 */     while (error) {
/*     */       try {
/*     */         do {
/* 396 */           id_trans = Integer.parseInt(this.sc.nextLine());
/* 397 */           if (!this.world.correctTransacNumber(id_trans)) {
/* 398 */             this.vue.transacError();
/*     */           }
/*     */           
/* 401 */         } while (!this.world.correctTransacNumber(id_trans));
/*     */         
/* 403 */         error = false;
/*     */       }
/*     */       catch (NumberFormatException e) {
/* 406 */         this.vue.formatError();
/*     */       }
/*     */     }
/*     */     
/* 410 */     this.vue.renseignerChaine(1);
/*     */     
/* 412 */     error = true;
/* 413 */     while (error) {
/*     */       try
/*     */       {
/*     */         boolean success;
/*     */         do {
/* 418 */           ArrayList<Integer> toCheck = new ArrayList();
/* 419 */           success = true;
/* 420 */           chaine_1 = this.sc.nextLine();
/* 421 */           String[] temp = chaine_1.split(",");
/* 422 */           int[] temp2 = new int[temp.length - 1];
/* 423 */           for (int i = 0; i < temp2.length; i++) {
/* 424 */             temp2[i] = Integer.parseInt(temp[i]);
/* 425 */             if ((!this.world.correctSocietyID(temp2[i])) || (Monde.idUsed(toCheck, temp2[i]))) {
/* 426 */               this.vue.idErrorChaine();
/* 427 */               success = false;
/* 428 */               break;
/*     */             }
/*     */             
/* 431 */             toCheck.add(Integer.valueOf(temp2[i]));
/*     */           }
/*     */           
/* 434 */           if (temp.length == 1) {
/* 435 */             success = false;
/* 436 */             this.vue.chaineError();
/*     */           }
/*     */           
/* 439 */         } while (!success);
/* 440 */         error = false;
/*     */       }
/*     */       catch (NumberFormatException e) {
/* 443 */         this.vue.formatError();
/*     */       }
/*     */     }
/*     */     
/* 447 */     this.vue.renseignerChaine(2);
/*     */     
/* 449 */     error = true;
/* 450 */     while (error) {
/*     */       try
/*     */       {
/*     */         boolean success;
/*     */         do {
/* 455 */           ArrayList<Integer> toCheck = new ArrayList();
/* 456 */           success = true;
/* 457 */           chaine_2 = this.sc.nextLine();
/* 458 */           String[] temp = chaine_2.split(",");
/* 459 */           int[] temp2 = new int[temp.length - 1];
/* 460 */           for (int i = 0; i < temp2.length; i++) {
/* 461 */             temp2[i] = Integer.parseInt(temp[i]);
/* 462 */             if ((!this.world.correctSocietyID(temp2[i])) || (Monde.idUsed(toCheck, temp2[i]))) {
/* 463 */               this.vue.idErrorChaine();
/* 464 */               success = false;
/* 465 */               break;
/*     */             }
/* 467 */             toCheck.add(Integer.valueOf(temp2[i]));
/*     */           }
/* 469 */           if (temp.length == 1) {
/* 470 */             success = false;
/* 471 */             this.vue.chaineError();
/*     */           }
/*     */           
/* 474 */         } while (!success);
/* 475 */         error = false;
/*     */       }
/*     */       catch (NumberFormatException e) {
/* 478 */         this.vue.formatError();
/*     */       }
/*     */     }
/*     */     
/* 482 */     Denonciation denonciation = new Denonciation(joueur.getEnqueteur());
/* 483 */     denonciation.setJour(this.jour);
/* 484 */     denonciation.setChaine_1(chaine_1);
/* 485 */     denonciation.setChaine_2(chaine_2);
/* 486 */     denonciation.setId_transaction(id_trans);
/* 487 */     this.world.getRegistre().getListeDenonc().add(denonciation);
/*     */     
/* 489 */     Requete req = new Requete(1);
/* 490 */     boolean succeed = this.world.denonciationReussie(joueur, denonciation);
/* 491 */     req.setResultat(this.world.reponseAdmin(succeed, denonciation));
/*     */     
/* 493 */     this.vue.confirmerSollicitation();
/* 494 */     this.vue.indiquerDelai(req, true);
/* 495 */     joueur.getEnqueteur().getListe_requetes().add(req);
/* 496 */     joueur.getEnqueteur().addDenonciation();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void denoncerIA(Joueur ia)
/*     */   {
/* 504 */     String chaine_1 = "";
/* 505 */     String chaine_2 = "";
/*     */     
/* 507 */     int randTransac = this.world.randBetween(
/* 508 */       ((Transaction_Bancaire)this.world.getRegistre().getListeTransactionSuspectes().get(0)).getId(), 
/* 509 */       ((Transaction_Bancaire)this.world.getRegistre().getListeTransactionSuspectes().get(this.world.getRegistre().getListeTransactionSuspectes().size() - 1)).getId());
/*     */     
/* 511 */     int randLength = this.world.randBetween(1, 3);
/* 512 */     int[] randTab1 = new int[randLength];
/* 513 */     for (int i = 0; i < randTab1.length; i++) {
/* 514 */       randTab1[i] = this.world.randBetween(0, Monde.getListe_allCompagnies().size() - 1);
/* 515 */       chaine_1 = chaine_1 + Integer.toString(randTab1[i]) + ",";
/*     */     }
/*     */     
/* 518 */     randLength = this.world.randBetween(1, 3);
/* 519 */     int[] randTab2 = new int[randLength];
/* 520 */     for (int i = 0; i < randTab2.length; i++) {
/* 521 */       randTab2[i] = this.world.randBetween(0, Monde.getListe_allCompagnies().size() - 1);
/* 522 */       chaine_2 = chaine_2 + Integer.toString(randTab2[i]) + ",";
/*     */     }
/*     */     
/* 525 */     String randName1 = ((Contribuable)this.world.getListe_contribuables().get(this.world.randBetween(0, this.world.getListe_contribuables().size() - 1))).getNom().toUpperCase();
/* 526 */     String randName2 = ((Contribuable)this.world.getListe_contribuables().get(this.world.randBetween(0, this.world.getListe_contribuables().size() - 1))).getNom().toUpperCase();
/*     */     
/* 528 */     chaine_1 = chaine_1 + randName1;
/* 529 */     chaine_2 = chaine_2 + randName2;
/*     */     
/* 531 */     Denonciation denonciation_1 = new Denonciation(ia.getEnqueteur());
/* 532 */     denonciation_1.setJour(this.jour);
/* 533 */     denonciation_1.setChaine_1(chaine_1);
/* 534 */     denonciation_1.setChaine_2(chaine_2);
/* 535 */     denonciation_1.setId_transaction(randTransac);
/* 536 */     this.world.getRegistre().getListeDenonc().add(denonciation_1);
/*     */     
/* 538 */     Requete req = new Requete(1);
/* 539 */     boolean succeed = this.world.denonciationReussie(ia, denonciation_1);
/* 540 */     req.setResultat(this.world.reponseAdmin(succeed, denonciation_1));
/* 541 */     ia.getEnqueteur().getListe_requetes().add(req);
/* 542 */     ia.getEnqueteur().addDenonciation();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void jourSuivant()
/*     */   {
/* 551 */     this.jour += 1;
/*     */     
/* 553 */     for (int i = 0; i < this.joueurs.size(); i++) {
/* 554 */       for (int j = 0; j < ((Joueur)this.joueurs.get(i)).getEnqueteur().getListe_requetes().size(); j++) {
/* 555 */         if (((Requete)((Joueur)this.joueurs.get(i)).getEnqueteur().getListe_requetes().get(j)).getTemps_attente() >= 0) {
/* 556 */           ((Requete)((Joueur)this.joueurs.get(i)).getEnqueteur().getListe_requetes().get(j)).minusTempsAttente();
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 561 */     int k = this.world.getRegistre().getListeDenonc().size();
/* 562 */     int[] indexToDelete = new int[k];
/* 563 */     int nb_suppressed = 0;
/*     */     
/* 565 */     for (int i = 0; i < indexToDelete.length; i++) { indexToDelete[i] = -1;
/*     */     }
/* 567 */     for (int i = 0; i < k; i++) {
/* 568 */       if (((Denonciation)this.world.getRegistre().getListeDenonc().get(i)).getJour() < this.jour - 1) {
/* 569 */         indexToDelete[i] = i;
/*     */       }
/*     */     }
/*     */     
/* 573 */     for (int i = 0; i < indexToDelete.length; i++) {
/* 574 */       if (indexToDelete[i] != -1) {
/* 575 */         this.world.getRegistre().getListeDenonc().remove(i - nb_suppressed);
/* 576 */         nb_suppressed++;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void getReponses(Joueur joueur)
/*     */   {
/* 587 */     for (int i = 0; i < joueur.getEnqueteur().getListe_requetes().size(); i++) {
/* 588 */       if (((Requete)joueur.getEnqueteur().getListe_requetes().get(i)).getTemps_attente() == 0) {
/* 589 */         this.vue.afficherResultat(((Requete)joueur.getEnqueteur().getListe_requetes().get(i)).getResultat());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void play()
/*     */   {
/* 603 */     boolean passerTour = false;boolean exit = false;boolean error = true;
/* 604 */     int choix = 0;
/*     */     
/* 606 */     this.vue.afficherRegistre();
/* 607 */     this.jour = 0;
/*     */     int index;
/*     */     do
/*     */     {
/* 611 */       index = 0;
/* 612 */       jourSuivant();
/* 613 */       this.vue.afficherJour();
/*     */       do
/*     */       {
/* 616 */         this.vue.afficherDebutTour(index);
/* 617 */         getReponses((Joueur)this.joueurs.get(index));
/*     */         do
/*     */         {
/* 620 */           this.vue.afficherPointsAction(index);
/* 621 */           this.vue.afficherActions();
/* 622 */           error = true;
/*     */           
/* 624 */           while (error) {
/*     */             try {
/*     */               do {
/* 627 */                 choix = Integer.parseInt(this.sc.nextLine());
/* 628 */                 if ((choix < 1) || (choix > 7)) {
/* 629 */                   this.vue.choiceError(7);
/*     */                 }
/* 631 */               } while ((choix < 1) || (choix > 7));
/* 632 */               error = false;
/*     */             }
/*     */             catch (NumberFormatException e) {
/* 635 */               this.vue.formatError();
/*     */             }
/*     */           }
/*     */           
/* 639 */           switch (choix)
/*     */           {
/*     */           case 1: 
/* 642 */             solliciter((Joueur)this.joueurs.get(index));
/* 643 */             ((Joueur)this.joueurs.get(index)).minusPoint_action();
/* 644 */             break;
/*     */           
/*     */           case 2: 
/* 647 */             denoncer((Joueur)this.joueurs.get(index));
/* 648 */             ((Joueur)this.joueurs.get(index)).setPoints_action(0);
/* 649 */             break;
/*     */           
/*     */           case 3: 
/* 652 */             this.vue.afficherRegistre();
/* 653 */             break;
/*     */           
/*     */           case 4: 
/* 656 */             this.vue.recapJoueurs();
/* 657 */             break;
/*     */           
/*     */           case 5: 
/* 660 */             for (int i = 0; i < ((Joueur)this.joueurs.get(index)).getEnqueteur().getListe_requetes().size(); i++) {
/* 661 */               if (((Requete)((Joueur)this.joueurs.get(index)).getEnqueteur().getListe_requetes().get(index)).getTemps_attente() <= 0) {
/* 662 */                 this.vue.afficherAnciens(((Joueur)this.joueurs.get(index)).getEnqueteur().getListe_requetes());
/* 663 */                 break;
/*     */               }
/*     */             }
/* 666 */             break;
/*     */           
/*     */           case 6: 
/* 669 */             passerTour = true;
/* 670 */             break;
/*     */           
/*     */           case 7: 
/* 673 */             passerTour = true;
/*     */           
/*     */           }
/*     */           
/* 677 */         } while ((((Joueur)this.joueurs.get(index)).getPoints_action() > 0) && (!passerTour));
/*     */         
/* 679 */         ((Joueur)this.joueurs.get(index)).setPoints_action(2);
/* 680 */         passerTour = false;
/* 681 */         index++;
/*     */         
/* 683 */         if (choix == 7) {
/* 684 */           exit = true;
/*     */         }
/* 686 */         choix = 0;
/*     */       }
/* 688 */       while ((index < this.world.getNombre_joueurs_humain()) && (!exit));
/*     */       
/* 690 */       if ((!exit) && (this.world.getNombre_joueurs_humain() < this.world.getNombre_joueurs()) && 
/* 691 */         (!this.world.getRegistre().getListeTransactionSuspectes().isEmpty())) {
/*     */         do {
/* 693 */           int randNumber = this.world.randBetween(1, 4);
/* 694 */           if (randNumber <= 3) {
/* 695 */             denoncerIA((Joueur)this.joueurs.get(index));
/*     */           }
/*     */           
/* 698 */           index++;
/* 699 */         } while ((index < this.world.getNombre_joueurs()) && 
/* 700 */           (!this.world.getRegistre().getListeTransactionSuspectes().isEmpty()));
/*     */       }
/*     */       
/* 703 */     } while (((index < this.world.getNombre_joueurs()) && (!exit)) || (
/*     */     
/* 705 */       (!this.world.getRegistre().getListeTransactionSuspectes().isEmpty()) && (!exit)));
/*     */     
/* 707 */     endGame();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void endGame()
/*     */   {
/* 717 */     this.vue.classement();
/* 718 */     this.vue.finPartie();
/* 719 */     this.sc.close();
/*     */   }
/*     */   
/*     */   public static void main(String[] args)
/*     */   {
/* 724 */     Jeu jeu = new Jeu();
/* 725 */     jeu.init();
/* 726 */     jeu.play();
/*     */   }
/*     */ }


/* Location:              D:\Users\ZeMachine\Scolaire\ET3S5\Java\projet.jar!\et3\fraude\controleur\Jeu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */