package com.nhnacademy.board.repository;

import com.nhnacademy.board.domain.Post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MemoryPostRepository implements PostRepository{

    Map<Long, Post> postMap = new HashMap<>();

    @Override
    public List<Post> getPosts() {
        return postMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public long register(Post post) {
        postMap.put(post.getId(),post);
        return post.getId();
    }

    @Override
    public void modify(Post post) {

    }

    @Override
    public Post remove(long id) {
        return null;
    }

    @Override
    public Post getPost(long id) {
        return null;
    }


}
