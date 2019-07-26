package com.yc.biz;

import java.util.List;

import com.yc.bean.Address;
import com.yc.bean.Users;

public interface AddressBiz {
	/**
	 * 添加地址
	 * @param address
	 * @return
	 */
    public int InsertAddr(Address address);
    /**
     * 更新地址
     * @param address
     * @return
     */
    public boolean updateAddr(Address address);
    
    public boolean updateStatus(Address address);
    /**
     * 根据id查找地址
     * @param id
     * @return
     */
    public List<Address> getAddressById(Users user);
    
    public Address getAddressByStatus(Address address);
    
    /**
	 * 删除单条地址
	 * @param addrid
	 * @return
	 */
	public boolean  delSingleAddress(Integer  addrid);
	boolean setDefault(Address address);
}
