/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.asset.model.condition.EiDomainDetailSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��Ȩ����_��ɫ��ȨForm
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGASM2004Form extends BaseForm implements EiDomainDetailSearchCond{
	
	/**�ʲ���ID**/
	private Integer eiddid;
	
	/**�ʲ���汾**/
	private Integer eiddversion;
	
	/**
	 * ����ӵ����ʲ�
	 */
	protected String[] owneiddids;
	
	/**
	 * δ��ӵ����ʲ�
	 */
	protected String[] eiddids;
	
	/**
	 * ����ʽ1-ɾ����0-���
	 */
	protected String mode;
	
	/** �߼�ɾ����ʶ */
	private String deleteflag;
	
	protected String updatetime;
	
	/**��ȡ�ʲ���ID**/
	public Integer getEiddid() {
		return eiddid;
	}	
	/**
	 * �ʲ���ID�趨
	 * @param eiddid�ʲ���ID
	 */
	public void setEiddid(Integer eiddid) {
		this.eiddid = eiddid;
	}
	/**��ȡ�ʲ���汾**/
	public Integer getEiddversion() {
		return eiddversion;
	}
	/**
	 * �ʲ���汾�趨
	 * @param eiddversion�ʲ���汾
	 */
	public void setEiddversion(Integer eiddversion) {
		this.eiddversion = eiddversion;
	}	
	/**
	 * ����Form
	 * @param mapping ActionMapping
	 * @param request HttpServletRequest
	 */
	
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
		this.owneiddids = null;
		this.eiddids = null;
	}
	
	/**
	 * ��ȡ����ʽ1-ɾ����0-���
	 * @return String[]
	 */
	
	public String getMode() {
		return mode;
	}

	/**
	 * ���ô���ʽ1-ɾ����0-���
	 * @param mode String
	 */
	
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	/**
	 * ����ӵ����ʲ�ȡ��
	 * @return ����ӵ����ʲ�
	 */
	public String[] getOwneiddids() {
		return owneiddids;
	}
	/**
	 * ����ӵ����ʲ��趨
	 * @param owneiddids����ӵ����ʲ�
	 */
	public void setOwneiddids(String[] owneiddids) {
		this.owneiddids = owneiddids;
	}
	/**
	 * δ��ӵ����ʲ�ȡ��
	 * @return δ��ӵ����ʲ�
	 */
	public String[] getEiddids() {
		return eiddids;
	}
	/**
	 * δ��ӵ����ʲ��趨
	 * @param eiddidsδ��ӵ����ʲ�
	 */
	public void setEiddids(String[] eiddids) {
		this.eiddids = eiddids;
	}
	/**
	 * �߼�ɾ����ʶȡ��
	 */
	public String getDeleteflag() {
		return deleteflag;
	}
	/**
	 * �߼�ɾ����ʶ�趨
	 * @param deleteflag�߼�ɾ����ʶ
	 */
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
}
