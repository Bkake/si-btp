DROP TABLE IF EXISTS entreprise, particulier, categorie, adresse, contact;

CREATE TABLE contact (
  id              NUMBER(7),
  nom             VARCHAR2(20),
  prenom          VARCHAR2(20) ,
  telephone       VARCHAR2(15),
  mobile          VARCHAR2(15),
  fax             VARCHAR2(15),
  email           VARCHAR2(50),
  date_of_create  DATE  DEFAULT CURRENT_DATE,
  date_of_update  DATE,

  CONSTRAINT pk_contact_id PRIMARY KEY (id)
);

CREATE TABLE adresse (
  id              NUMBER(7),
  code_adresse    VARCHAR2(30)  DEFAULT 'Adresse principal',
  adresse         VARCHAR2(50),    
  cp              CHAR(5),
  ville           VARCHAR2(20),
  telephone       VARCHAR2(15),
  mobile          VARCHAR2(15),
  fax             VARCHAR2(15),
  email           VARCHAR2(50),
  date_of_create  DATE  DEFAULT CURRENT_DATE,
  date_of_update  DATE,

  CONSTRAINT pk_adresse_id PRIMARY KEY (id),
  CONSTRAINT nn_adresse_code_adresse CHECK(code_adresse IS NOT NULL),
  CONSTRAINT nn_adresse_cp CHECK(cp IS NOT NULL),
  CONSTRAINT nn_adresse_ville CHECK(ville IS NOT NULL)
);

CREATE TABLE categorie (
  id              NUMBER(7),
  abreviation     VARCHAR2(20),
  designation     VARCHAR2(50),
  visibleOuiNon   BOOLEAN,
  date_of_create  DATE  DEFAULT CURRENT_DATE,
  date_of_update  DATE,

  CONSTRAINT pk_categorie_id PRIMARY KEY (id),
  CONSTRAINT nn_categorie_abreviation CHECK(abreviation IS NOT NULL),
  CONSTRAINT nn_categorie_designation CHECK(designation IS NOT NULL)
);


CREATE TABLE entreprise (
  id              NUMBER(7),
  code            VARCHAR2(20),
  commentaire     VARCHAR2(50),
  statut          VARCHAR2(10),
  nom             VARCHAR2(20) ,
  enseigne        VARCHAR2(20),
  siren           VARCHAR2(11),
  categorie_id    NUMBER(7),
  adresse_id      NUMBER(7),
  contact_id      NUMBER(7),
  date_of_create  DATE  DEFAULT CURRENT_DATE,
  date_of_update  DATE,

  CONSTRAINT pk_entreprise_id PRIMARY KEY (id),
  CONSTRAINT unq_entrprise_code UNIQUE(code),
  CONSTRAINT nn_entrprise_nom CHECK(nom IS NOT NULL),
  CONSTRAINT fk_entreprise_categorie FOREIGN KEY (categorie_id) REFERENCES categorie(id),
  CONSTRAINT fk_entreprise_adresse   FOREIGN KEY (adresse_id)   REFERENCES adresse(id),
  CONSTRAINT fk_entreprise_contact   FOREIGN KEY (contact_id)   REFERENCES contact(id)
);


CREATE TABLE particulier (
 id              NUMBER(7),
 code            VARCHAR2(20),
 commentaire     VARCHAR2(50),
 civilite        CHAR(4),
 nom             VARCHAR2(20),
 prenom          VARCHAR2(20),
 categorie_id    NUMBER(7),
 adresse_id      NUMBER(7),
 contact_id      NUMBER(7),
 create_date     DATE  DEFAULT CURRENT_DATE,
 update_date     DATE,

 CONSTRAINT pk_particulier_id PRIMARY KEY (id),
 CONSTRAINT unq_particulier_code UNIQUE(code),
 CONSTRAINT nn_particulier_nom CHECK(nom IS NOT NULL),
 CONSTRAINT nn_particulier_prenom CHECK(nom IS NOT NULL),
 CONSTRAINT fk_particulier_categorie FOREIGN KEY (categorie_id) REFERENCES categorie(id),
 CONSTRAINT fk_particulier_adresse  FOREIGN KEY (adresse_id)   REFERENCES adresse(id),
 CONSTRAINT fk_particulier_contact  FOREIGN KEY (contact_id)   REFERENCES contact(id)
);


