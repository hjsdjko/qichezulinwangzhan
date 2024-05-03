package com.dao;

import com.entity.QicheCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.QicheCollectionView;

/**
 * 汽车租赁收藏 Dao 接口
 *
 * @author 
 */
public interface QicheCollectionDao extends BaseMapper<QicheCollectionEntity> {

   List<QicheCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
