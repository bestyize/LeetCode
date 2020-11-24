package com.yize.design;

import java.util.LinkedList;
import java.util.List;

/**
 * 请补全这个函数String getInfo(int errCode)，输入错误码返回错误信息，比如：
 * 错误代码1，用户名错误；
 * 错误代码2，密码错误；
 * 错误代码10-100，数据库错误；
 * 错误代码200-1000，文件找不到错误。
 * 要求这个函数要使修改错误码和错误信息时尽可能少修改代码（代码可维护）
 */
public class ErrCodeHelper {
    /**
     * 实现思路，把错误信息写在配置文件，或者从网络读取错误信息
     */
    public static List<ErrCode> errCodes;

    static class ErrCode{
        public int min;
        public int max;
        public String errInfo;

        public ErrCode(int min, int max, String errInfo) {
            this.min = min;
            this.max = max;
            this.errInfo = errInfo;
        }
    }

    public static String getInfo(int errCode){
        String errInfo=null;
        try {
            errInfo=getInfo(errCode,loadErrCodeList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return errInfo;
    }
    public static String getInfo(int errCode, List<ErrCode> errCodeList) throws Exception {
        if(errCodeList==null||errCodeList.isEmpty()){
            throw new Exception("ErrCode List Error");
        }
        for (ErrCode code:errCodeList){
            if(errCode>=code.min&&errCode<=code.max){
                return code.errInfo;
            }
        }
        throw new Exception("ErrCode Not Found Exception");
    }

    public static List<ErrCode> loadErrCodeList(){
        if(errCodes==null){
            //read from disk or network
            errCodes=new LinkedList<>();
        }
        return errCodes;
    }
}
