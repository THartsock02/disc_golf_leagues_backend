package com.dgc.DiscGolfLeagues.model;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "score")
    private int score;
    @Column(name = "tag_in")
    private int tagIn;
    @Column(name = "tag_out")
    private int tagOut;
    @Column(name = "starting_hole")
    private int startingHole;
    @Column(name = "pair")
    private int pair;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "division_id", nullable = false)
    private Division division;

    public Player() {

    }

    public Player(String firstName, String lastName, Division division, int tagIn, int tagOut, int score, int startingHole, int pair) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.division = division;
        this.score = score;
        this.tagIn = tagIn;
        this.tagOut = tagOut;
        this.startingHole = startingHole;
        this.pair = pair;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTagIn() {
        return tagIn;
    }

    public void setTagIn(int tagIn) {
        this.tagIn = tagIn;
    }

    public int getTagOut() {
        return tagOut;
    }

    public void setTagOut(int tagOut) {
        this.tagOut = tagOut;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public int getStartingHole() {
        return startingHole;
    }

    public void setStartingHole(int startingHole) {
        this.startingHole = startingHole;
    }

    public int getPair() {
        return pair;
    }

    public void setPair(int pair) {
        this.pair = pair;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", score=" + score +
                ", tagIn=" + tagIn +
                ", tagOut=" + tagOut +
                ", startingHole=" + startingHole +
                ", pair=" + pair +
                ", division=" + division +
                '}';
    }
}
