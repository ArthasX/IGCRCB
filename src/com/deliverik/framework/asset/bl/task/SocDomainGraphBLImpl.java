/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.asset.EiDomainKeyWords;
import com.deliverik.framework.asset.EiRelationKeyWords;
import com.deliverik.framework.asset.model.EiDomainDefInfo;
import com.deliverik.framework.asset.model.EiLinkMapInfo;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.condition.EiLinkMapSearchCondImpl;
import com.deliverik.framework.asset.model.entity.EiDomainDefPK;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
  * ����: ����ͼҵ���߼�ʵ��
  * ��������: ����ͼҵ���߼�ʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public class SocDomainGraphBLImpl extends BaseBLImpl implements
	SocDomainGraphBL {

	/** ����ͼ��·��ϢBL */
	protected EiLinkMapBL eiLinkMapBL;
	
	/** ������ϢBL */
	protected EiDomainDefBL eiDomainDefBL;
	
	/**
	 * ����ͼ��·��ϢBL�趨
	 *
	 * @param eiLinkMapBL ����ͼ��·��ϢBL
	 */
	public void setEiLinkMapBL(EiLinkMapBL eiLinkMapBL) {
		this.eiLinkMapBL = eiLinkMapBL;
	}
	
	/**
	 * ������ϢBL�趨
	 *
	 * @param eiDomainDefBL ������ϢBL
	 */
	public void setEiDomainDefBL(EiDomainDefBL eiDomainDefBL) {
		this.eiDomainDefBL = eiDomainDefBL;
	}
	
	/**
	 * ����ڵ�
	 * 
	 * @param nodeXmlStr �ڵ�XML
	 * @param eiLinkMap ��·�ϵ��ʲ�
	 * @param selEiid �������ʲ�ID
	 * @param domainid ��ID
	 * @param domainversion ��汾
	 * @param createtime ��������ʱ��
	 */
	private void drawNode(StringBuffer nodeXmlStr, EiLinkMapInfo eiLinkMap, Integer selEiid, 
			Integer domainid, Integer domainversion, String createtime) throws BLException {
		nodeXmlStr.append("<Node ");
		nodeXmlStr.append("id='");
		nodeXmlStr.append(eiLinkMap.getEiid());//�ڵ�ID
		nodeXmlStr.append("' eiid='");
		nodeXmlStr.append(eiLinkMap.getEiid());//�ʲ�ID
		nodeXmlStr.append("' name='");
		nodeXmlStr.append(TopologyGraph.filterStr(eiLinkMap.getEiname()));//�ʲ�����
		nodeXmlStr.append("' desc='");
		nodeXmlStr.append(TopologyGraph.filterStr(eiLinkMap.getEiname()));//�ʲ�����
		//����
		if(eiLinkMap.getEiid().equals(selEiid)){
			nodeXmlStr.append("' nodeColor='0x00FF00' bright='true'");
		} else {
			nodeXmlStr.append("'");
		}
		nodeXmlStr.append(" eiversion='").append(eiLinkMap.getEiversion()).append("'");
		nodeXmlStr.append(" eismallversion='").append(eiLinkMap.getEismallversion()).append("'");
		
		//���������������洢���Բ鿴��ϵ
		if(eiLinkMap.getEsyscoding().startsWith(EiRelationKeyWords.HOST) 
				|| eiLinkMap.getEsyscoding().startsWith(EiRelationKeyWords.SWITCH)
				|| eiLinkMap.getEsyscoding().startsWith(EiRelationKeyWords.STORAGE)) {
			nodeXmlStr.append(" showRelation='true'");
			nodeXmlStr.append(" domainid='").append(domainid).append("'");
			nodeXmlStr.append(" domainversion='").append(domainversion).append("'");
			nodeXmlStr.append(" createtime='").append(createtime).append("'");
		}
		nodeXmlStr.append(" nodeClass='leaf'");
		nodeXmlStr.append(" nodeIcon='");
		nodeXmlStr.append(eiLinkMap.getEsyscoding());//�ʲ�ģ�Ͳ����
		nodeXmlStr.append("'/>");
	}
	
	/**
	 * ����
	 * 
	 * @param actionXmlStr ����XML
	 * @param fromId ��ʼ�ڵ�ID
	 * @param to_id �����ڵ�ID
	 */
	private void drawLine(StringBuffer actionXmlStr, Integer fromId, Integer to_id) {
		actionXmlStr.append("<Edge ");
		actionXmlStr.append("fromID='");
		actionXmlStr.append(fromId);
		actionXmlStr.append("' toID='");
		actionXmlStr.append(to_id);
		actionXmlStr.append("'");
		actionXmlStr.append("/>");
	}
	
	/**
	 * ����ͼ��ʾ��ʼ������(Ĭ�ϼ���default��)
	 * 
	 * @param ei ѡ���ʲ���Ϣ
	 * @param domainid ��ID
	 * @param domainversion ��汾
	 * @param createtime ����ʱ��
	 * @return ��ʾ��XML
	 * @throws BLException 
	 * 
	 */
	public String initGraph(IG688Info ei, Integer domainid,
			Integer domainversion, String createtime) throws BLException {
		EiDomainDefInfo domain = null;
		//ȡĬ����ID
		if(domainid == null || domainid.intValue() == 0) {
			domainid = EiDomainKeyWords.DOOMAIN_ID_DEFAULT;
		}
		//ȡ�����汾
		if(domainversion == null || domainversion.intValue() == 0) {
			domain = this.eiDomainDefBL.searchDomainMaxVersion(domainid);
			domainversion = domain.getVersion();
			if(StringUtils.isEmpty(createtime)) {
				createtime = domain.getUpdatetime();
			}
		}
		//ȡ����ͼ��·����ʱ��
		if(StringUtils.isEmpty(createtime)) {
			domain = this.eiDomainDefBL.searchEiDomainDefByPK(new EiDomainDefPK (domainid, domainversion));
			createtime = domain.getUpdatetime();
		}
		List<EiLinkMapInfo> linkMap = this.searchLinkMap(ei, domainid, domainversion, createtime);
		return this.createXml(ei, linkMap, domainid, domainversion, createtime);
	}
	
	/**
	 * ����ͼ��·����
	 * 
	 * @param ei �ʲ���Ϣ
	 * @param domainid ��ID
	 * @param domainversion ��汾
	 * @param createtime ����ʱ��
	 * @return ��ʾ��XML
	 * @throws BLException 
	 * 
	 */
	private List<EiLinkMapInfo> searchLinkMap(IG688Info ei, Integer domainid,
			Integer domainversion, String createtime) throws BLException {
		EiLinkMapSearchCondImpl cond = new EiLinkMapSearchCondImpl();
		cond.setDomainid_eq(domainid);//��ID
		cond.setDomainversion_eq(domainversion);//��汾
		cond.setEiid_eq(ei.getEiid());//�ʲ�ID
		cond.setCreatetime_eq(createtime);//���������ʱ��
		cond.setLinkflag_eq("1");//��ͼ���
		return this.eiLinkMapBL.queryEiLinkMapList(cond);
	}
	
	/**
	 * ������ʾXML
	 * 
	 * @param ei ѡ���ʲ�
	 * @param linkMap ��·����
	 * @param domainid ��ID
	 * @param domainversion ��汾
	 * @param createtime ��������ʱ��
	 * @throws BLException 
	 */
	protected String createXml(IG688Info ei, List<EiLinkMapInfo> linkMap, 
			Integer domainid, Integer domainversion, String createtime) throws BLException {
		StringBuffer nodeXmlStr = new StringBuffer("<?xml version='1.0' encoding='utf-8'?>");
		nodeXmlStr.append("<TopologyGraph>");
		this.drawRoot(nodeXmlStr);
		this.drawGraph(linkMap, ei.getEiid(), nodeXmlStr, domainid, domainversion, createtime);
		nodeXmlStr.append("</TopologyGraph>");
		return nodeXmlStr.toString();
	}
	
	/**
	 * ������ڵ�
	 * 
	 * @param actionXmlStr �ڵ�XML
	 */
	private void drawRoot(StringBuffer nodeXmlStr) throws BLException {
		nodeXmlStr.append("<Node ");
		nodeXmlStr.append("id='1' ");
		nodeXmlStr.append("name='");
		nodeXmlStr.append("Start");
		nodeXmlStr.append("' desc='");
		nodeXmlStr.append("Start");
		nodeXmlStr.append("' showRelation='false'");
		nodeXmlStr.append(" nodeClass='earth'");
		nodeXmlStr.append(" nodeIcon='");
		nodeXmlStr.append("0");
		nodeXmlStr.append("'/>");
	}
	
	/**
	 * ������ͼ
	 * 
	 * @param linkMap ��·����
	 * @param selEiid ѡ�е��ʲ�ID
	 * @param nodeXmlStr �ڵ�XML
	 * @param domainid ��ID
	 * @param domainversion ��汾
	 * @param createtime ��������ʱ��
	 * @throws BLException
	 */
	private void drawGraph(List<EiLinkMapInfo> linkMap, Integer selEiid, StringBuffer nodeXmlStr, 
			Integer domainid, Integer domainversion, String createtime) throws BLException {
		StringBuffer actionXmlStr = new StringBuffer();
		//�����ظ����ʲ�
		Set<Integer> eiidSet = new HashSet<Integer>();
		//�����ظ�����
		Set<String> lineSet = new HashSet<String>();
		Integer fromId = 1;
		for(EiLinkMapInfo eiLinkMap : linkMap) {
			//����ʾDA��DISK
			if(eiLinkMap.getEsyscoding().startsWith(EiRelationKeyWords.DA)
					|| eiLinkMap.getEsyscoding().startsWith(EiRelationKeyWords.DISK)) {
				continue;
			}
			if(eiLinkMap.getLinkorder().intValue() == 1) {
				fromId = 1;
			}
			if(!eiidSet.contains(eiLinkMap.getEiid())) {
				//����ڵ�XML
				this.drawNode(nodeXmlStr, eiLinkMap, selEiid, domainid, domainversion, createtime);
				eiidSet.add(eiLinkMap.getEiid());
			}
			if(!lineSet.contains(fromId.toString() + "-" + eiLinkMap.getEiid().toString())) {
				//����ActionXML
				this.drawLine(actionXmlStr, fromId, eiLinkMap.getEiid());
				lineSet.add(fromId.toString() + "-" + eiLinkMap.getEiid().toString());
			}
			fromId = eiLinkMap.getEiid();
		}
		nodeXmlStr.append(actionXmlStr);
	}
	
}