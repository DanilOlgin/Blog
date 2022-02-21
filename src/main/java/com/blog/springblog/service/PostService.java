package com.blog.springblog.service;

import com.blog.springblog.dto.PostDto;
import com.blog.springblog.exception.PostNotFoundException;
import com.blog.springblog.model.Post;
import com.blog.springblog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class PostService {

    @Autowired
    private AuthService authService;
    @Autowired
    private PostRepository postRepository;

    public void createPost(PostDto postDto) throws Throwable {

        Post post = mapFromDtoToPost(postDto);
        postRepository.save(post);
    }

    public List<PostDto> showAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(this::mapFromPostToDto).collect(toList());
    }

    private PostDto mapFromPostToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setContent(post.getContent());
        postDto.setUsername(post.getAuthor());
        postDto.setTitle(post.getTitle());
        return postDto;
    }

    private Post mapFromDtoToPost(PostDto postDto) throws Throwable {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());

        User loggedInUser = (User) authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("No such User found"));
        post.setAuthor(loggedInUser.getUsername());
        post.setCreatedOn(Instant.now());
        post.setUpdatedOn(Instant.now());
        return post;
    }
//TODO rename + tags + manyToMany etc + roles(superadmin admin user/reader) + likes/rating + pagination + replace mapfromdtoto
    public PostDto readSinglePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("No such id found" + id));
        return mapFromPostToDto(post);
    }
}
