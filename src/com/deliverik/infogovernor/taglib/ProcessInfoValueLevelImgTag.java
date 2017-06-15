package com.deliverik.infogovernor.taglib;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.TagUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * ����: ���̱�ֵתͼƬ��ʾ
 * ���������������̱�ֵת��ͼƬ��ʾ
 * ������¼��
 */
public class ProcessInfoValueLevelImgTag extends TagSupport{

	private static final long serialVersionUID = 1L;

	/** ����ID */
	protected String prid;
	
	/** ���̱����� */
	protected String pdname;
	
	public int doStartTag() throws JspException {
		
		
		String imghtml = "";
	    FlowSearchBL flowSearchBL = (FlowSearchBL) WebApplicationSupport.getBean("flowSearchBL");
	    try {
	    	
	    	CodeDetailBL codeDetailBL =  (CodeDetailBL) WebApplicationSupport.getBean("codeDetailBL");
	    	CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
	    	cond.setCcid(CodeDefine.getCodeDefine("PROCESSINFOTOIMG").getCcid());
	    	cond.setCvalue(pdname);
	    	List<CodeDetail> cdlist = codeDetailBL.searchCodeDetail(cond, 0);
	    	if(cdlist.size() > 0){
	    		String pidname = cdlist.get(0).getCdinfo();
	    		String out = flowSearchBL.searchPublicProcessInfo(Integer.valueOf(prid), pidname);
	    		imghtml = "<img align=\"middle\" src=\"images/" + out + ".gif\" alt=\"" + pidname + "\" border=\"0\" width=\"16\" height=\"16\"/>";
	    	}
        } catch (NumberFormatException e) {
            
        } catch (BLException e) {
            
        }
	    
		TagUtils.getInstance().write(pageContext, imghtml);
		return (EVAL_BODY_INCLUDE);
	}

	/**
	 * ����IDȡ��
	 * @return prid ����ID
	 */
	public String getPrid() {
		return prid;
	}

	/**
	 * ����ID�趨
	 * @param prid ����ID
	 */
	public void setPrid(String prid) {
		this.prid = prid;
	}

	/**
	 * ���̱�����ȡ��
	 * @return pdname ���̱�����
	 */
	public String getPdname() {
		return pdname;
	}

	/**
	 * ���̱������趨
	 * @param pdname ���̱�����
	 */
	public void setPdname(String pdname) {
		this.pdname = pdname;
	}
}