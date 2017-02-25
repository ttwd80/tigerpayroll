ALTER TABLE IF EXISTS ONLY "public"."user" DROP CONSTRAINT IF EXISTS "user_socso_status_id_fkey";
ALTER TABLE IF EXISTS ONLY "public"."user_role" DROP CONSTRAINT IF EXISTS "user_role_username_fkey";
ALTER TABLE IF EXISTS ONLY "public"."user_role" DROP CONSTRAINT IF EXISTS "user_role_role_id_fkey";
ALTER TABLE IF EXISTS ONLY "public"."user_role" DROP CONSTRAINT IF EXISTS "user_role_last_modified_by_fkey";
ALTER TABLE IF EXISTS ONLY "public"."user" DROP CONSTRAINT IF EXISTS "user_race_id_fkey";
ALTER TABLE IF EXISTS ONLY "public"."user" DROP CONSTRAINT IF EXISTS "user_marital_status_id_fkey";
ALTER TABLE IF EXISTS ONLY "public"."user" DROP CONSTRAINT IF EXISTS "user_last_modified_by_fkey";
ALTER TABLE IF EXISTS ONLY "public"."user" DROP CONSTRAINT IF EXISTS "user_image_id_fkey";
ALTER TABLE IF EXISTS ONLY "public"."user" DROP CONSTRAINT IF EXISTS "user_gender_id_fkey";
ALTER TABLE IF EXISTS ONLY "public"."user" DROP CONSTRAINT IF EXISTS "user_department_id_fkey";
ALTER TABLE IF EXISTS ONLY "public"."user" DROP CONSTRAINT IF EXISTS "user_created_by_fkey";
ALTER TABLE IF EXISTS ONLY "public"."role" DROP CONSTRAINT IF EXISTS "role_last_modified_by_fkey";
ALTER TABLE IF EXISTS ONLY "public"."role" DROP CONSTRAINT IF EXISTS "role_created_by_fkey";
ALTER TABLE IF EXISTS ONLY "public"."image" DROP CONSTRAINT IF EXISTS "image_last_modified_by_fkey";
ALTER TABLE IF EXISTS ONLY "public"."image" DROP CONSTRAINT IF EXISTS "image_created_by_fkey";
DROP INDEX IF EXISTS "public"."fki_user_socso_status_id_fkey";
DROP INDEX IF EXISTS "public"."fki_user_race_id_fkey";
DROP INDEX IF EXISTS "public"."fki_user_marital_status_id_fkey";
DROP INDEX IF EXISTS "public"."fki_user_gender_id_fkey";
ALTER TABLE IF EXISTS ONLY "public"."user_role" DROP CONSTRAINT IF EXISTS "user_role_username_role_id_key";
ALTER TABLE IF EXISTS ONLY "public"."user_role" DROP CONSTRAINT IF EXISTS "user_role_pkey";
ALTER TABLE IF EXISTS ONLY "public"."user" DROP CONSTRAINT IF EXISTS "user_pkey";
ALTER TABLE IF EXISTS ONLY "public"."socso_status" DROP CONSTRAINT IF EXISTS "socso_status_pkey";
ALTER TABLE IF EXISTS ONLY "public"."role" DROP CONSTRAINT IF EXISTS "role_pkey";
ALTER TABLE IF EXISTS ONLY "public"."race" DROP CONSTRAINT IF EXISTS "race_pkey";
ALTER TABLE IF EXISTS ONLY "public"."marital_status" DROP CONSTRAINT IF EXISTS "marital_status_pkey";
ALTER TABLE IF EXISTS ONLY "public"."image" DROP CONSTRAINT IF EXISTS "image_pkey";
ALTER TABLE IF EXISTS ONLY "public"."gender" DROP CONSTRAINT IF EXISTS "gender_pkey";
ALTER TABLE IF EXISTS ONLY "public"."department" DROP CONSTRAINT IF EXISTS "department_pkey";
ALTER TABLE IF EXISTS "public"."user_role" ALTER COLUMN "id" DROP DEFAULT;
ALTER TABLE IF EXISTS "public"."image" ALTER COLUMN "id" DROP DEFAULT;
DROP SEQUENCE IF EXISTS "public"."user_role_id_seq";
DROP TABLE IF EXISTS "public"."user_role";
DROP TABLE IF EXISTS "public"."user";
DROP TABLE IF EXISTS "public"."socso_status";
DROP TABLE IF EXISTS "public"."role";
DROP TABLE IF EXISTS "public"."race";
DROP TABLE IF EXISTS "public"."marital_status";
DROP SEQUENCE IF EXISTS "public"."image_id_seq";
DROP TABLE IF EXISTS "public"."image";
DROP TABLE IF EXISTS "public"."gender";
DROP TABLE IF EXISTS "public"."department";
DROP SCHEMA IF EXISTS "public";
CREATE SCHEMA "public";
COMMENT ON SCHEMA "public" IS 'standard public schema';
CREATE TABLE "department" (
    "id" character(10) NOT NULL,
    "name" character varying(20) NOT NULL,
    "created_by" character varying(20),
    "last_modified_by" character varying(20),
    "created_date" timestamp with time zone,
    "last_modified_date" timestamp with time zone
);
CREATE TABLE "gender" (
    "id" character(1) NOT NULL,
    "name" character varying(20) NOT NULL,
    "created_by" character varying(20),
    "last_modified_by" character varying(20),
    "created_date" timestamp with time zone,
    "last_modified_date" timestamp with time zone
);
CREATE TABLE "image" (
    "id" integer NOT NULL,
    "image" "bytea" NOT NULL,
    "created_by" character varying(20),
    "last_modified_by" character varying(20),
    "created_date" timestamp with time zone,
    "last_modified_date" timestamp with time zone
);
CREATE SEQUENCE "image_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER SEQUENCE "image_id_seq" OWNED BY "image"."id";
CREATE TABLE "marital_status" (
    "id" character(1) NOT NULL,
    "name" character varying(20) NOT NULL,
    "created_by" character varying(20),
    "last_modified_by" character varying(20),
    "created_date" timestamp with time zone,
    "last_modified_date" timestamp with time zone
);
CREATE TABLE "race" (
    "id" character(1) NOT NULL,
    "name" character varying(20) NOT NULL,
    "created_by" character varying(20),
    "last_modified_by" character varying(20),
    "created_date" timestamp with time zone,
    "last_modified_date" timestamp with time zone
);
CREATE TABLE "role" (
    "id" character varying(20) NOT NULL,
    "created_by" character varying(20),
    "last_modified_by" character varying(20),
    "created_date" timestamp with time zone,
    "last_modified_date" timestamp with time zone
);
CREATE TABLE "socso_status" (
    "id" character(1) NOT NULL,
    "label" character varying(100) NOT NULL,
    "note" character varying(100),
    "created_by" character varying(20),
    "last_modified_by" character varying(20),
    "created_date" timestamp with time zone,
    "last_modified_date" timestamp with time zone
);
CREATE TABLE "user" (
    "username" character varying(20) NOT NULL,
    "full_name" character varying(100) NOT NULL,
    "password" character(60) NOT NULL,
    "locked" boolean NOT NULL,
    "department_id" character(10),
    "address" "text",
    "phone_cell" character varying(20),
    "phone_office" character varying(20),
    "race_id" character(1),
    "gender_id" character(1),
    "data_of_birth" "date",
    "marital_status_id" character(1),
    "data_joined" "date",
    "job_title" character varying(100),
    "qualification_academic" character varying(100),
    "qualification_professional" character varying(100),
    "socso_no" character varying(20),
    "socso_status_id" character(1),
    "epf_no" character varying(20),
    "income_tax_no" character varying(20),
    "basic_salary" numeric(16,2) NOT NULL,
    "image_id" integer,
    "created_by" character varying(20),
    "last_modified_by" character varying(20),
    "created_date" timestamp with time zone,
    "last_modified_date" timestamp with time zone
);
CREATE TABLE "user_role" (
    "id" integer NOT NULL,
    "username" character varying(20) NOT NULL,
    "role_id" character varying(20) NOT NULL,
    "created_by" character varying(20),
    "last_modified_by" character varying(20),
    "created_date" timestamp with time zone,
    "last_modified_date" timestamp with time zone
);
CREATE SEQUENCE "user_role_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER SEQUENCE "user_role_id_seq" OWNED BY "user_role"."id";
ALTER TABLE ONLY "image" ALTER COLUMN "id" SET DEFAULT "nextval"('"image_id_seq"'::"regclass");
ALTER TABLE ONLY "user_role" ALTER COLUMN "id" SET DEFAULT "nextval"('"user_role_id_seq"'::"regclass");
ALTER TABLE ONLY "department"
    ADD CONSTRAINT "department_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "gender"
    ADD CONSTRAINT "gender_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "image"
    ADD CONSTRAINT "image_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "marital_status"
    ADD CONSTRAINT "marital_status_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "race"
    ADD CONSTRAINT "race_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "role"
    ADD CONSTRAINT "role_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "socso_status"
    ADD CONSTRAINT "socso_status_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "user"
    ADD CONSTRAINT "user_pkey" PRIMARY KEY ("username");
