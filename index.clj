(ns index
  {:nextjournal.clerk/visibility {:code :hide}}
  (:require common)
  (:require [nextjournal.clerk :as clerk]))

(clerk/html
 (into [:div.md:grid.md:gap-8.md:grid-cols-1.pb-8]
       (map (fn [path] [:a {:href (clerk/doc-url path)} path])
            (common/markdowns))))
