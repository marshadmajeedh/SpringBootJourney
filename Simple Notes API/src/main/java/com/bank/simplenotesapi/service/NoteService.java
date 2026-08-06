package com.bank.simplenotesapi.service;

import com.bank.simplenotesapi.dto.request.NoteRequest;
import com.bank.simplenotesapi.dto.response.NoteResponse;
import com.bank.simplenotesapi.exception.IdNotFoundInTheListException;
import com.bank.simplenotesapi.model.Note;
import com.bank.simplenotesapi.util.Validation;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {
    private final List<Note> notes;

    public NoteService() {
        this.notes = new ArrayList<>();
    }

    //create a note
    public NoteResponse createNote(NoteRequest noteRequest) {
        Note note = new Note(noteRequest.getTitle(), noteRequest.getContent());
        this.notes.add(note);

        return new NoteResponse(note.getId(), note.getTitle(),note.getContent(),note.getCreatedAt());
    }

    //get all notes in the list
    public List<NoteResponse> getAllNotes() {

        return notes.stream()
                .map(note -> new NoteResponse(
                        note.getId(),
                        note.getTitle(),
                        note.getContent(),
                        note.getCreatedAt()
                ))
                .toList();
    }

    //get a note by its id
    public NoteResponse getNoteById(String id) {
        Validation.isIDAvailableInTheList(notes,id);

        return notes.stream()
                .filter(note -> note.getId().equals(id))
                .map(task -> new NoteResponse(task.getId(),task.getTitle(),task.getContent(),task.getCreatedAt()))
                .findFirst()
                .orElseThrow(() -> new IdNotFoundInTheListException("A note with ID "+id+" not found in the list"));
    }

    //update a note by its id
    public NoteResponse updateNoteById(String id,NoteRequest noteRequest) {
        Validation.isIDAvailableInTheList(notes,id);

        return notes.stream()
                .filter(task -> task.getId().equals(id))
                .peek( task ->{
                    task.setTitle(noteRequest.getTitle());
                    task.setContent(noteRequest.getContent());
                })
                .map(task -> new NoteResponse(task.getId(), task.getTitle(),task.getContent(),task.getCreatedAt()))
                .findFirst()
                .orElseThrow(() -> new IdNotFoundInTheListException("A note with ID "+id+" not found in the list"));
    }

    //delete a note by its id
    public NoteResponse deleteNoteById(String id) {
        Validation.isIDAvailableInTheList(notes,id);

        Note noteToDelete = notes.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IdNotFoundInTheListException("A note with ID "+id+" not found in the list"));
        notes.remove(noteToDelete);

        return  new NoteResponse(noteToDelete.getId(), noteToDelete.getTitle(),noteToDelete.getContent(),noteToDelete.getCreatedAt());
    }
}
