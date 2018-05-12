package com.ctu.tqsang.dao;

import com.ctu.tqsang.domain.Vote;

public interface VoteDAO {

    Vote findOne(int aid, int uid);

    void create(Vote vote);

}
