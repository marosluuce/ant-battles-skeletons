(ns ant-battles.core-spec
  (:require [speclj.core :refer :all]
            [ant-battles.core :refer :all]))

(defn- get-id [data]
  (get-in data [:message :id]))

(describe "the client"
          (it "hits the index page"
              (should (= 200 (index "http://localhost:4000"))))

          (it "can join and leave again"
             (let [id (get-id (join "http://localhost:4000" "dolphins"))]
                (should= id (get-in (leave "http://localhost:4000" id) [:message :removed]))))

          (it "can spawn an ant"
              (let [id (get-id (join "http://localhost:4000" "dolphins"))]
                (do
                  (should-not (get-in (spawn-ant-for "http://localhost:4000" id) [:message :got_food]))
                  (leave "http://localhost:4000" id))))

          (it "can move an ant"
              (let [nest_id (get-id (join "http://localhost:4000" "dolphins"))
                    ant_id (get-id (spawn-ant-for "http://localhost:4000" nest_id))]
                    (do
                      (should= [0 1] (get-in (move-ant "http://localhost:4000" ant_id "n") [:message :location]))
                      (leave "http://localhost:4000" nest_id)))))
(run-specs)
