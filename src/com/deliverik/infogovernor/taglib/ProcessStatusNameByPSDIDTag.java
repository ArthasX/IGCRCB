package com.deliverik.infogovernor.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.TagUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.model.IG333Info;

/**
 * ����: ����״̬����id��ʾ״̬������
 * ��������������״̬����id��ʾ״̬������
 * ������¼��
 */
@SuppressWarnings("serial")
public class ProcessStatusNameByPSDIDTag extends TagSupport {

	/** ���̶���id */ 
	protected String psdid;
	
	public int doStartTag() throws JspException {
		String retHtml = "";
        IG333BL ig333BL = (IG333BL) WebApplicationSupport.getBean("ig333BL");	
        try {
            IG333Info info = ig333BL.searchIG333InfoByKey(psdid);
            retHtml = info.getPsdname();
        } catch (BLException e) {
            // TODO Auto-generated catch block
            retHtml = "";
        }
		TagUtils.getInstance().write(pageContext, retHtml);
		return (EVAL_BODY_INCLUDE);
	}

	/**
	 * �ͷ���Դ
	 */
	public void release() {
        super.release();
        psdid = null;
    }

    /** 
     * ���̶���id ȡ��
     * @return psdid ���̶���id 
     */
    public String getPsdid() {
        return psdid;
    }

    /** 
     * ���̶���id �趨
     * @param psdid ���̶���id 
     */
    public void setPsdid(String psdid) {
        this.psdid = psdid;
    }
	

}