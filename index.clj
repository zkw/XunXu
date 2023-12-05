(ns index
  (:require [common]
            [nextjournal.clerk :as clerk]))

(clerk/md "## 张昆玮的小站\n\n# USACO 解题练习\n\n")

(clerk/html
 (list [:h2 "铜组"]
       (into [:ul.m-0]
             (for [path (common/markdowns)]
               [:li [:a {:href (clerk/doc-url path)} path]]))))
