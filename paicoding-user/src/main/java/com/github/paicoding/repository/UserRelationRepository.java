package com.github.paicoding.repository;

import com.github.paicoding.forum.api.model.vo.user.dto.UserRelationDTO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.security.auth.message.callback.PrivateKeyCallback;

public interface UserRelationRepository {

    UserRelationDTO getUserRelationRecord(Long userId, Long followUserId);

    // 保存用户关系
    void save(UserRelationDTO userRelationDTO);

    void reset(UserRelationDTO userRelationDTO);
}
