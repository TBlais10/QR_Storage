package com.qr_storeage.QR_StoragePt2.Controllers.History;

import com.qr_storeage.QR_StoragePt2.Models.History.History;
import com.qr_storeage.QR_StoragePt2.Repositories.DeveloperRepository;
import com.qr_storeage.QR_StoragePt2.Repositories.HistoryRepository;
import com.qr_storeage.QR_StoragePt2.Repositories.ItemRepository;
import com.qr_storeage.QR_StoragePt2.Repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping
@RestController("api/history")
public class HistoryController {

    @Autowired
    private HistoryRepository repository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private DeveloperRepository developerRepository;

        @GetMapping
        public @ResponseBody List<History> getAll(){
            return repository.findAll();
        }

    }
