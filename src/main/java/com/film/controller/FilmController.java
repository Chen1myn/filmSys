package com.film.controller;

import com.film.entity.Film;
import com.film.service.FilmService;
import com.film.service.ScoreService;
import com.film.service.TypeService;
import com.film.util.ResponseData;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.nio.file.Files;

/**
 * @author:Chen1myn
 * @time: 2023/5/4
 */
@Controller
public class FilmController {

    @Autowired
    FilmService filmService;
    @Autowired
    TypeService typeService;
    @Autowired
    ResponseData responseData;
    @Autowired
    ScoreService scoreService;

    /**
     * 去电影评级页面
     * @return
     */
    @GetMapping("/toFilmScore")
    public String toFilmScore(Model model){
        model.addAttribute("score",scoreService.queryAll());
        return "admin/filmScore";
    }
    /**
     * 电影新增
     * @param img
     * @param video
     * @param request
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/upload")
    public String upload(@RequestParam("img") MultipartFile img,
                         @RequestParam("video") MultipartFile video,
                         HttpServletRequest request,
                         Model model) throws Exception{
        String fname = request.getParameter("fname");
        String type = request.getParameter("type");
        String path = "E:\\JAVA-IDEA\\filmSys\\src\\main\\resources\\static\\";
        String path2 = "E:\\JAVA-IDEA\\filmSys\\target\\classes\\static\\";
        if (StringUtils.isNullOrEmpty(fname)){
            model.addAttribute("msg","can not be empty！");
        }else {
            Film film = new Film();
            film.setFname(fname);
            film.setType(type);
            film.setRate(0);
            film.setImg(img.getOriginalFilename());
            film.setVideo(video.getOriginalFilename());
            filmService.insert(film);
            try{
                img.transferTo(new File(path+"img\\"+img.getOriginalFilename()));
                video.transferTo(new File(path+"video\\"+video.getOriginalFilename()));
                Files.copy(new File(path+"img\\"+img.getOriginalFilename()).toPath(),
                        new File(path2+"img\\"+img.getOriginalFilename()).toPath());
                Files.copy(new File(path+"video\\"+video.getOriginalFilename()).toPath(),
                        new File(path2+"video\\"+video.getOriginalFilename()).toPath());
                model.addAttribute("msg","New film success！");
            }catch (Exception e){
                model.addAttribute("msg","The pictures or videos already exist. Do not upload them again！");
            }
                model.addAttribute("type", typeService.queryAll());

        }
        return "admin/filmAddition";
    }

    /**
     * 去电影添加页面
     * @return
     */
    @GetMapping("/toFilmAddition")
    public String toFilmAddition(Model model){
        model.addAttribute("type",typeService.queryAll());
        return "admin/filmAddition";
    }

    /**
     * 删除电影
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/deleteFilm")
    public String deleteFilm(@RequestParam(value = "id",defaultValue = "0") int id,Model model){
        filmService.deleteById(id);
        model.addAttribute("files",filmService.queryAll());
        return "admin/filmManage";
    }

    /**
     * 电影管理页面
     * @param model
     * @return
     */
    @GetMapping("/toFilmManage")
    public String toFilmManage(Model model){
        model.addAttribute("files",filmService.queryAll());
        return "admin/filmManage";
    }
}
