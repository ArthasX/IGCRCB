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
import com.deliverik.framework.workflow.prd.model.IG211Info;
import com.deliverik.framework.workflow.prd.model.condition.IG211SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG211SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG211DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG211TB;

/**
 * <p>����:����״̬����ǰ����ҵ���߼�ʵ��</p>
 * <p>����������1.���������������ȡ��</p>
 * <p>          2.������������</p>
 * <p>          3.������������</p>
 * <p>          4.ȫ����������</p>
 * <p>          5.��������</p>
 * <p>          6.ɾ������</p>
 * <p>          7.�������</p>
 * <p>          8.����״̬����ǰ������Ϣ���ڼ��</p>
 * <p>          9.����״̬ǰ���������Ϣʵ��</p>
 * <p>������¼��</p>
 */
public class IG211BLImpl extends BaseBLImpl implements IG211BL {
	
	/** ����״̬����ǰ����DAO���� */
	protected IG211DAO ig211DAO;

	/**
	 * ����״̬����ǰ������DAO
	 * 
	 * @param ig211DAO ����״̬����ǰ������DAO
	 */
	public void setIg211DAO(
			IG211DAO ig211DAO) {
		this.ig211DAO = ig211DAO;
	}

	/**
	 * ���ܣ����������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	
	public int getIG211InfoSearchCount(IG211SearchCond cond) {
		return ig211DAO.getSearchCount(cond);
	}
	
	

	/**
	 * ���ܣ�������������
	 * 
	 * @param psidid ����״̬����ǰ����ID
	 * @return ����״̬����ǰ������Ϣ
	 * @throws BLException 
	 */
	
	public IG211Info searchIG211InfoByKey(String psidid) throws BLException {
		return checkExistIG211Info(psidid);
	}

	/**
	 * ���ܣ�������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	
	public List<IG211Info> searchIG211Info(
			IG211SearchCond cond, int start, int count) {
		return ig211DAO.findByCond(cond, start, count);
	}
	
	/**
	 * ���ܣ�������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	
	public List<IG211Info> searchIG211Info(
			IG211SearchCond cond) {
		return ig211DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ���ܣ�ȫ����������
	 * 
	 * @return ��������б�
	 */
	
	public List<IG211Info> searchProcessStatusInfoDefAll() {
		return ig211DAO.findAll();
	}

	/**
	 * ���ܣ���������
	 * 
	 * @param IG211Info ��������
	 * @return �ʲ���Ϣ
	 * @throws BLException 
	 */
	
	public IG211Info registIG211Info(
			IG211Info ig211Info) throws BLException {
		return ig211DAO.save(ig211Info);
	}

	/**
	 * ���ܣ�ɾ������
	 * 
	 * @param psidid ɾ������״̬����ǰ��������
	 * @throws BLException 
	 */
	
	public void deleteIG211Info(String psidid) throws BLException {
		IG211Info processStatusInfoDef = checkExistIG211Info(psidid);
		ig211DAO.delete(processStatusInfoDef);
	}

	/**
	 * ���ܣ��������
	 * 
	 * @param Ig211 �������
	 * @return ����״̬����ǰ����
	 * @throws BLException 
	 */
	
	public IG211Info updateIG211Info(
			IG211Info ig211Info) throws BLException {
		return ig211DAO.save(ig211Info);
	}
	
	/**
	 * ���ܣ�����״̬����ǰ������Ϣ���ڼ��
	 * 
	 * @param psidid ����״̬����ǰ����ID
	 * @return ����״̬����ǰ����
	 * @throws BLException 
	 */
	
	protected IG211Info checkExistIG211Info(String psidid) throws BLException{
		IG211Info info = ig211DAO.findByPK(psidid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","����״̬����ǰ�������");
		}
		return info;
	}
	
	/**
	 * ���ܣ�����״̬ǰ���������Ϣʵ��
	 * 
	 * @return ����״̬ǰ�������
	 */
	
	public IG211TB getIG211TBInstance() {
		return new IG211TB();
	}
	
	/**
	 * PSIDID����ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PSIDID����ֵ
	 */
	public String getPsididSequenceNextValue(String psdid) {
		return ig211DAO.getPsididSequenceNextValue(psdid);
	}
	
	/**
	 * XML�ű���������
	 *
	 * @param pdid ���̶���ID
	 * @return XML�ű�
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG211SearchCondImpl cond = new IG211SearchCondImpl();
		cond.setPsidid_like(pdid);
		List<IG211Info> lst_IG211Info = this.searchIG211Info(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG211>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG211Info != null) {
			for(IG211Info info : lst_IG211Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PSIDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsidid()) ? "" : IGStringUtils.filterXMLStr(info.getPsidid()));
				sbf_xml.append("</PSIDID>");
				sbf_xml.append("<PSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdid()) ? "" : IGStringUtils.filterXMLStr(info.getPsdid()));
				sbf_xml.append("</PSDID>");
				sbf_xml.append("<PIDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidid()) ? "" : IGStringUtils.filterXMLStr(info.getPidid()));
				sbf_xml.append("</PIDID>");
				sbf_xml.append("<PIDNAME>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidname()) ? "" : IGStringUtils.filterXMLStr(info.getPidname()));
				sbf_xml.append("</PIDNAME>");
				sbf_xml.append("<PIDLABEL>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidlabel()) ? "" : IGStringUtils.filterXMLStr(info.getPidlabel()));
				sbf_xml.append("</PIDLABEL>");
				sbf_xml.append("<PIDDESC>");
				sbf_xml.append(StringUtils.isEmpty(info.getPiddesc()) ? "" : IGStringUtils.filterXMLStr(info.getPiddesc()));
				sbf_xml.append("</PIDDESC>");
				sbf_xml.append("<PIDTYPE>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidtype()) ? "" : IGStringUtils.filterXMLStr(info.getPidtype()));
				sbf_xml.append("</PIDTYPE>");
				sbf_xml.append("<PIDVALUE>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidvalue()) ? "" : IGStringUtils.filterXMLStr(info.getPidvalue()));
				sbf_xml.append("</PIDVALUE>");
				sbf_xml.append("<PIDATTKEY>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidattkey()) ? "" : IGStringUtils.filterXMLStr(info.getPidattkey()));
				sbf_xml.append("</PIDATTKEY>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG211>");
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
		List<IG211Info> lst_IG211 = new ArrayList<IG211Info>();
		IG211TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG211TBInstance();
			entity.setPsidid(e.getChildText("PSIDID"));
			entity.setPsdid(e.getChildText("PSDID"));
			entity.setPidid(e.getChildText("PIDID"));
			entity.setPidname(e.getChildText("PIDNAME"));
			entity.setPidlabel(e.getChildText("PIDLABEL"));
			entity.setPiddesc(e.getChildText("PIDDESC"));
			entity.setPidtype(e.getChildText("PIDTYPE"));
			entity.setPidvalue(e.getChildText("PIDVALUE"));
			entity.setPidattkey(e.getChildText("PIDATTKEY"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			lst_IG211.add(entity);
		}
		this.ig211DAO.saveOrUpdateAll(lst_IG211);
	}

}
