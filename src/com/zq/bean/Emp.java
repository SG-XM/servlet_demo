package com.zq.bean;

public class Emp {
    private String eid;
    private String name;
    private String job;
    private String dno;

    public String getEid() {
        return eid;
    }

    public Emp setEid(String eid) {
        this.eid = eid;
        return this;
    }

    public String getName() {
        return name;
    }

    public Emp setName(String name) {
        this.name = name;
        return this;
    }

    public String getJob() {
        return job;
    }

    public Emp setJob(String job) {
        this.job = job;
        return this;
    }

    public String getDno() {
        return dno;
    }

    public Emp setDno(String dno) {
        this.dno = dno;
        return this;
    }

    public Emp(){}
    public Emp(String eid, String name, String job, String dno) {
        this.eid = eid;
        this.name = name;
        this.job = job;
        this.dno = dno;
    }

    @Override
    public String toString() {
        return "{" +
                "\"eid\":\"" + eid + '\"' +
                ", \"name\":\"" + name + '\"' +
                ", \"job\":\"" + job + '\"' +
                ", \"dno\":\"" + dno + '\"' +
                '}';
    }
}
