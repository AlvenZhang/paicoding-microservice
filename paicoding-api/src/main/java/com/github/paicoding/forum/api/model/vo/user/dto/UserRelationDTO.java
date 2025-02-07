package com.github.paicoding.forum.api.model.vo.user.dto;


import lombok.Data;

@Data
public class UserRelationDTO {

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
}
