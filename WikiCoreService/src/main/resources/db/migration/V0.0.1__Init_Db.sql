CREATE SCHEMA IF NOT EXISTS public;

CREATE TABLE IF NOT EXISTS public.articles
(
    id         BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    author_id  BIGINT                   NOT NULL,

    title      VARCHAR(255)             NOT NULL,
    content    TEXT,
    format     VARCHAR                  NOT NULL,
    deleted_by BIGINT                   NOT NULL,
    deleted    BOOLEAN                  NOT NULL,

    createdAt  TIMESTAMP WITH TIME ZONE NOT NULL,
    updatedAt  TIMESTAMP WITH TIME ZONE,
    deletedAt  TIMESTAMP WITH TIME ZONE
);

