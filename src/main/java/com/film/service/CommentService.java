package com.film.service;

import com.film.entity.Comment;

import java.util.List;

/**
 * (Comment)表服务接口
 *
 * @author Chen1myn
 * @since 2023-05-03 21:35:12
 */
public interface CommentService {
    List<Comment> queryAll(Comment comment);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Comment queryById(Integer id);

    /**
     * 新增数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    Comment insert(Comment comment);

    /**
     * 修改数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    Comment update(Comment comment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
