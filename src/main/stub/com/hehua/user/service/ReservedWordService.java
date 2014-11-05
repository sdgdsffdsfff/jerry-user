/*
 * 由系统于2014-09-17 13:30:10生成。
 */

package com.hehua.user.service;

import com.hehua.user.domain.ReservedWord;
import org.apache.log4j.Logger;

import java.util.List;

@javax.inject.Named
public class ReservedWordService extends ReservedWordServiceI{
    private static final Logger log = Logger.getLogger(ReservedWordService.class);

    public boolean existWordAndType(String word, int type) {
        return dao.hasWithWordAndType(word, type) != null;
    }

    public ReservedWord getByWordAndType(String word, int type) {
        return dao.getByWordAndType(word, type);
    }

    public List<ReservedWord> getListByType(int type, int offset, int limit) {
        return dao.getListByType(type, offset, limit);
    }

}
