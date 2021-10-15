package com.projectjavasem4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.projectjavasem4.entities.ProductDetailEntity;

public interface ProductDetailRepository extends JpaRepository<ProductDetailEntity, Long>{
	@Query(nativeQuery = true, value = "SELECT * FROM product_detail where id_product =:id group by id_color") // 3. Spring JPA In cause
	List<ProductDetailEntity> colorGroup(@Param("id") Long id);
	
	@Query(nativeQuery = true, value = "SELECT * FROM product_detail where id_product =:id group by id_size") // 3. Spring JPA In cause
	List<ProductDetailEntity> sizeGroup(@Param("id") Long id);
	
	@Query(nativeQuery = true, value = "SELECT * FROM product_detail where id_color= :id_color AND  id_size= :id_size AND id_product= :id_product")
	ProductDetailEntity findProIdsizeAndIdColor(@Param("id_size") Long id_size,@Param("id_color") Long id_color,@Param("id_product") Long id_product);
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "insert into product_detail (id_color,id_size,id_product,quantity) values(:idColor,:idSize,:idPro,:soluong)") 
	void insertProductDetail(@Param("idSize")long idSize, @Param("idColor") long idColor, @Param("idPro") Long idPro,@Param("soluong") int soluong);

	@Query(nativeQuery = true, value = "SELECT * FROM product_detail where id_size=:idSize and id_color=:idColor") 
	ProductDetailEntity findByIdColorAndIdSize(@Param("idSize")long idSize, @Param("idColor") long idColor);

	
}
