package fr.isima.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter private Long id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "GAME_FRANCHISE_ID")
    @JsonIgnore
    @Getter @Setter private  GameFranchise gameFranchise;

    @ElementCollection
    @JsonIgnore
    @Getter @Setter private List<Integer> playabilityScores;

    @ElementCollection
    @JsonIgnore
    @Getter @Setter private List<Integer> graphicsScores;

    @ElementCollection
    @JsonIgnore
    @Getter @Setter private List<Integer> interestScores;

    @NotNull
    @Getter @Setter private String name;

    @NotNull
    @Getter @Setter private String description;

    @ManyToMany(cascade= CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "GAME_CONSOLE",
            joinColumns = { @JoinColumn(name = "ID_CONSOLE", referencedColumnName = "ID") },
            inverseJoinColumns = { @JoinColumn(name = "ID_GAME", referencedColumnName = "ID") })
    @Getter @Setter private Set<Console> consoles;

    @Column(nullable = false, length = 5000)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Getter @Setter private byte[] image;

    @Transient
    public int getPlayability() {
        if(playabilityScores == null || playabilityScores.size() == 0) {
            return 0;
        }
        int somme = 0;
        for(int score : playabilityScores) {
            somme += score;
        }

        return somme / playabilityScores.size();
    }

    @Transient
    public int getGraphics() {
        if(graphicsScores == null || graphicsScores.size() == 0) {
            return 0;
        }
        int somme = 0;
        for(int score : graphicsScores) {
            somme += score;
        }

        return somme / graphicsScores.size();
    }

    @Transient
    public int getInterest() {
        if(interestScores == null || interestScores.size() == 0) {
            return 0;
        }
        int somme = 0;
        for(int score : interestScores) {
            somme += score;
        }

        return somme / interestScores.size();
    }
}
