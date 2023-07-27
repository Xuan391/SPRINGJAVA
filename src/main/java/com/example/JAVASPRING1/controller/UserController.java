package com.example.JAVASPRING1.controller;

import com.example.JAVASPRING1.dto.JwtResponse;
import com.example.JAVASPRING1.dto.MessageResponse;
import com.example.JAVASPRING1.dto.UserLoginRequest;
import com.example.JAVASPRING1.dto.UserSigninRequest;
import com.example.JAVASPRING1.entity.EnumRole;
import com.example.JAVASPRING1.entity.Roles;
import com.example.JAVASPRING1.entity.Users;
import com.example.JAVASPRING1.jwt.JwtTokenProvider;
import com.example.JAVASPRING1.security.CustomUserDetails;
import com.example.JAVASPRING1.service.RoleService;
import com.example.JAVASPRING1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/public")
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserSigninRequest userSigninRequest){
        if(userService.existsByUserName(userSigninRequest.getUserName())){
            return  ResponseEntity.badRequest().body(new MessageResponse("Error: username is already"));
        }

        Users user = new Users();
        user.setUserName(userSigninRequest.getUserName());
        user.setPassword(passwordEncoder.encode(userSigninRequest.getPassword()));
        Set<String> strRoles = userSigninRequest.getListRoles();
        Set<Roles> listRoles = new HashSet<>();
        if(strRoles == null){
            Roles userRole = roleService.findByRoleName(EnumRole.ROLE_USER).orElseThrow(()->new RuntimeException("Error: role not found"));
            listRoles.add(userRole);
        }else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Roles adminRole = roleService.findByRoleName(EnumRole.ROLE_ADMIN).orElseThrow(() -> new RuntimeException("Error role is not found"));
                        listRoles.add(adminRole);
                    case "user":
                        Roles userRole = roleService.findByRoleName(EnumRole.ROLE_USER).orElseThrow(() -> new RuntimeException("Errpr: Role is not found"));
                        listRoles.add(userRole);
                }
            } );
        }
        user.setListRoles(listRoles);
        userService.saveOrUpdate(user);
        return ResponseEntity.ok(new MessageResponse("user registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser (@RequestBody UserLoginRequest userLoginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userLoginRequest.getUserName(), userLoginRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        String jwt = jwtTokenProvider.generateToken(customUserDetails);
        List<String> listRoles = customUserDetails.getAuthorities().stream()
                .map(item -> item.getAuthority()).collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(jwt, customUserDetails.getUsername(), listRoles));
    }
}
