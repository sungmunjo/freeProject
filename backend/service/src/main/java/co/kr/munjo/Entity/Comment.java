package co.kr.munjo.Entity;

import jakarta.persistence.*;

@Entity
public class Comment {
    @Id @GeneratedValue
    private Long id;

    private String CommentContext;

    @ManyToOne
    private Post post;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentContext() {
        return CommentContext;
    }

    public void setCommentContext(String commentContext) {
        CommentContext = commentContext;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
