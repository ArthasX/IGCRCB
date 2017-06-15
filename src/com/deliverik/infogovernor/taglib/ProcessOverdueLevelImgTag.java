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
 * 流程逾期为未处理等级显示图片标签
 * @author Deliverik
 *
 */
public class ProcessOverdueLevelImgTag extends TagSupport{

	private static final long serialVersionUID = 1L;

	protected String prid;
	
	protected String prstatus;
	
	public int doStartTag() throws JspException {
		
	    String leveFlag = "overdue";
	    //逾期未处理的人名称
	    StringBuffer ppusernames = new StringBuffer();
	    String imghtml = "";
	    FlowSearchBL flowSearchBL = (FlowSearchBL) WebApplicationSupport.getBean("flowSearchBL");
	    try {
	    	//获取流程状态所在节点的逾期信息
	    	List<ProcessOverdueInfo> poiList = flowSearchBL.searchProcessOverdueInfo(Integer.valueOf(prid), prstatus);
	        if(!poiList.isEmpty()){
	        	for (int i = 0; i < poiList.size(); i++) {
	        		if(i != poiList.size()-1){
	        			ppusernames.append(poiList.get(i).getUsername()+"\n");
	        		}else{
	        			ppusernames.append(poiList.get(i).getUsername());
	        		}
				}
	        	//设置要显示的图片
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
	 * 根据等级标识查询显示的图片信息
	 * 暂预留功能
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
     * 流程状态获取
     * @return
     */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * 流程状态设定
	 * @param prstatus
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

}