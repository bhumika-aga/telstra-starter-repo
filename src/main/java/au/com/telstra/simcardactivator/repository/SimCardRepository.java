package au.com.telstra.simcardactivator.repository;

import org.springframework.data.repository.CrudRepository;

import au.com.telstra.simcardactivator.entity.SimCardDetails;

public interface SimCardRepository extends CrudRepository<SimCardDetails, Long> {

}