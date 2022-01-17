package ru.goncharov.todolist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import ru.goncharov.todolist.dao.FieldDAO;
import ru.goncharov.todolist.models.Field;

import javax.validation.Valid;

@Controller
@RequestMapping("/notes")
public class FieldController {

    private final FieldDAO fieldDAO;

    @Autowired
    public FieldController(FieldDAO fieldDAO) {
        this.fieldDAO = fieldDAO;
    }

    // main page
    @GetMapping
    public String index(Model model) {
        model.addAttribute("notes", fieldDAO.index());
        return "index";
    }

    // change condition of task
    @GetMapping("/{id}")
    public String change(@ModelAttribute("field") @Valid Field field, @PathVariable("id") int id) {
        fieldDAO.changeCheckBox(id, !fieldDAO.checkbox(id));
        return "redirect:/notes";
    }

    // create new task
    @PostMapping()
    public String create(@ModelAttribute("field") @Valid Field field) {
        fieldDAO.save(field);
        return "redirect:/notes";
    }

    // edit task
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String edit(@ModelAttribute("field") @Valid Field field, @PathVariable("id") int id) {
        fieldDAO.edit(id, field);
        return "redirect:/notes";
    }

    // delete task
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        fieldDAO.delete(id);
        return "redirect:/notes";
    }
}