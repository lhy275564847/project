package com.oceanleo.project.ssm.domain;

import java.io.Serializable;

/**
 * @author haiyang.li on 2017/8/25.
 */
public class Menu extends Domain implements Serializable {

    private static final long serialVersionUID = 5089362992086561588L;

    private String name;        //菜单名称

    private String code;        //菜单编码

    private String url;         //菜单url

    private Integer sort;       //排序

    private String parentId;    //上级菜单id

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", url='" + url + '\'' +
                ", sort=" + sort +
                ", parentId='" + parentId + '\'' +
                '}';
    }
}
