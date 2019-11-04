/**
 * Copyright (C), 2015-2019, 百分点信息科技有限公司
 *
 * @fileName: CatalogService
 * @author: yihan.hu
 * @date: 2019/11/1 16:38
 * @description:
 * @history: <author>          <date>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.blog.service.self;

import com.blog.entity.self.KindInfo;
import com.blog.utils.R;

public interface CatalogService {
    R save(KindInfo kindInfo);

    R getCatalog();

    R update(KindInfo kindInfo);
}
