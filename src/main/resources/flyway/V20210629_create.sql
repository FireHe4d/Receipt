CREATE TABLE nation (
                        nation_id Serial Primary key,
                        nation_name varchar,
                        country varchar,
                        description text);
CREATE TABLE type_recept (
                             type_id Serial Primary key,
                             type_name varchar,
                             description text);

CREATE TABLE ingredient (
                            id Serial Primary key,
                            name varchar);
CREATE TABLE company (
                         company_id Serial Primary key,
                         company_name varchar,
                         contact text,
                         email text,
                         website text);


CREATE TABLE login (
                       login_id Serial Primary key,
                       login_name varchar,
                       login_surname varchar,
                       email text,
                       pass text);
CREATE TABLE recept (
                        recept_id Serial Primary key,
                        recept_name varchar,
                        nation_id int,
                        type_id int,
                        isvegan boolean,
                        isvegetarian boolean,
                        photo bytea,
                        video bytea,
                        ingredient int[],
                        level_id smallint,
                        recept_view int,
                        company_id int,
                        FOREIGN KEY (nation_id) REFERENCES nation(nation_id),
                        FOREIGN KEY (type_id) REFERENCES type_recept(type_id),
                        FOREIGN KEY (company_id) REFERENCES company(company_id)
);
CREATE TABLE tried (
                       tried_id Serial Primary key,
                       recept_id int,
                       login_id int,
                       FOREIGN KEY (recept_id) REFERENCES recept(recept_id),
                       FOREIGN KEY (login_id) REFERENCES login(login_id));
CREATE TABLE remember (
                          remember_id Serial Primary key,
                          recept_id int,
                          login_id int,
                          FOREIGN KEY (recept_id) REFERENCES recept(recept_id),
                          FOREIGN KEY (login_id) REFERENCES login(login_id));
CREATE TABLE favorite (
                          favorite_id Serial Primary key,
                          recept_id int,
                          login_id int,
                          FOREIGN KEY (recept_id) REFERENCES recept(recept_id),
                          FOREIGN KEY (login_id) REFERENCES login(login_id));
CREATE TABLE rating (
                        rating_id Serial Primary key,
                        recept_id int,
                        login_id int,
                        rating smallint,
                        aver_rating float,
                        FOREIGN KEY (recept_id) REFERENCES recept(recept_id),
                        FOREIGN KEY (login_id) REFERENCES login(login_id));
