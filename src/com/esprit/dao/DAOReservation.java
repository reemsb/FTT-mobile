/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.dao;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.esprit.entity.Reservation;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Rym
 */
public class DAOReservation {
    public void addReservation(Reservation res) {
        ConnectionRequest connectionRequest;
        connectionRequest = new ConnectionRequest() {
            @Override
            protected void readResponse(InputStream in) throws IOException {
                
            }

            @Override
            protected void postResponse() {
                
            }

        };

       connectionRequest.setUrl("http://localhost/codename/AddBookingTicket.php?date_recuperation_ticket" + res.getDate_recuperation_ticket()+ 
        "&ticket_id_ticket=" + res.getTicket_id_ticket()+ "&block=" + res.getBlock()
        + "&seat=" + res.getSeat());
        NetworkManager.getInstance().addToQueue(connectionRequest);
        
    }
    
}
