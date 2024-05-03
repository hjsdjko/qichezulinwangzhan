package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 汽车租赁订单
 *
 * @author 
 * @email
 */
@TableName("qiche_order")
public class QicheOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public QicheOrderEntity() {

	}

	public QicheOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 订单号
     */
    @TableField(value = "qiche_order_uuid_number")

    private String qicheOrderUuidNumber;


    /**
     * 汽车租赁
     */
    @TableField(value = "qiche_id")

    private Integer qicheId;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 租车日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @TableField(value = "zuche_time")

    private Date zucheTime;


    /**
     * 预计还车日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @TableField(value = "yujihuanche_time")

    private Date yujihuancheTime;


    /**
     * 实际还车日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @TableField(value = "shijihuanche_time")

    private Date shijihuancheTime;


    /**
     * 使用天数
     */
    @TableField(value = "shiyongtianshu")

    private Integer shiyongtianshu;


    /**
     * 花费总额
     */
    @TableField(value = "huafei_money")

    private Double huafeiMoney;


    /**
     * 订单类型
     */
    @TableField(value = "qiche_order_types")

    private Integer qicheOrderTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：订单号
	 */
    public String getQicheOrderUuidNumber() {
        return qicheOrderUuidNumber;
    }
    /**
	 * 获取：订单号
	 */

    public void setQicheOrderUuidNumber(String qicheOrderUuidNumber) {
        this.qicheOrderUuidNumber = qicheOrderUuidNumber;
    }
    /**
	 * 设置：汽车租赁
	 */
    public Integer getQicheId() {
        return qicheId;
    }
    /**
	 * 获取：汽车租赁
	 */

    public void setQicheId(Integer qicheId) {
        this.qicheId = qicheId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：租车日期
	 */
    public Date getZucheTime() {
        return zucheTime;
    }
    /**
	 * 获取：租车日期
	 */

    public void setZucheTime(Date zucheTime) {
        this.zucheTime = zucheTime;
    }
    /**
	 * 设置：预计还车日期
	 */
    public Date getYujihuancheTime() {
        return yujihuancheTime;
    }
    /**
	 * 获取：预计还车日期
	 */

    public void setYujihuancheTime(Date yujihuancheTime) {
        this.yujihuancheTime = yujihuancheTime;
    }
    /**
	 * 设置：实际还车日期
	 */
    public Date getShijihuancheTime() {
        return shijihuancheTime;
    }
    /**
	 * 获取：实际还车日期
	 */

    public void setShijihuancheTime(Date shijihuancheTime) {
        this.shijihuancheTime = shijihuancheTime;
    }
    /**
	 * 设置：使用天数
	 */
    public Integer getShiyongtianshu() {
        return shiyongtianshu;
    }
    /**
	 * 获取：使用天数
	 */

    public void setShiyongtianshu(Integer shiyongtianshu) {
        this.shiyongtianshu = shiyongtianshu;
    }
    /**
	 * 设置：花费总额
	 */
    public Double getHuafeiMoney() {
        return huafeiMoney;
    }
    /**
	 * 获取：花费总额
	 */

    public void setHuafeiMoney(Double huafeiMoney) {
        this.huafeiMoney = huafeiMoney;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getQicheOrderTypes() {
        return qicheOrderTypes;
    }
    /**
	 * 获取：订单类型
	 */

    public void setQicheOrderTypes(Integer qicheOrderTypes) {
        this.qicheOrderTypes = qicheOrderTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "QicheOrder{" +
            "id=" + id +
            ", qicheOrderUuidNumber=" + qicheOrderUuidNumber +
            ", qicheId=" + qicheId +
            ", yonghuId=" + yonghuId +
            ", zucheTime=" + zucheTime +
            ", yujihuancheTime=" + yujihuancheTime +
            ", shijihuancheTime=" + shijihuancheTime +
            ", shiyongtianshu=" + shiyongtianshu +
            ", huafeiMoney=" + huafeiMoney +
            ", qicheOrderTypes=" + qicheOrderTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
