package com.marshad.hellospring;

public class Validation {

    public static void validId(Long id,TaskRepository taskRepository){
        if(!taskRepository.existsById(id)){
            throw new TaskNotFoundException("Id "+id+" is not recognized as valid task id");
        }
    }
}
