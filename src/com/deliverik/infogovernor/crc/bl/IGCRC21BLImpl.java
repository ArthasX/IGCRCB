/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.crc.bl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.crc.bl.task.IGCRC2101BL;
import com.deliverik.infogovernor.crc.dto.IGCRC2101DTO;
import com.deliverik.infogovernor.crc.form.IGCRC2101Form;
import com.deliverik.infogovernor.crc.model.IGCRC2101VWInfo;
import com.deliverik.infogovernor.crc.model.IGCRC2102VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2101CondImpl;
import com.deliverik.infogovernor.crc.model.entity.IGCRC2101VW;
import com.deliverik.infogovernor.crc.model.entity.IGCRC2102VW;
import com.deliverik.infogovernor.crc.vo.IGCRC2102VO;

/**	
 * ����:��Ա����ͳ�Ʋ�ѯҵ���߼�ʵ��	
 * ������¼��yukexin    2014-8-15 ����2:24:00	
 * �޸ļ�¼��
 */	
public class IGCRC21BLImpl implements IGCRC21BL {
	//��־����ȡ��
	static Log log = LogFactory.getLog(IGCRC21BLImpl.class);
	
	/** ��Ա����ͳ����ϢBL */
	protected IGCRC2101BL igcrc2101BL;
	
	/** ����BL */
	protected OrganizationBL organizationBL;

	public void setIgcrc2101BL(IGCRC2101BL igcrc2101bl) {
		this.igcrc2101BL = igcrc2101bl;
	}
	
	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}

	/**
	 * ��Ա������Ϣ��ѯ����
	 *
	 * @param dto IGCRC2101DTO
	 * @return IGCRC2101DTO
	 */
	public IGCRC2101DTO searchEntityItemAction(IGCRC2101DTO dto)
			throws BLException {
		log.debug("========��Ա����ͳ����Ϣ��ѯ����ʼ========");
		//��ȡform
		IGCRC2101Form form = dto.getIgcrc2101Form();
		//ʵ����cond
		IGCRC2101CondImpl cond = new IGCRC2101CondImpl();
		//��ȡ��
		String year=form.getYear();
		//��ȡ��
		String month=form.getMonth();
		String propentime=null;
		//�ж������Ƿ�Ϊ��
		if(year==null&&month==null){
			propentime="%";
		}else{
			propentime=year+"/"+month+"%";
		}
		//ƴ�ӵ����¸�ֵ
		cond.setPropentime(propentime);
		//��ֵ
		cond = copyProperties(form, cond);
		//��ȡ����
		List<IGCRC2101VWInfo> crList = igcrc2101BL.searchIGCRC2101(cond);
		// ���ϼƵ�����
		List<IGCRC2102VO> igcrc2102voList = new ArrayList<IGCRC2102VO>();
		// ����ϼ�����
		List<Integer> listSum = new ArrayList<Integer>();

		// ͳ��ÿ����Ա��ͳ��
		if (null != crList && crList.size() != 0) {
			IGCRC2101VW igcrc2101VW = null;
			Integer incidentNum = 0;
			Integer problemNum = 0;
			Integer changeNum = 0;
			Integer serviceNum = 0;
			Integer developNum = 0;
			Integer total = 0;
			//�������ݲ�����ϼ�
			for (IGCRC2101VWInfo vw : crList) {
				igcrc2101VW = (IGCRC2101VW)vw;
				//�����ѯ���ǿ�ֵ,��Ϊ0
				if(igcrc2101VW.getIncidentNum() == null){
					igcrc2101VW.setIncidentNum(0);
				}
				if(igcrc2101VW.getProblemNum() == null){
					igcrc2101VW.setProblemNum(0);
				}
				if(igcrc2101VW.getChangeNum() == null){
					igcrc2101VW.setChangeNum(0);
				}
				if(igcrc2101VW.getServiceNum() == null){
					igcrc2101VW.setServiceNum(0);
				}
				if(igcrc2101VW.getDevelopNum() == null){
					igcrc2101VW.setDevelopNum(0);
				}
				// ����ÿ����Աʹ�õ�����
				int sum = (igcrc2101VW.getIncidentNum() + igcrc2101VW.getProblemNum() + igcrc2101VW.getChangeNum()
						+ igcrc2101VW.getServiceNum() + igcrc2101VW.getDevelopNum());
				// �ۼ�ÿ��ϼ�
				incidentNum += igcrc2101VW.getIncidentNum();
				problemNum += igcrc2101VW.getProblemNum();
				changeNum += igcrc2101VW.getChangeNum();
				serviceNum += igcrc2101VW.getServiceNum();
				developNum += igcrc2101VW.getDevelopNum();
				total += sum;
				// ����ͼ����bean�ͺϼ���ӵ��µ�bean�в���������
				igcrc2102voList.add(new IGCRC2102VO(igcrc2101VW, sum));
			}
			listSum.add(incidentNum);
			listSum.add(problemNum);
			listSum.add(changeNum);
			listSum.add(serviceNum);
			listSum.add(developNum);
			listSum.add(total);
		} else {
			// û�����ݵ�ʱ�� �ϼƸ�����0  6��
			for (int i = 0; i < 6; i++) {
				listSum.add(0);
			}
		}
		//���ݴ���dto
		dto.setListSum(listSum);
		dto.setIgcrc2102voList(igcrc2102voList);
		log.debug("========��Ա������Ϣ��ѯ��������========");
		return dto;
	}
	
	/**	
	 * ���ܣ���form�еĲ�ѯ��������cond
	 * @param form ҳ���ѯ����
	 * @param cond ��������
	 * @return
	 * �޸ļ�¼��
	 */	
	private IGCRC2101CondImpl copyProperties(IGCRC2101Form form, IGCRC2101CondImpl cond){
		//��
		cond.setYear(form.getYear());
		//��
		cond.setMonth(form.getMonth());
		//����
		cond.setDepartment(form.getDepartment());
		return cond;
	}

	/**	
	 * ���ܣ���ѯ���������б�
	 * @param dto
	 * @return IGCRC2101DTO
	 * @throws BLException
	 * �޸ļ�¼��null
	 */	
	public IGCRC2101DTO searchDepartmentBeanList(IGCRC2101DTO dto)
			throws BLException {
		
		OrganizationSearchCondImpl organizationSearchCond = new OrganizationSearchCondImpl();
		organizationSearchCond.setIs_in_use("1");
		organizationSearchCond.setOrgpar("0002001017");//��Ϣ�Ƽ���
		organizationSearchCond.setSortType(CommonDefineUtils.SORT_BY_ORGSYSCODING);
		List<Organization> ret = organizationBL.searchOrganization(organizationSearchCond);//��1������
		List<IGCRC2102VWInfo> departmentBeanList = new ArrayList<IGCRC2102VWInfo>();
		for (Organization organization : ret) {
			IGCRC2102VW igcrc2102vw = new IGCRC2102VW();
			igcrc2102vw.setId(organization.getOrgid().toString());
			String[] orgnames = organization.getOrgname().split("-");
			int orgslen = orgnames.length - 1;
			igcrc2102vw.setLabel(orgnames[orgslen]);
			igcrc2102vw.setValue(organization.getOrgsyscoding());
			departmentBeanList.add(igcrc2102vw);
		}
		//��ȡ����
//		List<IGCRC2102VWInfo> departmentBeanList = igcrc2101BL.searchDepartmentBeanList();
		//����
		dto.setDepartmentBeanList(departmentBeanList);
		return dto;
	}
}
