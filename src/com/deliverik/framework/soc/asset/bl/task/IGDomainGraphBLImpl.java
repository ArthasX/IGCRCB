/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.EiRelationKeyWords;
import com.deliverik.framework.soc.asset.model.SOC0114Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0114SearchCondImpl;

/**
  * ����: ����ͼҵ���߼�ʵ��
  * ��������: ����ͼҵ���߼�ʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public class IGDomainGraphBLImpl extends BaseBLImpl implements
	IGDomainGraphBL {

	/** ����ͼ��·��ϢBL */
	protected SOC0114BL soc0114BL;
	
	/**
	 * ����ͼ��·��ϢBL�趨
	 *
	 * @param soc0114BL ����ͼ��·��ϢBL
	 */
	public void setSoc0114BL(SOC0114BL soc0114BL) {
		this.soc0114BL = soc0114BL;
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
		nodeXmlStr.append("<NODE ");
		nodeXmlStr.append("id=\"");
		nodeXmlStr.append(eiLinkMap.getEiid());//�ڵ�ID
		nodeXmlStr.append("\" eiid=\"");
		nodeXmlStr.append(eiLinkMap.getEiid());//�ʲ�ID
		nodeXmlStr.append("\" name=\"");
		nodeXmlStr.append(TopologyGraph.filterStr(eiLinkMap.getEiname()));//�ʲ�����
		nodeXmlStr.append("\" desc=\"");
		nodeXmlStr.append(TopologyGraph.filterStr(eiLinkMap.getEiname()));//�ʲ�����
		nodeXmlStr.append("\" alert=\"flase\"");
		nodeXmlStr.append(" esyscoding=\"");
		nodeXmlStr.append(eiLinkMap.getEsyscoding());//�ʲ�ģ�Ͳ����
		nodeXmlStr.append("\" imgUrl=\"../monitor/");
		nodeXmlStr.append(eiLinkMap.getEsyscoding());//�ʲ�ģ�Ͳ����
		nodeXmlStr.append(".png\"/>");
	}
	
	/**
	 * ����
	 * 
	 * @param actionXmlStr ����XML
	 * @param fromId ��ʼ�ڵ�ID
	 * @param to_id �����ڵ�ID
	 */
	private void drawLine(StringBuffer actionXmlStr, Integer fromId, Integer to_id) {
		actionXmlStr.append("<LINE ");
		actionXmlStr.append("fromNode=\"");
		actionXmlStr.append(fromId);
		actionXmlStr.append("\" toNode=\"");
		actionXmlStr.append(to_id);
		actionXmlStr.append("\"");
		actionXmlStr.append("/>");
	}
	
	/**
	 * ����ͼ��ʾ��ʼ������
	 * 
	 * @param eiid ѡ���ʲ�ID
	 * @param domainid ��ID
	 * @param domainversion ��汾
	 * @param createtime ����ʱ��
	 * @return ��ʾ��XML
	 * @throws BLException 
	 * 
	 */
	public String initGraph(Integer eiid, Integer domainid,
			Integer domainversion, String createtime) throws BLException {
		List<SOC0114Info> linkMap = this.searchLinkMap(eiid, domainid, domainversion, createtime);
		return this.createXml(eiid, linkMap, domainid, domainversion, createtime);
	}
	
	/**
	 * ����ͼ��·����
	 * 
	 * @param eiid ѡ���ʲ�ID
	 * @param domainid ��ID
	 * @param domainversion ��汾
	 * @param createtime ����ʱ��
	 * @return ��ʾ��XML
	 * @throws BLException 
	 * 
	 */
	private List<SOC0114Info> searchLinkMap(Integer eiid, Integer domainid,
			Integer domainversion, String createtime) throws BLException {
		SOC0114SearchCondImpl cond = new SOC0114SearchCondImpl();
		cond.setDomainid_eq(domainid);//��ID
		cond.setDomainversion_eq(domainversion);//��汾
//		cond.setCreatetime_eq(createtime);//���������ʱ��
		cond.setLinkflag_eq("1");//��Ч��·
		return this.soc0114BL.searchEiLinkMap(cond);
	}
	
	/**
	 * ������ʾXML
	 * 
	 * @param eiid ѡ���ʲ�ID
	 * @param linkMap ��·����
	 * @param domainid ��ID
	 * @param domainversion ��汾
	 * @param createtime ��������ʱ��
	 * @throws BLException 
	 */
	protected String createXml(Integer eiid, List<SOC0114Info> linkMap, 
			Integer domainid, Integer domainversion, String createtime) throws BLException {
		StringBuffer nodeXmlStr = new StringBuffer("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		nodeXmlStr.append("<root>");
		nodeXmlStr.append("<NODEONE id=\"0\" esyscoding=\"999999999999\"/>");
		this.drawGraph(linkMap, eiid, nodeXmlStr, domainid, domainversion, createtime);
		nodeXmlStr.append("</root>");
		return nodeXmlStr.toString();
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
	private void drawGraph(List<SOC0114Info> linkMap, Integer selEiid, StringBuffer nodeXmlStr, 
			Integer domainid, Integer domainversion, String createtime) throws BLException {
		StringBuffer actionXmlStr = new StringBuffer();
		//�����ظ����ʲ�
		Set<Integer> eiidSet = new HashSet<Integer>();
		//�����ظ�����
		Set<String> lineSet = new HashSet<String>();
		Integer fromId = 1;
		for(SOC0114Info eiLinkMap : linkMap) {
			//������Ч·��
//			if("0".equals(eiLinkMap.getLinkflag())) {
//				continue;
//			}
			//����ʾDA��DISK
			if(eiLinkMap.getEsyscoding().startsWith(EiRelationKeyWords.HBA)
					|| eiLinkMap.getEsyscoding().startsWith(EiRelationKeyWords.HBAPORT)
						||eiLinkMap.getEsyscoding().startsWith(EiRelationKeyWords.FRONTPORT)
						||eiLinkMap.getEsyscoding().startsWith(EiRelationKeyWords.SANPORT)
						||eiLinkMap.getEsyscoding().startsWith(EiRelationKeyWords.FA)) {
				continue;
			}
			//����ʾ���κ����ӵĽ������˿�
			if(eiLinkMap.getEsyscoding().startsWith(EiRelationKeyWords.SANPORT)
					&& "1".equals(eiLinkMap.getEndflag())) {
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
			if(!lineSet.contains(fromId.toString() + "-" + eiLinkMap.getEiid().toString())&&
					eiLinkMap.getLinkorder().intValue()!=1&&fromId!=eiLinkMap.getEiid()) {
				//����ActionXML
				this.drawLine(actionXmlStr, fromId, eiLinkMap.getEiid());
				lineSet.add(fromId.toString() + "-" + eiLinkMap.getEiid().toString());
			}
			fromId = eiLinkMap.getEiid();
		}
		
		nodeXmlStr.append(actionXmlStr);
	}
	
}