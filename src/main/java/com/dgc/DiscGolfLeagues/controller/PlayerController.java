package com.dgc.DiscGolfLeagues.controller;

import com.dgc.DiscGolfLeagues.model.Player;
import com.dgc.DiscGolfLeagues.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @PostMapping()
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        try {
            Player p = new Player(player.getFirstName(), player.getLastName(), player.getDivision(), player.getTagIn(), player.getTagOut(), player.getScore(), player.getStartingHole(), player.getPair());
            Player _player = playerRepository
                    .save(p);
            return new ResponseEntity<>(_player, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable("id") long id, @RequestBody Player player) {
        Optional<Player> playerData = playerRepository.findById(id);

        if (playerData.isPresent()) {
            Player _player = playerData.get();
            _player.setId(player.getId());
            _player.setFirstName(player.getFirstName());
            _player.setLastName(player.getLastName());
            _player.setDivision(player.getDivision());
            _player.setTagIn(player.getTagIn());
            _player.setTagOut(player.getTagOut());
            _player.setScore(player.getScore());
            _player.setStartingHole(player.getStartingHole());
            _player.setPair(player.getPair());
            return new ResponseEntity<>(playerRepository.save(_player), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePlayer(@PathVariable("id") long id) {
        try {

            playerRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getEventById(@PathVariable("id") long id) {
        Optional<Player> playerData = playerRepository.findById(id);

        return playerData.map(player -> new ResponseEntity<>(player, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
