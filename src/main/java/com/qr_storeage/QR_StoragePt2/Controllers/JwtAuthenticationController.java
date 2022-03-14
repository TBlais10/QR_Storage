package com.qr_storeage.QR_StoragePt2.Controllers;

import com.qr_storeage.QR_StoragePt2.Service.JwtUserDetailsService;
import com.qr_storeage.QR_StoragePt2.Util.JwtTokenUtil;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jtwTokenUtil;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;
//
//    @PostMapping("/api/authenticate")
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody){}
}
