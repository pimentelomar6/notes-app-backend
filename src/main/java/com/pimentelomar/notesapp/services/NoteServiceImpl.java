package com.pimentelomar.notesapp.services;

import com.pimentelomar.notesapp.exceptions.ResourceNotFoundException;
import com.pimentelomar.notesapp.models.Note;
import com.pimentelomar.notesapp.repository.NotesRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NotesService {
    private final NotesRepository repository;


    @Override
    public List<Note> getAllNotes() {
        return repository.findAll();
    }

    @Override
    public Note getNoteById(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note id: " + id + " is not exists"));

    }

    @Override
    public void saveNote(Note note) {
        repository.save(note);

    }

    @Override
    public void deleteNoteById(Long id) {
        Note noteDelete = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note id: " + id + " is not exists"));


        repository.deleteById(noteDelete.getId());

    }

    @Override
    public void updateNote(Note note) {
        Note noteForUpdate = repository.findById(note.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Note id: " + note.getId() + " is not exists"));

        noteForUpdate.setTitle(note.getTitle());
        noteForUpdate.setContent(note.getContent());
        noteForUpdate.setIsArchived(note.getIsArchived());
        noteForUpdate.setCategories(note.getCategories());

        repository.save(noteForUpdate);
    }
}
