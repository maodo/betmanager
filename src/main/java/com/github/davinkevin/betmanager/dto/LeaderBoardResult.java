package com.github.davinkevin.betmanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.davinkevin.betmanager.entity.Bet;
import com.github.davinkevin.betmanager.entity.User;

import javax.annotation.concurrent.Immutable;
import java.util.List;

/**
 * Created by kevin on 16/08/15 for betmanager
 */
@Immutable
public class LeaderBoardResult {

    final String username;
    final Long score;

    public LeaderBoardResult(User user, List<Bet> bets) {
        this.username = user.getUsername();
        this.score = bets
                .stream()
                .filter(Bet::isValid)
                .count();
    }



    @JsonProperty("username")
    public String username() {
        return username;
    }

    @JsonProperty("score")
    public Long score() {
        return score;
    }
}
