package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.domain.MemberComplain;
import com.aaa.lee.app.mapper.MemberComplainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Whc
 * @Date 2019/11/25 21:27
 * @Description
 **/

@Service
public class MemberComplainService extends BaseService<MemberComplain> {

    @Autowired
    private MemberComplainMapper memberComplainMapper;

    @Override
    public Mapper<MemberComplain> getMapper() {

        return memberComplainMapper;
    }

    /**
     * 添加意见信息功能
     * @param complain
     * @return
     */
    public Boolean addComplain(MemberComplain complain, String token) {
        if(null != token || !"".equals(token)){
            Member memberByToken = memberComplainMapper.getMemberByToken(token);
            complain.setMemberId(memberByToken.getId());
            //********
            //获取当前时间
            Date date = new Date();
            String formatDate = null;
            //HH表示24小时制；
            DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            formatDate = dFormat.format(date);
            SimpleDateFormat lsdStrFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date strD = null;
            try {
                strD = lsdStrFormat.parse(formatDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println(strD+"======================");
            complain.setCreateTime(strD);
            int insert = memberComplainMapper.insert(complain);
            if (insert > 0) {
                return true;
            }else{
                return null;
            }
        }else{
            return null;
        }

    }
}
