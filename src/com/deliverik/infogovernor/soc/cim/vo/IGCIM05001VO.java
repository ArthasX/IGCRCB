package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;

/**
 * ����: ȫ������ͼ�֣�
 * ��������: ȫ������ͼ�֣�
 * ������¼: yanglongquan 2013/05/22
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGCIM05001VO extends BaseVO implements Serializable{
	
	/**�Ƿ񵯳�����ȫ��ͼ 1Ϊ��*/
	protected String isGoTopology;

	/**�����ʱ��*/
	protected String updatetime;
	
	/**��汾*/
	protected Integer version;
	
	/**��ID*/
	protected Integer eiddid;
	/**
	 * @return the �Ƿ񵯳�����ȫ��ͼ
	 */
	public String getIsGoTopology() {
		return isGoTopology;
	}

	/**
	 * @param �Ƿ񵯳�����ȫ��ͼ the isGoTopology to set
	 */
	public void setIsGoTopology(String isGoTopology) {
		this.isGoTopology = isGoTopology;
	}

	/**
	 * @return the �����ʱ��
	 */
	public String getUpdatetime() {
		return updatetime;
	}

	/**
	 * @param �����ʱ�� the updatetime to set
	 */
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	/**
	 * @return the ��汾
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param ��汾 the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * @return the ��ID
	 */
	public Integer getEiddid() {
		return eiddid;
	}

	/**
	 * @param ��ID the eiddid to set
	 */
	public void setEiddid(Integer eiddid) {
		this.eiddid = eiddid;
	}

	
}