ALTER TABLE ONLY "user_role"
    ADD CONSTRAINT "user_role_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "user_role"
    ADD CONSTRAINT "user_role_username_role_id_key" UNIQUE ("username", "role_id");
CREATE INDEX "fki_user_gender_id_fkey" ON "user" USING "btree" ("gender_id");
CREATE INDEX "fki_user_marital_status_id_fkey" ON "user" USING "btree" ("marital_status_id");
CREATE INDEX "fki_user_race_id_fkey" ON "user" USING "btree" ("race_id");
CREATE INDEX "fki_user_socso_status_id_fkey" ON "user" USING "btree" ("socso_status_id");
ALTER TABLE ONLY "image"
    ADD CONSTRAINT "image_created_by_fkey" FOREIGN KEY ("created_by") REFERENCES "user"("username") ON UPDATE RESTRICT ON DELETE RESTRICT;
ALTER TABLE ONLY "image"
    ADD CONSTRAINT "image_last_modified_by_fkey" FOREIGN KEY ("last_modified_by") REFERENCES "user"("username") ON UPDATE RESTRICT ON DELETE RESTRICT;
ALTER TABLE ONLY "role"
    ADD CONSTRAINT "role_created_by_fkey" FOREIGN KEY ("created_by") REFERENCES "user"("username") ON UPDATE RESTRICT ON DELETE RESTRICT;
