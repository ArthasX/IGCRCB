/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.model.IG699Info;
import com.deliverik.framework.workflow.prd.model.IG909Info;
import com.deliverik.framework.workflow.prd.model.condition.IG699SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG699SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG909SearchCond;
import com.deliverik.framework.workflow.prd.model.dao.IG699DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG699TB;

/**
 * <p>����:����ȱʡ�����߱���Ȩ��ҵ���߼�ʵ��</p>
 * <p>����������1.���������������ȡ��</p>
 * <p>          2.������������</p>
 * <p>          3.ȫ����������</p>
 * <p>          4.������������</p>
 * <p>          5.��¼����</p>
 * <p>          6.ɾ������</p>
 * <p>          7.�������</p>
 * <p>          8.����ȱʡ�����߱���Ȩ�޴��ڼ��</p>
 * ������¼��</p>
 */
public class IG699BLImpl extends BaseBLImpl implements IG699BL{
	
	/** ParticipantDefaultVariable DAO */
	protected IG699DAO ig699DAO;
	
	/**
	 * ����ȱʡ�����߱���Ȩ��DAO
	 * @param ig699DAO ����ȱʡ�����߱���Ȩ��DAO
	 */
	public void setIg699DAO(
			IG699DAO ig699DAO) {
		this.ig699DAO = ig699DAO;
	}

	/**
	 * ���ܣ���ȡ���̱�������ʵ��
	 * @return IG699TB
	 */
	
	public IG699TB getIG699TBInstance(){
		return new IG699TB();
	}

	/**
	 * ���ܣ����������������ȡ��
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getIG699InfoSearchCount(IG699SearchCond cond){
		
		return ig699DAO.getSearchCount(cond);
	}

	/**
	 * ���ܣ�������������
	 * @param pdvid ����ȱʡ�����߱���Ȩ��ID
	 * @return ����ȱʡ�����߱���Ȩ��
	 */
	public IG699Info searchIG699InfoByKey(String pdvid) throws BLException{
		
		return checkExistParticipantDefaultVariable(pdvid);
	}
	
	/**
	 * ���ܣ�ȫ����������
	 * @param cond ��������
	 * @return ȫ������ȱʡ�����߱���Ȩ����Ϣ
	 */
	public List<IG699Info> searchIG699Info(IG699SearchCond cond){
		
		return ig699DAO.findByCond(cond,0,0);
	}

	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG699Info> searchIG699Info(IG699SearchCond cond, int start, int count){
		
		return ig699DAO.findByCond(cond,start,count);
	}

	/**
	 * ���ܣ���¼����
	 * @param ig699Info ��¼����
	 * @return ����ȱʡ�����߱���Ȩ��
	 * @throws BLException
	 */
	public IG699Info registIG699Info(IG699Info ig699Info) throws BLException{
		
		return ig699DAO.save(ig699Info);
	}

	/**
	 * ���ܣ�ɾ������
	 * @param pdvid ɾ����������ȱʡ����������
	 * @throws BLException
	 */
	public void deleteIG699InfoByKey(String pdvid) throws BLException{
		
		IG699Info participantDefaultVariable = checkExistParticipantDefaultVariable(pdvid);
		
		ig699DAO.delete(participantDefaultVariable);
	}

	/**
	 * ���ܣ�ɾ������
	 * @param pdvid ɾ����������ȱʡ���������� 
	 * @throws BLException
	 */
	public void deleteIG699Info(IG699Info ig699Info) throws BLException{
		IG699Info pid = checkExistParticipantDefaultVariable(ig699Info.getPdvid());
		
		ig699DAO.delete(pid);
	}
	/**
	 * ���ܣ��������
	 * @param ig699Info �������
	 * @return ����ȱʡ�����߱���Ȩ��
	 * @throws BLException
	 */
	public IG699Info updateIG699Info(IG699Info ig699Info) throws BLException{
		
		checkExistParticipantDefaultVariable(ig699Info.getPdvid());
		return ig699DAO.save(ig699Info);
	}

	/**
	 * ���ܣ�����ȱʡ�����߱���Ȩ�޴��ڼ��
	 * @param pdvid ����ȱʡ�����߱���Ȩ��ID
	 * @return ����ȱʡ�����߱���Ȩ��
	 * @throws BLException 
	 */
	protected IG699Info checkExistParticipantDefaultVariable(String pdvid) throws BLException{
		IG699Info info = ig699DAO.findByPK(pdvid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","����ȱʡ�����߱���Ȩ�޻���");
		}
		return info;
	}
	
	/**
	 * ����ȱʡ����Ȩ����ͼ��ѯ
	 * 
	 * @param cond ��ѯ����
	 * @return ����ȱʡ����Ȩ��
	 * @throws BLException 
	 */
	public List<IG909Info> searchIG909Info(IG909SearchCond cond) {
		return ig699DAO.searchIG909Info(cond);
	}
	
	/**
	 * PDVID����ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PDVID����ֵ
	 */
	public String getPdvidSequenceNextValue(String psdid) {
		return ig699DAO.getPdvidSequenceNextValue(psdid);
	}
	
	/**
	 * XML�ű���������
	 *
	 * @param pdid ���̶���ID
	 * @return XML�ű�
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG699SearchCondImpl cond = new IG699SearchCondImpl();
		cond.setPdvid_like(pdid);
		List<IG699Info> lst_IG699Info = this.searchIG699Info(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG699>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG699Info != null) {
			for(IG699Info info : lst_IG699Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PDVID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdvid()) ? "" : IGStringUtils.filterXMLStr(info.getPdvid()));
				sbf_xml.append("</PDVID>");
				sbf_xml.append("<PIDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidid()) ? "" : IGStringUtils.filterXMLStr(info.getPidid()));
				sbf_xml.append("</PIDID>");
				sbf_xml.append("<PSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdid()) ? "" : IGStringUtils.filterXMLStr(info.getPsdid()));
				sbf_xml.append("</PSDID>");
				sbf_xml.append("<PIDACCESS>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidaccess()) ? "" : IGStringUtils.filterXMLStr(info.getPidaccess()));
				sbf_xml.append("</PIDACCESS>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("<PIDREQUIRED>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidrequired()) ? "" : IGStringUtils.filterXMLStr(info.getPidrequired()));
				sbf_xml.append("</PIDREQUIRED>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG699>");
		return sbf_xml;
	}
	
	/**
	 * XML�ű����봦��
	 *
	 * @param element Element
	 * @throws BLException
	 */
	@SuppressWarnings("unchecked")
	public void importXML(Element element) throws BLException {
		Element data = element.getChild("DATALIST");
		List<Element> dataList = data.getChildren();
		List<IG699Info> lst_IG699 = new ArrayList<IG699Info>();
		IG699TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG699TBInstance();
			entity.setPdvid(e.getChildText("PDVID"));
			entity.setPidid(e.getChildText("PIDID"));
			entity.setPsdid(e.getChildText("PSDID"));
			entity.setPidaccess(e.getChildText("PIDACCESS"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			entity.setPidrequired(e.getChildText("PIDREQUIRED"));
			lst_IG699.add(entity);
		}
		this.ig699DAO.saveOrUpdateAll(lst_IG699);
	}
	
}
