/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.soc.vir;

/**
 * 虚拟化资源管理相关常量类
 * 
 */
public class IGVIRCONSTANTS {

    /** 资源申请表单——项目主键 */
    public static final String APPLY_FORM_PROJECT = "项目主键";
    
    /** 即将过期天数 */
    public static final Integer WILL_EXPIRE = 10;
    
    /** 虚机状态：未部署 */
    public static final String VM_STATUS_A = "A";
    
    /** 虚机状态：部署中 */
    public static final String VM_STATUS_B = "B";
    
    /** 虚机状态：已部署 */
    public static final String VM_STATUS_C = "C";
    
    /** 虚机状态：调整中 */
    public static final String VM_STATUS_D = "D";
    
    /** 虚机状态：回收中 */
    public static final String VM_STATUS_E = "E";
    
    /** 虚机状态：已回收 */
    public static final String VM_STATUS_F = "F";

    /** 资源调整类型标识：调整 */
    public static final String RESOURCE_CHANGE_C = "C";
    
    /** 资源调整类型标识：回收 */
    public static final String RESOURCE_CHANGE_R = "R";
}
