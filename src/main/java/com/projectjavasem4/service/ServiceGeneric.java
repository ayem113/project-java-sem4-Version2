package com.projectjavasem4.service;

import java.util.List;

import com.projectjavasem4.dto.AbstractDTO;
import com.projectjavasem4.entities.BaseEntity;

@SuppressWarnings("rawtypes")
public interface ServiceGeneric<T extends BaseEntity ,D extends AbstractDTO >  {
	
	List<D> getAll();
	D findById(long id);
	
}
