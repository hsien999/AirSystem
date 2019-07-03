package cn.wyx.service;

import java.util.List;

/**
 * 通用的service接口
 *
 * @Author: wyx
 * @Date: 2019/7/2 17:21
 * @Version 1.0
 */
public interface BaseService<T> {

    /**
     * 查询所有
     *
     * @return all T
     */
    List<T> findAll();

    /**
     * 根据id查询
     *
     * @param id
     * @return T
     */
    T findById(Long id);

    /**
     * 根据id查询
     *
     * @param id
     * @return T
     */
    T findById(String id);

    /**
     * 新增
     *
     * @param t
     */
    void create(T t);

    /**
     * 更新
     *
     * @param t
     */
    void update(T t);

    /**
     * 批量删除 by long id
     *
     * @param ids
     */
    void delete(Long... ids);

    /**
     * 批量删除 by string id
     *
     * @param ids
     */
    void delete(String... ids);
}
