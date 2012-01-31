0;95;c
(defproject lein-iclojure "1.0.0-SNAPSHOT"
  :dependencies [[com.offbytwo.iclojure/iclojure "1.0.2-SNAPSHOT" :exclusions [org.clojure/clojure]]]
  :dev-dependencies [[org.clojure/clojure "1.3.0"]]
  :description "Launch an IClojure REPL"
  :eval-in-leiningen true
  )
