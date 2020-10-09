package com.hjy.business.controller;

import com.hjy.business.entity.TCustomer;
import com.hjy.business.service.TCustomerService;
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
 * (TCustomer)表控制层
 *
 * @author wangdengjun
 * @since 2020-09-28 17:48:11
 */
@Slf4j
@RestController
public class TCustomerController {
    /**
     * 服务对象
     */
    @Autowired
    private TCustomerService tCustomerService;
    @Autowired
    private ShiroService shiroService;

    /**
     * 跳转到新增页面
     */
     @GetMapping(value = "/business/customer/addPage")
     public CommonResult tCustomerAddPage() throws FebsException {
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
     * @param tCustomer 实体对象
     * @return 新增结果
     */
    @RequiresPermissions({"customer:add"})
    @PostMapping("/business/customer/add")
    public CommonResult tCustomerAdd(@RequestBody TCustomer tCustomer, HttpServletRequest httpRequest) throws FebsException{
        try {
            SysToken sysToken=shiroService.findByToken(TokenUtil.getRequestToken(httpRequest));
            return tCustomerService.insertSelective(tCustomer,sysToken);
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
    @RequiresPermissions({"customer:del"})
    @DeleteMapping("/business/customer/del")
    public CommonResult tCustomerDel(@RequestBody String parm) throws FebsException{
        try {
            return tCustomerService.deleteById(parm);
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
    @PostMapping("/business/customer/getOne")
    public CommonResult tCustomerGetOne(@RequestBody String parm) throws FebsException{
        try {
            return tCustomerService.selectById(parm);
        } catch (Exception e) {
            String message = "数据获取失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }
    
    /**
     * 修改数据
     * @param tCustomer 实体对象
     * @return 修改结果
     */
    @RequiresPermissions({"customer:update"})
    @PutMapping("/business/customer/update")
    public CommonResult tCustomerUpdate(@RequestBody TCustomer tCustomer, HttpServletRequest httpRequest) throws FebsException{
        try {
            SysToken sysToken=shiroService.findByToken(TokenUtil.getRequestToken(httpRequest));
            return tCustomerService.updateById(tCustomer,sysToken);
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
    @RequiresPermissions({"customer:list"})
    @PostMapping("/business/customer/list")
    public CommonResult tCustomerList(@RequestBody String param ) throws FebsException{
        try {
            return tCustomerService.selectAllPage(param);
        } catch (Exception e) {
            String message = "查询数据失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

}