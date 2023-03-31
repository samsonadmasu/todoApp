package com.exam.userservice.services;

import com.exam.userservice.entity.AppUser;
import com.exam.userservice.exceptions.ResourceNotFoundException;
import com.exam.userservice.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class UserService {
    private final AppUserRepository appUserRepository;

    public boolean isChecked(int id) throws ResourceNotFoundException {
        AppUser appUser = appUserRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));

        if(appUser.isStatus()){
            return true;
        }
        return false;
    }

    public Map<String, Boolean> deleteUser(Integer userId) throws ResourceNotFoundException {
        AppUser appUser = appUserRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

        appUserRepository.delete(appUser);
        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    public ResponseEntity<AppUser> updateUsers(Integer userId, AppUser appUserDetail) throws ResourceNotFoundException {
        AppUser appUser = appUserRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

        appUser.setFullName(appUserDetail.getFullName());
        appUser.setUserName(appUserDetail.getUserName());
        final AppUser updatedUser = appUserRepository.save(appUser);
        return ResponseEntity.ok(updatedUser);
    }

    public ResponseEntity<AppUser> getUserById(Integer userId) throws ResourceNotFoundException {
        AppUser appUser = appUserRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
        return ResponseEntity.ok().body(appUser);
    }

}
