package com.example.test.repository;

import com.example.test.model.InfoPurchaseUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface InfoPurchaseUserRepository extends CrudRepository<InfoPurchaseUser, Long> {

    @Query("SELECT ipu.purchaseItem.name, SUM (ipu.count) AS s FROM InfoPurchaseUser ipu WHERE ipu.purchaseDate BETWEEN :start AND :endd GROUP BY ipu.purchaseItem.name ORDER BY s DESC ")
    List<String> findPurchaseNameByMaxCountLastMonth(@Param("start") Date start, @Param("endd") Date endd);

    @Query("SELECT ipu FROM InfoPurchaseUser ipu WHERE ipu.purchaseDate BETWEEN :start AND :endd")
    List<InfoPurchaseUser> findByLastWeek(@Param("start") Date start, @Param("endd") Date endd);

    @Query("SELECT ipu.name, ipu.lastname, SUM (ipu.count) AS s FROM InfoPurchaseUser ipu WHERE ipu.purchaseDate BETWEEN :start AND :endd GROUP BY ipu.name, ipu.lastname ORDER BY s DESC ")
    List<String> findByMaxPurchaseHalfYear(@Param("start") Date start, @Param("endd") Date endd);

    @Query("SELECT ipu.purchaseItem.name, SUM (ipu.count) AS s FROM InfoPurchaseUser ipu WHERE ipu.age = ?1 GROUP BY ipu.purchaseItem.name ORDER BY s DESC ")
    List<String> findPurchaseNameByAge(Integer age);
}
