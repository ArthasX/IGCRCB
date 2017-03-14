/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���м���ά���Form
 * </p>
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR1403Form extends BaseForm{

    /** ÿҳ��ʾ��¼�� */
    protected int pageDispCount;
    
    /** �ܼ�¼�� */
    protected int totalCount;
    
    /** ·�� */
    protected String actionPath;

    protected int totalPage; 
    
    /** ��ǰҳ */
    protected int nowPage;

    /**
     * ��ȡÿҳ��ʾ��¼��
     * @return ÿҳ��ʾ��¼�� 
     */
    public int getPageDispCount() {
        return pageDispCount;
    }

    /**
     * ����ÿҳ��ʾ��¼��
     * @param pageDispCount ÿҳ��ʾ��¼��
     */
    public void setPageDispCount(int pageDispCount) {
        this.pageDispCount = pageDispCount;
    }

    /**
     * ��ȡ�ܼ�¼��
     * @return �ܼ�¼�� 
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * �����ܼ�¼��
     * @param totalCount �ܼ�¼��
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
     * ��ȡ·��
     * @return ·�� 
     */
    public String getActionPath() {
        return actionPath;
    }

    /**
     * ����·��
     * @param actionPath ·��
     */
    public void setActionPath(String actionPath) {
        this.actionPath = actionPath;
    }

    /**
     * ��ȡtotalPage
     * @return totalPage 
     */
    public int getTotalPage() {
        return totalPage;
    }

    /**
     * ����totalPage
     * @param totalPage totalPage
     */
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    /**
     * ��ȡ��ǰҳ
     * @return ��ǰҳ 
     */
    public int getNowPage() {
        return nowPage;
    }

    /**
     * ���õ�ǰҳ
     * @param nowPage ��ǰҳ
     */
    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    @Override
    public int getFromCount() {
        return this.getNowPage() * this.getPageDispCount();
    }
    
}
