package com.yu.mall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yu.mall.product.entity.DicInfoEntity;
import com.yu.mall.product.service.DicInfoService;
import com.yu.common.utils.PageUtils;
import com.yu.common.utils.R;



/**
 * 字典表
 *
 * @author yu
 * @email 183213557@qq.com
 * @date 2020-12-17 21:53:41
 */
@RestController
@RequestMapping("product/dicinfo")
public class DicInfoController {
    @Autowired
    private DicInfoService dicInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:dicinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = dicInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{dicCode}")
    //@RequiresPermissions("product:dicinfo:info")
    public R info(@PathVariable("dicCode") Long dicCode){
		DicInfoEntity dicInfo = dicInfoService.getById(dicCode);

        return R.ok().put("dicInfo", dicInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:dicinfo:save")
    public R save(@RequestBody DicInfoEntity dicInfo){
		dicInfoService.save(dicInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:dicinfo:update")
    public R update(@RequestBody DicInfoEntity dicInfo){
		dicInfoService.updateById(dicInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:dicinfo:delete")
    public R delete(@RequestBody Long[] dicCodes){
		dicInfoService.removeByIds(Arrays.asList(dicCodes));

        return R.ok();
    }

}
