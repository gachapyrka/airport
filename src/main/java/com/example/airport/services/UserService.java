package com.example.airport.services;

import com.example.airport.domain.ClientInfo;
import com.example.airport.domain.Ticket;
import com.example.airport.repos.ClientInfoRepo;
import com.example.airport.repos.TicketRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final ClientInfoRepo userRepo;
    private final TicketRepo ticketRepo;

    public UserService(ClientInfoRepo userRepo, TicketRepo ticketRepo) {
        this.userRepo = userRepo;
        this.ticketRepo = ticketRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepo.findByUsername(s);
    }

    public Double calculateDiscount(ClientInfo user){
        int count = 0;
        for(Ticket t: ticketRepo.findAllByClientInfo_Id(user.getId())){
            if(t.getBoughtTicket() != null){
                count++;
            }
        }
        return (double)count%15;
    }
}
