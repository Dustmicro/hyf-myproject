package com.myccb;

import java.io.IOException;

public class HttpCilent {

    public static class Response{
        private int status;
        private String content;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }


    public static Response operate(String url, String content, String messageType, String mathod) throws IOException {
        return null;

    }
}
