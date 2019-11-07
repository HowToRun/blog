/**
 * Copyright (C), 2015-2019, 百分点信息科技有限公司
 *
 * @fileName: BlogService
 * @author: yihan.hu
 * @date: 2019/10/31 16:31
 * @description:
 * @history: <author>          <date>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.blog.service.self;

import com.blog.entity.self.BlogInfo;
import com.blog.utils.R;

public interface BlogSelfService {
    void saveBlog(BlogInfo blogInfo);

    R listBlog(BlogInfo blogInfo, Integer pageNum, Integer pageSize);

    R getArchives();
}
