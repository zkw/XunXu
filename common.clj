(ns common
  (:require [clojure.string])
  (:import java.io.File))

(defn markdowns []
  (let [files (file-seq (File. "."))]
    (map #(clojure.string/replace % #"\.md$" "")
         (filter #(clojure.string/ends-with? % ".md")
                 (map #(.getName %) files)))))

(defn build [] (conj (map #(str % ".md") (markdowns)) "index.clj"))
