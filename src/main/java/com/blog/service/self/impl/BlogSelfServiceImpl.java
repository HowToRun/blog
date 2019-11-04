/**
 * Copyright (C), 2015 - 2019 , 百分点信息科技有限公司
 *
 * @fileName: BlogServiceImpl
 * @author: huyih
 * @date: 2019/10/31 16:31
 * @description:
 * @history: <author>          <date>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.blog.service.self.impl;

import com.blog.dao.self.BlogSelfMapper;
import com.blog.entity.self.BlogInfo;
import com.blog.service.self.BlogSelfService;
import com.blog.utils.R;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BlogSelfServiceImpl implements BlogSelfService {
    @Resource
    BlogSelfMapper blogSelfMapper;

    @Override
    @Transactional
    public void saveBlog(BlogInfo blogInfo) {
//        先将博客基本信息入库返回id用于text表存储
        blogSelfMapper.saveBlogInfo(blogInfo);
        System.out.println(blogInfo);
        blogSelfMapper.saveBlogText(blogInfo);
    }

    @Override
    public R listBlog(BlogInfo blogInfo, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<BlogInfo> blogList = blogSelfMapper.listBlog(blogInfo);
        PageInfo resultList = new PageInfo(blogList);
        return new R().ok(resultList);

    }
}
