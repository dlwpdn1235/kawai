package com.kawai.dao;

import com.kawai.dto.CommDtoBookinfo;


public interface CommDaoBookinfo {
	public int commBookinfoInsert(CommDtoBookinfo bookinfo);
	public int commBookinfoUpdate(CommDtoBookinfo bookinfo);
	public int commBookinfoDelete(int bookinfo_id);
}
