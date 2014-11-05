/*
 * 由系统于2014-09-17 13:30:10生成，请勿人为进行任何修改！
 */

package com.hehua.user.service;

import com.hehua.user.domain.ReservedWord;
import com.hehua.user.dao.ReservedWordDAO;
import java.util.*;

public class ReservedWordServiceI{

    @javax.inject.Inject
    protected ReservedWordDAO dao;

    public ReservedWord getReservedWordById(long id){
        return dao.getReservedWordById(id);
    }
    
    public boolean hasReservedWordWithId(long id){
        return dao.hasReservedWordWithId(id)!=null;
    }
    
    public List<ReservedWord> getAllReservedWord(){
        return dao.getAllReservedWord();
    }
    
    public boolean createReservedWord(ReservedWord ent){
        return dao.createReservedWord(ent)==1;
    }
    
    public boolean updateReservedWordById(ReservedWord ent){
        return dao.updateReservedWordById(ent)==1;
    }
    
    public boolean deleteReservedWordById(long id){
        return dao.deleteReservedWordById(id)==1;
    }
}
