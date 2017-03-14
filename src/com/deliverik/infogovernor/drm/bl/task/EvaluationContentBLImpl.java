/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.user.model.condition.UserInfoSearchCondImpl;
import com.deliverik.framework.user.model.entity.UserInfoVW;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.framework.workflow.prd.bl.task.IG222BL;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.condition.IG222SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG224BL;
import com.deliverik.framework.workflow.prr.model.IG224Info;
import com.deliverik.framework.workflow.prr.model.condition.IG224SearchCondImpl;
import com.deliverik.infogovernor.drm.model.EvaluationContentInfo;
import com.deliverik.infogovernor.drm.model.condition.EvaluationContentSearchCond;
import com.deliverik.infogovernor.drm.model.condition.EvaluationContentSearchCondImpl;
import com.deliverik.infogovernor.drm.model.dao.EvaluationContentDAO;
import com.deliverik.infogovernor.drm.model.entity.EvaluationContentTB;
import com.deliverik.infogovernor.drm.util.IGDRMEmergencyTools;

/**
  * ����: ��Ŀ�ܱ���Ա������ҵ���߼�ʵ��
  * ��������: ��Ŀ�ܱ���Ա������ҵ���߼�ʵ��
  * ������¼: 2016/08/11
  * �޸ļ�¼: 
  */
