/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model;


/**
 * 流程缺省变量权限
 * 
 */
public interface IG913Info {
    /**
     * @return the 流程自定义ID
     */
    public String getPdid() ;

    /**
     * @return the 流程自定义名称
     */
    public String getPdname();

    /**
     * @return the ig911表的主键
     */
    public String getPsprpid() ;
    
    /**
     * @return the ig931表的主键
     */
    public String getDpsprpid();

}
