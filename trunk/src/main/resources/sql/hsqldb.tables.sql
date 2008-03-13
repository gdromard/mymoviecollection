DROP TABLE PERSON IF EXISTS CASCADE;
CREATE MEMORY TABLE PERSON (
	ID INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, 
    LASTNAME VARCHAR(50) NOT NULL,
    FIRSTNAME VARCHAR(50) NOT NULL
);


DROP TABLE MOVIE IF EXISTS CASCADE;
CREATE MEMORY TABLE MOVIE (
	ID INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, 
    TITLE VARCHAR(50) NOT NULL,
    ORIGINAL_TITLE VARCHAR(50),
    FORMAT_ID INTEGER,
    VERSION_ID INTEGER,
    QUALITY_ID INTEGER,
    GENRE_ID INTEGER,
    SIZE INTEGER,
    LENGTH TIME,
    SYNOPSIS VARCHAR(2000),
    IMAGE_LINK VARCHAR(100),
    DIRECTOR INTEGER,
    CASTING VARCHAR(500),
    CAST1_ID INTEGER,
    CAST2_ID INTEGER,
    CAST3_ID INTEGER,
    CAST4_ID INTEGER,
    YEAR INTEGER,  
    NATIONALITY_ID INTEGER, 
    RENT INTEGER
);


DROP TABLE FORMAT IF EXISTS CASCADE;
CREATE MEMORY TABLE FORMAT (
  ID INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, 
  NAME VARCHAR(50) NOT NULL
);


DROP TABLE GENRE IF EXISTS CASCADE;
CREATE MEMORY TABLE GENRE (
  ID INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, 
  NAME VARCHAR(50) NOT NULL
);


DROP TABLE NATIONALITY IF EXISTS CASCADE;
CREATE MEMORY TABLE NATIONALITY (
  ID INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, 
  NAME VARCHAR(50) NOT NULL
);


DROP TABLE CASTING IF EXISTS CASCADE;
CREATE MEMORY TABLE CASTING (
  ID INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, 
  FIRSTNAME VARCHAR(50) NOT NULL,
  LASTNAME VARCHAR(50) NOT NULL
);


DROP TABLE QUALITY IF EXISTS CASCADE;
CREATE MEMORY TABLE QUALITY (
  ID INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, 
  NAME VARCHAR(50) NOT NULL
);


DROP TABLE VERSION IF EXISTS CASCADE;
CREATE MEMORY TABLE VERSION (
  ID INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, 
  NAME VARCHAR(50) NOT NULL
);

