package com.hjy.business.controller;

import com.hjy.business.entity.TRecruit;
import com.hjy.business.service.TRecruitService;
import com.hjy.common.domin.CommonResult;
import com.hjy.common.exception.FebsException;
import com.hjy.common.utils.TokenUtil;
import com.hjy.system.entity.SysToken;
import com.hjy.system.service.ShiroService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * (TRecruit)表控制层
 *
 * @author wangdengjun
 * @since 2020-09-28 17:48:11
 */
@Slf4j
@RestController
public class TRecruitController {
    /**
     * 服务对象
     */
    @Autowired
    private TRecruitService tRecruitService;
    @Autowired
    private ShiroService shiroService;

    /**
     * 跳转到新增页面
     */
     @GetMapping(value = "/business/recruit/addPage")
     public CommonResult tRecruitAddPage() throws FebsException {
        try {
            return new CommonResult(200,"success","成功!",null);
        } catch (Exception e) {
            String message = "失败";
            log.error(message, e);
            throw new FebsException(message);
        }
     }
    /**
     * 新增数据
     * @param tRecruit 实体对象
     * @return 新增结果
     */
    @RequiresPermissions({"recruit:add"})
    @PostMapping("/business/recruit/add")
    public CommonResult tRecruitAdd(@RequestBody TRecruit tRecruit,HttpServletRequest httpRequest) throws FebsException{
        try {
            SysToken sysToken=shiroService.findByToken(TokenUtil.getRequestToken(httpRequest));
            return tRecruitService.insertSelective(tRecruit,sysToken);
        } catch (Exception e) {
            String message = "数据添加失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    /**
     * 删除数据
     * @return 删除结果
     */
    @RequiresPermissions({"recruit:del"})
    @DeleteMapping("/business/recruit/del")
    public CommonResult tRecruitDel(@RequestBody String parm) throws FebsException{
        try {
            return tRecruitService.deleteById(parm);
        } catch (Exception e) {
            String message = "数据删除失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }
    
    /**
     * 通过主键查询单条数据
     * @return 单条数据
     */
    @PostMapping("/business/recruit/getOne")
    public CommonResult tRecruitGetOne(@RequestBody String parm) throws FebsException{
        try {
            return tRecruitService.selectById(parm);
        } catch (Exception e) {
            String message = "数据获取失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }
    
    /**
     * 修改数据
     * @param tRecruit 实体对象
     * @return 修改结果
     */
    @RequiresPermissions({"recruit:update"})
    @PutMapping("/business/recruit/update")
    public CommonResult tRecruitUpdate(@RequestBody TRecruit tRecruit,HttpServletRequest httpRequest) throws FebsException{
        try {
            SysToken sysToken=shiroService.findByToken(TokenUtil.getRequestToken(httpRequest));
            return tRecruitService.updateById(tRecruit,sysToken);
        } catch (Exception e) {
            String message = "修改失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    /**
     * 查询所有数据
     * @return 所有数据
     */
//    @RequiresPermissions({"recruit:list"})
    @PostMapping("/business/recruit/list")
    public CommonResult tRecruitList(@RequestBody String param ) throws FebsException{
        try {
            return tRecruitService.selectAllPage(param);
        } catch (Exception e) {
            String message = "查询数据失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

}