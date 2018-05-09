package cn.zhku.test.util.modle;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author yechao
 * @date 2017/8/23 11:21.
 *
 */

/**
 * 此类是用于一般的分页查询。
 * 注意：数据库字段切记不要设置为 ‘end’，否则会因为关键字冲突而查询失败
 */
public class CommonQo {
    //  当前去请求的页码
    private  int pageNum = 1;
    //  一页拥有的记录数
    private int pageSize = 10;

    //  开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date start;
    //  结束时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date end;


    private String sort = "1";

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }


    @Override
    public String toString() {
        return "CommonQo{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", start=" + start +
                ", end=" + end +
                ", sort='" + sort + '\'' +
                '}';
    }
}