package ru.javawebinar.webapp.util;

import org.postgresql.util.PSQLException;
import ru.javawebinar.webapp.ResumeStorageException;

import java.sql.SQLException;

/**
 * GKislin
 * http://javawebinar.ru/basejava/
 */
public class ExceptionUtil {
    private ExceptionUtil() {
    }

    public static ResumeStorageException convertException(SQLException e) {
        if (e instanceof PSQLException) {

//            http://www.postgresql.org/docs/9.3/static/errcodes-appendix.html
            if (e.getSQLState().equals("23505")) {
                return new ResumeStorageException(null, "Resume alredy exists", e);
            }
        }
        return new ResumeStorageException(e);
    }
}
