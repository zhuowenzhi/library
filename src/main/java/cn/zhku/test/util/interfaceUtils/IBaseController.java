package cn.zhku.test.util.interfaceUtils;

import cn.zhku.test.util.modle.CommonQo;
import cn.zhku.test.util.modle.Result;
import com.github.pagehelper.PageInfo;


/**
 * @author : 钱伟健 gonefuture@qq.com
 * @version : 2017/11/14 22:36.
 * 说明：
 */
public interface IBaseController<T> {


    /**
     *  增加一条数据
     * @param entity 实体类
     * @return Message
     * @throws Exception    sql、bean检验
     */
    Result add(T entity) throws Exception ;

    /**
     *  删除一条记录
     *  @param id   主键
     * @param entity    带表主键的实体类
     * @return  Message
    1     * @throws Exception   sql、bean检验
     */
    Result delete(String  id,T entity) throws Exception ;


    /**
     * 更新记录
     *@param id 主键
     * @param entity    实体类
     * @return  Message
     * @throws Exception    sql、bean检验
     */
    Result update(String  id,T entity) throws Exception ;


    /**
     *  获取一条记录
     * @param id    表主键
     * @return  Message
     * @throws Exception    sql、bean检验
     */
    T get(String id) throws Exception ;

    /**
     *  获取一个分页的数据列表
     * @param entity    实体类
     * @param commonQo  通用查询类
     * @return  PageInfo分页类
     * @throws Exception    sql、bean检验
     */
    PageInfo<T> list(T entity, CommonQo commonQo) throws Exception ;

}