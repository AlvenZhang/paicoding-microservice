package com.github.paicoding.dao;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.paicoding.entity.UserAiHistoryDO;
import com.github.paicoding.mapper.UserAiHistoryMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UserAiHistoryDao extends ServiceImpl<UserAiHistoryMapper, UserAiHistoryDO> {

    @Resource
    private UserAiHistoryMapper userAiHistoryMapper;
}

