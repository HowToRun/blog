/**
 * Copyright (C), 2015 - 2019 , 百分点信息科技有限公司
 *
 * @fileName: CatalogDto
 * @author: huyih
 * @date: 2019/11/1 16:41
 * @description:
 * @history: <author>          <date>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.blog.dto;

import com.blog.entity.self.KindInfo;

import java.util.List;

public class CatalogDto {
    private Integer id;
    private Integer pid;
    private String value;
    private String label;
    List<CatalogDto> children;

    @Override
    public String toString() {
        return "CatalogDto{" +
                "id=" + id +
                ", pid=" + pid +
                ", value='" + value + '\'' +
                ", label='" + label + '\'' +
                ", children=" + children +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<CatalogDto> getChildren() {
        return children;
    }

    public void setChildren(List<CatalogDto> children) {
        this.children = children;
    }
}
