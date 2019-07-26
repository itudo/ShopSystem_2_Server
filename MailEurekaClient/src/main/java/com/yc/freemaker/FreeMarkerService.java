package com.yc.freemaker;

import java.util.List;
import java.util.Map;

public interface FreeMarkerService {
	public void getHtml(Map<String,Object> map,String tempName,String htmlName);
}
