package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.mapper.MemberMapper;
import com.aaa.lee.app.utils.IDUtil;
import com.aaa.lee.app.utils.JSONUtil;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

import static com.aaa.lee.app.staticstatus.StaticProperties.*;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/21 9:37
 * @Description
 **/
@Service
public class MemberService extends BaseService<Member> {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Mapper<Member> getMapper() {
        return memberMapper;
    }
    /**
     * 执行登录操作
     * @param member
     * @param Member
     * @return
     */
    public String doLogin(Member member){
        try {
            Member member1 = super.selectOne(member);
            String token = member.getOpenId()+IDUtil.getUUID();

            if (null != member1){
                //数据库中有数据，登录成功
                member1.setToken(token);
                memberMapper.updateByPrimaryKey(member1);
                return token;
            }else {
                member.setToken(token);
                memberMapper.insert(member);
                return token;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 获取用户信息
     * @param member
     * @param redisService
     * @return
     */

    public String newUser(Member member){

        if(null != member ){
            String token = member.getOpenId()+ IDUtil.getUUID();
            member.setToken(token);
            if ( memberMapper.insert(member) > 0){
                return token;
            }
            return null;
        }
        return null;
    }


                /**
                 * 如果涉及到session的跨域:
                 *      如果是ajax，session跨域传递数据必须使用jsonp
                 *      如果是常规的调用:
                 *          1.把user对象存到redis中，也就是说redis就相当于session，然后把redis的key存入到cookie中
                 *          2.自己百度session的全局配置
                 *
                 *      什么是脏读什么是幻读？
                 *          无论是脏读还是幻读假设第一次读出了一条数据，第二次读出了两条
                 *          脏读和幻读唯一的区别就看事务是否提交(也就是说是否执行了commit操作)
                 *          如果执行了则就是幻读
                 *          如果没有执行就是脏读
                 */


    /**
     * @author shenzhendong
     * @date 2019/11/22 9:48
     *      验证登录
     * @description
     * @param
     * @return
     **/

}
