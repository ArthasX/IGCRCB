/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 运行及运维情况Form
 * </p>
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR1403Form extends BaseForm{

    /** 每页显示记录数 */
    protected int pageDispCount;
    
    /** 总记录数 */
    protected int totalCount;
    
    /** 路径 */
    protected String actionPath;

    protected int totalPage; 
    
    /** 当前页 */
    protected int nowPage;

    /**
     * 获取每页显示记录数
     * @return 每页显示记录数 
     */
    public int getPageDispCount() {
        return pageDispCount;
    }

    /**
     * 设置每页显示记录数
     * @param pageDispCount 每页显示记录数
     */
    public void setPageDispCount(int pageDispCount) {
        this.pageDispCount = pageDispCount;
    }

    /**
     * 获取总记录数
     * @return 总记录数 
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * 设置总记录数
     * @param totalCount 总记录数
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        if (this.totalCount % this.pageDispCount == 0) {
            this.totalPage = (this.totalCount / this.pageDispCount);
        } else {
            this.totalPage = (this.totalCount / this.pageDispCount + 1);
        }
    }

    /**
     * 获取路径
     * @return 路径 
     */
    public String getActionPath() {
        return actionPath;
    }

    /**
     * 设置路径
     * @param actionPath 路径
     */
    public void setActionPath(String actionPath) {
        this.actionPath = actionPath;
    }

    /**
     * 获取totalPage
     * @return totalPage 
     */
    public int getTotalPage() {
        return totalPage;
    }

    /**
     * 设置totalPage
     * @param totalPage totalPage
     */
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    /**
     * 获取当前页
     * @return 当前页 
     */
    public int getNowPage() {
        return nowPage;
    }

    /**
     * 设置当前页
     * @param nowPage 当前页
     */
    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    @Override
    public int getFromCount() {
        return this.getNowPage() * this.getPageDispCount();
    }
    
}
