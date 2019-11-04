/**
 * Copyright (C), 2015 - 2019 , 百分点信息科技有限公司
 *
 * @fileName: CatalogController
 * @author: huyih
 * @date: 2019/11/1 16:35
 * @description:
 * @history: <author>          <date>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.blog.controller.self;

import com.blog.entity.self.BlogInfo;
import com.blog.entity.self.KindInfo;
import com.blog.service.self.CatalogService;
import com.blog.utils.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
    @Autowired
    CatalogService catalogService;


    @ApiOperation("新增分类")
    @RequestMapping(value = "/save",method = {RequestMethod.POST})
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body", dataType = "KindInfo", name = "kindInfo", value = "")})
    public R list(@RequestBody KindInfo kindInfo){

        return catalogService.save(kindInfo);
    }

    @ApiOperation("重命名")
    @RequestMapping(value = "/update",method = {RequestMethod.POST})
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body", dataType = "KindInfo", name = "kindInfo", value = "")})
    public R update(@RequestBody KindInfo kindInfo){

        return catalogService.update(kindInfo);
    }
    @ApiOperation("获取分类树形数据结构")
    @RequestMapping(value = "/getCatalog",method = {RequestMethod.GET})
    public R getCatalog(){
        return catalogService.getCatalog();
    }
}
