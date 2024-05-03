package com.entity.vo;

import com.entity.QicheEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 汽车租赁
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("qiche")
public class QicheVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 汽车编号
     */

    @TableField(value = "qiche_uuid_number")
    private String qicheUuidNumber;


    /**
     * 汽车名称
     */

    @TableField(value = "qiche_name")
    private String qicheName;


    /**
     * 汽车照片
     */

    @TableField(value = "qiche_photo")
    private String qichePhoto;


    /**
     * 汽车类型
     */

    @TableField(value = "qiche_types")
    private Integer qicheTypes;


    /**
     * 汽车库存数量
     */

    @TableField(value = "qiche_kucun_number")
    private Integer qicheKucunNumber;


    /**
     * 租赁原价/天
     */

    @TableField(value = "qiche_old_money")
    private Double qicheOldMoney;


    /**
     * 现价/天
     */

    @TableField(value = "qiche_new_money")
    private Double qicheNewMoney;


    /**
     * 热度
     */

    @TableField(value = "qiche_clicknum")
    private Integer qicheClicknum;


    /**
     * 汽车详细介绍
     */

    @TableField(value = "qiche_content")
    private String qicheContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "qiche_delete")
    private Integer qicheDelete;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：汽车编号
	 */
    public String getQicheUuidNumber() {
        return qicheUuidNumber;
    }


    /**
	 * 获取：汽车编号
	 */

    public void setQicheUuidNumber(String qicheUuidNumber) {
        this.qicheUuidNumber = qicheUuidNumber;
    }
    /**
	 * 设置：汽车名称
	 */
    public String getQicheName() {
        return qicheName;
    }


    /**
	 * 获取：汽车名称
	 */

    public void setQicheName(String qicheName) {
        this.qicheName = qicheName;
    }
    /**
	 * 设置：汽车照片
	 */
    public String getQichePhoto() {
        return qichePhoto;
    }


    /**
	 * 获取：汽车照片
	 */

    public void setQichePhoto(String qichePhoto) {
        this.qichePhoto = qichePhoto;
    }
    /**
	 * 设置：汽车类型
	 */
    public Integer getQicheTypes() {
        return qicheTypes;
    }


    /**
	 * 获取：汽车类型
	 */

    public void setQicheTypes(Integer qicheTypes) {
        this.qicheTypes = qicheTypes;
    }
    /**
	 * 设置：汽车库存数量
	 */
    public Integer getQicheKucunNumber() {
        return qicheKucunNumber;
    }


    /**
	 * 获取：汽车库存数量
	 */

    public void setQicheKucunNumber(Integer qicheKucunNumber) {
        this.qicheKucunNumber = qicheKucunNumber;
    }
    /**
	 * 设置：租赁原价/天
	 */
    public Double getQicheOldMoney() {
        return qicheOldMoney;
    }


    /**
	 * 获取：租赁原价/天
	 */

    public void setQicheOldMoney(Double qicheOldMoney) {
        this.qicheOldMoney = qicheOldMoney;
    }
    /**
	 * 设置：现价/天
	 */
    public Double getQicheNewMoney() {
        return qicheNewMoney;
    }


    /**
	 * 获取：现价/天
	 */

    public void setQicheNewMoney(Double qicheNewMoney) {
        this.qicheNewMoney = qicheNewMoney;
    }
    /**
	 * 设置：热度
	 */
    public Integer getQicheClicknum() {
        return qicheClicknum;
    }


    /**
	 * 获取：热度
	 */

    public void setQicheClicknum(Integer qicheClicknum) {
        this.qicheClicknum = qicheClicknum;
    }
    /**
	 * 设置：汽车详细介绍
	 */
    public String getQicheContent() {
        return qicheContent;
    }


    /**
	 * 获取：汽车详细介绍
	 */

    public void setQicheContent(String qicheContent) {
        this.qicheContent = qicheContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getQicheDelete() {
        return qicheDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setQicheDelete(Integer qicheDelete) {
        this.qicheDelete = qicheDelete;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
