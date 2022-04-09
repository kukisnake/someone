package com.someone.service;

import com.someone.dto.HobbyDTO;
import com.someone.entity.Hobby;
import com.someone.repository.HobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("hobbyService")
public class HobbyService {

    @Autowired
    private HobbyRepository hobbyRepository;

    public void addNewHobby(HobbyDTO hobbyDto) {
        Hobby hobby = new Hobby();
        if (isHobbyNew(hobbyDto)) {
            hobby.setName(hobbyDto.getName());
            hobbyRepository.save(hobby);
        }
    }

    public boolean isHobbyNew(HobbyDTO hobbyDto) {
        List<Hobby> foundHobby = hobbyRepository.findByName(hobbyDto.getName());
        return (foundHobby.size() == 0);
    }

}
