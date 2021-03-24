package io.springboot2.x.repository;

import io.springboot2.x.domain.NetflixUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface NetflixUserRepository extends JpaRepository<NetflixUser,String> {

    @Query("SELECT count(*) FROM NetflixUser WHERE phoneNor= :phoneNor and password= :password")
    Integer isVerifyPhoneNorAndPassword(@Param("phoneNor")String phoneNor, @Param("password")String password);
@Transactional
@Modifying
    @Query(value="UPDATE NetflixUser SET planId=:planId WHERE phoneNor=:phoneNor")
    public Integer updatePlan(@Param("phoneNor")String phoneNor,@Param("planId")String planId);

}
