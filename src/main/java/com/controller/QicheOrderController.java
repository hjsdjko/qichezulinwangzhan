
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 汽车租赁订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/qicheOrder")
public class QicheOrderController {
    private static final Logger logger = LoggerFactory.getLogger(QicheOrderController.class);

    @Autowired
    private QicheOrderService qicheOrderService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private QicheService qicheService;
    @Autowired
    private YonghuService yonghuService;
@Autowired
private QicheCommentbackService qicheCommentbackService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = qicheOrderService.queryPage(params);

        //字典表数据转换
        List<QicheOrderView> list =(List<QicheOrderView>)page.getList();
        for(QicheOrderView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        QicheOrderEntity qicheOrder = qicheOrderService.selectById(id);
        if(qicheOrder !=null){
            //entity转view
            QicheOrderView view = new QicheOrderView();
            BeanUtils.copyProperties( qicheOrder , view );//把实体数据重构到view中

                //级联表
                QicheEntity qiche = qicheService.selectById(qicheOrder.getQicheId());
                if(qiche != null){
                    BeanUtils.copyProperties( qiche , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setQicheId(qiche.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(qicheOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody QicheOrderEntity qicheOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,qicheOrder:{}",this.getClass().getName(),qicheOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            qicheOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        qicheOrder.setInsertTime(new Date());
        qicheOrder.setCreateTime(new Date());
        qicheOrderService.insert(qicheOrder);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody QicheOrderEntity qicheOrder, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,qicheOrder:{}",this.getClass().getName(),qicheOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            qicheOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<QicheOrderEntity> queryWrapper = new EntityWrapper<QicheOrderEntity>()
            .eq("id",0)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        QicheOrderEntity qicheOrderEntity = qicheOrderService.selectOne(queryWrapper);
        if(qicheOrderEntity==null){
            qicheOrderService.updateById(qicheOrder);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        qicheOrderService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<QicheOrderEntity> qicheOrderList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            QicheOrderEntity qicheOrderEntity = new QicheOrderEntity();
//                            qicheOrderEntity.setQicheOrderUuidNumber(data.get(0));                    //订单号 要改的
//                            qicheOrderEntity.setQicheId(Integer.valueOf(data.get(0)));   //汽车租赁 要改的
//                            qicheOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            qicheOrderEntity.setZucheTime(sdf.parse(data.get(0)));          //租车日期 要改的
//                            qicheOrderEntity.setYujihuancheTime(sdf.parse(data.get(0)));          //预计还车日期 要改的
//                            qicheOrderEntity.setShijihuancheTime(sdf.parse(data.get(0)));          //实际还车日期 要改的
//                            qicheOrderEntity.setShiyongtianshu(Integer.valueOf(data.get(0)));   //使用天数 要改的
//                            qicheOrderEntity.setHuafeiMoney(data.get(0));                    //花费总额 要改的
//                            qicheOrderEntity.setQicheOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            qicheOrderEntity.setInsertTime(date);//时间
//                            qicheOrderEntity.setCreateTime(date);//时间
                            qicheOrderList.add(qicheOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单号
                                if(seachFields.containsKey("qicheOrderUuidNumber")){
                                    List<String> qicheOrderUuidNumber = seachFields.get("qicheOrderUuidNumber");
                                    qicheOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> qicheOrderUuidNumber = new ArrayList<>();
                                    qicheOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("qicheOrderUuidNumber",qicheOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单号
                        List<QicheOrderEntity> qicheOrderEntities_qicheOrderUuidNumber = qicheOrderService.selectList(new EntityWrapper<QicheOrderEntity>().in("qiche_order_uuid_number", seachFields.get("qicheOrderUuidNumber")));
                        if(qicheOrderEntities_qicheOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(QicheOrderEntity s:qicheOrderEntities_qicheOrderUuidNumber){
                                repeatFields.add(s.getQicheOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        qicheOrderService.insertBatch(qicheOrderList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = qicheOrderService.queryPage(params);

        //字典表数据转换
        List<QicheOrderView> list =(List<QicheOrderView>)page.getList();
        for(QicheOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        QicheOrderEntity qicheOrder = qicheOrderService.selectById(id);
            if(qicheOrder !=null){


                //entity转view
                QicheOrderView view = new QicheOrderView();
                BeanUtils.copyProperties( qicheOrder , view );//把实体数据重构到view中

                //级联表
                    QicheEntity qiche = qicheService.selectById(qicheOrder.getQicheId());
                if(qiche != null){
                    BeanUtils.copyProperties( qiche , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setQicheId(qiche.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(qicheOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody QicheOrderEntity qicheOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,qicheOrder:{}",this.getClass().getName(),qicheOrder.toString());
            QicheEntity qicheEntity = qicheService.selectById(qicheOrder.getQicheId());
            if(qicheEntity == null){
                return R.error(511,"查不到该汽车租赁");
            }
            // Double qicheNewMoney = qicheEntity.getQicheNewMoney();
            if(false){
            }
            else if((qicheEntity.getQicheKucunNumber() -1)<0){
                return R.error(511,"库存不够,无法租车");
            }
            else if(qicheEntity.getQicheNewMoney() == null){
                return R.error(511,"汽车租赁价格不能为空");
            }

            //计算所获得积分
            Integer userId = (Integer) request.getSession().getAttribute("userId");

            qicheOrder.setQicheOrderTypes(1); //设置订单状态为已支付
            qicheOrder.setYonghuId(userId); //设置订单支付人id
            qicheOrder.setQicheOrderUuidNumber(String.valueOf(new Date().getTime()));
            qicheOrder.setInsertTime(new Date());
            qicheOrder.setCreateTime(new Date());
            qicheEntity.setQicheKucunNumber( qicheEntity.getQicheKucunNumber() -1);
            qicheService.updateById(qicheEntity);
            qicheOrderService.insert(qicheOrder);//新增订单
            return R.ok();
    }

    /**
    * 取消
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);

            QicheOrderEntity qicheOrder = qicheOrderService.selectById(id);
            Integer buyNumber = 1;
            Integer qicheId = qicheOrder.getQicheId();
            if(qicheId == null)
                return R.error(511,"查不到该汽车租赁");
            QicheEntity qicheEntity = qicheService.selectById(qicheId);
            if(qicheEntity == null)
                return R.error(511,"查不到该汽车租赁");
            Double qicheNewMoney = qicheEntity.getQicheNewMoney();
            if(qicheNewMoney == null)
                return R.error(511,"汽车租赁价格不能为空");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");

            Double zhekou = 1.0;


            //判断是什么支付方式 1代表余额 2代表积分
//            if(qicheOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = qicheEntity.getQicheNewMoney() * buyNumber  * zhekou;
                //计算所获得积分
                Double buyJifen = 0.0;
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() + money); //设置金额


//            }

            qicheEntity.setQicheKucunNumber(qicheEntity.getQicheKucunNumber() + buyNumber);



            qicheOrder.setQicheOrderTypes(2);//设置订单状态为取消
            qicheOrderService.updateById(qicheOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            qicheService.updateById(qicheEntity);//更新订单中汽车租赁的信息
            return R.ok();
    }


    /**
     * 取车
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id ){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        QicheOrderEntity  qicheOrderEntity = new  QicheOrderEntity();;
        qicheOrderEntity.setId(id);
        qicheOrderEntity.setQicheOrderTypes(3);
        boolean b =  qicheOrderService.updateById( qicheOrderEntity);
        if(!b){
            return R.error("取车出错");
        }
        return R.ok();
    }














    /**
     * 还车
     */
    @RequestMapping("/receiving")
    public R receiving(Integer id, HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
//        QicheOrderEntity  qicheOrderEntity = new  QicheOrderEntity();

        YonghuEntity yonghuEntity = yonghuService.selectById((Integer) request.getSession().getAttribute("userId"));
        Double newMoney = yonghuEntity.getNewMoney();

        QicheOrderEntity qicheOrderEntity = qicheOrderService.selectById(id);
        Date zucheTime = qicheOrderEntity.getZucheTime();
        QicheEntity qicheEntity = qicheService.selectById(qicheOrderEntity.getQicheId());

        Date shijihuancheTime = new Date();
        Integer haomiao = 1*24*60*60*1000;
        Long df = shijihuancheTime.getTime() - zucheTime.getTime();
        if(df<=haomiao){
            qicheOrderEntity.setShiyongtianshu(1);
        }else{
            qicheOrderEntity.setShiyongtianshu(df.intValue()/haomiao+1);
        }
        double huafei = qicheEntity.getQicheNewMoney() * qicheOrderEntity.getShiyongtianshu();
        double balance = newMoney - huafei;
        if(balance<0){
            return R.error("无法还车,此次花费"+huafei+",当前账户余额不够.,请去充值后再还车");
        }

        qicheOrderEntity.setShijihuancheTime(shijihuancheTime);
        qicheOrderEntity.setHuafeiMoney(huafei);



        qicheOrderEntity.setQicheOrderTypes(4);
        boolean b =  qicheOrderService.updateById( qicheOrderEntity);
        if(!b){
            return R.error("还车出错");
        }
        yonghuEntity.setNewMoney(balance);
        yonghuService.updateById(yonghuEntity);

        qicheEntity.setQicheKucunNumber(qicheEntity.getQicheKucunNumber()+1);
        qicheService.updateById(qicheEntity);
        return R.ok();
    }



    /**
    * 评价
    */
    @RequestMapping("/commentback")
    public R commentback(Integer id, String commentbackText, Integer qicheCommentbackPingfenNumber, HttpServletRequest request){
        logger.debug("commentback方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
            QicheOrderEntity qicheOrder = qicheOrderService.selectById(id);
        if(qicheOrder == null)
            return R.error(511,"查不到该订单");
        if(qicheOrder.getQicheOrderTypes() != 4)
            return R.error(511,"您不能评价");
        Integer qicheId = qicheOrder.getQicheId();
        if(qicheId == null)
            return R.error(511,"查不到该汽车租赁");

        QicheCommentbackEntity qicheCommentbackEntity = new QicheCommentbackEntity();
            qicheCommentbackEntity.setId(id);
            qicheCommentbackEntity.setQicheId(qicheId);
            qicheCommentbackEntity.setYonghuId((Integer) request.getSession().getAttribute("userId"));
            qicheCommentbackEntity.setQicheCommentbackText(commentbackText);
            qicheCommentbackEntity.setInsertTime(new Date());
            qicheCommentbackEntity.setReplyText(null);
            qicheCommentbackEntity.setUpdateTime(null);
            qicheCommentbackEntity.setCreateTime(new Date());
            qicheCommentbackService.insert(qicheCommentbackEntity);

            qicheOrder.setQicheOrderTypes(5);//设置订单状态为已评价
            qicheOrderService.updateById(qicheOrder);//根据id更新
            return R.ok();
    }












}
