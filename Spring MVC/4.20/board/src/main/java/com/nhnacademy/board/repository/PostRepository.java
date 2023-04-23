package com.nhnacademy.board.repository;

import com.nhnacademy.board.domain.ConcretePost;
import com.nhnacademy.board.domain.Post;

import java.util.List;

public interface PostRepository {
    long register(Post post);
    void modify(Post post);
    void remove(long id);

    ConcretePost getPost(long id);
    List<Post> getPosts();
}