public class EvaluationContentBLImpl extends BaseBLImpl implements
		EvaluationContentBL {

	/** ��Ŀ�ܱ���Ա������DAO�ӿ� */
	protected EvaluationContentDAO evaluationContentDAO;
	
	/**
	 * ��Ŀ�ܱ���Ա������DAO�ӿ��趨
	 *
	 * @param evaluationContentDAO ��Ŀ�ܱ���Ա������DAO�ӿ�
	 */
	public void setEvaluationContentDAO(EvaluationContentDAO evaluationContentDAO) {
		this.evaluationContentDAO = evaluationContentDAO;
	}

	/**
	 * ��Ŀ�ܱ���Ա������ʵ��ȡ��
	 *
	 * @return ��Ŀ�ܱ���Ա������ʵ��
	 */
	public EvaluationContentTB getEvaluationContentTBInstance() {
		return new EvaluationContentTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EvaluationContentInfo> searchEvaluationContent() {
		return evaluationContentDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EvaluationContentInfo searchEvaluationContentByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(EvaluationContentSearchCond cond) {
		return evaluationContentDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<EvaluationContentInfo> searchEvaluationContent(
			EvaluationContentSearchCond cond) {
		return evaluationContentDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EvaluationContentInfo> searchEvaluationContent(
			EvaluationContentSearchCond cond, int start,
			int count) {
		return evaluationContentDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public EvaluationContentInfo registEvaluationContent(EvaluationContentInfo instance)
		throws BLException {
		return evaluationContentDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public EvaluationContentInfo updateEvaluationContent(EvaluationContentInfo instance)
		throws BLException {
		checkExistInstance(instance.getEvid());
		return evaluationContentDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteEvaluationContentByPK(Integer pk)
		throws BLException {
		evaluationContentDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteEvaluationContent(EvaluationContentInfo instance)
		throws BLException {
		evaluationContentDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public EvaluationContentInfo checkExistInstance(Integer pk)
		throws BLException {
		EvaluationContentInfo instance = evaluationContentDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.drm.bl.task.EvaluationContentBL#saveEvaluationContent(com.deliverik.infogovernor.drm.model.entity.EvaluationContentTB)
	 */
	public List<EvaluationContentInfo> saveEvaluationContent(EvaluationContentTB evaluationContentTB)
			throws BLException {
		Map<String, Object> map = new HashMap<String, Object>();
		map = IGDRMEmergencyTools.getEmergencyFlow(evaluationContentTB.getPrid());
		List<Map<String,Object>> flowList = (List<Map<String,Object>>) map.get("stepList");
		if(flowList!=null && flowList.size()>0){
			for(int index = 0;index<flowList.size();index++){
				Map<String,Object> stepMap = flowList.get(index);
				if(stepMap.get("psdid").equals(evaluationContentTB.getPsdid())){
					evaluationContentTB.setStepName(stepMap.get("psdname").toString());
				}
			}
			
		}
		IG224BL ig224BL = (IG224BL) WebApplicationSupport.getBean("ig224BL");
		IG222BL ig222BL = (IG222BL) WebApplicationSupport.getBean("ig222BL");
		UserBL userBL = (UserBL) WebApplicationSupport.getBean("userBL");
		IG224SearchCondImpl ig224Cond = new IG224SearchCondImpl();
		ig224Cond.setPrid(evaluationContentTB.getPrid());
		ig224Cond.setPsdid(evaluationContentTB.getPsdid());
		IG224Info ig224Info = ig224BL.searchIG224Info(ig224Cond, 0, 0).get(0);
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		evaluationContentTB.setStartTime(format.format(ig224Info.getRslOpenTime()));
		evaluationContentTB.setStopTime(format.format(ig224Info.getRslCloseTime()));
		Long factUseTimeValue = ig224Info.getRslCloseTime().getTime() - ig224Info.getRslOpenTime().getTime();
		Double factUseTime = Double.parseDouble(factUseTimeValue.toString())/1000/60;
		evaluationContentTB.setFactUseTime(String.format("%.2f", factUseTime));
//		if(evaluationContentTB.getFlowType().equals("em")){
			// ��ѯ�����˲��洢
			Map<String, UserInfo> userMap = new HashMap<String, UserInfo>();
			IG222SearchCondImpl ig222Cond = new IG222SearchCondImpl();
			UserInfoSearchCondImpl userCond = new UserInfoSearchCondImpl();
			ig222Cond.setPsdid(evaluationContentTB.getPsdid());
			List<IG222Info> ig222List = ig222BL.searchIG222Info(ig222Cond);
			if (ig222List != null && ig222List.size() > 0) {
				for (IG222Info ig222Info : ig222List) {
					if (StringUtils.isNotEmpty(ig222Info.getUserid())) {
						userCond.setUserida(ig222Info.getUserid());
						List<UserInfo> userList = userBL.searchUserInfo(userCond);
						if (userList != null && userList.size() > 0) {
							UserInfo user = (UserInfo) userList.get(0);
							userMap.put(user.getUserida(), user);
						}
					} else {
						List<UserInfo> userInfoList = userBL.searchUserByRoleId(ig222Info.getRoleid());
						if (userInfoList != null&& userInfoList.size() > 0) {
							for (int i = 0; i < userInfoList.size(); i++) {
								UserInfoVW user = new UserInfoVW();
								BeanUtils.copyProperties(userInfoList.get(i), user);
								user.setUserida(((UserTB) userInfoList.get(i)).getUserid());
								userMap.put(user.getUserida(), user);
							}
						}
					}
				}
//			}
			StringBuffer peopleStr = new StringBuffer();
			for (String peopleKey : userMap.keySet()) {
				peopleStr.append(userMap.get(peopleKey).getUsername()+ "��");
			}
			if(peopleStr.length()>0){
				evaluationContentTB.setPeoples(peopleStr.substring(0,peopleStr.length()-1 ));
			}else{
				evaluationContentTB.setPeoples("");
			}
		}
		//������
		String username = userBL.searchUserByKey(evaluationContentTB.getEvpeople()).getUsername();
		evaluationContentTB.setEvpeople(username);
		EvaluationContentSearchCondImpl ecCond = new EvaluationContentSearchCondImpl();
		ecCond.setPsdid(evaluationContentTB.getPsdid());
		ecCond.setPrid(evaluationContentTB.getPrid());
		//����ʱ��
		Date nowDate = new Date();
		evaluationContentTB.setDoTime(format.format(nowDate));
		List<EvaluationContentInfo> ecList = evaluationContentDAO.findByCond(ecCond, 0, 0);
		if(ecList.size()>0){
			evaluationContentTB.setEvid(ecList.get(0).getEvid());
			updateEvaluationContent(evaluationContentTB);
		}else{
			registEvaluationContent(evaluationContentTB);
		}
		//��ѯ�����µ���������
		ecCond = new EvaluationContentSearchCondImpl();
		ecCond.setPrid(evaluationContentTB.getPrid());
		
		return evaluationContentDAO.findByCond(ecCond, 0, 0);
	}

}