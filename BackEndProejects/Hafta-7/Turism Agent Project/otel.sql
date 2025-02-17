PGDMP      3                |            otel    15.5    16.1 &    &           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            '           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            (           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            )           1262    16929    otel    DATABASE     y   CREATE DATABASE otel WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Turkish_T�rkiye.1254';
    DROP DATABASE otel;
                postgres    false            �            1259    16945    hotel    TABLE     �  CREATE TABLE public.hotel (
    hotel_id integer NOT NULL,
    hotel_name text NOT NULL,
    city text NOT NULL,
    region text NOT NULL,
    address text NOT NULL,
    mail text NOT NULL,
    phone text NOT NULL,
    star text NOT NULL,
    carpark boolean NOT NULL,
    wifi boolean NOT NULL,
    pool boolean NOT NULL,
    fitness boolean NOT NULL,
    conclerge boolean NOT NULL,
    spa boolean NOT NULL,
    room_service boolean NOT NULL
);
    DROP TABLE public.hotel;
       public         heap    postgres    false            �            1259    17072    otel_hotel_id_seq    SEQUENCE     �   CREATE SEQUENCE public.otel_hotel_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.otel_hotel_id_seq;
       public          postgres    false    214            *           0    0    otel_hotel_id_seq    SEQUENCE OWNED BY     H   ALTER SEQUENCE public.otel_hotel_id_seq OWNED BY public.hotel.hotel_id;
          public          postgres    false    221            �            1259    16951    pension_type    TABLE     �   CREATE TABLE public.pension_type (
    id integer NOT NULL,
    hotel_id integer NOT NULL,
    pension_type character varying NOT NULL
);
     DROP TABLE public.pension_type;
       public         heap    postgres    false            �            1259    17091    pension_type_id_seq    SEQUENCE     �   CREATE SEQUENCE public.pension_type_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.pension_type_id_seq;
       public          postgres    false    216            +           0    0    pension_type_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.pension_type_id_seq OWNED BY public.pension_type.id;
          public          postgres    false    222            �            1259    16957    reservation    TABLE     b  CREATE TABLE public.reservation (
    id integer NOT NULL,
    room_id integer NOT NULL,
    checkin_date date NOT NULL,
    checkout_date date NOT NULL,
    total_price double precision NOT NULL,
    guest_count integer NOT NULL,
    guest_name text NOT NULL,
    guest_idno text NOT NULL,
    guest_mail text NOT NULL,
    guest_phone text NOT NULL
);
    DROP TABLE public.reservation;
       public         heap    postgres    false            �            1259    16954    room    TABLE       CREATE TABLE public.room (
    room_id integer NOT NULL,
    hotel_name text NOT NULL,
    pension text NOT NULL,
    room_type text NOT NULL,
    season_strt_date date NOT NULL,
    season_fnsh_date date NOT NULL,
    stock integer NOT NULL,
    bed integer NOT NULL,
    metresquare integer NOT NULL,
    prc_adult double precision NOT NULL,
    prc_child double precision NOT NULL,
    air_conditioning boolean NOT NULL,
    minibar boolean NOT NULL,
    tv boolean NOT NULL,
    bcase boolean NOT NULL,
    fridge boolean NOT NULL
);
    DROP TABLE public.room;
       public         heap    postgres    false            �            1259    17100    room_room_id_seq    SEQUENCE     �   CREATE SEQUENCE public.room_room_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.room_room_id_seq;
       public          postgres    false    217            ,           0    0    room_room_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.room_room_id_seq OWNED BY public.room.room_id;
          public          postgres    false    223            �            1259    16948    season    TABLE     �   CREATE TABLE public.season (
    id integer NOT NULL,
    hotel_id integer NOT NULL,
    strt_date date NOT NULL,
    fnsh_date date NOT NULL
);
    DROP TABLE public.season;
       public         heap    postgres    false            �            1259    17007    user    TABLE     �   CREATE TABLE public."user" (
    user_id integer NOT NULL,
    user_name text NOT NULL,
    user_pass text NOT NULL,
    user_role character varying NOT NULL
);
    DROP TABLE public."user";
       public         heap    postgres    false            �            1259    17006    user_user_id_seq    SEQUENCE     �   CREATE SEQUENCE public.user_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.user_user_id_seq;
       public          postgres    false    220            -           0    0    user_user_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.user_user_id_seq OWNED BY public."user".user_id;
          public          postgres    false    219            |           2604    17073    hotel hotel_id    DEFAULT     o   ALTER TABLE ONLY public.hotel ALTER COLUMN hotel_id SET DEFAULT nextval('public.otel_hotel_id_seq'::regclass);
 =   ALTER TABLE public.hotel ALTER COLUMN hotel_id DROP DEFAULT;
       public          postgres    false    221    214            }           2604    17092    pension_type id    DEFAULT     r   ALTER TABLE ONLY public.pension_type ALTER COLUMN id SET DEFAULT nextval('public.pension_type_id_seq'::regclass);
 >   ALTER TABLE public.pension_type ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    222    216            ~           2604    17101    room room_id    DEFAULT     l   ALTER TABLE ONLY public.room ALTER COLUMN room_id SET DEFAULT nextval('public.room_room_id_seq'::regclass);
 ;   ALTER TABLE public.room ALTER COLUMN room_id DROP DEFAULT;
       public          postgres    false    223    217                       2604    17010    user user_id    DEFAULT     n   ALTER TABLE ONLY public."user" ALTER COLUMN user_id SET DEFAULT nextval('public.user_user_id_seq'::regclass);
 =   ALTER TABLE public."user" ALTER COLUMN user_id DROP DEFAULT;
       public          postgres    false    219    220    220                      0    16945    hotel 
   TABLE DATA           �   COPY public.hotel (hotel_id, hotel_name, city, region, address, mail, phone, star, carpark, wifi, pool, fitness, conclerge, spa, room_service) FROM stdin;
    public          postgres    false    214   
