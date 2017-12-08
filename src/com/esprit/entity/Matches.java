/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entity;

import java.util.Date;

/**
 *
 * @author Rym
 */
public class Matches {
    int id_match;
    Date date_match;
    int satde_id_stade;
    int id_joueur_gagnant;
    int user_id_user;
    int joueur_id1_joueur;
    int joueur_id2_joueur;
    int tournoi_id_touroi;
    String duree_match;
    int score_joueur1;
    int score_joueur2;

    public Matches(int id_match, int user_id_user, int joueur_id1_joueur, int joueur_id2_joueur) {
        this.id_match = id_match;
        this.user_id_user = user_id_user;
        this.joueur_id1_joueur = joueur_id1_joueur;
        this.joueur_id2_joueur = joueur_id2_joueur;
    }

    public Matches(int id_match, int satde_id_stade, int user_id_user, int joueur_id1_joueur, int joueur_id2_joueur, int tournoi_id_touroi) {
        this.id_match = id_match;
        this.satde_id_stade = satde_id_stade;
        this.user_id_user = user_id_user;
        this.joueur_id1_joueur = joueur_id1_joueur;
        this.joueur_id2_joueur = joueur_id2_joueur;
        this.tournoi_id_touroi = tournoi_id_touroi;
    }

    public Matches(int id_match, int satde_id_stade, int id_joueur_gagnant, int user_id_user, int joueur_id1_joueur, int joueur_id2_joueur, int tournoi_id_touroi, int score_joueur1, int score_joueur2) {
        this.id_match = id_match;
        this.satde_id_stade = satde_id_stade;
        this.id_joueur_gagnant = id_joueur_gagnant;
        this.user_id_user = user_id_user;
        this.joueur_id1_joueur = joueur_id1_joueur;
        this.joueur_id2_joueur = joueur_id2_joueur;
        this.tournoi_id_touroi = tournoi_id_touroi;
        this.score_joueur1 = score_joueur1;
        this.score_joueur2 = score_joueur2;
    }

    public Matches(Date date_match, int satde_id_stade, int user_id_user, int joueur_id1_joueur, int joueur_id2_joueur, int tournoi_id_touroi) {
        this.date_match = date_match;
        this.satde_id_stade = satde_id_stade;
        this.user_id_user = user_id_user;
        this.joueur_id1_joueur = joueur_id1_joueur;
        this.joueur_id2_joueur = joueur_id2_joueur;
        this.tournoi_id_touroi = tournoi_id_touroi;
    }

    public Matches(int id_match, int satde_id_stade, int id_joueur_gagnant, int user_id_user, int joueur_id1_joueur, int joueur_id2_joueur, int tournoi_id_touroi, String duree_match, int score_joueur1, int score_joueur2) {
        this.id_match = id_match;
        this.satde_id_stade = satde_id_stade;
        this.id_joueur_gagnant = id_joueur_gagnant;
        this.user_id_user = user_id_user;
        this.joueur_id1_joueur = joueur_id1_joueur;
        this.joueur_id2_joueur = joueur_id2_joueur;
        this.tournoi_id_touroi = tournoi_id_touroi;
        this.duree_match = duree_match;
        this.score_joueur1 = score_joueur1;
        this.score_joueur2 = score_joueur2;
    }

    public Matches(Date date_match, int satde_id_stade, int id_joueur_gagnant, int user_id_user, int joueur_id1_joueur, int joueur_id2_joueur, int tournoi_id_touroi, String duree_match, int score_joueur1, int score_joueur2) {
        this.date_match = date_match;
        this.satde_id_stade = satde_id_stade;
        this.id_joueur_gagnant = id_joueur_gagnant;
        this.user_id_user = user_id_user;
        this.joueur_id1_joueur = joueur_id1_joueur;
        this.joueur_id2_joueur = joueur_id2_joueur;
        this.tournoi_id_touroi = tournoi_id_touroi;
        this.duree_match = duree_match;
        this.score_joueur1 = score_joueur1;
        this.score_joueur2 = score_joueur2;
    }

    public Matches(int id_match, Date date_match, int satde_id_stade, int id_joueur_gagnant, int user_id_user, int joueur_id1_joueur, int joueur_id2_joueur, int tournoi_id_touroi, String duree_match, int score_joueur1, int score_joueur2) {
        this.id_match = id_match;
        this.date_match = date_match;
        this.satde_id_stade = satde_id_stade;
        this.id_joueur_gagnant = id_joueur_gagnant;
        this.user_id_user = user_id_user;
        this.joueur_id1_joueur = joueur_id1_joueur;
        this.joueur_id2_joueur = joueur_id2_joueur;
        this.tournoi_id_touroi = tournoi_id_touroi;
        this.duree_match = duree_match;
        this.score_joueur1 = score_joueur1;
        this.score_joueur2 = score_joueur2;
    }

    public Matches(int id_match, Date date_match, int user_id_user, int joueur_id1_joueur, int joueur_id2_joueur) {
        this.id_match = id_match;
        this.date_match = date_match;
        this.user_id_user = user_id_user;
        this.joueur_id1_joueur = joueur_id1_joueur;
        this.joueur_id2_joueur = joueur_id2_joueur;
    }

    


    public int getTournoi_id_touroi() {
        return tournoi_id_touroi;
    }

    public String getDuree_match() {
        return duree_match;
    }

    public int getScore_joueur1() {
        return score_joueur1;
    }

    public int getScore_joueur2() {
        return score_joueur2;
    }

    public void setTournoi_id_touroi(int tournoi_id_touroi) {
        this.tournoi_id_touroi = tournoi_id_touroi;
    }

    public void setDuree_match(String duree_match) {
        this.duree_match = duree_match;
    }

    public void setScore_joueur1(int score_joueur1) {
        this.score_joueur1 = score_joueur1;
    }

    public void setScore_joueur2(int score_joueur2) {
        this.score_joueur2 = score_joueur2;
    }
    
    
    public Matches() {
    }


    public int getId_match() {
        return id_match;
    }

    public Date getDate_match() {
        return date_match;
    }

    public int getSatde_id_stade() {
        return satde_id_stade;
        
    }

    public int getId_joueur_gagnant() {
        return id_joueur_gagnant;
    }

    public int getUser_id_user() {
        return user_id_user;
    }

    public int getJoueur_id1_joueur() {
        return joueur_id1_joueur;
    }

    public int getJoueur_id2_joueur() {
        return joueur_id2_joueur;
    }



    public void setId_match(int id_match) {
        this.id_match = id_match;
    }

    public void setDate_match(Date date_match) {
        this.date_match = date_match;
    }

    public void setSatde_id_s(int satde_id_s) {
        this.satde_id_stade = satde_id_s;
    }

    public void setId_joueur_gagnant(int id_joueur_gagnant) {
        this.id_joueur_gagnant = id_joueur_gagnant;
    }

    public void setUser_id_user(int user_id_user) {
        this.user_id_user = user_id_user;
    }

    public void setJoueur_id1_joueur(int joueur_id1_joueur) {
        this.joueur_id1_joueur = joueur_id1_joueur;
    }

    public void setJoueur_id2_joueur(int joueur_id2_joueur) {
        this.joueur_id2_joueur = joueur_id2_joueur;
    }

    @Override
    public String toString() {
        return " date_match=" + date_match  + " duree_match=" + duree_match ;
    }

   
}
