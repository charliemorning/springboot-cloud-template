CREATE TABLE FOO (
    FOO_INT INTEGER NOT NULL AUTO_INCREMENT,
    FOO_STR VARCHAR(8),
    FOO_DATE TIMESTAMP,
    PRIMARY KEY (FOO_INT)
);

CREATE TABLE BAR (
    BAR_INT INTEGER NOT NULL AUTO_INCREMENT,
    FOO_INT INTEGER,
    PRIMARY KEY (BAR_INT)
);
