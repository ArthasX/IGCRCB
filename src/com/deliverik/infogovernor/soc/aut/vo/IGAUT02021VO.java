/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.soc.aut.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_�������_��ѯVO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGAUT02021VO extends BaseVO implements Serializable {
	
	public IGAUT02021VO(){}
	public IGAUT02021VO(List<SOC0124Info> entityItemVWInfoList){
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	protected List<SOC0124Info> entityItemVWInfoList;

	/** ��ID */
	protected Integer domainid;
	
	/** ��汾 */
	protected Integer domainversion;
	/** ��������ʱ�� */
	protected String createtime;
	
	/** �Ƿ���ʾ�߼���ϵMAP */
	protected Map<String,String> showRelationMap;
	
	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}
	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}
	public Integer getDomainid() {
		return domainid;
	}
	public void setDomainid(Integer domainid) {
		this.domainid = domainid;
	}
	public Integer getDomainversion() {
		return domainversion;
	}
	public void setDomainversion(Integer domainversion) {
		this.domainversion = domainversion;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public Map<String, String> getShowRelationMap() {
		return showRelationMap;
	}
	public void setShowRelationMap(Map<String, String> showRelationMap) {
		this.showRelationMap = showRelationMap;
	}
	
	
	
}
