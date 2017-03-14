package com.deliverik.infogovernor.cic.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.infogovernor.cic.bl.task.CompareobjectBL;
import com.deliverik.infogovernor.cic.bl.task.CompareroleBL;
import com.deliverik.infogovernor.cic.dto.IGCIC01DTO;
import com.deliverik.infogovernor.cic.form.IGCIC0101Form;
import com.deliverik.infogovernor.cic.form.IGCIC0102Form;
import com.deliverik.infogovernor.cic.model.CompareobjectInfo;
import com.deliverik.infogovernor.cic.model.CompareroleInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareobjectSearchCondImpl;
import com.deliverik.infogovernor.cic.model.condition.CompareroleSearchCondImpl;
import com.deliverik.infogovernor.cic.model.entity.CompareobjectTB;
import com.deliverik.infogovernor.cic.model.entity.CompareroleTB;
import com.google.gson.Gson;


/**
 * �Աȹ���ҵ���߼�ʵ��
 *
 */
public class IGCIC01BLImpl extends BaseBLImpl implements IGCIC01BL {

	static Log log = LogFactory.getLog(IGCIC01BLImpl.class);

	private CompareroleBL compareroleBL;
	private CompareobjectBL compareobjectBL;
	private SOC0118BL soc0118BL;
	

	public void setCompareobjectBL(CompareobjectBL compareobjectBL) {
		this.compareobjectBL = compareobjectBL;
	}



	public void setSoc0118BL(SOC0118BL soc0118bl) {
		soc0118BL = soc0118bl;
	}



	public void setCompareroleBL(CompareroleBL compareroleBL) {
		this.compareroleBL = compareroleBL;
	}



	/**
	 * ��ѯ�ȽϹ���
	 */
	public IGCIC01DTO searchCompareRoleList(IGCIC01DTO dto) throws BLException{
		
		IGCIC0101Form from = dto.getIgcic0101Form();
		
		CompareroleSearchCondImpl cond = new CompareroleSearchCondImpl();
		
		BeanUtils.copyProperties(from, cond);
		
		List<CompareroleInfo> crList = compareroleBL.searchComparerole(cond);
		
		dto.setCrList(crList);
		
		return  dto;
	}
	/**
	 * ��ѯҵ��ϵͳ
	 */
	public IGCIC01DTO getSystemList(IGCIC01DTO dto)throws BLException{
		
		SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		
		cond.setEid("CM03010001");
		
		List<SOC0118Info> systemList = soc0118BL.searchEntityItem(cond);
		
		dto.setSystemList(systemList);
		
		return dto;
	}
	
	/**
	 * ����ҵ��ϵͳid�ͻ������Ͳ�ѯ����
	 * @param systemId
	 * @return
	 */
	public List<Map<String,String>> searchHostList(Integer systemId,String crtype)throws BLException{
		
		List<Map<String,String>> result  = new ArrayList<Map<String,String>>();
		
		SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		
		cond.setSystemId(systemId);
		//crtype ���ֻ����λ��ֻ�Ǹ��ݻ������в�ѯ �����4λ ���ʾ��ѯָ�������ļ�Ⱥ��
		if(StringUtils.isNotEmpty(crtype)){
			String environmentType = crtype.substring(0, 3);
			cond.setEnvironmentType(environmentType);
			if(crtype.length()>3){
				cond.setClumped(true);
			}
		}else{
			cond.setEnvironmentType("146");
		}
		
		result = soc0118BL.searchHostList(cond);
		
		return result;
	}
	
	/**
	 * ���Աȹ����Ƿ����,��������ڷ���null �����ѯ���ù������Ϣ
	 * @param systemId
	 * @param crtype
	 * @return
	 * @throws BLException
	 */
	public Map<String,Object> checkCompareRole(Integer systemId,String crtype)throws BLException{
		Map<String,Object> result =null;
		
		CompareroleSearchCondImpl cond = new CompareroleSearchCondImpl();
		cond.setCrsystemid(systemId);
		if(crtype==null){
			return null;
		}
		cond.setCrtype(crtype);
		List<CompareroleInfo> crList = compareroleBL.searchComparerole(cond);
		result = new HashMap<String, Object>();
		List<Map<String,String>> sourceHostList = null;
		//���ݶԱȹ����ȡ�Ա�Դ�����б�
		//����Ա����ʹ�����λ ���ǱȽϼ�Ⱥ�ڵ����� Ŀ��������װ�Ա������еĻ���ѡ�� 
		//����Ŀ������λ���������е�����
		if(crtype.length()>3){
			sourceHostList= this.searchHostList(systemId, crtype);
		}else{
			sourceHostList= this.searchHostList(systemId, null);
		}
		List<Map<String,String>> targetHostList = this.searchHostList(systemId, crtype);
		result.put("sourceHostList", sourceHostList);
		result.put("targetHostList", targetHostList);
		//���ݶԱȹ����ȡ�Ա�Ŀ�������б�
		if(crList.size()>0){
			CompareroleInfo crInfo = crList.get(0);
			//��ȡ�Աȶ�����Ϣ
			CompareobjectSearchCondImpl coCond = new CompareobjectSearchCondImpl();
			coCond.setFkCrid_eq(crInfo.getCrid());
			List<CompareobjectInfo> coList = compareobjectBL.searchCompareobject(coCond);
			result.put("crInfo", crInfo);
			result.put("coList", coList);
		}
		return result;
		
	}
	
