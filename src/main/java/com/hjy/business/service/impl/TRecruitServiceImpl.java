package com.hjy.business.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hjy.business.dao.TRecruitMapper;
import com.hjy.business.entity.TRecruit;
import com.hjy.business.service.TRecruitService;
import com.hjy.common.domin.CommonResult;
import com.hjy.common.utils.IDUtils;
import com.hjy.common.utils.JsonUtil;
import com.hjy.common.utils.StringUtil;
import com.hjy.common.utils.TokenUtil;
import com.hjy.common.utils.page.PageUtils;
import com.hjy.system.entity.SysToken;
import com.hjy.system.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * (TRecruit)表服务实现类
 *
 * @author wangdengjun
 * @since 2020-07-27 16:15:29
 */
@Service
public class TRecruitServiceImpl implements TRecruitService {
    @Autowired
    private TRecruitMapper tRecruitMapper;
    @Autowired
    private ShiroService shiroService;

    /**
     * 通过ID查询单条数据
     *
     * @param parm 主键
     * @return 实例对象
     */
    @Override
    public CommonResult selectById(String parm) {
        JSONObject jsonObject = JSON.parseObject(parm);
        String pkRecruitId = String.valueOf(jsonObject.get("pkRecruitId"));
        TRecruit tRecruit = tRecruitMapper.selectById(pkRecruitId);
        return new CommonResult(200, "success", "数据获取成功!", tRecruit);
    }

    /**
     * 新增数据
     *
     * @param tRecruit
     * @return
     * @
     */
    @Override
    public CommonResult insertSelective(TRecruit tRecruit, HttpServletRequest httpRequest) {
        SysToken sysToken = shiroService.findByToken(TokenUtil.getRequestToken(httpRequest));
        if (tRecruit.getRecruitStatus() != 1 && tRecruit.getRecruitStatus() != 2) {
            return new CommonResult(440, "error", "请选择状态!", null);
        }
        tRecruit.setPkRecruitId(IDUtils.getUUID());
        tRecruit.setCreateDate(new Date());
        tRecruit.setCreateUserId(sysToken.getFkUserId());
        tRecruit.setLastModifyDate(tRecruit.getCreateDate());
        tRecruit.setLastModifyUserId(tRecruit.getCreateUserId());
        tRecruitMapper.insertSelective(tRecruit);
        return new CommonResult(200, "success", "数据添加成功!", null);
    }

    /**
     * 修改数据
     *
     * @param tRecruit
     * @return
     * @
     */
    @Override
    public CommonResult updateById(TRecruit tRecruit, HttpServletRequest httpRequest) {
        SysToken sysToken = shiroService.findByToken(TokenUtil.getRequestToken(httpRequest));
        if (tRecruit.getRecruitStatus() != 1 && tRecruit.getRecruitStatus() != 2) {
            return new CommonResult(440, "error", "请选择状态!", null);
        }
        tRecruit.setLastModifyDate(new Date());
        tRecruit.setLastModifyUserId(sysToken.getFkUserId());
        tRecruitMapper.updateById(tRecruit);
        return new CommonResult(200, "success", "数据修改成功!", null);
    }

    /**
     * 通过主键删除数据
     *
     * @param parm 主键
     * @return 是否成功
     */
    @Override
    public CommonResult deleteById(String parm) {
        JSONObject jsonObject = JSON.parseObject(parm);
        String pkRecruitId = String.valueOf(jsonObject.get("pkRecruitId"));
        tRecruitMapper.deleteById(pkRecruitId);
        return new CommonResult(200, "success", "数据删除成功!", null);
    }


    @Override
    public CommonResult selectAllPage(String param) {
        JSONObject json = JSON.parseObject(param);
        //实体数据
        String pageNumStr = JsonUtil.getStringParam(json, "pageNum");
        String pageSizeStr = JsonUtil.getStringParam(json, "pageSize");
        String recruitPosition = JsonUtil.getStringParam(json, "recruitPosition");
        String recruitStatus = JsonUtil.getStringParam(json, "recruitStatus");
        TRecruit tRecruit = new TRecruit();
        if (StringUtil.isNotEmptyAndNull(recruitStatus)) {
            tRecruit.setRecruitStatus(Integer.parseInt(recruitStatus));
        }
        tRecruit.setRecruitPosition(recruitPosition);
        //分页记录条数
        int pageNum = 1;
        int pageSize = 10;
        if (pageNumStr != null) {
            pageNum = Integer.parseInt(pageNumStr);
        }
        if (pageSizeStr != null) {
            pageSize = Integer.parseInt(pageSizeStr);
        }
        PageHelper.startPage(pageNum, pageSize);
        List<TRecruit> tRecruits = tRecruitMapper.selectAllPage(tRecruit);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("PageResult", PageUtils.getPageResult(new PageInfo<TRecruit>(tRecruits)));
        return new CommonResult(200, "success", "查询数据成功!", jsonObject);
    }

}