package com.deliverik.infogovernor.taglib;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.TagUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.resultset.ProcessOverdueInfo;
import com.deliverik.framework.platform.WebApplicationSupport;

/**
 * ��������Ϊδ����ȼ���ʾͼƬ��ǩ
 * @author Deliverik
 *
 */
public class ProcessOverdueLevelImgTag extends TagSupport{

	private static final long serialVersionUID = 1L;

	protected String prid;
	
	protected String prstatus;
	
	public int doStartTag() throws JspException {
		
	    String leveFlag = "overdue";
	    //����δ�����������
	    StringBuffer ppusernames = new StringBuffer();
	    String imghtml = "";
	    FlowSearchBL flowSearchBL = (FlowSearchBL) WebApplicationSupport.getBean("flowSearchBL");
	    try {
	    	//��ȡ����״̬���ڽڵ��������Ϣ
	    	List<ProcessOverdueInfo> poiList = flowSearchBL.searchProcessOverdueInfo(Integer.valueOf(prid), prstatus);
	        if(!poiList.isEmpty()){
	        	for (int i = 0; i < poiList.size(); i++) {
	        		if(i != poiList.size()-1){
	        			ppusernames.append(poiList.get(i).getUsername()+"\n");
	        		}else{
	        			ppusernames.append(poiList.get(i).getUsername());
	        		}
				}
	        	//����Ҫ��ʾ��ͼƬ
	        	imghtml = "<img align=\"middle\" src=\"images/" + getLeveImageName(leveFlag) + ".gif\" alt=\"" + ppusernames.toString() + "\" border=\"0\" width=\"16\" height=\"16\"/>";
	        }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (BLException e) {
            e.printStackTrace();
        }
		TagUtils.getInstance().write(pageContext, imghtml);
		return (EVAL_BODY_INCLUDE);
	}

	/**
	 * ���ݵȼ���ʶ��ѯ��ʾ��ͼƬ��Ϣ
	 * ��Ԥ������
	 * @param leveFlag
	 * @return
	 */
	private String getLeveImageName(String leveFlag) {
		return leveFlag;
	}
	
    /**
     * @return the prid
     */
    public String getPrid() {
        return prid;
    }

    /**
     * @param prid the prid to set
     */
    public void setPrid(String prid) {
        this.prid = prid;
    }

    /**
     * ����״̬��ȡ
     * @return
     */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * ����״̬�趨
	 * @param prstatus
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

}