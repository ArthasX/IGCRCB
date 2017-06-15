/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.EiDomainKeyWords;
import com.deliverik.framework.soc.asset.EiRelationKeyWords;
import com.deliverik.framework.soc.asset.model.SOC0111Info;
import com.deliverik.framework.soc.asset.model.SOC0114Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0114SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0111PK;

/**
  * ����: Ӱ�����ͼҵ���߼�ʵ��
  * ��������: Ӱ�����ͼҵ���߼�ʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 2011/08/22  ���Ϸ�������ͼ�㷨�޸� searchImpactCI()
  */
public class SocImpactGraphBLImpl extends BaseBLImpl implements
	SocImpactGraphBL {

	/** Ӱ�����ͼ��·��ϢBL */
	protected SOC0114BL soc0114BL;
	
	/** ������ϢBL */
	protected SOC0111BL soc0111BL;
	
	/**�ʲ�ʵ����ϢBL */
	protected SOC0118BL soc0118BL;
	
	
	public void setSoc0114BL(SOC0114BL soc0114BL) {
		this.soc0114BL = soc0114BL;
	}

	public void setSoc0111BL(SOC0111BL soc0111BL) {
		this.soc0111BL = soc0111BL;
	}

	public void setSoc0118BL(SOC0118BL soc0118BL) {
		this.soc0118BL = soc0118BL;
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
	private void drawNode(StringBuffer nodeXmlStr, SOC0114Info eiLinkMap, Integer selEiid, 
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
	 * Ӱ�����ͼ��ʾ��ʼ������(Ĭ�ϼ���default��)
	 * 
	 * @param ei ѡ���ʲ���Ϣ
	 * @param domainid ��ID
	 * @param domainversion ��汾
	 * @param createtime ����ʱ��
	 * @return ��ʾ��XML
	 * @throws BLException 
	 * 
	 */
	public String initGraph(SOC0124Info ei, Integer domainid,
			Integer domainversion, String createtime) throws BLException {
		SOC0111Info domain = null;
		//ȡĬ����ID
		if(domainid == null || domainid.intValue() == 0) {
			domainid = EiDomainKeyWords.DOOMAIN_ID_DEFAULT;
		}
		//ȡ�����汾
		if(domainversion == null || domainversion.intValue() == 0) {
			domain = this.soc0111BL.searchDomainMaxVersion(domainid);
			domainversion = domain.getVersion();
			if(StringUtils.isEmpty(createtime)) {
				createtime = domain.getUpdatetime();
			}
		}
		//ȡӰ�����ͼ��·����ʱ��
		if(StringUtils.isEmpty(createtime)) {
			domain = this.soc0111BL.searchEiDomainDefByPK(new SOC0111PK (domainid, domainversion));
			createtime = domain.getUpdatetime();
		}
		List<SOC0114Info> linkMap = this.searchLinkMap(ei, domainid, domainversion, createtime);
		return this.createXml(ei, linkMap, domainid, domainversion, createtime);
	}
	
	/**
	 * Ӱ�����ͼ��·����
	 * 
	 * @param ei �ʲ���Ϣ
	 * @param domainid ��ID
	 * @param domainversion ��汾
	 * @param createtime ����ʱ��
	 * @return ��ʾ��XML
	 * @throws BLException 
	 * 
	 */
	private List<SOC0114Info> searchLinkMap(SOC0124Info ei, Integer domainid,
			Integer domainversion, String createtime) throws BLException {
		SOC0114SearchCondImpl cond = new SOC0114SearchCondImpl();
		cond.setDomainid_eq(domainid);//��ID
		cond.setDomainversion_eq(domainversion);//��汾
		cond.setEiid_eq(ei.getEiid());//�ʲ�ID
		cond.setCreatetime_eq(createtime);//���������ʱ��
		cond.setLinkflag_eq("1");//��ͼ���
		return this.soc0114BL.queryEiLinkMapList(cond);
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
	protected String createXml(SOC0124Info ei, List<SOC0114Info> linkMap, 
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
	 * ��Ӱ�����ͼ
	 * 
	 * @param linkMap ��·����
	 * @param selEiid ѡ�е��ʲ�ID
	 * @param nodeXmlStr �ڵ�XML
	 * @param domainid ��ID
	 * @param domainversion ��汾
	 * @param createtime ��������ʱ��
	 * @throws BLException
	 */
	private void drawGraph(List<SOC0114Info> linkMap, Integer selEiid, StringBuffer nodeXmlStr, 
			Integer domainid, Integer domainversion, String createtime) throws BLException {
		StringBuffer actionXmlStr = new StringBuffer();
		//�����ظ����ʲ�
		Set<Integer> eiidSet = new HashSet<Integer>();
		//�����ظ�����
		Set<String> lineSet = new HashSet<String>();
		Integer fromId = 1;
		//�ж���·�Ƿ��ѻ���ѡ���ʲ������������»�
		boolean flag = false;
		for(SOC0114Info eiLinkMap : linkMap) {
			if(flag && eiLinkMap.getLinkorder().intValue() != 1) {
				continue;
			}
			if(eiLinkMap.getLinkorder().intValue() == 1) {
				fromId = 1;
				flag = false;//���ñ�־
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
			//�Ƿ��ѻ���ѡ���ʲ�
			if(fromId.equals(selEiid)) {
				flag = true;
				fromId = 1;
			}
		}
		nodeXmlStr.append(actionXmlStr);
	}

	/**
	 * Ӱ��CI��������(Ĭ�ϼ���default��)
	 * 
	 * @param eiid ѡ����ʲ�ID
	 * @param domainid ��ID
	 * @param syscoding Ӱ��CIģ�Ͳ����
	 * @return Ӱ��CI�ʲ�ID����
	 * @throws BLException
	 */
	public List<Integer> searchImpactCI(Integer eiid, Integer domainid, String syscoding) throws BLException {
		
		Integer temp_eiid = eiid;
		//�ж��ʲ����ͣ����ΪDA����DISK����Ҫ���ҵ��������洢������CI����EIID���ٰ��ո�EIID����Ӱ�����
		SOC0118Info ei = soc0118BL.searchEntityItemByKey(eiid);
		if(ei!=null){
			if("999001012".equals(ei.getEsyscoding()) || "999001013".equals(ei.getEsyscoding())){
				temp_eiid = ei.getEirootmark();
			}
		}
		
		
		
		//Ӱ�����
		SOC0114SearchCondImpl cond = new SOC0114SearchCondImpl();
		if(domainid == null) {
			cond.setDomainid_eq(EiDomainKeyWords.DOOMAIN_ID_DEFAULT);
		}
		cond.setDomainid_eq(1);
		cond.setEiid_eq(temp_eiid);
		cond.setEsyscoding_eq(syscoding);
		return this.soc0114BL.queryImpactCI(cond);
	}
	
}