package com.yc.model;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;
/**
 * 更改controller该接口对应方法接收的参数List<Integer>
 * @author adeline
 * @date 2018年9月3日
 * @TODO
 */
@Data
@Component
public class ParameterVO {
	private List<Integer> ids;

}
