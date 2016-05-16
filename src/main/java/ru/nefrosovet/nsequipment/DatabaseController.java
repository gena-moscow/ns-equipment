package ru.nefrosovet.nsequipment;

/**
 * Created by gena on 5/12/16.
 */
import org.springframework.jdbc.core.JdbcTemplate;

import net.sourceforge.jtds.jdbcx.JtdsDataSource;

public class DatabaseController {

    private String host;
    private int port;
    private String databaseName;
    private String user;
    private String password;

    private JtdsDataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    private DatabaseController(String host, int port, String databaseName, String user, String password) {
        this.host = host;
        this.port = port;
        this.databaseName = databaseName;
        this.user = user;
        this.password = password;
        this.dataSource = dataSource;

        dataSource = new JtdsDataSource();
        dataSource.setServerName(this.host);
        dataSource.setPortNumber(this.port);
        dataSource.setUser(this.user);
        dataSource.setPassword(this.password);
        dataSource.setDatabaseName(this.databaseName);
        dataSource.setTds("8.0");
        dataSource.setServerType(1);
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static class DatabaseControllerHolder {
        private static final DatabaseController INSTANCE = new DatabaseController(
//                "10.16.17.11",
                "10.0.16.59",
                1433,
//                "Maximus",
                "Maximus-Kostroma-1.47.1",
                "admin",
                "kuffEjHep"
        );
    }

    public static JdbcTemplate getJdbc() {
        return DatabaseControllerHolder.INSTANCE.jdbcTemplate;
    }
}