INSERT INTO contact (id, nom, prenom, telephone, mobile, fax, email) VALUES (1, 'KAKE', 'Bangaly', '01.00.00.00', '06.00.00.00', '01.00.00.00', 'bangaly.kake@toto.gn');
INSERT INTO contact (id, nom, prenom, telephone, mobile, fax, email) VALUES (2, 'CAMARA', 'Aboubacar', '01.01.00.00', '06.01.00.00', '01.01.00.00', 'aboubacar.camara@toto.gn');
INSERT INTO contact (id, nom, prenom, telephone, mobile, fax, email) VALUES (3, 'BANGOURA', 'Momo', '01.00.01.00', '06.00.01.00', '01.00.01.00', 'momo.bangoura@toto.gn');
INSERT INTO contact (id, nom, prenom, telephone, mobile, fax, email) VALUES (4, 'CONDE', 'Hamidou', '01.00.00.01', '06.00.00.01', '01.00.00.01', 'hamidou.conde@toto.gn');

INSERT INTO adresse (id, adresse, cp, ville, telephone, mobile, fax, email) VALUES(1 , '11 rue de la marne', '91120', 'PALAISEAU', '01.00.00.00', '06.00.00.00', '01.00.00.00', 'bangaly.kake@toto.gn');
INSERT INTO adresse (id, adresse, cp, ville, telephone, mobile, fax, email) VALUES(2 , '3 avenue de la republique', '92000', 'NANTERRE', '01.01.00.00', '06.01.00.00', '01.01.00.00', 'aboubacar.camara@toto.gn');
INSERT INTO adresse (id, adresse, cp, ville, telephone, mobile, fax, email) VALUES(3 , '10 chemin de la baraudière', '44800', 'ST-HERBLAIN', '01.00.01.00', '06.00.01.00', '01.00.01.00', 'momo.bangoura@toto.gn');
INSERT INTO adresse (id, adresse, cp, ville, telephone, mobile, fax, email) VALUES(4, '11 rue de paris', '92190', 'MEUDON', '01.00.00.01', '06.00.00.01', '01.00.00.01', 'hamidou.conde@toto.gn');


INSERT INTO categorie (id, abreviation, designation, visibleOuiNon) VALUES(1 , 'Client', 'Client', TRUE);
INSERT INTO categorie (id, abreviation, designation, visibleOuiNon) VALUES(2 , 'Fournisseur', 'Fournisseur', TRUE);
INSERT INTO categorie (id, abreviation, designation, visibleOuiNon) VALUES(3 , 'Prospect', 'Prospect', TRUE);
INSERT INTO categorie (id, abreviation, designation, visibleOuiNon) VALUES(4 , 'Sous-traitant', 'Sous-traitant', TRUE);


INSERT INTO entreprise(id, code, commentaire, statut, nom, enseigne, siren, categorie_id, adresse_id, contact_id) VALUES (1, 'PALAISEAU91120', 'entreprise édutrice de logiciel', 'SAS', 'SOGUE-DIGITAL', '', '692 049 109', 2,1,3);
INSERT INTO entreprise(id, code, commentaire, statut, nom, enseigne, siren, categorie_id, adresse_id, contact_id) VALUES (2, 'NANTERRE92000', 'entreprise BTP', 'SARL', 'SOGEFEL', '', '692 049 109', 1,2,3);
INSERT INTO entreprise(id, code, commentaire, statut, nom, enseigne, siren, categorie_id, adresse_id, contact_id) VALUES (3, 'MEUDON92190', 'entreprise Services', 'SAS', 'SIS MARCHES', '', '692 049 109', 3,3,4);
INSERT INTO entreprise(id, code, commentaire, statut, nom, enseigne, siren, categorie_id, adresse_id, contact_id) VALUES (4, 'STHERBLAIN44800', 'Grande distribution', 'SARL', 'Carrefour', '', '692 049 109', 4,1,4);



INSERT INTO particulier(id, code, commentaire, civilite, nom, prenom, categorie_id, adresse_id, contact_id) VALUES (1, 'CAMARA PALAISEAU', 'Client premium', 'Mr', 'CAMARA', 'FODE', 2,1,3);
INSERT INTO particulier(id, code, commentaire, civilite, nom, prenom, categorie_id, adresse_id, contact_id) VALUES (2, 'KAKE NANTERRE', 'Client classic', 'Mr', 'KAKE', 'NFaly', 1,2,3);
INSERT INTO particulier(id, code, commentaire, civilite, nom, prenom, categorie_id, adresse_id, contact_id) VALUES (3, 'CONDE MEUDON', 'Client privilégié', 'Mme', 'CONDE', 'Lamaye',  3,3,4);
INSERT INTO particulier(id, code, commentaire, civilite, nom, prenom, categorie_id, adresse_id, contact_id) VALUES (4, 'MARA STHERBLAIN', 'prospect ', 'Mlle', 'MARA', 'Biba', 4,1,4);