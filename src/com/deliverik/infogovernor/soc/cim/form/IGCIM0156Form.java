/**
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.form;


/**
 * ����: ��ض���Form
 * ��������: ��ض���Form
 * ������¼: yanglongquan 2013-10-29
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGCIM0156Form extends IGCIM0155Form{
	
	/**resource_id*/
	protected Integer resource_id;
	/**eiid*/
	protected String eiid;

	/**
	 * resource_idȡ��
	 *
	 * @return resource_id resource_id
	 */
	
	public Integer getResource_id() {
		return resource_id;
	}

	/**
	 * resource_id�趨
	 *
	 * @param resource_id resource_id
	 */
	
	public void setResource_id(Integer resource_id) {
		this.resource_id = resource_id;
	}

	/**
	 * eiidȡ��
	 * @return eiid eiid
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * eiid�趨
	 * @param eiid eiid
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

}
