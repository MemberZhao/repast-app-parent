package com.aaa.lee.app.mapper;

import com.aaa.lee.app.domain.Member;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MemberMapper extends Mapper<Member> {
    /**
     * @param
     * @return
     * @author Memer Zhao
     * @date 2019/11/22 10:22
     * @description
     **/
    List<Member> selectMemberBalance(Long memberID);

    /**
     * @param
     * @return
     * @author Memer Zhao
     * @date 2019/11/22 10:22
     * @description
     **/
    Boolean updateMemberBalance(Integer money, Long memberID);
}