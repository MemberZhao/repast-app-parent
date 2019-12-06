package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.domain.MemberReceiveAddress;
import com.aaa.lee.app.mapper.MemberMapper;
import com.aaa.lee.app.mapper.MemberReceiveAddressMapper;
import com.aaa.lee.app.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

import static com.aaa.lee.app.staticstatus.StaticProperties.*;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/21 10:39
 * @Description
 **/
@Service
public class MemberReceiveAddressService extends BaseService<MemberReceiveAddress> {

    @Autowired
    private MemberReceiveAddressMapper memberReceiveAddressMapper;

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Mapper<MemberReceiveAddress> getMapper() {
        return memberReceiveAddressMapper;
    }

    /**
     * @author Seven Lee
     * @description
     *      通用会员id查询会员的收获地址列表
     * @param
     * @date 2019/11/21
     * @return java.util.List<com.aaa.lee.app.domain.MemberReceiveAddress>
     * @throws
     **/
    public List<MemberReceiveAddress> getMemberReceiveAddress(String token) {
        Member member =new Member();
        member.setToken(token);
        Member m = memberMapper.selectOne(member);
        if (null!=m){
            return memberReceiveAddressMapper.selectMemberReceiveAddrrss(m.getId());
        }else{
            return null;
        }
    }

    /**
     * 根据id删除收货地址
     * @param id
     * @return
     */
    public boolean delSite(Long id ,String token){
        Member member = memberMapper.selectByPrimaryKey(token);
        if (null != member){
            Integer i = memberReceiveAddressMapper.delSite(id);
            if (i>0){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    /**
     * 修改会员表的收货地址
     * @param memberReceiveAddress
     * @return
     */
    public boolean upSite(MemberReceiveAddress memberReceiveAddress,String token){
        Member member = memberMapper.selectByPrimaryKey(token);
        if (null != member) {
            int i = memberReceiveAddressMapper.updateByPrimaryKey(memberReceiveAddress);
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        }else{
            return false;
        }
    }
    /**
     * 添加收货地址
     * @param memberReceiveAddress
     * @return
     */
    public boolean insertSite(MemberReceiveAddress memberReceiveAddress, String token) {
        Member member = memberMapper.selectByPrimaryKey(token);
        if (null != member) {
            int i = memberReceiveAddressMapper.insert(memberReceiveAddress);
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        }else{
            return false;
        }
    }
}
