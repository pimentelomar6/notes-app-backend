package com.pimentelomar.notesapp.services;

import com.pimentelomar.notesapp.models.Note;


import java.util.List;



public interface NotesService {

    List<Note> getAllNotes();

    Note getNoteById(Long id);

    void saveNote(Note note);

    void deleteNoteById(Long id);

    void updateNote(Note note);
}
