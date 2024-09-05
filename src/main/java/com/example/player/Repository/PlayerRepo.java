package com.example.player.Repository;

import com.example.player.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepo extends JpaRepository<Player, Long> {
    List<Player> findByPosition(String position);
}
