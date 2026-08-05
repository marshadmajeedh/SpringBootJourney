package com.bank.simpleaskmanagerapi.util;

import com.bank.simpleaskmanagerapi.exception.TitleNotMatchException;
import com.bank.simpleaskmanagerapi.model.Task;

import java.util.List;

public class Validation {

    public static void checkTaskByTitle(List<Task> tasks, String title) {

        boolean found = false;
        for (Task task : tasks) {
            if(task.getTitle().equalsIgnoreCase(title)) {
                found = true;
                break;
            }
        }
        if(!found) {
            throw new TitleNotMatchException(title+" was not found in the task list");
        }
    }
}
