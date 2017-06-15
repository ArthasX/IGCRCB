package com.deliverik.infogovernor.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts.upload.FormFile;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.model.condition.IG800SearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * ������������ϸ����FORM
 * 
 */
public class IGCOM0303Form extends BaseForm implements IG800SearchCond{

	private static final long serialVersionUID = 1L;

	/** ������ID */
	protected Integer eiid;
	
	/** ���������ð汾 */
	protected String civersion;
	/** �豸���ø������� */
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
	
	/** ȡֵ��Χ�������� */
	protected Map<Integer, List<LabelValueBean>> selectedListMap = new HashMap<Integer, List<LabelValueBean>>();
	
	
	/** �ʲ�����С�汾��*/
	protected String cismallversion;
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
	 * ������IDȡ��
	 * @return ������ID
	 */
	public Integer getEiid() {
		return eiid;
	}


	/**
	 * ������ID�趨
	 *
	 * @param eiid ������ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * ���������ð汾ȡ��
	 * @return ���������ð汾
	 */
	public String getCiversion() {
		return civersion;
	}


	/**
	 * ���������ð汾�趨
	 *
	 * @param civersion ���������ð汾
	 */
	public void setCiversion(String civersion) {
		this.civersion = civersion;
	}

	public Integer getCid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCivalue() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * �ʲ�����С�汾��ȡ��
	 * @return �ʲ�����С�汾��
	 */
	public String getCismallversion() {
		return cismallversion;
	}
	/**
	 * �ʲ�����С�汾���趨
	 *
	 * @param cismallversion �ʲ�����С�汾��
	 */
	public void setCismallversion(String cismallversion) {
		this.cismallversion = cismallversion;
	}
}
