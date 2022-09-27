package com.myccb.comm;
import com.myccb.appmid.common.gateway.util.ServiceExceptionMycc;
import com.myccb.comm.constant.CommConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




/**
 * 公共服务类
 * @author 黄弋峰
 */
public class CommService {
    private static final Logger logger = LoggerFactory.getLogger(CommService.class);

    /**
     * 校验必输项
     * @param cloumn
     * @param columnName
     * @throws ServiceExceptionMycc
     */
    public static void CheckEmpty(String cloumn, String columnName) throws ServiceExceptionMycc{
        if (StringUtilsMycc.isNull(cloumn)){
            throw new ServiceExceptionMycc(CommConstant.ERROR_CODE, "请求字段" + columnName + "必输项为空!!");
        }
    }

}
