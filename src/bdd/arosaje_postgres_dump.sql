--
-- PostgreSQL database dump
--

-- Dumped from database version 16.3
-- Dumped by pg_dump version 16.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: arosaje; Type: DATABASE; Schema: -; Owner: user
--

CREATE DATABASE arosaje WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'fr_FR.utf8';


ALTER DATABASE arosaje OWNER TO "user";

\connect arosaje

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: address; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.address (
    id integer NOT NULL,
    user_id integer NOT NULL,
    city text NOT NULL,
    zip_code text NOT NULL,
    postal_address text NOT NULL,
    other_info text
);


ALTER TABLE public.address OWNER TO "user";

--
-- Name: address_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE public.address_seq
    START WITH 120
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.address_seq OWNER TO "user";

--
-- Name: address_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: user
--

ALTER SEQUENCE public.address_seq OWNED BY public.address.id;


--
-- Name: comment; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.comment (
    id integer NOT NULL,
    commentator_id integer NOT NULL,
    report_id integer NOT NULL,
    publishing_date timestamp with time zone NOT NULL,
    text text NOT NULL
);


ALTER TABLE public.comment OWNER TO "user";

--
-- Name: comment_answers; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.comment_answers (
    answers_id bigint,
    comment_id bigint
);


ALTER TABLE public.comment_answers OWNER TO "user";

--
-- Name: comment_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE public.comment_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.comment_seq OWNER TO "user";

--
-- Name: comment_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: user
--

ALTER SEQUENCE public.comment_seq OWNED BY public.comment.id;


--
-- Name: message; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.message (
    id integer NOT NULL,
    receiver_id integer NOT NULL,
    sender_id integer NOT NULL,
    publishing_date timestamp with time zone NOT NULL,
    text text NOT NULL
);


ALTER TABLE public.message OWNER TO "user";

--
-- Name: message_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE public.message_seq
    START WITH 10
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.message_seq OWNER TO "user";

--
-- Name: message_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: user
--

ALTER SEQUENCE public.message_seq OWNED BY public.message.id;


--
-- Name: picture_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE public.picture_seq
    START WITH 400
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.picture_seq OWNER TO "user";

--
-- Name: picture; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.picture (
    id integer DEFAULT nextval('public.picture_seq'::regclass) NOT NULL,
    creation_date date
);


ALTER TABLE public.picture OWNER TO "user";

--
-- Name: plant; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.plant (
    id integer NOT NULL,
    picture_id integer,
    plant_condition_id integer NOT NULL,
    user_id integer,
    name text NOT NULL,
    description text,
    address_id integer NOT NULL
);


ALTER TABLE public.plant OWNER TO "user";

--
-- Name: plant_condition; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.plant_condition (
    id integer NOT NULL,
    name text NOT NULL
);


ALTER TABLE public.plant_condition OWNER TO "user";

--
-- Name: plant_condition_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE public.plant_condition_seq
    START WITH 10
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.plant_condition_seq OWNER TO "user";

--
-- Name: plant_condition_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: user
--

ALTER SEQUENCE public.plant_condition_seq OWNED BY public.plant_condition.id;


--
-- Name: plant_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE public.plant_seq
    START WITH 100
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.plant_seq OWNER TO "user";

--
-- Name: plant_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: user
--

ALTER SEQUENCE public.plant_seq OWNED BY public.plant.id;


--
-- Name: publication; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.publication (
    id integer NOT NULL,
    garden_keeper_id integer,
    address_id integer NOT NULL,
    publisher_id integer NOT NULL,
    creation_date timestamp with time zone NOT NULL,
    description text,
    ending_date timestamp with time zone NOT NULL,
    starting_date timestamp with time zone NOT NULL
);


ALTER TABLE public.publication OWNER TO "user";

--
-- Name: publication_comments; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.publication_comments (
    comments_id bigint,
    publication_id bigint
);


ALTER TABLE public.publication_comments OWNER TO "user";

--
-- Name: publication_plants; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.publication_plants (
    plants_id integer,
    publication_id integer
);


ALTER TABLE public.publication_plants OWNER TO "user";

--
-- Name: publication_reports; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.publication_reports (
    publication_id integer,
    reports_id integer
);


ALTER TABLE public.publication_reports OWNER TO "user";

--
-- Name: publication_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE public.publication_seq
    START WITH 100
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.publication_seq OWNER TO "user";

--
-- Name: publication_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: user
--

ALTER SEQUENCE public.publication_seq OWNED BY public.publication.id;


