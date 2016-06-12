package com.example.mycomputer.homework;

/**
 * Created by Administrator on 2016/6/12.
 */
public class studentbean {
    private int _id;
    private String Sname;
    private String Sbirth;
    private String fileName;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSbirth() {
        return Sbirth;
    }

    public void setSbirth(String sbirth) {
        Sbirth = sbirth;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
