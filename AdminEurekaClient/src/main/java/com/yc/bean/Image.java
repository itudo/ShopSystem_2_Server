package com.yc.bean;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Component
public class Image implements Serializable{
	private static final long serialVersionUID = 7611674282375284712L;
	private Integer image_id;
	private String image_path;
	private GoodsDetail goodsDetail;
	
}
