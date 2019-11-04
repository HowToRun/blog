/**
 * Copyright (C), 2015-2019, 百分点信息科技有限公司
 *
 * @fileName: CatalogMapper
 * @author: yihan.hu
 * @date: 2019/11/1 16:39
 * @description:
 * @history: <author>          <date>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.blog.dao.self;

import com.blog.dto.CatalogDto;
import com.blog.entity.self.KindInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CatalogMapper {
    void save(KindInfo kindInfo);


    List<CatalogDto> getCatalogByPid(@Param("pId") Integer pId);

    void update(KindInfo kindInfo);
}
