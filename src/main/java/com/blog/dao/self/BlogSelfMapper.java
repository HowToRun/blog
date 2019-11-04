/**
 * Copyright (C), 2015 - 2019 , 百分点信息科技有限公司
 *
 * @fileName: BlogSelfMapper
 * @author: huyih
 * @date: 2019/10/31 16:37
 * @description:
 * @history: <author>          <date>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.blog.dao.self;

import com.blog.entity.self.BlogInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogSelfMapper {
    void saveBlogInfo(BlogInfo blogInfo);

    void saveBlogText(BlogInfo blogInfo);

    List<BlogInfo> listBlog(BlogInfo blogInfo);
}
