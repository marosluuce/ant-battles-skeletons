(ns ant-battles.core
  (:require [ant-battles.symbolizer :as sym]
            [clj-http.client :as client]
            [clj-json [core :as json]]))

(defn- from-json [data]
  (sym/symbolize (json/parse-string data)))

(defn- read-json [url]
  (from-json
    (get (client/get url) :body)))

(defn index [base]
  (get (client/get (str base "/")) :status))

(defn join [base team]
  (read-json (str base "/join/" team)))

(defn leave [base id]
  (read-json (str base "/" id "/leave")))

(defn spawn-ant-for [base id]
  (read-json (str base "/" id "/spawn")))

(defn move-ant [base ant direction]
  (read-json (str base "/" ant "/move/" direction)))
