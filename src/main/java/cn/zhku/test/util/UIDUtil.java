package cn.zhku.test.util;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import java.util.UUID;

/**
 * @author : 钱伟健 gonefuture@qq.com
 * @version : 2017/11/19 21:42.
 * 说明：y一个用于生成UID的工具类
 */
public final class UIDUtil {

    /**
     *      标准无"-"UUID
     * @return uuid 返回一个没有"-"的UUID
     */
    public String uuid() {
        return UUID.randomUUID().toString().replace("-","").toUpperCase();
    }

    /**
     *      原生带"-"的标准UUID
     * @return  uuid 返回一个带"-"的UUID
     */
    public String originUUID() {
        return UUID.randomUUID().toString();
    }


}