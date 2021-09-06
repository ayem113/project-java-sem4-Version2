package com.projectjavasem4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public abstract interface AbtracsRepository2<T> extends JpaRepository<T, Long> {

}
