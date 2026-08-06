package com.bank.simplenotesapi.controller;

import com.bank.simplenotesapi.dto.request.NoteRequest;
import com.bank.simplenotesapi.dto.response.NoteResponse;
import com.bank.simplenotesapi.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/notes")
    public ResponseEntity<NoteResponse> createANote(@RequestBody NoteRequest noteRequest){
        NoteResponse noteResponse = noteService.createNote(noteRequest);
        return ResponseEntity.ok(noteResponse);
    }

    @GetMapping("/notes")
    public ResponseEntity<List<NoteResponse>> getAllTasks(){
        List<NoteResponse> noteResponseList = noteService.getAllNotes();
        return ResponseEntity.ok(noteResponseList);
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity<NoteResponse> getNoteById(@PathVariable String id){
        NoteResponse noteResponse = noteService.getNoteById(id);
        return ResponseEntity.ok(noteResponse);
    }

    @PutMapping("/notes/{id}")
    public ResponseEntity<NoteResponse> updateNote(@PathVariable String id, @Valid @RequestBody NoteRequest noteRequest){
        NoteResponse noteResponse = noteService.updateNoteById(id,noteRequest);
        return ResponseEntity.ok(noteResponse);
    }

    @DeleteMapping("notes/{id}")
    public ResponseEntity<NoteResponse> deleteNoteById(@PathVariable String id){
        NoteResponse noteResponse = noteService.deleteNoteById(id);
        return ResponseEntity.ok(noteResponse);
    }
}
