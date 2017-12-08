/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.dao;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Label;
import com.esprit.entity.Matches;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



/**
 *
 * @author Rym
 */
public class Matchesapp {
   public  Label lbdate=new Label();
        public void getMatch(int id) throws ParseException {  
                               SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        ConnectionRequest connectionRequest;
        connectionRequest = new ConnectionRequest() {
            List<Matches> lm = new ArrayList<>();
            @Override
            protected void readResponse(InputStream in) throws IOException {

                JSONParser json = new JSONParser();
                try {
                    Reader reader = new InputStreamReader(in, "UTF-8");

                    Map<String, Object> data = json.parseJSON(reader);

                    List<Map<String, Object>> content
                            = (List<Map<String, Object>>) data.get("root");
                    lm.clear();
                    for (Map<String, Object> obj : content) {

                           lm.add(

                                    new Matches(Integer.parseInt((String) obj.get("id_match")), 
                                            
                                            formatter.parse((String) obj.get("date_match")),
                                            Integer.parseInt((String) obj.get("user_id_user")),
                                            Integer.parseInt((String) obj.get("joueur_id1_joueur")),
                                            Integer.parseInt((String) obj.get("joueur_id2_joueur")))
                            );
                        } 
                    
                } catch (IOException err) {
                    Log.e(err);
                } catch (ParseException ex) {
                }
            }

            @Override
            protected void postResponse() {
                 { 
                                   for (Matches M : lm)
                                   {   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                                   String a=M.getDate_match().toString();
                                   ;
                                   lbdate.setText(a);
                                   };
                  
                  
            };
            }
                  
        };
        connectionRequest.setUrl("http://localhost/codename/matches.php?idm="+id);
        NetworkManager.getInstance().addToQueue(connectionRequest);
        
    }

    
}
