package com.beitian.adminuijava.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Menu {

    @Id
    @GeneratedValue
    private int id;

    private int parentId;

    private String icon;

    private String name;

    private String url;

    private String privilege;

    private int isMenu;

    private int sort;

    @Column(columnDefinition = "timestamp default current_timestamp")
    private Timestamp createTime;

    public Menu() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public int getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(int isMenu) {
        this.isMenu = isMenu;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", icon='" + icon + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", privilege='" + privilege + '\'' +
                ", isMenu=" + isMenu +
                ", sort=" + sort +
                ", createTime=" + createTime +
                '}';
    }
}
