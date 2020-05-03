package mt.mas.hibernate;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Sample class for Hibernate (the annotation approach).
 */
@Entity(name = "Movie")
public class Movie {
    public enum MovieCategory {Unknown, Comedy, SciFi}

    private long id;
    private LocalDate releaseDate;
    private String title;
    private MovieCategory movieCategory;

    private List<Actor> actors = new ArrayList<>();

    /**
     * Required by Hibernate.
     */
    public Movie() {
    }

    public Movie(String title, LocalDate releaseDate, MovieCategory movieCategory) {
        this.releaseDate = releaseDate;
        this.title = title;
        this.movieCategory = movieCategory;
    }

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Actor> getActors() {
        return actors;
    }

    private void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public void addActor(Actor actor) {
        getActors().add(actor);
        actor.setMovie(this);
    }

    public void removeActor(Actor actor) {
        getActors().remove(actor);
        actor.setMovie(null);
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    @Basic
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Basic
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Enumerated
    public MovieCategory getMovieCategory() {
        return movieCategory;
    }

    public void setMovieCategory(MovieCategory movieCategory) {
        this.movieCategory = movieCategory;
    }

    @Override
    public String toString() {
        // The code could be optimized.
        var sb = new StringBuilder();

        sb.append(String.format("Movie: %s released on %s as %s (#%s @%s)", getTitle(), getReleaseDate(), getMovieCategory(), getId(), super.hashCode()));
        sb.append("\n   Actors: ");
        sb.append(getActors().size() == 0 ? "---" : "");
        for (var actor : getActors()) {
            sb.append(actor);
            sb.append("; ");
        }
        return sb.toString();
    }
}