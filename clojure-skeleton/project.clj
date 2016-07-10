(defproject clojure-skeleton "0.1.0-SNAPSHOT"
  :description "A very basic client for the ant-battles"
  :dependencies [
                 [org.clojure/clojure "1.8.0"]
                 [clj-http "2.2.0"]
                 [clj-json "0.5.3"]
                 ]
  :target-path "target/%s"
  :plugins [[speclj  "3.3.0"]]
  :test-paths ["spec"]
  :profiles {:uberjar {:aot :all}
             :dev {:dependencies [[speclj "3.3.0"]]}})
