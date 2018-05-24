package com.example.a2mmm.gift;


public class suggest {
    private String name;
    private String code;
    private double bfb;
    private String sz;
    private String lx;
    private double zf;
    private double kj;
    private int nn;

    public suggest() {
    }

    public suggest(String name, String code, double bfb,String sz,double zf,String lx,double kj,int nn) {
        this.name = name;
        this.code = code;
        this.bfb = bfb;
        this.sz= sz;
        this.lx=lx;
        this.zf = zf;
        this.kj=kj;
        this.nn=nn;
    }
    public int getnn() {return nn;}
    public String getname() {
        return name;
    }

    public String getcode() {
        return code;
    }
    public String getbfb()  {
        if (bfb>=0)
            return ("+"+String.valueOf((long)bfb)+"."+String.valueOf((long)((bfb-(long) bfb)*100))+"%");
        else return ("-"+String.valueOf((long)(-bfb))+"."+String.valueOf((long)((-bfb-(long) (-bfb))*100))+"%");
    }
    public String getsz() {
        return sz;
    }
    public String getlx() {
        return lx;
    }
    public String getzf() {
        if (zf>=0)
            return ("+"+String.valueOf((long)zf)+"."+String.valueOf((long)((zf-(long) zf)*10))+"%");
        else return ("-"+String.valueOf((long)(-zf))+"."+String.valueOf((long)((-zf-(long)(-zf))*10))+"%");
    }
    public String getkj() {
        if (kj>=0)
            return ("+"+String.valueOf((long)kj)+"."+String.valueOf((long)((kj-(long) kj))*10)+"%");
        else return ("-"+String.valueOf((long)(-kj))+"."+String.valueOf((long)(-kj-(long)(-kj))*10)+"%");
    }




    public void setname(String name) {
        this.name = name;
    }
    public void setcode(String code) {
        this.code = code;
    }
    public void setbfb(double bfb) {
        this.bfb = bfb;
    }
    public void setsz(String sz) {
        this.sz = sz;
    }
    public void setlx(String lx) {
        this.lx = lx;
    }
    public void setzf(double zf) {
        this.zf = zf;
    }
    public void setkj(double kj) {
        this.kj = kj;
    }


}
