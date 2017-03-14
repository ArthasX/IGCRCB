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
import com.deliverik.framework.workflow.prd.model.IG258Info;
import com.deliverik.framework.workflow.prd.model.condition.IG258SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG258SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG258DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG258TB;

/**
  * ����: ����״̬�����ߵ���ҵ���߼�ʵ��
  * ��������: ����״̬�����ߵ���ҵ���߼�ʵ��
  * ������¼: 2012/05/09
  * �޸ļ�¼: 
  */
public class IG258BLImpl extends BaseBLImpl implements
		IG258BL {

	/** ����״̬�����ߵ���DAO�ӿ� */
	protected IG258DAO ig258DAO;
	
	/**
	 * ����״̬�����ߵ���DAO�ӿ��趨
	 *
	 * @param ig258DAO ����״̬�����ߵ���DAO�ӿ�
	 */
	public void setIg258DAO(IG258DAO ig258DAO) {
		this.ig258DAO = ig258DAO;
	}

	/**
	 * ����״̬�����ߵ���ʵ��ȡ��
	 *
	 * @return ����״̬�����ߵ���ʵ��
	 */
	public IG258TB getIG258TBInstance() {
		return new IG258TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG258Info> searchIG258Info() {
		return ig258DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG258Info searchIG258InfoByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG258SearchCond cond) {
		return ig258DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG258Info> searchIG258Info(
			IG258SearchCond cond) {
		return ig258DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG258Info> searchIG258Info(
			IG258SearchCond cond, int start,
			int count) {
		return ig258DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG258Info registIG258Info(IG258Info instance)
		throws BLException {
		return ig258DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG258Info updateIG258Info(IG258Info instance)
		throws BLException {
		checkExistInstance(instance.getPspcdid());
		return ig258DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG258InfoByPK(String pk)
		throws BLException {
		ig258DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG258Info(IG258Info instance)
		throws BLException {
		ig258DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG258Info checkExistInstance(String pk)
		throws BLException {
		IG258Info instance = ig258DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

	/**
	 * PSDID����ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return PSDID����ֵ
	 */
	public String getPspcdSequenceNextValue(String psdid) {
		return ig258DAO.getPspcdSequenceNextValue(psdid);
	}
	
	/**
	 * XML�ű���������
	 *
	 * @param pdid ���̶���ID
	 * @return XML�ű�
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG258SearchCondImpl cond = new IG258SearchCondImpl();
		cond.setPspcdid_like(pdid);
		List<IG258Info> lst_IG258Info = this.searchIG258Info(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG258>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG258Info != null) {
			for(IG258Info info : lst_IG258Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PSPCDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPspcdid()) ? "" : IGStringUtils.filterXMLStr(info.getPspcdid()));
				sbf_xml.append("</PSPCDID>");
				sbf_xml.append("<PSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdid()) ? "" : IGStringUtils.filterXMLStr(info.getPsdid()));
				sbf_xml.append("</PSDID>");
				sbf_xml.append("<PSPCDPSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPspcdpsdid()) ? "" : IGStringUtils.filterXMLStr(info.getPspcdpsdid()));
				sbf_xml.append("</PSPCDPSDID>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG258>");
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
		List<IG258Info> lst_IG258 = new ArrayList<IG258Info>();
		IG258TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG258TBInstance();
			entity.setPspcdid(e.getChildText("PSPCDID"));
			entity.setPsdid(e.getChildText("PSDID"));
			entity.setPspcdpsdid(e.getChildText("PSPCDPSDID"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			lst_IG258.add(entity);
		}
		this.ig258DAO.saveOrUpdateAll(lst_IG258);
	}
}