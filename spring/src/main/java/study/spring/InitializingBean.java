/**
 * LY.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package study.spring;

/**
 * @author 1205869
 * @version Id: InitializeBean, v 0.1 2022/8/26 9:31 PM 1205869 Exp $
 */
public interface InitializingBean {
    void afterPropertiesSet() throws Exception;
}
