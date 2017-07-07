package com.zhang.greendaotest.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Project: GreenDaoTest
 * Author:  张佳林
 * Version:  1.0
 * Date:    2017/7/7
 * Modify:  //TODO
 * Description: //TODO
 * Copyright notice:
 */
@Entity
public class Tbl_province {
    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "codeid")
    private String code;
    @Property(nameInDb = "parentid")
    private String parent;
    @Property(nameInDb = "cityName")
    private String city;
    @Generated(hash = 1967490424)
    public Tbl_province(Long id, String code, String parent, String city) {
        this.id = id;
        this.code = code;
        this.parent = parent;
        this.city = city;
    }
    @Generated(hash = 704082307)
    public Tbl_province() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCode() {
        return this.code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getParent() {
        return this.parent;
    }
    public void setParent(String parent) {
        this.parent = parent;
    }
    public String getCity() {
        return this.city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Tbl_province{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", parent='" + parent + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
