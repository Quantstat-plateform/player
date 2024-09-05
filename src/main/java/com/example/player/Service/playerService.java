package com.example.player.Service;

import com.example.player.Entity.Player;
import com.example.player.Repository.PlayerRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class playerService implements IPlayerService {
    @Autowired
    private PlayerRepo playerRepository;

    @Override
    public long Ajouter_Player(Player p) {
        playerRepository.save(p);
        log.info("Player added successfully");
        return p.getId();
    }

    @Override
    public void removePlayer(Long idPlayer) {
        playerRepository.deleteById(idPlayer);
    }

    @Override
    public Player updatePlayer(Long id, Player updatedPlayer) {
        Optional<Player> existingPlayerOptional = playerRepository.findById(id);
        if (existingPlayerOptional.isPresent()) {
            Player existingPlayer = existingPlayerOptional.get();

            // Update the fields
            existingPlayer.setNumber(updatedPlayer.getNumber());
            existingPlayer.setPlayer(updatedPlayer.getPlayer());
            existingPlayer.setAge(updatedPlayer.getAge());
            existingPlayer.setHeight(updatedPlayer.getHeight());
            existingPlayer.setWeight(updatedPlayer.getWeight());
            existingPlayer.setNationality(updatedPlayer.getNationality());
            existingPlayer.setIndex(updatedPlayer.getIndex());
            existingPlayer.setMinutesPlayed(updatedPlayer.getMinutesPlayed());
            existingPlayer.setPosition(updatedPlayer.getPosition());

            // Update performance metrics
            existingPlayer.setGoalMistakes(updatedPlayer.getGoalMistakes());
            existingPlayer.setMistakes(updatedPlayer.getMistakes());
            existingPlayer.setGoals(updatedPlayer.getGoals());
            existingPlayer.setAssists(updatedPlayer.getAssists());
            existingPlayer.setChances(updatedPlayer.getChances());
            existingPlayer.setChancesSuccessful(updatedPlayer.getChancesSuccessful());
            existingPlayer.setChancesSuccessfulPercentage(updatedPlayer.getChancesSuccessfulPercentage());
            existingPlayer.setChancesCreated(updatedPlayer.getChancesCreated());
            existingPlayer.setShots(updatedPlayer.getShots());
            existingPlayer.setShotsOnTarget(updatedPlayer.getShotsOnTarget());

            // Update discipline metrics
            existingPlayer.setYellowCards(updatedPlayer.getYellowCards());
            existingPlayer.setRedCards(updatedPlayer.getRedCards());
            existingPlayer.setFouls(updatedPlayer.getFouls());
            existingPlayer.setFoulsSuffered(updatedPlayer.getFoulsSuffered());

            // Update passing metrics
            existingPlayer.setPasses(updatedPlayer.getPasses());
            existingPlayer.setPassesAccuratePercentage(updatedPlayer.getPassesAccuratePercentage());
            existingPlayer.setKeyPasses(updatedPlayer.getKeyPasses());
            existingPlayer.setKeyPassesAccuratePercentage(updatedPlayer.getKeyPassesAccuratePercentage());
            existingPlayer.setCrosses(updatedPlayer.getCrosses());
            existingPlayer.setCrossesAccuratePercentage(updatedPlayer.getCrossesAccuratePercentage());
            existingPlayer.setProgressivePasses(updatedPlayer.getProgressivePasses());
            existingPlayer.setProgressivePassesAccuratePercentage(updatedPlayer.getProgressivePassesAccuratePercentage());
            existingPlayer.setLongPasses(updatedPlayer.getLongPasses());
            existingPlayer.setLongPassesAccuratePercentage(updatedPlayer.getLongPassesAccuratePercentage());
            existingPlayer.setSuperLongPasses(updatedPlayer.getSuperLongPasses());
            existingPlayer.setSuperLongPassesAccuratePercentage(updatedPlayer.getSuperLongPassesAccuratePercentage());
            existingPlayer.setPassesForwardToFinalThird(updatedPlayer.getPassesForwardToFinalThird());
            existingPlayer.setPassesForwardToFinalThirdAccuratePercentage(updatedPlayer.getPassesForwardToFinalThirdAccuratePercentage());
            existingPlayer.setPassesIntoPenaltyBox(updatedPlayer.getPassesIntoPenaltyBox());
            existingPlayer.setPassesIntoPenaltyBoxAccuratePercentage(updatedPlayer.getPassesIntoPenaltyBoxAccuratePercentage());

            // Update challenges metrics
            existingPlayer.setChallenges(updatedPlayer.getChallenges());
            existingPlayer.setChallengesAccuratePercentage(updatedPlayer.getChallengesAccuratePercentage());
            existingPlayer.setDefensiveChallenges(updatedPlayer.getDefensiveChallenges());
            existingPlayer.setDefensiveChallengesAccuratePercentage(updatedPlayer.getDefensiveChallengesAccuratePercentage());
            existingPlayer.setAttackingChallenges(updatedPlayer.getAttackingChallenges());
            existingPlayer.setAttackingChallengesWonPercentage(updatedPlayer.getAttackingChallengesWonPercentage());
            existingPlayer.setAirChallenges(updatedPlayer.getAirChallenges());
            existingPlayer.setAirChallengesWonPercentage(updatedPlayer.getAirChallengesWonPercentage());

            // Update dribbling metrics
            existingPlayer.setDribbles(updatedPlayer.getDribbles());
            existingPlayer.setDribblesSuccessfulPercentage(updatedPlayer.getDribblesSuccessfulPercentage());
            existingPlayer.setDribblingInFinalThird(updatedPlayer.getDribblingInFinalThird());
            existingPlayer.setDribblingInFinalThirdSuccessfulPercentage(updatedPlayer.getDribblingInFinalThirdSuccessfulPercentage());

            // Update tackles and interceptions metrics
            existingPlayer.setTackles(updatedPlayer.getTackles());
            existingPlayer.setTacklesSuccessfulPercentage(updatedPlayer.getTacklesSuccessfulPercentage());
            existingPlayer.setInterceptions(updatedPlayer.getInterceptions());
            existingPlayer.setPickingUp(updatedPlayer.getPickingUp());
            existingPlayer.setXG(updatedPlayer.getXG());

            return playerRepository.save(existingPlayer);
        } else {
            log.warn("Player with ID " + id + " not found");
            return null;
        }
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public List<Player> getPlayersByPosition(String position) {
        return playerRepository.findByPosition(position);
    }
}
