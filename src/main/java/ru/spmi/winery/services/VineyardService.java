package ru.spmi.winery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spmi.winery.entities.Vineyard;
import ru.spmi.winery.repositories.VineyardRepository;

import java.util.List;

@Service
public class VineyardService {

    @Autowired
    private VineyardRepository vineyardRepository;

    public List<Vineyard> getAllVineyards() {
        return vineyardRepository.findAll();
    }

}
