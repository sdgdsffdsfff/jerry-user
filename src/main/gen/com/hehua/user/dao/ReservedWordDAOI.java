/*
 * 由系统于2014-09-17 13:30:10生成，请勿人为进行任何修改！
 */

package com.hehua.user.dao;

import org.apache.ibatis.annotations.*;
import com.hehua.user.domain.ReservedWord;
import java.util.List;

public interface ReservedWordDAOI{
    @Select("select * from `reserved_word` where id=#{id}")
    ReservedWord getReservedWordById(long id);
    
    @Select("select 1 from `reserved_word` where id=#{id}")
    Integer hasReservedWordWithId(long id);
    
    @Select("select * from `reserved_word`")
    List<ReservedWord> getAllReservedWord();
    
    @Insert("INSERT INTO `reserved_word`(`word`,`type`) VALUES (#{word},#{type})")
    @Options(useGeneratedKeys = true,keyProperty="id",keyColumn="id")
    int createReservedWord(ReservedWord ent);
    
    @Update("update `reserved_word` set `word`=#{word},`type`=#{type} where id=#{id}")
    int updateReservedWordById(ReservedWord ent);
    
    @Delete("delete from `reserved_word` where id=#{id}")
    int deleteReservedWordById(long id);
    
}
