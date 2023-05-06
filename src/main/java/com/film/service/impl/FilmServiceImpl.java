package com.film.service.impl;

import com.film.entity.Film;
import com.film.dao.FilmDao;
import com.film.entity.TypeStatistics;
import com.film.service.FilmService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Film)表服务实现类
 *
 * @author BruceQ
 * @since 2023-05-03 21:35:14
 */
@Service("filmService")
public class FilmServiceImpl implements FilmService {
    @Resource
    private FilmDao filmDao;

    @Override
    public List<Film> queryAll() {
        return filmDao.queryAll();
    }

    @Override
    public List<TypeStatistics> queryType() {
        return filmDao.queryType();
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Film queryById(Integer id) {
        return this.filmDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param film 实例对象
     * @return 实例对象
     */
    @Override
    public Film insert(Film film) {
        this.filmDao.insert(film);
        return film;
    }

    /**
     * 修改数据
     *
     * @param film 实例对象
     * @return 实例对象
     */
    @Override
    public Film update(Film film) {
        this.filmDao.update(film);
        return this.queryById(film.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.filmDao.deleteById(id) > 0;
    }
}
