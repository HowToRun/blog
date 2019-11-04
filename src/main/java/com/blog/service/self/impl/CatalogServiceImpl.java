/**
 * Copyright (C), 2015 - 2019 , 百分点信息科技有限公司
 *
 * @fileName: CatalogServiceImpl
 * @author: huyih
 * @date: 2019/11/1 16:38
 * @description:
 * @history: <author>          <date>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.blog.service.self.impl;

import com.blog.dao.self.CatalogMapper;
import com.blog.dto.CatalogDto;
import com.blog.entity.self.KindInfo;
import com.blog.service.self.CatalogService;
import com.blog.utils.R;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {
    @Resource
    CatalogMapper catalogMapper;

    @Override
    public R save(KindInfo kindInfo) {
        catalogMapper.save(kindInfo);
        return new R().ok("保存成功");
    }

    @Override
    public R getCatalog() {
//        先查询父类
        List<CatalogDto> resultList = catalogMapper.getCatalogByPid(0);
//        遍历父类查询子类
        resultList.forEach(e->{
            List<CatalogDto> children = catalogMapper.getCatalogByPid(e.getId());
            e.setChildren(children);
        });
        return new R().ok(resultList);
    }

    @Override
    public R update(KindInfo kindInfo) {
        catalogMapper.update(kindInfo);
        return new R().ok("修改成功");
    }
}
