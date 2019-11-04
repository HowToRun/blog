/**
 * Copyright (C), 2015 - 2019 , 百分点信息科技有限公司
 *
 * @fileName: BlogController
 * @author: huyih
 * @date: 2019/10/30 16:07
 * @description: 个人博客博文相关操作
 * @history: <author>          <date>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.blog.controller.self;

import com.alibaba.druid.util.StringUtils;
import com.blog.entity.self.BlogInfo;
import com.blog.service.self.BlogSelfService;
import com.blog.utils.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/blogSelf")
public class BlogController {

    @Autowired
    BlogSelfService blogSelfService;

    @ApiOperation("保存博客")
    @RequestMapping(value = "/save",method = {RequestMethod.POST})
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body", dataType = "BlogInfo", name = "blogInfo", value = "")})
    public R save(@RequestBody BlogInfo blogInfo){
        if(StringUtils.isEmpty(blogInfo.getTitle())){
            return new R().error("文章标题不可为空");
        }
        if(StringUtils.isEmpty(blogInfo.getText())){
            return new R().error("无效的文章内容");
        }
        blogSelfService.saveBlog(blogInfo);
        return  new R().ok("保存成功");
    }

    @ApiOperation("博客查询")
    @RequestMapping(value = "/list",method = {RequestMethod.GET})
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body", dataType = "BlogInfo", name = "blogInfo", value = "")})
    public R list(BlogInfo blogInfo,
                  @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                  @RequestParam(value = "pageSize",defaultValue = "15")Integer pageSize){
        System.out.println(blogInfo);
        return blogSelfService.listBlog(blogInfo,pageNum,pageSize);
    }



}
