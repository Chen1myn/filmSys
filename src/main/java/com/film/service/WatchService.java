package com.film.service;

import com.film.entity.Watch;
import com.film.entity.WatchStatistics;

import java.util.List;

/**
 * (Watch)表服务接口
 *
 * @author Chen1myn
 * @since 2023-05-03 21:35:15
 */
public interface WatchService {
    List<WatchStatistics> queryWatch();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Watch queryById(Integer id);

    /**
     * 新增数据
     *
     * @param watch 实例对象
     * @return 实例对象
     */
    Watch insert(Watch watch);

    /**
     * 修改数据
     *
     * @param watch 实例对象
     * @return 实例对象
     */
    Watch update(Watch watch);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