--
-- Name: report; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.report (
    id integer NOT NULL,
    publication_id integer NOT NULL,
    publishing_date date NOT NULL,
    text text,
    title text NOT NULL
);


ALTER TABLE public.report OWNER TO "user";

--
-- Name: report_pictures; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.report_pictures (
    report_id integer,
    pictures_id integer
);


ALTER TABLE public.report_pictures OWNER TO "user";

--
-- Name: report_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE public.report_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.report_seq OWNER TO "user";

--
-- Name: report_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: user
--

ALTER SEQUENCE public.report_seq OWNED BY public.report.id;


--
-- Name: token; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.token (
    expired boolean,
    id integer NOT NULL,
    revoked boolean,
    user_id integer,
    token text,
    token_type text
);


ALTER TABLE public.token OWNER TO "user";

--
-- Name: token_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE public.token_seq
    START WITH 900
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.token_seq OWNER TO "user";

--
-- Name: token_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: user
--

ALTER SEQUENCE public.token_seq OWNED BY public.token.id;


--
-- Name: user; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public."user" (
    id integer NOT NULL,
    first_name text,
    last_name text,
    email text NOT NULL,
    password text NOT NULL,
    user_type text
);


ALTER TABLE public."user" OWNER TO "user";

--
-- Name: user_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE public.user_seq
    START WITH 200
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.user_seq OWNER TO "user";

--
-- Name: user_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: user
--

ALTER SEQUENCE public.user_seq OWNED BY public."user".id;


--
-- Name: user_type; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.user_type (
    id integer NOT NULL,
    name text NOT NULL
);


ALTER TABLE public.user_type OWNER TO "user";

--
-- Name: user_type_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE public.user_type_seq
    START WITH 10
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.user_type_seq OWNER TO "user";

--
-- Name: user_type_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: user
--

ALTER SEQUENCE public.user_type_seq OWNED BY public.user_type.id;


--
-- Name: address id; Type: DEFAULT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.address ALTER COLUMN id SET DEFAULT nextval('public.address_seq'::regclass);


--
-- Name: comment id; Type: DEFAULT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.comment ALTER COLUMN id SET DEFAULT nextval('public.comment_seq'::regclass);


--
-- Name: message id; Type: DEFAULT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.message ALTER COLUMN id SET DEFAULT nextval('public.message_seq'::regclass);


--
-- Name: plant id; Type: DEFAULT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.plant ALTER COLUMN id SET DEFAULT nextval('public.plant_seq'::regclass);


--
-- Name: plant_condition id; Type: DEFAULT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.plant_condition ALTER COLUMN id SET DEFAULT nextval('public.plant_condition_seq'::regclass);


--
-- Name: publication id; Type: DEFAULT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.publication ALTER COLUMN id SET DEFAULT nextval('public.publication_seq'::regclass);


--
-- Name: report id; Type: DEFAULT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.report ALTER COLUMN id SET DEFAULT nextval('public.report_seq'::regclass);


--
-- Name: token id; Type: DEFAULT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.token ALTER COLUMN id SET DEFAULT nextval('public.token_seq'::regclass);


--
-- Name: user id; Type: DEFAULT; Schema: public; Owner: user
--

ALTER TABLE ONLY public."user" ALTER COLUMN id SET DEFAULT nextval('public.user_seq'::regclass);


--
-- Name: user_type id; Type: DEFAULT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.user_type ALTER COLUMN id SET DEFAULT nextval('public.user_type_seq'::regclass);


--
-- Data for Name: address; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.address (id, user_id, city, other_info, postal_address, zip_code) FROM stdin;
\.


--
-- Data for Name: comment; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.comment (id, commentator_id, report_id, publishing_date, text) FROM stdin;
\.


--
-- Data for Name: comment_answers; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.comment_answers (answers_id, comment_id) FROM stdin;
\.


--
-- Data for Name: message; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.message (id, receiver_id, sender_id, publishing_date, text) FROM stdin;
\.


--
-- Data for Name: picture; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.picture (id, creation_date) FROM stdin;
\.


--
-- Data for Name: plant; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.plant (id, picture_id, plant_condition_id, user_id, name, description, address_id) FROM stdin;
\.


--
-- Data for Name: plant_condition; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.plant_condition (id, name) FROM stdin;
1	Sain
2	Malade
3	Abimé
4	Problème
\.


--
-- Data for Name: publication; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.publication (address_id, garden_keeper_id, id, publisher_id, creation_date, description, ending_date, starting_date) FROM stdin;
\.


