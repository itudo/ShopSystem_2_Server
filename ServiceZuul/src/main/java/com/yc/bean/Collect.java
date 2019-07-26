package com.yc.bean;

import java.io.Serializable;


import lombok.Data;
@Data

/**
 * 商品收藏表collect
 * @author Administrator
 *
 */
public class Collect implements Serializable   {
	private static final long serialVersionUID = 5096419959602765963L;
	private Integer Collect_id ;
	private Integer User_id ;
	private Goods goods ;  //goods_id

}
