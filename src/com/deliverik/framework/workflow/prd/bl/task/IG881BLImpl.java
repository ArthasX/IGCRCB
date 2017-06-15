/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.model.IG100Info;
import com.deliverik.framework.workflow.prd.model.IG881Info;
import com.deliverik.framework.workflow.prd.model.condition.IG100SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG881SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG881SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG881DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG881TB;

/**
 * <p>����:���̲����߱���Ȩ��ҵ���߼�ʵ��</p>
 * <p>����������1.���������������ȡ��</p>
 * <p>          2.������������</p>
 * <p>          3.ȫ����������</p>
 * <p>          4.������������</p>
 * <p>          5.��¼����</p>
 * <p>          6.������ɾ������</p>
 * <p>          7.ɾ������</p>
 * <p>          8.�������</p>
 * <p>          9.���̲����߱���Ȩ�޴��ڼ��</p>
 * <p>������¼��</p>
 */
public class IG881BLImpl extends BaseBLImpl implements IG881BL{
	
	/** ig881DAO DAO */
	protected IG881DAO ig881DAO;
	
	/**
	 * ���ܣ����̲����߱���Ȩ�޶���DAO
	 * 
	 * @param ig881DAO ���̲����߱���Ȩ�޶���DAO
	 */
	public void setIg881DAO(
			IG881DAO ig881DAO) {
		this.ig881DAO = ig881DAO;
	}

	/**
	 * ���ܣ���ȡ���̱�������ʵ��
	 * @return IG881TB
	 */
	
	public IG881TB getIG881TBInstance(){
		return new IG881TB();
	}

	/**
	 * ���ܣ����������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getIG881InfoSearchCount(IG881SearchCond cond){
		
		return ig881DAO.getSearchCount(cond);
	}

	/**
	 * ���ܣ�������������
	 * 
	 * @param pipdid ���̲����߱���Ȩ��ID
	 * @return ���̲����߱���Ȩ��
	 */
	public IG881Info searchIG881InfoByKey(String pipdid) throws BLException{
		
		return checkExistProcessInfoParticipantDef(pipdid);
	}
	
	/**
	 * ���ܣ�ȫ����������
	 *
	 * @return ȫ�����̲����߱���Ȩ����Ϣ
	 */
	public List<IG881Info> searchIG881Info(IG881SearchCond cond){
		
		return ig881DAO.findByCond(cond,0,0);
	}

	/**
	 * ���ܣ�������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG881Info> searchIG881Info(IG881SearchCond cond, int start, int count){
		
		return ig881DAO.findByCond(cond,start,count);
	}

	/**
	 * ���ܣ���¼����
	 * 
	 * @param Ig881 ��¼����
	 * @return ���̲����߱���Ȩ��
	 */
	public IG881Info registIG881Info(IG881Info ig881Info) throws BLException{
		
		return ig881DAO.save(ig881Info);
	}

	/**
	 * ���ܣ�ɾ������
	 * 
	 * @param pipdid ɾ���������̲���������
	 */
	public void deleteIG881InfoByKey(String pipdid) throws BLException{
		
		IG881Info processInfoParticipantDef = checkExistProcessInfoParticipantDef(pipdid);
		
		ig881DAO.delete(processInfoParticipantDef);
	}

	/**
	 * ���ܣ�ɾ������
	 * 
	 * @param IG881 ɾ���������̲�����
	 */
	public void deleteIG881Info(IG881Info ig881Info) throws BLException{
		IG881Info pid = checkExistProcessInfoParticipantDef(ig881Info.getPipdid());
		
		ig881DAO.delete(pid);
	}
	/**
	 * ���ܣ��������
	 * 
	 * @param IG881 �������
	 * @return ���̲����߱���Ȩ��
	 */
	public IG881Info updateIG881Info(IG881Info ig881Info) throws BLException{
		
		checkExistProcessInfoParticipantDef(ig881Info.getPipdid());
		return ig881DAO.save(ig881Info);
	}

	/**
	 * ���ܣ����̲����߱���Ȩ�޴��ڼ��
	 * 
	 * @param pipdid ���̲����߱���Ȩ��ID
	 * @return ���̲����߱���Ȩ��
	 * @throws BLException 
	 */
	protected IG881Info checkExistProcessInfoParticipantDef(String pipdid) throws BLException{
		IG881Info info = ig881DAO.findByPK(pipdid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","���̲����߱���Ȩ�޻���");
		}
		return info;
	}
	
	/**
	 * ���̲����߱���Ȩ����ͼ��ѯ
	 * 
	 * @param cond ��ѯ����
	 * @return ���̲����߱���Ȩ��
	 * @throws BLException 
	 */
	public List<IG100Info> searchIG100Info(IG100SearchCond cond)
		throws BLException{
		return ig881DAO.findByCond(cond);
	}
	
	/**
	 * PIPDID����ֵȡ��
	 * 
	 * @param ����״̬�����߶���ID
	 * @return PIPDID����ֵ
	 */
	public String getPipdidSequenceNextValue(String ppdid) {
		return ig881DAO.getPipdidSequenceNextValue(ppdid);
	}
	
	/**
	 * XML�ű���������
	 *
	 * @param pdid ���̶���ID
	 * @return XML�ű�
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG881SearchCondImpl cond = new IG881SearchCondImpl();
		cond.setPipdid_like(pdid);
		List<IG881Info> lst_IG881Info = this.searchIG881Info(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG881>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG881Info != null) {
			for(IG881Info info : lst_IG881Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PIPDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPipdid()) ? "" : IGStringUtils.filterXMLStr(info.getPipdid()));
				sbf_xml.append("</PIPDID>");
				sbf_xml.append("<PIDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidid()) ? "" : IGStringUtils.filterXMLStr(info.getPidid()));
				sbf_xml.append("</PIDID>");
				sbf_xml.append("<PSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdid()) ? "" : IGStringUtils.filterXMLStr(info.getPsdid()));
				sbf_xml.append("</PSDID>");
				sbf_xml.append("<PPDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPpdid()) ? "" : IGStringUtils.filterXMLStr(info.getPpdid()));
				sbf_xml.append("</PPDID>");
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
		sbf_xml.append("</IG881>");
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
		List<IG881Info> lst_IG881 = new ArrayList<IG881Info>();
		IG881TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG881TBInstance();
			entity.setPipdid(e.getChildText("PIPDID"));
			entity.setPidid(e.getChildText("PIDID"));
			entity.setPsdid(e.getChildText("PSDID"));
			entity.setPpdid(e.getChildText("PPDID"));
			entity.setPidaccess(e.getChildText("PIDACCESS"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			entity.setPidrequired(e.getChildText("PIDREQUIRED"));
			lst_IG881.add(entity);
		}
		this.ig881DAO.saveOrUpdateAll(lst_IG881);
	}
}
