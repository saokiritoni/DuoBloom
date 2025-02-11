package POT.DuoBloom.domain.hospital.repository;

import POT.DuoBloom.domain.hospital.entity.HospitalScrap;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HospitalScrapRepository extends JpaRepository<HospitalScrap, Long> {
    boolean existsByHospital_HospitalIdAndUser_UserId(Integer hospitalId, Long userId);

    //List<HospitalScrap> findByUser_UserId(Long userId);
    //Optional<HospitalScrap> findByHospital_HospitalIdAndUser_UserId(Integer hospitalId, Long userId);

    @Query("SELECT hs FROM HospitalScrap hs " +
            "JOIN FETCH hs.hospital h " +
            "JOIN FETCH hs.user u " +
            "WHERE u.userId = :userId")
    List<HospitalScrap> findByUser_UserId(@Param("userId") Long userId);

    @Query("SELECT hs FROM HospitalScrap hs " +
            "JOIN FETCH hs.hospital h " +
            "JOIN FETCH hs.user u " +
            "WHERE h.hospitalId = :hospitalId AND u.userId = :userId")
    Optional<HospitalScrap> findByHospital_HospitalIdAndUser_UserId(
            @Param("hospitalId") Integer hospitalId,
            @Param("userId") Long userId
    );
}


