package com.kawai.service;

import com.kawai.dto.CommDtoBookinfo;


public interface CommServiceBookinfo {
	public int commBookinfoInsert(CommDtoBookinfo bookinfo);
	public int commBookinfoUpdate(CommDtoBookinfo bookinfo);
	public int commBookinfoDelete(int bookinfo_id);
}
