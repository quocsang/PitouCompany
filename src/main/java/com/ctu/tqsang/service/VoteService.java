package com.ctu.tqsang.service;

import com.ctu.tqsang.domain.Vote;

public interface VoteService {

	Vote findOne(int aid, int uid);

	void create(Vote vote);
	
}
