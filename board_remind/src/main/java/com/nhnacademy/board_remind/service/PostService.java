package com.nhnacademy.board_remind.service;

import com.nhnacademy.board_remind.domain.Posts;
import com.nhnacademy.board_remind.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PostService {

    PostRepository postRepository;

    public List<Posts> getPostList(){
        return postRepository.getPosts();
    }
    public List<Posts> getPartList(int num){
        num = (num-1)*10;
        int size=10;
        List<Posts> postList = new ArrayList<>();
        List<Posts> list = postRepository.getPosts();
        if(list.size()<num+10){
            size=list.size()-num;
        }
        for(int i=0;i<size;i++){
            postList.add(list.get(num));
            num++;
        }
        return postList;
    }


}
