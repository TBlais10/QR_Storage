package com.qr_storeage.QR_StoragePt2.Controllers.Facility;

import com.qr_storeage.QR_StoragePt2.Repositories.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Facility")
public class FacilityController {

    @Autowired
    FacilityRepository repository;


}
