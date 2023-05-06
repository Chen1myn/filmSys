package com.film.service;

import com.film.entity.User;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author Chen1myn
 * @since 2023-05-03 21:35:14
 */
public interface UserService {

    List<User> queryAll(User user);
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Integer id);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
