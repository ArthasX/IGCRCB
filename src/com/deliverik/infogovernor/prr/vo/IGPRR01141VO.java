/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.infogovernor.prr.model.CopyReadUserInfo;

/**
 * ����:�����˲�ѯ 
 * ���������������˲�ѯ
 * �����ˣ�����͢
 * ������¼�� 2013-02-25
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGPRR01141VO extends BaseVO {

	/**ҳ��map����*/	
	protected Map<String,List<UserRoleInfo>> map_cru;
	
	/**��ѯ���*/
	protected List<CopyReadUserInfo> list;

	private Map<String,String> detailPgMap;
	public Map<String, List<UserRoleInfo>> getMap_cru() {
		return map_cru;
	}

	public void setMap_cru(Map<String, List<UserRoleInfo>> map_cru) {
		this.map_cru = map_cru;
	}
	/**
	 * ��ѯ���ȡ��
	 * @return ��ѯ���
	 */
	public List<CopyReadUserInfo> getList() {
		return list;
	}
	/**
	 * ��ѯ����趨
	 *
	 * @param user ��ѯ���
	 */
	public void setList(List<CopyReadUserInfo> list) {
		this.list = list;
	}
	public void setDetailPgMap(Map<String,String> detailPgMap) {
		this.detailPgMap = detailPgMap;
	}

	public Map<String, String> getDetailPgMap() {
		return detailPgMap;
	}
	
}
