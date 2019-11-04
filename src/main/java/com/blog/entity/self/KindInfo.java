/**
 * Copyright (C), 2015 - 2019 , 百分点信息科技有限公司
 *
 * @fileName: KindInfo
 * @author: huyih
 * @date: 2019/11/1 16:34
 * @description:
 * @history: <author>          <date>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.blog.entity.self;

public class KindInfo {
    private Integer id;
    private Integer pId;
    private String name;

    @Override
    public String toString() {
        return "KindInfo{" +
                "id=" + id +
                ", pId=" + pId +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
