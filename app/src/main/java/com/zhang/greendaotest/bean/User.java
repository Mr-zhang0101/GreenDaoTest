package com.zhang.greendaotest.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Project: GreenDaoTest
 * Author:  张佳林
 * Version:  1.0
 * Date:    2017/7/5
 * Modify:  //TODO
 * Description: //TODO
 * Copyright notice:
 */
@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "user_name")
    private String name;
    @Property(nameInDb = "tel_phone")
    private String phone;
    private int age;
    private String pwd;
    @Transient
    private String address;
    @Generated(hash = 625137031)
    public User(Long id, String name, String phone, int age, String pwd) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.pwd = pwd;
    }

    public User(Long id, String name, String phone, int age) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.age = age;
    }

    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", pwd='" + pwd + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getPwd() {
        return this.pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
