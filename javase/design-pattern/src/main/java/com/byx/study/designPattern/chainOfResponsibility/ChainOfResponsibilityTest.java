package com.byx.study.designPattern.chainOfResponsibility;

import org.junit.Test;

/**
 * @author wang zhen xing
 * @date 2020/11/30 11:06
 * 责任链模式
 */
public class ChainOfResponsibilityTest {
    public static void main(String[] args) {
        Request request = new Request.RequestBuilder().frequentOK(false).loggedIn(true).build();
        RequestFrequentHandler requestFrequentHandler = new RequestFrequentHandler(new LoggingHandler(null));
        if (requestFrequentHandler.procces(request)) {
            System.out.println("正常业务处理");
        } else {
            System.out.println("访问异常");
        }
    }
}

class Request {
    private boolean loggedIn;
    private boolean frequentOK;
    private boolean isPermits;
    private boolean containsSensitiveWords;
    private String requestBody;

    public Request(boolean loggedIn, boolean frequentOK, boolean isPermits, boolean containsSensitiveWords) {
        this.loggedIn = loggedIn;
        this.frequentOK = frequentOK;
        this.isPermits = isPermits;
        this.containsSensitiveWords = containsSensitiveWords;
    }

    static class RequestBuilder {
        private boolean loggedIn;
        private boolean frequentOK;
        private boolean isPermits;
        private boolean containsSensitiveWords;

        RequestBuilder loggedIn(boolean loggedIn) {
            this.loggedIn = loggedIn;
            return this;
        }

        RequestBuilder frequentOK(boolean frequentOK) {
            this.frequentOK = frequentOK;
            return this;
        }

        RequestBuilder isPermits(boolean isPermits) {
            this.isPermits = isPermits;
            return this;
        }

        RequestBuilder containsSensitiveWords(boolean containsSensitiveWords) {
            this.containsSensitiveWords = containsSensitiveWords;
            return this;
        }

        public Request build() {
            Request request = new Request(loggedIn, frequentOK, isPermits, containsSensitiveWords);
            return request;
        }

    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public boolean isFrequentOK() {
        return frequentOK;
    }

    public boolean isPermits() {
        return isPermits;
    }

    public boolean isContainsSensitiveWords() {
        return containsSensitiveWords;
    }
}

abstract class Handler {
    Handler next;

    public Handler(Handler next) {
        this.next = next;
    }

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    abstract boolean procces(Request request);

}

class RequestFrequentHandler extends Handler {
    public RequestFrequentHandler(Handler next) {
        super(next);
    }

    @Override
    boolean procces(Request request) {
        System.out.println("访问频率控制");
        if (request.isFrequentOK()) {
            Handler next = getNext();
            if (next == null) {
                return true;
            }
            return next.procces(request);
        }
        return false;
    }
}

class LoggingHandler extends Handler {

    public LoggingHandler(Handler next) {
        super(next);
    }

    @Override
    boolean procces(Request request) {
        System.out.println("登录验证");
        if (request.isLoggedIn()) {
            Handler next = getNext();
            if (next == null) {
                return true;
            }
            return next.procces(request);
        }
        return false;
    }
}

