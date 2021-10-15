package com.projectjavasem4.entities;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
@Table(name = "orders")
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@Column(name = "detail_address", columnDefinition = "TEXT")
	private String detail_address;
	
	@Column(name = "general_address", columnDefinition = "TEXT")
	private String general_address;
	
	@Column(name = "customer_name", columnDefinition = "TEXT")
	private String customer_name;
	
	@Column(name = "sdt")
	private String sdt;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "code") //mã đơn hàng
	private String code;
	
	@Column(name = "stt")
	private String stt;
	
	@Column(name = "total_price")
	private String total_price;
	
	@Column(name = "code_sale") //mã giảm giá
	private String code_sale;
	
	@Column(name = "payment_methods", nullable = true)
	private String payment_methods;
	
	//@ColumnDefault(value = "Chờ xác nhậnn")
	@Column(name = "delivery_status",columnDefinition = "varchar(50) default 'Chờ xác nhận'" )  // k set duowcj defaul
	private String delivery_status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user")
	private UserEntity user;
	
	@OneToMany(mappedBy = "order")
	private List<OrderDetailEntity> orderDetails = new ArrayList<>();

}
