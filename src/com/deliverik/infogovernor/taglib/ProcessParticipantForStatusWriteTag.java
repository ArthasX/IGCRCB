/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.taglib;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.taglib.TagUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.prr.bl.task.IG337BL;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;

/**
 * ����: ���̵�ǰ�����˱�ǩ
 * ������������������id��״̬ȡ�õ�ǰ������
 * ������¼��
 */
public class ProcessParticipantForStatusWriteTag extends TagSupport{

	private static final long serialVersionUID = 1L;
	

	private static IG337BL ig337BL = (IG337BL) WebApplicationSupport.getBean("ig337BL");
	private static IG500BL ig500BL = (IG500BL) WebApplicationSupport.getBean("ig500BL");

	/** ����id */
	protected String prid;
	
	/** ����״̬ */
	protected String prstatus;
	
	// ���̵��˴����˻��棬Key: prid_prstatus
//	protected static HashMap<String, StringBuffer> processParticipantsMap = new HashMap<String, StringBuffer>();
	
	public int doStartTag() throws JspException {
		
		// �����˻���Key
//		String mapKey = this.getPrid() + "_" + this.getPrstatus();
		// �ӻ����ȡ��������Ϣ
//		StringBuffer processParticipants =  processParticipantsMap.get(mapKey);
		
		// �����������Ϣ�ڻ��治����
//		if(null == processParticipants){
			StringBuffer processParticipants = new StringBuffer();
			List<String> lst_Status = null;
			try {
				lst_Status = ig500BL.searchCurrentStatus(new Integer(prid));
			} catch (BLException e) {
				lst_Status = new ArrayList<String>();
			}
		    IG337SearchCondImpl cond337 = new IG337SearchCondImpl();
			cond337.setPrid(new Integer(prid));
			List<IG337Info> list_337 =  new ArrayList<IG337Info>();
			for(String status : lst_Status) {
				cond337.setPpstatus_q(status);
				// ��ѯ��������Ϣ
				list_337.addAll(ig337BL.getIG337Infos(cond337));
			}
			if(list_337.size() > 0){
				for(int i = 0; i < list_337.size(); i++){
					IG337Info info = list_337.get(i);
					if(StringUtils.isEmpty(info.getPpusername())){
						if(processParticipants.indexOf("δָ��") == -1) {
							processParticipants.append("δָ����");
						}
						continue;
					}
					processParticipants.append(info.getPpusername());
					if(i < list_337.size() - 1){
						processParticipants.append("��");
					}
				}
			} else {
				processParticipants.append("");
			}
			
//			processParticipantsMap.put(mapKey, processParticipants);
//		}
	    if(processParticipants.toString().endsWith("��")) {
	    	TagUtils.getInstance().write(pageContext,  processParticipants.substring(0, processParticipants.length()-1).toString());
	    } else {
	    	TagUtils.getInstance().write(pageContext,  processParticipants.toString());
	    }
		processParticipants = null;
		cond337 = null;
		list_337 = null;
		return (EVAL_BODY_INCLUDE);
	}

	
	/**
	 * �ͷ���Դ
	 */
	public void release() {
        super.release();
        this.prid = null;
        this.prstatus = null;
    }
	
	/**
	 * ����idȡ��
	 * @return prid ����id
	 */
	public String getPrid() {
		return prid;
	}

	/**
	 * ����id�趨
	 * @param prid ����id
	 */
	public void setPrid(String prid) {
		this.prid = prid;
	}

	/**
	 * ����״̬ȡ��
	 * @return prstatus ����״̬
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * ����״̬�趨
	 * @param prstatus ����״̬
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

}