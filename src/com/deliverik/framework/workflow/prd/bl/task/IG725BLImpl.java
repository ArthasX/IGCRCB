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
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG725Info;
import com.deliverik.framework.workflow.prd.model.condition.IG725SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG725SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG725DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG725TB;

/**
  * ����: ȱʡ�����߰�ť�����ҵ���߼�ʵ��
  * ��������: ȱʡ�����߰�ť�����ҵ���߼�ʵ��
  * ������¼: 2012/04/18
  * �޸ļ�¼: 
  */
public class IG725BLImpl extends BaseBLImpl implements
		IG725BL {

	/** ȱʡ�����߰�ť�����DAO�ӿ� */
	protected IG725DAO ig725DAO;
	
	/**
	 * ȱʡ�����߰�ť�����DAO�ӿ��趨
	 *
	 * @param ig725DAO ȱʡ�����߰�ť�����DAO�ӿ�
	 */
	public void setIg725DAO(IG725DAO ig725DAO) {
		this.ig725DAO = ig725DAO;
	}

	/**
	 * ȱʡ�����߰�ť�����ʵ��ȡ��
	 *
	 * @return ȱʡ�����߰�ť�����ʵ��
	 */
	public IG725TB getIG725TBInstance() {
		return new IG725TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG725Info> searchIG725Info() {
		return ig725DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG725Info searchIG725InfoByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG725SearchCond cond) {
		return ig725DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG725Info> searchIG725Info(
			IG725SearchCond cond) {
		return ig725DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG725Info> searchIG725Info(
			IG725SearchCond cond, int start,
			int count) {
		return ig725DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG725Info registIG725Info(IG725Info instance)
		throws BLException {
		return ig725DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG725Info updateIG725Info(IG725Info instance)
		throws BLException {
		checkExistInstance(instance.getPdbdid());
		return ig725DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG725InfoByPK(String pk)
		throws BLException {
		ig725DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG725Info(IG725Info instance)
		throws BLException {
		ig725DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG725Info checkExistInstance(String pk)
		throws BLException {
		IG725Info instance = ig725DAO.findByPK(pk);
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
	public String getPdbdidSequenceNextValue(String psdid) {
		return ig725DAO.getPdbdidSequenceNextValue(psdid);
	}
	
	/**
	 * ����ȷ�ϰ�ť����
	 *
	 * @param psdid ����״̬ID
	 */
	public void registConfirmButton(String psdid) throws BLException {
		IG725SearchCondImpl cond = new IG725SearchCondImpl();
		cond.setPsdid(psdid);
		cond.setPbdid(IGPRDCONSTANTS.BUTTON_CONFIRM);
		List<IG725Info> lst_pdbd = this.searchIG725Info(cond);
		if(lst_pdbd.isEmpty()) {
			IG725TB pdbd = this.getIG725TBInstance();
			pdbd.setPdbdid(this.getPdbdidSequenceNextValue(psdid));//����
			pdbd.setPsdid(psdid);//״̬ID
			pdbd.setPbdid(IGPRDCONSTANTS.BUTTON_CONFIRM);//��ťID
			pdbd.setPdbdname("ȷ��");//��ť����
			pdbd.setPdbddesc("ȷ��");//��ť����
			pdbd.setPdbdauth(null);//�ύȨ��
			this.registIG725Info(pdbd);
		}
	}
	
	/**
	 * ɾ��ȷ�ϰ�ť����
	 *
	 * @param psdid ����״̬ID
	 */
	public void deleteConfirmButton(String psdid) throws BLException {
		IG725SearchCondImpl cond = new IG725SearchCondImpl();
		cond.setPsdid(psdid);
		cond.setPbdid(IGPRDCONSTANTS.BUTTON_CONFIRM);
		List<IG725Info> lst_pdbd = this.searchIG725Info(cond);
		for(IG725Info pdbd : lst_pdbd) {
			this.deleteIG725Info(pdbd);
		}
	}
	
	/**
	 * XML�ű���������
	 *
	 * @param pdid ���̶���ID
	 * @return XML�ű�
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG725SearchCondImpl cond = new IG725SearchCondImpl();
		cond.setPdbdid_like(pdid);
		List<IG725Info> lst_IG725Info = this.searchIG725Info(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG725>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG725Info != null) {
			for(IG725Info info : lst_IG725Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PDBDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdbdid()) ? "" : IGStringUtils.filterXMLStr(info.getPdbdid()));
				sbf_xml.append("</PDBDID>");
				sbf_xml.append("<PSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdid()) ? "" : IGStringUtils.filterXMLStr(info.getPsdid()));
				sbf_xml.append("</PSDID>");
				sbf_xml.append("<PBDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPbdid()) ? "" : IGStringUtils.filterXMLStr(info.getPbdid()));
				sbf_xml.append("</PBDID>");
				sbf_xml.append("<PDBDNAME>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdbdname()) ? "" : IGStringUtils.filterXMLStr(info.getPdbdname()));
				sbf_xml.append("</PDBDNAME>");
				sbf_xml.append("<PDBDDESC>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdbddesc()) ? "" : IGStringUtils.filterXMLStr(info.getPdbddesc()));
				sbf_xml.append("</PDBDDESC>");
				sbf_xml.append("<PDBDAUTH>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdbdauth()) ? "" : IGStringUtils.filterXMLStr(info.getPdbdauth()));
				sbf_xml.append("</PDBDAUTH>");
				sbf_xml.append("<CHECKREQUIRED>");
				sbf_xml.append(StringUtils.isEmpty(info.getCheckrequired()) ? "" : IGStringUtils.filterXMLStr(info.getCheckrequired()));
				sbf_xml.append("</CHECKREQUIRED>");
				sbf_xml.append("<CHECKRECORD>");
				sbf_xml.append(StringUtils.isEmpty(info.getCheckrecord()) ? "" : IGStringUtils.filterXMLStr(info.getCheckrecord()));
				sbf_xml.append("</CHECKRECORD>");
				sbf_xml.append("<ACTURL>");
				sbf_xml.append(StringUtils.isEmpty(info.getActurl()) ? "" : IGStringUtils.filterXMLStr(info.getActurl()));
				sbf_xml.append("</ACTURL>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG725>");
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
		List<IG725Info> lst_IG725 = new ArrayList<IG725Info>();
		IG725TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG725TBInstance();
			entity.setPdbdid(e.getChildText("PDBDID"));
			entity.setPsdid(e.getChildText("PSDID"));
			entity.setPbdid(e.getChildText("PBDID"));
			entity.setPdbdname(e.getChildText("PDBDNAME"));
			entity.setPdbddesc(e.getChildText("PDBDDESC"));
			entity.setPdbdauth(e.getChildText("PDBDAUTH"));
			entity.setCheckrequired(e.getChildText("CHECKREQUIRED"));
			entity.setCheckrecord(e.getChildText("CHECKRECORD"));
			entity.setActurl(e.getChildText("ACTURL"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			lst_IG725.add(entity);
		}
		this.ig725DAO.saveOrUpdateAll(lst_IG725);
	}
}