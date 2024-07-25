package au.com.telstra.simcardactivator.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import au.com.telstra.simcardactivator.entity.SimCardDetails;

@Repository
public interface SimCardRepository extends CrudRepository<SimCardDetails, Long> {

}