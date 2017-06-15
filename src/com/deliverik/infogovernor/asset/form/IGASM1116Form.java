package com.deliverik.infogovernor.asset.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts.upload.FormFile;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0606SearchCond;

/**
 * �豸������ϸ����FORM
 * 
 */
public class IGASM1116Form extends BaseForm implements SOC0606SearchCond{

	private static final long serialVersionUID = 1L;

	/** �豸ID */
	protected String eiid;
	
	/** �豸���ð汾 */
	protected String civersion;
	
	/** ϵͳ����ID */
	protected String[] ciid;
	
	/** �ʲ�����ID */
	protected String[] cid;

	/** �ʲ����ñ�� */
	protected String[] clabel;

	/** ϵͳ����ֵ */
	protected String[] civalue;
	
	/** ϵͳ���ø��� */
	protected String[] ciattach;
	
	/** ϵͳ���ø������� */
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
	
	/** ȡֵ��Χ�������� */
	protected Map<Integer, List<LabelValueBean>> selectedListMap = new HashMap<Integer, List<LabelValueBean>>();
	
	/** ģ�Ͳ���� */
	protected String esyscoding_q;
	
	public String[] getCiid() {
		return ciid;
	}


	public void setCiid(String[] ciid) {
		this.ciid = ciid;
	}


	public String[] getCid() {
		return cid;
	}


	public void setCid(String[] cid) {
		this.cid = cid;
	}


	public String[] getClabel() {
		return clabel;
	}


	public void setClabel(String[] clabel) {
		this.clabel = clabel;
	}


	public String[] getCivalue() {
		return civalue;
	}


	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}


	public String[] getCiattach() {
		return ciattach;
	}


	public void setCiattach(String[] ciattach) {
		this.ciattach = ciattach;
	}


	/**
	 * ȡֵ��Χ��������ȡ��
	 * @return ȡֵ��Χ��������
	 */
	public List<LabelValueBean> getSelectedListMap(int index) {
		return (List<LabelValueBean>) selectedListMap.get( new Integer( index ) );
	}

	/**
	 * ȡֵ��Χ���������趨
	 *
	 * @param selectedList ȡֵ��Χ��������
	 */
	public void setSelectedListMap(int index,List<LabelValueBean> selectedList) {
		selectedListMap.put(new Integer(index), selectedList);
	}

	/**
	 * ȡֵ��Χ��������ȡ��
	 * @return ȡֵ��Χ��������
	 */
	public Map<Integer, List<LabelValueBean>> getSelectedListMap() {
		return selectedListMap;
	}


	/**
	 * �豸IDȡ��
	 * @return �ʲ���ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * �豸ID�趨
	 *
	 * @param eiid �豸ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}
	
	/**
	 * �豸���ð汾ȡ��
	 * @return �豸���ð汾
	 */
	public String getCiversion() {
		return civersion;
	}

	/**
	 * �豸���ð汾�趨
	 *
	 * @param civersion �豸���ð汾
	 */
	public void setCiversion(String civersion) {
		this.civersion = civersion;
	}


	public String getCname() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getEsyscoding_q() {
		return esyscoding_q;
	}


	public void setEsyscoding_q(String esyscoding_q) {
		this.esyscoding_q = esyscoding_q;
	}


	public String getClabel_q() {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Integer> getEiid_list() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getSreilabel_q() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getSrname_q() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getEid_q() {
		// TODO Auto-generated method stub
		return null;
	}
}
