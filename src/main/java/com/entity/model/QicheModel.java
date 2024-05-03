package com.entity.model;

import com.entity.QicheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 汽车租赁
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class QicheModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 汽车编号
     */
    private String qicheUuidNumber;


    /**
     * 汽车名称
     */
    private String qicheName;


    /**
     * 汽车照片
     */
    private String qichePhoto;


    /**
     * 汽车类型
     */
    private Integer qicheTypes;


    /**
     * 汽车库存数量
     */
    private Integer qicheKucunNumber;


    /**
     * 租赁原价/天
     */
    private Double qicheOldMoney;


    /**
     * 现价/天
     */
    private Double qicheNewMoney;


    /**
     * 热度
     */
    private Integer qicheClicknum;


    /**
     * 汽车详细介绍
     */
    private String qicheContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer qicheDelete;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：汽车编号
	 */
    public String getQicheUuidNumber() {
        return qicheUuidNumber;
    }


    /**
	 * 设置：汽车编号
	 */
    public void setQicheUuidNumber(String qicheUuidNumber) {
        this.qicheUuidNumber = qicheUuidNumber;
    }
    /**
	 * 获取：汽车名称
	 */
    public String getQicheName() {
        return qicheName;
    }


    /**
	 * 设置：汽车名称
	 */
    public void setQicheName(String qicheName) {
        this.qicheName = qicheName;
    }
    /**
	 * 获取：汽车照片
	 */
    public String getQichePhoto() {
        return qichePhoto;
    }


    /**
	 * 设置：汽车照片
	 */
    public void setQichePhoto(String qichePhoto) {
        this.qichePhoto = qichePhoto;
    }
    /**
	 * 获取：汽车类型
	 */
    public Integer getQicheTypes() {
        return qicheTypes;
    }


    /**
	 * 设置：汽车类型
	 */
    public void setQicheTypes(Integer qicheTypes) {
        this.qicheTypes = qicheTypes;
    }
    /**
	 * 获取：汽车库存数量
	 */
    public Integer getQicheKucunNumber() {
        return qicheKucunNumber;
    }


    /**
	 * 设置：汽车库存数量
	 */
    public void setQicheKucunNumber(Integer qicheKucunNumber) {
        this.qicheKucunNumber = qicheKucunNumber;
    }
    /**
	 * 获取：租赁原价/天
	 */
    public Double getQicheOldMoney() {
        return qicheOldMoney;
    }


    /**
	 * 设置：租赁原价/天
	 */
    public void setQicheOldMoney(Double qicheOldMoney) {
        this.qicheOldMoney = qicheOldMoney;
    }
    /**
	 * 获取：现价/天
	 */
    public Double getQicheNewMoney() {
        return qicheNewMoney;
    }


    /**
	 * 设置：现价/天
	 */
    public void setQicheNewMoney(Double qicheNewMoney) {
        this.qicheNewMoney = qicheNewMoney;
    }
    /**
	 * 获取：热度
	 */
    public Integer getQicheClicknum() {
        return qicheClicknum;
    }


    /**
	 * 设置：热度
	 */
    public void setQicheClicknum(Integer qicheClicknum) {
        this.qicheClicknum = qicheClicknum;
    }
    /**
	 * 获取：汽车详细介绍
	 */
    public String getQicheContent() {
        return qicheContent;
    }


    /**
	 * 设置：汽车详细介绍
	 */
    public void setQicheContent(String qicheContent) {
        this.qicheContent = qicheContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getQicheDelete() {
        return qicheDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setQicheDelete(Integer qicheDelete) {
        this.qicheDelete = qicheDelete;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
