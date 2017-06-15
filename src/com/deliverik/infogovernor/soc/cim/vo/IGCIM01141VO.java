/**
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.model.CR01VWInfo;

/**
 * ����: �ɼ���ѯ������ϸ�Ա�VO
 * ��������: �ɼ���ѯ������ϸ�Ա�VO
 * ������¼: zhangnan 2013-6-6
 * �޸ļ�¼: 
 */
public class IGCIM01141VO extends BaseVO {

	private static final long serialVersionUID = -7758047756094583642L;

	/** �ɼ�������ϰ汾1 */
	protected List<CR01VWInfo> cr01List1;
	
	/** �ɼ�������ϰ汾2 */
	protected List<CR01VWInfo> cr01List2;
	
	/**����*/
	protected String keys;
	
	/**������*/
	protected String tablenames;
	
	/**��������*/
	protected String host;
	
	/**�ɼ�ʱ��*/
	protected String collecttime;
	
	/** �汾����1 */
	protected String collecttime1;
	
	/** �汾����2 */
	protected String collecttime2;

	/**
	 * �ɼ��������ȡ��
	 *
	 * @return cr01List �ɼ��������
	 */
	
	public List<CR01VWInfo> getCr01List1() {
		return cr01List1;
	}

	/**
	 * �ɼ���������趨
	 *
	 * @param cr01List �ɼ��������
	 */
	
	public void setCr01List1(List<CR01VWInfo> cr01List1) {
		this.cr01List1 = cr01List1;
	}

	/**
	 * ����ȡ��
	 *
	 * @return keys ����
	 */
	
	public String getKeys() {
		return keys;
	}

	/**
	 * �����趨
	 *
	 * @param keys ����
	 */
	
	public void setKeys(String keys) {
		this.keys = keys;
	}

	/**
	 * ������ȡ��
	 *
	 * @return tablename ������
	 */
	
	public String getTablenames() {
		return tablenames;
	}

	/**
	 * �������趨
	 *
	 * @param tablename ������
	 */
	
	public void setTablenames(String tablenames) {
		this.tablenames = tablenames;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return host ��������
	 */
	
	public String getHost() {
		return host;
	}

	/**
	 * ���������趨
	 *
	 * @param host ��������
	 */
	
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * �ɼ�ʱ��ȡ��
	 *
	 * @return collecttime �ɼ�ʱ��
	 */
	
	public String getCollecttime() {
		return collecttime;
	}

	/**
	 * �ɼ�ʱ���趨
	 *
	 * @param collecttime �ɼ�ʱ��
	 */
	
	public void setCollecttime(String collecttime) {
		this.collecttime = collecttime;
	}

	public List<CR01VWInfo> getCr01List2() {
		return cr01List2;
	}

	public void setCr01List2(List<CR01VWInfo> cr01List2) {
		this.cr01List2 = cr01List2;
	}

	public String getCollecttime1() {
		return collecttime1;
	}

	public void setCollecttime1(String collecttime1) {
		this.collecttime1 = collecttime1;
	}

	public String getCollecttime2() {
		return collecttime2;
	}

	public void setCollecttime2(String collecttime2) {
		this.collecttime2 = collecttime2;
	}
	
	
}
