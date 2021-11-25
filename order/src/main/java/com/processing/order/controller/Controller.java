package com.processing.order.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.processing.order.model.MemberShip;
import com.processing.order.model.Order;
import com.processing.order.model.Shipping;
import com.processing.order.repository.MemberShipRepository;
import com.processing.order.repository.OrderRepository;
import com.processing.order.repository.ShippingRepository;

@RestController
//@RequestMapping("/payment")
public class Controller {
	@Autowired
	OrderRepository orderRep;
	
	@Autowired
	ShippingRepository shippingRep;
	
	@Autowired
	MemberShipRepository membershipRepo;
	
	@PostMapping("/product")
	ResponseEntity<Shipping> payementProd(@RequestBody Order order){
		Order odr= orderRep.save(new Order(order.getType(), order.getOwner(), order.getCost()));
		// generating shipping id for product payment
		Shipping ship = shippingRep.save(new Shipping(odr.getType(), "Shipped"));
		return new ResponseEntity<>(ship,HttpStatus.CREATED);
	}
	
	@PostMapping("/membership")
	ResponseEntity<MemberShip> membership(@RequestBody MemberShip memship){
		MemberShip mem= membershipRepo.save(new MemberShip(memship.getName(), memship.getEmail(),"Activated"));
		sendMail(mem.getEmail());
		return new ResponseEntity<>(mem,HttpStatus.CREATED);
	}
	
	@PostMapping("/upgrade")
	ResponseEntity<MemberShip> upgrade(@RequestBody MemberShip memship){
		MemberShip mem= membershipRepo.save(new MemberShip(memship.getName(),memship.getEmail(), "Upgraded"));
		sendMail(mem.getEmail());
		return new ResponseEntity<>(mem,HttpStatus.CREATED);
	}
	
	@Autowired
    private JavaMailSender sender;
	public String sendMail(String email) {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo(email);
            helper.setText("HI");
            helper.setSubject("Mail for MemberShip Activation/Upgrade");
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Error while sending mail ..";
        }
        sender.send(message);
        return "Mail Sent Success!";
    }
}

