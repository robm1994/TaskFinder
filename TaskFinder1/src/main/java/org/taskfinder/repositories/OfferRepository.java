package org.taskfinder.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.taskfinder.entities.Offer;
import org.taskfinder.entities.Task;
import org.taskfinder.entities.User;


public interface OfferRepository  extends JpaRepository<Offer, Long> {

	List<Offer> findByUser(User user);
	List<Offer> findByTask(Task task);
	//List<Offer> findById(Long id);
	Offer findOne(Long id);
	//Offer findAcceptedOffer(Offer offer);

//	List<Offer> findOne(Task task);

}