	/**
	 * ����Աȹ���ķ���
	 */
	public IGCIC01DTO insertIgcic0102Action(IGCIC01DTO dto)throws BLException{
		IGCIC0102Form form = dto.getIgcic0102Form();
		CompareroleInfo crInfo = null;
		//������²���
		if(form.getCrid()==null||form.getCrid()==0){
			CompareroleTB crTb = new CompareroleTB();
			crTb.setCrname(form.getCrname());
			crTb.setCrsystemid(form.getCrsystemid());
			crTb.setCrsystemname(form.getCrsystemname());
			crTb.setCrtype(form.getCrtype());
			crTb.setCrversion(0);
			if(form.getCsid()==null||form.getCsid()==0){
				crTb.setFkCsid(1);
			}else{
				crTb.setFkCsid(form.getCsid());
			}
			crInfo = compareroleBL.save(crTb);
			form.setCrid(crInfo.getCrid());
		}
		
		//���뱾�Աȹ�������ĶԱȶ���ת�Ƶ���ʷ����
		CompareroleTB crTb = (CompareroleTB)compareroleBL.searchCompareroleByPK(form.getCrid());
		crTb.setCrversion(crTb.getCrversion()+1);
		crInfo = crTb;
		
		//����Աȶ���
		String[] obNameArr = form.getCompareObjectName();
		List<CompareobjectInfo>  coList = new ArrayList<CompareobjectInfo>();
		for (int i=0;i< obNameArr.length;i++) {
			CompareobjectTB coTb = new CompareobjectTB();
			String[] parArr =  obNameArr[i].split("#");
			coTb.setConame("");
			coTb.setFkCrid(crInfo.getCrid());
			coTb.setCrversion(crInfo.getCrversion());
			coTb.setCosource(Integer.valueOf(parArr[1]));
			coTb.setCotarget(Integer.valueOf(parArr[3]));
			coTb.setSourceIP(parArr[2].split("_")[0]);
			coTb.setTargetIP(parArr[4].split("_")[0]);
			coList.add(coTb);
		}
		compareobjectBL.save(coList);
		
		compareroleBL.updateComparerole(crInfo);
		compareobjectBL.toHistory(crInfo.getCrid());
		
		return dto;
	}
	/**
	 * �鿴ʱ ���ضԱȹ�����ϸ��Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIC01DTO loadCompareRoleInfo(IGCIC01DTO dto)throws BLException{
		
		IGCIC0102Form form = dto.getIgcic0102Form();
		//��ȡ�Աȹ�����Ϣ
		CompareroleInfo crInfo = compareroleBL.searchCompareroleByPK(form.getCrid());
		dto.setCompareRoleInfo(crInfo);
		form.setCrsystemid(crInfo.getCrsystemid());
		form.setCrtype(crInfo.getCrtype());
		//���ݶԱȹ����ȡ�Ա�Դ�����б�
		List<Map<String,String>> sourceHostList = this.searchHostList(crInfo.getCrsystemid(), null);
		dto.setSourceHostList(sourceHostList);
		//���ݶԱȹ����ȡ�Ա�Ŀ�������б�
		List<Map<String,String>> targetHostList = this.searchHostList(crInfo.getCrsystemid(), crInfo.getCrtype());
		dto.setTargetHostList(targetHostList);
		//��ȡ�Աȶ�����Ϣ
		CompareobjectSearchCondImpl cond = new CompareobjectSearchCondImpl();
		cond.setFkCrid_eq(crInfo.getCrid());
		List<CompareobjectInfo> coList = compareobjectBL.searchCompareobject(cond);
		Gson gson = new Gson();
		dto.setCompareObjectListJson(gson.toJson(coList));
		
		return dto;
	}
	
	public IGCIC01DTO delCompareRole(IGCIC01DTO dto)throws BLException{
		IGCIC0101Form form = dto.getIgcic0101Form();
		compareroleBL.deleteCompareroleByPK(form.getCrid());
		compareobjectBL.delByCrid(form.getCrid());
		return dto;
	}

}
