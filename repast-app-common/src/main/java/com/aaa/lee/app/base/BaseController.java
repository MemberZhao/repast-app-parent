package com.aaa.lee.app.base;

import com.aaa.lee.app.status.LoginStatus;
import com.aaa.lee.app.status.StatusEnum;
import org.springframework.stereotype.Controller;

/**
 * @Company 
 * @Author Seven Lee
 * @Date Create in 2019/11/20 11:10
 * @Description
 *      所有controller的基类
 **/
@Controller
public class BaseController {

    /**
     * @author Seven Lee
     * @description
     *      登录成功，使用系统消息
     * @param []
     * @date 2019/11/20
     * @return com.aaa.lee.app.base.ResultData
     * @throws 
    **/
    protected ResultData success() {
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_SUCCESS.getCode());
        resultData.setMsg(LoginStatus.LOGIN_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @author Seven Lee
     * @description
     *      登录成功，自定义返回消息
     * @param [msg]
     * @date 2019/11/20
     * @return com.aaa.lee.app.base.ResultData
     * @throws
    **/
    protected ResultData success(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @author Seven Lee
     * @description
     *      登录成功，使用系统消息，自定义返回值
     * @param [data]
     * @date 2019/11/20
     * @return com.aaa.lee.app.base.ResultData
     * @throws
    **/
    protected ResultData success(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_SUCCESS.getCode());
        resultData.setMsg(LoginStatus.LOGIN_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @author Seven Lee
     * @description
     *      登录成功，自定义消息，自定义返回值
     * @param [msg, data]
     * @date 2019/11/20
     * @return com.aaa.lee.app.base.ResultData
     * @throws 
    **/
    protected ResultData success(String msg, Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * @author Seven Lee
     * @description
     *      登录失败，返回系统消息
     * @param []
     * @date 2019/11/20
     * @return com.aaa.lee.app.base.ResultData
     * @throws 
    **/
    protected ResultData failed() {
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_FAILED.getCode());
        resultData.setMsg(LoginStatus.LOGIN_FAILED.getMsg());
        return resultData;
    }

    // TODO 该类未完成，自行完成剩余的方法
    protected ResultData failed(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    protected ResultData failed(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_FAILED.getCode());
        resultData.setMsg(LoginStatus.LOGIN_FAILED.getMsg());
        resultData.setData(data);
        return resultData;
    }
    protected ResultData failed(String msg,Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_FAILED.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }
    /**
     * 查询成功，自定义消息，自定义返回值
     * @return
     */
    protected  ResultData querySuccess(String msg, Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(StatusEnum.SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * 查询失败，自定义消息
     * @return
     */
    protected ResultData queryFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(StatusEnum.FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 删除评价成功，自定义返回消息
     * @return
     */
    protected  ResultData delSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(StatusEnum.DELETE_OPERATION.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 删除评价失败，自定义返回消息
     * @return
     */
    protected ResultData delFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(StatusEnum.DELETE_OPERATION.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 添加评价成功，自定义返回消息
     * @return
     */
    protected  ResultData addSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(StatusEnum.INSERT_OPERATION.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 添加评价失败，自定义返回消息
     * @param msg
     * @return
     */
    protected  ResultData addFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(StatusEnum.INSERT_OPERATION.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
}
