package com.beitian.adminuijava.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Info {
    @Id
    @GeneratedValue
    private int id;

    private String title;

    private String file;

    @Column(columnDefinition = "text")
    private String  content;

    @Column(columnDefinition = "timestamp default current_timestamp")
    private Timestamp createTime;

    private int infoCateId;


    public Info() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public int getInfoCateId() {
        return infoCateId;
    }

    public void setInfoCateId(int infoCateId) {
        this.infoCateId = infoCateId;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
