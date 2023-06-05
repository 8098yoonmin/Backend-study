package com.nhnacademy.board_remind.repository;

import com.nhnacademy.board_remind.domain.Posts;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PostRepository {

    Map<Long, Posts> postMap = new HashMap<>();

    public long register(Posts post){
        postMap.put(post.getId(),post);
        return post.getId();
    }

    public void modify(Posts post) {
        postMap.put(post.getId(),post);
    }

    public void remove(Long id){
        postMap.remove(id);
    }

    public Posts getPost(Long id){
        return postMap.get(id);
    }

    public List<Posts> getPosts(){
        return postMap.values().stream().collect(Collectors.toList());
    }
}
