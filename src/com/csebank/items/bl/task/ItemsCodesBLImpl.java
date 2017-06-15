package com.csebank.items.bl.task;

import java.util.List;

import com.csebank.items.model.ItemsCodes;
import com.csebank.items.model.condition.ItemsCodesSearchCondImpl;
import com.csebank.items.model.dao.ItemsCodesTBDAO;
import com.csebank.items.model.entity.ItemsCodesTB;
import com.deliverik.framework.base.BaseBLImpl;

public class ItemsCodesBLImpl extends BaseBLImpl implements ItemsCodesBL{
	
	private ItemsCodesTBDAO itemsCodesTBDAO;

	public void setItemsCodesTBDAO(ItemsCodesTBDAO itemsCodesTBDAO) {
		this.itemsCodesTBDAO = itemsCodesTBDAO;
	}

	public List<ItemsCodes> getItemsCodesList(String selectid) {
		ItemsCodesSearchCondImpl cond = new ItemsCodesSearchCondImpl();
		cond.setSelectid(selectid);
		List<ItemsCodes> itemsCodesList = itemsCodesTBDAO.findByCond(cond, 0, 0);
		return itemsCodesList;
	}

	public List<ItemsCodes> findAll() {
		return itemsCodesTBDAO.findAll();
	}

	public ItemsCodes changeStatus(String selectId, String status) {
		ItemsCodesSearchCondImpl cond = new ItemsCodesSearchCondImpl();
		cond.setSelectid(selectId);
		ItemsCodes itemsCodes = itemsCodesTBDAO.findByCond(cond, 0, 0).get(0);
		ItemsCodesTB itemsCodesTB = (ItemsCodesTB)itemsCodes;
		itemsCodesTB.setStatus(status);
		itemsCodes = itemsCodesTBDAO.save(itemsCodesTB);
		return itemsCodes;
	}

}
