package com.example.player.Service;

import com.example.player.Entity.Player;

import java.util.List;

public interface IPlayerService {
    long Ajouter_Player(Player p);
    void removePlayer(Long idPlayer);
    Player updatePlayer(Long id, Player updatedPlayer);
    List<Player> getAllPlayers();
    List<Player> getPlayersByPosition(String position);
}
