package com.example.player.Controller;

import com.example.player.Entity.Player;
import com.example.player.Service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Player")
@CrossOrigin(origins = "http://localhost:4200")
public class PlayerController {
    @Autowired
    IPlayerService playerService;

    @PostMapping("/addPlayer")
    @ResponseBody
    public ResponseEntity<String> addPlayer(@RequestBody Player player) {
        playerService.Ajouter_Player(player);
        String message = "Player ajouté avec succès";
        return ResponseEntity.ok(message);
    }
    @DeleteMapping("/removePlayer/{idPlayer}")
    @ResponseBody
    public ResponseEntity<String> removeTerrain(@PathVariable("idPlayer") Long idPlayer) {
      playerService.removePlayer(idPlayer);
        String message = "Player supprimé avec succès";
        return ResponseEntity.ok(message);
    }

    @PutMapping("/updatePlayer/{id}")
    public ResponseEntity<String> updateTerrain(@PathVariable Long id, @RequestBody Player updatedPlayer) {
        Player updated = playerService.updatePlayer(id, updatedPlayer);

        if (updated != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Modification du Player avec succès");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player avec l'ID " + id + " non trouvé");
        }
    }

    @GetMapping("/listPlayers")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }
//
//    @GetMapping("/terrains/position")
//    public ResponseEntity<List<Terrain>> getTerrainsByPosition(
//            @RequestParam(value = "position") String position
//    ) {
//        List<Terrain> terrains = terrainService.getTerrainsByPosition(position);
//        return ResponseEntity.ok(terrains);
//    }
}
