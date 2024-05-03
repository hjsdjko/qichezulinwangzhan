package com.entity.view;

import com.entity.QicheCommentbackEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 汽车租赁评价
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("qiche_commentback")
public class QicheCommentbackView extends QicheCommentbackEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 qiche
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
				* 汽车类型的值
				*/
				private String qicheValue;
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
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer qicheDelete;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 余额
			*/
			private Double newMoney;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;

	public QicheCommentbackView() {

	}

	public QicheCommentbackView(QicheCommentbackEntity qicheCommentbackEntity) {
		try {
			BeanUtils.copyProperties(this, qicheCommentbackEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



















				//级联表的get和set qiche

					/**
					* 获取： 汽车编号
					*/
					public String getQicheUuidNumber() {
						return qicheUuidNumber;
					}
					/**
					* 设置： 汽车编号
					*/
					public void setQicheUuidNumber(String qicheUuidNumber) {
						this.qicheUuidNumber = qicheUuidNumber;
					}

					/**
					* 获取： 汽车名称
					*/
					public String getQicheName() {
						return qicheName;
					}
					/**
					* 设置： 汽车名称
					*/
					public void setQicheName(String qicheName) {
						this.qicheName = qicheName;
					}

					/**
					* 获取： 汽车照片
					*/
					public String getQichePhoto() {
						return qichePhoto;
					}
					/**
					* 设置： 汽车照片
					*/
					public void setQichePhoto(String qichePhoto) {
						this.qichePhoto = qichePhoto;
					}

					/**
					* 获取： 汽车类型
					*/
					public Integer getQicheTypes() {
						return qicheTypes;
					}
					/**
					* 设置： 汽车类型
					*/
					public void setQicheTypes(Integer qicheTypes) {
						this.qicheTypes = qicheTypes;
					}


						/**
						* 获取： 汽车类型的值
						*/
						public String getQicheValue() {
							return qicheValue;
						}
						/**
						* 设置： 汽车类型的值
						*/
						public void setQicheValue(String qicheValue) {
							this.qicheValue = qicheValue;
						}

					/**
					* 获取： 汽车库存数量
					*/
					public Integer getQicheKucunNumber() {
						return qicheKucunNumber;
					}
					/**
					* 设置： 汽车库存数量
					*/
					public void setQicheKucunNumber(Integer qicheKucunNumber) {
						this.qicheKucunNumber = qicheKucunNumber;
					}

					/**
					* 获取： 租赁原价/天
					*/
					public Double getQicheOldMoney() {
						return qicheOldMoney;
					}
					/**
					* 设置： 租赁原价/天
					*/
					public void setQicheOldMoney(Double qicheOldMoney) {
						this.qicheOldMoney = qicheOldMoney;
					}

					/**
					* 获取： 现价/天
					*/
					public Double getQicheNewMoney() {
						return qicheNewMoney;
					}
					/**
					* 设置： 现价/天
					*/
					public void setQicheNewMoney(Double qicheNewMoney) {
						this.qicheNewMoney = qicheNewMoney;
					}

					/**
					* 获取： 热度
					*/
					public Integer getQicheClicknum() {
						return qicheClicknum;
					}
					/**
					* 设置： 热度
					*/
					public void setQicheClicknum(Integer qicheClicknum) {
						this.qicheClicknum = qicheClicknum;
					}

					/**
					* 获取： 汽车详细介绍
					*/
					public String getQicheContent() {
						return qicheContent;
					}
					/**
					* 设置： 汽车详细介绍
					*/
					public void setQicheContent(String qicheContent) {
						this.qicheContent = qicheContent;
					}

					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
					}


						/**
						* 获取： 是否上架的值
						*/
						public String getShangxiaValue() {
							return shangxiaValue;
						}
						/**
						* 设置： 是否上架的值
						*/
						public void setShangxiaValue(String shangxiaValue) {
							this.shangxiaValue = shangxiaValue;
						}

					/**
					* 获取： 逻辑删除
					*/
					public Integer getQicheDelete() {
						return qicheDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setQicheDelete(Integer qicheDelete) {
						this.qicheDelete = qicheDelete;
					}
















				//级联表的get和set yonghu

					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}

					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 余额
					*/
					public Double getNewMoney() {
						return newMoney;
					}
					/**
					* 设置： 余额
					*/
					public void setNewMoney(Double newMoney) {
						this.newMoney = newMoney;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}



}
