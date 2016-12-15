; jdbc
(ns clojure-crumbs.clj-05
  (:require [clojure.java.jdbc :as db]))

; =================
; Clojure Java JDBC
; =================

; low-level functional wrapper around java.jdbc Java package

; define DB connection properties
(def db-spec
  {:classname      "org.h2.Driver"
   :connection-uri "jdbc:h2:file:./target/db/sample;AUTO_SERVER=TRUE;DB_CLOSE_ON_EXIT=FALSE"
   :user           "sa"
   :password       ""})
;    ;TRACE_LEVEL_SYSTEM_OUT=2

; execute DDL commands
(db/db-do-commands
  db-spec
  "drop table if exists customer")

(db/db-do-commands
  db-spec
  "create table if not exists customer (
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    age integer)")


; execute DML commands and queries

; with-db-connection: opens and closes connection for statements within, txn not created
; with-db-transaction: opens and closes txn
(db/with-db-connection
  [con db-spec]
  (db/delete! con :customer [])
  (db/insert! con :customer {:first_name "Luke", :last_name "Skywalker" :age 29})
  (db/insert! con :customer {:first_name "Leia", :last_name "Organa"})
  (db/insert! con :customer {:first_name "Darth", :last_name "Vader" :age 25})
  (db/query con ["SELECT * FROM customer"]))

(db/with-db-transaction
  [con db-spec]
  (db/update! con :customer {:age 59} ["last_name = ?" "Vader"])
  (db/query con ["SELECT * FROM customer where last_name = ?" "Vader"]))

(db/with-db-transaction
  [con db-spec]
  (db/delete! con :customer ["last_name = ?" "Organa"])
  (db/query con ["SELECT * FROM customer"]))


;
