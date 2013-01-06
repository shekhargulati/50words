package com.fiftywords.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.fiftywords.domain.Challenge;

/**
 * Repostiory for CRUD,Finders, Paging, and Sorting operations on Challenge document.
 * 
 * @author shekhargulati
 *
 */
@Repository
public interface ChallengeRepository extends PagingAndSortingRepository<Challenge, String> {

}
