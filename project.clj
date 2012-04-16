(defproject lein-iclojure "1.1-SNAPSHOT"
  :dependencies [[com.offbytwo.iclojure/iclojure "1.1.0" :exclusions [org.clojure/clojure]]]
  :dev-dependencies [[org.clojure/clojure "1.4.0"]
                     [lein-clojars "0.6.0"]]
  :description "Launch an IClojure REPL"
  :eval-in-leiningen true)
