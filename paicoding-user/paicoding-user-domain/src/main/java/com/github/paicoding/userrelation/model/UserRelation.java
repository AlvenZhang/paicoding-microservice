package com.github.paicoding.userrelation.model;



import com.github.paicoding.forum.api.model.enums.NotifyTypeEnum;
import com.github.paicoding.forum.api.model.vo.notify.NotifyMsgEvent;
import com.github.paicoding.forum.api.model.vo.user.UserRelationReq;
import com.github.paicoding.forum.api.model.vo.user.dto.UserRelationDTO;
import com.github.paicoding.forum.core.context.ReqInfoContext;
import com.github.paicoding.forum.core.util.SpringUtil;

import com.github.paicoding.userrelation.model.converter.UserConverter;
import com.github.paicoding.userrelation.repository.UserRelationRepository;
import lombok.Data;


import javax.annotation.Resource;

@Data
public class UserRelation {

    private static final long serialVersionUID = 1L;

    /**
     * 主用户ID
     */
    private Long userId;

    /**
     * 粉丝用户ID
     */
    private Long followUserId;

    /**
     * 关注状态: 0-未关注，1-已关注，2-取消关注
     */
    private Integer followState;

    public UserRelation(Long userId, Long followUserId, Integer followState) {
        this.userId = userId;
        this.followUserId = followUserId;
        this.followState = followState;
        this.isValid();
    }

    @Resource
    private UserRelationRepository userRelationRepository;

    // 是否已经有关注信息
    public boolean hasRelation(){
        UserRelationDTO userRelationDTO = userRelationRepository.getUserRelationRecord(userId, followUserId);
        return userRelationDTO != null;
    }

    // 关注用户
    public void follow(){
        UserRelationDTO userRelationDTO = UserConverter.toDTO(this);
        userRelationRepository.save(userRelationDTO);
        // 发布关注事件
        SpringUtil.publishEvent(new NotifyMsgEvent<>(this, NotifyTypeEnum.FOLLOW, this));
    }

    // 重置关注关系
    public void reset(){
        // 将是否关注状态重置
        userRelationRepository.reset(UserConverter.toDTO(this));
        // 发布关注、取消关注事件
        SpringUtil.publishEvent(new NotifyMsgEvent<>(this, this.getFollowState()==1 ? NotifyTypeEnum.FOLLOW : NotifyTypeEnum.CANCEL_FOLLOW, this));
    }

    public void isValid(){
        if (!this.userId.equals(ReqInfoContext.getReqInfo().getUserId())){
            throw new RuntimeException("不能修改其他用户的关系");
        }
    }

}
