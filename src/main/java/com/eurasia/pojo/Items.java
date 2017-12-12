package com.eurasia.pojo;

import com.eurasia.controller.validation.ValidGroup1;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class Items {
    private Integer id;

    //校验名称在1-30个字符中间
    //提示校验出错显示的信息
    //groups：此校验属于哪个分组，groups可以定义多个分组
    @Size(min = 1,max = 30,message = "{items.name.length.error}",groups = {ValidGroup1.class})
    private String name;

    private Float price;

    private String pic;

    //非空校验
    @NotNull(message = "{items.createtime.isNull}")
    private Date createtime;

    private String detail;

    public Items(Integer id, String name, Float price, String pic, Date createtime, String detail) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pic = pic;
        this.createtime = createtime;
        this.detail = detail;
    }

    public Items() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}