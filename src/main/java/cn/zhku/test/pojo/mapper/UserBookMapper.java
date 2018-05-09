package cn.zhku.test.pojo.mapper;

import cn.zhku.test.pojo.entity.UserBook;
import cn.zhku.test.pojo.entity.UserBookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserBookMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_book
     *
     * @mbggenerated Thu Mar 22 22:58:46 CST 2018
     */
    int countByExample(UserBookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_book
     *
     * @mbggenerated Thu Mar 22 22:58:46 CST 2018
     */
    int deleteByExample(UserBookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_book
     *
     * @mbggenerated Thu Mar 22 22:58:46 CST 2018
     */
    int deleteByPrimaryKey(@Param("userId") String userId, @Param("bookId") String bookId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_book
     *
     * @mbggenerated Thu Mar 22 22:58:46 CST 2018
     */
    int insert(UserBook record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_book
     *
     * @mbggenerated Thu Mar 22 22:58:46 CST 2018
     */
    int insertSelective(UserBook record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_book
     *
     * @mbggenerated Thu Mar 22 22:58:46 CST 2018
     */
    List<UserBook> selectByExample(UserBookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_book
     *
     * @mbggenerated Thu Mar 22 22:58:46 CST 2018
     */
    UserBook selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_book
     *
     * @mbggenerated Thu Mar 22 22:58:46 CST 2018
     */
    int updateByExampleSelective(@Param("record") UserBook record, @Param("example") UserBookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_book
     *
     * @mbggenerated Thu Mar 22 22:58:46 CST 2018
     */
    int updateByExample(@Param("record") UserBook record, @Param("example") UserBookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_book
     *
     * @mbggenerated Thu Mar 22 22:58:46 CST 2018
     */
    int updateByPrimaryKeySelective(UserBook record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_book
     *
     * @mbggenerated Thu Mar 22 22:58:46 CST 2018
     */
    int updateByPrimaryKey(UserBook record);
}