package nl.zdzislaw.verhuur_voertuig.repository;

import nl.zdzislaw.verhuur_voertuig.model.Assortment.Extras;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExtraRepository extends JpaRepository <Extras, Integer> {
    List<Extras> findAll();

}
