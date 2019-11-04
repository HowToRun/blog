/**
 * Copyright (C), 2015 - 2019 , 百分点信息科技有限公司
 *
 * @fileName: blogInfo
 * @author: huyih
 * @date: 2019/10/30 16:43
 * @description:
 * @history: <author>          <date>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.blog.entity.self;

import java.util.Date;

public class BlogInfo {
    private Integer id;
    private Integer kindId;
    private String title;
    private String kindName;
    private String text;
    private Date createTime;
    private Date updateTime;
    private Integer commentCount;
    private Integer praiseCount;

    @Override
    public String toString() {
        return "BlogInfo{" +
                "id=" + id +
                ", kindId=" + kindId +
                ", title='" + title + '\'' +
                ", kindName='" + kindName + '\'' +
                ", text='" + text + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", commentCount=" + commentCount +
                ", praiseCount=" + praiseCount +
                '}';
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public Integer getKindId() {
        return kindId;
    }

    public void setKindId(Integer kindId) {
        this.kindId = kindId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Integer praiseCount) {
        this.praiseCount = praiseCount;
    }
}
