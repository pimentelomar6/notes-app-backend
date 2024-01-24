package com.pimentelomar.notesapp.controllers;

import com.pimentelomar.notesapp.models.Note;
import com.pimentelomar.notesapp.services.NotesService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/notes")
@RequiredArgsConstructor
public class NoteController {


    private final NotesService service;

    @GetMapping()
    public ResponseEntity<List<Note>> listOfNotes() {
        return ResponseEntity.ok(service.getAllNotes());
    }

    @PostMapping()
    public ResponseEntity createNote(@RequestBody Note note) {
        service.saveNote(note);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Note> noteById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getNoteById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity updateNote(@RequestBody Note note) {
        service.updateNote(note);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteNote(@PathVariable("id") Long id) {
        service.deleteNoteById(id);
        return ResponseEntity.ok("Note delete successfully");
    }

}
