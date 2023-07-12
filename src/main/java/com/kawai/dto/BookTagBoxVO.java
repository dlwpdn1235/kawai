package com.kawai.dto;

import lombok.Data;

@Data
public class BookTagBoxVO {
	private int box_no;
	private int bs_no;
	private int tag_id;
	private String bs_name; // 추가
    private String tag_name; // 추가
    private String selected_tagname;
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + bs_no;
        result = prime * result + tag_id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BookTagBoxVO other = (BookTagBoxVO) obj;
        if (bs_no != other.bs_no)
            return false;
        if (tag_id != other.tag_id)
            return false;
        return true;
    }
}