ALTER TABLE ONLY "role"
    ADD CONSTRAINT "role_last_modified_by_fkey" FOREIGN KEY ("last_modified_by") REFERENCES "user"("username") ON UPDATE RESTRICT ON DELETE RESTRICT;
ALTER TABLE ONLY "user"
    ADD CONSTRAINT "user_created_by_fkey" FOREIGN KEY ("created_by") REFERENCES "user"("username") ON UPDATE RESTRICT ON DELETE RESTRICT;
ALTER TABLE ONLY "user"
    ADD CONSTRAINT "user_department_id_fkey" FOREIGN KEY ("department_id") REFERENCES "department"("id") ON UPDATE RESTRICT ON DELETE RESTRICT;
ALTER TABLE ONLY "user"
    ADD CONSTRAINT "user_gender_id_fkey" FOREIGN KEY ("gender_id") REFERENCES "gender"("id") ON UPDATE RESTRICT ON DELETE RESTRICT;
ALTER TABLE ONLY "user"
    ADD CONSTRAINT "user_image_id_fkey" FOREIGN KEY ("image_id") REFERENCES "image"("id");
ALTER TABLE ONLY "user"
    ADD CONSTRAINT "user_last_modified_by_fkey" FOREIGN KEY ("last_modified_by") REFERENCES "user"("username") ON UPDATE RESTRICT ON DELETE RESTRICT;
ALTER TABLE ONLY "user"
    ADD CONSTRAINT "user_marital_status_id_fkey" FOREIGN KEY ("marital_status_id") REFERENCES "marital_status"("id");
ALTER TABLE ONLY "user"
    ADD CONSTRAINT "user_race_id_fkey" FOREIGN KEY ("race_id") REFERENCES "race"("id") ON UPDATE RESTRICT ON DELETE RESTRICT;
ALTER TABLE ONLY "user_role"
    ADD CONSTRAINT "user_role_last_modified_by_fkey" FOREIGN KEY ("last_modified_by") REFERENCES "user"("username") ON UPDATE RESTRICT ON DELETE RESTRICT;
ALTER TABLE ONLY "user_role"
    ADD CONSTRAINT "user_role_role_id_fkey" FOREIGN KEY ("role_id") REFERENCES "role"("id");
ALTER TABLE ONLY "user_role"
    ADD CONSTRAINT "user_role_username_fkey" FOREIGN KEY ("username") REFERENCES "user"("username");
ALTER TABLE ONLY "user"
    ADD CONSTRAINT "user_socso_status_id_fkey" FOREIGN KEY ("socso_status_id") REFERENCES "socso_status"("id") ON UPDATE RESTRICT ON DELETE RESTRICT;
