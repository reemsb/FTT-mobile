/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.dao;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.esprit.entity.Club;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Rym
 */
public class DAOClub {
    public void getClub(int id) {
        
        ConnectionRequest connectionRequest;
        connectionRequest = new ConnectionRequest() {
        
        List<Club> cl = new ArrayList<>();

            @Override
            public void readResponse(InputStream in) throws IOException {

                JSONParser json = new JSONParser();
                try {
                    Reader reader = new InputStreamReader(in, "UTF-8");

                    Map<String, Object> data = json.parseJSON(reader);

                    List<Map<String, Object>> content
                            = (List<Map<String, Object>>) data.get("root");
                    cl.clear();
                    for (Map<String, Object> obj : content) {
                        
                            cl.add(
                                    
                                    new Club((String) obj.get("libelle_club"),(String) obj.get("adresse_club"),(String) obj.get("ville_club"),(String) obj.get("numero_telephone"),(String) obj.get("numero_fax"),(int) obj.get("nbr_terrain"),(float) obj.get("budget_club")));
                            
                        } 
                    
                } catch (IOException err) {
                    Log.e(err);
                }
    
};
        };
    }}
