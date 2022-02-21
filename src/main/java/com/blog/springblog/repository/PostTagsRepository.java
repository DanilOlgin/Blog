package com.blog.springblog.repository;

import com.blog.springblog.model.PostTags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostTagsRepository extends JpaRepository<PostTags, Long> {
}
