package com.github.paicoding.userrelation.model.converter;


import com.github.paicoding.forum.api.model.enums.FollowStateEnum;
import com.github.paicoding.forum.api.model.enums.RoleEnum;
import com.github.paicoding.forum.api.model.enums.user.UserAIStatEnum;
import com.github.paicoding.forum.api.model.vo.user.UserInfoSaveReq;
import com.github.paicoding.forum.api.model.vo.user.UserRelationReq;
import com.github.paicoding.forum.api.model.vo.user.UserSaveReq;
import com.github.paicoding.forum.api.model.vo.user.dto.BaseUserInfoDTO;
import com.github.paicoding.forum.api.model.vo.user.dto.SimpleUserInfoDTO;
import com.github.paicoding.forum.api.model.vo.user.dto.UserRelationDTO;
import com.github.paicoding.forum.api.model.vo.user.dto.UserStatisticInfoDTO;
import com.github.paicoding.forum.core.context.ReqInfoContext;
import com.github.paicoding.forum.core.util.JsonUtil;

import com.github.paicoding.userrelation.model.UserRelation;
import com.github.paicoding.userrelation.model.UserRelationDO;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

/**
 * 用户转换
 *
 * @author louzai
 * @date 2022-07-20
 */
public class UserConverter {







    public static UserRelationDTO toDTO(UserRelation userRelation){
        if (userRelation == null){
            return null;
        }
        UserRelationDTO userRelationDTO = new UserRelationDTO();
        BeanUtils.copyProperties(userRelation, userRelationDTO);
        return userRelationDTO;
    }

    public static UserRelationDTO toDTO(UserRelationDO userRelationDO){
        if (userRelationDO == null){
            return null;
        }
        UserRelationDTO userRelationDTO = new UserRelationDTO();
        BeanUtils.copyProperties(userRelationDO, userRelationDTO);
        return userRelationDTO;
    }



    public static UserRelationDO toDO(UserRelationReq req) {
        if (req == null) {
            return null;
        }
        UserRelationDO userRelationDO = new UserRelationDO();
        userRelationDO.setUserId(req.getUserId());
        userRelationDO.setFollowUserId(ReqInfoContext.getReqInfo().getUserId());
        userRelationDO.setFollowState(req.getFollowed() ? FollowStateEnum.FOLLOW.getCode() : FollowStateEnum.CANCEL_FOLLOW.getCode());
        return userRelationDO;
    }
    public static UserRelationDO toDO(UserRelationDTO userRelationDTO) {
        if (userRelationDTO == null) {
            return null;
        }
        UserRelationDO userRelationDO = new UserRelationDO();
        BeanUtils.copyProperties(userRelationDTO, userRelationDO);
        return userRelationDO;
    }


    public static UserStatisticInfoDTO toUserHomeDTO(UserStatisticInfoDTO userHomeDTO, BaseUserInfoDTO baseUserInfoDTO) {
        if (baseUserInfoDTO == null) {
            return null;
        }
        BeanUtils.copyProperties(baseUserInfoDTO, userHomeDTO);
        return userHomeDTO;
    }
}
