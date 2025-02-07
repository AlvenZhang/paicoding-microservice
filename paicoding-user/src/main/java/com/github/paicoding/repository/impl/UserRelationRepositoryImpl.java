package com.github.paicoding.repository.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.paicoding.converter.UserConverter;
import com.github.paicoding.dao.UserRelationDao;
import com.github.paicoding.entity.UserRelationDO;
import com.github.paicoding.forum.api.model.vo.user.dto.UserRelationDTO;
import com.github.paicoding.repository.UserRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRelationRepositoryImpl implements UserRelationRepository {

    @Autowired
    private UserRelationDao userRelationDao;


    @Override
    public UserRelationDTO getUserRelationRecord(Long userId, Long followUserId) {
        UserRelationDO userRelationRecord = userRelationDao.getUserRelationRecord(userId, followUserId);
        UserRelationDTO userRelationDTO = UserConverter.toDTO(userRelationRecord);
        return userRelationDTO;
    }

    @Override
    public void save(UserRelationDTO userRelationDTO) {
        if (userRelationDTO == null){
            throw new RuntimeException("用户关注信息不能为空");
        }
        UserRelationDO userRelationDO = UserConverter.toDO(userRelationDTO);
        userRelationDao.save(userRelationDO);
    }

    @Override
    public void reset(UserRelationDTO userRelationDTO) {
        if (userRelationDTO == null){
            throw new RuntimeException("用户关注信息不能为空");
        }
        UpdateWrapper<UserRelationDO> userRelationDOUpdateWrapper = new UpdateWrapper<>();
        userRelationDOUpdateWrapper.set("follow_state", userRelationDTO.getFollowState());
        userRelationDOUpdateWrapper.eq("user_id", userRelationDTO.getUserId());
        userRelationDOUpdateWrapper.eq("follow_user_id", userRelationDTO.getFollowUserId());
        userRelationDao.update(userRelationDOUpdateWrapper);
    }
}
