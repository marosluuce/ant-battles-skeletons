(ns ant-battles.symbolizer-spec
  (:require [speclj.core :refer :all]
            [ant-battles.symbolizer :refer :all]
            [clj-json [core :as json]]))

(describe "the symbolizer"
          (it "converts keys to symbols"
              (let [input "{\"status\":\"ok\",\"message\":{\"type\":\"ant\",\"team\":\"Badgers\",\"surroundings\":{\"w\":[],\"sw\":[],\"se\":[],\"s\":[{\"foo\": 1}],\"nw\":[],\"ne\":[],\"n\":[],\"e\":[]},\"nest\":146,\"location\":[0,0],\"id\":14,\"got_food\":true}}]"                    converted (symbolize(json/parse-string input))]
                (do
                  (should= "ant" (get-in converted [:message :type]))
                  (should= 1 (get-in converted [:message :surroundings :s 0 :foo]))))))
