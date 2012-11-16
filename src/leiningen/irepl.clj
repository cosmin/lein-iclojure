(ns leiningen.irepl
  (:require [leiningen.trampoline :as lt]))

(def start-iclojure-form `(com.offbytwo.iclojure.Main/main (into-array String [])))

(defn ^:no-project-needed irepl
  "Start an IClojure REPL session either with the current project or standalone."
  ([] (irepl nil))
  ([project]
     (if (or (empty? project) (= :leiningen (:eval-in project)))
       (eval start-iclojure-form)
       (if lt/*trampoline?*
         (let [[eip two?] (or (try (require 'leiningen.core.eval)
                                   [(resolve 'leiningen.core.eval/eval-in-project)
                                    true]
                                   (catch java.io.FileNotFoundException _))
                              (try (require 'leiningen.compile)
                                   [(resolve 'leiningen.compile/eval-in-project)]
                                   (catch java.io.FileNotFoundException _)))]
           (eip (update-in project [:dependencies]
                           conj ['com.offbytwo.iclojure/iclojure "1.1.1"])
                start-iclojure-form))
         (println "To use irepl with a project run:\n\nlein trampoline irepl")))))