--
-- Data for Name: publication_comments; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.publication_comments (comments_id, publication_id) FROM stdin;
\.


--
-- Data for Name: publication_plants; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.publication_plants (plants_id, publication_id) FROM stdin;
\.


--
-- Data for Name: publication_reports; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.publication_reports (publication_id, reports_id) FROM stdin;
\.


--
-- Data for Name: report; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.report (id, publication_id, publishing_date, text, title) FROM stdin;
\.


--
-- Data for Name: report_pictures; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.report_pictures (report_id, pictures_id) FROM stdin;
\.


--
-- Data for Name: token; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.token (expired, id, revoked, user_id, token, token_type) FROM stdin;
\.


--
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public."user" (id, first_name, last_name, email, password, user_type) FROM stdin;
\.


--
-- Data for Name: user_type; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.user_type (id, name) FROM stdin;
1	USER
\.


--
-- Name: address_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('public.address_seq', 1, false);


--
-- Name: comment_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('public.comment_seq', 1, false);


--
-- Name: message_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('public.message_seq', 1, false);


--
-- Name: picture_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('public.picture_seq', 1, false);


--
-- Name: plant_condition_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('public.plant_condition_seq', 1, false);


--
-- Name: plant_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('public.plant_seq', 1, false);


--
-- Name: publication_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('public.publication_seq', 1, false);


--
-- Name: report_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('public.report_seq', 1, false);


--
-- Name: token_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('public.token_seq', 101, true);


--
-- Name: user_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('public.user_seq', 1, false);


--
-- Name: user_type_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('public.user_type_seq', 1, false);


--
-- Name: user user_id; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_id PRIMARY KEY (id);


--
-- Name: address idx_33040_address_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.address
    ADD CONSTRAINT idx_33040_address_pkey PRIMARY KEY (id);


--
-- Name: comment idx_33048_comment_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT idx_33048_comment_pkey PRIMARY KEY (id);


--
-- Name: message idx_33056_message_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.message
    ADD CONSTRAINT idx_33056_message_pkey PRIMARY KEY (id);


--
-- Name: plant idx_33067_plant_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.plant
    ADD CONSTRAINT idx_33067_plant_pkey PRIMARY KEY (id);


--
-- Name: plant_condition idx_33072_plant_condition_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.plant_condition
    ADD CONSTRAINT idx_33072_plant_condition_pkey PRIMARY KEY (id);


--
-- Name: picture idx_33130_picture_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.picture
    ADD CONSTRAINT idx_33130_picture_pkey PRIMARY KEY (id);


--
-- Name: publication idx_33133_publication_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.publication
    ADD CONSTRAINT idx_33133_publication_pkey PRIMARY KEY (id);


--
-- Name: report report_pk; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.report
    ADD CONSTRAINT report_pk PRIMARY KEY (id);


--
-- Name: token token_pk; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.token
    ADD CONSTRAINT token_pk PRIMARY KEY (id);


--
-- Name: user_type user_type_pk; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.user_type
    ADD CONSTRAINT user_type_pk PRIMARY KEY (id);


--
-- Name: idx_32982_sqlite_autoindex_comment_answers_1; Type: INDEX; Schema: public; Owner: user
--

CREATE UNIQUE INDEX idx_32982_sqlite_autoindex_comment_answers_1 ON public.comment_answers USING btree (answers_id);


--
-- Name: idx_33067_sqlite_autoindex_plant_1; Type: INDEX; Schema: public; Owner: user
--

CREATE UNIQUE INDEX idx_33067_sqlite_autoindex_plant_1 ON public.plant USING btree (picture_id);


--
-- Name: idx_33083_sqlite_autoindex_publication_comments_1; Type: INDEX; Schema: public; Owner: user
--

CREATE UNIQUE INDEX idx_33083_sqlite_autoindex_publication_comments_1 ON public.publication_comments USING btree (comments_id);


--
-- Name: idx_33097_sqlite_autoindex_token_1; Type: INDEX; Schema: public; Owner: user
--

CREATE UNIQUE INDEX idx_33097_sqlite_autoindex_token_1 ON public.token USING btree (token);


--
-- Name: idx_33121_sqlite_autoindex_publication_reports_1; Type: INDEX; Schema: public; Owner: user
--

CREATE UNIQUE INDEX idx_33121_sqlite_autoindex_publication_reports_1 ON public.publication_reports USING btree (reports_id);


--
-- Name: idx_33124_sqlite_autoindex_report_pictures_1; Type: INDEX; Schema: public; Owner: user
--

