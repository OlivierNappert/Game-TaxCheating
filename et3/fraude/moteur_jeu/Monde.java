/*     */ package et3.fraude.moteur_jeu;
/*     */ 
/*     */ import et3.fraude.controleur.IA;
/*     */ import et3.fraude.controleur.Joueur;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Date;
/*     */ import java.util.GregorianCalendar;
/*     */ import java.util.Properties;
/*     */ import java.util.Random;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Monde
/*     */ {
/*     */   private static ArrayList<Societe> liste_societes;
/*     */   private static ArrayList<Banque> liste_banques;
/*     */   private static ArrayList<Societe> liste_allCompagnies;
/*     */   private ArrayList<Pays> liste_pays;
/*     */   private ArrayList<Contribuable> liste_contribuables;
/*     */   private ArrayList<Enqueteur> liste_enqueteurs;
/*     */   private ArrayList<Transaction_Bancaire> liste_transactions;
/*     */   private Registre_Central registre;
/*  32 */   private static Properties properties = new Properties();
/*  33 */   private Random rand = new Random();
/*     */   
/*  35 */   private final int NOMBRE_TRANSACTIONS = 5;
/*  36 */   private final int NOMBRE_JOUEURS_MAX = 10;
/*  37 */   private int nombre_joueurs = 4;
/*  38 */   private int nombre_joueurs_humain = 4;
/*     */   
/*     */   private int[][] facteurs_coop;
/*     */   
/*     */ 
/*     */   public Monde()
/*     */   {
/*  45 */     this.liste_pays = new ArrayList();
/*  46 */     this.liste_contribuables = new ArrayList();
/*  47 */     this.liste_enqueteurs = new ArrayList();
/*  48 */     liste_societes = new ArrayList();
/*  49 */     liste_banques = new ArrayList();
/*  50 */     this.liste_transactions = new ArrayList();
/*  51 */     liste_allCompagnies = new ArrayList();
/*     */     
/*  53 */     this.registre = new Registre_Central();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ArrayList<Pays> getListe_pays()
/*     */   {
/*  60 */     return this.liste_pays;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static ArrayList<Societe> getListe_allCompagnies()
/*     */   {
/*  67 */     return liste_allCompagnies;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ArrayList<Contribuable> getListe_contribuables()
/*     */   {
/*  74 */     return this.liste_contribuables;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ArrayList<Enqueteur> getListe_enqueteurs()
/*     */   {
/*  81 */     return this.liste_enqueteurs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static ArrayList<Societe> getListe_societes()
/*     */   {
/*  88 */     return liste_societes;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static ArrayList<Banque> getListe_banques()
/*     */   {
/*  95 */     return liste_banques;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ArrayList<Transaction_Bancaire> getListe_transactions()
/*     */   {
/* 102 */     return this.liste_transactions;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Registre_Central getRegistre()
/*     */   {
/* 109 */     return this.registre;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getNombre_joueurs()
/*     */   {
/* 116 */     return this.nombre_joueurs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNombre_joueurs(int nombre_joueurs)
/*     */   {
/* 124 */     this.nombre_joueurs = nombre_joueurs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getNombre_joueurs_humain()
/*     */   {
/* 131 */     return this.nombre_joueurs_humain;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNombre_joueurs_humain(int nombre_joueurs_humain)
/*     */   {
/* 139 */     this.nombre_joueurs_humain = nombre_joueurs_humain;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int[][] getFacteurs_coop()
/*     */   {
/* 146 */     return this.facteurs_coop;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getNombreTransactions()
/*     */   {
/* 153 */     return 5;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getNombreJoueursMax()
/*     */   {
/* 160 */     return 10;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void init()
/*     */   {
/* 173 */     createLists();
/* 174 */     setPays(this.nombre_joueurs);
/* 175 */     createEnqueteurList(this.nombre_joueurs);
/* 176 */     setComptesBancaire();
/* 177 */     setSocietiesHierarchy();
/* 178 */     createTransactionList();
/* 179 */     setRegistre();
/*     */   }
/*     */   
/*     */ 
/*     */   public void createLists()
/*     */   {
/*     */     try
/*     */     {
/* 187 */       InputStream in = getClass().getResourceAsStream("/cfg/config.properties");
/* 188 */       properties.loadFromXML(in);
/*     */     } catch (IOException e) {
/* 190 */       e.printStackTrace();
/*     */     }
/*     */     
/* 193 */     createCountryList();
/* 194 */     createContribList();
/* 195 */     createSocietesList();
/* 196 */     createBankList();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void createCountryList()
/*     */   {
/* 203 */     String[] temp = properties.getProperty("PAYS").split(",");
/* 204 */     shuffleArray(temp);
/*     */     
/* 206 */     for (int i = 0; i < temp.length; i++) {
/* 207 */       Pays pays = new Pays(temp[i], i + 1);
/* 208 */       this.liste_pays.add(pays);
/*     */     }
/*     */     
/* 211 */     this.facteurs_coop = new int[temp.length][temp.length];
/*     */     
/*     */ 
/* 214 */     for (int x = 0; x < this.facteurs_coop.length; x++) {
/* 215 */       for (int y = 0; y < this.facteurs_coop.length; y++) {
/* 216 */         if (y <= x) {
/* 217 */           if (x == y) {
/* 218 */             this.facteurs_coop[x][y] = 1;
/*     */           }
/*     */           else {
/* 221 */             int random_number = randBetween(1, 3);
/* 222 */             this.facteurs_coop[x][y] = random_number;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void createContribList()
/*     */   {
/* 233 */     String[] temp = properties.getProperty("CONTRIBUABLE").split(",");
/* 234 */     shuffleArray(temp);
/* 235 */     for (int i = 0; i < temp.length; i++) {
/* 236 */       Date date = randomDate();
/* 237 */       String[] name_holder = parseName(temp[i]);
/* 238 */       Contribuable contribuable = new Contribuable(name_holder[1], name_holder[0], date, null);
/* 239 */       this.liste_contribuables.add(contribuable);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void createEnqueteurList(int nombre_joueurs)
/*     */   {
/* 248 */     String[] temp = properties.getProperty("ENQUETEUR").split(",");
/* 249 */     shuffleArray(temp);
/* 250 */     ArrayList<Integer> id_array = new ArrayList();
/* 251 */     int random_number = 0;
/* 252 */     int represented_countries = 0;
/*     */     
/*     */ 
/* 255 */     for (int i = 0; i < nombre_joueurs; i++) {
/* 256 */       Date date = randomDate();
/* 257 */       String[] name_holder = parseName(temp[i]);
/*     */       Pays pays;
/*     */       do {
/* 260 */         random_number = randBetween(0, this.liste_contribuables.size() - 1);
/* 261 */         pays = ((Contribuable)this.liste_contribuables.get(random_number)).getPays_residence();
/* 262 */       } while ((idUsed(id_array, ((Contribuable)this.liste_contribuables.get(random_number)).getPays_residence().getId_pays())) && (represented_countries < nombre_joueurs));
/*     */       
/* 264 */       Enqueteur enqueteur = new Enqueteur(name_holder[1], name_holder[0], date, pays, i + 1);
/* 265 */       id_array.add(Integer.valueOf(enqueteur.getPays_residence().getId_pays()));
/* 266 */       enqueteur.setNombre_denonciations(0);
/* 267 */       ((Pays)this.liste_pays.get(enqueteur.getPays_residence().getId_pays() - 1)).setEnqueteur(enqueteur);
/* 268 */       represented_countries++;
/* 269 */       this.liste_enqueteurs.add(enqueteur);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void createSocietesList()
/*     */   {
/* 277 */     String[] temp = properties.getProperty("SOCIETE").split(",");
/* 278 */     shuffleArray(temp);
/* 279 */     for (int i = 0; i < temp.length; i++) {
/* 280 */       Societe societe = new Societe(temp[i].toUpperCase(), null, i + 1);
/* 281 */       liste_societes.add(societe);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void createBankList()
/*     */   {
/* 289 */     String[] temp = properties.getProperty("BANQUE").split(",");
/* 290 */     shuffleArray(temp);
/* 291 */     int id = 100001;int j = liste_societes.size() + 1;
/* 292 */     for (int i = 0; i < temp.length; i++) {
/* 293 */       Banque banque = new Banque(temp[i].toUpperCase(), null, i + 1, j);
/* 294 */       createAccountList(banque, id);
/* 295 */       id += 40;
/* 296 */       j++;
/* 297 */       liste_banques.add(banque);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void createAccountList(Banque b, int id)
/*     */   {
/* 307 */     int nombre_comptes = randBetween(15, 30);
/*     */     
/* 309 */     for (int i = 0; i < nombre_comptes; i++) {
/* 310 */       int solde = randBetween(100, 30000);
/* 311 */       Compte_Bancaire cb = new Compte_Bancaire(b, id, solde);
/* 312 */       id++;
/* 313 */       b.addCompte(cb);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPays(int nombre_joueurs)
/*     */   {
/* 322 */     int[] rand_country = new int[nombre_joueurs];
/*     */     
/* 324 */     ArrayList<Integer> id_checker = new ArrayList();
/*     */     
/* 326 */     for (int i = 0; i < nombre_joueurs; i++) {
/*     */       do {
/* 328 */         rand_country[i] = randBetween(0, this.liste_pays.size() - 1);
/* 329 */       } while (idUsed(id_checker, rand_country[i]));
/* 330 */       id_checker.add(Integer.valueOf(rand_country[i]));
/*     */     }
/*     */     
/* 333 */     for (int i = 0; i < this.liste_contribuables.size(); i++) {
/* 334 */       int choice = randBetween(0, rand_country.length - 1);
/* 335 */       ((Contribuable)this.liste_contribuables.get(i)).setPays_residence((Pays)this.liste_pays.get(rand_country[choice]));
/*     */     }
/*     */     
/* 338 */     for (int i = 0; i < liste_societes.size(); i++) {
/* 339 */       int choice = randBetween(0, rand_country.length - 1);
/* 340 */       ((Societe)liste_societes.get(i)).setPays_residence((Pays)this.liste_pays.get(rand_country[choice]));
/*     */     }
/*     */     
/* 343 */     for (int i = 0; i < liste_banques.size(); i++) {
/* 344 */       int choice = randBetween(0, rand_country.length - 1);
/* 345 */       ((Banque)liste_banques.get(i)).setPays_residence((Pays)this.liste_pays.get(rand_country[choice]));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setComptesBancaire()
/*     */   {
/* 356 */     int k = 0;
/*     */     
/* 358 */     ArrayList<Integer> id_check = new ArrayList();
/* 359 */     ArrayList<Contribuable> contrib_array = new ArrayList();
/*     */     
/* 361 */     for (int i = 0; i < this.liste_contribuables.size(); i++) contrib_array.add((Contribuable)this.liste_contribuables.get(i));
/* 362 */     for (int i = 0; i < this.liste_enqueteurs.size(); i++) { contrib_array.add((Contribuable)this.liste_enqueteurs.get(i));
/*     */     }
/* 364 */     Collections.shuffle(contrib_array);
/*     */     
/* 366 */     for (int i = 0; i < contrib_array.size(); i++) {
/*     */       int randBankIndex;
/*     */       int id;
/* 369 */       do { randBankIndex = randBetween(0, liste_banques.size() - 1);
/* 370 */         if (k < ((Banque)liste_banques.get(randBankIndex)).getListe_comptes().size() - 1) {
/* 371 */           int id = ((Compte_Bancaire)((Banque)liste_banques.get(randBankIndex)).getListe_comptes().get(k)).getIdentifiant_unique();
/* 372 */           k++;
/*     */         }
/*     */         else {
/* 375 */           k = 0;
/* 376 */           randBankIndex = randBetween(0, liste_banques.size() - 1);
/* 377 */           id = ((Compte_Bancaire)((Banque)liste_banques.get(randBankIndex)).getListe_comptes().get(k)).getIdentifiant_unique();
/*     */         }
/* 379 */       } while (idUsed(id_check, id));
/*     */       
/* 381 */       ((Contribuable)contrib_array.get(i)).setCompte_bancaire((Compte_Bancaire)((Banque)liste_banques.get(randBankIndex)).getListe_comptes().get(k));
/* 382 */       if ((contrib_array.get(i) instanceof Enqueteur)) {
/* 383 */         ((Contribuable)contrib_array.get(i)).getCompte_bancaire().setSolde(10000);
/*     */       }
/* 385 */       id_check.add(Integer.valueOf(id));
/*     */     }
/*     */     
/* 388 */     for (int i = 0; i < liste_societes.size(); i++) {
/*     */       int randBankIndex;
/*     */       int id;
/* 391 */       do { randBankIndex = randBetween(0, liste_banques.size() - 1);
/*     */         
/* 393 */         if (k < ((Banque)liste_banques.get(randBankIndex)).getListe_comptes().size() - 1) {
/* 394 */           int id = ((Compte_Bancaire)((Banque)liste_banques.get(randBankIndex)).getListe_comptes().get(k)).getIdentifiant_unique();
/* 395 */           k++;
/*     */         }
/*     */         else {
/* 398 */           k = 0;
/* 399 */           randBankIndex = randBetween(0, liste_banques.size() - 1);
/* 400 */           id = ((Compte_Bancaire)((Banque)liste_banques.get(randBankIndex)).getListe_comptes().get(k)).getIdentifiant_unique();
/*     */         }
/* 402 */       } while (idUsed(id_check, id));
/*     */       
/* 404 */       ((Societe)liste_societes.get(i)).setCompte_bancaire((Compte_Bancaire)((Banque)liste_banques.get(randBankIndex)).getListe_comptes().get(k));
/* 405 */       id_check.add(Integer.valueOf(id));
/*     */     }
/*     */     
/* 408 */     for (int i = 0; i < liste_banques.size(); i++) {
/*     */       int randBankIndex;
/*     */       int id;
/* 411 */       do { randBankIndex = randBetween(0, liste_banques.size() - 1);
/*     */         
/* 413 */         if (k < ((Banque)liste_banques.get(randBankIndex)).getListe_comptes().size() - 1) {
/* 414 */           int id = ((Compte_Bancaire)((Banque)liste_banques.get(randBankIndex)).getListe_comptes().get(k)).getIdentifiant_unique();
/* 415 */           k++;
/*     */         }
/*     */         else {
/* 418 */           k = 0;
/* 419 */           randBankIndex = randBetween(0, liste_banques.size() - 1);
/* 420 */           id = ((Compte_Bancaire)((Banque)liste_banques.get(randBankIndex)).getListe_comptes().get(k)).getIdentifiant_unique();
/*     */         }
/* 422 */       } while (idUsed(id_check, id));
/*     */       
/* 424 */       ((Banque)liste_banques.get(i)).setCompte_bancaire((Compte_Bancaire)((Banque)liste_banques.get(randBankIndex)).getListe_comptes().get(k));
/* 425 */       id_check.add(Integer.valueOf(id));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSocietiesHierarchy()
/*     */   {
/* 435 */     ArrayList<Contribuable> contrib_array = new ArrayList();
/*     */     
/* 437 */     for (int i = 0; i < liste_societes.size(); i++) liste_allCompagnies.add((Societe)liste_societes.get(i));
/* 438 */     for (int i = 0; i < liste_banques.size(); i++) liste_allCompagnies.add((Societe)liste_banques.get(i));
/* 439 */     for (int i = 0; i < this.liste_contribuables.size(); i++) contrib_array.add((Contribuable)this.liste_contribuables.get(i));
/* 440 */     for (int i = 0; i < this.liste_enqueteurs.size(); i++) { contrib_array.add((Contribuable)this.liste_enqueteurs.get(i));
/*     */     }
/* 442 */     Collections.shuffle(liste_allCompagnies, this.rand);
/* 443 */     Collections.shuffle(contrib_array, this.rand);
/*     */     
/*     */ 
/*     */ 
/* 447 */     for (int i = 0; i < liste_allCompagnies.size(); i++)
/*     */     {
/* 449 */       if ((i < contrib_array.size()) && (i < liste_allCompagnies.size() / 3 + 1)) {
/* 450 */         int rand_number = randBetween(0, liste_allCompagnies.size() / 3);
/* 451 */         ((Societe)liste_allCompagnies.get(i)).setProprietaire((Proprietaire)contrib_array.get(rand_number));
/*     */ 
/*     */       }
/* 454 */       else if (i < 2 * (1 + liste_allCompagnies.size() / 3)) {
/* 455 */         int rand_number = randBetween(0, liste_allCompagnies.size() / 3);
/* 456 */         ((Societe)liste_allCompagnies.get(i)).setProprietaire((Proprietaire)liste_allCompagnies.get(rand_number));
/*     */       }
/*     */       else
/*     */       {
/* 460 */         int rand_number = randBetween(liste_allCompagnies.size() / 3 + 1, 2 * liste_allCompagnies.size() / 3 + 1);
/* 461 */         ((Societe)liste_allCompagnies.get(i)).setProprietaire((Proprietaire)liste_allCompagnies.get(rand_number));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void createTransactionList()
/*     */   {
/* 472 */     ArrayList<Integer> used = new ArrayList();
/*     */     
/* 474 */     for (int i = 0; i < 5; i++) {
/*     */       int rand_bank;
/*     */       int rand_account;
/* 477 */       do { rand_bank = randBetween(0, liste_banques.size() - 1);
/* 478 */         rand_account = randBetween(0, ((Banque)liste_banques.get(rand_bank)).getListe_comptes().size() - 1);
/* 479 */       } while ((((Compte_Bancaire)((Banque)liste_banques.get(rand_bank)).getListe_comptes().get(rand_account)).getProprietaire() == null) || 
/* 480 */         (stepsToContrib((Compte_Bancaire)((Banque)liste_banques.get(rand_bank)).getListe_comptes().get(rand_account)) == 0));
/*     */       
/* 482 */       Transaction_Bancaire tb = new Transaction_Bancaire();
/* 483 */       tb.setId(i + 1);
/* 484 */       tb.setCompte_source((Compte_Bancaire)((Banque)liste_banques.get(rand_bank)).getListe_comptes().get(rand_account));
/*     */       do
/*     */       {
/* 487 */         rand_bank = randBetween(0, liste_banques.size() - 1);
/* 488 */         rand_account = randBetween(0, ((Banque)liste_banques.get(rand_bank)).getListe_comptes().size() - 1);
/* 489 */       } while ((((Compte_Bancaire)((Banque)liste_banques.get(rand_bank)).getListe_comptes().get(rand_account)).getIdentifiant_unique() == tb.getCompte_source().getIdentifiant_unique()) || 
/* 490 */         (((Compte_Bancaire)((Banque)liste_banques.get(rand_bank)).getListe_comptes().get(rand_account)).getProprietaire() == null) || 
/* 491 */         (stepsToContrib((Compte_Bancaire)((Banque)liste_banques.get(rand_bank)).getListe_comptes().get(rand_account)) == 0) || 
/*     */         
/* 493 */         (!coupleUnused(used, tb.getCompte_source().getIdentifiant_unique(), ((Compte_Bancaire)((Banque)liste_banques.get(rand_bank)).getListe_comptes().get(rand_account)).getIdentifiant_unique())));
/*     */       
/* 495 */       tb.setCompte_destination((Compte_Bancaire)((Banque)liste_banques.get(rand_bank)).getListe_comptes().get(rand_account));
/*     */       
/* 497 */       used.add(Integer.valueOf(tb.getCompte_source().getIdentifiant_unique()));
/* 498 */       used.add(Integer.valueOf(tb.getCompte_destination().getIdentifiant_unique()));
/*     */       
/* 500 */       int rand_montant = randBetween(3 * tb.getCompte_destination().getSolde() / 4, tb.getCompte_destination().getSolde());
/* 501 */       tb.setMontant(rand_montant);
/*     */       
/* 503 */       this.liste_transactions.add(tb);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRegistre()
/*     */   {
/* 511 */     this.registre.setAllTransactions(this.liste_transactions);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean idUsed(ArrayList<Integer> id_array, int toCheck)
/*     */   {
/* 521 */     if (id_array.isEmpty()) {
/* 522 */       return false;
/*     */     }
/* 524 */     for (int i = 0; i < id_array.size(); i++) {
/* 525 */       if (((Integer)id_array.get(i)).intValue() == toCheck) {
/* 526 */         return true;
/*     */       }
/*     */     }
/* 529 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean coupleUnused(ArrayList<Integer> used, int id_new1, int id_new2)
/*     */   {
/* 541 */     if (used.isEmpty()) {
/* 542 */       return true;
/*     */     }
/*     */     
/* 545 */     for (int i = 0; i < used.size(); i += 2) {
/* 546 */       if ((((Integer)used.get(i)).intValue() == id_new1) || 
/* 547 */         (((Integer)used.get(i + 1)).intValue() == id_new1))
/*     */       {
/* 549 */         if ((((Integer)used.get(i)).intValue() == id_new2) || 
/* 550 */           (((Integer)used.get(i + 1)).intValue() == id_new2))
/*     */         {
/* 552 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 558 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean correctCode(int code_banque)
/*     */   {
/* 567 */     for (int i = 0; i < liste_banques.size(); i++) {
/* 568 */       if (((Banque)liste_banques.get(i)).getCode_banque() == code_banque) {
/* 569 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 573 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean correctAccountNumber(int code_banque, int num_compte)
/*     */   {
/* 583 */     for (int i = 0; i < liste_banques.size(); i++) {
/* 584 */       if (((Banque)liste_banques.get(i)).getCode_banque() == code_banque) {
/* 585 */         for (int j = 0; j < ((Banque)liste_banques.get(i)).getListe_comptes().size(); j++) {
/* 586 */           if (((Compte_Bancaire)((Banque)liste_banques.get(i)).getListe_comptes().get(j)).getIdentifiant_unique() == num_compte) {
/* 587 */             return true;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 593 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean correctSocietyID(int id)
/*     */   {
/* 602 */     for (int i = 0; i < liste_allCompagnies.size(); i++) {
/* 603 */       if (((Societe)liste_allCompagnies.get(i)).getId_societe() == id) {
/* 604 */         return true;
/*     */       }
/*     */     }
/* 607 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean correctTransacNumber(int trans_number)
/*     */   {
/* 616 */     for (int i = 0; i < this.registre.getListeTransactionSuspectes().size(); i++) {
/* 617 */       if (((Transaction_Bancaire)this.registre.getListeTransactionSuspectes().get(i)).getId() == trans_number) {
/* 618 */         return true;
/*     */       }
/*     */     }
/* 621 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String reponseAdmin(boolean reussite, Denonciation d)
/*     */   {
/* 632 */     if (reussite) {
/* 633 */       return "Bravo, votre dénonciation concernant la transaction " + d.getId_transaction() + " ( Jour " + d.getJour() + " ), a permis d'identifier les coupables.\nMerci pour votre coopération.";
/*     */     }
/* 635 */     return "Les suspects n'ont pas pu être identifiés suite à votre dénonciation concernant la transaction " + d.getId_transaction() + " (Jour " + d.getJour() + ").\nVeuillez vérifier vos informations.";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean denonciationReussie(Joueur j, Denonciation d)
/*     */   {
/* 646 */     for (int i = 0; i < this.registre.getListeTransactionSuspectes().size(); i++) {
/* 647 */       if (d.getId_transaction() == ((Transaction_Bancaire)this.registre.getListeTransactionSuspectes().get(i)).getId()) {
/* 648 */         String s1 = getSuspect(((Transaction_Bancaire)this.registre.getListeTransactionSuspectes().get(i)).getCompte_source()).getNom().toUpperCase();
/* 649 */         String s2 = getSuspect(((Transaction_Bancaire)this.registre.getListeTransactionSuspectes().get(i)).getCompte_destination()).getNom().toUpperCase();
/* 650 */         String[] toCheck1 = d.getChaine_1().split(",");
/* 651 */         String[] toCheck2 = d.getChaine_2().split(",");
/*     */         
/* 653 */         if (((toCheck1[(toCheck1.length - 1)].equals(s1.toString())) && (toCheck2[(toCheck2.length - 1)].equals(s2.toString()))) || (
/* 654 */           (toCheck1[(toCheck1.length - 1)].equals(s2)) && (toCheck2[(toCheck2.length - 1)].equals(s1))))
/*     */         {
/* 656 */           int random_recompense = randBetween(1, 5);
/* 657 */           random_recompense *= 1000;
/* 658 */           j.getEnqueteur().getCompte_bancaire().addToSolde(random_recompense);
/* 659 */           this.registre.getListeTransactionSuspectes().remove(i);
/* 660 */           if (!(j instanceof IA)) {
/* 661 */             System.out.println("Récompense reçue : " + random_recompense + "$.");
/*     */           }
/* 663 */           return true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 668 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Contribuable getSuspect(Compte_Bancaire b)
/*     */   {
/* 677 */     Proprietaire p = b.getProprietaire();
/*     */     
/*     */ 
/* 680 */     if ((p instanceof Contribuable))
/* 681 */       return (Contribuable)p;
/*     */     Societe s;
/* 683 */     do { s = (Societe)p;
/* 684 */       p = s.getProprietaire();
/* 685 */       if ((p instanceof Contribuable)) {
/*     */         break;
/*     */       }
/* 688 */       s = (Societe)p;
/* 689 */     } while (s.getProprietaire() != null);
/*     */     
/* 691 */     return (Contribuable)p;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int stepsToContrib(Compte_Bancaire b)
/*     */   {
/* 701 */     int steps = 0;
/* 702 */     Proprietaire p = b.getProprietaire();
/*     */     
/*     */ 
/* 705 */     if ((p instanceof Contribuable))
/* 706 */       return steps;
/*     */     Societe s;
/*     */     do {
/* 709 */       s = (Societe)p;
/* 710 */       p = s.getProprietaire();
/* 711 */       if ((p instanceof Contribuable)) {
/* 712 */         steps++;
/* 713 */         break;
/*     */       }
/* 715 */       s = (Societe)p;
/* 716 */       steps++;
/* 717 */     } while (s.getProprietaire() != null);
/*     */     
/* 719 */     return steps;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void shuffleArray(String[] ar)
/*     */   {
/* 728 */     Random rnd = new Random();
/* 729 */     for (int i = ar.length - 1; i > 0; i--)
/*     */     {
/* 731 */       int index = rnd.nextInt(i + 1);
/* 732 */       String a = ar[index];
/* 733 */       ar[index] = ar[i];
/* 734 */       ar[i] = a;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date randomDate()
/*     */   {
/* 743 */     int year = randBetween(1940, 1990);
/* 744 */     int month = randBetween(1, 12);
/* 745 */     int day = randBetween(1, 30);
/* 746 */     int hour = randBetween(0, 23);
/* 747 */     int minutes = randBetween(0, 59);
/* 748 */     int seconds = randBetween(0, 59);
/*     */     
/* 750 */     GregorianCalendar gc = new GregorianCalendar(year, month - 1, day, hour, minutes, seconds);
/*     */     
/* 752 */     Date newDate = gc.getTime();
/*     */     
/* 754 */     return newDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int randBetween(int start, int end)
/*     */   {
/* 764 */     int randomNum = this.rand.nextInt(end - start + 1) + start;
/* 765 */     return randomNum;
/*     */   }
/*     */   
/*     */   public static String[] parseName(String toParse) {
/* 769 */     String[] parsed = new String[2];
/* 770 */     int k = toParse.indexOf(" ", 0);
/* 771 */     parsed[0] = toParse.substring(0, k);
/* 772 */     parsed[1] = toParse.substring(k + 1, toParse.length()).toUpperCase();
/* 773 */     return parsed;
/*     */   }
/*     */ }


/* Location:              D:\Users\ZeMachine\Scolaire\ET3S5\Java\projet.jar!\et3\fraude\moteur_jeu\Monde.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */