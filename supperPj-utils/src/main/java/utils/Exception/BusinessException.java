package utils.Exception;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.exception.ExceptionUtils;


import javax.xml.transform.Result;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * 权限校验、权限异常
 * @author 黄弋峰
 */
public class BusinessException extends RuntimeException {
    private Result result;
    private Throwable cause = this;

    public BusinessException(){}

    /**
     * 构造方法
     * @param result 返回值
     * @param cause  异常堆栈
     */
    public BusinessException(Result result, Throwable cause) {
        super(result.getSystemId(), cause);
        this.result = result;
    }

    /**
     * 构造方法
     * @param code 返回码
     * @param msg  错误消息
     */
    public BusinessException(int code, String msg) {
        super(msg);
//        this.result = new Result() {
//            @Override
//            public void setSystemId(String systemId) {
//
//                return systemId;
//            }
//
//            @Override
//            public String getSystemId() {
//                return null;
//            }
//        };
    }

    public BusinessException(String code, String msg) {
        super(msg);
//        this.result = new Result() {
//            @Override
//            public void setSystemId(String systemId) {
//
//                return systemId;
//            }
//
//            @Override
//            public String getSystemId() {
//                return null;
//            }
//        };
    }

    /**
     * 构造方法
     * @param result 返回值
     * @param detail 具体的返回消息
     */
//    public BusinessException(Result result, String detail) {
//        super(result.getSystemId() + "," + detail);
//        this.result = new Result(result.getSystemId(), result.toString() + "," + detail);
//    }

    /**
     * 构造方法
     * @param result 返回值
     * @param detail 具体的返回消息
     * @param cause  异常堆栈
     */
//    public BusinessException(Result result, String detail, Throwable cause) {
//        super(result.getMsg() + "," + detail, cause);
//        this.result = new Result(result.getCode(), result.getMsg() + "," + detail);
//    }

    /**
     * 构造方法
     * @param code	返回码
     * @param msg	返回消息
     * @param cause 异常堆栈
     */
    public BusinessException(String code, String msg, Throwable cause) {
        super(msg, cause);

        if(cause != null) {
//            if(cause.getCause() != null) {
//                msg += " cause:" + ExceptionUtils.getCause(cause.getCause(), 500);
//            }
//            msg += " StackTrace:"+ExceptionUtils.getCause(cause, ([ 500,500));
        }
        String finalMsg = msg;
//        this.result = new Result(code, finalMsg) {
//            @Override
//            public void setSystemId(String s) {
//                return;
//            }
//
//            @Override
//            public String getSystemId() {
//                return finalMsg;
//            }
//        };
    }

    /**
     * 构造方法
     * @param code	返回码
     * @param cause	异常堆栈
     */
    public BusinessException(int code, Throwable cause) {
        super(cause);
        String msg = "";

//        if(cause != null) {
//            if(cause.getCause() != null) {
//                msg += " cause:" + ExceptionUtils.populateExecption(cause.getCause(), 500);
//            }
//            msg += " StackTrace:"+ExceptionUtils.populateExecption(cause, 500);
//        }
//        this.result = new Result(code, msg);
    }

    /**
     *
     * TODO 简单描述该方法的实现功能（可选）.
     * @see Throwable#getCause()
     */
    public synchronized Throwable getCause() {
        return (cause==this ? super.getCause() : cause);
    }


    /**
     * 返回异常消息
     * @return 异常消息
     */
    @Override
    public String getMessage() {
        return ExceptionUtils.getMessage(getCause());
    }

    /**
     * 异常
     * @return
     */
    public String toJsonString() {
        JSONObject exceptionJson = JSONObject.parseObject("{\"exception\":{}");
        JSONObject exceptionJsonObj = exceptionJson.getJSONObject("exception");

        if (getResult() != null)
            exceptionJsonObj.putAll(JSONObject.parseObject(result.toString()));

        exceptionJsonObj.put("exceptionTrace",getMessage());

        return exceptionJsonObj.toString();
    }
    @Override
    public void printStackTrace(PrintStream ps) {
        ps.print("<exception>");
        if (getResult() != null) {
            ps.print(result.toString());
        }
        ps.append("<exceptionTrace>");

        Throwable cause = getCause();
        if (cause == null) {
            super.printStackTrace(ps);
        } else {
            ps.println(this);
            ps.print("Caused by: ");
            cause.printStackTrace(ps);
        }
        ps.append("</exceptionTrace>");
        ps.println("</exception>");
    }

    @Override
    public void printStackTrace(PrintWriter pw) {
        pw.print("<exception>");
        if (getResult() != null) {
            pw.print(result.toString());
        }
        pw.append("<exceptionTrace>");

        Throwable cause = getCause();
        if (cause == null) {
            super.printStackTrace(pw);
        } else {
            pw.println(this);
            pw.print("Caused by: ");
            cause.printStackTrace(pw);
        }
        pw.append("</exceptionTrace>");
        pw.println("</exception>");
    }

    /**
     * 返回异常值
     * @return	异常值对象
     */
    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}
