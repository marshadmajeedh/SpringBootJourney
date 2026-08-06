package com.bank.simplenotesapi.util;

import com.bank.simplenotesapi.exception.IdNotFoundInTheListException;
import com.bank.simplenotesapi.model.Note;

import java.util.List;

public class Validation {
    public static void isIDAvailableInTheList(List<Note> notes, String id) {

        boolean found = false;
        for (Note note : notes) {
            if (note.getId().equals(id)) {
                found = true;
                break;
            }
        }
        if (!found) {
            throw new IdNotFoundInTheListException("A note with the ID "+id+" was not found in the list");
        }
    }
}
