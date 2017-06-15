package com.deliverik.infogovernor.crc.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.infogovernor.crc.bl.task.IGCRC1301BL;
import com.deliverik.infogovernor.crc.bl.task.IGCRC1303BL;
import com.deliverik.infogovernor.crc.bl.task.IGCRC1304BL;
import com.deliverik.infogovernor.crc.dto.IGCRC1301DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC1302DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC1303DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC1304DTO;
import com.deliverik.infogovernor.crc.form.IGCRC1301Form;
import com.deliverik.infogovernor.crc.form.IGCRC1303Form;
import com.deliverik.infogovernor.crc.form.IGCRC1304Form;
import com.deliverik.infogovernor.crc.model.IGCRC1301VWInfo;
import com.deliverik.infogovernor.crc.model.IGCRC1303VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1301CondImpl;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1303Cond;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1303CondImpl;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1304CondImpl;
import com.deliverik.infogovernor.crc.model.entity.DepartModelVW;
import com.deliverik.infogovernor.crc.model.entity.IGCRC1301VW;
import com.deliverik.infogovernor.crc.model.entity.ModelVW;

/**
 * �ĵ���ѯҵ���߼�ʵ��
 *
 */
public class IGCRC13BLImpl implements IGCRC13BL {

	static Log log = LogFactory.getLog(IGCRC13BLImpl.class);
	
	/** �ĵ���ϢBL */
	protected IGCRC1301BL igcrc1301BL;
	
	/** �ĵ���Ϣͳ��BL */
	protected IGCRC1303BL igcrc1303BL;
	
	/** �����ĵ�ͳ����ϢBL */
	protected IGCRC1304BL igcrc1304BL;
	
	/** ���̲�ѯ����API */
	protected SysManageBL sysManageBL;
	
	/**���̴���BL*/
	protected WorkFlowOperationBL workFlowOperationBL;

