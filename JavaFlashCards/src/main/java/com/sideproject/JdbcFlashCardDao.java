package com.sideproject;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcFlashCardDao implements FlashCardDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcFlashCardDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public FlashCard getFlashCardById(int flashCardId) {
        FlashCard flashCard = null;
        String sql = "Select * from flashcard where flashcard_id = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, flashCardId);
            if (results.next()) {
                flashCard = mapRowToFlashcard(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.");
        }
        return flashCard;
    }

    @Override
    public List<FlashCard> getAllFlashcards() {
        List<FlashCard> flashcardTerms = new ArrayList<>();
        String sql = "Select * from flashcard order by flashcard_id asc;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                flashcardTerms.add(mapRowToFlashcard(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.");
        }
        return flashcardTerms;

    }

    @Override
    public FlashCard getRandomFlashcard() {
        FlashCard flashcard = null;
        String sql = "Select * from flashcard order by random() limit 1;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            if (results.next()) {
                flashcard = mapRowToFlashcard(results) ;
            }
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to database or server", e);
        }
        return flashcard;
    }


    @Override
    public List<FlashCard> getFlashCardByPartialNameSearch(String term) {
        List<FlashCard> flashCardTerms = new ArrayList<>();
        String sql = "SELECT * from flashcard where term ilike ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + term + "%");
            while (results.next()) {
                flashCardTerms.add(mapRowToFlashcard(results));
            }
        }
        catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return flashCardTerms;
    }

    @Override
    public FlashCard create(FlashCard flashCard) {
        FlashCard newFlashCard = null;
        String sql = "Insert into flashcard (term, definition) " +
                "values (?, ?) returning flashcard_id;";
        try{
            int newFlashCardId = jdbcTemplate.queryForObject(sql, int.class,
                    flashCard.getTerm(), flashCard.getDefinition());

            newFlashCard = getFlashCardById(newFlashCardId);
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.");
        }catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Integrity Violation");
        }
        return newFlashCard;
    }

    @Override
    public FlashCard updateFlashcard(FlashCard flashCard) {
        FlashCard updatedFlashCard = null;
        String sql = "Update flashcard set term = ?, definition = ? where flashcard_id = ?;";
        try {
            int numberOfRows = jdbcTemplate.update(sql, flashCard.getTerm(), flashCard.getDefinition(), flashCard.getFlashCardId());

            if (numberOfRows == 0) {
                throw new DaoException("Zero rows affected, expect at least one.");
            }else {
                updatedFlashCard = getFlashCardById(flashCard.getFlashCardId());
            }
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.");
        }catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Integrity Violation");
        }
        return updatedFlashCard;
    }

    private FlashCard mapRowToFlashcard(SqlRowSet rowSet) {
        FlashCard flashCard = new FlashCard();
        flashCard.setFlashCardId(rowSet.getInt("flashcard_id"));
        flashCard.setTerm(rowSet.getString("term"));
        flashCard.setDefinition(rowSet.getString("definition"));
        return flashCard;
    }
}
