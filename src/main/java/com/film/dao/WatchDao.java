package com.film.dao;

import com.film.entity.Watch;
import com.film.entity.WatchStatistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Watch)表数据库访问层
 *
 * @author Chen1myn
 * @since 2023-05-03 21:35:15
 */
 @Mapper
public interface WatchDao {

     List<WatchStatistics> queryWatch();
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Watch queryById(Integer id);



    /**
     * 统计总行数
     *
     * @param watch 查询条件
     * @return 总行数
     */
    long count(Watch watch);

    /**
     * 新增数据
     *
     * @param watch 实例对象
     * @return 影响行数
     */
    int insert(Watch watch);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Watch> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Watch> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Watch> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Watch> entities);

    /**
     * 修改数据
     *
     * @param watch 实例对象
     * @return 影响行数
     */
    int update(Watch watch);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