	/**
	 * ���̴���BL�趨
	 * @param workFlowOperationBL ���̴���BL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	public void setIgcrc1301BL(IGCRC1301BL igcrc1301bl) {
		igcrc1301BL = igcrc1301bl;
	}
	
	public void setSysManageBL(SysManageBL sysManagebl) {
		sysManageBL = sysManagebl;
	}

	public void setIgcrc1303BL(IGCRC1303BL igcrc1303bl) {
		igcrc1303BL = igcrc1303bl;
	}

	public void setIgcrc1304BL(IGCRC1304BL igcrc1304bl) {
		igcrc1304BL = igcrc1304bl;
	}

	/**
	 * �ĵ���Ϣ��ѯ����
	 *
	 * @param dto IGCRC1301DTO
	 * @return IGCRC1301DTO
	 */
	public IGCRC1301DTO searchEntityItemAction(IGCRC1301DTO dto)
			throws BLException {
		log.debug("========�ĵ���Ϣ��ѯ����ʼ========");
		IGCRC1301Form form = dto.getIgcrc1301Form();
		
		IGCRC1301CondImpl cond = new IGCRC1301CondImpl();
		
		BeanUtils.copyProperties(form, cond);
		
		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		List<IGCRC1301VWInfo> crList = igcrc1301BL.searchIGCRC1301(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(igcrc1301BL.getSearchCount(cond));
		dto.setEntityItemVWInfoList(crList);
		
		//��ȡ�û���ɫ�б�
		List<Integer> roleList  = sysManageBL.searchRoleListByUserid(dto.getUser().getUserid());
		
		String isManeger = "";
		
		for(int i=0;i<roleList.size();i++){
//			if(roleList.get(i) == 3002 ||  roleList.get(i) == 3003 || roleList.get(i) == 3004 ){
//				dto.setIsManeger("1");
//				break;
//			}
			if (roleList.get(i) == 3002) {
				isManeger += "_�Ƽ�������";
			} else if (roleList.get(i) == 3003) {
				isManeger += "_���������";
			} else if (roleList.get(i) == 3004) {
				isManeger += "_����������";
			}
		}		
		if (StringUtils.isNotEmpty(isManeger)) {
			isManeger = isManeger.substring(1);
		}
		
		dto.setIsManeger(isManeger);
		
		log.debug("========�ĵ���Ϣ��ѯ��������========");
		return dto;
	}
	/**
	 * �����ĵ�ͳ�ƴ���
	 *
	 * @param dto IGCRC1301DTO
	 * @return IGCRC1301DTO
	 */
	public IGCRC1303DTO searchEntitySumAction(IGCRC1303DTO dto) throws BLException{
		// TODO Auto-generated method stub
		log.debug("========�ĵ�����ͳ�Ʋ�ѯ����ʼ========");
		IGCRC1303Form form = dto.getIgcrc1303Form();
		
		IGCRC1303CondImpl cond = new IGCRC1303CondImpl();
		
		BeanUtils.copyProperties(form, cond);	
		
		StringBuffer type = new StringBuffer();
		type.append(form.getEiSort());
		if(form.getEiSort()!= null && !type.toString().contains("-")){
			type.append("%");
			cond.setEiSort(type.toString());
		}

		//��ҳ����Ϣȡ��		
		PagingDTO pDto = dto.getPagingDto();
		List<IGCRC1303VWInfo> crList = igcrc1303BL.searchIGCRC1303(cond, pDto.getFromCount(), pDto.getPageDispCount());

		Map<String,Integer> maps = new HashMap<String, Integer>();
		List<ModelVW> vwList = new ArrayList<ModelVW>();
		if(crList.size()!=0){
			/**����ȥ��,������ͳ�� **/
			
			List<String> typeList = new ArrayList<String>();
			
			for(int i =0 ;i<crList.size();i++){
				String temp = crList.get(i).getEiSort();
				typeList.add(temp);
			}
			//ȥ�أ�ȥ����ͬ��
			Set<String> sets = new HashSet<String>(typeList);
			
			Object[] strs = (Object[]) sets.toArray();
			//�鿴ÿһ�������
			for(int i = 0;i<strs.length;i++){
				ModelVW model = new ModelVW();
				
				String[] str1 = ((String) strs[i]).split("_");
				
				model.setTypeid(str1[0]);
				
				int y = getSum1(crList,(String)strs[i]);
				
				model.setType(str1[str1.length-1]);

				model.setWordSum(y);

				vwList.add(model);
			}
			
		}else{
			
			String str = form.getEiSort();
			ModelVW model = new ModelVW();
			if(str!=null && !(str.equals(""))){
				model.setType(str);
				model.setWordSum(0);
				vwList.add(model);
			}
//			int z = getReadSum(listMap,str);
//			model.setReadSum(z); 
		}
		dto.setListVM(vwList);
		pDto.setTotalCount(vwList.size());
		dto.setEntityItemVWInfoList(crList);
		
		//��ȡ�û���ɫ�б�
		List<Integer> roleList  = sysManageBL.searchRoleListByUserid(dto.getUser().getUserid());
		
		for(int i=0;i<roleList.size();i++){
			if(roleList.get(i) == 3002 ||  roleList.get(i) == 3003 || roleList.get(i) == 3004 ){
				dto.setIsManeger("1");
				break;
			}
		}
		log.debug("========�ĵ�����ͳ�Ʋ�ѯ����ʼ========");		
		return dto;
	}


	/**
	 * �������˲��Ų�ѯͳ�ƴ���
	 *
	 * @param dto IGCRC1301DTO
	 * @return IGCRC1301DTO
	 */
	public IGCRC1304DTO searchDepartSumAction(IGCRC1304DTO dto) throws BLException{
		log.debug("========�ĵ�����ͳ�Ʋ�ѯ����ʼ========");
		IGCRC1304Form form = dto.getIgcrc1304Form();
		IGCRC1304CondImpl cond = new IGCRC1304CondImpl();

		BeanUtils.copyProperties(form, cond);
		String department = form.getDepartment();
		if(department!=null){
			if(department.equals("��Ϣ�Ƽ���")){
				department = "�Ƽ���";
				cond.setDepartment(department);
			}
		}
		
		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		List<IGCRC1303VWInfo> crList = igcrc1304BL.searchIGCRC1304(cond, pDto.getFromCount(), pDto.getPageDispCount());
		List<String> condList = igcrc1304BL.searchDownDepart();
		
		List<String> listMap = igcrc1304BL.searchType();
		
		List<DepartModelVW> vwList = new ArrayList<DepartModelVW>();
		
		
		//�жϲ�ѯ�Ľ���Ƿ�Ϊ�գ����Ϊ�յĻ���ֱ���������0
		if(crList.size()!=0){
			List<String> typeList = new ArrayList<String>();
			//ѡ�������ĵ��ʲ�������
			for(int i =0 ;i<crList.size();i++){
				String temp = crList.get(i).getEiName();
				typeList.add(temp);
			}
			//�鿴ÿһ�������
			for(int i = 0;i<crList.size();i++){
				int x = getDownSun(condList,crList.get(i).getEiName());
				DepartModelVW model = new DepartModelVW();
				model.setEiname(typeList.get(i));
				model.setEiid(crList.get(i).getEiid());
				model.setDowSum(x);
				int z = getReadSum(listMap,crList.get(i).getEiName());
				model.setReadSum(z);
				vwList.add(model);
			}
		}
		dto.setListVM(vwList);
		pDto.setTotalCount(vwList.size());
		dto.setEntityItemVWInfoList(crList);
		
		
		//��ȡ�û���ɫ�б�
		List<Integer> roleList  = sysManageBL.searchRoleListByUserid(dto.getUser().getUserid());
		
		for(int i=0;i<roleList.size();i++){
			if(roleList.get(i) == 3002 ||  roleList.get(i) == 3003 || roleList.get(i) == 3004 ){
				dto.setIsManeger("1");
				break;
			}
		}
		log.debug("========�ĵ�����ͳ�Ʋ�ѯ����ʼ========");	
		return dto;
	}
	
	/**
	 * �ĵ���Ϣ��ѯ����
	 *
	 * @param dto IGCRC1301DTO
	 * @return IGCRC1301DTO
	 */
	public IGCRC1301DTO searchItemAction(IGCRC1301DTO dto)
			throws BLException {
		log.debug("========�ĵ���ϸ��Ϣ��ѯ����ʼ========");
		IGCRC1301Form form = dto.getIgcrc1301Form();
		
		IGCRC1301CondImpl cond = new IGCRC1301CondImpl();
		
		BeanUtils.copyProperties(form, cond);
		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		List<IGCRC1301VWInfo> crList = igcrc1301BL.searchIGCRC1302(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		
		List<IGCRC1301VWInfo> finalList = new ArrayList<IGCRC1301VWInfo>();
		String type = dto.getType();
		if(type!=null && !(type.equals(""))){
			for(int i =0 ;i<crList.size();i++){
				String[] temp = crList.get(i).getEiSort().split("_");
				if(temp[0].equals(type)){
					IGCRC1301VW igcrc1301vw = (IGCRC1301VW) crList.get(i);
					igcrc1301vw.setEiSort(type);
					finalList.add(igcrc1301vw);
				}
			}
		}else{
			for(int i =0 ;i<crList.size();i++){
				IGCRC1301VW igcrc1301vw = (IGCRC1301VW) crList.get(i);
				if(crList.get(i).getEiSort()!=null){
					String[] temp = crList.get(i).getEiSort().split("_");
					igcrc1301vw.setEiSort(temp[0]);
				}
				finalList.add(igcrc1301vw);
			}
		}
		dto.setEntityItemVWInfoList(finalList);
		pDto.setTotalCount(finalList.size());
		log.debug("========�ĵ���ϸ��Ϣ��ѯ��������========");
		return dto;
	}

	/**
	 * �õ��ü��������ַ���ƥ�������
	 * @param listMap
	 * @param str
	 * @return
	 */
	private int getReadSum(List<String> listMap, String str) {
		// TODO Auto-generated method stub
		int x = 0;
		for(int i = 0;i<listMap.size()&&str!=null;i++){
			String[] strs = listMap.get(i).split("_");
			//��ȡһ������
			String[] strs2 = strs[strs.length-1].split("-");
			if(str.equals(strs2[0])){
				x++;
			}
		}
		return x;
	}

	/**
	 * �ж�ĳ��Ԫ����List �����еĸ���
	 * @param crList
	 * @param string
	 * @return
	 */
	private int getSum(List<IGCRC1303VWInfo> crList, String str) {
		// TODO Auto-generated method stub
		int x = 0;
		for(int i=0;i<crList.size()&&str!=null;i++){
			String[] strs = crList.get(i).getDepartment().split("-");
			if(str.equals(strs[0])){
				x++;
			}	
		}
		return x;
	}
	/**
	 * �ж�ĳ��Ԫ����List �����еĸ���
	 * @param crList
	 * @param string
	 * @return
	 */
	private int getSum1(List<IGCRC1303VWInfo> crList, String str) {
		// TODO Auto-generated method stub
		int x = 0;
		for(int i=0;i<crList.size()&&str!=null;i++){
			if(str.equals(crList.get(i).getEiSort())){
				x++;
			}	
		}
		return x;
	}
	/**
	 * ������ÿ�����ŵ���������
	 * @param condList
	 * @param object
	 * @return
	 */
	private int getDownSun(List<String> condList, String str) {
		// TODO Auto-generated method stub
		int x = 0;
		for(int i =0;i<condList.size()&&str!=null;i++){
			if(str.equals(condList.get(i))){
				x++;
			}
		}
		return x;
	}
	
	
	/**
	 * �ĵ���Ϣ��ѯ����
	 *
	 * @param dto IGCRC1301DTO
	 * @return IGCRC1301DTO
	 */
	public IGCRC1301DTO openSearchEntityItemAction(IGCRC1301DTO dto)
			throws BLException {
		log.debug("========�ĵ���Ϣ��ѯ����ʼ========");
		IGCRC1301Form form = dto.getIgcrc1301Form();
		
		IGCRC1301CondImpl cond = new IGCRC1301CondImpl();
		
		BeanUtils.copyProperties(form, cond);
		//��ѯ�Ƿ������Ϊ���񡯵�
		cond.setIsDownload("��");
		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		List<IGCRC1301VWInfo> crList = igcrc1301BL.searchIGCRC1301(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(igcrc1301BL.getSearchCount(cond));
		dto.setEntityItemVWInfoList(crList);
		
		log.debug("========�ĵ���Ϣ��ѯ��������========");
		return dto;
	}
	
	public IGCRC1304DTO searchIG500ItemAction(IGCRC1304DTO dto)throws BLException{
		
		IGCRC1304Form form = dto.getIgcrc1304Form();
		IGCRC1304CondImpl cond = new IGCRC1304CondImpl();

		
		BeanUtils.copyProperties(form, cond);
		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();		
		
		List<Integer> IdList = igcrc1304BL.searchTypeID(cond);
		
		IG500SearchCondImpl condIg500 = new IG500SearchCondImpl();
		
		// ����������ͱ��
		condIg500.setPrpdid("0112001");

		// ��ѯ������Ϣ
		dto.setProcessList(workFlowOperationBL.searchProcessByType(condIg500, 0, 0,null));
		
		List<IG500Info> ig500 = dto.getProcessList();
		
		List<IG500Info> ig500final = new ArrayList<IG500Info>();

		if(IdList.size()<1){
			dto.setProcessList(ig500final);
		}else{
			for(int i =0;i<ig500.size();i++){
				for(int j=0;j<IdList.size();j++){
					Integer prid = IdList.get(j);
					if(ig500.get(i).getPrid().equals(prid)){
						ig500final.add(ig500.get(i));
					}
				}
			}
			dto.setProcessList(ig500final);
		}
		pDto.setTotalCount(ig500final.size());
		return dto;
	}
	
	
	/**
	 * �ҵĽ��ģ���ȡ�û�������ĵ�����
	 *
	 * @param dto IGCRC1302DTO
	 * @return IGCRC1302DTO
	 */
	public IGCRC1302DTO getWorkInitByMe(IGCRC1302DTO dto) throws BLException {
		log.debug("========��ȡ�ҵ��ĵ����Ŀ�ʼ========");
		String userId = dto.getUserId();
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		cond.setPrpdid("0112001");//�ĵ���������
		cond.setPruserid(userId);
		List<IG500Info> processRecords = workFlowOperationBL.searchProcessRecordSubStatusList(cond, 0, 0);
		dto.setEntityItemInfoList(processRecords);
		log.debug("========��ȡ�ҵ��ĵ����Ľ���========");
		return dto;
	}

	
	
	
}
