package com.film.controller;

import com.film.entity.Film;
import com.film.entity.TypeStatistics;
import com.film.entity.WatchStatistics;
import com.film.service.FilmService;
import com.film.service.WatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author:Chen1myn
 * @time: 2023/5/4
 */
@Controller
public class StatisticsController {

    @Autowired
    FilmService filmService;
    @Autowired
    WatchService watchService;

    /**
     * 打开年龄统计页面
     * @return
     */
    @GetMapping("/toAgeStatistics")
    public String toAgeStatistics(){
        return "admin/ageStatistics";
    }
    /**
     * 年龄数据
     * @return
     */
    @ResponseBody
    @GetMapping("/ageStatistics")
    public List<WatchStatistics> ageStatistics(){
        return watchService.queryWatch();
    }

    /**
     * 打开电影类型页面
     * @return
     */
    @GetMapping("/toTypeStatistics")
    public String toTypeStatistics(){
        return "admin/typeStatistics";
    }
    /**
     * 类型数据
     * @return
     */
    @ResponseBody
    @GetMapping("/typeStatistics")
    public List<TypeStatistics> typeStatistics(){
        return filmService.queryType();
    }
    /**
     * 打开收视率统计页面
     * @return
     */
    @GetMapping("/toRateStatistics")
    public String toRateStatistics(){
        return "admin/rateStatistics";
    }

    /**
     * 所有的电影收视率数据
     * @return
     */
    @ResponseBody
    @GetMapping("/rateStatistics")
    public List<Film> rateStatistics(){
        return filmService.queryAll();
    }
}
