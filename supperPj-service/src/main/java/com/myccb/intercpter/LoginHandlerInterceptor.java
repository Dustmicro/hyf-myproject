//package com.myccb.intercpter;
//
//import com.myccb.comm.redis.JWTCache;
//import com.myccb.mapper.UserDbMapper;
//import org.apache.ibatis.session.SqlSession;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
///**
// * 请求拦截器
// */
//public class LoginHandlerInterceptor implements HandlerInterceptor{
//    private static final Logger logger = LoggerFactory.getLogger(LoginHandlerInterceptor.class);
//
//    private static final String SESSION_ID = "sessionId";
//
//    @Autowired
//    UserDbMapper userMapper;
//    @Autowired
//    public SqlSession sqlSession;
//
//
//    /**
//     * 校验同一账号多人登录
//     * @param request
//     * @param userId
//     * @return
//     */
//    private boolean CheckOtherLogin(HttpServletRequest request, String userId){
//        HttpSession session = request.getSession();
//        String sessionId = request.getHeader(SESSION_ID);
//        String redisSessionId = JWTCache.getValue(JWTCache.SESSION_PREFIX+userId);
//        boolean flag = false;
//        if (redisSessionId == null || sessionId.equals(redisSessionId)){
//            flag = true;
//        }else {
//            session.getAttribute("你的账号在其他客户端已登录，你已被挤下线！！");
//        }
//        return flag;
//    }
//}
