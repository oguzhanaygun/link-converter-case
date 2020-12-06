
CREATE DATABASE IF NOT EXISTS testApp;
USE testApp;

BEGIN;
CREATE TABLE IF NOT EXISTS logging_event 
  (
    timestmp         BIGINT NOT NULL,
    formatted_message  TEXT NOT NULL,
    logger_name       VARCHAR(254) NOT NULL,
    level_string      VARCHAR(254) NOT NULL,
    thread_name       VARCHAR(254),
    reference_flag    SMALLINT,
    arg0              VARCHAR(254),
    arg1              VARCHAR(254),
    arg2              VARCHAR(254),
    arg3              VARCHAR(254),
    caller_filename   VARCHAR(254) NOT NULL,
    caller_class      VARCHAR(254) NOT NULL,
    caller_method     VARCHAR(254) NOT NULL,
    caller_line       CHAR(4) NOT NULL,
    event_id          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY
  );
COMMIT;

BEGIN;
CREATE TABLE IF NOT EXISTS logging_event_property
  (
    event_id          BIGINT NOT NULL,
    mapped_key        VARCHAR(254) NOT NULL,
    mapped_value      TEXT,
    PRIMARY KEY(event_id, mapped_key),
    FOREIGN KEY (event_id) REFERENCES logging_event(event_id)
  );
COMMIT;

BEGIN;
CREATE TABLE IF NOT EXISTS logging_event_exception
  (
    event_id         BIGINT NOT NULL,
    i                SMALLINT NOT NULL,
    trace_line       VARCHAR(254) NOT NULL,
    PRIMARY KEY(event_id, i),
    FOREIGN KEY (event_id) REFERENCES logging_event(event_id)
  );
COMMIT;


BEGIN;
CREATE TABLE IF NOT EXISTS loggıng_event 
  (
    tımestmp         BIGINT NOT NULL,
    formatted_message  TEXT NOT NULL,
    logger_name       VARCHAR(254) NOT NULL,
    level_strıng      VARCHAR(254) NOT NULL,
    thread_name       VARCHAR(254),
    reference_flag    SMALLINT,
    arg0              VARCHAR(254),
    arg1              VARCHAR(254),
    arg2              VARCHAR(254),
    arg3              VARCHAR(254),
    caller_fılename   VARCHAR(254) NOT NULL,
    caller_class      VARCHAR(254) NOT NULL,
    caller_method     VARCHAR(254) NOT NULL,
    caller_lıne       CHAR(4) NOT NULL,
    event_ıd          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY
  );
COMMIT;

BEGIN;
CREATE TABLE IF NOT EXISTS loggıng_event_property
  (
    event_ıd          BIGINT NOT NULL,
    mapped_key        VARCHAR(254) NOT NULL,
    mapped_value      TEXT,
    PRIMARY KEY(event_ıd, mapped_key),
    FOREIGN KEY (event_ıd) REFERENCES loggıng_event(event_ıd)
  );
COMMIT;

BEGIN;
CREATE TABLE IF NOT EXISTS loggıng_event_exceptıon
  (
    event_ıd         BIGINT NOT NULL,
    ı                SMALLINT NOT NULL,
    trace_lıne       VARCHAR(254) NOT NULL,
    PRIMARY KEY(event_ıd, ı),
    FOREIGN KEY (event_ıd) REFERENCES loggıng_event(event_ıd)
  );
COMMIT;
