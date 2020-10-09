package com.hjy.business.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hjy.business.dao.TCustomerMapper;
import com.hjy.business.entity.TCustomer;
import com.hjy.business.service.TCustomerService;
import com.hjy.common.domin.CommonResult;
import com.hjy.common.utils.IDUtils;
import com.hjy.common.utils.JsonUtil;
import com.hjy.common.utils.page.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * (TCustomer)表服务实现类
 *
 * @author wangdengjun
 * @since 2020-07-27 16:15:29
 */
@Service
public class TCustomerServiceImpl implements TCustomerService {
    @Autowired
    private TCustomerMapper tCustomerMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param parm 主键
     * @return 实例对象
     */
    @Override
    public CommonResult selectById(String parm) throws Exception{
        JSONObject jsonObject = JSON.parseObject(parm);
        String pkCustomerId=String.valueOf(jsonObject.get("pkCustomerId"));
        TCustomer tCustomer = tCustomerMapper.selectById(pkCustomerId);
        return new CommonResult(200,"success","数据获取成功!",tCustomer);
    }

    /**
     * 新增数据
     *
     * @param tCustomer 实例对象
     * @return 实例对象
     */
    @Override
    public CommonResult insertSelective(TCustomer tCustomer) throws Exception{
        tCustomer.setPkCustomerId(IDUtils.getUUID());
        tCustomer.setCreateDate(new Date());
        tCustomer.setLastModifyDate(tCustomer.getCreateDate());
        tCustomer.setLastModifyUserId(tCustomer.getCreateUserId());
        tCustomerMapper.insertSelective(tCustomer);
        return new CommonResult(200,"success","数据添加成功!",null);
    }

    /**
     * 修改数据
     *
     * @param TCustomer 实例对象
     * @return 实例对象
     */
    @Override
    public CommonResult updateById(TCustomer TCustomer) throws Exception{
        tCustomerMapper.updateById(TCustomer);
        return new CommonResult(200,"success","数据添加成功!",null);
    }

    /**
     * 通过主键删除数据
     *
     * @param parm 主键
     * @return 是否成功
     */
    @Override
    public CommonResult deleteById(String parm) throws Exception{
        JSONObject jsonObject = JSON.parseObject(parm);
        String pkCustomerId=String.valueOf(jsonObject.get("pkCustomerId"));
        tCustomerMapper.deleteById(pkCustomerId);
        return new CommonResult(200,"success","数据添加成功!",null);
    }
    

    @Override
    public CommonResult selectAllPage(String param) {
        JSONObject json = JSON.parseObject(param);
        //实体数据
        String pageNumStr = JsonUtil.getStringParam(json,"pageNum");
        String pageSizeStr = JsonUtil.getStringParam(json,"pageSize");
        String customerName = JsonUtil.getStringParam(json,"customerName");
        String customerContact = JsonUtil.getStringParam(json,"customerContact");
        TCustomer tCustomer = new TCustomer();
        tCustomer.setCustomerName(customerName);
        tCustomer.setCustomerContact(customerContact);
        //分页记录条数
        int pageNum = 1;
        int pageSize = 10;
        if(pageNumStr != null){
            pageNum = Integer.parseInt(pageNumStr);
        }
        if(pageSizeStr != null){
            pageSize = Integer.parseInt(pageSizeStr);
        }
        PageHelper.startPage(pageNum, pageSize);
        List<TCustomer> tCustomers = tCustomerMapper.selectAllPage(tCustomer);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("PageResult",PageUtils.getPageResult(new PageInfo<TCustomer>(tCustomers)));
        return new CommonResult(200,"success","查询数据成功!",jsonObject);
    }

}