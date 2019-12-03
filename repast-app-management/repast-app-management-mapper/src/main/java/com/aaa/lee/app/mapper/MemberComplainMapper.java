package com.aaa.lee.app.mapper;

import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.domain.MemberComplain;
import tk.mybatis.mapper.common.Mapper;

public interface MemberComplainMapper extends Mapper<MemberComplain> {
    /**
     * 通过token查询当前用户信息
     * @param token
     * @return
     */
    Member getMemberByToken(String token);
}