CREATE UNIQUE INDEX idx_33124_sqlite_autoindex_report_pictures_1 ON public.report_pictures USING btree (pictures_id);


--
-- Name: idx_33127_sqlite_autoindex_publication_plants_1; Type: INDEX; Schema: public; Owner: user
--

CREATE UNIQUE INDEX idx_33127_sqlite_autoindex_publication_plants_1 ON public.publication_plants USING btree (publication_id);


--
-- Name: publication_reports fk1wkjj9ptb3msqb0jnf49u08ui; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.publication_reports
    ADD CONSTRAINT fk1wkjj9ptb3msqb0jnf49u08ui FOREIGN KEY (publication_id) REFERENCES public.publication(id);


--
-- Name: message fk2vy6vvsey4fendbyhcg3xxl4e; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.message
    ADD CONSTRAINT fk2vy6vvsey4fendbyhcg3xxl4e FOREIGN KEY (receiver_id) REFERENCES public."user"(id);


--
-- Name: publication_plants fk4qny78nklwtlnpe3i3jwuqnne; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.publication_plants
    ADD CONSTRAINT fk4qny78nklwtlnpe3i3jwuqnne FOREIGN KEY (plants_id) REFERENCES public.plant(id);


--
-- Name: message fk5ae4oshfopjfwjpf9xbcso8v2; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.message
    ADD CONSTRAINT fk5ae4oshfopjfwjpf9xbcso8v2 FOREIGN KEY (sender_id) REFERENCES public."user"(id);


--
-- Name: report_pictures fk5xn74e76yt29ss869y7mkj5bx; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.report_pictures
    ADD CONSTRAINT fk5xn74e76yt29ss869y7mkj5bx FOREIGN KEY (report_id) REFERENCES public.report(id);


--
-- Name: publication fk69rtmgw0rl7xvsn60ntkrogjr; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.publication
    ADD CONSTRAINT fk69rtmgw0rl7xvsn60ntkrogjr FOREIGN KEY (publisher_id) REFERENCES public."user"(id);


--
-- Name: plant fk77hk1vcisama6j1246r5d369l; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.plant
    ADD CONSTRAINT fk77hk1vcisama6j1246r5d369l FOREIGN KEY (plant_condition_id) REFERENCES public.plant_condition(id);


--
-- Name: publication fka391tcj1q5n2c9x47i6o6f0ij; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.publication
    ADD CONSTRAINT fka391tcj1q5n2c9x47i6o6f0ij FOREIGN KEY (garden_keeper_id) REFERENCES public."user"(id);


--
-- Name: publication_reports fkb4wi7hhhi8odhoqr29iltudmi; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.publication_reports
    ADD CONSTRAINT fkb4wi7hhhi8odhoqr29iltudmi FOREIGN KEY (reports_id) REFERENCES public.report(id);


--
-- Name: report_pictures fkckt32aqwkt7i36g230xg1toj5; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.report_pictures
    ADD CONSTRAINT fkckt32aqwkt7i36g230xg1toj5 FOREIGN KEY (pictures_id) REFERENCES public.picture(id);


--
-- Name: plant fkfei6ie0q4whu1olt0mnduh4fa; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.plant
    ADD CONSTRAINT fkfei6ie0q4whu1olt0mnduh4fa FOREIGN KEY (picture_id) REFERENCES public.picture(id);


--
-- Name: comment fkkfk9n995qv9jfa11r1xgsb7px; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT fkkfk9n995qv9jfa11r1xgsb7px FOREIGN KEY (commentator_id) REFERENCES public."user"(id);


--
-- Name: token fkl10xjn274m2rkxo54knt2xqvy; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE public.token DROP CONSTRAINT IF EXISTS FKl10xjn274m2rkxo54knt2xqvy;

ALTER TABLE ONLY public.token
    ADD CONSTRAINT fkl10xjn274m2rkxo54knt2xqvy FOREIGN KEY (user_id) REFERENCES public."user"(id) ON DELETE CASCADE;

ALTER TABLE public.report_pictures ADD CONSTRAINT pk_report_pictures PRIMARY KEY (report_id, pictures_id);

ALTER TABLE public.publication_reports ADD CONSTRAINT pk_publication_reports PRIMARY KEY (publication_id, reports_id);

ALTER TABLE public.publication_plants ADD CONSTRAINT pk_publication_plants PRIMARY KEY (plants_id, publication_id);

ALTER TABLE public.publication_comments ADD CONSTRAINT pk_publication_comments PRIMARY KEY (comments_id, publication_id);

