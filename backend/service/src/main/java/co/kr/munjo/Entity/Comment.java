package co.kr.munjo.Entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Comment {
    @Id @GeneratedValue
    private Long id;

    private String commentContext;

    @ManyToOne
    private Post post;

    private int up;

    private int down;

    private boolean best;


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Account getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Account createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Account getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Account updateUser) {
        this.updateUser = updateUser;
    }

    @CreatedDate
    private Date createTime;

    @CreatedBy
    @ManyToOne
    private Account createUser;

    @LastModifiedDate
    private Date updateTime;

    @LastModifiedBy
    @ManyToOne
    private Account updateUser;

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    private Integer likeCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentContext() {
        return commentContext;
    }

    public void setCommentContext(String commentContext) {
        this.commentContext = commentContext;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", commentContext='" + commentContext + '\'' +
                ", post=" + post +
                ", likeCount=" + likeCount +
                '}';
    }

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }

    public boolean isBest() {
        return best;
    }

    public void setBest(boolean best) {
        this.best = best;
    }


//    @PrePersist
//    public void perPersist(){
//        System.out.println("Pre Persist is called");
//        this.createTime = new Date();
//        this.createUser =
//
//    }
}
