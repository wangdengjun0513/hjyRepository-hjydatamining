package com.hjy.business.controller;

import com.hjy.business.entity.TBanner;
import com.hjy.business.service.TBannerService;
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
 * (TBanner)表控制层
 *
 * @author wangdengjun
 * @since 2020-09-28 17:48:11
 */
@Slf4j
@RestController
public class TBannerController {
    /**
     * 服务对象
     */
    @Autowired
    private TBannerService tBannerService;
    @Autowired
    private ShiroService shiroService;

    /**
     * 跳转到新增页面
     */
     @GetMapping(value = "/business/banner/addPage")
     public CommonResult tBannerAddPage() throws FebsException {
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
     * @param tBanner 实体对象
     * @return 新增结果
     */
    @RequiresPermissions({"banner:add"})
    @PostMapping("/business/banner/add")
    public CommonResult tBannerAdd(@RequestBody TBanner tBanner,HttpServletRequest httpRequest) throws FebsException{
        try {
            SysToken sysToken=shiroService.findByToken(TokenUtil.getRequestToken(httpRequest));
            return tBannerService.insertSelective(tBanner,sysToken);
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
    @RequiresPermissions({"banner:del"})
    @DeleteMapping("/business/banner/del")
    public CommonResult tBannerDel(@RequestBody String parm) throws FebsException{
        try {
            return tBannerService.deleteById(parm);
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
    @PostMapping("/business/banner/getOne")
    public CommonResult tBannerGetOne(@RequestBody String parm) throws FebsException{
        try {
            return tBannerService.selectById(parm);
        } catch (Exception e) {
            String message = "数据获取失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }
    
    /**
     * 修改数据
     * @param tBanner 实体对象
     * @return 修改结果
     */
    @RequiresPermissions({"banner:update"})
    @PutMapping("/business/banner/update")
    public CommonResult tBannerUpdate(@RequestBody TBanner tBanner,HttpServletRequest httpRequest) throws FebsException{
        try {
            SysToken sysToken=shiroService.findByToken(TokenUtil.getRequestToken(httpRequest));
            return tBannerService.updateById(tBanner,sysToken);
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
    @RequiresPermissions({"banner:view"})
    @PostMapping("/business/banner/list")
    public CommonResult tBannerList(@RequestBody String param ) throws FebsException{
        try {
            return tBannerService.selectAllPage(param);
        } catch (Exception e) {
            String message = "查询数据失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

}