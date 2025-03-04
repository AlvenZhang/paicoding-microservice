package com.github.paicoding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.paicoding.entity.SearchZsxqWhiteParams;
import com.github.paicoding.entity.UserAiDO;
import com.github.paicoding.forum.api.model.vo.PageParam;
import com.github.paicoding.forum.api.model.vo.user.dto.ZsxqUserInfoDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ai用户登录mapper接口
 *
 * @author ygl
 * @date 2022-07-18
 */
public interface UserAiMapper extends BaseMapper<UserAiDO> {

    Long countZsxqUsersByParams(@Param("searchParams") SearchZsxqWhiteParams params);

    List<ZsxqUserInfoDTO> listZsxqUsersByParams(@Param("searchParams") SearchZsxqWhiteParams params,
                                                @Param("pageParam") PageParam newPageInstance);
}
