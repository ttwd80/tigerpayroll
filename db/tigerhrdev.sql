ALTER TABLE IF EXISTS ONLY "public"."user_role" DROP CONSTRAINT IF EXISTS "user_role_username_fkey";
ALTER TABLE IF EXISTS ONLY "public"."user_role" DROP CONSTRAINT IF EXISTS "user_role_role_id_fkey";
ALTER TABLE IF EXISTS ONLY "public"."user_role" DROP CONSTRAINT IF EXISTS "user_role_last_modified_by_fkey";
ALTER TABLE IF EXISTS ONLY "public"."user" DROP CONSTRAINT IF EXISTS "user_last_modified_by_fkey";
ALTER TABLE IF EXISTS ONLY "public"."user" DROP CONSTRAINT IF EXISTS "user_image_id_fkey";
ALTER TABLE IF EXISTS ONLY "public"."user" DROP CONSTRAINT IF EXISTS "user_created_by_fkey";
ALTER TABLE IF EXISTS ONLY "public"."role" DROP CONSTRAINT IF EXISTS "role_last_modified_by_fkey";
ALTER TABLE IF EXISTS ONLY "public"."role" DROP CONSTRAINT IF EXISTS "role_created_by_fkey";
ALTER TABLE IF EXISTS ONLY "public"."image" DROP CONSTRAINT IF EXISTS "image_last_modified_by_fkey";
ALTER TABLE IF EXISTS ONLY "public"."image" DROP CONSTRAINT IF EXISTS "image_created_by_fkey";
ALTER TABLE IF EXISTS ONLY "public"."user_role" DROP CONSTRAINT IF EXISTS "user_role_username_role_id_key";
ALTER TABLE IF EXISTS ONLY "public"."user_role" DROP CONSTRAINT IF EXISTS "user_role_pkey";
ALTER TABLE IF EXISTS ONLY "public"."user" DROP CONSTRAINT IF EXISTS "user_pkey";
ALTER TABLE IF EXISTS ONLY "public"."role" DROP CONSTRAINT IF EXISTS "role_pkey";
ALTER TABLE IF EXISTS ONLY "public"."image" DROP CONSTRAINT IF EXISTS "image_pkey";
ALTER TABLE IF EXISTS "public"."user_role" ALTER COLUMN "id" DROP DEFAULT;
ALTER TABLE IF EXISTS "public"."image" ALTER COLUMN "id" DROP DEFAULT;
DROP SEQUENCE IF EXISTS "public"."user_role_id_seq";
DROP TABLE IF EXISTS "public"."user_role";
DROP TABLE IF EXISTS "public"."user";
DROP TABLE IF EXISTS "public"."role";
DROP SEQUENCE IF EXISTS "public"."image_id_seq";
DROP TABLE IF EXISTS "public"."image";
DROP SCHEMA IF EXISTS "public";
CREATE SCHEMA "public";
COMMENT ON SCHEMA "public" IS 'standard public schema';
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
CREATE TABLE "role" (
    "id" character varying(20) NOT NULL,
    "created_by" character varying(20),
    "last_modified_by" character varying(20),
    "created_date" timestamp with time zone,
    "last_modified_date" timestamp with time zone
);
CREATE TABLE "user" (
    "username" character varying(20) NOT NULL,
    "password" character(60) NOT NULL,
    "locked" boolean NOT NULL,
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
ALTER TABLE ONLY "image"
    ADD CONSTRAINT "image_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "role"
    ADD CONSTRAINT "role_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "user"
    ADD CONSTRAINT "user_pkey" PRIMARY KEY ("username");
ALTER TABLE ONLY "user_role"
    ADD CONSTRAINT "user_role_pkey" PRIMARY KEY ("id");
ALTER TABLE ONLY "user_role"
    ADD CONSTRAINT "user_role_username_role_id_key" UNIQUE ("username", "role_id");
ALTER TABLE ONLY "image"
    ADD CONSTRAINT "image_created_by_fkey" FOREIGN KEY ("created_by") REFERENCES "user"("username") ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE ONLY "image"
    ADD CONSTRAINT "image_last_modified_by_fkey" FOREIGN KEY ("last_modified_by") REFERENCES "user"("username") ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE ONLY "role"
    ADD CONSTRAINT "role_created_by_fkey" FOREIGN KEY ("created_by") REFERENCES "user"("username") ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE ONLY "role"
    ADD CONSTRAINT "role_last_modified_by_fkey" FOREIGN KEY ("last_modified_by") REFERENCES "user"("username") ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE ONLY "user"
    ADD CONSTRAINT "user_created_by_fkey" FOREIGN KEY ("created_by") REFERENCES "user"("username") ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE ONLY "user"
    ADD CONSTRAINT "user_image_id_fkey" FOREIGN KEY ("image_id") REFERENCES "image"("id");
ALTER TABLE ONLY "user"
    ADD CONSTRAINT "user_last_modified_by_fkey" FOREIGN KEY ("last_modified_by") REFERENCES "user"("username") ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE ONLY "user_role"
    ADD CONSTRAINT "user_role_last_modified_by_fkey" FOREIGN KEY ("last_modified_by") REFERENCES "user"("username") ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE ONLY "user_role"
    ADD CONSTRAINT "user_role_role_id_fkey" FOREIGN KEY ("role_id") REFERENCES "role"("id");
ALTER TABLE ONLY "user_role"
    ADD CONSTRAINT "user_role_username_fkey" FOREIGN KEY ("username") REFERENCES "user"("username");