package nl.zdzislaw.verhuur_voertuig.service;

import nl.zdzislaw.verhuur_voertuig.model.Assortment.Extras;
import nl.zdzislaw.verhuur_voertuig.repository.ExtraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExtraService {
    private ExtraRepository extraRepository;

    public ExtraService(ExtraRepository extraRepository) {
        this.extraRepository = extraRepository;
    }
    public void addExtras(Extras extras){
        extraRepository.save(extras);
    }

    public List<Extras> showAllExtras(){
        List<Extras>allExtras=extraRepository.findAll();
        return allExtras;
    }
}
