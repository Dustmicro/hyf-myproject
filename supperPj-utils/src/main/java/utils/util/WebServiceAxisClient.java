package utils.util;

import utils.Exception.BusinessException;
import utils.constant.ResponseConstant;
import utils.log.LoggerEngine;

/**
 * 前端客户端服务
 * @author 黄弋峰
 */
public class WebServiceAxisClient extends LoggerEngine {
    public static void main(String[] args) {

    }

    /**
     * callWebService
     *
     * @param url
     * @param function
     * @param obj
     * @return
     * @throws Exception
     * @author wuxw
     */
    public static Object callWebService(String url, String function, Object[] obj) throws Exception {
        return callWebService(url,function,obj,2*60*1000);
    }

    /**
     * webservice 调用
     * @param url
     * @param function
     * @param obj
     * @param timeOut
     * @return
     * @throws Exception
     */
    public static Object callWebService(String url, String function, Object[] obj,Integer timeOut) throws BusinessException {
        Object retObj = null;
        try {
            logger.debug("-----------开始调用Web Service-----------");
            // 创建Service对象，Service对用用于创建Call对象
//            Service service = new Service();
//            // 创建Call对象，Call对象用于调用服务
//            Call call = (Call) service.createCall();
//            // 为Call对象设置WebService的url
//            call.setTargetEndpointAddress(new java.net.URL(url));
//            // 为Call对象设置调用的方法名
//            call.setOperationName(function);
//            // 设置等待时间
//            call.setTimeout(timeOut);
//            // 调用WebService的方法，并获得返回值
//            retObj = call.invoke(obj);
            logger.debug("-----------调用Web Service正常结束-----------");
        } catch (Exception e) {
            logger.error("-----------调用Web Service异常,原因:{}", e);
            e.printStackTrace();
            retObj = e.getMessage();
            throw new BusinessException(ResponseConstant.RESULT_CODE_INNER_ERROR,"WebServiceAxisClient.callWebService throws Exception : " + e.getMessage());
        }
        return retObj;
    }
}
