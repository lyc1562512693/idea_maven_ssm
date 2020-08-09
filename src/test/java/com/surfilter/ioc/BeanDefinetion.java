package com.surfilter.ioc;

/**
 * bean详细信息
 */
public class BeanDefinetion {
    private String beanName;
    private String alias;

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
