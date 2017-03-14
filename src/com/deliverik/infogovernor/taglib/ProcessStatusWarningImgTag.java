package com.deliverik.infogovernor.taglib;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.TagUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.prd.bl.task.IG105BL;
import com.deliverik.framework.workflow.prd.model.IG105Info;
import com.deliverik.framework.workflow.prd.model.entity.IG105PK;
import com.deliverik.framework.workflow.prr.bl.task.IG224BL;
import com.deliverik.framework.workflow.prr.model.IG224Info;

/**
 * ����: ���̽ڵ㳬ʱ��ǩ
 * �����������ж����̽ڵ������Ƿ�ʱ
 * ������¼��
 * �޸ļ�¼���κ���  2010/12/01
 */
@SuppressWarnings("serial")
public class ProcessStatusWarningImgTag extends TagSupport {
	// ����
	public final static String IMG_DEAD = "<img src=\"images/statuswarning.gif\" alt=\"����ʱ\" border=\"0\" width=\"16\" height=\"16\"/>";

	// ��������
	protected String processType;
	// ���԰汾
	protected Integer prStrategyVersion; 
	// ������
	protected String prUrgency; 
	// ���̶�������
	protected String prPdid; 
	
	// ����״̬
	protected String prStatus; 
	
	// ����id
	protected Integer prid; 
	
	public int doStartTag() throws JspException {
		String retHtml = "";
	
			
			try {
				if(checkTimeOut()){
				
					return (SKIP_BODY);
				}else{
					retHtml = IMG_DEAD;
				}
			} catch (Exception e) {

				return (SKIP_BODY);
			}
		
		TagUtils.getInstance().write(pageContext, retHtml);
		return (EVAL_BODY_INCLUDE);
	}
	/**
	 * �ж������ڵ�ǰ״̬�Ƿ�ʱ
	 * @param list
	 * @return
	 * @throws BLException
	 */
	public boolean checkTimeOut() throws BLException {
		boolean isAlive = true;
		IG105BL ig105BL = (IG105BL) WebApplicationSupport
				.getBean("ig105BL");
		IG224BL ig224BL = (IG224BL) WebApplicationSupport
				.getBean("ig224BL");

		// �ж��Ƿ���������趨,�Ƿ�ʱ
		IG105PK pk = new IG105PK();
		// ���̶�������
		pk.setPdid(prPdid);
		// ���԰汾��
		pk.setPsdversion(prStrategyVersion);
		// ���̽�����
		pk.setPrurgency(prUrgency);
		// ����״̬
		pk.setPrstatus(prStatus);

		IG105Info psd = ig105BL
				.searchIG105InfoByKey(pk);

		if (psd != null) {
	
			//ȡ��״̬�Ŀ�ʼʱ��
			IG224Info recordStatusLog = ig224BL
					.searchCurrentIG224Info(prid, null).get(0);
			Date starttime = recordStatusLog.getRslOpenTime();
			Date endtime = recordStatusLog.getRslCloseTime();
			
			Double excepttime = psd.getExpecttime() * 60;
            if(endtime !=null && endtime.getTime()>0){//�Ѿ������Ľڵ�
            
    			if ((endtime.getTime() - starttime.getTime()) > excepttime.intValue() * 60000) {
    				isAlive = false;
    			}
            }else{//δ�����Ľڵ�
            	Calendar calendar = Calendar.getInstance();
    			calendar.getTime();
    			
    			// ��ǰʱ�� - Ԥ��ʱ�� -��ʼʱ�� >0 ��ڵ� ��ʱ
    			calendar.add(Calendar.MINUTE, 0 - excepttime.intValue());
    			if ((calendar.getTimeInMillis() - starttime.getTime()) > 0) {
    				isAlive = false;
    			}
            }
		}
		return isAlive;
	}
	

	public String getPrStatus() {
		return prStatus;
	}
	public void setPrStatus(String prStatus) {
		this.prStatus = prStatus;
	}
	public Integer getPrid() {
		return prid;
	}
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	public String getProcessType() {
		return processType;
	}

	public void setProcessType(String processType) {
		this.processType = processType;
	}

	public Integer getPrStrategyVersion() {
		return prStrategyVersion;
	}

	public void setPrStrategyVersion(Integer prStrategyVersion) {
		this.prStrategyVersion = prStrategyVersion;
	}

	public String getPrPdid() {
		return prPdid;
	}

	public void setPrPdid(String prPdid) {
		this.prPdid = prPdid;
	}

	public void setPrUrgency(String prUrgency) {
		this.prUrgency = prUrgency;
	}

	public String getPrUrgency() {
		return prUrgency;
	}
	/**
	 * �ͷ���Դ
	 */
	public void release() {
        super.release();
        processType = null;
        prStrategyVersion = null;
        prUrgency = null;
        prPdid = null;
        prStatus = null;
        prid = null;
    }
	

}