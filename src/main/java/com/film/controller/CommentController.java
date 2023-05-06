package com.film.controller;

import com.film.entity.Comment;
import com.film.entity.Film;
import com.film.entity.Score;
import com.film.entity.User;
import com.film.service.CommentService;
import com.film.service.FilmService;
import com.film.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author:Chen1myn
 * @time: 2023/5/4
 */
@Controller
public class CommentController {

    @Autowired
    FilmService filmService;
    @Autowired
    CommentService commentService;
    @Autowired
    ScoreService scoreService;

    /**
     * 评级
     * @param model
     * @param request
     * @param session
     * @return
     */
    @PostMapping("/addScore")
    public String addScore(Model model, HttpServletRequest request, HttpSession session){
        int id = Integer.parseInt(request.getParameter("fid"));
        User user = (User)session.getAttribute("user");
        String fname = request.getParameter("fname");
        String star = request.getParameter("star");
        //打分
        Score score = new Score();
        score.setFname(fname);
        score.setStar(star);
        score.setUname(user.getAccount());
        scoreService.insert(score);
        Film film = filmService.queryById(id);
        Comment comment = new Comment();
        comment.setFid(id);
        model.addAttribute("comment",commentService.queryAll(comment));
        model.addAttribute("film",film);
        return "user/filmInfo";
    }
    /**
     * 添加评论
     * @param model
     * @param request
     * @param session
     * @return
     */
    @PostMapping("/addComment")
    public String addComment(Model model, HttpServletRequest request, HttpSession session){
        int id = Integer.parseInt(request.getParameter("fid"));
        String content = request.getParameter("content");
        User user = (User)session.getAttribute("user");
        Film film = filmService.queryById(id);
        Comment comment = new Comment();
        comment.setFid(id);
        comment.setContent(content);
        comment.setUname(user.getAccount());
        comment.setTime(new Date());
        commentService.insert(comment);
        Comment comment1 = new Comment();
        comment1.setFid(id);
        model.addAttribute("comment",commentService.queryAll(comment1));
        model.addAttribute("film",film);
        return "user/filmInfo";
    }
}
