/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.taglib;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.taglib.TagUtils;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.infogovernor.smr.bl.IGSMRCONSTANT;
import com.deliverik.infogovernor.smr.bl.task.ApproveSuggestionBL;
import com.deliverik.infogovernor.smr.model.ApproveSuggestionInfo;
import com.deliverik.infogovernor.smr.model.condition.ApproveSuggestionSearchCondImpl;

/**
 * ����:��������Զ����ǩ 
 * ������������������Զ����ǩ
 * �����ˣ�����͢
 * ������¼�� 2013-08-02
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class ProcessExamineIdeaTag extends TagSupport {
	
	public final static String IMG_DEAD ="<img src='images/deldata.png' alt='�鿴�������' width='16' height='16' border='0' style='cursor: hand;' " ;	
	public final static String IMG_DEAD_WRITE_0 ="<img src='images/modify.png' alt='��д�������' width='16' height='16' border='0' style='cursor: hand;' " ;	
	public final static String IMG_DEAD_WRITE_1 ="<img src='images/deldata.png' alt='��д�������' width='16' height='16' border='0' style='cursor: hand;' " ;	
	// ����id
	protected Integer prid; 
	
	// ��id
	protected String pidid;
	
	/** ����״̬���� */
	protected String psdname;
	
	/** ���������ʾ��ʶ */
	protected String needidea;
	
	/** ���ʽ����ʶ */
	protected String tableFlag;

	public int doStartTag() throws JspException {		
		String retHtml = "";
		try{
			retHtml = getRetHtml(prid,pidid,psdname,needidea,tableFlag);
		}catch (Exception e) {
			return (SKIP_BODY);
		}
		TagUtils.getInstance().write(pageContext, retHtml);
		return (EVAL_BODY_INCLUDE);
	}
	
	public static String getRetHtml(Integer prid,String pidid,String psdname,String needidea,String tableFlag){
		String retHtml = "";
		if(StringUtils.isEmpty(tableFlag)){
			tableFlag = "N";
		}
		if(IGSMRCONSTANT.HASH_APPROVE_IDEA_YES.equals(needidea)){
			if(IGSMRCONSTANT.PRSTATUSNAME_REPORT.equals(psdname)){
				if(isExist(prid,pidid)){
					retHtml =IMG_DEAD+"onclick='goIGSMR0202(\""+prid+"\",\""+pidid+"\",this,\"" + tableFlag + "\")'/>";
				}
			}else if(IGSMRCONSTANT.PRSTATUSNAME_FIRSTEXAMINE.equals(psdname) || IGSMRCONSTANT.PRSTATUSNAME_SECONDEXAMINE.equals(psdname)){
				if(isExist(prid,pidid)){
					retHtml =IMG_DEAD_WRITE_1+"onclick='goIGSMR0201(\""+prid+"\",\""+pidid+"\",this,\"" + tableFlag + "\")'/>";
				}else{
					retHtml =IMG_DEAD_WRITE_0+"onclick='goIGSMR0201(\""+prid+"\",\""+pidid+"\",this,\"" + tableFlag + "\")'/>";
				}
			}
		}
		return retHtml;
	}

	private static boolean isExist(Integer prid,String pidid){
		ApproveSuggestionBL approveSuggestionBL = (ApproveSuggestionBL) WebApplicationSupport.getBean("approveSuggestionBL");
		//ʵ������ѯ����
		ApproveSuggestionSearchCondImpl cond = new ApproveSuggestionSearchCondImpl();
		cond.setPrid_eq(prid);
		cond.setPidid_eq(pidid);
	    cond.setStatus_eq(IGSMRCONSTANT.APPROVE_STATUS_YES);//��Ч
		//��ѯ�Ƿ����
		List<ApproveSuggestionInfo> list_as = approveSuggestionBL.searchApproveSuggestionInfo(cond);
		if(list_as.isEmpty()){
			return false;
		}
		return true;
	}

	public Integer getPrid() {
		return prid;
	}

	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	
	public String getPidid() {
		return pidid;
	}

	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * ����״̬����ȡ��
	 * @return psdname ����״̬����
	 */
	public String getPsdname() {
		return psdname;
	}

	/**
	 * ����״̬�����趨
	 * @param psdname ����״̬����
	 */
	public void setPsdname(String psdname) {
		this.psdname = psdname;
	}

	/**
	 * ���������ʾ��ʶȡ��
	 * @return needidea ���������ʾ��ʶ
	 */
	public String getNeedidea() {
		return needidea;
	}

	/**
	 * ���������ʾ��ʶ�趨
	 * @param needidea ���������ʾ��ʶ
	 */
	public void setNeedidea(String needidea) {
		this.needidea = needidea;
	}

	/**
	 * ���ʽ����ʶȡ��
	 * @return tableFlag ���ʽ����ʶ
	 */
	public String getTableFlag() {
		return tableFlag;
	}

	/**
	 * ���ʽ����ʶ�趨
	 * @param tableFlag ���ʽ����ʶ
	 */
	public void setTableFlag(String tableFlag) {
		this.tableFlag = tableFlag;
	}

	/**
	 * �ͷ���Դ
	 */
	public void release() {
        super.release();
        this.pidid = null;
        this.prid = null;
        this.needidea = null;
        this.psdname = null;
        this.tableFlag = null;
    }
}
