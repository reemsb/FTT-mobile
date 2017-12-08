/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.dao;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.esprit.entity.Stade;
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
public class DAOStade {
    public void getClub(int id) {
        
        ConnectionRequest connectionRequest;
        connectionRequest = new ConnectionRequest() {
        
        List<Stade> sl = new ArrayList<>();

            @Override
            public void readResponse(InputStream in) throws IOException {

                JSONParser json = new JSONParser();
                try {
                    Reader reader = new InputStreamReader(in, "UTF-8");

                    Map<String, Object> data = json.parseJSON(reader);

                    List<Map<String, Object>> content
                            = (List<Map<String, Object>>) data.get("root");
                    sl.clear();
                    for (Map<String, Object> obj : content) {
                        
                            sl.add(new Stade(Integer.parseInt((String) obj.get("id_stade")),(String) obj.get("libelle_stade")));
                            
                        } 
                    
                } catch (IOException err) {
                    Log.e(err);
                }
    
};
        };
    }}


