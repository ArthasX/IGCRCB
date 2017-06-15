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
import com.deliverik.framework.workflow.prd.model.IG700Info;
import com.deliverik.framework.workflow.prd.model.condition.IG700SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG700SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG700DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG700PK;
import com.deliverik.framework.workflow.prd.model.entity.IG700TB;
 
/**
  * ����: ���̲鿴��ɫ���ñ�ҵ���߼�ʵ��
  * ��������: ���̲鿴��ɫ���ñ�ҵ���߼�ʵ��
  * ������¼: 2012/10/15
  * �޸ļ�¼: 
  */
public class IG700BLImpl extends BaseBLImpl implements
		IG700BL {

	/** ���̲鿴��ɫ���ñ�DAO�ӿ� */
	protected IG700DAO ig700DAO;
	
	/**
	 * ���̲鿴��ɫ���ñ�DAO�ӿ��趨
	 *
	 * @param ig700DAO ���̲鿴��ɫ���ñ�DAO�ӿ�
	 */
	public void setIg700DAO(IG700DAO ig700DAO) {
		this.ig700DAO = ig700DAO;
	}

	/**
	 * ���̲鿴��ɫ���ñ�ʵ��ȡ��
	 *
	 * @return ���̲鿴��ɫ���ñ�ʵ��
	 */
	public IG700TB getIg700TBInstance() {
		return new IG700TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG700Info> searchIg700() {
		return ig700DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG700Info searchIg700ByPK(IG700PK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG700SearchCond cond) {
		return ig700DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG700Info> searchIg700(
			IG700SearchCond cond) {
		return ig700DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG700Info> searchIg700(
			IG700SearchCond cond, int start,
			int count) {
		return ig700DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG700Info registIg700(IG700Info instance)
		throws BLException {
		return ig700DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG700Info updateIg700(IG700Info instance)
		throws BLException {
		checkExistInstance(new IG700PK(instance.getPdid(), instance.getRoleid()));
		return ig700DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIg700ByPK(IG700PK pk)
		throws BLException {
		ig700DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIg700(IG700Info instance)
		throws BLException {
		ig700DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG700Info checkExistInstance(IG700PK pk)
		throws BLException {
		IG700Info instance = ig700DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	
	/**
     * XML�ű���������
     *
     * @param pdid ���̶���ID
     * @return XML�ű�
     */
    public StringBuffer exportXML(String pdid) throws BLException {
    	IG700SearchCondImpl cond = new IG700SearchCondImpl();
        cond.setPdid(pdid);
        List<IG700Info> lst_IG700Info = this.searchIg700(cond);
        StringBuffer sbf_xml = new StringBuffer("");
        sbf_xml.append("<IG700>");
        sbf_xml.append("<DATALIST>");
        if(lst_IG700Info != null) {
            for(IG700Info info : lst_IG700Info) {
                sbf_xml.append("<DATA>");
                sbf_xml.append("<PDID>");
                sbf_xml.append(StringUtils.isEmpty(info.getPdid()) ? "" : IGStringUtils.filterXMLStr(info.getPdid()));
                sbf_xml.append("</PDID>");
                sbf_xml.append("<ROLEID>");
                sbf_xml.append(StringUtils.isEmpty(info.getRoleid().toString()) ? "" : "&roleid_" + info.getRoleid().toString() + ";");
                sbf_xml.append("</ROLEID>");
                sbf_xml.append("<FINGERPRINT>");
                sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
                sbf_xml.append("</FINGERPRINT>");
                sbf_xml.append("</DATA>");
            }
        }
        sbf_xml.append("</DATALIST>");
        sbf_xml.append("</IG700>");
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
        List<IG700Info> lst_IG700 = new ArrayList<IG700Info>();
        IG700TB entity = null;
        for(Element e : dataList) {
            entity = this.getIg700TBInstance();
            entity.setPdid(e.getChildText("PDID"));
            entity.setRoleid(Integer.parseInt(e.getChildText("ROLEID")));
            entity.setFingerPrint(e.getChildText("FINGERPRINT"));
            lst_IG700.add(entity);
        }
        this.ig700DAO.saveOrUpdateAll(lst_IG700);
    }

}