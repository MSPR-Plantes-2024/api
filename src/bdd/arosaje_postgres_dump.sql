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

CREATE DATABASE arosaje WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.utf8';


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
    user_id integer,
    city text,
    other_info text,
    postal_address text,
    zip_code text
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
    commentator_id integer,
    id integer NOT NULL,
    report_id integer,
    publishing_date timestamp with time zone,
    text text
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
    receiver_id integer,
    sender_id integer,
    publishing_date timestamp with time zone,
    text text
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
    plant_condition_id integer,
    user_id integer,
    name text,
    description text,
    address_id integer
);


ALTER TABLE public.plant OWNER TO "user";

--
-- Name: plant_condition; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.plant_condition (
    id integer NOT NULL,
    name text
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
    address_id integer,
    garden_keeper_id integer,
    id integer NOT NULL,
    publisher_id integer,
    creation_date timestamp with time zone,
    description text,
    ending_date timestamp with time zone,
    starting_date timestamp with time zone
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
    publication_id integer,
    publishing_date date,
    text text,
    title text
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
    email text,
    password text,
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
    name text,
    id integer NOT NULL
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
1	1	Rennes		65 rue d'Antrain	35000
52	2	Quimper	digicode : 3945	7 av. Victor HUGO	29000
102	102	Cesson-cévigné	3ème étage	3 rue des myosotis	35510
\.


--
-- Data for Name: comment; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.comment (commentator_id, id, report_id, publishing_date, text) FROM stdin;
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
1	1	2	2024-02-28 10:43:13+00	Bonjour toto.
\.


--
-- Data for Name: picture; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.picture (id, creation_date) FROM stdin;
1	2024-06-12
202	2024-06-17
353	2024-06-17
\.


--
-- Data for Name: plant; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.plant (id, picture_id, plant_condition_id, user_id, name, description, address_id) FROM stdin;
1	353	1	102	Tulipe	string	102
\.


--
-- Data for Name: plant_condition; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.plant_condition (id, name) FROM stdin;
1	Sain
2	Malade
3	Abimé
\.


--
-- Data for Name: publication; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.publication (address_id, garden_keeper_id, id, publisher_id, creation_date, description, ending_date, starting_date) FROM stdin;
102	\N	1	102	2024-06-19 13:28:12+00	Je recherche un personnes pour s'occuper de mes plantes	2024-06-20 00:00:00+00	2024-06-19 13:12:14+00
102	\N	4	102	2024-06-19 13:42:44+00	Je recherche un personnes pour s'occuper de mes plantes SVP	2024-06-20 00:00:00+00	2024-06-19 13:12:14+00
102	\N	52	102	2024-06-20 13:26:35+00	Je recherche un personnes pour s'occuper de mes plantes SVP	2024-06-13 00:00:00+00	2024-06-19 13:12:14+00
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
1	1
1	4
1	52
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
t	1	t	1	eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0b3RvQHRlc3QuZnIiLCJpYXQiOjE3MDkxMTExNzMsImV4cCI6MTcwOTE5NzU3M30.npwOy8ufgsva_tjJppXtfmIw3mVb3oB5B16B2vC81xI	BEARER
t	2	t	1	eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0b3RvQHRlc3QuZnIiLCJpYXQiOjE3MDkxMTEyMDMsImV4cCI6MTcwOTE5NzYwM30.-e-ICvYlIXv-YPq75ueONjt7X8UHV_PDZ6ev-d0W4gU	BEARER
t	52	t	1	eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0b3RvQHRlc3QuZnIiLCJpYXQiOjE3MDkxMTQwMDUsImV4cCI6MTcwOTIwMDQwNX0.l20tqMNBSSX3VdqRiAaZBROEkLG5ON9tKD3Xg5upf94	BEARER
f	102	f	1	eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0b3RvQHRlc3QuZnIiLCJpYXQiOjE3MDkxMTQyNzgsImV4cCI6MTcwOTIwMDY3OH0.TxXKXXG2-WBiRx-RHTZHLVXEqCVoMhxA1kvnPlJDnnk	BEARER
t	152	t	2	eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0aXRpQHRlc3QuZnIiLCJpYXQiOjE3MDkxMTY3MTUsImV4cCI6MTcwOTIwMzExNX0.ZgD7vvh-LtnG9DRV9FYhk075IlID1DN8ToNFjSNUZGA	BEARER
f	153	f	2	eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0aXRpQHRlc3QuZnIiLCJpYXQiOjE3MDkxMTY3MzgsImV4cCI6MTcwOTIwMzEzOH0.fWGGk80aEmbl1gbZbFuxBtAkXa7FvnqeJ9voCslyQ24	BEARER
t	202	t	52	eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0b2xlc3RAdGVzdC5mciIsImlhdCI6MTcwOTIzMzA4NiwiZXhwIjoxNzA5MzE5NDg2fQ._-6lXCajyUglL2MExK04OkDoI5HfT3yo1wBbidlUxPM	BEARER
t	203	t	52	eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0b2xlc3RAdGVzdC5mciIsImlhdCI6MTcwOTIzMzExMCwiZXhwIjoxNzA5MzE5NTEwfQ.Uh4BdqF92G6vNuy1F6pMifKNkxpV_2rWvse3OuuckRs	BEARER
t	252	t	52	eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0b2xlc3RAdGVzdC5mciIsImlhdCI6MTcwOTIzODMzMCwiZXhwIjoxNzA5MzI0NzMwfQ.AuE9Pw5cpHHoBcrk1GkMOH51n5l0cSq0IfKDUBdcnq0	BEARER
t	302	t	52	eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0b2xlc3RAdGVzdC5mciIsImlhdCI6MTcwOTIzODUxNywiZXhwIjoxNzA5MzI0OTE3fQ.5QgXeBXyspVCeWK2J60dIiBsjKRtaTCRv6RdL9N2hFY	BEARER
f	352	f	52	eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0b2xlc3RAdGVzdC5mciIsImlhdCI6MTcwOTIzODk3NCwiZXhwIjoxNzA5MzI1Mzc0fQ.P8WjWbYytr07VoMLe7scEYC1KFy_tkL8AqcrzgvfHwc	BEARER
t	402	t	102	eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmZyIiwiaWF0IjoxNzE4NjE3NTg4LCJleHAiOjE3MTg3MDM5ODh9.LvVwX-8oWoXVp-8pp7eb3W7o3xtrVhBGDVWe2IN-UNY	BEARER
t	452	t	152	eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0MkBnbWFpbC5mciIsImlhdCI6MTcxODYyMDIyNiwiZXhwIjoxNzE4NzA2NjI2fQ.5SnzBI69aW0NFSpOUpvl7tfpIAVQIoFPUxeGF4fnhqg	BEARER
f	502	f	152	eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0MkBnbWFpbC5mciIsImlhdCI6MTcxODYyMDQ4NCwiZXhwIjoxNzE4NzA2ODg0fQ.U1VDp8t4xMexw6JihKorsx8xLNsIlHQytdqqREG8S34	BEARER
t	552	t	102	eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmZyIiwiaWF0IjoxNzE4ODAyMzYxLCJleHAiOjE3MTg4ODg3NjF9.97kXyG1_E2KeVkpwxEnwmEkgWhEr5d74l_UwEdhk-K0	BEARER
t	602	t	102	eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmZyIiwiaWF0IjoxNzE4ODA0MzY0LCJleHAiOjE3MTg4OTA3NjR9.juvzlXH39R9WnSkgda5YZyiiAZ51h5di4XDOxcXZtXs	BEARER
t	652	t	102	eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmZyIiwiaWF0IjoxNzE4ODA4NTgyLCJleHAiOjE3MTg4OTQ5ODJ9.tc3Vdats4j15F_TipU7Hp9TH8JOySZFl8ckq8oOuwD8	BEARER
t	702	t	102	eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmZyIiwiaWF0IjoxNzE4ODg5OTY3LCJleHAiOjE3MTg5NzYzNjd9.tAYDJrgG-2P7apKKZXQknTJlyg5OlAh1Zisl6npAEMY	BEARER
t	3	t	102	eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmZyIiwiaWF0IjoxNzE5MTQ2NDc1LCJleHAiOjE3MTkyMzI4NzV9.nErXXs6Vod0gHJR5ihW1eugyTJrLKahG_hw8UC94rI0	BEARER
t	53	t	102	eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmZyIiwiaWF0IjoxNzE5MTUzMzUxLCJleHAiOjE3MTkyMzk3NTF9.u3s5_2AnX9IT2BKKHcBI1XoU_F_qcUNd72s6cl2VVj0	BEARER
f	54	f	102	eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmZyIiwiaWF0IjoxNzE5MTUzMzU0LCJleHAiOjE3MTkyMzk3NTR9.r8QQIx7O59GdKPOaS6QPmJlrqmKp2iR7DIM0DVwaWKA	BEARER
\.


--
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public."user" (id, first_name, last_name, email, password, user_type) FROM stdin;
1	toto	Lys	toto@test.fr	$2a$10$gYep9ACBOuks1VyQnx3f0upNG1IIJwjUeLNLM/8M48Fw0an53j2Ga	USER
2	titi	Las	titi@test.fr	$2a$10$BzCJINiDInHzJc3ySQWyA.IUsfH83.cETaXOd1QtIaq9.arOM8WbS	USER
52	tobias	Lest	tolest@test.fr	$2a$10$DB/irADykJH68ojCnmAY5uafZZjmrOF9DqoML1GQQiJpUetgZhTPm	USER
102	Test	Test	test@gmail.fr	$2a$10$sTlAVTaAMoIZVD.Uu55FnejLp50aD4n0TGOoiIcVeMx9sGyn30ZFa	USER
152	Test	Test	test2@gmail.fr	$2a$10$xl68zpamGH5fX6oIBEA.redWpHWvfINPpz3DX9QZoN.NpuvZz47cK	USER
\.


--
-- Data for Name: user_type; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.user_type (name, id) FROM stdin;
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
-- Name: user id_user; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT id_user PRIMARY KEY (id);


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

ALTER TABLE ONLY public.token
    ADD CONSTRAINT fkl10xjn274m2rkxo54knt2xqvy FOREIGN KEY (user_id) REFERENCES public."user"(id);


--
-- Name: report fkmlmq1w66s5uinwjggf89o9ps2; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.report
    ADD CONSTRAINT fkmlmq1w66s5uinwjggf89o9ps2 FOREIGN KEY (publication_id) REFERENCES public.publication(id);


--
-- Name: comment fkn2m8whrfw1drq2c67d247br7c; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT fkn2m8whrfw1drq2c67d247br7c FOREIGN KEY (report_id) REFERENCES public.report(id);


--
-- Name: plant fknj7pdlp85ekaid5kgou1wl85v; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.plant
    ADD CONSTRAINT fknj7pdlp85ekaid5kgou1wl85v FOREIGN KEY (user_id) REFERENCES public."user"(id);


--
-- Name: publication_plants fkq1uod3iv85gr4brb8qsimqxup; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.publication_plants
    ADD CONSTRAINT fkq1uod3iv85gr4brb8qsimqxup FOREIGN KEY (publication_id) REFERENCES public.publication(id);


--
-- Name: address fksa4c9i7qwgoffq6mmhdnnjhoy; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.address
    ADD CONSTRAINT fksa4c9i7qwgoffq6mmhdnnjhoy FOREIGN KEY (user_id) REFERENCES public."user"(id);


--
-- Name: plant fksdl1u305i0vd1n6affgbpp650; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.plant
    ADD CONSTRAINT fksdl1u305i0vd1n6affgbpp650 FOREIGN KEY (address_id) REFERENCES public.address(id);


--
-- Name: publication fksmwvpq90560h49kv3i068s5hu; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.publication
    ADD CONSTRAINT fksmwvpq90560h49kv3i068s5hu FOREIGN KEY (address_id) REFERENCES public.address(id);


--
-- PostgreSQL database dump complete
--

