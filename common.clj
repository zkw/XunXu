(ns common
  (:require [clojure.string :as string])
  (:import java.io.File))

(defn markdowns []
  (sort (for [file (file-seq (File. "."))
              :let [name (.getName file)]
              :when (string/ends-with? name ".md")]
          (subs name 0 (- (count name) 3)))))

(defn build [] (into ["index.clj"] (for [markdown (markdowns)] (str markdown ".md"))))