,                 0    16951    pension_type 
   TABLE DATA           B   COPY public.pension_type (id, hotel_id, pension_type) FROM stdin;
    public          postgres    false    216   �,                 0    16957    reservation 
   TABLE DATA           �   COPY public.reservation (id, room_id, checkin_date, checkout_date, total_price, guest_count, guest_name, guest_idno, guest_mail, guest_phone) FROM stdin;
    public          postgres    false    218   k-                 0    16954    room 
   TABLE DATA           �   COPY public.room (room_id, hotel_name, pension, room_type, season_strt_date, season_fnsh_date, stock, bed, metresquare, prc_adult, prc_child, air_conditioning, minibar, tv, bcase, fridge) FROM stdin;
    public          postgres    false    217   .                 0    16948    season 
   TABLE DATA           D   COPY public.season (id, hotel_id, strt_date, fnsh_date) FROM stdin;
    public          postgres    false    215   +/                  0    17007    user 
   TABLE DATA           J   COPY public."user" (user_id, user_name, user_pass, user_role) FROM stdin;
    public          postgres    false    220   �/       .           0    0    otel_hotel_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.otel_hotel_id_seq', 10, true);
          public          postgres    false    221            /           0    0    pension_type_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.pension_type_id_seq', 1, false);
          public          postgres    false    222            0           0    0    room_room_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.room_room_id_seq', 1, true);
          public          postgres    false    223            1           0    0    user_user_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.user_user_id_seq', 10, true);
          public          postgres    false    219            �           2606    17080    hotel otel_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.hotel
    ADD CONSTRAINT otel_pkey PRIMARY KEY (hotel_id);
 9   ALTER TABLE ONLY public.hotel DROP CONSTRAINT otel_pkey;
       public            postgres    false    214            �           2606    17099    pension_type pension_type_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.pension_type
    ADD CONSTRAINT pension_type_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.pension_type DROP CONSTRAINT pension_type_pkey;
       public            postgres    false    216            �           2606    17090    reservation reservation_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.reservation DROP CONSTRAINT reservation_pkey;
       public            postgres    false    218            �           2606    17108    room room_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.room
    ADD CONSTRAINT room_pkey PRIMARY KEY (room_id);
 8   ALTER TABLE ONLY public.room DROP CONSTRAINT room_pkey;
       public            postgres    false    217            �           2606    17086    season season_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.season
    ADD CONSTRAINT season_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.season DROP CONSTRAINT season_pkey;
       public            postgres    false    215            �           2606    17012    user user_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (user_id);
 :   ALTER TABLE ONLY public."user" DROP CONSTRAINT user_pkey;
       public            postgres    false    220               �   x�m�1n�0Й:�O$�嶣$p�v�؅�儐,6] �@��k��^�m���@��9T�8x(����������~�t�lz^>���T�Q�����E���}p��];�+�m$�xg����:Ni�c�%�&�wg��N�Oŧ)��Z�x�WCV�`t�qak��"��ؙfB���z�j��r`�ᗖ:�����c9^O��M�3Wo+��/#c�         f   x�3�4�,NLIMNU�L,I��2�4��OIT�N�(K�)9��˘ӂ34��(Q�#�����J��Č�.NK�SNCNǜ����Ģ����Jsr�b���� ��!�         �   x�E�1�0E���Nڱi��B��'h�/�T4?^��d�5t">{{�X2DC��}�v����ڪÉ:�)/p�b�j)���ҍ�ω��0�	⩒U��o�R=1����|@=طu���:�#�i�1~����ʫ�^����5Y           x�m�KN�0����@��G�l�.]�Pر1�CFum)��r���^���`�2����뷀�����e���5d��A�_=:Hx�n�
�+(!�$��sN�i9hǯe;��Ɠ6��@#/�\q�{ֿj�d�e�Ģ��ie �I����񼩭S�O�(�w����ZZ�'-�"��IV�;���4x^i!Λ:��܊&�G�O],�+x�J�������Ȕ��f�toө#����%D�ZR��d��ɦ^nc?�	�G         O   x�E���0�3ޅ�&�f��?G�
��g~�n�(.:g2�ac���N%�"�ݹ�U�FB��ӡ��;����G5<���          ]   x�3�LL����4426�tt����2�!�s��p���[p����G��r��Č�MA��h�� AK4A�5��{�� � Q @���qqq +�)     