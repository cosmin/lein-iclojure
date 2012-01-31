(ns leiningen.irepl
  (:require [leiningen.compile :as lc]
            [leiningen.trampoline :as lt]))

(def start-iclojure-form `(com.offbytwo.iclojure.Main/main (into-array String [])))

(defn irepl
  "Start an IClojure REPL session either with the current project or standalone."
  ([] (irepl nil))
  ([project]
     (if (or (empty? project) (= :leiningen (:eval-in project)))
       (eval start-iclojure-form)
       (if lt/*trampoline?*
         (lc/eval-in-project project start-iclojure-form)
         (println "To use irepl with a project run:\n\nlein trampoline irepl")
         ))))
