package com.myccb.utils.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 异常工具类
 * @author 黄弋峰
 */
public class ExceptionUtil {
    public static String getStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        try {
            throwable.printStackTrace(pw);
            return sw.toString();
        } finally {
            pw.close();
        }
    }
}
