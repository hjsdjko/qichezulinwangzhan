package com.dao;

import com.entity.QicheCommentbackEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.QicheCommentbackView;

/**
 * 汽车租赁评价 Dao 接口
 *
 * @author 
 */
public interface QicheCommentbackDao extends BaseMapper<QicheCommentbackEntity> {

   List<QicheCommentbackView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