ALTER TABLE public.comment_answers ADD CONSTRAINT pk_comment_answers PRIMARY KEY (answers_id, comment_id);

-- Address Table Foreign Key
ALTER TABLE public.address
    ADD CONSTRAINT fk_address_user_id FOREIGN KEY (user_id)
        REFERENCES public."user" (id);

-- Comment Table Foreign Keys
ALTER TABLE public.comment
    ADD CONSTRAINT fk_comment_commentator_id FOREIGN KEY (commentator_id)
        REFERENCES public."user" (id);

ALTER TABLE public.comment
    ADD CONSTRAINT fk_comment_report_id FOREIGN KEY (report_id)
        REFERENCES public.report (id);

-- Message Table Foreign Keys
ALTER TABLE public.message
    ADD CONSTRAINT fk_message_receiver_id FOREIGN KEY (receiver_id)
        REFERENCES public."user" (id);

ALTER TABLE public.message
    ADD CONSTRAINT fk_message_sender_id FOREIGN KEY (sender_id)
        REFERENCES public."user" (id);

-- Plant Table Foreign Keys
ALTER TABLE public.plant
    ADD CONSTRAINT fk_plant_picture_id FOREIGN KEY (picture_id)
        REFERENCES public.picture (id);

ALTER TABLE public.plant
    ADD CONSTRAINT fk_plant_plant_condition_id FOREIGN KEY (plant_condition_id)
        REFERENCES public.plant_condition (id);

ALTER TABLE public.plant
    ADD CONSTRAINT fk_plant_user_id FOREIGN KEY (user_id)
        REFERENCES public."user" (id);

ALTER TABLE public.plant
    ADD CONSTRAINT fk_plant_address_id FOREIGN KEY (address_id)
        REFERENCES public.address (id);

-- Publication Table Foreign Keys
ALTER TABLE public.publication
    ADD CONSTRAINT fk_publication_garden_keeper_id FOREIGN KEY (garden_keeper_id)
        REFERENCES public."user" (id);

ALTER TABLE public.publication
    ADD CONSTRAINT fk_publication_address_id FOREIGN KEY (address_id)
        REFERENCES public.address (id);

ALTER TABLE public.publication
    ADD CONSTRAINT fk_publication_publisher_id FOREIGN KEY (publisher_id)
        REFERENCES public."user" (id);

-- Token Table Foreign Key
ALTER TABLE public.token
    ADD CONSTRAINT fk_token_user_id FOREIGN KEY (user_id)
        REFERENCES public."user" (id) ON DELETE CASCADE;

-- Publication Reports Foreign Key
ALTER TABLE public.publication_reports
    ADD CONSTRAINT fk_publication_reports_publication_id FOREIGN KEY (publication_id)
        REFERENCES public.publication(id);

ALTER TABLE public.publication_reports
    ADD CONSTRAINT fk_publication_reports_reports_id FOREIGN KEY (reports_id)
        REFERENCES public.report(id);

-- Report Pictures Foreign Key
ALTER TABLE public.report_pictures
    ADD CONSTRAINT fk_report_pictures_report_id FOREIGN KEY (report_id)
        REFERENCES public.report(id);

ALTER TABLE public.report_pictures
    ADD CONSTRAINT fk_report_pictures_pictures_id FOREIGN KEY (pictures_id)
        REFERENCES public.picture(id);

-- Publication Plants Foreign Key
ALTER TABLE public.publication_plants
    ADD CONSTRAINT fk_publication_plants_plants_id FOREIGN KEY (plants_id)
        REFERENCES public.plant(id);

ALTER TABLE public.publication_plants
    ADD CONSTRAINT fk_publication_plants_publication_id FOREIGN KEY (publication_id)
        REFERENCES public.publication(id);

-- Publication Comments Foreign Key
ALTER TABLE public.publication_comments
    ADD CONSTRAINT fk_publication_comments_comments_id FOREIGN KEY (comments_id)
        REFERENCES public.comment(id);

ALTER TABLE public.publication_comments
    ADD CONSTRAINT fk_publication_comments_publication_id FOREIGN KEY (publication_id)
        REFERENCES public.publication(id);

-- Comment Answers Foreign Key
ALTER TABLE public.comment_answers
    ADD CONSTRAINT fk_comment_answers_answers_id FOREIGN KEY (answers_id)
        REFERENCES public.comment(id);

ALTER TABLE public.comment_answers
    ADD CONSTRAINT fk_comment_answers_comment_id FOREIGN KEY (comment_id)
        REFERENCES public.comment(id);
--
-- PostgreSQL database dump complete
--

