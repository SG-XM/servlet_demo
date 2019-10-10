package com.zq.service;

import com.zq.dao.MainDao;

public class MainService {
    public ResBean createTable() {
        if (MainDao.getInstance().createTable()) {
            return ResBean.succ();
        }else{
            return ResBean.err(MainDao.errMsg);
        }
    }
    public ResBean deleteTable() {
        if (MainDao.getInstance().deleteTable()) {
            return ResBean.succ();
        }else{
            return ResBean.err(MainDao.errMsg);
        }
    }
    public ResBean insertPre(String eid,String name,String job,String dno) {
        if (MainDao.getInstance().insertPre(eid,name,job,dno)) {
            return ResBean.succ();
        }else{
            return ResBean.err(MainDao.errMsg);
        }
    }
    public ResBean insert(String eid,String name,String job,String dno) {
        if (MainDao.getInstance().insert(eid,name,job,dno)) {
            return ResBean.succ();
        }else{
            return ResBean.err(MainDao.errMsg);
        }
    }
    public ResBean select(String type,String job,String dno) {
        System.out.println(type);
        if(type.equals("0")){
             return ResBean.succWithRes(MainDao.getInstance().selectND());
            //MainDao.getInstance().selectND();
        }else if(type.equals("1")){
            return ResBean.succWithRes(MainDao.getInstance().selectAll());
        }else{
            return ResBean.succWithRes(MainDao.getInstance().selectSearch(job, dno));
        }
//        if (MainDao.getInstance().insert(eid,name,job,dno)) {
//            return ResBean.succ();
//        }else{
//            return ResBean.err(MainDao.errMsg);
//        }
    }
}
