package com.dgc.DiscGolfLeagues.repository;

import com.dgc.DiscGolfLeagues.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
