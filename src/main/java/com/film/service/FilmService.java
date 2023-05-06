package com.film.service;

import com.film.entity.Film;
import com.film.entity.TypeStatistics;

import java.util.List;

/**
 * (Film)表服务接口
 *
 * @author Chen1myn
 * @since 2023-05-03 21:35:14
 */
public interface FilmService {
    List<Film> queryAll();
    List<TypeStatistics> queryType();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Film queryById(Integer id);

    /**
     * 新增数据
     *
     * @param film 实例对象
     * @return 实例对象
     */
    Film insert(Film film);

    /**
     * 修改数据
     *
     * @param film 实例对象
     * @return 实例对象
     */
    Film update(Film film);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
