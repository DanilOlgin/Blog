package com.blog.springblog.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column
    private String title;
    @Lob
    @Column
    @NotEmpty
    private String content;
    @Column
    private Instant createdOn;
    @Column
    private Instant updatedOn;
    @Column
    @NotBlank
    private String author;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<PostTags> tagsByPost;

    @ManyToOne
    private User user;



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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public Instant getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Instant updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String username) {
        this.author = username;
    }

    public Set<PostTags> getTagsByPost() {
        return tagsByPost;
    }

    public void setTagsByPost(Set<PostTags> tagsByPost) {
        this.tagsByPost = tagsByPost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
