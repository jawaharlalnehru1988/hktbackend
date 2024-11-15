package com.example.HKT.service.impl;

import com.example.HKT.DTOs.ProfileDto;
import com.example.HKT.DTOs.UserDto;
import com.example.HKT.entity.ProfileEntity;
import com.example.HKT.entity.UserEntity;
import com.example.HKT.exceptionHandler.UserNotFoundException;
import com.example.HKT.repository.ProfileRepository;
import com.example.HKT.repository.UserRepository;
import com.example.HKT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

//    @Override
//    public UserDto saveUser(UserDto userDto){
//        UserEntity userEntity = convertToEntity(userDto);
//            UserEntity savedUser =  userRepository.save(userEntity);
//        return convertToDto(savedUser);
//    }

//    @Override
//    public UserDto getUserByid(Integer id){
//        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id " + id + "not found"));
//        return convertToDto(userEntity);
//    }

    public UserEntity convertToEntity(UserDto user){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());

        ProfileEntity profileEntity = new ProfileEntity();
        if (user.getProfileDto() != null) {
            profileEntity.setAddress(user.getProfileDto().getAddress());
            profileEntity.setPhoneNumber(user.getProfileDto().getPhoneNumber());
        }
        userEntity.setProfileEntity(profileEntity);
        return userEntity;

    }

//    public UserDto convertToDto(UserEntity userEntity){
//        UserDto userdto = new UserDto();
//        userdto.setName(userEntity.getName());
//        userdto.setId(userEntity.getId());
//
//        ProfileDto profileDto = new ProfileDto();
//        profileDto.setAddress(userEntity.getProfileEntity().getAddress());
//        profileDto.setPhoneNumber(userEntity.getProfileEntity().getPhoneNumber());
//        profileDto.setId(userEntity.getProfileEntity().getId());
//        userdto.setProfileDto(profileDto);
//        return userdto;
//    }
}
