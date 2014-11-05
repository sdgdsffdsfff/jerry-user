/*
 * 由系统于2014-09-17 13:30:10生成。
 */

package com.hehua.user.dao;

import org.apache.ibatis.annotations.*;
import com.hehua.user.domain.ReservedWord;

import java.util.List;

@javax.inject.Named
public interface ReservedWordDAO extends ReservedWordDAOI{

    @Select("select * from `reserved_word` where word=#{word}")
    ReservedWord getReservedWordByWord(String word);

    @Select("select * from `reserved_word` where word=#{word} and type=#{type}")
    ReservedWord getByWordAndType(@Param("word") String word, @Param("type") int type);

    @Select("select 1 from `reserved_word` where word=#{word} and type=#{type}")
    Integer hasWithWordAndType(@Param("word") String word, @Param("type") int type);

    @Select("select * from `reserved_word` where type=#{type} order by id limit #{offset},#{limit}")
    public List<ReservedWord> getListByType(@Param("type") int type, @Param("offset") int offset, @Param("limit") int limit);
}
