(ns common
  (:require [clojure.string])
  (:require [nextjournal.clerk :as clerk])
  (:import java.io.File))

(defn markdowns []
  (let [files (file-seq (File. "."))]
    (sort (map #(clojure.string/replace % #"\.md$" "")
               (filter #(clojure.string/ends-with? % ".md")
                       (map #(.getName %) files))))))

(defn build [] (conj (map #(str % ".md") (markdowns)) "index.clj"))

(defn whole-code [name]
  (let [pattern (re-pattern (str "(?s)" "\\`\\`\\`cpp(.*?)\\`\\`\\`"))
        content (slurp name)
        content (apply str (map second (re-seq pattern content)))]
    (clerk/code {:nextjournal.clerk/render-opts {:language "cpp"}} content)))
