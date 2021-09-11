package com.projectjavasem4.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "users")
@Data

public class UserEntity extends BaseEntity {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final long OTP_VALID_DURATION = 2 * 60 * 1000;   // 5 minutes
	
	
	public boolean isOTPRequired() {
		/*
		 * if (this.getOneTimePassword() == null) { return false; }
		 */
         
        long currentTimeInMillis = System.currentTimeMillis();
        long otpRequestedTimeInMillis = this.otpRequestedTime.getTime();
         
        return (otpRequestedTimeInMillis + OTP_VALID_DURATION < currentTimeInMillis)?false:true;
        
        
    }
	
	
	@Column(name = "one_time_password")
    private String oneTimePassword;
     
    @Column(name = "otp_requested_time")
    private Date otpRequestedTime;
     

	@Column(name = "captcha")
	private String captcha;
	
	@Column(name = "sdt")
	private String sdt;
	
	@Column(name = "payments")
	private String payments;
	
	@Column(name = "username")
	private String username;
	@Column(name = "email")
	private String email;
	
	@Column(name = "otp")
	private String otp;
	@Column(name = "password")
	private String password;

	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "address",columnDefinition = "TEXT")
	private String address;
	
	@Column(name = "img",columnDefinition = "TEXT")
	private String img;

	@Column(name="stt")
	private Integer stt;
	
	@OneToMany(mappedBy = "user")
	private List<OrderEntity> orders = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	private List<CommentEntity> comments = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_role",nullable=false)
	
	
	private RoleEntity role;

	
	
	
	
	
	

}
