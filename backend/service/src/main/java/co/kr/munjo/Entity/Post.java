package co.kr.munjo.Entity;

import co.kr.munjo.event.PostPublishedEvent;
import jakarta.persistence.*;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Post {

    @Id @GeneratedValue
    private Long id;

    private String title;

//    @OneToMany(mappedBy = "post", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
//    private Set<Comment> comments = new HashSet<>();

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }



//    public void addCommnet(Comment commet){
//        this.getComments().add(commet);
//        commet.setPost(this);
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public Set<Comment> getComments() {
//        return comments;
//    }

//    public void setComments(Set<Comment> comments) {
//        this.comments = comments;
//    }

//    public Post publish() {
//        this.registerEvent(new PostPublishedEvent(this));
//
//
//        return this;
//    }
}
