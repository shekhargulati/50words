package com.fiftywords.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.fiftywords.domain.Story;

public interface StoryRepository extends PagingAndSortingRepository<Story, String> {

}
