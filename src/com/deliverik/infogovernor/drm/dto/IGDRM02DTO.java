package com.deliverik.infogovernor.drm.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.infogovernor.drm.form.IGDRM0201Form;


/**
 * ��ϳ�������������DTO
 * 
 */
@SuppressWarnings("serial")
public class IGDRM02DTO extends BaseDTO implements Serializable{

	/** �ʲ��������� */
	protected List<SOC0124Info> soc0124List;
	
	/** ѡ����ʲ�eiid */
	private String[] addEiids ;
	
	/** ��ϳ������� */
	private String pgdid;
	
	/** ��ϳ���form */
	protected IGDRM0201Form igdrm0201Form ;
	
	/** flex��������xml*/
	private String  XmlValue ;
	
	/** ����ʵ������ */
	private Integer prid ;
	
	/** ��������idƴ�� */
	private String flowIdStr;
	
	/** ״̬��flag*/
	private String flag;
	
	/** ��������pdid */
	private String pdidStr;

	/** �����޶���ʶ */
	private String isUpdate;
	
	/** ԭpgdid */
	protected String oldpdid;
	/**
	 * @return the �����޶���ʶ
	 */
	public String getIsUpdate() {
		return isUpdate;
	}

	/**
	 * @param �����޶���ʶ the isUpdate to set
	 */
	public void setIsUpdate(String isUpdate) {
		this.isUpdate = isUpdate;
	}

	/**
	 * @return the �ʲ���������
	 */
	public List<SOC0124Info> getSoc0124List() {
		return soc0124List;
	}

	/**
	 * @param �ʲ��������� the soc0124List to set
	 */
	public void setSoc0124List(List<SOC0124Info> soc0124List) {
		this.soc0124List = soc0124List;
	}

	/**
	 * @return the ѡ����ʲ�eiid
	 */
	public String[] getAddEiids() {
		return addEiids;
	}

	/**
	 * @param ѡ����ʲ�eiid the addEiids to set
	 */
	public void setAddEiids(String[] addEiids) {
		this.addEiids = addEiids;
	}

	/**
	 * @return the ��ϳ�������
	 */
	public String getPgdid() {
		return pgdid;
	}

	/**
	 * @param ��ϳ������� the pgdid to set
	 */
	public void setPgdid(String pgdid) {
		this.pgdid = pgdid;
	}

	/**
	 * @return the ��ϳ���form
	 */
	public IGDRM0201Form getIgdrm0201Form() {
		return igdrm0201Form;
	}

	/**
	 * @param ��ϳ���form the igdrm0201Form to set
	 */
	public void setIgdrm0201Form(IGDRM0201Form igdrm0201Form) {
		this.igdrm0201Form = igdrm0201Form;
	}

	/**
	 * @return the xmlValue
	 */
	public String getXmlValue() {
		return XmlValue;
	}

	/**
	 * @param xmlValue the xmlValue to set
	 */
	public void setXmlValue(String xmlValue) {
		XmlValue = xmlValue;
	}

	/**
	 * @return the ����ʵ������
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * @param ����ʵ������ the prid to set
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * @return the ��������idƴ��
	 */
	public String getFlowIdStr() {
		return flowIdStr;
	}

	/**
	 * @param ��������idƴ�� the flowIdStr to set
	 */
	public void setFlowIdStr(String flowIdStr) {
		this.flowIdStr = flowIdStr;
	}

	/**
	 * @return the ״̬��flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * @param ״̬��flag the ״̬��flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * @return the ��������pdid
	 */
	public String getPdidStr() {
		return pdidStr;
	}

	/**
	 * @param ��������pdid the pdidStr to set
	 */
	public void setPdidStr(String pdidStr) {
		this.pdidStr = pdidStr;
	}

	/**
	 * @return the ԭpgdid
	 */
	public String getOldpdid() {
		return oldpdid;
	}

	/**
	 * @param ԭpgdid the oldpdid to set
	 */
	public void setOldpdid(String oldpdid) {
		this.oldpdid = oldpdid;
	}
	
	
}