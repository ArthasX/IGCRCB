/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;

/**
 * ����:����� 
 * ���������������
 * �����ˣ�����͢
 * ������¼�� 2013-09-02
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGSMR08011VO extends BaseVO {

	/**����Ա���˲�ѯ���*/
	protected Map<String,List<IGSMR08001VO>> map;
	
	/**���������˲�ѯ���*/
	protected List<IGSMR08001VO> list;
	
	/**���������˲�ѯ����ϼ�*/
	protected IGSMR08001VO orgsum;
	
	/**���������˲�ѯ����ϼ�*/
	protected IGSMR08001VO usersum;

	public Map<String, List<IGSMR08001VO>> getMap() {
		return map;
	}

	public void setMap(Map<String, List<IGSMR08001VO>> map) {
		this.map = map;
	}

	public List<IGSMR08001VO> getList() {
		return list;
	}

	public void setList(List<IGSMR08001VO> list) {
		this.list = list;
	}

	public IGSMR08001VO getOrgsum() {
		return orgsum;
	}

	public void setOrgsum(IGSMR08001VO orgsum) {
		this.orgsum = orgsum;
	}

	public IGSMR08001VO getUsersum() {
		return usersum;
	}

	public void setUsersum(IGSMR08001VO usersum) {
		this.usersum = usersum;
	}
	
	
}
