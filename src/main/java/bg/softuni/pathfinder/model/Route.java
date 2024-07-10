package bg.softuni.pathfinder.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "routes")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "gpx_coordinates", columnDefinition = "LONGTEXT")
    private String gpxCordinates;

    @Enumerated(EnumType.STRING)
    private Level level;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "video_url")
    private  String videoUrl;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne(optional = false)
    private User author;

    @OneToMany(targetEntity = Comment.class, mappedBy = "route")
    private Set<Comment> comments;

    @OneToMany(targetEntity = Pictures.class, mappedBy = "route")
    private Set<Pictures> pictures;

    @ManyToMany
    private Set<Category> categories;


    public Route(){
        this.comments = new HashSet<>();
        this.pictures = new HashSet<>();
        this.categories = new HashSet<>();
    }


}
