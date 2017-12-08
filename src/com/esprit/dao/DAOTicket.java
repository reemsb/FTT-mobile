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
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import com.esprit.entity.Reservation;
import com.esprit.entity.Ticket;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author Rym
 */
public class DAOTicket {
    //info ticket var
 public static Form reservation;
    Button book, back, b,b1;
    Label lbticket, lbprix, lbdate, lbstade,date,label,label1;
    private Form form1;
    Container Container,Container1,Container2,Container3;
    ComboBox ComboBox,ComboBox1; 
    private  String picker;
    private Picker Picker;


    

    public void getTickets() {

        ConnectionRequest connectionRequest;

        connectionRequest = new ConnectionRequest() {

            List<Ticket> cl = new ArrayList<>();
            private String theme;

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
                                new Ticket(Integer.parseInt((String) obj.get("id_ticket")),
                                        (String) obj.get("libelle_ticket"),
                                        Float.parseFloat((String) obj.get("prix_ticket")),
                                        Integer.parseInt((String) obj.get("match_id_match")),
                                        Integer.parseInt((String) obj.get("stade_id_stade")),
                                        Integer.parseInt((String) obj.get("nbr_ticket_dispo"))));

                    }

                } catch (IOException err) {
                    Log.e(err);
                }
            }

            ;
            
             protected void postResponse() {
                  //list 
               
                //libelle_ticket
                Form f = new Form("the avaible tickets  ");
                Label lb = new Label("May you choose the ticket to book: ");

                Container cnt1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                f.add(cnt1);
                cnt1.add(lb);
                for (Ticket t : cl) {
                    Container cnt2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                    f.add(cnt2);
                    Button lbinfo = new Button(t.getLibelle_ticket());
                    cnt2.add(lbinfo);
                    /*                   lbinfo.addActionListener(ee -> {
                      });*/

                    lbinfo.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            // System.out.println(""+t.getLibelle_ticket());
                            Form f1 = new Form("ticket info");
                            Container cnt3 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                            f1.add(cnt3);
                            Label lbticket = new Label("label :" + t.getLibelle_ticket());
                            cnt3.add(lbticket);
                            Container cnt4 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                            f1.add(cnt4);
                            Label lbprix = new Label("Price: " + t.getPrix_ticket() + " DT");
                            cnt4.add(lbprix);

                            Container cnt5 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                            f1.add(cnt5);
                            Label lbdate = new Label("Date of the match:  2016-11-02");
                            cnt5.add(lbdate);

                            Container cnt6 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                            f1.add(cnt6);
                            Label lbstade = new Label("Stadium:  menzah stadium");
                            cnt6.add(lbstade);

                            Button back = new Button("back to tickets");
                            Button book = new Button("book it");
                            f1.add(back);
                            f1.add(book);
                            back.addActionListener(e -> f.show());
                            book.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    
                                    UIBuilder ui = new UIBuilder();
                                    Resources r = null;
                                    try {
                                        r = Resources.open("/theme.res");
                                    } catch (IOException ex) {
                                    }
                                    
                                    UIBuilder.registerCustomComponent("reservation", com.codename1.ui.Form.class);
                                    UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
                                    UIBuilder.registerCustomComponent("Button1", com.codename1.ui.Button.class);
                                    UIBuilder.registerCustomComponent("Picker", Picker.class);
                                    UIBuilder.registerCustomComponent("ComboBox", com.codename1.ui.ComboBox.class);
                                    UIBuilder.registerCustomComponent("ComboBox1", com.codename1.ui.ComboBox.class);
                                    UIBuilder.registerCustomComponent("date", com.codename1.ui.Label.class);
                                    UIBuilder.registerCustomComponent("label", com.codename1.ui.Label.class);
                                    UIBuilder.registerCustomComponent("label1", com.codename1.ui.Label.class);
                                    UIBuilder.registerCustomComponent("Container1", com.codename1.ui.Container.class);
                                    UIBuilder.registerCustomComponent("Container2", com.codename1.ui.Container.class);
                                    UIBuilder.registerCustomComponent("Container3", com.codename1.ui.Container.class);
                                     Container=(Container) reservation;
                                    Container1 = (Container) ui.findByName("Container1", Container);
                                    Container1 = (Container) ui.findByName("Container1", Container);
                                    Container2 = (Container) ui.findByName("Container2", Container);
                                    Container3 = (Container) ui.findByName("Container3", Container);
                                    
                                    date = (Label) ui.findByName("date", Container1);
                                    Picker=(Picker)ui.findByName("Picker", Container1);

                                    label = (Label) ui.findByName("label", Container2);
                                    label1 = (Label) ui.findByName("label1", Container3);
                                    b = (Button) ui.findByName("Button", Container);
                                    b1 = (Button) ui.findByName("Button1", Container);
                                    
                                    ComboBox = (ComboBox) ui.findByName("ComboBox", Container2);
                                    ComboBox1 = (ComboBox) ui.findByName("ComboBox1",Container3);
                                    b.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent ev) {
                                            try {
                                                //Logger.getLogger(DAOTicket.class.getName()).log(Level.SEVERE, null, ex);
                                                
                                                
                                                int id=t.getId_ticket();
                                                String b=ComboBox.getSelectedItem().toString();
                                                String c=ComboBox1.getSelectedItem().toString();
                                                picker=Picker.getText();
                                                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd");
                                                
                                                Date   d = formatter.parse(picker);
                                                
                                                Reservation res =new Reservation(d,id,b,c);
                                                new DAOReservation().addReservation(res);
                                            } catch (ParseException ex) {
                                              //  Logger.getLogger(DAOTicket.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }});             
                                reservation.show();
                                }
                            });
                            f1.show();
                        }
                    });

                }
                f.show();

            }
        };
        connectionRequest.setUrl(
                "http://localhost/CodeNameFTT/InfoTicket.php");
        NetworkManager.getInstance()
                .addToQueueAndWait(connectionRequest);
    }

;
}
