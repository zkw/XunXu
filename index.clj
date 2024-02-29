^{:nextjournal.clerk/visibility #{:hide-ns}}
(ns index
  (:require [common]
            [nextjournal.clerk :as clerk]))
{::clerk/visibility {:code :hide}}
(clerk/html [:style (slurp "common.css")])

(clerk/md "# 《循序渐进信息学竞赛》系列课程\n\n")

^{::clerk/no-cache true}
(clerk/html
 (list [:h2 "目录"]
       (into [:ul.m-0]
             (for [path (common/markdowns)]
               [:li [:a {:href (clerk/doc-url path)} path]]))))
