package com.film.service.impl;

import com.film.entity.Watch;
import com.film.dao.WatchDao;
import com.film.entity.WatchStatistics;
import com.film.service.WatchService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Watch)表服务实现类
 *
 * @author BruceQ
 * @since 2023-05-03 21:35:15
 */
@Service("watchService")
public class WatchServiceImpl implements WatchService {
    @Resource
    private WatchDao watchDao;

    @Override
    public List<WatchStatistics> queryWatch() {
        return watchDao.queryWatch();
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Watch queryById(Integer id) {
        return this.watchDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param watch 实例对象
     * @return 实例对象
     */
    @Override
    public Watch insert(Watch watch) {
        this.watchDao.insert(watch);
        return watch;
    }

    /**
     * 修改数据
     *
     * @param watch 实例对象
     * @return 实例对象
     */
    @Override
    public Watch update(Watch watch) {
        this.watchDao.update(watch);
        return this.queryById(watch.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.watchDao.deleteById(id) > 0;
    }
}
