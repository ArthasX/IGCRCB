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
import com.deliverik.framework.workflow.prd.model.IG156Info;
import com.deliverik.framework.workflow.prd.model.condition.IG156SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG156SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG156DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG156TB;

/**
  * ����: ����״̬��ť�����ҵ���߼�ʵ��
  * ��������: ����״̬��ť�����ҵ���߼�ʵ��
  * ������¼: 2012/04/13
  * �޸ļ�¼: 
  */
public class IG156BLImpl extends BaseBLImpl implements
		IG156BL {

	/** ����״̬��ť�����DAO�ӿ� */
	protected IG156DAO ig156DAO;
	
	/**
	 * ����״̬��ť�����DAO�ӿ��趨
	 *
	 * @param ig156DAO ����״̬��ť�����DAO�ӿ�
	 */
	public void setIg156DAO(IG156DAO ig156DAO) {
		this.ig156DAO = ig156DAO;
	}

	/**
	 * ����״̬��ť�����ʵ��ȡ��
	 *
	 * @return ����״̬��ť�����ʵ��
	 */
	public IG156TB getIG156TBInstance() {
		return new IG156TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG156Info> searchIG156Info() {
		return ig156DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG156Info searchIG156InfoByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG156SearchCond cond) {
		return ig156DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG156Info> searchIG156Info(
			IG156SearchCond cond) {
		return ig156DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG156Info> searchIG156Info(
			IG156SearchCond cond, int start,
			int count) {
		return ig156DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG156Info registIG156Info(IG156Info instance)
		throws BLException {
		return ig156DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG156Info updateIG156Info(IG156Info instance)
		throws BLException {
		checkExistInstance(instance.getPseid());
		return ig156DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG156InfoByPK(String pk)
		throws BLException {
		ig156DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG156Info(IG156Info instance)
		throws BLException {
		ig156DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG156Info checkExistInstance(String pk)
		throws BLException {
		IG156Info instance = ig156DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

	/**
	 * PEDID����ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PEDID����ֵ
	 */
	public String getPedidSequenceNextValue(String psdid) {
		return ig156DAO.getPedidSequenceNextValue(psdid);
	}
	
	/**
	 * XML�ű���������
	 *
	 * @param pdid ���̶���ID
	 * @return XML�ű�
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG156SearchCondImpl cond = new IG156SearchCondImpl();
		cond.setPseid_like(pdid);
		List<IG156Info> lst_IG156Info = this.searchIG156Info(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG156>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG156Info != null) {
			for(IG156Info info : lst_IG156Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PSEID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPseid()) ? "" : IGStringUtils.filterXMLStr(info.getPseid()));
				sbf_xml.append("</PSEID>");
				sbf_xml.append("<PDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdid()) ? "" : IGStringUtils.filterXMLStr(info.getPdid()));
				sbf_xml.append("</PDID>");
				sbf_xml.append("<PSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdid()) ? "" : IGStringUtils.filterXMLStr(info.getPsdid()));
				sbf_xml.append("</PSDID>");
				sbf_xml.append("<PSEBUTTONID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsebuttonid()) ? "" : IGStringUtils.filterXMLStr(info.getPsebuttonid()));
				sbf_xml.append("</PSEBUTTONID>");
				sbf_xml.append("<PSEACTIONID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPseactionid()) ? "" : IGStringUtils.filterXMLStr(info.getPseactionid()));
				sbf_xml.append("</PSEACTIONID>");
				sbf_xml.append("<PSEORDER>");
				sbf_xml.append(info.getPseorder() == null ? "" : info.getPseorder());
				sbf_xml.append("</PSEORDER>");
				sbf_xml.append("<PSEDEC>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsedec()) ? "" : IGStringUtils.filterXMLStr(info.getPsedec()));
				sbf_xml.append("</PSEDEC>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("<PSBDNAME>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsbdname()) ? "" : IGStringUtils.filterXMLStr(info.getPsbdname()));
				sbf_xml.append("</PSBDNAME>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG156>");
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
		List<IG156Info> lst_IG156 = new ArrayList<IG156Info>();
		IG156TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG156TBInstance();
			entity.setPseid(e.getChildText("PSEID"));
			entity.setPdid(e.getChildText("PDID"));
			entity.setPsdid(e.getChildText("PSDID"));
			entity.setPsebuttonid(e.getChildText("PSEBUTTONID"));
			entity.setPseactionid(e.getChildText("PSEACTIONID"));
			entity.setPseorder(StringUtils.isEmpty(e.getChildText("PSEORDER")) ? null : new Integer(e.getChildText("PSEORDER")));
			entity.setPsedec(e.getChildText("PSEDEC"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			entity.setPsbdname(e.getChildText("PSBDNAME"));
			lst_IG156.add(entity);
		}
		this.ig156DAO.saveOrUpdateAll(lst_IG156);
	}
}