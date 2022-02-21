package com.blog.springblog.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class PostTags {
    @Id
    private String tagName;

    @ManyToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "tagsByPost")
    private Set<Post> postsByTag;


    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Set<Post> getPostsByTag() {
        return postsByTag;
    }

    public void setPostsByTag(Set<Post> postsByTag) {
        this.postsByTag = postsByTag;
    }
}
