package mt.mas.hibernate;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity(name = "Actor")
public class Actor {
    private long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Movie movie;
    private List<String> urls;

    /**
     * Required by Hibernate.
     */
    public Actor() {
    }

    public Actor(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
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

    @ManyToOne
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Basic
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Transient
    public String getName() {
        return getFirstName() + " " + getLastName();
    }

    @Transient
    public int getAge() {
        return Period.between(getBirthDate(), LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return String.format("Actor: %s born on %s, age: %s, movie: %s (#%s @%s)", getName(), getBirthDate(), getAge(), getMovie() != null ? getMovie().getTitle() : "---", getId(), super.hashCode());
    }

    @ElementCollection
    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}
