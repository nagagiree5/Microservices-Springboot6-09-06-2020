package io.springboot2.x.repository;

import io.springboot2.x.domain.NetflixDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface NetflixDeviceRepository extends JpaRepository<NetflixDevice,Integer> {

    @Query("SELECT count(*) FROM NetflixDevice WHERE mobile= :phoneNor and device= :device")
    Integer isDeviceExistOrNot(@Param("phoneNor")String phoneNor, @Param("device")String device);

/*    @Query("SELECT device FROM NetflixDevice WHERE mobile= :phoneNor")
    List<String> friendDevicesContactNumber(@Param("phoneNor")String phoneNor);*/

    List<NetflixDevice> findByMobile(String phoneNor);
    @Transactional
    @Modifying
    Integer deleteByMobile(String phoneNor);

}
