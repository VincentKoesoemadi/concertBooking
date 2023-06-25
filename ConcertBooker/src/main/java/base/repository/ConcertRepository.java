package base.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import base.model.Concert;

@Repository
public interface ConcertRepository extends JpaRepository<Concert, Long> {

    @Query(value = "SELECT * FROM Concert WHERE venue = :venue", nativeQuery = true)
    List<Concert> getConcertByVenue(@Param("venue") String venue);
}
