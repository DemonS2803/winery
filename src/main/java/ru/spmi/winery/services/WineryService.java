package ru.spmi.winery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.spmi.winery.entities.Winery;
import ru.spmi.winery.repositories.WineryRepository;

import java.util.List;

@Service
public class WineryService {

    @Autowired
    private WineryRepository wineryRepository;

    public List<Winery> getAllWineries() {
        return wineryRepository.findAll(Sort.by("id"));
    }

}
