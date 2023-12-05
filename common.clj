(ns common
  (:require [clojure.java.io :as io]
            [clojure.string :as string]
            [nextjournal.clerk :as clerk])
  (:import java.io.File))

(defn markdowns []
  (sort (for [file (file-seq (File. "."))
              :let [name (.getName file)]
              :when (string/ends-with? name ".md")]
          (subs name 0 (- (count name) 3)))))

(defn build [] (into ["index.clj"] (for [markdown (markdowns)] (str markdown ".md"))))

(defn code [language name begin end]
  (let [content (line-seq (io/reader (str name \. language)))
        content (take (- end begin) (drop (dec begin) content))
        content (string/join "\n" content)
        content (str content "\n\n/*------  ↑↑ " name "." language " [" begin "-" end "] ↑↑  ------*/")]
    (clerk/code {::clerk/render-opts {:language language}} content)))
