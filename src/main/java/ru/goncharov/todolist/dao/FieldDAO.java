package ru.goncharov.todolist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.goncharov.todolist.models.Field;

import java.util.List;

@Component
public class FieldDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FieldDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Field> index() {
        jdbcTemplate.update("DELETE FROM Field WHERE task is null");
        return jdbcTemplate.query("SELECT * FROM Field ORDER BY id;", new BeanPropertyRowMapper<>(Field.class));
    }

    public boolean checkbox(int id) {
        Field f = jdbcTemplate.query("SELECT checkbox FROM Field where id = ?", new Object[]{id},
                new BeanPropertyRowMapper<>(Field.class)).stream().findAny().orElse(null);
        return f.getCheckBox();
    }

    public void changeCheckBox(int id, boolean updatedCheckBox) {
        jdbcTemplate.update("UPDATE Field SET checkbox=? WHERE id=?", updatedCheckBox, id);
    }

    public void edit(int id, Field updatedField) {
        jdbcTemplate.update("UPDATE Field SET task=? WHERE id=?", updatedField.getUpdatedTask(), id);
    }

    public void save(Field field) {
        jdbcTemplate.update("INSERT INTO Field VALUES(DEFAULT, ?, false) ON CONFLICT (id) DO NOTHING",
                field.getTask());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Field WHERE id = ?", id);
    }
}
