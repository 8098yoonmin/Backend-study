package com.nhnacademy.board_remind.controller.user;

import com.nhnacademy.board_remind.domain.Posts;
import com.nhnacademy.board_remind.domain.Users;
import com.nhnacademy.board_remind.request.PostRegisterRequest;
import com.nhnacademy.board_remind.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/post")
@AllArgsConstructor
public class PostController {

    PostService postService;

    @GetMapping
    public String getPosts(@RequestParam(name = "page") int page, Model model) {
        List<Posts> postList = postService.getPostList();
        List<Posts> postPartList = postService.getPartList(page);
        int last = postList.size() / 10;
        model.addAttribute("postList",postPartList);
        if(last == 0){
            return "post/postList";
        }
        if(page==1){
            model.addAttribute("nextPage",2);
        }
        else if(page==last){
            model.addAttribute("prePage",page-1);
        }
        else{
            model.addAttribute("prePage",page-1);
            model.addAttribute("nextPage",page+1);
        }
        return "post/postList";
    }

    @PostMapping("/register")
    public String addRegister(PostRegisterRequest postRegisterRequest, HttpServletRequest req){
        Long id = postService.getId();
        HttpSession session = req.getSession();
        Users user = (Users) session.getAttribute("user");
        postService.register(new Posts(id, postRegisterRequest.getTitle(), postRegisterRequest.getContent(), user.getId()));
        return "redirect:/post?page=1";

    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("post", new Posts());
        return "post/postRegister";
    }







}
