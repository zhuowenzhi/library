package cn.zhku.test.util.interfaceUtils;

import java.util.List;

/**
 * @author : 钱伟健 gonefuture@qq.com
 * @version : 2017/10/19 22:19.
 * 说明：支持单表增删改查的基础服务接口
 */
public interface  IBaseService<T> {

    /**
     * 对某个实体对象（相对应的表）添加操作
     *
     * @param entity
     *            映射数据库单表的实体类
     * @return 影响行数
     * @throws Exception     抛出参数错误、SQL操作等异常
     */
    public int add(T entity) throws Exception;

    /**
     * 对某个实体对象（相对应的表）修改操作
     *
     * @param entity
     *            映射数据库单表的实体类
     * @return 影响行数
     * @throws Exception     抛出参数错误、SQL操作等异常
     */
    public int update(T entity) throws Exception;

    /**
     * 对某个实体对象（相对应的表）删除操作
     *
     * @param entity
     *            映射数据库单表的实体类
     * @return 影响行数
     * @throws Exception     抛出参数错误、SQL操作等异常
     */
    public int delete(T entity) throws Exception;

    /**
     * 通过ID获取某个对象实体
     *
     * @param id
     *            主键ID
     * @return      实体
     * @throws Exception      抛出参数错误、SQL操作等异常
     */
    public T get(String id) throws Exception;

    /**
     * 通过设置实体某些字获取个实体对象（相对应的表）
     *
     * @param entity
     *            映射数据库单表的实体类
     * @return 影响行数
     * @throws Exception     抛出参数错误、SQL操作等异常
     */
    public T get(T entity) throws Exception;

    /**
     * 通过查询条件获取某个实体对象（相对应的表）列表操作
     *
     * @param entity
     *            映射数据库单表的实体类
     * @return 影响行数
     * @throws Exception    抛出参数错误、SQL操作等异常
     */
    public List<T> findList(T entity) throws Exception;
}