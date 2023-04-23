package com.nhnacademy.board.controller.board;

import com.nhnacademy.board.domain.ConcretePost;
import com.nhnacademy.board.domain.Post;
import com.nhnacademy.board.domain.User;
import com.nhnacademy.board.request.PostRegisterRequset;
import com.nhnacademy.board.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.Binding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/board")
public class PostListController {

    private final PostService postService;

    public PostListController(PostService postService) {
        this.postService = postService;
    }


    @GetMapping("/list")
    public String list(Model model) {
        List<Post> boardList = postService.getPostList();
        model.addAttribute("boardList", boardList);
        return "board/boardList";
    }

    @GetMapping("/register")
    public String postForm(Model model) {
        Post post = new ConcretePost();
        model.addAttribute("post", post);
        return "board/register";
    }

    @PostMapping("/register")
    public String register(@Valid PostRegisterRequset postRegisterRequset, BindingResult bindingResult, HttpServletRequest req) {
        Long id = postService.getId();
        //로그인 할 때 생성했던 세션
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        postService.register(new ConcretePost(id, postRegisterRequset.getTitle(), postRegisterRequset.getContent(), user.getUserId()));
        return "redirect:/board/list";
    }
}
