/**
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.model.CR01VWInfo;

/**
 * ����: �ɼ���ѯ֮��������ϸ��ѯVO
 * ��������: �ɼ���ѯ֮��������ϸ��ѯVO
 * ������¼: yanglongquan 2013-5-31
 * �޸ļ�¼: 
 */
public class IGCIM01121VO extends BaseVO {

	private static final long serialVersionUID = -7758047756094583642L;

	/** �ɼ�������� */
	protected List<CR01VWInfo> cr01List;
	
	/**����*/
	protected String keys;
	
	/**������*/
	protected String tablename;
	
	/**��������*/
	protected String host;
	
	/**�ɼ�ʱ��*/
	protected String collecttime;

	/**
	 * �ɼ��������ȡ��
	 *
	 * @return cr01List �ɼ��������
	 */
	
	public List<CR01VWInfo> getCr01List() {
		return cr01List;
	}

	/**
	 * �ɼ���������趨
	 *
	 * @param cr01List �ɼ��������
	 */
	
	public void setCr01List(List<CR01VWInfo> cr01List) {
		this.cr01List = cr01List;
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
	
	public String getTablename() {
		return tablename;
	}

	/**
	 * �������趨
	 *
	 * @param tablename ������
	 */
	
	public void setTablename(String tablename) {
		this.tablename = tablename;
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
	
	
}
