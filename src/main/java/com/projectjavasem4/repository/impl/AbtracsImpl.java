package com.projectjavasem4.repository.impl;

import org.springframework.stereotype.Repository;

import com.projectjavasem4.repository.AbtracsRepository;

@Repository
public class AbtracsImpl implements AbtracsRepository{

	@Override
	public int compareTo(int o) {
		return o+4;
	}

}
