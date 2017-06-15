/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.model.IG126Info;
import com.deliverik.framework.workflow.prd.model.condition.IG126SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG126SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG126DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG126TB;

/**
 * <p>
 * ����ҳ�涨��ҵ���߼�ʵ��
 * </p>
 */

public class IG126BLImpl extends BaseBLImpl implements
		IG126BL {

	/** ����ҳ�涨��DAO */
	protected IG126DAO ig126DAO;

	/**
	 * ����ҳ�涨��DAO
	 * 
	 * @param processJspDefDAO����ҳ�涨��DAO
	 */
	public void setIg126DAO(
			IG126DAO ig126DAO) {
		this.ig126DAO = ig126DAO;
	}
	
	/**
	 * ���ܣ���ȡ����ҳ�涨��ʵ��
	 * @return IG126TB
	 */
	
	public IG126TB getIG126TBInstance(){
		return new IG126TB();
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond��������
	 * @return ���������������
	 */
	public int getSearchCount(IG126SearchCond cond) {
		return ig126DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param pjdid����ҳ�涨��ID
	 * @return ����ҳ�涨����Ϣ
	 */
	public IG126Info searchIG126InfoByKey(String pjdid)
			throws BLException {

		return checkExistIG126Info(pjdid);
	}

	/**
	 * ȫ����������
	 * 
	 * @return ȫ������ҳ�涨����Ϣ
	 */
	public List<IG126Info> searchIG126InfoAll() {
		return ig126DAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<IG126Info> searchIG126Info(
			IG126SearchCond cond, int start, int count) {
		return ig126DAO.findByCond(cond, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<IG126Info> searchIG126Info(
			IG126SearchCond cond) {
		return ig126DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ��¼����
	 * 
	 * @param IG126��¼����
	 * @return ����ҳ�涨����Ϣ
	 */
	public IG126Info registIG126Info(IG126Info ig126Info)
			throws BLException {
		return ig126DAO.save(ig126Info);
	}

	/**
	 * ɾ������
	 * 
	 * @param pjdid����ҳ�涨��ID
	 */
	public void deleteIG126Info(String pjdid) throws BLException {

		IG126Info processJspDef = checkExistIG126Info(pjdid);

		ig126DAO.delete(processJspDef);
	}

	/**
	 * �������
	 * 
	 * @param IG126�������
	 * @return ����ҳ�涨����Ϣ
	 */
	public IG126Info updateIG126Info(IG126Info ig126Info)
			throws BLException {
		checkExistIG126Info(ig126Info.getPjdid());
		return ig126DAO.save(ig126Info);
	}

	/**
	 * ����ҳ�涨����Ϣ���ڼ��
	 * 
	 * @param pjdid����ҳ�涨��ID
	 * @return ����ҳ�涨����Ϣ
	 * @throws BLException
	 */
	protected IG126Info checkExistIG126Info(String pjdid)
			throws BLException {
		IG126Info info = ig126DAO.findByPK(pjdid);
		if (info == null) {
			throw new BLException("IGCO10000.E004", "����ҳ�涨�����");
		}
		return info;
	}
	
	/**
	 * PJDID����ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return PJDID����ֵ
	 */
	public String getPjdidSequenceNextValue(String pdid) {
		return ig126DAO.getPjdidSequenceNextValue(pdid);
	}
	
	/**
	 * XML�ű���������
	 *
	 * @param pdid ���̶���ID
	 * @return XML�ű�
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG126SearchCondImpl cond = new IG126SearchCondImpl();
		cond.setPjdid_like(pdid);
		List<IG126Info> lst_IG126Info = this.searchIG126Info(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG126>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG126Info != null) {
			for(IG126Info info : lst_IG126Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PJDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPjdid()) ? "" : IGStringUtils.filterXMLStr(info.getPjdid()));
				sbf_xml.append("</PJDID>");
				sbf_xml.append("<PDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdid()) ? "" : IGStringUtils.filterXMLStr(info.getPdid()));
				sbf_xml.append("</PDID>");
				sbf_xml.append("<PJDTYPE>");
				sbf_xml.append(StringUtils.isEmpty(info.getPjdtype()) ? "" : IGStringUtils.filterXMLStr(info.getPjdtype()));
				sbf_xml.append("</PJDTYPE>");
				sbf_xml.append("<PJDBLID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPjdblid()) ? "" : IGStringUtils.filterXMLStr(info.getPjdblid()));
				sbf_xml.append("</PJDBLID>");
				sbf_xml.append("<PJDURL>");
				sbf_xml.append(StringUtils.isEmpty(info.getPjdurl()) ? "" : IGStringUtils.filterXMLStr(info.getPjdurl()));
				sbf_xml.append("</PJDURL>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG126>");
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
		List<IG126Info> lst_IG126 = new ArrayList<IG126Info>();
		IG126TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG126TBInstance();
			entity.setPjdid(e.getChildText("PJDID"));
			entity.setPdid(e.getChildText("PDID"));
			entity.setPjdtype(e.getChildText("PJDTYPE"));
			entity.setPjdblid(e.getChildText("PJDBLID"));
			entity.setPjdurl(e.getChildText("PJDURL"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			lst_IG126.add(entity);
		}
		this.ig126DAO.saveOrUpdateAll(lst_IG126);
	}
}
