/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.sdl.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.sdl.model.condition.SdlDefineInfoSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_��׼��ѯɾ��Form
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSDL0301Form extends BaseForm implements SdlDefineInfoSearchCond{

	/**���*/
	protected String sdiyear;

	/**����ʲ�ID*/
	protected Integer sdieiid;

	/**�ʲ����� */
	protected String sdieiname;
	
	/**��׼ɾ������*/
	protected String[] deleteSdlDefineInfoid;
	
	/**
	 * ��ȡ���
	 * @return ���
	 */
	public String getSdiyear() {
		return sdiyear;
	}

	/**
	 * �������
	 * @param sdiyear ���
	 */
	public void setSdiyear(String sdiyear) {
		this.sdiyear = sdiyear;
	}

	/**
	 * ��ȡ����ʲ�ID
	 * @return ����ʲ�ID
	 */
	public Integer getSdieiid() {
		if(sdieiid != null && sdieiid != 0){
			return sdieiid;
		}else{
			return null;
		}
	}

	/**
	 * ��������ʲ�ID
	 * @param sdieiid ����ʲ�ID
	 */
	public void setSdieiid(Integer sdieiid) {
		this.sdieiid = sdieiid;
	}

	/**
	 * ��ȡ����ʲ�����
	 * @return ����ʲ�����
	 */
	public String getSdieiname() {
		return sdieiname;
	}

	/**
	 * ��������ʲ�����
	 * @param sdieiname ����ʲ�����
	 */
	public void setSdieiname(String sdieiname) {
		this.sdieiname = sdieiname;
	}
	
	/**
	 * ��ȡ��׼ɾ������
	 * @return String[]
	 */
	
	public String[] getDeleteSdlDefineInfoid() {
		return deleteSdlDefineInfoid;
	}

	/**
	 * ���ñ�׼ɾ������
	 * @param deleteSdlDefineInfoid String[]
	 */
	
	public void setDeleteSdlDefineInfoid(String[] deleteSdlDefineInfoid) {
		this.deleteSdlDefineInfoid = deleteSdlDefineInfoid;
	}
	
}
