package com.film.controller;

import com.film.entity.Comment;
import com.film.entity.Film;
import com.film.entity.User;
import com.film.entity.Watch;
import com.film.service.CommentService;
import com.film.service.FilmService;
import com.film.service.WatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author:Chen1myn
 * @time: 2023/5/4
 */
@Controller
public class UserFilm {

    @Autowired
    FilmService filmService;
    @Autowired
    CommentService commentService;
    @Autowired
    WatchService watchService;

    /**
     * 查看电影
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/filmInfo")
    public String filmInfo(@RequestParam(value = "id",defaultValue = "0") int id, Model model, HttpSession session){
        Film film = filmService.queryById(id);
        //添加查看电影表，统计年龄
        User user = (User)session.getAttribute("user");
        Watch watch = new Watch();
        watch.setAge(user.getAge());
        watch.setFname(film.getFname());
        watchService.insert(watch);
        //电影浏览次数+1，统计收视率
        film.setRate(film.getRate()+1);
        filmService.update(film);
        //显示该电影的评论
        Comment comment = new Comment();
        comment.setFid(id);
        model.addAttribute("comment",commentService.queryAll(comment));
        model.addAttribute("film",film);
        return "user/filmInfo";
    }
    /**
     * 电影页面
     * @param model
     * @return
     */
    @GetMapping("/toFilmShow")
    public String toFilmShow(Model model){
        model.addAttribute("films",filmService.queryAll());
        return "user/filmShow";
    }
}
